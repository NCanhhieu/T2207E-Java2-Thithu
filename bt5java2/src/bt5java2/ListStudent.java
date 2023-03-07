/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt5java2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ListStudent {
    ArrayList<Student> list = new ArrayList<Student>();
    

    public ArrayList<Student> getList() {
        return list;
    }
    
    public int checkID(int idmoi){
       
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).id == idmoi){
                return i;
            }
        }
        return -1;
    }
    
    public boolean add(int id, String name, int Age){
        Student sv = new Student(id,name,Age);
        
        if(checkID(id) < 0){
            list.add(sv);
            return true;
        }
        return false;
    }
    public void display(){
         String leftAlignFormat = "| %-15s | %-20s | %-4d |%n";

                            System.out.format("+-----------------+----------------------+------+%n");
                            System.out.format("| ENROLLID        | FULLNAME             |AGE   |%n");
                            System.out.format("+-----------------+----------------------+------+%n");
                           for (int i = 0; i < list.size(); i++) {
                                System.out.format(leftAlignFormat, "GC00" + list.get(i).id, list.get(i).name, list.get(i).age);
                            }
                            System.out.format("+-----------------+----------------------+------+%n");
    }
    
    public boolean save(){
        if(list.isEmpty()){
            return false;
        }
         FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:/Students.dat");
            oos = new ObjectOutputStream(fos);
             //thao tác ghi tệp kiểu nhị phân
             oos.writeInt(list.size()); //ghi so phan tu ra tep
             for(int i = 0; i < list.size(); i++){
             Student sv = list.get(i);
             oos.writeObject(sv);
        }  System.out.println("Ghi tệp thành công");
        }catch (FileNotFoundException ex) {
             System.out.println("Có lỗi mở tệp để ghi!");
            Logger.getLogger(ListStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
               System.out.println("Có lỗi!");
            Logger.getLogger(ListStudent.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                if(oos != null){
                    oos.close();
                }
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                  Logger.getLogger(ListStudent.class.getName()).log(Level.SEVERE, null, e);
            }
        } 
        return true;
    }
    public boolean read(){

         ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:/Students.dat");
            ois = new ObjectInputStream(fis);
              int n = ois.readInt();//đọc số nguyên là số đối tượng đã ghi
            for (int i = 0; i < n; i++) // lặp n lần để đọc n đói tượng phone
            {
                Student sv = (Student) ois.readObject();//Phải ép kiểu object về kiểu object khi write
                list.add(sv);
            }
               

        } catch (FileNotFoundException ex) {
            System.out.println("Có lỗi mở tệp để đọc!");
            Logger.getLogger(ListStudent.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
