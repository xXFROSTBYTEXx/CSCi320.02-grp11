create database socialNet;
use socialNet;

CREATE USER 'USERNAME'@'localhost' identified BY 'PASSWORD';
USE socialnet;
grant ALL ON socialnet.* to 'USERNAME'@'localhost';

CREATE TABLE SocialUser( 

	email varchar(50) not null,
	firstName varchar(20) not null,
    lastName varchar(30) not null,
    
    PRIMARY KEY(email)
);
    
CREATE TABLE Recruiter( 

	email varchar(50) not null,
    
    PRIMARY KEY(email),
    FOREIGN KEY (email) REFERENCES SocialUser(email)
);

CREATE TABLE Interview( 
	
    recruiter varchar(50) not null,
	schedueled date not null,
    
    PRIMARY KEY (recruiter, schedueled),
    FOREIGN KEY (recruiter) REFERENCES Recruiter(email)
);

CREATE TABLE Company(

	id Integer not null,
	companyName varchar(100),
    
    PRIMARY KEY (id)
);

CREATE TABLE JobPosition( 
	
    id Integer not null,
	initD date,
    endD date,
    title varchar(50),
    company Integer,
    
    PRIMARY KEY (id),
    FOREIGN KEY (company) REFERENCES Company(id)
);
    
CREATE TABLE ParticipatesIn( 

	recruiter varchar(50) not null,
	schedueled date not null,
    socialUser varchar(50) not null,
    
    PRIMARY KEY(recruiter, schedueled, socialUser), 
    FOREIGN KEY(recruiter, schedueled) REFERENCES Interview(recruiter, schedueled),
    FOREIGN KEY(socialUser) REFERENCES SocialUser(email)
);
    
CREATE TABLE WorksIn( 

	socialUser varchar(50) not null,
	jobPosition Integer not null,
    
    PRIMARY KEY(socialUser, jobPosition),
    FOREIGN KEY(socialUser) REFERENCES SocialUser(email),
    FOREIGN KEY (jobPosition) REFERENCES JobPosition(id)
);
    
CREATE TABLE JobPost( 
	
    id Integer not null, 
	jobPosition varchar(100),
    minSalary Integer,
    maxSalary Integer,
    description varchar(450),
    active Boolean default 0,
    recruiter varchar(50),
    schedueled date,
    company Integer,
    
    PRIMARY KEY (id),
    FOREIGN KEY (recruiter, schedueled) REFERENCES Interview(recruiter, schedueled),
    FOREIGN KEY (company) REFERENCES Company(id)
);
    
CREATE TABLE BranchesInto( 
	
    main Integer not null,
	branch Integer not null,
    
    PRIMARY KEY(main, branch),
    FOREIGN KEY(main)  REFERENCES Company(id),
    FOREIGN KEY(branch)  REFERENCES Company(id)
);