-- SQLite3

-- TRAIN TABLE CREATION
CREATE TABLE Train1 (Train_Number PRIMARY KEY, Train_Name VARCHAR[25] NOT NULL, src VARCHAR[5] NOT NULL, dst VARCHAR[5] NOT NULL, A SMALLINT NOT NULL, B SMALLINT NOT NULL, C SMALLINT NOT NULL, Total_Seat_A SMALLINT NOT NULL, Total_Seat_B SMALLINT NOT NULL, Total_Seat_C SMALLINT NOT NULL, Price_A SMALLINT NOT NULL, Price_B SMALLINT NOT NULL, Price_C SMALLINT NOT NULL);
CREATE TABLE Train2 (Train_Number PRIMARY KEY, Train_Name VARCHAR[25] NOT NULL, src VARCHAR[5] NOT NULL, dst VARCHAR[5] NOT NULL, A SMALLINT NOT NULL, B SMALLINT NOT NULL, C SMALLINT NOT NULL, Total_Seat_A SMALLINT NOT NULL, Total_Seat_B SMALLINT NOT NULL, Total_Seat_C SMALLINT NOT NULL, Price_A SMALLINT NOT NULL, Price_B SMALLINT NOT NULL, Price_C SMALLINT NOT NULL);
CREATE TABLE Train3 (Train_Number PRIMARY KEY, Train_Name VARCHAR[25] NOT NULL, src VARCHAR[5] NOT NULL, dst VARCHAR[5] NOT NULL, A SMALLINT NOT NULL, B SMALLINT NOT NULL, C SMALLINT NOT NULL, Total_Seat_A SMALLINT NOT NULL, Total_Seat_B SMALLINT NOT NULL, Total_Seat_C SMALLINT NOT NULL, Price_A SMALLINT NOT NULL, Price_B SMALLINT NOT NULL, Price_C SMALLINT NOT NULL);
CREATE TABLE Train4 (Train_Number PRIMARY KEY, Train_Name VARCHAR[25] NOT NULL, src VARCHAR[5] NOT NULL, dst VARCHAR[5] NOT NULL, A SMALLINT NOT NULL, B SMALLINT NOT NULL, C SMALLINT NOT NULL, Total_Seat_A SMALLINT NOT NULL, Total_Seat_B SMALLINT NOT NULL, Total_Seat_C SMALLINT NOT NULL, Price_A SMALLINT NOT NULL, Price_B SMALLINT NOT NULL, Price_C SMALLINT NOT NULL);
CREATE TABLE Train5 (Train_Number PRIMARY KEY, Train_Name VARCHAR[25] NOT NULL, src VARCHAR[5] NOT NULL, dst VARCHAR[5] NOT NULL, A SMALLINT NOT NULL, B SMALLINT NOT NULL, C SMALLINT NOT NULL, Total_Seat_A SMALLINT NOT NULL, Total_Seat_B SMALLINT NOT NULL, Total_Seat_C SMALLINT NOT NULL, Price_A SMALLINT NOT NULL, Price_B SMALLINT NOT NULL, Price_C SMALLINT NOT NULL);
CREATE TABLE Train6 (Train_Number PRIMARY KEY, Train_Name VARCHAR[25] NOT NULL, src VARCHAR[5] NOT NULL, dst VARCHAR[5] NOT NULL, A SMALLINT NOT NULL, B SMALLINT NOT NULL, C SMALLINT NOT NULL, Total_Seat_A SMALLINT NOT NULL, Total_Seat_B SMALLINT NOT NULL, Total_Seat_C SMALLINT NOT NULL, Price_A SMALLINT NOT NULL, Price_B SMALLINT NOT NULL, Price_C SMALLINT NOT NULL);
CREATE TABLE Train7 (Train_Number PRIMARY KEY, Train_Name VARCHAR[25] NOT NULL, src VARCHAR[5] NOT NULL, dst VARCHAR[5] NOT NULL, A SMALLINT NOT NULL, B SMALLINT NOT NULL, C SMALLINT NOT NULL, Total_Seat_A SMALLINT NOT NULL, Total_Seat_B SMALLINT NOT NULL, Total_Seat_C SMALLINT NOT NULL, Price_A SMALLINT NOT NULL, Price_B SMALLINT NOT NULL, Price_C SMALLINT NOT NULL);

-- END (TRAIN TABLE CREATION)

