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

INSERT INTO Sjanger (SjangerID, Sjanger)
VALUES ('4', 'Drama');

# Selskap
INSERT INTO Selskap (SelskapID, Navn, URL, Land, Addresse)
VALUES ('1', 'Det Norske Selskab', 'https://www.norskeselskab.no/', 'Norway', 'Norway Avenue 1');

INSERT INTO Selskap (SelskapID, Navn, URL, Land, Addresse)
VALUES ('2', 'Knowit', 'https://www.knowit.no/', 'Norway', 'Lakkegata 53');

INSERT INTO Selskap (SelskapID, Navn, URL, Land, Addresse)
VALUES ('3', 'Bouvet', 'https://www.bouvet.no/', 'Norway', 'Sørkedalsveien 8');

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
VALUES ('1', '1');

INSERT INTO Sesong (Nummer, SerieID)
VALUES ('2', '2');

INSERT INTO Sesong (Nummer, SerieID)
VALUES ('3', '3');

# Media
INSERT INTO Media (MediaID, Tittel, Utgivelsesår, Lanseringsdato, Beskrivelse, Lengde, SelskapID)
VALUES ('1', 'The Good the Bad and the Zugly', '1998', '1997-01-01', 'Kinda long', '3', '1');

INSERT INTO Media (MediaID, Tittel, Utgivelsesår, Lanseringsdato, Beskrivelse, Lengde, SelskapID)
VALUES ('2', 'Behemoth', '2000', '1990-05-03', 'The movie about the band', '2', '2');

INSERT INTO Media (MediaID, Tittel, Utgivelsesår, Lanseringsdato, Beskrivelse, Lengde, SelskapID)
VALUES ('3', 'Transformers', '2010', '2009-06-11', 'The one about robots', '2', '3');

# Anmeldelse
INSERT INTO Anmeldelse (AnmeldelseID, Tekst, Rating, BrukerID, MediaID)
VALUES ('1', 'Good movie, I like it.', '10', '1', '1');

INSERT INTO Anmeldelse (AnmeldelseID, Tekst, Rating, BrukerID, MediaID)
VALUES ('2', 'Meeh, seen better', '7', '2', '2');

INSERT INTO Anmeldelse (AnmeldelseID, Tekst, Rating, BrukerID, MediaID)
VALUES ('3', 'This series made me depressed...', '2', '3', '3');

INSERT INTO Anmeldelse (AnmeldelseID, Tekst, Rating, BrukerID, MediaID)
VALUES ('4', 'Oh well, ok', '3', '1', '2');

INSERT INTO Anmeldelse (AnmeldelseID, Tekst, Rating, BrukerID, MediaID)
VALUES ('5', 'Lol very nice yes yes', '5', '1', '3');

# SkuespillerI
INSERT INTO SkuespillerI (Fnr, MediaID, Rolle)
VALUES ('1', '1', 'Papa John');

INSERT INTO SkuespillerI (Fnr, MediaID, Rolle)
VALUES ('2', '2', 'Lucky Luke');

INSERT INTO SkuespillerI (Fnr, MediaID, Rolle)
VALUES ('3', '3', 'Luke Smith');

INSERT INTO SkuespillerI (Fnr, MediaID, Rolle)
VALUES ('1', '2', 'Billy Bob');

INSERT INTO SkuespillerI (Fnr, MediaID, Rolle)
VALUES ('1', '3', 'Zohan');

# SkrevetAv
INSERT INTO SkrevetAv (Fnr, MediaID)
VALUES ('1', '1');

INSERT INTO SkrevetAv (Fnr, MediaID)
VALUES ('2', '2');

INSERT INTO SkrevetAv (Fnr, MediaID)
VALUES ('3', '3');

# RegiAv
INSERT INTO RegiAv (Fnr, MediaID)
VALUES ('1', '1');

INSERT INTO RegiAv (Fnr, MediaID)
VALUES ('2', '2');

INSERT INTO RegiAv (Fnr, MediaID)
VALUES ('3', '3');

# Komponert
INSERT INTO Komponert (Fnr, MusikkID)
VALUES ('1', '1');

INSERT INTO Komponert (Fnr, MusikkID)
VALUES ('2', '2');

INSERT INTO Komponert (Fnr, MusikkID)
VALUES ('3', '3');

# MusikkIMedia
INSERT INTO MusikkIMedia (MusikkID ,MediaID)
VALUES ('1', '1');

INSERT INTO MusikkIMedia (MusikkID ,MediaID)
VALUES ('2', '2');

INSERT INTO MusikkIMedia (MusikkID ,MediaID)
VALUES ('3', '3');

# EpisodeI
INSERT INTO EpisodeI (MediaID, Nummer)
VALUES ('1', '1');

INSERT INTO EpisodeI (MediaID, Nummer)
VALUES ('2', '2');

INSERT INTO EpisodeI (MediaID, Nummer)
VALUES ('3', '3');

# HarSjanger
INSERT INTO HarSjanger (SjangerID, MediaID)
VALUES ('1', '1');

INSERT INTO HarSjanger (SjangerID, MediaID)
VALUES ('2', '2');

INSERT INTO HarSjanger (SjangerID, MediaID)
VALUES ('2', '3');

INSERT INTO HarSjanger (SjangerID, MediaID)
VALUES ('3', '3');

INSERT INTO HarSjanger (SjangerID, MediaID)
VALUES ('3', '2');

INSERT INTO HarSjanger (SjangerID, MediaID)
VALUES ('1', '2');

INSERT INTO HarSjanger (SjangerID, MediaID)
VALUES ('4', '3');


# EierAvMedia
INSERT INTO EierAvMedia (SelskapID, MediaID)
VALUES ('1', '1');

INSERT INTO EierAvMedia (SelskapID, MediaID)
VALUES ('1', '2');

INSERT INTO EierAvMedia (SelskapID, MediaID)
VALUES ('1', '3');

INSERT INTO EierAvMedia (SelskapID, MediaID)
VALUES ('2', '1');

INSERT INTO EierAvMedia (SelskapID, MediaID)
VALUES ('2', '3');

INSERT INTO EierAvMedia (SelskapID, MediaID)
VALUES ('3', '1');

INSERT INTO EierAvMedia (SelskapID, MediaID)
VALUES ('3', '2');
