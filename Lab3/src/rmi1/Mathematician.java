/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi1;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
/**
 *
 * @author lekim
 */
public class Mathematician extends UnicastRemoteObject
                            implements MathServices {
    public Mathematician() throws RemoteException{}
    public double add(double x, double y) throws RemoteException{
        return x+y;
    }
    public double subtract(double x, double y) throws RemoteException{
        return x-y;
    }
}
