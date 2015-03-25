# Come compilare il PRBM #
La compilazione del PRBM è un processo piuttosto semplice e che non dovrebbe impensierire nessuno sviluppatore Java, ma si è pensato che automatizzare tale processo e soprattutto dare uno strumento semplice per crearne una versione installabile ed eseguibile potesse facilitare chi volesse avvicinarsi al progetto per dare il proprio contributo.

## Strumenti di gestione delle fasi di build ##
Per la gestione delle fasi di build del programma viene fornito all'interno del pacchetto dei sorgenti il file _build.xml_ da usare con [Ant](http://ant.apache.org/) che è lo strumento di riferimento per i progetti Java.

Per chi non lo conoscesse, Ant e' uno strumento scritto in Java per automatizzare i processi di compilazione e di deploy di progetti software in genere nato per superare (ndr. e in molti casi ci è riuscito) alcuni limiti dei tool esistenti come _make_, _gnumake_, _nmake_, etc (vedi [il manuale di Ant](http://ant.apache.org/manual/index.html)).

## Target previsti ##
Per ora sono stati previsti i _target_ essenziali e che per la tipologia di progetto saranno probabilmente gli unici a dover essere descritti.
  * **prepare**: prepara l'ambiente di compilazione;
  * _**compile**_: compila il codice sorgente;
  * **dist**: genera la distribuzione;
  * **clean**: ripulisce le directory di compilazione e di distribuzione.
Il _target_ **compile** è quello che viene eseguito di default se non ne viene specificato uno in particolare.

## Come costruirsi il PRBM dai sorgenti ##
### Prerequisiti ###
  * Java SDK >= 1.4.x
  * Ant >= 1.5.x
### Passo passo ###
  1. Fare un check-out completo dei sorgenti dal repository in una propria directory sul disco (vedi [Repository](Repository.md));
> 2. Andare nella directory dove avete effettuato il ckeck-out e lanciare il comando (il parametro **compile** non sarebbe necessario poiché e' il _target_ di default:
```
$ ant compile
```
> > Ora all'interno della directory _build_ c'è tutto il programma compilato. Il programma così compilato è già pronto per essere eseguito ma se si vuole avere un pacchetto più compatto per la distribuzione, passare al prossimo punto.

> 3. Rimanendo nella directory di check-out, lanciare il comando:
```
$ ant dist
```
> > Ora all'interno della directory _dist_ c'è il programma pronto per essere eseguito o zippato e distibuito.