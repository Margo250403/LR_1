import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //Створюємо матрицю та заповнюємо її
    public static int[][]getArray(int length){
        int[][] array=new int[length][length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = ((int) (Math.random() * 31) - 15);//Заповнюємо масив рандомними числами від -15 до 15
            }
        }
        return array;//Повертаемо array
    }
    //Виводимо матрицю
    public static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print("\t|\t"+array[i][j]+"\t|\t");
            }
            System.out.println();
        }
    }

    //Пошук за номером рядка
    public static void Search(int[][] array,int number){
        System.out.println("Номер рядка " +number);
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t|\t"+array[number - 1][i] +"\t|\t");//Виводимо рядок
        }
        System.out.println();
    }




    public static void main(String[] arghs) {
        Scanner sc = new Scanner(System.in, "cp1251");
        try {
            int max=10;
            System.out.print("Введіть розмір матриці(Макс=10):");
            int length = sc.nextInt();//Вводимо розмір
            int[][] array = getArray(length);
            printArray(array);
            while (max>=length)
            {
                try {
                    System.out.print("Введіть номер рядка:");
                    int number = sc.nextInt();//Вводимо номер рядка який хочемо вивести
                    Search(array,number);
                    break;
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Немає такого номера рядка");//Помилка за вводом неіснуючого рядка
                    continue;
                }
                catch (Exception e){
                    sc.nextLine();
                    System.out.println("Введіть ціле число");
                    continue;
                }
            }
        }
        catch (InputMismatchException e){
            sc.nextLine();
            System.out.println("Невірний формат. Введіть ціле число");
            main(arghs);
        }
    }
}
