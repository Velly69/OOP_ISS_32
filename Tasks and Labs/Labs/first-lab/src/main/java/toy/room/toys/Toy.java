package toy.room.toys;

import toy.room.toys.exceptions.NegativePriceAmount;

import java.util.Objects;

public abstract class Toy {
    private float price;
    private String name;

    public Toy(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(float price) throws NegativePriceAmount {
        if(price < 0){
            throw new NegativePriceAmount("You can't change price to negative number");
        }
        this.price = price;
    }

    public void renameToy(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return Double.compare(toy.price, price) == 0 &&
                name.equals(toy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}
