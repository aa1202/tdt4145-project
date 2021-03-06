CREATE DATABASE FilmDB;
USE FilmDB;

CREATE TABLE Person (
	Fnr INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (Fnr),
    Navn VARCHAR(100),
    Tlf INT(8),
    Fødselsår YEAR,
    Fødselsland VARCHAR(100)
);

CREATE TABLE Musikk (
	MusikkID INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (MusikkID),
    Tittel VARCHAR(100)
);

CREATE TABLE Sjanger (
	SjangerID INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (SjangerID),
    Sjanger VARCHAR(100)
);

CREATE TABLE Selskap (
	SelskapID INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (SelskapID),

    Navn VARCHAR(100),
    URL VARCHAR(100),
    Land VARCHAR(100),
    Addresse VARCHAR(100)
);

CREATE TABLE Bruker (
	BrukerID INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (BrukerID),
    Brukernavn VARCHAR(100)
);

CREATE TABLE Serie (
	SerieID INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (SerieID),
    Tittel VARCHAR(100)
);

CREATE TABLE Sesong (
	Nummer INT,
    SerieID INT,
	FOREIGN KEY (SerieID)
		REFERENCES Serie (SerieID)
		ON DELETE CASCADE,
        
	PRIMARY KEY (Nummer, SerieID)
);

CREATE TABLE Media (
	MediaID INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (MediaID),
    Tittel VARCHAR(100),
    Utgivelsesår YEAR,
    Lanseringsdato DATE,
    Beskrivelse VARCHAR(255),
    Lengde INT,
    
    SelskapID INT,
    FOREIGN KEY (SelskapID) 
		REFERENCES Selskap (SelskapID) 
		ON DELETE CASCADE
);

CREATE TABLE Anmeldelse (
	AnmeldelseID INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (AnmeldelseID),
    Tekst VARCHAR(255),
    Rating INT,
    
    BrukerID INT,
    FOREIGN KEY BrukerID (BrukerID)
		REFERENCES Bruker (BrukerID)
        ON DELETE CASCADE,
	
    MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
        ON DELETE CASCADE,
	
    Nummer INT,
	
    SerieID INT,
	FOREIGN KEY (SerieID)
		REFERENCES Serie (SerieID)
        ON DELETE CASCADE
);


# Relations
CREATE TABLE SkuespillerI (
	Fnr INT,
	FOREIGN KEY (Fnr)
		REFERENCES Person (Fnr)
		ON DELETE CASCADE,
	
    MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
		ON DELETE CASCADE,
        
	Rolle VARCHAR(100)
);

CREATE TABLE SkrevetAv (
	Fnr INT,
	FOREIGN KEY (Fnr)
		REFERENCES Person (Fnr)
		ON DELETE CASCADE,
        
	MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
		ON DELETE CASCADE
);

CREATE TABLE RegiAv (
	Fnr INT,
	FOREIGN KEY (Fnr)
		REFERENCES Person (Fnr)
		ON DELETE CASCADE,
	
    MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
		ON DELETE CASCADE
);

CREATE TABLE Komponert (
	Fnr INT,
	FOREIGN KEY (Fnr)
		REFERENCES Person (Fnr)
		ON DELETE CASCADE,
	
    MusikkID INT,
	FOREIGN KEY (MusikkID)
		REFERENCES Musikk (MusikkID)
		ON DELETE CASCADE
);

CREATE TABLE MusikkIMedia (
	MusikkID INT,
	FOREIGN KEY (MusikkID)
		REFERENCES Musikk (MusikkID)
        ON DELETE CASCADE,
        
	MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
        ON DELETE CASCADE
);

CREATE TABLE EpisodeI (
	MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
        ON DELETE CASCADE,
	
    Nummer INT,
	FOREIGN KEY (Nummer)
		REFERENCES Sesong (Nummer)
        ON DELETE CASCADE
);

CREATE TABLE EierAvMedia (
	SelskapID int,
    FOREIGN KEY (SelskapID)
		REFERENCES Selskap (SelskapID)
        ON DELETE CASCADE,
        
	MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
        ON DELETE CASCADE
);

CREATE TABLE HarSjanger (
	SjangerID int,
    FOREIGN KEY (SjangerID)
		REFERENCES Sjanger (SjangerID)
        ON DELETE CASCADE,
        
	MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
        ON DELETE CASCADE
);