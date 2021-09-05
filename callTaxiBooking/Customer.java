package callTaxiBooking;
public class Customer {
    private int customerId;
    private char pickUpPoint;
    private char dropPoint;
    private int  pickUpTime;
    private int dropTime;
    private int bookedTaxiId;
    private int payAmount;
    private int bookingId;


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", pickUpPoint=" + pickUpPoint +
                ", dropPoint=" + dropPoint +
                ", pickUpTime=" + pickUpTime +
                ", dropTime=" + dropTime +
                ", bookedTaxiId=" + bookedTaxiId +
                ", payAmount=" + payAmount +
                ", bookingId=" + bookingId +
                '}';
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public char getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(char pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(char dropPoint) {
        this.dropPoint = dropPoint;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public int getBookedTaxiId() {
        return bookedTaxiId;
    }

    public void setBookedTaxiId(int bookedTaxiId) {
        this.bookedTaxiId = bookedTaxiId;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
