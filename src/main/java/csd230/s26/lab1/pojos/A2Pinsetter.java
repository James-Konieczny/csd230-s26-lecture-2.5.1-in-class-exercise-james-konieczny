package csd230.s26.lab1.pojos;

import java.util.Objects;
import java.util.Scanner;

/**
 * DTO for {@link csd230.s26.lab1.entities.A2PinsetterEntity}
 */
public abstract class A2Pinsetter extends Product {
    private String material = "";
    private double price = 0.0;

    public A2Pinsetter() {
    }

    public A2Pinsetter(String material, double price) {
        this.material = material;
        this.price = price;
    }

    @Override
    public void edit(Scanner input) {
        System.out.println("Edit Material [" + this.material + "]:");
        this.material = getInput(input, this.material);

        System.out.println("Edit Price [" + this.price + "]:");
        this.price = getInput(input, this.price);
    }

    @Override
    public void initialize(Scanner input) {
        System.out.println("Enter Material:");
        this.material = getInput(input, "Metal");

        System.out.println("Enter Price:");
        this.price = getInput(input, 0.0);
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    @Override
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "A2Pinsetter{" +
                "material='" + material + '\'' +
                ", price=" + price +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        A2Pinsetter that = (A2Pinsetter) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(material, that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, price);
    }
}
