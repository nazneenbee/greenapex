package com.greenapex.service;

import java.util.List;
import java.util.Optional;

import com.greenapex.Exception.URLNotProperException;
import com.greenapex.dto.EmloyeeDepartmentData;
import com.greenapex.dto.EmployeeMoreTheanOneProjectData;
import com.greenapex.dto.EmployeeRespectiveManagerName;
import com.greenapex.dto.HighestSalaryEmployeeDetail;
import com.greenapex.entity.EmployeeEntity;

public interface IEmployeeService {
	public EmployeeEntity saveEmployee(EmployeeEntity employee);
	public List<EmployeeEntity> showEmployeeData();
	public Optional<EmployeeEntity> getEmployeeById(Integer Id);
	public Boolean deleteEmployeeDataById(Integer Id);
	public EmployeeEntity updateEmployee(EmployeeEntity employee);
	
	public List<HighestSalaryEmployeeDetail> MaxSalaryDept();
	
	public List<EmployeeRespectiveManagerName> ShowEmployeeNameManagerNameDetail();
	
	public List<EmloyeeDepartmentData> ShowEmpDeptTData();
	
	//public List<EmployeeMoreTheanOneProjectData> ShowEmpDetailMoreThanOneProject();
}
