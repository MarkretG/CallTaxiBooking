package callTaxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum  InMemoryStorage {
    INSTANCE;
    private List<Taxi> taxiList=new ArrayList<>();
    public void setInitialTaxiList(List<Taxi> taxis)
    {
        for (Taxi taxi:taxis)
        {
            taxiList.add(taxi);
        }
    }
    private void updateTaxis(Taxi taxi)
    {

    }
    public List<Taxi> getUpdatedTaxiList()
    {
        return taxiList;
    }

}
