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