/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhanvien;

import DBLayer.LNhanVien;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
/**
 *
 * @author lekim
 */
public interface NhanVienServices extends  Remote{
    public List<LNhanVien> getNhanVien() throws RemoteException;
    public int AddNhanVien(String ID, String Ten, Date BirthDay, float Luong, String DiaChi) throws RemoteException;
    public int EditNhanVien(String ID, String Ten, Date BirthDay, float Luong, String DiaChi) throws RemoteException;
    public int DeleteNhanVien(String ID) throws RemoteException;
}
