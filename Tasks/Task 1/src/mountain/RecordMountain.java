package mountain;
import java.util.Scanner;

class Gora{
    String name; // назва гори
    String place; // місце гори
    double high; // висота гори
}
public class RecordMountain{
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
// Введення інформації про гори
        System.out.println("Введіть кількість гір => ");
        int n = sc.nextInt(); // кількість гір
        Gora mount[] = new Gora[n];
        System.out.println("Введіть інформацію про гори: ");
        for (int i = 0; i < mount.length; i++) {
            sc.nextLine(); // очищення буфера
            mount[i] = new Gora();
            System.out.print("Назва " + (i + 1) + "-ї гори => ");
            mount[i].name = sc.nextLine();
            System.out.print("Місце розташування " + (i + 1) + "-ї гори => ");
            mount[i].place = sc.nextLine();
            System.out.print("Висота " + (i + 1) + "-ї гори => ");
            mount[i].high = sc.nextDouble();
        }
// Виведення отриманої інформації
        System.out.println("\nХарактеристики гір:");
        for(int i = 0; i < mount.length; i++) {
            System.out.println(""+mount[i].name+"\t"+mount[i].place+"\t"+mount[i].high+ "км");
        }
        int nommax=0; //номер елемента для гори з максимальною висотою (початкове значення)

        double max=mount[nommax].high; //максимальна висота (початкове значення)
        for (int i = 0; i < mount.length; i++) if (mount[i].high>max) {
            max = mount [i]. high;
            nommax=i;
        }
        System.out.println("\nГора з максимальною висотою:");
        System.out.println(""+mount[nommax].name+"\t"+mount[nommax].high + "км");
// Cписок гір понад 1000 м
        System.out.println("\nСписок гір понад 1000 м:");
        for (int i = 0; i < mount.length; i++)if (mount[i].high>=1000) {
                System.out.println(""+mount[i].name);
        }
// Сортування гір за висотою
        for (int i = 0; i < mount.length-1; i++)
        for (int j = 0; j < mount.length-1-i; j++)
        if (mount[j].high>mount[j+1].high){
            Gora rab=mount[j]; //rab – робоча змінна для перестановки
            mount [j] = mount [j + 1];
            mount [j + 1] = rab;
        }
        System.out.println("\nВідсортований список за висотою: ");
        for (int i = 0; i < mount.length; i++) {
            System.out.println(""+mount[i].name+"\t"+mount[i].place +"\t"+mount[i].high+ " км");
        }
        sc.nextLine(); // очищення буфера
        System.out.println("Введіть назву шуканої гори =>");
        String name=sc.nextLine();
        int nom= -1; //-1 – гора з шуканою назвою відсутня
        for (int i = 0; i < mount.length; i++)
        if (name.equalsIgnoreCase(mount[i].name)) nom=i;
        if (nom != -1) {
            System.out.println("Така гора є у списку. Це "
                    +mount[nom].name+"\t"+mount[nom].place +"\t"+mount[nom].high+ " км");
        }else System.out.println("Такої гори немає у списку");

        System.out.println("Введіть назву гори, дані якої потрібно змінити =>");
        String rename=sc.nextLine();
        int nome= -1; //-1 – гора з шуканою назвою відсутня
        for (int i = 0; i < mount.length; i++)
            if (rename.equalsIgnoreCase(mount[i].name)) nome=i;
        if (nome != -1) {
            System.out.println("Гора перед виправленням "
                    +mount[nome].name+"\t"+mount[nome].place +"\t"+mount[nome].high+ " км");
            System.out.println("Щоб виправити назву, введіть 'Назва', щоб місце-'Місце', щоб висоту-'Висота' =>");
            String number = sc.nextLine();
            switch (number){
                case "Назва":
                    System.out.println("Введіть назву гори, щоб змінити =>");
                    String rename_gor1=sc.nextLine();
                    mount[nome].name=rename_gor1;
                    System.out.println("Гора після виправлення "
                            +mount[nome].name+"\t"+mount[nome].place +"\t"+mount[nome].high+ " км");
                    break;
                case "Місце":
                    System.out.println("Введіть місце розташування гори, щоб змінити =>");
                    String rename_place1=sc.nextLine();
                    mount[nome].place=rename_place1;
                    System.out.println("Гора після виправлення "
                            +mount[nome].name+"\t"+mount[nome].place +"\t"+mount[nome].high+ " км");
                    break;
                case "Висота":
                    System.out.println("Введіть висоту гори, щоб змінити =>");
                    double rename_high1= sc.nextDouble();
                    mount[nome].high=rename_high1;
                    System.out.println("Гора після виправлення "
                            +mount[nome].name+"\t"+mount[nome].place +"\t"+mount[nome].high+ " км");
                    break;
            }
        }
    }
}
