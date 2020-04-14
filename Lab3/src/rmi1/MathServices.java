/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi1;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author lekim
 */
public interface MathServices extends Remote{
    double add(double x, double y) throws RemoteException;
    double subtract(double x, double y) throws RemoteException;
}
