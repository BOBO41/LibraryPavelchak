USE Library;

INSERT INTO book (Book_Name, Author, Publisher, Imprint_Year, Amount) VALUES
('Bible','St. mans','Svichado',2005,5),
('Kobzar','Shevchenko ','Svichado',2007,4),
('Harry Potter','J. K. Rowling','Nebo Booklab Publishing',2002,1),
('Zakhar Berkut','I. Franko','Caravela',2003,2),
('The Jungle Book','Rudyard Kipling','Nebo Booklab Publishing',2002,1),
('100 fairy tales. Volume 1','','A-BA-BA-HA-LA-MA-HA',2005,3),
('100 fairy tales. Volume 2','','A-BA-BA-HA-LA-MA-HA',2008,1),
('100 fairy tales. Volume 3','','A-BA-BA-HA-LA-MA-HA',2014,2);

INSERT INTO city (IDCity,City) VALUES 
(1,'Herson'),(2,'Kyiv'),(3,'Lviv'),(4,'Poltava'),(5,'Ternopil');

INSERT INTO person (Surname,Name,Email,IDCity,Street,Apartment) VALUES 
('Koldovskyy','Vyacheslav','koldovsky@gmail.com',3,'Himichna','13/25'),
('Pavelchak','Andrii','apavelchak@gmail.com',4, 'Trartorystiv','11/14a'),
('Soluk','Andrian','andriansoluk@gmail.com',1,'Tehnichna','23'),
('Dubyniak','Bohdan','bohdan.dub@gmail.com',5,'S.Bandery','1/21'),
('Faryna','Igor','farynaihor@gmail.com',2,'Dytiacha','23/5'),
('Kurylo','Volodymyr','kurylo.volodymyr@gmail.com',4,'Vesniana','11a'),
('Shyika','Tamara','tamara.shyika@gmail.com',2,'Maidan Nezalezhnosti','3/5'),
('Tkachyk','Volodymyr','vova1234.tkachik@gmail.com',5,'S.Bandery','1/22');


