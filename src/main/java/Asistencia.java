
public class Asistencia{

    private Invitable participante;         //asosiacion dirigida hacia Empleado en el UML, AGREGADO EXTRA

    public Asistencia(Invitable participante){     //constructor
        this.participante = participante;
    }


    public Invitable getParticipante(){        //getter, AGREGADO EXTRA
        return participante;
    }

    public void setParticipante(Invitable participante){       //setter, AGREGADO EXTRA
        this.participante = participante;
    }


    @Override
    public String toString() {      //toString que se pide por enunciado
        return "Asistencia {" +
                "participante=" + (participante != null ? participante.toString() : "null") +
                '}';
    }
}


//todo lo que tenga un "AGREGADO EXTRA" hay que especificalo dpues en el UML
//esta clase está hecha solo para q se pueda tener conocimiento de los q fueron o no fueron a la reunion