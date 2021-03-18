# Esame Programmazione ad Oggetti
Sono chiamate di tipo get da effettuare in postman:

http://localhost:8083/forecast?country=hu&city=B*
- Presenta i dati senza salvarli in tempo reale.

http://localhost:8083/forecast/statistics?start=2021-03-0100:00:00&end=2021-03-1823:59:59&country=it&city=Rome,Ancona
- Offre le statistiche dei dati salvati nel database.

http://localhost:8083/forecast/lookup/secret/?sleep=1&type=minutes&country=it&city=Ancona,Bologna,Torino,Jesi,Macerata,San*,Morovalle,Civi*
- Scarica in modo automatico i dati da [Openweather](https://openweathermap.org/) ogni tot di tempo (nel nostro caso ogni 5 ore, basta modificare il parametro)

http://localhost:8083/forecast/lookup/secret/stop
- Ferma il salvataggio automatico (thread). Secret deve essere una password salvata nell’application properties.

http://localhost:8083/forecast/seed/secret/?sleep=1&type=seconds&country=it&city=*
http://localhost:8083/forecast/seed/secret/stop
- Popola il database con elementi random per poter effettuare le richieste, su un database locale abbiamo salvato per un anno tutte le informazioni riguardanti le città italiane ogni 5 ore ottenendo oltre 17 milioni di righe.

http://localhost:8083/cities?country=it&city=Ancona
- Legge la lista delle città salvate nel database.

http://localhost:8083/cities/load/secret
- Carica le città del mondo da un file JSON messo a disposizione da Openweather.

http://localhost:8083/cities/stop/secret
- Ferma il thread che carica le città dal file JSON.


- Le tabelle si creano automaticamente nel caso in cui non fossero presenti nel computer.
 Nelle ricerche si possono precisare più paesi e più città, separate dalla virgola. Inoltre si possono usare i seguenti caratteri sostitutivi:
 * “!” sostituisce un carattere nella parola (stringa);
 * “*” sostituisce uno o più caratteri nella riga.

- Il database usato è _MariaDB_ e i parametri di connessione vanno impostati nel file “application.properties”.

- Nel file sono presenti anche delle linee di codice per controllare le eccezioni che possono verificarsi.
