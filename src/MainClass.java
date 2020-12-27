import java.io.IOException;
import java.util.*;

public class MainClass {
    //    get Dataset / read Dataset
//    make first clustering
//    make loop clustering according to K
    public static void main(String args[]) throws IOException {

        Scanner scanner = new Scanner(System.in);
        GetData data = new GetData();

        System.out.println("Enter the filename with path");

        String file = scanner.next();
        data.getData(file);

        System.out.println(file);
    }
}

