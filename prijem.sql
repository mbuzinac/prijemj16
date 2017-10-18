drop database if exists prijem;
create database prijem default character set utf8;



use prijem;

--za potrebe byet hosting
ALTER DATABASE CHARACTER SET utf8 COLLATE utf8_unicode_ci;



create table dobavljac(
sifra 		int 			not null primary key auto_increment,
naziv       varchar(50)     not null,
adresa      varchar(60)     not null,
telefon     varchar(20)     not null,
email 		varchar(100) 	not null,
obrisano boolean not null default false
)engine=InnoDB;

create table artikl(
sifra int not null primary key auto_increment,
dobavljac int not null,
kategorija int not null,
naziv varchar(50) not null,
ean varchar(13) not null,
lot varchar(20),
cijena decimal(8,2) not null,
pakiranje varchar(50) 
)engine=InnoDB;

create table narudzba(
sifra int not null primary key auto_increment,
vrsta varchar (20) not null,
dobavljac int not null,
artikl int not null,
kolicina varchar (30) not null,
datum_narudzbe datetime not null DEFAULT CURRENT_TIMESTAMP, 
datum_isporuke datetime not null
)engine=InnoDB;

create table ulaz_robe(
sifra int not null primary key auto_increment,
narudzba int not null,
artikl int not null,
broj_opremnice varchar(30),
datum date not null
)engine=InnoDB;


create table kategorija(
sifra int not null primary key auto_increment,
naziv varchar(30)
)engine=InnoDb;


alter table narudzba add foreign key(dobavljac) references dobavljac(sifra); 
alter table artikl add foreign key(kategorija) references kategorija(sifra);
alter table artikl add foreign key(dobavljac) references dobavljac(sifra);
alter table ulaz_robe add foreign key (narudzba) references narudzba(sifra);
alter table ulaz_robe add foreign key (artikl) references artikl(sifra);



insert into dobavljac (sifra,naziv,adresa,telefon,email) values
#1
(null,'Kraš','Jablanova 31 Zagreb','01-512-012','kras@kras.hr'),
#2
(null,'Atlantic','Avenija 3 Zagreb','01-612-612','atlantic@upravaat.hr'),
#3
(null,'Pivovara Osijek','Vukovarska 112 Osijek','031-205-612','prvohrvatskopivo@gmail.hr'),
#4
(null,'Tvornica ulja Čepin','Radnicka 8 Čepin','031-205-301','cepinskoulje@gmail.hr'),
#5
(null,'Limarija Sebastijan','Kolodvorska 1 Belišće','031-200-301','limarijasebastijan@gmail.hr'),
#6
(null,'AWT','Jablanova 25 Zagreb','01-512-301','awt@gmail.hr'),
#7
(null,'Vinkoprom','Bosutska 11 Vinkovci','030-512-301','vinkoprom@gmail.hr'),
#8
(null,'Ravlić','Industrijska 1 Petrijevci','031-395-301','ravlic@gmail.hr'),
#9
(null,'Vulkak','Industrijska 36 Županja','035-395-301','vulkal@gmail.hr'),
#10
(null,'PP Orahovica','Kolodvorska 1 Našice','032-395-301','pporahovica@gmail.hr'),
#11
(null,'Vindija','Kolodvorska 12 Zagreb','01-395-301','vindija@upraval.hr'),
#12
(null,'OPG Ivkovic','Uska cesta 3 Zagreb','01-395-301','opgivkovic@upraval.hr');

insert into kategorija (sifra,naziv) values
#1
(null,'Meso'),
#2
(null,'Mlijecno i smrznuto'),
#3
(null,'Voće i povrće'),
#4
(null,'Piće'),
#5
(null,'Suhi asortiman'),
#6
(null,'Salame'),
#7
(null,'Delikatesa'),
#8
(null,'Pekara'),
#9
(null,'Kemija i kozmetika'),
#10
(null,'Netrgovacka roba'),
#11
(null,'Ostalo');

insert into artikl (sifra,dobavljac,kategorija,naziv,ean,cijena,pakiranje) values

#1
(null,1,5,'Gloria 250g','38500124568','17,99kn','kom'),
#2
(null,1,5,'Gloria 500g','38500124564','24,99kn','kom'),
#3
(null,1,5,'Gloria 175g','38500124561','13,99kn','kom'),
#4
(null,1,5,'Franck kava 250','38500124317','19,99kn','kom'),
#5
(null,1,5,'Frack čaj limun 90g','38500124314','17,99kn','kom'),
#6
(null,1,5,'Frack čaj šumsko voće 90g','38500124638','17,99kn','kom'),
#7
(null,1,5,'Frack čaj zeleni 90g','38500124111','17,99kn','kom'),
#8
(null,1,5,'Frack čaj brusnica 90g','38500124247','17,99kn','kom'),
#9
(null,1,5,'Frack čaj šipak 90g','38500124312','17,99kn','kom'),
#10
(null,1,5,'Frack čaj hibiskus 90g','38500144568','17,99kn','kom'),
#11
(null,1,5,'Frack čaj menta 90g','38500124558','17,99kn','kom'),
#12
(null,1,5,'Frack čaj borovnica 90g','38500127578','17,99kn','kom');





 
 
 









