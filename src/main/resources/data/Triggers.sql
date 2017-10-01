USE Library ;

DELIMITER //
CREATE TRIGGER AfterInsertPersonBook
AFTER INSERT
ON PersonBook FOR EACH ROW
BEGIN
	DECLARE NamePerson VARCHAR(50);
    DECLARE NameBook VARCHAR(90);
    SELECT CONCAT(Surname, ' ', Name) INTO NamePerson
    FROM Person WHERE IDPerson=new.IDPerson;
    SELECT CONCAT(Book_Name, ' / ', Author) INTO NameBook
    FROM Book WHERE IDBook=new.IDBook;
	INSERT INTO Logger (Person, Book, Action, 
								Time_Stamp, User)
	VALUES(NamePerson,  NameBook, 'GOT', NOW(), USER() );
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER AfterDeletePersonBook
AFTER DELETE
ON PersonBook FOR EACH ROW
BEGIN
	DECLARE NamePerson VARCHAR(50);
    DECLARE NameBook VARCHAR(90);
    SELECT CONCAT(Surname, ' ', Name) INTO NamePerson
    FROM Person WHERE IDPerson=old.IDPerson;
    SELECT CONCAT(Book_Name, ' / ', Author) INTO NameBook
    FROM Book WHERE IDBook=old.IDBook;
	INSERT INTO Logger (Person, Book, Action, 
								Time_Stamp, User)
	VALUES(NamePerson,  NameBook, 'GAVEBACK', NOW(), USER() );
END //
DELIMITER ;






