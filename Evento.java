import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String nome;
    private LocalDate data;
    private TipoEvento tipo;
    private String codice;
    private final String EVT = "EVT";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMMdd");

    public Evento (String nome, String data, TipoEvento tipo) {
        if ( nome == null || nome.isEmpty() ) {
            throw new IllegalArgumentException("Il nome non può essere nullo o una stringa vuota");
        } else {
            this.nome = nome;
        }
        LocalDate date = LocalDate.parse(data, formatter);
        if(validaData(date)) {
            this.data = date;
        } else {
            throw new DateTimeException("La data non può essere antecedente ad oggi");
        }
        this.tipo = tipo;
        this.codice = generaCodice(date);
    }

    private String generaCodice(LocalDate data){
        int nnn = (int) Math.random() * (999 - 100 + 1) + 100;
        String dataCod = data.format(formatter2);
        String codice = EVT + "-" + dataCod + "-" + nnn;
        return codice;
    }

    private boolean validaData (LocalDate data) {
        boolean isValid = false;
        LocalDate oggi = LocalDate.now();
        if (data.isBefore(oggi)) {
            return isValid;
        } else {
            isValid = true;
        }
        return isValid;
    }

    public void stampaInfo() {
        System.out.print("Nome evento: " + nome + ", Data: " + data.format(formatter) + ", tipo: " + tipo + ", codice: " + codice + ".");
    }
}
