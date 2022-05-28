/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.socket;

import com.fasterxml.jackson.databind.JsonNode;
import com.tonduong.controller.MainController;
import com.tonduong.model.struct.Action;
import com.tonduong.model.struct.TypeAction;
import com.tonduong.model.struct.UserUI;
import com.tonduong.util.Json;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ClientSocket {

    public ClientSocket() {

    }
    private InputStream is;
    private BufferedReader br;
    private OutputStream os;
    private BufferedWriter bw;
    private Socket socket;

    public void start(int port) throws IOException {
        socket = new Socket("localhost", port);
        System.out.println(socket.getPort());

        is = socket.getInputStream();
        br = new BufferedReader(new InputStreamReader(is));

        os = socket.getOutputStream();
        bw = new BufferedWriter(new OutputStreamWriter(os));

        Action<String> first = new Action<>(TypeAction.REPLACE, UserUI.getId());
        sendMessage(bw, first);

        //read message
        new Thread(() -> {
            JsonNode data = null;
            do {
                data = readMessage(br);
                if (data == null) {
                    break;
                }
            } while (true);
        }).start();
//        new Thread(() -> {
//            // write message
//            do {
//                try {
//                    DataInputStream din = new DataInputStream(System.in);
//                    String sentMessage = din.readLine();
//                    Action<String> data = new Action<>(TypeAction.CLIENT_TO_SERVER, sentMessage);
//                    sendMessage(bw, data);
//                } catch (IOException ex) {
//                    Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } while (true);
//
//        });
    }

    public String sendMessage(Object data) {
        try {
            String send = Json.stringify(data);
            bw.write(send);
            bw.newLine();
            bw.flush();
            System.err.println(send);
            return send;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String sendMessage(BufferedWriter bw, Object data) {
        try {
            String send = Json.stringify(data);
            bw.write(send);
            bw.newLine();
            bw.flush();
            return send;
        } catch (IOException e) {
            return null;
        }
    }

    private JsonNode readMessage(BufferedReader br) {
        try {
            String receivedMessage;
            receivedMessage = br.readLine();
            MainController.reducer(receivedMessage);
            System.out.println("Received : " + receivedMessage);
            return Json.parse(receivedMessage);
        } catch (IOException ex) {
            return null;
        }
    }
    public void close() {
        try {
            is.close();
            br.close();
            os.close();
            bw.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
