public class runKnights {

    public static void main(String[] args) {


        Knights kt = new Knights(0, 4);

        kt.run();
        //kt.run();
        kt.setAccessibility();
        kt.printAccessibility();

        /*
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many tours would you like to run?");
        int numberOfTours = scanner.nextInt();
        */




        /*
        for (int i = 0; i < numberOfTours; i++) {
            kt.tour();
        }



        tour.printBoard();

        for (int i = 0; i <= 50; i++) {kt.tour;
            tour.makeMove();
            System.out.println();
            tour.printBoard();
        }

        tour.resetTour();
        tour.printBoard();

        for (int i = 0; i <= 50; i++) {
            tour.makeMove();
            System.out.println();
            tour.printBoard();
        }

        if (tour.getMoveCounter() == 64) {
            tour.setCompletedTours(tour.getCompletedTours() + 1);
        } */





    }

}
