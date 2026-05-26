package csd230.s26.lab1.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue("TURRETSPIDER")
public class TurretSpiderEntity extends A2PinsetterEntity {
    private int ballBearings;
    private int spoons;

    public TurretSpiderEntity() {}

    public TurretSpiderEntity(String material, Double price, int ballBearings, int spoons) {
        super(material, price);
        this.ballBearings = ballBearings;
        this.spoons = spoons;
    }

    public int getBallBearings() {
        return ballBearings;
    }
    public void setBallBearings(int ballBearings) {
        this.ballBearings = ballBearings;
    }
    public int getSpoons() {
        return spoons;
    }
    public void setSpoons(int spoons) { this.spoons = spoons; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TurretSpiderEntity that = (TurretSpiderEntity) o;
        return ballBearings == that.ballBearings && spoons == that.spoons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ballBearings, spoons);
    }

    @Override
    public String toString() {
        return "TurretSpiderEntity{" +
                "ballBearings=" + ballBearings +
                ", spoons=" + spoons + ", "
                + super.toString() +
                '}';
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Turret Spider with " + ballBearings + " ball bearings and " + spoons + " spoons.");
    }
}