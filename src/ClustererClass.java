import java.util.ArrayList;
import java.util.List;

public class ClustererClass {
    public static double distanceGet(double point1[], double point2[]){
        double sum = 0.0;
        for(int i = 0; i < point1.length; i++) {
            sum += (Math.abs(point1[i] - point2[i]));
        }
        return sum;
    }
}
