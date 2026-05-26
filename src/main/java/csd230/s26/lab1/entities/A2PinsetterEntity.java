package csd230.s26.lab1.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue("A2PINSETTER")
public abstract class A2PinsetterEntity extends ProductEntity {
    private String material;
    private double price;

    public A2PinsetterEntity() {
        setMaterial("Metal");
        setPrice(0.0);
    }

    public A2PinsetterEntity(String material, double price) {
        this.material = material;
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) { this.price = price; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        A2PinsetterEntity that = (A2PinsetterEntity) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(material, that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), material, price);
    }

    @Override
    public String toString() {
        return "A2PinsetterEntity{" +
                "material='" + material + '\'' +
                ", price=" + price +
                '}' + super.toString();
    }
}