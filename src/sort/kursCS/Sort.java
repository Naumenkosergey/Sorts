package sort.kursCS;

import java.util.Random;

public class Sort {
    private static int countH = 0;
    private static int countB = 0;
    private static int countV = 0;
    private static int countS = 0;
    private static int countVib = 0;

    public static void printArry(int[] a) {
        System.out.print("[ ");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.print("]");
    }

    public static void boblSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = a.length - 1; j >= i; j--) {
                if (a[j - 1] > a[j]) {
                    int buf = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = buf;
                }
                countB++;
            }
            countB++;
        }
        System.out.println("\nМассив после пузырька: " + "Всего итераций: " + countB);
    }

    public static void viborSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int min_i = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    min_i = j;
                }
                countVib++;
            }
            if (i != min_i) {
                int buf = a[i];
                a[i] = a[min_i];
                a[min_i] = buf;
            }
            countVib++;
        }
        System.out.println("\nМассив после выборки: " + "Всего итераций: " + countVib);
    }

    //    public static void shakerSort(int[] a) {
//        int min, max;
//        for (int i = 0; i < a.length / 2; i++) {
//            if (a[i] > a[i + 1]) {
//                min = i + 1;
//                max = i;
//            } else {
//                min = i;
//                max = i + 1;
//            }
//            for (int j = i + 2; j < a.length - i + 1; j++) {
//                if (a[j] > a[max]) {
//                    max = i;
//                } else if (a[j] < a[min]) {
//                    min = j;
//                }
//
//            }
//            int buf = a[i];
//            a[i] = a[min];
//            a[min] = buf;
//            if (max == i) {
//                max = min;
//            }
//            buf = a[a.length - i + 1];
//            a[a.length - i + 1] = a[max];
//            a[max] = buf;
//
//        }
//    }
    public static void vstavkamiSort(int[] a) {
        int key;
        for (int i = 0; i < a.length; i++) {
            key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {//если поменять знак возле key то будет сортироваться от большего
                a[j + 1] = a[j];
                j--;
                countV++;
            }
            a[j + 1] = key;
            countV++;
        }
        System.out.println("\nМассив после вставок: " + "Всего итераций: " + countV);
    }

    public static void shelSort(int[] a) {
        int step = 1;
        while (step < a.length / 3) {
            step = 3 * step + 1;
        }
        while (step >= 1) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i; j >= step && a[j] < a[j - step]; j -= step) {
                    //если поменять знак во втором условии то получится по убыванию
                    int buf = a[j];
                    a[j] = a[j - step];
                    a[j - step] = buf;
                    countS++;
                }
                countS++;
            }
            step = step / 3;
            countS++;
        }
        System.out.println("\nМассив после Шелла: " + "Всего итераций: " + countS);
    }


    public static void choarSort(int[] a, int l, int r) {

        if (a.length == 0) return;
        if (l >= r) return;
        int midle = l + (r - l) / 2;
        int opora = a[midle];
        int i = l;
        int j = r;
        while (i <= j) {
            while (a[i] < opora) {
                i++;
                countH++;
            }
            while (a[j] > opora) {
                j--;
                countH++;
            }
            if (i <= j) {
                int buf = a[i];
                a[i] = a[j];
                a[j] = buf;
                i++;
                j--;
            }
            countH++;
        }
        if (l < j) {
            choarSort(a, l, j);
        }
        if (r > i) {
            choarSort(a, i, r);
        }

    }

    public static void main(String[] args) {
        // write your code here
        final int N = 1000000;
        Random rnd = new Random();
        int[] mas = new int[N];
        for (int i = 0; i < N; i++) {
            mas[i] = rnd.nextInt() % 10;
        }
        System.out.println("Исходный Массив: ");
        //printArry(mas);
        boblSort(mas);
        //printArry(mas);

        viborSort(mas);
        //printArry(mas);
        //shakerSort(mas);
        //printArry(mas);

        vstavkamiSort(mas);
        //printArry(mas);

        shelSort(mas);
        //printArry(mas);

        choarSort(mas, 0, N - 1);
        System.out.println("\nМассив после Хооара: " + "Всего итераций: " + countH);
        //printArry(mas);


    }
}
