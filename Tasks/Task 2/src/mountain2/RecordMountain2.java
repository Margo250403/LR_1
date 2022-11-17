package mountain2;

import java.util.Scanner;

class Gora{
    String name; // назва гори
    String place; // місце гори
    double high; // висота гори
}
public class RecordMountain2{
    public static Gora[]setMountArr(int gor){
        // Введення інформації
        Scanner sc = new Scanner(System.in, "cp1251");
        Gora mount[]=new Gora[gor];// кількість гір
        System.out.println("Введіть інформацію про гори => ");
        for (int i=0; i<mount.length; i++){
            mount[i]=new Gora();
            System.out.println("Назва " + (i + 1) + "-ї гори => ");

            mount[i].name = sc.nextLine();
            System.out.print("Місце розташування " + (i + 1) + "-ї гори => ");

            mount[i].place = sc.nextLine();

            System.out.print("Висота " + (i + 1) + "-ї гори => ");

            mount[i].high = sc.nextDouble();
            sc.nextLine();
        }
        return mount;
    }
    // Виведення масиву
    public static void showArray(Gora[] gr){
        for(int i = 0; i < gr.length; i++) {
            System.out.println(""+gr[i].name+"\t"+gr[i].place+"\t"+gr[i].high+ "км");
        }
    }
    public static void showMount(Gora gr){
            System.out.println(""+gr.name+"\t"+gr.place+"\t"+gr.high+ "км");

    }
    public static int NomMax (Gora []mon){
        int nommax=0; //номер елемента для гори з максимальною висотою (початкове значення)

        double max=mon[nommax].high; //максимальна висота (початкове значення)
        for (int i = 0; i < mon.length; i++) if (mon[i].high>max) {
            max = mon[i].high;
            nommax=i;
        }
        return nommax;
    }
    // Cписок гір понад 1000 м
    public static void Over1000(Gora[]gr){
        for (int i = 0; i < gr.length; i++)
            if (gr[i].high>=1000){
            System.out.println(""+gr[i].name);
            }
    }
    // Сортування гір за висотою
    public static void sortHigh(Gora[]gr){
        for (int i=0; i< gr.length-1;i++)
            for (int j=0; j< gr.length-1;j++)
                if(gr[j].high>gr[j+1].high){
                    Gora rab=gr[j]; //rab – робоча змінна для перестановки
                    gr [j] = gr [j + 1];
                    gr [j + 1] = rab;
                }

    }
    //Пошук за назвою
    public static Gora findForName(Gora gr[],String name){
        int nom=-1;//-1 – гора з шуканою назвою відсутня
        for (int i = 0; i < gr.length; i++)
            if (name.equalsIgnoreCase(gr[i].name)) nom=i;
        if (nom != -1) {
            return gr[nom];
        }else return null;
    }
    //Редагування
    public static Gora Rename(Gora gr[],String name, String number){
        Scanner sc = new Scanner(System.in, "cp1251");
        int nome= -1; //-1 – гора з шуканою назвою відсутня
        for (int i = 0; i < gr.length; i++)
            if (name.equalsIgnoreCase(gr[i].name)) nome=i;
        if (nome != -1) {
            System.out.println("Гора перед виправленням "
                    +gr[nome].name+"\t"+gr[nome].place +"\t"+gr[nome].high+ " км");
            switch (number){
                case "Назва":
                    System.out.println("Введіть назву гори, щоб змінити =>");
                    gr[nome].name = sc.nextLine();
                    System.out.println("Гора після виправлення "
                            +gr[nome].name+"\t"+gr[nome].place +"\t"+gr[nome].high+ " км");
                    break;
                case "Місце":
                    System.out.println("Введіть місце розташування гори, щоб змінити =>");
                    gr[nome].place=sc.nextLine();;
                    System.out.println("Гора після виправлення "
                            +gr[nome].name+"\t"+gr[nome].place +"\t"+gr[nome].high+ " км");
                    break;
                case "Висота":
                    System.out.println("Введіть висоту гори, щоб змінити =>");
                    gr[nome].high =sc.nextDouble();
                    System.out.println("Гора після виправлення "
                            +gr[nome].name+"\t"+gr[nome].place +"\t"+gr[nome].high+ " км");
                    break;
            }
        }
        return gr[nome];
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
// Введення інформації
        System.out.println("Введіть кількість гір => ");
        int n = sc.nextInt(); // кількість гір
        Gora mount[] = setMountArr(n);
        System.out.println("\nХарактеристики країн: ");
        showArray(mount);// Виведення отриманої інформації

        int nommax=NomMax(mount);
        System.out.println("\nГора з максимальною висотою:");
        showMount(mount[nommax]);

        System.out.println("\nСписок гір понад 1000 м:");
        Over1000(mount);

        sortHigh(mount);
        System.out.println("\nВідсортований список за висотою: ");
        showArray(mount);

        System.out.println("\nПошук країни \nВведіть назву гори =>");
        sc.nextLine(); // очищення буфера
        String name=sc.nextLine();
        Gora find=findForName(mount,name);if (find!=null){
            showMount(find);
        }else {
            System.out.println("Такої гори немає у списку");
        }

        System.out.println("Введіть назву гори, дані якої потрібно змінити =>");
        String rname= sc.nextLine();
        System.out.println("Щоб виправити назву, введіть 'Назва', щоб місце-'Місце', щоб висоту-'Висота' =>");
        String number=sc.nextLine();
        Gora rename=Rename(mount,rname,number); if (rename != null) {
            showMount(rename);
        } else{
            System.out.println("Такої гори немає у списку");
        }
    }
}
