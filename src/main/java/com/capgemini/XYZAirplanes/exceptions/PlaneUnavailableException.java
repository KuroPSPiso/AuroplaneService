package com.capgemini.XYZAirplanes.exceptions;

public class PlaneUnavailableException extends Exception {
    public PlaneUnavailableException()
    {
        super("Airplane already in use");
    }
}
