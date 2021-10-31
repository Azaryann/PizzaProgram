package domain;

import enums.PizzaIngredient;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class Order {

    private long id;
    private int customerNumber;
    private List<Pizza> pizzas;
    private LocalTime orderTime;
    private int quantity;
    private double price;
    private List<Pizza> pizza;
    private List<PizzaIngredient> pizzaIngredients;

    public Order() {
    }

    public Order(long id, int customerNumber, List<Pizza> pizzas, LocalTime orderTime, int quantity,
                 double price, List<Pizza> pizza, List<PizzaIngredient> pizzaIngredients) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.pizzas = pizzas;
        this.orderTime = orderTime;
        this.quantity = quantity;
        this.price = price;
        this.pizza = pizza;
        this.pizzaIngredients = pizzaIngredients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Pizza> getPizza() {
        return pizza;
    }

    public void setPizza(List<Pizza> pizza) {
        this.pizza = pizza;
    }

    public List<PizzaIngredient> getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void setPizzaIngredients(List<PizzaIngredient> pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    public String addIngredient(Pizza pizza, PizzaIngredient ingredient) {
        validation(pizza);
        if (pizza.getName() == null) {
            return "Pizza with " + pizza.getName() + " not found";
        }
        if (pizza.getIngredientList().size() == 7) {
            return "Your ingredients are full";
        }
        if (pizza.getIngredientList().contains(ingredient)) {
            return "Your Pizza already contains that ingredient";
        } else {
            pizza.getIngredientList().add(ingredient);
        }
        return "Ingredient added in pizza";
    }

    private void validation(Pizza pizza) {
        if (pizza.getName().toCharArray().length >= 4 && pizza.getName().toCharArray().length <= 20) {
            if (!pizza.getName().matches("^[A-Za-z]+$")) {
                pizza.setName("_" + pizza.getId());
            }
            pizzas.add(pizza);
        }
    }

    public String printCheck(Order order) {
        double totalAmount = 0;
        for (Pizza pizzas : order.getPizzas()) {
            double amount = 0;

            for (PizzaIngredient ingredient : pizzas.getIngredientList()) {
                amount += ingredient.getValue();
            }

            totalAmount += amount * pizzas.getQuantity();
        }

        return String.valueOf(totalAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && customerNumber == order.customerNumber && quantity == order.quantity && Double.compare(order.price, price) == 0 && Objects.equals(pizzas, order.pizzas) && Objects.equals(orderTime, order.orderTime) && Objects.equals(pizza, order.pizza) && Objects.equals(pizzaIngredients, order.pizzaIngredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerNumber, pizzas, orderTime, quantity, price, pizza, pizzaIngredients);
    }
}
