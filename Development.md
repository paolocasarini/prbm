# Come sviluppare PRBM #
L'applicazione _prbm_ è scritta completamenta in Java e non ci sono particolari indicazioni per poter iniziare a sviluppare l'applicazione: qualsiasi editor può andare bene anche perchè nel pacchetto viene fornito il file per la compilazione tramite Ant (vedere [Compilazione](Build.md)).

Nel repository sono però versionati i file di progetto di [eclispe](http://www.eclipse.org/), IDE molto valido per lo sviluppo in Java che tra l'altro e' OpenSource. Chi decidesse quindi di usare questo IDE e' avvantaggiato e anzi ne viene consigliato l'uso.

## Importare i sorgenti in un progetto Eclipse ##
Per rendere ancora più semplice incominciare a sviluppare e dare il proprio contributo, di seguito sono elencati i passi che servono per recuperare i sorgenti dell'applicazione dal repository dall'interno di [eclispe](http://www.eclipse.org/) e importare il progetto relativo nel proprio ''workspace''.

  1. Come prima cosa bisogna installare in eclpise il plug-in _subclipse_ che permette di utilizzare l'interfaccia per il lavoro in team su un repository _Subversion_.
  1. Poi bisogna configurare la _SVN Repository perspective_ appena aggiunta in modo da vedere il repository del _prbm_ e da li importare il progetto nel proprio workspace.