-- PASSENGER TABLE CREATION
CREATE TABLE Passenger1(TktID INTEGER PRIMARY KEY AUTOINCREMENT ,GpId SMALLINT NOT NULL,Train_Number SMALLINT NOT NULL,PassName VARCHAR[25] NOT NULL,Age SMALLINT NOT NULL,Sex VARCHAR[1] NOT NULL,Class VARCHAR[5] NOT NULL,SeatNum SMALLINT DEFAULT -1,State SMALLINT NOT NULL,Time DATETIME DEFAULT CURRENT_TIMESTAMP);
CREATE TABLE Passenger2(TktID INTEGER PRIMARY KEY AUTOINCREMENT ,GpId SMALLINT NOT NULL,Train_Number SMALLINT NOT NULL,PassName VARCHAR[25] NOT NULL,Age SMALLINT NOT NULL,Sex VARCHAR[1] NOT NULL,Class VARCHAR[5] NOT NULL,SeatNum SMALLINT DEFAULT -1,State SMALLINT NOT NULL,Time DATETIME DEFAULT CURRENT_TIMESTAMP);
CREATE TABLE Passenger3(TktID INTEGER PRIMARY KEY AUTOINCREMENT ,GpId SMALLINT NOT NULL,Train_Number SMALLINT NOT NULL,PassName VARCHAR[25] NOT NULL,Age SMALLINT NOT NULL,Sex VARCHAR[1] NOT NULL,Class VARCHAR[5] NOT NULL,SeatNum SMALLINT DEFAULT -1,State SMALLINT NOT NULL,Time DATETIME DEFAULT CURRENT_TIMESTAMP);
CREATE TABLE Passenger4(TktID INTEGER PRIMARY KEY AUTOINCREMENT ,GpId SMALLINT NOT NULL,Train_Number SMALLINT NOT NULL,PassName VARCHAR[25] NOT NULL,Age SMALLINT NOT NULL,Sex VARCHAR[1] NOT NULL,Class VARCHAR[5] NOT NULL,SeatNum SMALLINT DEFAULT -1,State SMALLINT NOT NULL,Time DATETIME DEFAULT CURRENT_TIMESTAMP);
CREATE TABLE Passenger5(TktID INTEGER PRIMARY KEY AUTOINCREMENT ,GpId SMALLINT NOT NULL,Train_Number SMALLINT NOT NULL,PassName VARCHAR[25] NOT NULL,Age SMALLINT NOT NULL,Sex VARCHAR[1] NOT NULL,Class VARCHAR[5] NOT NULL,SeatNum SMALLINT DEFAULT -1,State SMALLINT NOT NULL,Time DATETIME DEFAULT CURRENT_TIMESTAMP);
CREATE TABLE Passenger6(TktID INTEGER PRIMARY KEY AUTOINCREMENT ,GpId SMALLINT NOT NULL,Train_Number SMALLINT NOT NULL,PassName VARCHAR[25] NOT NULL,Age SMALLINT NOT NULL,Sex VARCHAR[1] NOT NULL,Class VARCHAR[5] NOT NULL,SeatNum SMALLINT DEFAULT -1,State SMALLINT NOT NULL,Time DATETIME DEFAULT CURRENT_TIMESTAMP);
CREATE TABLE Passenger7(TktID INTEGER PRIMARY KEY AUTOINCREMENT ,GpId SMALLINT NOT NULL,Train_Number SMALLINT NOT NULL,PassName VARCHAR[25] NOT NULL,Age SMALLINT NOT NULL,Sex VARCHAR[1] NOT NULL,Class VARCHAR[5] NOT NULL,SeatNum SMALLINT DEFAULT -1,State SMALLINT NOT NULL,Time DATETIME DEFAULT CURRENT_TIMESTAMP);

-- END (PASSENGER TABLE CREATION)

-- INSERT INTO Train1
INSERT INTO Train1 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (121,'TrainA','mdu','che',100,200,300,100,200,300,300,200,100);
INSERT INTO Train1 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (122,'TrainA','che','mdu',100,200,300,100,200,300,300,200,100);
INSERT INTO Train1 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (111,'TrainB','mdu','ban',100,200,300,100,200,300,300,200,100);
INSERT INTO Train1 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (112,'TrainB','ban','mdu',100,200,300,100,200,300,300,200,100);
--END (INSERT INTO Trainx)

