import java.time.LocalDate;

public class Main {
    public static void main (String[] args){
        Evento derby = new Evento("roma - lazio ma lungo lungo lungoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo","13/04/2025",TipoEvento.SPORT);
        derby.formattaNome();
        derby.stampaInfo();
        LocalDate data = derby.getData();
        Evento provaA = new Evento("prova A","13/04/2025",TipoEvento.CONFERENZA);
        Evento provaB = new Evento("prova B","13/04/2025",TipoEvento.CONFERENZA);
        Evento provaC = new Evento("prova c","20/04/2025",TipoEvento.WORKSHOP);
        Evento provaD = new Evento("prova d","13/04/2025",TipoEvento.SPORT);
        provaA.formattaNome();
        provaB.formattaNome();
        provaC.formattaNome();
        provaD.formattaNome();
        System.out.println("Lista stampa eventi singolarmente");
        provaA.stampaInfo();
        provaB.stampaInfo();
        provaC.stampaInfo();
        provaD.stampaInfo();
        System.out.println("--------------------------------");
        GestoreEventi.aggiungiEvento(derby);
        GestoreEventi.aggiungiEvento(provaA);
        GestoreEventi.aggiungiEvento(provaB);
        GestoreEventi.aggiungiEvento(provaC);
        GestoreEventi.aggiungiEvento(provaD);
        System.out.println("Prova metodi stampaEventi e cercaPerData");
        Evento[] listaEvPerData = GestoreEventi.cercaPerData(data);
        GestoreEventi.stampaEventi(listaEvPerData);
//        System.out.println(derby.getData() == provaB.getData());
//        System.out.println(derby.getData());
//        System.out.println(provaB.getData());
//        System.out.println(derby.getData().compareTo(provaB.getData()));
        System.out.println("Prova metodi stampaEventi e cercaPerTipo");
        Evento[] listaEvPerTipo = GestoreEventi.cercaPerTipo(TipoEvento.CONFERENZA);
        GestoreEventi.stampaEventi(listaEvPerTipo);
    }
}
