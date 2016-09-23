create database socialNet;

use socialNet;

CREATE USER 'USERNAME'@'localhost' identified BY 'PASSWORD';
USE socialnet;
grant ALL ON socialnet.* to 'USERNAME'@'localhost';

CREATE TABLE User( email varchar(50) not null,
	firstName varchar(20) not null,
    lastName varchar(30) not null,
    
    PRIMARY KEY(email) -- REFERENCES (ParticipatesIn.user, Recruiter.email)
);
    
CREATE TABLE Recruiter( email varchar(50) not null,

    PRIMARY KEY(email) REFERENCES (User.email),
    FOREIGN KEY (email) REFERENCES (User.email)
);

CREATE TABLE Interview( recruiter varchar(50) not null,
	schedueled date,
    
    PRIMARY KEY (recruiter) REFERENCES (Recruiter.email),
    FOREIGN KEY (recruiter) REFERENCES (Recruiter.email),
    PRIMARY KEY (schedueled), -- REFERENCES 
		-- (ParticipatesIn.schedueled, JobPost.schedueled)	
);
    
CREATE TABLE ParticipatesIn( recruiter varchar(50) not null,
	schedueled date,
    user varchar(50),
    
    PRIMARY KEY(recruiter) REFERENCES (Interview.recruiter),
    FOREIGN KEY(recruiter) REFERENCES (Interview.recruiter),
    PRIMARY KEY (schedueled) REFERENCES (Interview.schedueled),
    PRIMARY KEY (schedueled) REFERENCES (Interview.schedueled),
    FOREIGN KEY(user) REFERENCES (User.email),
	PRIMARY KEY(user) REFERENCES (User.email),

    -- FOREIGN KEY (recruiter, schedueled, user)
);
    
CREATE TABLE WorksIn( user varchar(50),
	position varchar(100),
    
    PRIMARY KEY(user) REFERENCES (User.email),
    FOREIGN KEY(user) REFERENCES (User.email),
    PRIMARY KEY (position) REFERENCES (Position.id),
    FOREIGN KEY (position) REFERENCES (Position.id),
    -- FOREIGN KEY (usee, position)
);
    
CREATE TABLE JobPost( id Integer, 
	position varchar(100),
    minsalary Integer,
    maxsalary Integer,
    description varchar(450),
    active Bool(default=true),
    recruiter varchar(50),
    schedueled date,
    company varchar(50),
    
    PRIMARY KEY (id),
    FOREIGN KEY (recruiter),
    FOREIGN KEY (schedueled) REFERENCES (Interview.schedueled),
    FOREIGN KEY (company) REFERENCES (Company.id)
);
    
CREATE TABLE Position( id Integer,
	initD date,
    endD date,
    title varchar(50),
    company varchar(50),
    
    PRIMARY KEY (id),
    FOREIGN KEY (company) REFERENCES (Company.id)
);
    
CREATE TABLE Company(id Integer,
	cname varchar(100)
    
    PRIMARY KEY (id)
);
    
CREATE TABLE BranchesInto( main varchar(100),
	branch varchar(100)
    
    PRIMARY KEY(main, branch) REFERENCES (Company.id),
    FOREIGN KEY( main, branch)  REFERENCES (Company.id)
);