package Excepciones;

public class NoComidaException extends RuntimeException{

    public NoComidaException(){
        super("No se ha podido elegir ninguna comida porque no había ninguna elegible. Esto puede deberse a que " +
                "las restricciones han anulado a las comidas permitidas.");
    }


}
