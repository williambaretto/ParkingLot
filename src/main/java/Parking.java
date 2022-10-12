package main.java;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    int parKingLotSize;
    private List<ParkingSlot> parkingSlots = new ArrayList<>();
    int slotsRemaining;

    public Parking(int parKingLotSize) {
        this.parKingLotSize = parKingLotSize;
        this.slotsRemaining = parKingLotSize;
        this.parkingSlots = generateParkingSlots(parKingLotSize);
    }

    private List<ParkingSlot> generateParkingSlots(int parKingLotSize) {
        List<ParkingSlot> list = new ArrayList<>();
        for (int i = 1; i <= parKingLotSize; i++) {
            list.add(new ParkingSlot(i));
        }
        return list;
    }

    public int getParKingLotSize() {
        return parKingLotSize;
    }

    public void setParKingLotSize(int parKingLotSize) {
        this.parKingLotSize = parKingLotSize;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getSlotsRemaining() {
        return slotsRemaining;
    }

    public void setSlotsRemaining(int slotsRemaining) {
        this.slotsRemaining = slotsRemaining;
    }
}
