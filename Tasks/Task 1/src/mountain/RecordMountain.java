package mountain;
import java.util.Scanner;

class Gora{
    String name; // ����� ����
    String place; // ���� ����
    double high; // ������ ����
}
public class RecordMountain{
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
// �������� ���������� ��� ����
        System.out.println("������ ������� �� => ");
        int n = sc.nextInt(); // ������� ��
        Gora mount[] = new Gora[n];
        System.out.println("������ ���������� ��� ����: ");
        for (int i = 0; i < mount.length; i++) {
            sc.nextLine(); // �������� ������
            mount[i] = new Gora();
            System.out.print("����� " + (i + 1) + "-� ���� => ");
            mount[i].name = sc.nextLine();
            System.out.print("̳��� ������������ " + (i + 1) + "-� ���� => ");
            mount[i].place = sc.nextLine();
            System.out.print("������ " + (i + 1) + "-� ���� => ");
            mount[i].high = sc.nextDouble();
        }
// ��������� �������� ����������
        System.out.println("\n�������������� ��:");
        for(int i = 0; i < mount.length; i++) {
            System.out.println(""+mount[i].name+"\t"+mount[i].place+"\t"+mount[i].high+ "��");
        }
        int nommax=0; //����� �������� ��� ���� � ������������ ������� (��������� ��������)

        double max=mount[nommax].high; //����������� ������ (��������� ��������)
        for (int i = 0; i < mount.length; i++) if (mount[i].high>max) {
            max = mount [i]. high;
            nommax=i;
        }
        System.out.println("\n���� � ������������ �������:");
        System.out.println(""+mount[nommax].name+"\t"+mount[nommax].high + "��");
// C����� �� ����� 1000 �
        System.out.println("\n������ �� ����� 1000 �:");
        for (int i = 0; i < mount.length; i++)if (mount[i].high>=1000) {
                System.out.println(""+mount[i].name);
        }
// ���������� �� �� �������
        for (int i = 0; i < mount.length-1; i++)
        for (int j = 0; j < mount.length-1-i; j++)
        if (mount[j].high>mount[j+1].high){
            Gora rab=mount[j]; //rab � ������ ����� ��� ������������
            mount [j] = mount [j + 1];
            mount [j + 1] = rab;
        }
        System.out.println("\n³����������� ������ �� �������: ");
        for (int i = 0; i < mount.length; i++) {
            System.out.println(""+mount[i].name+"\t"+mount[i].place +"\t"+mount[i].high+ " ��");
        }
        sc.nextLine(); // �������� ������
        System.out.println("������ ����� ������ ���� =>");
        String name=sc.nextLine();
        int nom= -1; //-1 � ���� � ������� ������ �������
        for (int i = 0; i < mount.length; i++)
        if (name.equalsIgnoreCase(mount[i].name)) nom=i;
        if (nom != -1) {
            System.out.println("���� ���� � � ������. �� "
                    +mount[nom].name+"\t"+mount[nom].place +"\t"+mount[nom].high+ " ��");
        }else System.out.println("���� ���� ���� � ������");

        System.out.println("������ ����� ����, ��� ��� ������� ������ =>");
        String rename=sc.nextLine();
        int nome= -1; //-1 � ���� � ������� ������ �������
        for (int i = 0; i < mount.length; i++)
            if (rename.equalsIgnoreCase(mount[i].name)) nome=i;
        if (nome != -1) {
            System.out.println("���� ����� ������������ "
                    +mount[nome].name+"\t"+mount[nome].place +"\t"+mount[nome].high+ " ��");
            System.out.println("��� ��������� �����, ������ '�����', ��� ����-'̳���', ��� ������-'������' =>");
            String number = sc.nextLine();
            switch (number){
                case "�����":
                    System.out.println("������ ����� ����, ��� ������ =>");
                    String rename_gor1=sc.nextLine();
                    mount[nome].name=rename_gor1;
                    System.out.println("���� ���� ����������� "
                            +mount[nome].name+"\t"+mount[nome].place +"\t"+mount[nome].high+ " ��");
                    break;
                case "̳���":
                    System.out.println("������ ���� ������������ ����, ��� ������ =>");
                    String rename_place1=sc.nextLine();
                    mount[nome].place=rename_place1;
                    System.out.println("���� ���� ����������� "
                            +mount[nome].name+"\t"+mount[nome].place +"\t"+mount[nome].high+ " ��");
                    break;
                case "������":
                    System.out.println("������ ������ ����, ��� ������ =>");
                    double rename_high1= sc.nextDouble();
                    mount[nome].high=rename_high1;
                    System.out.println("���� ���� ����������� "
                            +mount[nome].name+"\t"+mount[nome].place +"\t"+mount[nome].high+ " ��");
                    break;
            }
        }
    }
}
