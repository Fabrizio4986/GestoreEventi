import java.time.DateTimeException;
import java.time.LocalDate;
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

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    private String generaCodice(LocalDate data){
        int nnn = (int) (Math.random() * (999 - 100 + 1)) + 100;
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
        System.out.println("Nome evento: " + nome + ", Data: " + data.format(formatter) + ", tipo: " + tipo + ", codice: " + codice + ".");
    }

    public void formattaNome() {
        StringBuilder nomeTitleCase = convertToTitleCase(nome);
        if (nomeTitleCase.length() >= 50) {
            nomeTitleCase.replace(49,nomeTitleCase.length() , "...");
            this.nome = nomeTitleCase.toString();
        } else {
            this.nome = nomeTitleCase.toString();
        }
    }

    public static StringBuilder convertToTitleCase(String text) {
        if (text == null || text.isEmpty()) {
            return new StringBuilder(text);
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted;
    }
}
