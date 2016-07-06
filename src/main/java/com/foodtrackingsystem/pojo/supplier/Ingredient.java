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
public class Ingredient {

    private String name;
    private ArrayList<Nutrient> NutrientDir;

    public Ingredient() {
        NutrientDir = new ArrayList<Nutrient>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Nutrient> getNutrientDir() {
        return NutrientDir;
    }

    public void addNutrient(Nutrient nutrient) {
        NutrientDir.add(nutrient);
    }

    public void removeNutrient(Nutrient nutrient) {
        NutrientDir.remove(nutrient);
    }

    @Override
    public String toString() {
        return name;
    }
}
