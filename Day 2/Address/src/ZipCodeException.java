public class ZipCodeException extends RuntimeException {

    public ZipCodeException() {
        super("Invalid zip code! The zip code must be with 5 or 9 digits!");
    }
}
