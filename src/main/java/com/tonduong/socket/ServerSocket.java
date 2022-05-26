/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.socket;

import com.fasterxml.jackson.databind.JsonNode;
import com.tonduong.controller.MainController;
import com.tonduong.database.dao.DUser;
import com.tonduong.database.pojo.User;
import com.tonduong.model.struct.Action;
import com.tonduong.model.struct.TypeAction;
import com.tonduong.model.struct.UserUI;
import com.tonduong.util.Json;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ServerSocket {

    public ServerSocket() {
    }
    private static java.net.ServerSocket serverSocket;
    private static HashMap<String, BufferedWriter> bws = new HashMap<>();

    public static void start() throws IOException {
        User user = DUser.find(UserUI.getId());
        try {
            serverSocket = new java.net.ServerSocket(user.getPort());
            user.setIsOnline(true);
            DUser.update(user);
        } catch (Exception e) {

            serverSocket = new java.net.ServerSocket(0);
            int port = serverSocket.getLocalPort();
            String ip = "localhost";

            user.setIp(ip);
            user.setPort(port);
            user.setIsOnline(true);
            DUser.update(user);
        }

        new Thread(() -> {
            do {
                try {
//            System.out.println("Waiting for a Client");

                    Socket server = serverSocket.accept(); //synchronous

//            System.out.println("Talking to client");
//            System.out.println(server.getPort());
                    InputStream is = server.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    OutputStream os = server.getOutputStream();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

                    String firstRead = br.readLine();
                    JsonNode jsonNode = Json.parse(firstRead);
                    System.err.println(Json.parse(firstRead));
//confirm connect
                    String idUser = jsonNode.get("payload").asText();
                    bws.put(idUser, bw);
                    Action<String> first = new Action(TypeAction.AUTH, idUser);
                    sendMessage(bw, first);

                    try {
                        //read data
                        new Thread(() -> {
                            JsonNode data = null;
                            do {
                                data = readMessage(br);
                                System.err.println("Ckeck");
//                                if (data == null) {
//                                    try {
//                                        br.close();
//                                        bw.close();
//                                    } catch (IOException ex) {
//                                        Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
//                                    }
//                                    bws.remove(idUser);
//                                    break;
//                                }
                            } while (true);
                        })
                                .start();

                    } catch (Exception ex) {
                        bw.close();
                        br.close();
                        Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (true);
        })
                .start();
//        new Thread(() -> {
//            do {
//                try {
//                    //send data
//                    DataInputStream din = new DataInputStream(System.in);
//
//                    String sentMessage = "";
//
////                    System.out.println("Nhap noi dung: ");
////                    sentMessage = din.readLine();
////                    sendMessage(sentMessage);
//                } catch (IOException ex) {
//                    Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } while (true);
//        }).start();
    }

    public static void sendMessage(Object data, List<String> listUserSend) {
        for (String idUser : listUserSend) {
            try {

                System.err.println(idUser);
                if (bws.get(idUser) == null) {
                    break;
                }

                sendMessage(bws.get(idUser), data);

            } catch (Exception e) {

                Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, e);

                try {

                    bws.get(idUser).close();
                    bws.remove(idUser);

                } catch (IOException ex) {

                    Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
    }

    public static void close() {
        User user = DUser.find(UserUI.getId());
        user.setIsOnline(false);
        DUser.update(user);
    }

    private static String sendMessage(BufferedWriter bw, Object data) {
        try {
            String send = Json.stringify(data);

            System.err.println(send);
            bw.write(send);
            bw.newLine();
            bw.flush();
            return send;
        } catch (IOException e) {

        }
        return null;
    }

    private static JsonNode readMessage(BufferedReader br) {
        try {
            String receivedMessage;
            receivedMessage = br.readLine();
            System.err.println("Message read: " + receivedMessage);
            MainController.reducer(receivedMessage);
            return Json.parse(receivedMessage);
        } catch (IOException ex) {
            return null;
        }
    }
}
