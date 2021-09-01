package callTaxi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    public Taxi getTaxiObject(int taxiId,float earnings,char currentSpot,int freeTime)
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
        Collections.sort(freeTaxis,(a,b)-> (int) (a.getEarnings()-b.getEarnings()));
    }
    private List<Taxi>  getAvailableTaxis(List<Taxi> taxis,Customer customer)
    {
        List<Taxi> availableTaxis=new ArrayList<>();
        for (Taxi taxi:taxis)
        {
            if(taxi.getFreeTime()<= customer.getPickUpTime())
            {
                int spot=(taxi.getCurrentSpot()-customer.getPickUpPoint());
                int time=(taxi.getFreeTime()- customer.getPickUpTime());
                if(Math.abs(spot)<=Math.abs(time))
                {
                   availableTaxis.add(taxi);
                }
            }
        }
        return availableTaxis;
    }

    public List<Taxi> getTaxisList()
    {
        return InMemoryStorage.INSTANCE.getUpdatedTaxiList();
    }
}
