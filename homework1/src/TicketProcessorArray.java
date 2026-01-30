package homework1.src;

import java.util.ArrayList;
import java.util.List;

public class TicketProcessorArray {

    public static void main(String[] args) {

        processTicketsArrayList();

        /* For the iterations
        double[] res = new double[10];
        double average = 0;

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime(); // start testing runtime
            processTicketsArrayList();
            long end = System.nanoTime(); // end testing runtime
            res[i] = (end - start) / 1000000.0;
        }

        for (int i = 0; i < 10; i++) {
            average += res[i];
            System.out.println(res[i]);
        }
        System.out.println("Average: " + average / 10);
         */
    }

    public static void processTicketsArrayList() {

        ArrayList<String> ticketQueue = new ArrayList<>();

        // Uncomment the queue length you want to test with
        // createShortQueue(ticketQueue);
        createLongQueue(ticketQueue);


        while (!ticketQueue.isEmpty()) {
            // grab the first item in the list
            String currentTicket = ticketQueue.remove(ticketQueue.size() - 1);

            System.out.println("Processing: " + currentTicket);

            System.out.println("Finished! Remaining in line: " + ticketQueue.size());
            System.out.println("---------------------------");
        }
    }

    public static void createShortQueue(List<String> queue) {
        // feel free to change the number of tickets here to test different queue sizes
        for (int i = 1; i <= 50; i++) {
            queue.add("Ticket #" + i);
        }
    }

    public static void createLongQueue(List<String> queue) {
        // feel free to change the number of tickets here to test different queue sizes
        for (int i = 1; i <= 20000; i++) {
            queue.add("Ticket #" + i);
        }
    }

}
