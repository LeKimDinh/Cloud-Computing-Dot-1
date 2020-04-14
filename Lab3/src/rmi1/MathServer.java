/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi1;
import java.rmi.Naming;
import java.lang.Runtime;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author lekim
 */
public class MathServer {
    public static void main(String[] args){
    String serviceName = "rmi://localhost:5000/Math1";
    Mathematician server;
    try{
        server = new Mathematician();
        
        /* Runtime rt = Runtime.getRuntime();
        rt.exec("rmiregistry.exe"); */
        
        LocateRegistry.createRegistry(5000);
        //Thêm dòng Locate 
        
        Naming.rebind(serviceName, server);
        System.out.print("Service" + serviceName +" is running.");
    }
    catch(Exception e){
        System.out.println(e);
    }
    }
}
