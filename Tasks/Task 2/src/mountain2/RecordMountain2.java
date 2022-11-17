package mountain2;

import java.util.Scanner;

class Gora{
    String name; // ����� ����
    String place; // ���� ����
    double high; // ������ ����
}
public class RecordMountain2{
    public static Gora[]setMountArr(int gor){
        // �������� ����������
        Scanner sc = new Scanner(System.in, "cp1251");
        Gora mount[]=new Gora[gor];// ������� ��
        System.out.println("������ ���������� ��� ���� => ");
        for (int i=0; i<mount.length; i++){
            mount[i]=new Gora();
            System.out.println("����� " + (i + 1) + "-� ���� => ");

            mount[i].name = sc.nextLine();
            System.out.print("̳��� ������������ " + (i + 1) + "-� ���� => ");

            mount[i].place = sc.nextLine();

            System.out.print("������ " + (i + 1) + "-� ���� => ");

            mount[i].high = sc.nextDouble();
            sc.nextLine();
        }
        return mount;
    }
    // ��������� ������
    public static void showArray(Gora[] gr){
        for(int i = 0; i < gr.length; i++) {
            System.out.println(""+gr[i].name+"\t"+gr[i].place+"\t"+gr[i].high+ "��");
        }
    }
    public static void showMount(Gora gr){
            System.out.println(""+gr.name+"\t"+gr.place+"\t"+gr.high+ "��");

    }
    public static int NomMax (Gora []mon){
        int nommax=0; //����� �������� ��� ���� � ������������ ������� (��������� ��������)

        double max=mon[nommax].high; //����������� ������ (��������� ��������)
        for (int i = 0; i < mon.length; i++) if (mon[i].high>max) {
            max = mon[i].high;
            nommax=i;
        }
        return nommax;
    }
    // C����� �� ����� 1000 �
    public static void Over1000(Gora[]gr){
        for (int i = 0; i < gr.length; i++)
            if (gr[i].high>=1000){
            System.out.println(""+gr[i].name);
            }
    }
    // ���������� �� �� �������
    public static void sortHigh(Gora[]gr){
        for (int i=0; i< gr.length-1;i++)
            for (int j=0; j< gr.length-1;j++)
                if(gr[j].high>gr[j+1].high){
                    Gora rab=gr[j]; //rab � ������ ����� ��� ������������
                    gr [j] = gr [j + 1];
                    gr [j + 1] = rab;
                }

    }
    //����� �� ������
    public static Gora findForName(Gora gr[],String name){
        int nom=-1;//-1 � ���� � ������� ������ �������
        for (int i = 0; i < gr.length; i++)
            if (name.equalsIgnoreCase(gr[i].name)) nom=i;
        if (nom != -1) {
            return gr[nom];
        }else return null;
    }
    //�����������
    public static Gora Rename(Gora gr[],String name, String number){
        Scanner sc = new Scanner(System.in, "cp1251");
        int nome= -1; //-1 � ���� � ������� ������ �������
        for (int i = 0; i < gr.length; i++)
            if (name.equalsIgnoreCase(gr[i].name)) nome=i;
        if (nome != -1) {
            System.out.println("���� ����� ������������ "
                    +gr[nome].name+"\t"+gr[nome].place +"\t"+gr[nome].high+ " ��");
            switch (number){
                case "�����":
                    System.out.println("������ ����� ����, ��� ������ =>");
                    gr[nome].name = sc.nextLine();
                    System.out.println("���� ���� ����������� "
                            +gr[nome].name+"\t"+gr[nome].place +"\t"+gr[nome].high+ " ��");
                    break;
                case "̳���":
                    System.out.println("������ ���� ������������ ����, ��� ������ =>");
                    gr[nome].place=sc.nextLine();;
                    System.out.println("���� ���� ����������� "
                            +gr[nome].name+"\t"+gr[nome].place +"\t"+gr[nome].high+ " ��");
                    break;
                case "������":
                    System.out.println("������ ������ ����, ��� ������ =>");
                    gr[nome].high =sc.nextDouble();
                    System.out.println("���� ���� ����������� "
                            +gr[nome].name+"\t"+gr[nome].place +"\t"+gr[nome].high+ " ��");
                    break;
            }
        }
        return gr[nome];
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
// �������� ����������
        System.out.println("������ ������� �� => ");
        int n = sc.nextInt(); // ������� ��
        Gora mount[] = setMountArr(n);
        System.out.println("\n�������������� ����: ");
        showArray(mount);// ��������� �������� ����������

        int nommax=NomMax(mount);
        System.out.println("\n���� � ������������ �������:");
        showMount(mount[nommax]);

        System.out.println("\n������ �� ����� 1000 �:");
        Over1000(mount);

        sortHigh(mount);
        System.out.println("\n³����������� ������ �� �������: ");
        showArray(mount);

        System.out.println("\n����� ����� \n������ ����� ���� =>");
        sc.nextLine(); // �������� ������
        String name=sc.nextLine();
        Gora find=findForName(mount,name);if (find!=null){
            showMount(find);
        }else {
            System.out.println("���� ���� ���� � ������");
        }

        System.out.println("������ ����� ����, ��� ��� ������� ������ =>");
        String rname= sc.nextLine();
        System.out.println("��� ��������� �����, ������ '�����', ��� ����-'̳���', ��� ������-'������' =>");
        String number=sc.nextLine();
        Gora rename=Rename(mount,rname,number); if (rename != null) {
            showMount(rename);
        } else{
            System.out.println("���� ���� ���� � ������");
        }
    }
}
