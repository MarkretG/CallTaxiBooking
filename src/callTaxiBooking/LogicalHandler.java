package callTaxiBooking;
import java.util.*;
public enum  LogicalHandler {
    INSTANCE;
    public  void storeTaxiListInCache(List<Taxi> list)
    {
        InMemoryStorage.INSTANCE.setInitialTaxiList(list);
    }
    public Customer getCustomerObject(int customerId,char pickUpPoint,char dropPoint,int pickUpTime)
    {
        Customer customer=new Customer();
        customer.setCustomerId(customerId);
        customer.setPickUpPoint(pickUpPoint);
        customer.setDropPoint(dropPoint);
        customer.setPickUpTime(pickUpTime);
        return customer;
    }

    public Taxi getTaxiObject(int taxiId,int earnings,char currentSpot,int freeTime)
    {
        Taxi taxi=new Taxi();
        taxi.setTaxiId(taxiId);
        taxi.setEarnings(earnings);
        taxi.setCurrentSpot(currentSpot);
        taxi.setFreeTime(freeTime);
        return taxi;
    }

    public void assignTaxiToCustomer(Customer customer)
    {
        List<Taxi> taxi=InMemoryStorage.INSTANCE.getUpdatedTaxiList();
        List<Taxi> freeTaxis=getAvailableTaxis(taxi,customer);
        if(freeTaxis.size()==0)
        {
            System.out.println("No taxi can be allocated");
            return;
        }
        Collections.sort(freeTaxis, (o1, o2) -> {
            if(o1.getEarnings()>o2.getEarnings())
                return -1;
            else if(o1.getEarnings()<o2.getEarnings())
                return 1;

            return 0;
        });
        bookingTaxi(freeTaxis,customer);

    }
    private List<Taxi>  getAvailableTaxis(List<Taxi> taxis,Customer customer)
    {
        List<Taxi> availableTaxis=new ArrayList<>();
        for (Taxi taxi:taxis)
        {
            if(taxi.getFreeTime()<= customer.getPickUpTime())
            {
                int spot=((taxi.getCurrentSpot()-'0')-(customer.getPickUpPoint()-'0'));
                int time=(customer.getPickUpTime()-taxi.getFreeTime());
                if(Math.abs(spot)<=time)
                {
                    availableTaxis.add(taxi);
                }
            }

        }
        return availableTaxis;
    }
    private void bookingTaxi(List<Taxi> freeTaxis,Customer customer)
    {
        int min=999;
        int bookedTaxi=0;
        int nextFreeTime=0;
        int totalEarnings=0;
        int earnings=0;
        char nextSpot='m';
        int distanceBetweenPickUpAndDrop=0;
       for (Taxi list:freeTaxis)
       {
           int distanceBetweenCustomerAndTaxi=((list.getCurrentSpot()-'0')-(customer.getPickUpPoint()-'0'))*15;
           if (distanceBetweenCustomerAndTaxi<=min)
           {
               totalEarnings= list.getEarnings();
               min=distanceBetweenCustomerAndTaxi;
               bookedTaxi=list.getTaxiId();
               distanceBetweenPickUpAndDrop=Math.abs((customer.getDropPoint()-'0')-(customer.getPickUpPoint()-'0'))*15;
               earnings=(distanceBetweenPickUpAndDrop-5)*10+100;
               totalEarnings+=earnings;
               nextFreeTime= customer.getPickUpTime()+(distanceBetweenPickUpAndDrop/15);
               nextSpot=customer.getDropPoint();
           }
        }
        customer.setBookedTaxiId(bookedTaxi);
        customer.setPayAmount(earnings);
        customer.setDropTime(nextFreeTime);
        customer.setBookingId(customer.getCustomerId());
        Taxi taxi=getTaxiObject(bookedTaxi,totalEarnings,nextSpot,nextFreeTime);
        System.out.println("Taxi"+bookedTaxi+"booked");
        InMemoryStorage.INSTANCE.updateTaxis(taxi);
        InMemoryStorage.INSTANCE.setTaxiDetailsInMap(customer);
    }
    public List<Taxi> getTaxisStatus()
    {
        return InMemoryStorage.INSTANCE.getUpdatedTaxiList();
    }
    public Map<Integer,List<Customer>> getTaxiDetails()
    {
        return InMemoryStorage.INSTANCE.getTaxiDetails();
    }
}
