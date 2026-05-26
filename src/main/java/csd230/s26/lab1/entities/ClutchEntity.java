package csd230.s26.lab1.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue("CLUTCH")
public class ClutchEntity extends A2PinsetterEntity {
    private String diskSize;
    private Boolean shaft;

    public ClutchEntity() {}

    public ClutchEntity(String material, Double price, String diskSize, Boolean shaft) {
        super(material, price);
        this.diskSize = diskSize;
        this.shaft = shaft;
    }

    public String getDiskSize() {
        return diskSize;
    }
    public void setDiskSize(String diskSize) {
        this.diskSize = diskSize;
    }
    public Boolean getShaft() {
        return shaft;
    }
    public void setShaft(Boolean shaft) { this.shaft = shaft; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClutchEntity that = (ClutchEntity) o;
        return Objects.equals(diskSize, that.diskSize) && Objects.equals(shaft, that.shaft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diskSize, shaft);
    }

    @Override
    public String toString() {
        return "ClutchEntity{" +
                "diskSize='" + diskSize + '\'' +
                ", shaft=" + shaft + ", "
                + super.toString() +
                '}';
    }

    @Override
    public void sellItem() {
        String s = "";
        if ( shaft = true ) { s = "a"; }
        else { s = "no"; }

        System.out.println("Selling Clutch with disk size " + diskSize + " and " + s + " connecting shaft.");
    }

}