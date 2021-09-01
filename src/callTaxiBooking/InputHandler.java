package callTaxiBooking;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public enum  InputHandler {
    INSTANCE;
    Scanner sc=new Scanner(System.in);
    int customerId=0;
    public List<Taxi> initialiseTaxiList()
    {
        List<Taxi> taxis=new ArrayList<>();
        for (int i=1;i<=5;i++)
        {
            Taxi taxi=new Taxi();
            taxi.setTaxiId(i);
            taxi.setEarnings(0);
            taxi.setCurrentSpot('A');
            taxi.setFreeTime(6);
            taxis.add(taxi);
        }
        return taxis;
    }
    public Customer getBookingCustomer()
    {
        System.out.println("Enter pickUp point ");
        char pickUpPoint= getPickUpPoint();
        System.out.println("Enter drop point ");
        char dropPoint= getDropPoint();
        System.out.println("enter pickup time");
        int pickUpTime=sc.nextInt();
        return LogicalHandler.INSTANCE.getCustomerObject(customerId++,pickUpPoint,dropPoint,pickUpTime);
    }
    private char getDropPoint()
    {
        char dropPoint=sc.next().charAt(0);
        while (!(dropPoint>='A'&&dropPoint<='F'))
        {
            System.out.println("please enter valid drop point..drop are A,B,C,D,E,F existing");
             dropPoint=sc.next().charAt(0);
        }
        return dropPoint;
    }
    private char getPickUpPoint()
    {
        char PickUpPoint=sc.next().charAt(0);
        while (!(PickUpPoint>='A'&&PickUpPoint<='F'))
        {
            System.out.println("please enter valid pickup  point....pickup are A,B,C,D,E,F exiting");
            PickUpPoint=sc.next().charAt(0);
        }
        return PickUpPoint;
    }
}
