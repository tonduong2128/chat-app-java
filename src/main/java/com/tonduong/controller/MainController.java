/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.controller;

//import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.tonduong.database.dao.DJoinroom;
import com.tonduong.database.dao.DMessage;
import com.tonduong.database.pojo.Joinroom;
import com.tonduong.database.pojo.Message;
import com.tonduong.model.struct.Action;
import com.tonduong.model.struct.TypeAction;
import com.tonduong.model.struct.UserUI;
import com.tonduong.socket.ServerSocket;
import com.tonduong.util.Json;
import com.tonduong.view.Home;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class MainController {

    private static Home home;

    public static void run() {
        try {
            String c = "e043caf0-ba23-4c19-9d43-fab605d4e4d5";
            String b = "e043caf0-ba23-4c19-9d43-fab605d4e4d4";
            String a = "1dcde424-8a7f-4d79-9765-88c5b59d0e79";

            UserUI.setId(a);
//            UserUI.setId(b);
//            UserUI.setId(c);

            UserUI.setNickname("Ton Duong");

            try {
                ServerSocket.start();
                home = new Home();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void reducer(String data) {
        JsonNode action = Json.parse(data);
        String SEND_MES = TypeAction.SEND_MES.toString();
        String SERVER_TO_CLIENT = TypeAction.SERVER_TO_CLIENT.toString();
        String CLIENT_TO_SERVER = TypeAction.CLIENT_TO_SERVER.toString();

        String type = action.get("type").asText();
        System.err.println(type);

        if (type.compareTo(SEND_MES) == 0) {
            System.out.println("Send message");
            JsonNode payload = action.get("payload");
            String id = payload.get("id").asText();
            String idUser = payload.get("idUser").asText();
            String idGroup = payload.get("idGroup").asText();
            String content = payload.get("content").asText();
            long time = payload.get("time").asLong();

            Message message = new Message(id, idUser, idGroup, content, new Timestamp(time));
            DMessage.add(message);

            List<Joinroom> listJoinroom = DJoinroom.findByIdRoomWithUserOnline(idGroup);
            List<String> listUserSend = new ArrayList<>();

            for (Joinroom joinroom : listJoinroom) {
                listUserSend.add(joinroom.getIdUser());
            }
            Action<Message> ac = new Action<>(TypeAction.SEND_MES, message);
            ServerSocket.sendMessage(ac, listUserSend);
        } else if (type.equals(SERVER_TO_CLIENT)) {
            System.out.println("Server to client");
            JsonNode payload = action.get("payload");
            String id = payload.get("id").asText();
            String idUser = payload.get("idUser").asText();
            String idGroup = payload.get("idGroup").asText();
            String content = payload.get("content").asText();
            long time = payload.get("time").asLong();

            Message message = new Message(id, idUser, idGroup, content, new Timestamp(time));

            home.addLineContent(message);
        } else if (type.equals(CLIENT_TO_SERVER)) {
            System.out.println("Clinet to server");
            JsonNode payload = action.get("payload");
            String id = payload.get("id").asText();
            String idUser = payload.get("idUser").asText();
            String idGroup = payload.get("idGroup").asText();
            String content = payload.get("content").asText();
            long time = payload.get("time").asLong();
            Message message = new Message(id, idUser, idGroup, content, new Timestamp(time));

            DMessage.add(message);

            List<Joinroom> listJoinroom = DJoinroom.findByIdRoomWithUserOnline(idGroup);
            List<String> listUserSend = new ArrayList<>();

            for (Joinroom joinroom : listJoinroom) {
                System.err.println("Id group: " + joinroom.getIdUser());
                listUserSend.add(joinroom.getIdUser());
            }
            Action<Message> ac = new Action<>(TypeAction.SERVER_TO_CLIENT, message);

            ServerSocket.sendMessage(ac, listUserSend);
        }
        System.out.println(TypeAction.SEND_MES.toString());
    }
}
