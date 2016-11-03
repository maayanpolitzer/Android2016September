package com.company;

public class Main {

    public static void main(String[] args) {

        Vet vet = new Vet("Dr. dulitel", "sus street", 3);
        vet.addClient(new Client("Maayan", "0521111111"));
        vet.addClient(new Client("Moshe", "0522222222"));
        System.out.println(vet.getClients());

        Animal a = new Dog("lassi", Gender.FEMALE);

        System.out.println(vet.addAnimalToClient(2, a));

    }
}
