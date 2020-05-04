DROP DATABASE IF EXISTS schoolAdministration;
CREATE DATABASE schoolAdministration;

USE schoolAdministration;

CREATE TABLE students (
	id	INT	AUTO_INCREMENT	PRIMARY KEY,
	firstname VARCHAR(30)   NOT NULL,
    lastname VARCHAR(30)    NOT NULL,
    enrollmentDate DATE     NOT NULL,
    cpr VARCHAR(11)                 NOT NULL
);

INSERT INTO students VALUES 
(DEFAULT,'Lasse','Jørgensen','2019-12-17','150996-3661'),
(DEFAULT,'Jørgen','Jensen','2019-12-15','070265-2618'),
(DEFAULT,'Tina','Kristiansen','2018-10-04','151096-0455'),
(DEFAULT,'Bente','Olesen','2015-04-10','200785-2927'),
(DEFAULT,'Mark','Bentsen','2014-02-02','290359-0877'),
(DEFAULT,'Bo','Bostrupsen','2017-03-05','090949-4826'),
(DEFAULT,'Nicklas','Madsen','2012-07-03','190659-3625'),
(DEFAULT,'Mark','Andreasen','2013-11-15','220739-3625'),
(DEFAULT,'Joaquin','Frederiksen','2017-02-20','190861-3240'),
(DEFAULT,'Emil','Søndergaard','2012-06-26','100695-4924'),
(DEFAULT,'Charlotte','Gunnersen','2016-02-17','260142-3106'),
(DEFAULT,'Ida','Christensen','2019-01-10','220566-0022'),
(DEFAULT,'Børge','Thorsen','2012-04-27','200840-3603'),
(DEFAULT,'Jon','Stensen','2015-03-26','070567-4574'),
(DEFAULT,'Kristian','Bentsen','2011-07-12','220101-5831'),
(DEFAULT,'Betina','Boesen','2018-09-25','290744-2929'),
(DEFAULT,'Inger','Jensen','2014-09-23','221192-3825'),
(DEFAULT,'Gunner','Hansen','2015-08-20','030264-0300'),
(DEFAULT,'Ruth','Kruse','2012-11-16','200175-2718'),
(DEFAULT,'Andreas','Holmedal','2011-10-16','200292-0886'),
(DEFAULT,'Camilla','Jacobsen','2018-06-15','180941-0834'),
(DEFAULT,'Hjalmer','Odinsen','2012-03-11','233124-5551');
