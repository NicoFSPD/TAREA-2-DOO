
public enum tipoReunion {

    TECNICA("Tecnica"),
    MARKETING("Marketing"),
    OTRO("Otro");


    private final String tipo;


    tipoReunion(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}