-- CREATE TABLE Tenants ( TenantID INT, TenantName CHAR(10)  );

-- INSERT INTO Tenants VALUES (1, 'Tenant1');
-- INSERT INTO Tenants VALUES (2, 'Tenant2');
-- INSERT INTO Tenants VALUES (3, 'Tenant3');

-- SELECT * FROM Tenants



-- CREATE TABLE AptTenants (TenantID INT, AptID INT);

-- INSERT INTO AptTenants VALUES (1,1);
-- INSERT INTO AptTenants VALUES (2,2);
-- INSERT INTO AptTenants VALUES (1,3);

-- DELETE FROM AptTenants WHERE TenantID = 1 AND AptID = 3;    -- can NOT replace WHERE with ON, does not work
-- DELETE FROM AptTenants WHERE TenantID = 2 AND AptID = 2;
-- DELETE From AptTenants WHERE TenantID = 1 AND AptID = 1;

-- SELECT * FROM AptTenants



-- SELECT TenantID, count(AptID) AS AptNum
--     FROM AptTenants
--     GROUP BY TenantID

-- --15.1

-- --Solu 2.1: works

-- SELECT Tenants.TenantName, T.AptNum
-- FROM(
-- SELECT TenantID, count(AptID) AS AptNum
--     FROM AptTenants
--     GROUP BY TenantID
-- ) T INNER JOIN Tenants    -- must give new data set a name here, T
-- ON T.AptNum > 1 AND T.TenantID = Tenants.TenantID



-- -- --Solu 2.2: works
-- 
-- SELECT Tenants.TenantName, T.AptNum
-- FROM Tenants INNER JOIN (
-- SELECT TenantID, count(AptID) AS AptNum
--     FROM AptTenants
--     GROUP BY TenantID
-- ) T     -- must give new data set a name here, T
-- ON T.AptNum > 1 AND T.TenantID = Tenants.TenantID


-- --Solu 2.3: works

-- SELECT Tenants.TenantName, T.AptNum
-- FROM Tenants INNER JOIN (
-- SELECT TenantID, count(*) AS AptNum
--     FROM AptTenants
--     GROUP BY TenantID
-- ) T     -- must give new data set a name here, T
-- ON T.AptNum > 1 AND T.TenantID = Tenants.TenantID






-- 15.2

-- CREATE TABLE Buildings ( BuildingID INT, BuildingName CHAR(10)  );
-- 
-- INSERT INTO Buildings VALUES( 1, 'Building1');
-- INSERT INTO Buildings VALUES( 2, 'Building2');
-- INSERT INTO Buildings VALUES( 3, 'Building3');
-- 
-- SELECT * FROM Buildings


-- CREATE TABLE Apartments ( AptID INT, BuildingID INT );
-- 
-- INSERT INTO Apartments VALUES ( 1, 1);
-- INSERT INTO Apartments VALUES ( 2, 1);
-- INSERT INTO Apartments VALUES ( 3, 2);
-- INSERT INTO Apartments VALUES ( 4, 3);
-- 
-- SELECT * FROM Apartments



--DROP TABLE Requests;

-- CREATE TABLE Requests (Status CHAR(10), AptID INT);
-- 
-- INSERT INTO Requests VALUES ( 'Open', 1);
-- INSERT INTO Requests VALUES ( 'Open', 1);
-- INSERT INTO Requests VALUES ( 'Close', 2);
-- INSERT INTO Requests VALUES ( 'Open', 4);
-- 
-- SELECT * FROM Requests



-- SELECT Requests.AptID
-- FROM Requests
-- WHERE Requests.Status = 'Open'   -- can NOT replace WHERE with ON, does not work


    
-- SELECT Apartments.BuildingID, count(*) AS OpenNum
-- FROM Apartments INNER JOIN
--     (
--     SELECT Requests.AptID
--     FROM Requests
--     WHERE Requests.Status = 'Open'   -- can NOT replace WHERE with ON, does not work
--     ) T1
-- ON Apartments.AptID = T1.AptID
-- GROUP BY Apartments.BuildingID



-- -- Solu 1:
-- SELECT Buildings.BuildingName, T2.OpenNum
-- FROM Buildings LEFT JOIN
--     (
--     SELECT Apartments.BuildingID, count(*) AS OpenNum
--     FROM Apartments INNER JOIN
--         (
--         SELECT Requests.AptID
--         FROM Requests
--         WHERE Requests.Status = 'Open'   -- can NOT replace WHERE with ON, does not work
--         ) T1
--     ON Apartments.AptID = T1.AptID
--     GROUP BY Apartments.BuildingID
--     ) T2   
-- ON Buildings.BuildingID = T2.BuildingID


-- -- -- Solu 2:
-- SELECT Buildings.BuildingName,  T2.OpenNum
-- FROM Buildings LEFT JOIN
--     (
--     SELECT Apartments.BuildingID, count(*) AS OpenNum
--     FROM Apartments INNER JOIN Requests
--     ON Apartments.AptID = Requests.AptID
--         AND Requests.Status = 'Open'   -- can NOT replace WHERE with ON, does not work
--         GROUP BY Apartments.BuildingID
--     ) T2   
-- ON Buildings.BuildingID = T2.BuildingID

-- -- Solu 3:
-- SELECT Buildings.BuildingName,  T2.OpenNum, 
--     -- In SQL Server, we replace T2.OpenNum with:
--        -- ISNULL( T2.OpenNum, 0)
--     -- In MySQL, we replace T2.OpenNum with:
--        -- ISNULL( T2.OpenNum, 0) or IFNULL( T2.OpenNum, 0), both works
--     -- In Oracle, we replace T2.OpenNum with:
--         -- NVL( T2.OpenNum, 0)
--     -- In Derby, we add a new column:
--     CASE 
--         WHEN T2.OpenNum IS NULL THEN 0
--         ELSE T2.OpenNum  -- if miss the ELSE statement, other rows will be NULL because they are not assigned values           
--     END NewOpenNum
-- FROM Buildings LEFT JOIN
--     (
--     SELECT Apartments.BuildingID, count(*) AS OpenNum
--     FROM Apartments INNER JOIN Requests
--     ON Apartments.AptID = Requests.AptID
--         AND Requests.Status = 'Open'   -- can NOT replace WHERE with ON, does not work
--         GROUP BY Apartments.BuildingID
--     ) T2   
-- ON Buildings.BuildingID = T2.BuildingID




-- 15.3

-- INSERT INTO Apartments VALUES ( 110, 11);
-- 
-- SELECT * FROM Apartments


-- INSERT INTO Requests VALUES ('Open', 110);
-- 
-- SELECT * FROM Requests


-- UPDATE Requests
--     SET Status = 'Open'
--     WHERE AptID = 110;


-- This works
-- UPDATE Requests 
-- SET Requests.Status = 'Close'    
--     WHERE Requests.AptID IN  -- need to use IN
-- (
--     SELECT AptID  -- can ONLY return one column here
--     FROM Apartments
--     WHERE BuildingID = 11
-- );   -- can NOT add T after )



-- This does not work
-- UPDATE Requests SET Status = 'Close' WHERE Requests.AptID = Apartments.AptID AND Apartments.BuildingID = 11

-- SELECT * FROM Requests;






