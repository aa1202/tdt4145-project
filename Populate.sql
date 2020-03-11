USE FilmDB;

# Person
INSERT INTO Person (Fnr, Navn, Tlf, Fødselsår, Fødselsland)
VALUES ('1', 'Ola Halvorsen', '97664587', '1998', 'Norge');

INSERT INTO Person (Fnr, Navn, Tlf, Fødselsår, Fødselsland)
VALUES ('2', 'Preben Lohrengren', '67145633', '1996', 'Norge');

INSERT INTO Person (Fnr, Navn, Tlf, Fødselsår, Fødselsland)
VALUES ('3', 'Ahre-Ketil', '42013370', '1988', 'Norge');

# Musikk
INSERT INTO Musikk (MusikkID, Tittel)
VALUES ('1', 'Haugenstua - Herman Flesvig');

INSERT INTO Musikk (MusikkID, Tittel)
VALUES ('2', 'Tokyo Drift - Teriyaki Boyz');

INSERT INTO Musikk (MusikkID, Tittel)
VALUES ('3', 'F**kin' 'Problems - A$AP Rocky');

# Sjanger
INSERT INTO Sjanger (SjangerID, Sjanger)
VALUES ('1', 'Action');

INSERT INTO Sjanger (SjangerID, Sjanger)
VALUES ('2', 'Comedy');

INSERT INTO Sjanger (SjangerID, Sjanger)
VALUES ('3', 'Romantic');

# Selskap
INSERT INTO Selskap (SelskapID, URL, Land, Addresse)
VALUES ('1', 'https://www.norskeselskab.no/', 'Norway', 'Norway Avenue 1');

INSERT INTO Selskap (SelskapID, URL, Land, Addresse)
VALUES ('2', 'https://www.knowit.no/', 'Norway', 'Lakkegata 53');

INSERT INTO Selskap (SelskapID, URL, Land, Addresse)
VALUES ('3', 'https://www.bouvet.no/', 'Norway', 'Sørkedalsveien 8');

# Bruker
INSERT INTO Bruker (BrukerID, Brukernavn)
VALUES ('1', 'Lekesoldat');

INSERT INTO Bruker (BrukerID, Brukernavn)
VALUES ('2', 'CarlOfHoly');

INSERT INTO Bruker (BrukerID, Brukernavn)
VALUES ('3', 'DeepDap');

INSERT INTO Bruker (BrukerID, Brukernavn)
VALUES ('4', 'aa1202');


# Serie
INSERT INTO Serie (SerieID, Tittel)
VALUES ('1', 'Sex Education');

INSERT INTO Serie (SerieID, Tittel)
VALUES ('2', 'Prison Break');

INSERT INTO Serie (SerieID, Tittel)
VALUES ('3', 'Covid-19');

# Sesong
INSERT INTO Sesong (Nummer, SerieID)
VALUES ('')

# Media
INSERT INTO Media (MediaID, Tittel, Utgivelsesår, Lanseringsdato, Beskrivelse, Lengde, SelskapID)
VALUES ('')

# Anmeldelse
INSERT INTO Anmeldelse (AnmeldelseID, Tekst, Rating, BrukerID, MediaID, Nummer, SerieID)
VALUES ('')

# SkuespillerI
INSERT INTO SkuespillerI (Fnr, MediaID, Rolle)
VALUES ('')

# SkrevetAv
INSERT INTO SkrevetAv (Fnr, MediaID)
VALUES ('')

# RegiAv
INSERT INTO RegiAv (Fnr, MediaID)
VALUES ('')

# Komponert
INSERT INTO Komponert (Fnr, MusikkID)
VALUES ('')

# MusikkIMedia
INSERT INTO MusikkIMedia (MusikkID ,MediaID)
VALUES ('')

# EpisodeI
INSERT INTO EpisodeI (MediaID, Nummer)
VALUES ('')