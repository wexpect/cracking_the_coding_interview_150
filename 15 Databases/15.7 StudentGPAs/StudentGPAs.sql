-- CREATE TABLE Students (StudentID INT, StudentName CHAR(10));
-- 
-- INSERT INTO Students VALUES ( 1, 'Student1');
-- INSERT INTO Students VALUES ( 2, 'Student2');
-- 
-- SELECT * FROM Students



-- CREATE TABLE Courses (CourseID INT, CourseName CHAR(10), Credit INT);
-- 
-- INSERT INTO Courses VALUES ( 1, 'Course1', 3);
-- INSERT INTO Courses VALUES ( 2, 'Course2', 4);
-- 
-- SELECT * FROM Courses



-- DROP TABLE Grades;
-- 
-- CREATE TABLE Grades (StudentID INT, CourseID INT, Grade DECIMAL(2,1));
-- 
-- INSERT INTO Grades VALUES ( 1, 1, 2.5);
-- INSERT INTO Grades VALUES ( 1, 2, 3.5);
-- INSERT INTO Grades VALUES ( 2, 1, 3);
-- INSERT INTO Grades VALUES ( 2, 2, 3);
-- 
-- SELECT * FROM Grades


-- SELECT Grades.StudentID, Grades.Grade, Courses.Credit
--     FROM Grades INNER JOIN Courses
--     ON Grades.CourseID = Courses.CourseID


-- SELECT Grades.StudentID, Grades.Grade, Courses.Credit, Grades.Grade * Courses.Credit AS Product
--     FROM Grades INNER JOIN Courses
--     ON Grades.CourseID = Courses.CourseID


-- SELECT Grades.StudentID, sum(Grades.Grade * Courses.Credit) AS Total
--     FROM Grades INNER JOIN Courses
--     ON Grades.CourseID = Courses.CourseID
--     GROUP BY Grades.StudentID



-- SELECT Grades.StudentID, sum(Grades.Grade * Courses.Credit) AS Total
--     FROM Grades INNER JOIN Courses
--     ON Grades.CourseID = Courses.CourseID
--     GROUP BY Grades.StudentID
--     ORDER BY Total DESC






-- -- Solu 1: can only compute Total, not GPA

-- SELECT Students.StudentName, T.Total
-- FROM Students INNER JOIN
-- (
-- SELECT Grades.StudentID, sum(Grades.Grade * Courses.Credit) AS Total
--     FROM Grades INNER JOIN Courses
--     ON Grades.CourseID = Courses.CourseID
--     GROUP BY Grades.StudentID
--     ORDER BY Total DESC
-- ) T
-- ON Students.StudentID = T.StudentID








-- SELECT Grades.StudentID, sum(Grades.Grade * Courses.Credit)/2 AS Total
--     FROM Grades INNER JOIN Courses
--     ON Grades.CourseID = Courses.CourseID
--     GROUP BY Grades.StudentID




-- -- Solu 2: can compuete GPA

-- -- DECLARE and SET, TOP Num, TOP Num PERCENT only work in Microsift SQL Server; not in Derby

-- DECLARE @SumCredit REAL;
-- SET @SumCredit = 
-- (
-- SELECT sum(Courses.Credit)
-- FROM Courses
-- );
-- 
-- 
-- SELECT Students.StudentName, T.GPA
-- FROM Students INNER JOIN
-- (
-- SELECT TOP 10 PERCENT Grades.StudentID, sum(Grades.Grade * Courses.Credit)/@SumCredit AS GPA
--     FROM Grades INNER JOIN Courses
--     ON Grades.CourseID = Courses.CourseID
--     GROUP BY Grades.StudentID
--     ORDER BY GPA DESC
-- ) T
-- ON Students.StudentID = T.StudentID

