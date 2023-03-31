/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author tuanv
 */
public class GuiNhan {

    ServerSocket serverSocket;

    public void MoCong(int cong) throws Exception {
        serverSocket = new ServerSocket(cong);
        System.out.println("Da mo cong");

    }
    public String Nhan() throws Exception{
        Socket c = serverSocket.accept();
        System.out.println("Co 1 thang connect");
        InputStreamReader is = new InputStreamReader(c.getInputStream());
        BufferedReader r = new BufferedReader(is);
        return r.readLine();
    }
    public void Gui(String data, String ipmaychu, int cong) throws Exception{
        
        Socket client = new Socket(ipmaychu, cong);
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        out.writeBytes(InetAddress.getLocalHost().getHostAddress() + ":" +data);
        out.write(13);
        out.write(10);
        client.close();
        out.close();
    }
}
