package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 11/3/2016.
 */
public class Vet {

    private String name;
    private String address;
    private int beds;
    private ArrayList<Client> clients;
    private ArrayList<Animal> injuredAnimals;

    public Vet(String name, String address, int beds){
        this.name = name;
        this.address = address;
        this.beds = beds;
        clients = new ArrayList<>();
        injuredAnimals = new ArrayList<>();
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public boolean addAnimalToClient(int clientID, Animal animal){
        if (clientID > 0 && clientID <= clients.size()){
            return clients.get(clientID - 1).addAnimal(animal);
        }
        System.out.println("no such client...");
        return false;
    }

    public void sendAds(String message){
        for (int i = 0; i < clients.size(); i++){
            if (clients.get(i).isAdsPermission()){
                sendMessageToClient(clients.get(i).getPhoneNumber(), message);
            }
        }
    }

    private void sendMessageToClient(String phoneNumber, String message) {
        System.out.println("Message sent to : " + phoneNumber + ", message: " + message);
    }

    public void sendMessageToDogOwners(String message){

    }

    public boolean insertInjuredAnimal(int animalID){

        return true;
    }

    public void removeInjuredAnimal(int animalID){

    }

    public void setClientAdsStatus(int clientID, boolean sendAds){

    }

    public Client getClientByAnimal(int animalID){

        return null;
    }

    public ArrayList<Client> getClients(){
        return clients;
    }

}
