package trapesium.oop;

// Custom Unchecked Exception untuk menangani error validasi geometri Trapesium.
// Mewarisi RuntimeException sehingga tidak wajib dideklarasikan dengan 'throws'. 

public class TrapesiumNotValidException extends RuntimeException {

    public TrapesiumNotValidException(String vMessage) {
        super(vMessage);
    }

}