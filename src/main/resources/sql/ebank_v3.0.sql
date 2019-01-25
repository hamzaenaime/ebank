CREATE TYPE titleEnum AS ENUM
    ('M.','Mme','Mlle');

create table Personne(
  	cin varchar(10) primary key,
    title titleEnum,
		nom varchar(30),
		prenom varchar(30),
		date_naissance date check (extract(year from age(date_naissance))>=18),
		address varchar(100),
		ville varchar(30),
		tel varchar(15) unique,
		email varchar(50) unique,
		password varchar(100),
		date_creation TIMESTAMP(0) DEFAULT Now(),
		last_login TIMESTAMP(0)
);

insert into Personne(cin,nom,prenom,date_naissance,address,ville,tel,email,password,last_login) values('id84901','nafar','bill',TO_DATE('1996/20/11','YYYY/dd/mm'),'lissasfa','casablanca','0625647473','nafar.belal@gmail.com','1235',now());
insert into Personne(cin,nom,prenom,date_naissance,address,ville,tel,email,password,last_login) values('bk12','ayoub','haaoui',TO_DATE('1996/20/11','YYYY/dd/mm'),'lissasfa','casablanca','0675647473','hamaoui@gmail.com','1235',now());

create table Client(
		id varchar(10) references personne(cin) primary key
    numCompte serial references compte(numCompte) not null
  );

insert  into client values ('id84901');

create table Agence(
  id serial primary key,
  id_directeur varchar(10) unique null,
  nom varchar(30),
  adresse varchar(100),
  ville varchar(30),
  date_ouverture date default now()
);

create table Employe(
  id varchar(10) references personne(cin) primary key,
  id_employeur varchar(10) null,
  id_agence serial references agence(id),
  salaire decimal,
  FOREIGN KEY (id_employeur) REFERENCES Employe(id)
);

ALTER TABLE Agence
ADD CONSTRAINT fk_dir
foreign key (id_directeur) references employe(id);

insert into Agence(nom, adresse, ville) values('tanger malabata','malabata tanger 90000','tanger');

insert into employe (id, id_agence,salaire) values('bk12',1,15000);

update agence set id_directeur='bk12' where id=2;

create table Compte(
  numCompte serial primary key,
  solde decimal default 0,
  date_ouverture TIMESTAMP(0) DEFAULT Now(),
  active boolean default false,
  date_fermeture TIMESTAMP(0)
);


insert into Compte default values;

create table compteEpargne(
  numCompte serial references compte(numCompte) primary key,
  interet decimal
);

create table CompteCourant(
  numCompte serial references compte(numCompte) primary key,
  decouvertMax decimal
);

--reponse au compte conjoint l'association entre client et compte devient many to many so association devienne une table
insert into assoc_compte_client(numCompte,id_client) values(1,'id84901');

create table Operation(
  id_operation serial primary key,
  id_compte_src int REFERENCES compte(numCompte),
  id_compte_dest int REFERENCES compte(numCompte),
  description varchar(300),
  montant decimal,
  date_operation TIMESTAMP(0) DEFAULT Now()
);
alter table operation
    alter column descroption
    type varchar(300);

--virement online
create table Operation_client(
  id_operation serial references operation(id_operation) primary key,
  id_client varchar(10) REFERENCES client(id)
);

--virement en agence
create table Operation_employe(
  id_operation serial references operation(id_operation) primary key,
  id_employe serial REFERENCES compte(numCompte),
  nom varchar(10),
  prenom varchar(10),
  cin varchar(10)
);

create table Reclamation(
  id serial primary key,
  owner varchar(10) references client(id),
  objet varchar(40),
  description varchar(1000),
  traiter boolean default false,
  date_creation TIMESTAMP(0) DEFAULT Now()
);

