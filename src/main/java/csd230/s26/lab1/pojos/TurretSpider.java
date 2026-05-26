package csd230.s26.lab1.pojos;

import java.util.Objects;
import java.util.Scanner;

/**
 * DTO for {@link csd230.s26.lab1.entities.TurretSpiderEntity}
 */
public class TurretSpider extends A2Pinsetter {
    private int ballBearings = 0;
    private int spoons = 0;

    public TurretSpider() { super(); }

    public TurretSpider(String material, double price, int ballBearings, int spoons) {
        super(material, price);
        this.ballBearings = ballBearings;
        this.spoons = spoons;
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);

        System.out.println("Edit Number of Ball Bearings [" + this.ballBearings + "]:");
        this.ballBearings = getInput(input, this.ballBearings);

        System.out.println("Edit Number of Spoons [" + this.spoons + "]:");
        this.spoons = getInput(input, this.spoons);
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);

        System.out.println("Enter Number of Ball Bearings:");
        this.ballBearings = getInput(input, 149);

        System.out.println("Enter Number of Spoons:");
        this.spoons = getInput(input, 9);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Turret Spider with " + ballBearings + " ball bearings and " + spoons + " spoons.");
    }

    public int getBallBearings() { return ballBearings; }
    public void setBallBearings(int ballBearings) { this.ballBearings = ballBearings; }

    public int getSpoons() { return spoons; }
    public void setSpoons(int spoons) { this.spoons = spoons; }

    @Override
    public String toString() {
        return "TurretSpider{" +
                "ballBearings=" + ballBearings +
                ", spoons=" + spoons + ", "
                + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TurretSpider that = (TurretSpider) o;
        return ballBearings == that.ballBearings && spoons == that.spoons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ballBearings, spoons);
    }
}
