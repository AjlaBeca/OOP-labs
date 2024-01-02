package Week13;

import java.util.ArrayList;
import java.util.List;

class Coffee {
    private String type;
    private String size;
    private List<String> toppings;

    public Coffee() {
        this.toppings = new ArrayList<>();
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void addTopping(String topping) {
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}

interface CoffeeBuilder {
    void buildType();
    void buildSize();
    void buildToppings();
    Coffee getResult();
}

class EspressoBuilder implements CoffeeBuilder {
    private Coffee espresso = new Coffee();

    @Override
    public void buildType() {
        espresso.setType("Espresso");
    }

    @Override
    public void buildSize() {
        espresso.setSize("Small");
    }

    @Override
    public void buildToppings() {
        espresso.addTopping("Whipped Cream");
    }

    @Override
    public Coffee getResult() {
        return espresso;
    }
}

class LatteBuilder implements CoffeeBuilder {
    private Coffee latte = new Coffee();

    @Override
    public void buildType() {
        latte.setType("Latte");
    }

    @Override
    public void buildSize() {
        latte.setSize("Medium");
    }

    @Override
    public void buildToppings() {
        latte.addTopping("Caramel Drizzle");
    }

    @Override
    public Coffee getResult() {
        return latte;
    }
}

class CappuccinoBuilder implements CoffeeBuilder {
    private Coffee cappuccino = new Coffee();

    @Override
    public void buildType() {
        cappuccino.setType("Cappuccino");
    }

    @Override
    public void buildSize() {
        cappuccino.setSize("Large");
    }

    @Override
    public void buildToppings() {
        cappuccino.addTopping("Chocolate Powder");
    }

    @Override
    public Coffee getResult() {
        return cappuccino;
    }
}

class CoffeeDirector {
    public void constructCoffee(CoffeeBuilder builder) {
        builder.buildType();
        builder.buildSize();
        builder.buildToppings();
    }
}

public class BuilderDesign {
    public static void main(String[] args) {

        CoffeeDirector coffeeDirector = new CoffeeDirector();

        CoffeeBuilder espressoBuilder = new EspressoBuilder();
        coffeeDirector.constructCoffee(espressoBuilder);
        Coffee espresso = espressoBuilder.getResult();
        System.out.println("Espresso Coffee: " + espresso);

        CoffeeBuilder latteBuilder = new LatteBuilder();
        coffeeDirector.constructCoffee(latteBuilder);
        Coffee latte = latteBuilder.getResult();
        System.out.println("Latte Coffee: " + latte);

        CoffeeBuilder cappuccinoBuilder = new CappuccinoBuilder();
        coffeeDirector.constructCoffee(cappuccinoBuilder);
        Coffee cappuccino = cappuccinoBuilder.getResult();
        System.out.println("Cappuccino Coffee: " + cappuccino);
    }
}
