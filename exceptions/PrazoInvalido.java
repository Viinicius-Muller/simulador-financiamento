package exceptions;

public class PrazoInvalido extends RuntimeException {
    public PrazoInvalido(String message) {
        super(message);
    }
}
