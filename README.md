# spring-boot-tutorial

For Stored Proc
DELIMITER ;


CREATE PROCEDURE GetTotalEmpCount (
    IN  empid bigint,
    OUT name varchar(255)
)
BEGIN
    SELECT name
    INTO name
    FROM ds.employee
    WHERE empid = empid;
END$$
 
DELIMITER ;

Creating 2nd SP.
DELIMITER //
 
CREATE PROCEDURE GetAllEmployee()
BEGIN
    SELECT *  FROM ds.employee;
END //


INSERT INTO employee (empid, company_name, name)
VALUES (1, 'adobe', 'adit');
INSERT INTO employee (empid, company_name, name)
VALUES (2, 'microsoft', 'ankit');
INSERT INTO employee (empid, company_name, name)
VALUES (3, 'google', 'shivam');
