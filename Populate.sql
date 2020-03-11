USE FilmDB;

# Person
INSERT INTO Person (Fnr, Navn, Tlf, Fødselsår, Fødselsland)
VALUES ('')

# Musikk
INSERT INTO Musikk (MusikkID, Tittel)
VALUES ('')

# Sjanger
INSERT INTO Sjanger (SjangerID, Sjanger)
VALUES ('')

# Selskap
INSERT INTO Selskap (SelskapID, URL, Land, Addresse)
VALUES ('')

# Bruker
INSERT INTO Bruker (BrukerID, Brukernavn)
VALUES ('')

# Serie
INSERT INTO Serie (SerieID, Tittel)
VALUES ('')

# Sesong
INSERT INTO Sesong (Nummer, SerieID)
VALUES ('1', '1')
INSERT INTO Sesong (Nummer, SerieID)
VALUES ('2', '2')
INSERT INTO Sesong (Nummer, SerieID)
VALUES ('3', '3')

# Media
INSERT INTO Media (MediaID, Tittel, Utgivelsesår, Lanseringsdato, Beskrivelse, Lengde, SelskapID)
VALUES ('1', 'The Good the Bad and the Zugly', '1998', '1997', 'Kinda long', '3', '1')
INSERT INTO Media (MediaID, Tittel, Utgivelsesår, Lanseringsdato, Beskrivelse, Lengde, SelskapID)
VALUES ('2', 'Behemoth', '2000', '1990', 'The movie about the band', '2', '2')
INSERT INTO Media (MediaID, Tittel, Utgivelsesår, Lanseringsdato, Beskrivelse, Lengde, SelskapID)
VALUES ('3', 'Transformers', '2010', '2009', 'The one about robots', '2', '3')

# Anmeldelse
INSERT INTO Anmeldelse (AnmeldelseID, Tekst, Rating, BrukerID, MediaID, Nummer, SerieID)
VALUES ('1', 'Good movie, I like it.', '10', '1', '1')
INSERT INTO Anmeldelse (AnmeldelseID, Tekst, Rating, BrukerID, MediaID, Nummer, SerieID)
VALUES ('2', 'Meeh, seen better', '7', '2', '2')
INSERT INTO Anmeldelse (AnmeldelseID, Tekst, Rating, BrukerID, MediaID, Nummer, SerieID)
VALUES ('3', 'This series made me depressed...', '2', '3', '3')

# SkuespillerI
INSERT INTO SkuespillerI (Fnr, MediaID, Rolle)
VALUES ('1', '1', 'Papa John')
INSERT INTO SkuespillerI (Fnr, MediaID, Rolle)
VALUES ('2', '2', 'Lucky Luke')
INSERT INTO SkuespillerI (Fnr, MediaID, Rolle)
VALUES ('3', '3', 'Luke Smith')

# SkrevetAv
INSERT INTO SkrevetAv (Fnr, MediaID)
VALUES ('1', '1')
INSERT INTO SkrevetAv (Fnr, MediaID)
VALUES ('2', '2')
INSERT INTO SkrevetAv (Fnr, MediaID)
VALUES ('3', '3')

# RegiAv
INSERT INTO RegiAv (Fnr, MediaID)
VALUES ('1', '1')
INSERT INTO RegiAv (Fnr, MediaID)
VALUES ('2', '2')
INSERT INTO RegiAv (Fnr, MediaID)
VALUES ('3', '3')

# Komponert
INSERT INTO Komponert (Fnr, MusikkID)
VALUES ('1', '1')
INSERT INTO Komponert (Fnr, MusikkID)
VALUES ('2', '2')
INSERT INTO Komponert (Fnr, MusikkID)
VALUES ('3', '3')

# MusikkIMedia
INSERT INTO MusikkIMedia (MusikkID ,MediaID)
VALUES ('1', '1')
INSERT INTO MusikkIMedia (MusikkID ,MediaID)
VALUES ('2', '2')
INSERT INTO MusikkIMedia (MusikkID ,MediaID)
VALUES ('3', '3')

# EpisodeI
INSERT INTO EpisodeI (MediaID, Nummer)
VALUES ('1', '1')
INSERT INTO EpisodeI (MediaID, Nummer)
VALUES ('2', '2')
INSERT INTO EpisodeI (MediaID, Nummer)
VALUES ('3', '3')
