import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileABCD = rd.readLine();
        String filePoints = rd.readLine();
        ArrayList<Float> arrayABCD = new ArrayList<>();
        ArrayList<Float> arrayPoints = new ArrayList<>();


        FileReader fr = new FileReader(fileABCD);
        Scanner sc = new Scanner(fr);
        String[] st;


        while (sc.hasNextLine()) {

            st = sc.nextLine().replace("\\n", "").split(" ");
            for (int i = 0; i < st.length; i++) {
                arrayABCD.add(Float.parseFloat(st[i]));
            }
        }
        float Ax = arrayABCD.get(0);
        float Ay = arrayABCD.get(1);
        float Bx = arrayABCD.get(2);
        float By = arrayABCD.get(3);
        float Cx = arrayABCD.get(4);
        float Cy = arrayABCD.get(5);
        float Dx = arrayABCD.get(6);
        float Dy = arrayABCD.get(7);

        FileReader fr2 = new FileReader(filePoints);
        Scanner sc2 = new Scanner(fr2);
        String[] str;

        while (sc2.hasNextLine()) {

            str = sc2.nextLine().replace("\\n", "").split(" ");
            for (int i = 0; i < str.length; i++) {
                arrayPoints.add(Float.parseFloat(str[i]));
            }
        }
        int k = 0;
        for (int i = 0; i < arrayPoints.size() / 2; i++) {
            float px = arrayPoints.get(k);
            k++;
            float py = arrayPoints.get(k);
            k++;
           // System.out.println(AB(Cx, Cy, Dx, Dy, px, py));
            if (AB(Ax, Ay, Bx, By, px, py).equals("inpoint") || AB(Bx, By, Cx, Cy, px, py).equals("inpoint")
                    || AB(Cx, Cy, Dx, Dy, px, py).equals("inpoint") || AB(Dx, Dy, Ax, Ay, px, py).equals("inpoint")) {
                System.out.println(0);
            }
            if (AB(Ax, Ay, Bx, By, px, py).equals("between") || AB(Bx, By, Cx, Cy, px, py).equals("between")
                    || AB(Cx, Cy, Dx, Dy, px, py).equals("between") || AB(Dx, Dy, Ax, Ay, px, py).equals("between")) {
                System.out.println(1);
            }
            if (AB(Ax, Ay, Bx, By, px, py).equals("right") && AB(Bx, By, Cx, Cy, px, py).equals("right")
                    && AB(Cx, Cy, Dx, Dy, px, py).equals("right") && AB(Dx, Dy, Ax, Ay, px, py).equals("right")) {
                System.out.println(2);
            }
            if (AB(Ax, Ay, Bx, By, px, py).equals("left") || AB(Bx, By, Cx, Cy, px, py).equals("left")
                    || AB(Cx, Cy, Dx, Dy, px, py).equals("left") || AB(Dx, Dy, Ax, Ay, px, py).equals("left")) {
                System.out.println(3);
            }

        }



    }

    public static String AB(float Ax, float Ay, float Bx, float By, float Px, float Py) {
        float ax = Bx - Ax;
        float ay = By - Ay;
        float bx = Px - Ax;
        float by = Py - Ay;
        float sa = ax * by - bx * ay; // косое произведение

        float cx = Ax - Px;
        float cy = Ay - Py;
        float dx = Bx - Px;
        float dy = By - Py;
        float ca = cx * dx + cy * dy; // скалярное

        if ((Ax == Px && Ay == Py) || (Bx == Px && By == Py)) return "inpoint";
        else if (sa > 0.0) return "left";
        else if (sa < 0.0) return "right";
        else if  (sa == 0 && ca <= 0) return "between";
        else return "";


    }


// /Users/goshann/Desktop/test.txt
// /Users/goshann/Desktop/test2.txt
}
