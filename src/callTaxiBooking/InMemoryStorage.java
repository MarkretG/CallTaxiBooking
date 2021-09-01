package callTaxiBooking;

import java.util.*;

public enum  InMemoryStorage {
    INSTANCE;
    private Map<Integer,List<Customer>> map=new HashMap<>();
    private List<Taxi> taxiList=new ArrayList<>();
    public void setInitialTaxiList(List<Taxi> taxis)
    {
        for (Taxi taxi:taxis)
        {
            taxiList.add(taxi);
        }
    }
    public void updateTaxis(Taxi taxi)
    {
       for (Taxi t:taxiList)
       {
         if (t.getTaxiId()== taxi.getTaxiId())
         {
             t.setEarnings(taxi.getEarnings());
             t.setCurrentSpot(taxi.getCurrentSpot());
             t.setFreeTime(taxi.getFreeTime());
             break;
         }
       }
    }
    public List<Taxi> getUpdatedTaxiList()
    {
        return taxiList;
    }
    public void setTaxiDetailsInMap(Customer customer)
    {
        List<Customer> list=map.getOrDefault(customer.getBookedTaxiId(),new ArrayList<>());
        list.add(customer);
        map.put(customer.getBookedTaxiId(),list);
    }
    public Map<Integer,List<Customer>> getTaxiDetails()
    {
        return map;
    }

}