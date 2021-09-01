package callTaxiBooking;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int taxiId;
    private int earnings;
    private char currentSpot;
    private int freeTime;
    private List<Customer> trips;

    public Taxi()
    {
        trips=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "taxiId=" + taxiId +
                ", earnings=" + earnings +
                ", currentSpot=" + currentSpot +
                ", freeTime=" + freeTime +
                '}';
    }
    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }


    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public char getCurrentSpot() {
        return currentSpot;
    }

    public void setCurrentSpot(char currentSpot) {
        this.currentSpot = currentSpot;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }
}

