package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {

    List<Object> vehicle = new ArrayList<Object>();
    int parkingLotCapacity = 1;
    public boolean isParkingFull;
    ParkingLotInformationSubscriber parkingLotInformationSubscriber;

    //CONSTRUCTOR
    public ParkingLotSystem() {
        parkingLotInformationSubscriber = new ParkingLotInformationSubscriber();
    }

    //METHOD TO PARK THE VEHICLE
    public boolean isPark(Object vehicleToPark) throws ParkingLotException {
        if (this.vehicle.isEmpty()) {
            vehicle.add(vehicleToPark);
            return true;
        } else if (!this.vehicle.isEmpty() && (!this.vehicle.contains(vehicleToPark)) && (this.vehicle.size() < parkingLotCapacity)) {
            vehicle.add(vehicleToPark);
            return true;
        } else
            throw new ParkingLotException("Parking Lot Is Full");
    }

    //METHOD TO UNPARK THE GIVEN VEHICLE
    public boolean unParkTheVehicle(Object vehicleToUnPark) throws ParkingLotException {
        if (vehicle.contains(vehicleToUnPark)) {
            vehicle.remove(vehicleToUnPark);
            return true;
        }
        throw new ParkingLotException("Vehicle Is Not Parked Here");
    }
}
