CREATE DATABASE Employee;
USE Employee;
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(255),
    salary DECIMAL(10, 2),
    start_date DATE,
    department_id INT
);

CREATE TABLE access_rights (
    access_id INT PRIMARY KEY,
    employee_id INT,
    access_level VARCHAR(255),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(255)
);

INSERT INTO employees (employee_id, employee_name, salary, start_date, department_id)
VALUES
    (1, 'John Doe', 60000, '2021-01-15', 1),
    (2, 'Jane Smith', 70000, '2020-05-20', 2),
    (3, 'Bob Johnson', 55000, '2022-03-10', 1),
    (4, 'Alice Williams', 80000, '2021-08-05', 3),
    (5, 'Charlie Brown', 65000, '2020-12-01', 2),
    (6, 'John Cena', 100000, '2023-11-15', NULL);
INSERT INTO departments (department_id, department_name)
VALUES
    (1, 'IT'),
    (2, 'Sales'),
    (3, 'HR'),
	(4, 'MK');
INSERT INTO access_rights (access_id, employee_id, access_level)
VALUES
    (1, 1, 'Admin'),
    (2, 2, 'User'),
    (3, 3, 'User'),
    (4, 4, 'Admin'),
    (5, 5, 'User'),
    (6, 6, NULL);

-- 1
  SELECT *
  FROM employees e;
   
-- 2
  SELECT employee_name, salary
  FROM employees e;
 
-- 3
  SELECT *
  FROM employees e 
  WHERE salary > 50000;
 
 -- 4
  SELECT d.department_id, d.department_name, COUNT(e.employee_id) AS employee_sl
  FROM employees e
  LEFT JOIN departments d ON d.department_id = e.department_id
  GROUP BY d.department_id, d.department_name;
 
 -- 5
  SELECT employee_name
  FROM employees e 
  ORDER BY employee_name ASC;
 
 -- 6
  SELECT employee_name, salary, e.department_id, d.department_name
  FROM employees e 
  JOIN departments d ON d.department_id = e.department_id
  WHERE salary BETWEEN 40000 AND 60000
  ORDER BY salary DESC;
  
-- 7
  SELECT SUM(salary) AS total_salary
  FROM employees e;
   
-- 8
 SELECT e.employee_name, d.department_name
 FROM employees e
 JOIN departments d ON e.department_id = d.department_id;

-- 9
 SELECT d.department_id, d.department_name, COUNT(e.employee_id) AS employee_sl
 FROM departments d
 LEFT JOIN employees e ON d.department_id = e.department_id
 GROUP BY d.department_id, d.department_name
 HAVING COUNT(e.employee_id) >= 3;
  
-- 10
 SELECT employee_name, salary
 FROM employees e 
 JOIN departments d ON e.department_id = d.department_id
 WHERE department_name in('IT', 'Sales');
-- 11
SELECT employee_name, start_date
FROM employees e 
WHERE YEAR(start_date) > 2020;

-- 12
SELECT AVG(salary) as avr_salary
FROM employees e;

-- 13
 SELECT d.department_name, COUNT(e.employee_id) AS employee_count
 FROM departments d
 LEFT JOIN employees e ON d.department_id = e.department_id
 GROUP BY d.department_name;
 
-- 14
SELECT salary, employee_name
FROM employees
GROUP BY salary, employee_name
ORDER BY salary DESC;

-- 15
SELECT employee_name
FROM employees 
WHERE employee_name LIKE 'A%';

-- 16
SELECT e.employee_name, a.access_level
FROM employees e
JOIN access_rights a ON e.employee_id = a.employee_id
WHERE a.access_level = 'Admin';

-- 17
SELECT SUM(e.salary) as tongluong, d.department_name
FROM employees e 
JOIN departments d ON d.department_id = e.department_id 
GROUP BY d.department_name
ORDER BY tongluong DESC;

-- 18
SELECT employee_name, start_date
FROM employees e
ORDER BY start_date ASC;

-- 19
SELECT e.employee_name, e.salary, d.department_name
FROM employees e 
JOIN departments d ON e.department_id = d.department_id 
ORDER BY e.salary DESC;

-- 20
SELECT e.employee_name, a.access_level
FROM employees e
JOIN access_rights a ON e.employee_id = a.employee_id;
