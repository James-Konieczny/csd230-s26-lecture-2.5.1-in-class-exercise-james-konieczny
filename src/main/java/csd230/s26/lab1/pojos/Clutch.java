package csd230.s26.lab1.pojos;

import java.util.Objects;
import java.util.Scanner;

/**
 * DTO for {@link csd230.s26.lab1.entities.ClutchEntity}
 */
public class Clutch extends A2Pinsetter {
    private String diskSize = "";
    private Boolean shaft = false;

    public Clutch() { super(); }

    public Clutch(String material, double price, String diskSize, Boolean shaft) {
        super(material, price);
        this.diskSize = diskSize;
        this.shaft = shaft;
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);

        System.out.println("Edit Disk Size [" + this.diskSize + "]:");
        this.diskSize = getInput(input, this.diskSize);

        System.out.println("Edit if clutch connects to Shaft [" + this.shaft + "]:");
        this.shaft = getInput(input, this.shaft);
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);

        System.out.println("Enter Disk Size:");
        this.diskSize = getInput(input, "large");

        System.out.println("(true or false) Clutch connects to Shaft?:");
        this.shaft = getInput(input, true);
    }

    @Override
    public void sellItem() {
        String s = "";
        if ( shaft = true ) { s = "a"; }
        else { s = "no"; }

        System.out.println("Selling Clutch with disk size " + diskSize + " and " + s + " connecting shaft.");
    }

    public String getDiskSize() { return diskSize; }
    public void setDiskSize(String diskSize) { this.diskSize = diskSize; }

    public Boolean getShaft() { return shaft; }
    public void setShaft(Boolean shaft) { this.shaft = shaft; }

    @Override
    public String toString() {
        return "Clutch{" +
                "diskSize='" + diskSize + '\'' +
                ", shaft=" + shaft + ", "
                + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Clutch clutch = (Clutch) o;
        return Objects.equals(diskSize, clutch.diskSize) && Objects.equals(shaft, clutch.shaft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diskSize, shaft);
    }
}