-- INSERT INTO Train2
INSERT INTO Train2 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (121,'TrainA','mdu','che',100,200,300,100,200,300,300,200,100);
INSERT INTO Train2 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (122,'TrainA','che','mdu',100,200,300,100,200,300,300,200,100);
INSERT INTO Train2 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (111,'TrainB','mdu','ban',100,200,300,100,200,300,300,200,100);
INSERT INTO Train2 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (112,'TrainB','ban','mdu',100,200,300,100,200,300,300,200,100);
--END (INSERT INTO Train2)

-- INSERT INTO Train3
INSERT INTO Train3 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (121,'TrainA','mdu','che',100,200,300,100,200,300,300,200,100);
INSERT INTO Train3 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (122,'TrainA','che','mdu',100,200,300,100,200,300,300,200,100);
INSERT INTO Train3 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (111,'TrainB','mdu','ban',100,200,300,100,200,300,300,200,100);
INSERT INTO Train3 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (112,'TrainB','ban','mdu',100,200,300,100,200,300,300,200,100);
--END (INSERT INTO Train3)

-- INSERT INTO Train4
INSERT INTO Train4 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (121,'TrainA','mdu','che',100,200,300,100,200,300,300,200,100);
INSERT INTO Train4 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (122,'TrainA','che','mdu',100,200,300,100,200,300,300,200,100);
INSERT INTO Train4 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (111,'TrainB','mdu','ban',100,200,300,100,200,300,300,200,100);
INSERT INTO Train4 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (112,'TrainB','ban','mdu',100,200,300,100,200,300,300,200,100);
--END (INSERT INTO Train4)

-- INSERT INTO Train5
INSERT INTO Train5 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (121,'TrainA','mdu','che',100,200,300,100,200,300,300,200,100);
INSERT INTO Train5 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (122,'TrainA','che','mdu',100,200,300,100,200,300,300,200,100);
INSERT INTO Train5 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (111,'TrainB','mdu','ban',100,200,300,100,200,300,300,200,100);
INSERT INTO Train5 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (112,'TrainB','ban','mdu',100,200,300,100,200,300,300,200,100);
--END (INSERT INTO Train5)

-- INSERT INTO Train6
INSERT INTO Train6 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (121,'TrainA','mdu','che',100,200,300,100,200,300,300,200,100);
INSERT INTO Train6 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (122,'TrainA','che','mdu',100,200,300,100,200,300,300,200,100);
INSERT INTO Train6 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (111,'TrainB','mdu','ban',100,200,300,100,200,300,300,200,100);
INSERT INTO Train6 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (112,'TrainB','ban','mdu',100,200,300,100,200,300,300,200,100);
--END (INSERT INTO Train6)

-- INSERT INTO Train7
INSERT INTO Train7 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (121,'TrainA','mdu','che',100,200,300,100,200,300,300,200,100);
INSERT INTO Train7 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (122,'TrainA','che','mdu',100,200,300,100,200,300,300,200,100);
INSERT INTO Train7 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (111,'TrainB','mdu','ban',100,200,300,100,200,300,300,200,100);
INSERT INTO Train7 (Train_Number, Train_Name, src, dst, A, B, C, Total_Seat_A, Total_Seat_B, Total_Seat_C, Price_A, Price_B, Price_C)
VALUES (112,'TrainB','ban','mdu',100,200,300,100,200,300,300,200,100);
--END (INSERT INTO Train7)


-- RESET DATA QUERY
UPDATE Train1 SET A = 100 , B = 200 , C = 300;
UPDATE Train2 SET A = 100 , B = 200 , C = 300;
UPDATE Train3 SET A = 100 , B = 200 , C = 300;
UPDATE Train4 SET A = 100 , B = 200 , C = 300;
UPDATE Train5 SET A = 100 , B = 200 , C = 300;
UPDATE Train6 SET A = 100 , B = 200 , C = 300;
UPDATE Train7 SET A = 3 , B = 3 , C = 3;
DELETE FROM Passenger1;
DELETE FROM Passenger2;
DELETE FROM Passenger3;
DELETE FROM Passenger4;
DELETE FROM Passenger5;
DELETE FROM Passenger6;
DELETE FROM Passenger7;
-- END (RESET DATA QUERY)


--Test Queries--
UPDATE Train7 SET A = 3 , B = 3 , C = 3,Total_Seat_A = 3,Total_Seat_B = 3,Total_Seat_C = 3;
SELECT TktId from Passenger7  WHERE SeatNum == -2 AND Train_Number == 121 AND Class == 'A';