package application.models.base;

public class CUID {
    private String value;

    private CUID(String value) {
        this.value = value;
    }

    public static CUID randomCUID1() {
        return new CUID(io.github.thibaultmeyer.cuid.CUID.randomCUID1().toString());
    }

    public static CUID fromString(String value) {
        return new CUID(value);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
