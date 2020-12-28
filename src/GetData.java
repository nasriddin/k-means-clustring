import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetData {

    protected List<String> numbers = new ArrayList<>();
    protected List<double[]> dimension = new ArrayList<>();
    protected static int counter;
    protected static int dimensionNumber;


    void getData(String s) throws NumberFormatException, IOException {

        File file = new File(s);
        try {
            BufferedReader getData = new BufferedReader(new FileReader(file));
            String line;
            while ((line = getData.readLine()) != null) {
                String[] split = line.split(" ");
                double[] feature = new double[split.length - 1];
                dimensionNumber = split.length - 1;
                dimension.add(feature);
                String labels = split[feature.length];
                numbers.add(labels);
                counter = line.length() - 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
