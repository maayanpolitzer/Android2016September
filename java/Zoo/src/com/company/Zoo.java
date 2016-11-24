package com.company;

public class Zoo {

    private String name;
    private String manager;
    private Cage[] cages;
    private int numOfAnimals;
    public static final int MAX_CAPACITY = 5;

    public Zoo(String name, String manager,
               int numOfLandCages, int numOfAquariums){
        this.name = name;
        this.manager = manager;
        cages = new Cage[numOfLandCages + numOfAquariums];
        for (int i = 0; i < cages.length; i++){
            cages[i] = new Cage(MAX_CAPACITY, i >= numOfLandCages);
            //cages[i] = new Cage(MAX_CAPACITY, !(i < numOfLandCages));
            /*
            if(i < numOfLandCages){
                cages[i] = new Cage(MAX_CAPACITY, false);
            }else{
                cages[i] = new Cage(MAX_CAPACITY, true);
            }
            */
            //cages[i] = new Cage(MAX_CAPACITY, i < numOfLandCages ? false : true);
        }
    }

    public void printCages(){
        for (int i = 0; i < cages.length; i++){
            System.out.println("id: " + i + ", " + cages[i]);
        }
    }

    public boolean addAnimalToCage(Animal animal){
        for (int i = 0; i < cages.length; i++) {
            if (!cages[i].isFull() &&
                    animal.isAquatic() == cages[i].isAquarium() &&
                    (cages[i].getCount() == 0 || cages[i].isDangerous() == animal.isPredator() )) {
                cages[i].addAnimal(animal);
                return true;
            }
        }
        System.out.println("*** there is no cage available for this " + animal.getName());
        return false;
    }

    public String getManager(){
        return manager;
    }

    public void setManager(String manager){
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfAnimals() {
        return numOfAnimals;
    }
}
