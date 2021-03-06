import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class MainClass extends GetData {

    public static void main(String args[]) throws IOException {
//        File file = new File("final-centers-1.txt");

        Scanner scanner = new Scanner(System.in);
        GetData data = new GetData();
        ClustererClass cluster = new ClustererClass();
        data.dimension.clear();
        // /home/nasriddin/Inha/BigData/K_Means_clustring/Dataset1.txt
        // /home/nasriddin/Inha/BigData/K_Means_clustring/Dataset2.txt
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
            System.out.println("First centers: "+ Arrays.toString(Arrays.stream(centers).toArray()));

            Map<Integer, List<String[]>> firstClustered = new HashMap<>();
            firstClustered = kMeaning(numbers, centers, clusters);

            execution = scanner.nextInt();

        } while (execution == 1);


    }



    public static Map<Integer, List<String[]>> kMeaning(List<String[]> features, double[] centers, int cluster) {
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
            int center_index = (int) (strings.size() / 2);
            System.out.println(""+integer+ Arrays.toString(Arrays.stream(strings.get(center_index)).toArray()));


            File file = new File("set2-c" + integer + ".txt");

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

        return clusters;
    }
}

