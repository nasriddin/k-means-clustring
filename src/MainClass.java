import java.io.IOException;
import java.util.*;

public class MainClass extends GetData {

    //    get Dataset / read Dataset
//    make first clustering
//    make loop clustering according to K
    public static void main(String args[]) throws IOException {

        Scanner scanner = new Scanner(System.in);
        GetData data = new GetData();
        ClustererClass cluster = new ClustererClass();
        data.dimension.clear();
        System.out.println("Enter the filename with path");

        String file = scanner.next();
        data.getData(file);
        int execution = 1;

        do {
            System.out.println("How many clusters you want: ");
            int clusters = scanner.nextInt();
            int iteration = clusters;
            Map<Integer, double[]> centers = new HashMap<>();

//            TODO Get index of them and select first K points then make a loop. do not go for features

            double[] jj = new double[dimensionNumber];
            int a = 0;
            for (int i = 0; i < clusters; i++) {

                jj = data.dimension.get(a++);
                centers.put(i, jj);

            }
            Map<double[], Integer> clusterings = new HashMap<>();
            clusterings = kmeans(data.dimension, centers, clusters);

            for (double[] key : clusterings.keySet()) {
                for (int i = 0; i < key.length; i++) {
                    System.out.print(key[i] + " ");
                }
                System.out.print(clusterings.get(key) + "\n");
            }

            double dimensionalTwo[] = new double[dimensionNumber];

            for (int i = 0; i < iteration; i++) {
                for (int j = 0; j < clusters; j++) {
                    List<double[]> list = new ArrayList<>();
                    for (double[] key : clusterings.keySet()) {
                        if (clusterings.get(key) == j) {
                            list.add(key);
                        }
                    }

                    dimensionalTwo = centerCalculator(list);
                    centers.put(j, dimensionalTwo);

                }

                clusterings.clear();
                clusterings = kmeans(data.dimension, centers, clusters);
            }

            System.out.println("\nFinal clustering");
            System.out.println("First dimension\tSecond dimension");

            for (double[] key : clusterings.keySet()) {
                for (int i = 0; i < key.length; i++) {
                    System.out.print(key[i] + "\t \t");
                }
                System.out.print(clusterings.get(key) + "\n");
            }
            execution = scanner.nextInt();

        } while (execution == 1);


    }
//    private int randomNumber(){
//
//
//        return
//    }

    public static double[] centerCalculator(List<double[]> a) {

        int count = 0;
        double sum = 0.0;
        double[] centers = new double[GetData.dimensionNumber];
        for (int i = 0; i < GetData.dimensionNumber; i++) {
            sum = 0.0;
            count = 0;
            for (double[] x : a) {
                count++;
                sum = sum + x[i];
            }
            centers[i] = sum / count;
        }
        return centers;

    }


    public static Map<double[], Integer> kmeans(List<double[]> features, Map<Integer, double[]> centers, int cluster) {
        Map<double[], Integer> clusters = new HashMap<>();
        int cluster1 = 0;
        double dist = 0.0;
        for (double[] x : features) {
            double minimum = 999999.0;
            for (int j = 0; j < cluster; j++) {

                dist = ClustererClass.distanceGet(centers.get(j), x);
                if (dist < minimum) {
                    minimum = dist;
                    cluster1 = j;
                }

            }
            clusters.put(x, cluster1);
        }

        return clusters;
    }
}

