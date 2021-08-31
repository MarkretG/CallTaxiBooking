package callTaxi;

import java.util.List;
import java.util.Scanner;

public class CallTaxiBookingSystem {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("1.initial Taxi status");
            System.out.println("2.Booking");
            System.out.println("3.TaxiDetails");
            int choice =scanner.nextInt();
            switch(choice)
            {
                case 1:
                     List<Taxi> taxi=InputHandler.INSTANCE.initialiseTaxiList();
                     LogicalHandler.INSTANCE.storeTaxiListInCache(taxi);
                     print(taxi);
                    break;
                case 2:
                    Customer customer=InputHandler.INSTANCE.getBookingCustomer();
                    LogicalHandler.INSTANCE.assignTaxiToCustomer(customer);
                    break;
            }
        }
    }
    private static void print(List<Taxi> taxis)
    {
        System.out.println("TaxiId"+'\t'+"Total earnings"+'\t'+"Current spot"+'\t'+"free time");
        for (Taxi taxi:taxis)
        {
            System.out.print(taxi.getTaxiId()+"\t\t\t");
            System.out.print(taxi.getEarnings()+"\t\t\t");
            System.out.print(taxi.getCurrentSpot()+"\t\t\t\t\t");
            System.out.print(taxi.getFreeTime());
            System.out.println();
        }
    }
}
