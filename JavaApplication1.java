package javaapplication1;


import java.util.*;

public class JavaApplication1 {


    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        System.out.print("Enter number of equations: ");
        m = sc.nextInt(); // количество уравнений

        System.out.print("Enter number of variables: ");
        n = sc.nextInt(); // количество переменных

        GaussMethod sample = new GaussMethod(m, n);

        sample.fillMatrix();
        sample.rightGaussianStroke();

        System.out.println(sample);
        sample.backGaussianStroke();

        System.out.println("The answer: \n");
        System.out.println(sample.answer());
    }    
}
