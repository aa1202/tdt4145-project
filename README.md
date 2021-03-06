# Filmdatabase

## SQL
Sørg for at du har [MySQL Server](https://dev.mysql.com/downloads/mysql/). Installer og sett passordet til "password".

I `SQL-mappen` finnes det `to` script som må kjøres i [MySQL Workbench](https://www.mysql.com/products/workbench/):
- `DB_init.sql` oppretter databasen, alle tabellene samt relasjonene.
- `Populate.sql` fyller databasen med test-data.

### Possible relevant pre-made data:

**Person:**  

| Navn              | Tlf      | Fødselsår | Fødselsland |
| :-----------------: | :--------: | :---------: | :-----------: |
| Ola Halvorsen     | 97664587 | 1998      | Norge       |
| Preben Lohrengren | 67145633 | 1996      | Norge       |
| Ahre-Ketil        | 42013370 | 1988      | Norge       |



**Bruker:**  

| Brukernavn |
| :----------: |
| Lekesoldat |
| CarlOfHoly |
| DeepDap    |
| aa1202     |

**Media:**  

| Tittel                         | Utgivelsesår | Lanseringsdato | Beskrivelse              | Lengde | SelskapID |
|:------------------------------:|:-----------:|:-----------:|:----------------------:|:-----:|:-----:|
| The Good the Bad and the Zugly | 1998         | 1997-01-01     | Kinda long               | 3      | 1         |
| Behemoth                       | 2000         | 1990-05-03     | The movie about the band | 2      | 2         |
| Transformers                   | 2010         | 2009-06-11     | The one about the robots | 2      | 3         |

**Serie:**  

| Tittel        |
|:-------------:|
| Sex Education |
| Prison Break  |
| Covid-19      |

**Selskap:**  

| Navn               | URL                           | Land   | Addresse         |
|:---------------:|:---------------------------:|:----:|:-------------:|
| Det Norske Selskab | https://www.norskeselskab.no/ | Norway | Norway Avenue    |
| Knowit             | https://www.knowit.no/        | Norway | Lakkegata 53     |
| Bouvet             | https://www.bouvet.no/        | Norway | Sørkedalsveien 8 |

----

## Java

I `src/main/java/tdt4145.project` ligger følgende

**DBConn.java**:

Denne klassen tar for seg oppkobling mot databasen. Klassen er gjort abstrakt, slik at alle subklasser som arver den har tilgang til connectionen den oppretter. Databasen den kobler til er den som opprettes med `DB_init`-scriptet, nemlig `FilmDB`.

**FilmDatabase.java**:

Her håndteres hele brukerinteraksjonen. Gjennom et forholdsvis intuitivt tekstbasert brukergrensesnitt kan brukeren interagere med de ulike funksjonalitetene programmet tilbyr. 

*MERK*: Bruken av programmet forutsetter at en del input eksisterer i databasen fra før. Se over for en oversikt over hva som ligger inne fra start.

**Queries.java**:

Denne klassen tar seg av spørringene, gitt data som er sendt fra `FilmDatabase.java`.  
Usecasene er implementert i de følgende funksjonene:


Usecase 1: *fetchRolesForPerson(..)*  
Usecase 2: *fetchMoviesForPerson(..)*  
Usecase 3: *fetchTopCompaniesByGenres(..)*  
Usecase 4: *insertNewMovie(..)*  
Usecase 5: *insertNewMediaReview(..)*, *insertNewSeriesReview(..)* og *insertNewSeasonReview(..)*. Funksjon velges basert på brukerinput.

## Navigering av filmdatabasen

Når man kjører applikasjonen blir man presentert med 6 valg. Valg 1-5 dekker usecasene ovenfor, mens valg 6 printer informasjonen på nytt. For å avslutte applikasjonen skriver man inn hvilket som helst annet tall. *NB* Hvis man skriver inne noe annet enn et tall her vil man få en error-kode og applikasjonen avsluttes på den måten.

De fleste av valgene er relativt intuitive og man kan følge instruksjonene på skjermen. Valg 4 er noe annerledes fra de andre. For hver forespørsel skal man skrive hele linjen med hvert felt separert med komma. Eksempelvis for `film`: 
```
Forrest Gump, 1990, 1990-01-01, Movie about Forrest Gump, 210, Knowit
```


## Kommentar til leveranse
Gruppen vurderte det til at å lage videre spørringer utover usecasene var overflødig. Vi mener funksjonaliteten som allerede er implementerer, dekker og beviser høy måloppnåelse. Grunnet NTNUs vurdering av corona-viruset var det heller ikke anledning til biståelse fra læringsassist, som resulterte i at tiden ikke strakk til for videre spørringer.
