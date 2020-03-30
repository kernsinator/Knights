import java.util.Random;

public class runKnights_7_23 {

    public static void main(String[] args) {

        Random random = new Random();

        Knights_7_23 kt = new Knights_7_23(random.nextInt(7), random.nextInt(7));

        //each separate part of the assignment is listed below with the relevant code commented out

        /*

        // 7.23.a
        kt.run();

         */

         /*

        // 7.23.b - longest tour was 55 moves

        while (kt.getTotalTours() < 1000) {
            kt.run();
            kt.resetTour(random.nextInt(7),random.nextInt(7));
        }

        kt.printTourTable();

          */


        /*

        // 7.23.c - 1.2 million tours and several minutes before a tour was completed

        while (true) {
            kt.run();
            kt.resetTour(random.nextInt(7),random.nextInt(7));
            if (kt.getCompletedTours() >= 1) {
                break;
            }
        }

         */

        //7.23.d
        // The brute force method requires significantly more computation time and computer power
        // than the accessibility-heuristic approach, but requires less careful planning. For a problem
        // of this type, it is worthwhile to establish a clear plan of action to reduce the necessary computation.
        // Mathematically we can be certain of obtaining a full tour with the accessibility-heuristic approach.
        // The brute force approach offers no such guarantee in a limited number of tours.

        System.out.println("Shortest tour length: " + kt.getMinTourLength());
        System.out.println("Number of tours: " + kt.getTotalTours());
        System.out.println("Number of completed tours: " + kt.getCompletedTours());
        System.out.println("Longest tour length: " + kt.getMaxTourLength());
    }
}
