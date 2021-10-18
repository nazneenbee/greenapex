CREATE TABLE  E_BOOK 
   (	CALLNO VARCHAR(500), 
	NAME VARCHAR(500), 
	AUTHOR VARCHAR(500), 
	PUBLISHER VARCHAR(500), 
	QUANTITY INT, 
	ISSUED INT, 
	 CONSTRAINT E_BOOK_PK PRIMARY KEY (CALLNO)
   )
;
CREATE TABLE  E_LIBRARIAN 
   (	ID INT AUTO_INCREMENT, 
	NAME VARCHAR(500), 
	PASSWORD VARCHAR(500), 
	EMAIL VARCHAR(500), 
	MOBILE BIGINT , 
	 CONSTRAINT E_LIBRARIAN_PK PRIMARY KEY (ID)
   )
;

-- Note: ID must be generated through sequence in E_LIBRARIAN table.

CREATE TABLE  E_ISSUEBOOK 
   (	CALLNO VARCHAR(500) NOT NULL, 
	STUDENTID VARCHAR(500) NOT NULL, 
	STUDENTNAME VARCHAR(500), 
	STUDENTMOBILE INT, 
	ISSUEDDATE DATE, 
	RETURNSTATUS VARCHAR(500)
   )
;
