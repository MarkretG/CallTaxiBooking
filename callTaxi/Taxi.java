package callTaxi;
public class Taxi {
    private int taxiId;
    private float earnings;
    private char currentSpot;
    private int freeTime;

    @Override
    public String toString() {
        return ""
                + taxiId +'\t'+'\t'
                 + earnings +'\t'+'\t'
                 + currentSpot +'\t'+'\t'
                 + freeTime;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }


    public float getEarnings() {
        return earnings;
    }

    public void setEarnings(float earnings) {
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
