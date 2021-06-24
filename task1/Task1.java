import java.io.*;
import java.util.*;

public class Task1  {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
         String file = rd.readLine();
        ArrayList<Integer> array = new ArrayList<>();

        FileReader fr = new FileReader(file);
        Scanner sc = new Scanner(fr);

        while (sc.hasNextLine()) {
            array.add(Integer.parseInt(sc.nextLine()));


        }

            Collections.sort(array);

        System.out.println(array);
        System.out.format("%.2f" + "%n",percentile(array, 90));
        System.out.format("%.2f" + "%n",median(array));
        System.out.format("%.2f" + "%n",max(array));
        System.out.format("%.2f" + "%n",min(array));
        System.out.format("%.2f" + "%n",arifmeticMean(array));



    }


    public static float max(ArrayList<Integer> arrayList) {

        return (float) arrayList.get(arrayList.size() - 1);
    }

    public static float min(ArrayList<Integer> arrayList) {

        return (float) arrayList.get(0);
    }

    public static float arifmeticMean(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (int n : arrayList ){
            sum = sum + n;
        }
        return (float) sum / arrayList.size();
    }

    public static float median(ArrayList<Integer> arrayList) {
        if (arrayList.size() % 2 == 0){
            return (float) (arrayList.get(arrayList.size() / 2) + arrayList.get(arrayList.size() / 2 - 1)) / 2 ;
        } else return  (float) arrayList.get(arrayList.size() / 2);

    }

    public static double percentile(ArrayList<Integer> arrayList, double percentile) {

        double index = percentile / 100D * (arrayList.size() - 1) + 1 ;

        int n = (int)index;

       return arrayList.get(n - 1) + (index - n) * ((arrayList.get(n)) - arrayList.get(n - 1));


    }




}
