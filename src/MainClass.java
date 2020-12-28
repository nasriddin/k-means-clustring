import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MainClass extends GetData {

    public static void main(String args[]) throws IOException {

        Scanner scanner = new Scanner(System.in);
        GetData data = new GetData();
        ClustererClass cluster = new ClustererClass();
        data.dimension.clear();
        System.out.println("Enter the filename with path");
        // /home/nasriddin/Inha/BigData/K_Means_clustring/Dataset1.txt
        System.out.println("Enter the filename with path");

        String file = scanner.next();
        data.getData(file);

        int execution = 1;

        do {
            int clusters = 15;//number of clusters
            int iteration = clusters;//number of iteration
            double[] centers = new double[clusters];

            for (int i = 0; i < centers.length; i++) {
                centers[i] = new Random().nextInt(5000);
            }
            Arrays.sort(centers);


            Map<Integer, List<String[]>> firstClustered = new HashMap<>();
            firstClustered = kmeans(numbers, centers, clusters);

            execution = scanner.nextInt();

        } while (execution == 1);


    }




    public static Map<Integer, List<String[]>> kmeans(List<String[]> features, double[] centers, int cluster) {
        Map<Integer, List<String[]>> clusters = new HashMap<>();
        int indexes[];
        int cluster1 = 0;
        int dist = 0;
        for (int i = 0; i < features.toArray().length; i++) {
            int minimum = 5000;
            String[] x = features.get(i);
            int t = 0;
            System.out.println(cluster);
            for (int j = 0; j < cluster; j++) {

                dist = ClustererClass.distanceGet(centers[j], i);
                if (dist < minimum) {
                    minimum = dist;
                    cluster1 = j;

                }

            }
            List<String[]> list = new ArrayList<>();
            if (clusters.get(cluster1) != null) list.addAll(clusters.get(cluster1));
            list.add(x);
            clusters.put(cluster1, list);
        }
        clusters.forEach((integer, strings) -> {
            File file = new File("set1-c"+integer+".txt");
            file.exists();
            try {
                FileWriter writer = new FileWriter(file);
                strings.forEach(strings1 -> {
                    try {
                        writer.write(Arrays.toString(strings1));
                        writer.write("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        System.out.println(Arrays.toString(clusters.get(0).toArray()));

        return clusters;
    }
}

