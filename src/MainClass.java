import java.io.IOException;
import java.util.*;

public class MainClass {

    //    get Dataset / read Dataset
//    make first clustering
//    make loop clustering according to K
    public static void main(String args[]) throws IOException {

        Scanner scanner = new Scanner(System.in);
        GetData data = new GetData();
        ClustererClass cluster = new ClustererClass();
        data.features.clear();
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
//            double[] jj = new double[numberOfFeatures];
//            int a = 0;
//            for (int i = 0; i < clusters; i++){
//
//                jj = data.features.get(a++);
//                centers.put(i, jj);
//
//            }
//            Map<double[], Integer> clusterings = new HashMap<>();
//            clusterings = kmeans(data.features, distance, centroids, k);


        }while(execution == 1);


    }
//    private int randomNumber(){
//
//
//        return
//    }

    public static Map<double[], Integer> kmeans(List<double[]> features, int distance, Map<Integer, double[]> centroids, int k){

    }
}

