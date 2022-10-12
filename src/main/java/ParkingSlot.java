package main.java;

public class ParkingSlot {

    private String registrationNumber;
    private int slotNumber;
    boolean occupied = false;

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingSlot(String registrationNumber){
        this.registrationNumber= registrationNumber;
    }
    public ParkingSlot(int  slotNumber){
        this.slotNumber= slotNumber;
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
