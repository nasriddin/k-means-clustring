import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GetData {

    protected static List<String[]> numbers = new ArrayList<>();
    protected List<double[]> dimension = new ArrayList<>();
    protected static int counter;
    protected static int dimensionNumber;


    void getData(String s) throws NumberFormatException, IOException {

        File file = new File(s);
        try {
            BufferedReader getData = new BufferedReader(new FileReader(file));
            String line;
            while ((line = getData.readLine()) != null) {
                String[] split = line.trim().split("\t");
                numbers.add(split);
                counter = line.length() + 1;
            }
            System.out.println(Arrays.toString(numbers.get(0)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println(numbers.get(0));
    }
}
