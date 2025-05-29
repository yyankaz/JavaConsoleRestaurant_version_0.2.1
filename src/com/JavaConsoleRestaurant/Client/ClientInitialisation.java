package com.JavaConsoleRestaurant.Client;

public class ClientInitialisation {
    public static void init() {
        ClientDAO client = new ClientDAO();
        client.createTableIfNotExists();
        //client.addClient(new Client("000001","Ann", "Smith", LocalDate.of(2002, 3, 11), "0784459178", Status.BASIC));
    }
}
