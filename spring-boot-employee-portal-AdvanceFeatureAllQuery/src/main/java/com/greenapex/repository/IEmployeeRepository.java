package com.greenapex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greenapex.dto.EmloyeeDepartmentData;
import com.greenapex.dto.EmployeeMoreTheanOneProjectData;
import com.greenapex.dto.EmployeeRespectiveManagerName;
import com.greenapex.dto.HighestSalaryEmployeeDetail;
import com.greenapex.entity.EmployeeEntity;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	
	@Query("select new com.greenapex.dto.HighestSalaryEmployeeDetail(e.empId,e.empName,e.empAddress,e.managerId,e.empRole,e.empSalary,e.department.deptId) "
			+ "from EmployeeEntity e where (e.department.deptId,e.empSalary) IN(Select e.department.deptId,max(e.empSalary) "
			+ "FROM EmployeeEntity e JOIN DepartmentEntity d ON e.department.deptId = d.deptId group by d.deptId)")
	public List<HighestSalaryEmployeeDetail> highestSaleryDeptjoin();
	
	@Query("select new com.greenapex.dto.EmployeeRespectiveManagerName(e1.empName as employees, e2.empName as managers) from EmployeeEntity e1, EmployeeEntity e2\r\n"
			+ "Where e1.managerId=e2.empId")
	public List<EmployeeRespectiveManagerName> EmployeeManagerDetail();
	
	@Query("Select new com.greenapex.dto.EmloyeeDepartmentData(e.empId,e.empName,e.empAddress, e.managerId, e.empRole, e.empSalary,d.deptId,d.deptName, d.deptLocation) FROM EmployeeEntity e JOIN "
			+ "DepartmentEntity d ON e.department.deptId = d.deptId")
	public List<EmloyeeDepartmentData> ShowEmpDeptTableData();
	
	@Query("select new com.greenapex.dto.EmployeeMoreTheanOneProjectData(e.empName, p.projectName, p.projectId) from EmployeeEntity e, ProjectEntity p where e.empId=p.employee.empId and e.empId "
			+ "IN (select p.employee.empId from ProjectEntity p group by 1 having count(*) >1)")
	public List<EmployeeMoreTheanOneProjectData> ShowEmpDetailMoreThanOnePro();
}

