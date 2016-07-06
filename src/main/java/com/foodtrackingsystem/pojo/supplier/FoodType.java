/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo.supplier;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class FoodType {

    private String name;
    private String characteristic;
    private String type;
    private ArrayList<Ingredient> ingrendientDir;

    public FoodType() {
        this.ingrendientDir = new ArrayList<Ingredient>();
    }

    public Ingredient addIngredient() {
        Ingredient ingredient = new Ingredient();
        ingrendientDir.add(ingredient);
        return ingredient;
    }

    public void removeIngredient(Ingredient i) {
        ingrendientDir.remove(i);
    }

    public ArrayList<Ingredient> getIngrendientDir() {
        return ingrendientDir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

}
