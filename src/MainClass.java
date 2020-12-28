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
        // /home/nasriddin/Inha/BigData/K_Means_clustring/Dataset1.txt
        System.out.println("Enter the filename with path");

        String file = scanner.next();
        data.getData("/home/nasriddin/Inha/BigData/K_Means_clustring/Dataset1.txt");
//        System.out.println(data.getData(file));

        int execution = 1;

        do {
            int clusters = 15;//number of clusters
            int iteration = clusters;//number of iteration
            double[] centers = new double[clusters];

            for (int i = 0; i < centers.length; i++) {
                centers[i] = new Random().nextInt(5000);
//                System.out.println(centers[i]);
            }
            Arrays.sort(centers);

//            System.out.println(Arrays.toString(centers));

            Map<Integer, String[]> firstClustered = new HashMap<>();
            firstClustered = kmeans(numbers, centers, clusters);



//            TODO Get index of them and select first K points then make a loop. do not go for features
//            double[] jj = new double[dimensionNumber];
//            int a = 0;
//            for (int i = 0; i < clusters; i++) {
//                jj = data.dimension.get(a++);
//                centers.put(i, jj);
//            }
//            Map<double[], Integer> clusterings = new HashMap<>();
//            clusterings = kmeans(data.dimension, centers, clusters);
//            System.out.println(Arrays.toString(data.dimension.get(0)));
//
//            for (double[] key : clusterings.keySet()) {
//                for (int i = 0; i < key.length; i++) {
//                    System.out.print(key[i] + " ");
//                }
//                System.out.print(clusterings.get(key) + "\n");
//            }
//
//            double dimensionalTwo[] = new double[dimensionNumber];
//
//            for (int i = 0; i < iteration; i++) {
//                for (int j = 0; j < clusters; j++) {
//                    List<double[]> list = new ArrayList<>();
//                    for (double[] key : clusterings.keySet()) {
//                        if (clusterings.get(key) == j) {
//                            list.add(key);
//                        }
//                    }
//
//                    dimensionalTwo = centerCalculator(list);
//                    centers.put(j, dimensionalTwo);
//
//                }
//
//                clusterings.clear();
//                clusterings = kmeans(data.dimension, centers, clusters);
//            }
//
//            System.out.println("\nFinal clustering");
//            System.out.println("First dimension\tSecond dimension");
//
//            for (double[] key : clusterings.keySet()) {
//                for (int i = 0; i < key.length; i++) {
//                    System.out.print(key[i] + "\t \t");
//                }
//                System.out.print(clusterings.get(key) + "\n");
//            }
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
        double sum = 0;
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


    public static Map<Integer, String[]> kmeans(List<String[]> features, double[] centers, int cluster) {
        Map<Integer, String[]> clusters = new HashMap<>();
        int cluster1 = 0;
        int dist = 0;
        int minimum = 5000;
        for (int i = 0; i < features.toArray().length; i++) {
            String[] x = features.get(i);
            int t=0;
            for (int j = 0; j < cluster; j++) {

                dist = ClustererClass.distanceGet(centers[j], i);
                if (dist < minimum) {
                    minimum = dist;
                    cluster1 = j;
                }
            }
//            if (clusters.get(cluster1 - 1))
            clusters.put(cluster1, x);
        }
        System.out.println(Arrays.toString(clusters.keySet().toArray()));

        return clusters;
    }
}

