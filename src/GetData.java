import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetData {
    protected List<double[]> numbers=new ArrayList<>();

    void getData(String s) throws NumberFormatException, IOException {

        File file = new File(s);
        try {
            BufferedReader getData = new BufferedReader(new FileReader(file));
            String line;
            while((line=getData.readLine()) != null)
            {
                System.out.print(line);
                break;
//                String[] split = line.split(",");
//                double[] feature = new double[split.length - 1];
//                for (int i = 0; i < split.length - 1; i++)
//                    feature[i] = Double.parseDouble(split[i]);
//                String labels = split[feature.length];
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
