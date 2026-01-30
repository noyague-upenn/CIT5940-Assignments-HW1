package homework1.src;

import java.util.LinkedList;
import java.util.List;

public class TicketProcessor {
    public static void main(String[] args) {

        processTicketsLinkedList();

        /* For the iterations

        double[] res = new double[10];
        double average = 0;

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime(); // start testing runtime
            processTicketsLinkedList();
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

    public static void processTicketsLinkedList() {

        LinkedList<String> ticketQueue = new LinkedList<>();

        // Uncomment the queue length you want to test with
        createShortQueue(ticketQueue);
        // createLongQueue(ticketQueue);

        while (!ticketQueue.isEmpty()) {
            // grab the first item in the list
            String currentTicket = ticketQueue.remove(0); 
            
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