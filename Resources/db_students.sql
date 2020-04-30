DROP DATABASE IF EXISTS schoolAdministration;
CREATE DATABASE schoolAdministration;

SET GLOBAL time_zone = '+2:00';

USE schoolAdministration;

CREATE TABLE students (
	id	INT	AUTO_INCREMENT	PRIMARY KEY,
	firstname VARCHAR(30)   NOT NULL,
    lastname VARCHAR(30)    NOT NULL,
    enrollmentDate DATE     NOT NULL,
    cpr INT                 NOT NULL
);

INSERT INTO students VALUES 
(DEFAULT,'Lasse','Jørgensen','2019-12-17',1509963661),
(DEFAULT,'Jørgen','Jensen','2019-12-15',0702652618),
(DEFAULT,'Tina','Kristiansen','2018-10-04',1510960455),
(DEFAULT,'Bente','Olesen','2015-04-10',2007852927),
(DEFAULT,'Mark','Bentsen','2014-02-02',2903590877),
(DEFAULT,'Bo','Bostrupsen','2017-03-05',0909494826),
(DEFAULT,'Nicklas','Madsen','2012-07-03',1906593625),
(DEFAULT,'Mark','Andreasen','2013-11-15',2207393625),
(DEFAULT,'Joaquin','Frederiksen','2017-02-20',1908613240),
(DEFAULT,'Emil','Søndergaard','2012-06-26',1006954924),
(DEFAULT,'Charlotte','Gunnersen','2016-02-17',2601423106),
(DEFAULT,'Ida','Christensen','2019-01-10',2205660022),
(DEFAULT,'Børge','Thorsen','2012-04-27',2008403603),
(DEFAULT,'Jon','Stensen','2015-03-26',0705674574),
(DEFAULT,'Kristian','Bentsen','2011-07-12',2201015831),
(DEFAULT,'Betina','Boesen','2018-09-25',2907442929),
(DEFAULT,'Inger','Jensen','2014-09-23',2211923825),
(DEFAULT,'Gunner','Hansen','2015-08-20',0302640300),
(DEFAULT,'Ruth','Kruse','2012-11-16',2001752718),
(DEFAULT,'Andreas','Holmedal','2011-10-16',2002920886),
(DEFAULT,'Camilla','Jacobsen','2018-06-15',1809410834),
(DEFAULT,'Hjalmer','Odinsen','2012-03-11',2331245551);
