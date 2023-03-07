/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt5java2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    public static int Menu() {
        System.out.println("----------Menu---------------");
        System.out.println("-----------------------------");
        System.out.println("------Pick one Option--------");
        Scanner sc = new Scanner(System.in);
        int menuid = 0;
        while (true) {
            System.out.println("-----1.Add new Student-------");
            System.out.println("-----2.Save file-------------");
            System.out.println("-----3.Display all Student---");
            System.out.println("------4.Exit-------------");
            try {
                menuid = sc.nextInt();
                if (1 <= menuid && menuid <= 4) {
                    break;
                } else {
                    System.err.println("Chon tu 1 - 4");
                    //continue;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.err.println("Chon tu 1 - 4");
            }
        }
        System.out.println("Menu : " + menuid);
        return menuid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListStudent list = new ListStudent();
        int menuID = 0;
        do {
            menuID = Menu();
            switch (menuID) {
                case 1:

                    int id;
                    String name;
                    int age;
                   
                    System.out.println("nhap id int ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("nhap ho ten");
                    name = sc.nextLine();
                    System.out.println("nhap tuoi ");
                    age = sc.nextInt();
                    list.add(id, name, age);
                    break;
                case 2:
                    boolean ressave = list.save();
                    if (ressave) {
                        System.out.println("Đã Lưu Xong");
                    } else {
                        System.out.println("Warrning, Cant Save file");
                    }
                    break;
                case 3:

                    boolean res = list.read();
                    if (res) {
                         list.display();
                           
                        }
                    else {
                        System.out.println("Warning, cant import file");
                    }
                    
                    break;

                case 4:
                    System.out.println("Thoat chuong trinh");
                    break;
//                default:
//                    throw new AssertionError();
            }
        } while (menuID != 4);
    }
}
