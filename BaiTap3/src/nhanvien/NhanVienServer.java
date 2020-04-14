/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhanvien;
import java.rmi.Naming;
import java.lang.Runtime;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author lekim
 */
public class NhanVienServer {
    public static void main(String[] args)  {
        String serviceName = "rmi://localhost:5000/nhanvien";
        NhanVien server;
        try {
          server = new NhanVien();
          
          LocateRegistry.createRegistry(5000);
          
          Naming.rebind(serviceName, server);
          
          System.out.println("Service " + serviceName + " is running on.");
          
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
