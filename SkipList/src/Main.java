import java.sql.Array;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer> []arr(ArrayList<Integer> arr[], int n){
        for(int i = 0; i<n; i++){
            ArrayList<Integer> arr1 = new ArrayList<>();
            arr[i] = arr1;
        }
        return arr;
    }
    public static void main(String[] args) {
        ArrayList<Integer> [] ar = new ArrayList[6];
        ArrayList<Integer>[] a = arr(ar, 6);
        a[1].add(55);
        for (int i = 0; i<6;i++){
            System.out.println(a[i].toString());
        }
    }
}