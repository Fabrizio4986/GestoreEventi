import java.time.LocalDate;

public class GestoreEventi {
    private static Evento[] eventi = new Evento[100];
    private static int count = 0;

    public static void aggiungiEvento(Evento e) {
        if (count < 100) {
            eventi[count] = e;
            count++;
        } else throw new ArrayIndexOutOfBoundsException("Hai raggiunto il numero massimo di eventi (100)");
    }

    public static Evento[] cercaPerData(LocalDate data) {
        Evento[] listaEventi = new Evento[count];
        for (Evento ev : eventi) {
            if (ev != null) {
                if (ev.getData().compareTo(data) == 0) {
                    for (int i = 0; i <= listaEventi.length; i++) {
                        if (listaEventi[i] == null) {
                            listaEventi[i] = ev;
                            break;
                        } else continue;
                    }
                }
            } else return listaEventi;
        }
        return listaEventi;
    }

    public static Evento[] cercaPerTipo(TipoEvento tipo) {
        Evento[] listaEventi = new Evento[count];
        for (Evento ev : eventi) {
            if (ev != null) {
                if (ev.getTipo() == tipo) {
                    for (int i = 0; i <= listaEventi.length; i++) {
                        if (listaEventi[i] == null) {
                            listaEventi[i] = ev;
                            break;
                        } else continue;
                    }
                }
            } else return listaEventi;
        }
        return listaEventi;
    }

    public static void stampaEventi() {
        for (Evento evento : eventi) {
            if (evento != null) {
                evento.stampaInfo();
            } else break;
        }
    }
    public static void stampaEventi(Evento[] lista) {
        for (Evento evento : lista) {
            if (evento != null) {
                evento.stampaInfo();
            } else break;
        }
    }

}



