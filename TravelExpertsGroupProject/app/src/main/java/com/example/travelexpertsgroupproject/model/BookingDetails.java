package com.example.travelexpertsgroupproject.model;

import java.io.Serializable;

public class BookingDetails implements Serializable {

    private int BookingId;
    private String Description;
    private String Destination;
    private String  TripStart;
    private String TripEnd;
    private int TravelerCount;

    public BookingDetails(int bookingId, String description, String destination, String tripStart, String tripEnd, int travelerCount) {
        BookingId = bookingId;
        Description = description;
        Destination = destination;
        TripStart = tripStart;
        TripEnd = tripEnd;
        TravelerCount = travelerCount;
    }

    public int getBookingId() {
        return BookingId;
    }

    public void setBookingId(int bookingId) {
        BookingId = bookingId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getTripStart() {
        return TripStart;
    }

    public void setTripStart(String tripStart) {
        TripStart = tripStart;
    }

    public String getTripEnd() {
        return TripEnd;
    }

    public void setTripEnd(String tripEnd) {
        TripEnd = tripEnd;
    }

    public int getTravelerCount() {
        return TravelerCount;
    }

    public void setTravelerCount(int travelerCount) {
        TravelerCount = travelerCount;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "BookingId=" + BookingId +
                ", Description='" + Description + '\'' +
                ", Destination='" + Destination + '\'' +
                ", TripStart='" + TripStart + '\'' +
                ", TripEnd='" + TripEnd + '\'' +
                ", TravelerCount=" + TravelerCount +
                '}';
    }
}
