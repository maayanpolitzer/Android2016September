package com.company;

/**
 * Created by hackeru on 10/27/2016.
 */
public class Cage {

    private int animalsInCageCount;
    private boolean aquarium;
    private Animal[] animalsInCage;
    private boolean dangerous;

    // ENUM...

    public Cage(int maxCapacity, boolean aquarium){
        this.aquarium = aquarium;
        animalsInCage = new Animal[maxCapacity];

    }

    public void addAnimal(Animal animal){
        animalsInCage[animalsInCageCount++] = animal;
        dangerous = animal.isPredator();
    }

    @Override
    public String toString() {
        //return "aqua? " + aquarium;
        String str = aquarium + " [";
        for (int i = 0; i < animalsInCageCount; i++){
            str += animalsInCage[i].getName();
            if (i < animalsInCageCount - 1){
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

    public boolean isAquarium() {
        return aquarium;
    }

    public boolean isFull(){
        return animalsInCageCount == Zoo.MAX_CAPACITY;
    }

    public boolean isDangerous() {
        return dangerous;
    }

    public int getCount() {
        return animalsInCageCount;
    }
}
