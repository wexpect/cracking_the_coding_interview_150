CREATE TABLE Students ( StudentID CHAR(10), StudentName CHAR(10) ) -- , is important    

INSERT INTO Students VALUES ( '1', 'A'  );
INSERT INTO Students VALUES ( '2', 'B'  );
 INSERT INTO Students VALUES ( '3', 'C'  );

 SELECT * FROM Students


DROP TABLE StudentCourses;

CREATE TABLE StudentCourses ( CourseID CHAR(10), StudentID CHAR(10) );

INSERT INTO StudentCourses VALUES ( 'C1', '1' );
INSERT INTO StudentCourses VALUES ( 'C1', '2' );

INSERT INTO StudentCourses VALUES ( 'C2', '1' );

INSERT INTO StudentCourses VALUES ( 'C3', '2' );

SELECT * FROM StudentCourses



SELECT StudentName, CourseID 
    FROM Students, StudentCourses
    WHERE Students.StudentID = StudentCourses.StudentID


SELECT StudentName, COUNT(CourseID)
    FROM Students, StudentCourses
    WHERE Students.StudentID = StudentCourses.StudentID
    GROUP BY StudentName



SELECT StudentName, CourseID
    FROM Students LEFT OUTER JOIN StudentCourses 
    ON Students.StudentID = StudentCourses.StudentID

SELECT Students.StudentID, StudentName, COUNT(CourseID)  -- COUNT(CourseID) will count NULL as 0
    FROM Students LEFT OUTER JOIN StudentCourses  -- LEFT OUTER JOIN or LEFT JOIN both works
    ON Students.StudentID = StudentCourses.StudentID
    GROUP BY Students.StudentID, StudentName  -- GROUP BY every column appears in the SELECT, except the column with arithmetic operation




CREATE TABLE Teachers ( TeacherID CHAR(10), TeacherName CHAR(10) ) -- , is important    

INSERT INTO Teachers VALUES ( 'T1', 'TeacherA'  );
INSERT INTO Teachers VALUES ( 'T2', 'TeacherB'  );
INSERT INTO Teachers VALUES ( 'T3', 'TeacherC'  );



CREATE TABLE Courses ( CourseID CHAR(10), CourseName CHAR(10), TeacherID CHAR(10) ) -- , is important    

INSERT INTO Courses VALUES ( 'C1', 'CourseA', 'T1' );
INSERT INTO Courses VALUES ( 'C2', 'CourseB', 'T1'  );
INSERT INTO Courses VALUES ( 'C3', 'CourseC', 'T2'  );



-- This does not work, because the syntax is not right.
SELECT Teachers.TeacherName, StudentCourses.StudentID
    FROM Teachers LEFT JOIN Courses LEFT JOIN StudentCourses
            ON Teachers.TeacherID = Courses.TeacherID            
                AND Courses.CourseID = StudentCourses.CourseID


-- Works
SELECT Teachers.TeacherName, StudentCourses.StudentID
    FROM 
        Teachers LEFT JOIN Courses
            ON Teachers.TeacherID = Courses.TeacherID
        LEFT JOIN StudentCourses
            ON Courses.CourseID = StudentCourses.CourseID

-- Works
SELECT Teachers.TeacherName, StudentCourses.StudentID
    FROM 
        Teachers LEFT JOIN Courses
            ON Teachers.TeacherID = Courses.TeacherID
        LEFT JOIN StudentCourses  -- must use LEFT JOIN here, INNER JOIN will not display TeacherC
            ON Courses.CourseID = StudentCourses.CourseID
 --   GROUP BY Teachers.TeacherName
    ORDER BY StudentCourses.StudentID DESC -- ASC or DESC 


-- Works
SELECT Teachers.TeacherName, COUNT(StudentCourses.StudentID)
    FROM 
        Teachers LEFT JOIN Courses
            ON Teachers.TeacherID = Courses.TeacherID
        LEFT JOIN StudentCourses  -- must use LEFT JOIN here, INNER JOIN will not display TeacherC
            ON Courses.CourseID = StudentCourses.CourseID
    GROUP BY Teachers.TeacherName
    ORDER BY COUNT(StudentCourses.StudentID) ASC -- ASC or DESC 


-- Works
SELECT Teachers.TeacherName, COUNT(StudentCourses.StudentID) AS StudentCount -- AS NewName;  [NewName] does NOT work in this test
    FROM 
        Teachers LEFT JOIN Courses
            ON Teachers.TeacherID = Courses.TeacherID
        LEFT JOIN StudentCourses  -- must use LEFT JOIN here, INNER JOIN will not display TeacherC
            ON Courses.CourseID = StudentCourses.CourseID
    GROUP BY Teachers.TeacherName
    ORDER BY StudentCount ASC -- ASC or DESC 


-- Does NOT Work
SELECT Teachers.TeacherName, StudentCount
    FROM 
        Teachers LEFT JOIN Courses
            ON Teachers.TeacherID = Courses.TeacherID
        LEFT JOIN StudentCourses  -- must use LEFT JOIN here, INNER JOIN will not display TeacherC
            ON Courses.CourseID = StudentCourses.CourseID
    GROUP BY Teachers.TeacherName
    ORDER BY COUNT(StudentCourses.StudentID) AS StudentCount ASC -- ASC or DESC 