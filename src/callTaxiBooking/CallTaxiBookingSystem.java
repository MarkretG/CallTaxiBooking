package callTaxiBooking;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class CallTaxiBookingSystem {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("1.initialise Taxi status");
            System.out.println("2.Booking");
            System.out.println("3.TaxiDetails");
            System.out.println("4.exit");
            int choice =scanner.nextInt();
            switch(choice)
            {
                case 1: {
                    List<Taxi> taxi = InputHandler.INSTANCE.initialiseTaxiList();
                    LogicalHandler.INSTANCE.storeTaxiListInCache(taxi);
                    printTaxiStatus(taxi);
                }
                    break;
                case 2: {
                    Customer customer = InputHandler.INSTANCE.getBookingCustomer();
                    LogicalHandler.INSTANCE.assignTaxiToCustomer(customer);
                    List<Taxi> taxis=LogicalHandler.INSTANCE.getTaxisStatus();
                    printTaxiStatus(taxis);
                }
                    break;
                case 3: {
                    List<Taxi> taxis = LogicalHandler.INSTANCE.getTaxisStatus();
                    Map<Integer, List<Customer>> map = LogicalHandler.INSTANCE.getTaxiDetails();
                    printTaxiDetails(taxis, map);
                    }
                     break;

                    case 4:
                        System.exit(0);

                }
            }
        }

    private static void printTaxiStatus(List<Taxi> taxis)
    {
        System.out.println("TaxiId"+'\t'+"Total earnings"+'\t'+"Current spot"+'\t'+"free time");
        for (Taxi taxi:taxis)
        {
            System.out.print(taxi.getTaxiId()+"           ");
            System.out.print(taxi.getEarnings()+"           ");
            System.out.print(taxi.getCurrentSpot()+"          ");
            System.out.print(taxi.getFreeTime());
            System.out.println();
        }
    }
    private static void printTaxiDetails(List<Taxi> taxis,Map<Integer,List<Customer>> listMap)
    {
        System.out.println("Booking id"+" "+"CustomerId"+"        "+"pickup " +"           "+"drop"+"          "+"pick up time"+"drop time"+"  "+"Amount");
        for (Taxi taxi:taxis)
        {
            System.out.println("Taxi:"+taxi.getTaxiId()+"  "+"Total earnings:"+taxi.getEarnings());
            for (Map.Entry<Integer,List<Customer>> entry: listMap.entrySet())
            {
                if(taxi.getTaxiId()==entry.getKey())
                {
                    List<Customer> customers=entry.getValue();
                    System.out.println(customers);
                    break;
                }
            }
            System.out.println("----------------------------------------------------------------------");
        }

    }
}

