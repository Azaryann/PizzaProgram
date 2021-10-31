package domain;

import enums.PizzaIngredient;
import enums.PizzaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pizza {

    private long id;
    private String name;
    private List<PizzaIngredient> ingredientList = new ArrayList<>();
    private PizzaType type;
    private int quantity;
    private final int price = 1;

    public Pizza() {
    }

    public Pizza(String name, List<PizzaIngredient> ingredientList, PizzaType type, int quantity) {
        this.name = name;
        this.ingredientList = ingredientList;
        this.type = type;
        this.quantity = quantity;
    }

    public Pizza(String name, PizzaType type, int quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PizzaIngredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<PizzaIngredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public PizzaType getType() {
        return type;
    }

    public void setType(PizzaType type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return quantity == pizza.quantity && Objects.equals(name, pizza.name) && Objects.equals(ingredientList, pizza.ingredientList) && type == pizza.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ingredientList, type, quantity);
    }
}
