CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
declare i int;
set i = n - 1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct salary from Employee order by salary desc limit 1 offset i
  );
END