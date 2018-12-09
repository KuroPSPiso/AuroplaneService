package com.capgemini.XYZAirplanes.exceptions;

public class FlightDestinationIsOriginException extends Exception{
    public FlightDestinationIsOriginException(){
        super("Origin is the same as the set destination.");
    }
}
