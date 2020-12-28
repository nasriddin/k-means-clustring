import java.util.ArrayList;
import java.util.List;

public class ClustererClass {
    public static int distanceGet(double point1, int point2){
        int sum = 0;
        sum += (Math.abs(point1 - point2));

        return sum;
    }
}
