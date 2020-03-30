public class runKnights_7_22 {

    public static void main(String[] args) {


        Knights_7_22 kt = new Knights_7_22(0, 0);

        for (int i = 0; i <= 7; i++) {
            kt.setLocRow(i);
            for (int j = 0; j <= 7; j++) {
                kt.setLocCol(j);
                kt.resetTour(i, j);
                kt.run();
            }
        }

        System.out.println("Shortest tour length: " + kt.getMinTourLength());
        System.out.println("Number of completed tours: " + kt.getCompletedTours());
        System.out.println("Longest tour length: " + kt.getMaxTourLength());
    }
}
