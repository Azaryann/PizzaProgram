package enums;

public enum PizzaBase {

    CALZONE(1.5),
    BASE(1);

    public final double value;

    PizzaBase(double value) {
        this.value = value;
    }

}