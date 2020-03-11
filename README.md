# Filmdatabase


### SQL
Sørg for at du har [MySQL Server](https://dev.mysql.com/downloads/mysql/). Installer og sett passordet til "password".

I SQL-mappen finnes det `to script som må kjøres i [MySQL Workbench](https://www.mysql.com/products/workbench/):
- `DB_init.sql` oppretter alle tabellene og relasjonene.
- `Populate.sql` fyller databasen med test-data. Merk at dataen har id'er fra 1 til 3. 


### Java
Per nå er det noe uvisst om vi trenger klassene i `Entities/`, men la det ligge enn så lenge.

Usecasene/spørringene skrives i `Queries.java`. Her er første usecase løst, og resten burde gå greit å implementere, - er bare SQL-spørringer.
Print resultatene inni funksjonen, - se hvordan den over er løst.

Meny-systemet ligger i `FilmDatabase.java`, og implementeres til slutt. Test Likevel queriene her, - se på eksempelet.