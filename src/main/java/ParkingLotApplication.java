package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotApplication {

    public static void main(String[] args) {
        List<String> commandList = getAllCommands();
        Parking parking = null;
        for (String inpCommand : commandList) {
            String command = getCommand(inpCommand);

            switch (command) {
                case "create":
                    int slots = getTotalSlots(inpCommand);
                    parking = new Parking(slots);
                    System.out.println("Created parking lot with " + parking.getSlotsRemaining() + " slots");
                    break;
                case "leave":
                    String regNo = getRegistrationNo(inpCommand);
                    Optional<ParkingSlot> slot = parking.getParkingSlots().stream().filter(e -> regNo.equals(e.getRegistrationNumber())).findFirst();
                    if (slot.isPresent()) {
                        slot.get().setRegistrationNumber(null);
                        slot.get().setOccupied(false);
                        parking.setSlotsRemaining(parking.getSlotsRemaining() + 1);
                        int charge = calculateCharge(getHours(inpCommand));
                        System.out.println("Registration Number " + regNo + " from Slot " + slot.get().getSlotNumber() + " has left with Charge " + charge);
                    }
                break;
                case "park":
                    if (parking.getSlotsRemaining() == 0) {
                        System.out.println("Sorry, parking lot is full");
                    } else {
                        Optional<ParkingSlot> avslot = parking.getParkingSlots().stream().filter(e -> e.occupied == false).findFirst();
                        if (avslot.isPresent()) {
                            avslot.get().setRegistrationNumber(getRegistrationNo(inpCommand));
                            avslot.get().setOccupied(true);
                        }
                        parking.setSlotsRemaining(parking.getSlotsRemaining() - 1);
                        System.out.println("Allocated slot number: " + avslot.get().getSlotNumber());
                    }
                    break;
                case "status":
                    System.out.println("Slot No." + "     Registration No.");
                    parking.getParkingSlots().stream().filter(e->e.getRegistrationNumber() != null).forEach(e -> {
                        System.out.println(e.getSlotNumber() + "            " + e.getRegistrationNumber());
                    });
                  break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
    }

    private static int getHours(String inpCommand) {
        return Integer.parseInt(inpCommand.split(" ")[2]);
    }

    private static int calculateCharge(int hours) {
        if (hours <= 2) {
            return 10;
        } else {
            return 10 + (hours - 2) * 10;
        }
    }

    private static String getRegistrationNo(String inpCommand) {
        return inpCommand.split(" ")[1];
    }

    private static int getTotalSlots(String inpCommand) {
        return Integer.parseInt(inpCommand.split(" ")[1]);
    }

    private static String getCommand(String cmd) {
        return cmd.split(" ")[0];
    }

    public static List<String> getAllCommands() {

        List<String> commandList = new ArrayList<>();
        File file1 = new File("src/main/java/input.txt");
        StringBuilder builder = new StringBuilder();

        try (BufferedReader buffer = new BufferedReader(
                new FileReader(file1))) {
            String str;
            while ((str = buffer.readLine()) != null) {
                builder.append(str).append("\n");
                commandList.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commandList;
    }
}

