package Excepciones;

/**
 * Indica que no se ha podido crear una comida por alg&uacute;n motivo.
 */
public class NoComidaException extends RuntimeException{

    /**
     * Crea una excepci&oacute;n del tipo {@code NoComidaException} sin mensaje de error.
     */
    public NoComidaException(){
        super();
    }

    /**
     * Crea una excepci&oacute;n del tipo {@code NoComidaException} con un mensaje de error personalizado.
     * @param mensaje Mensaje donde se indica el error que ha causado la excepci&oacute;n.
     */
    public NoComidaException(String mensaje){
        super(mensaje);
    }

}
