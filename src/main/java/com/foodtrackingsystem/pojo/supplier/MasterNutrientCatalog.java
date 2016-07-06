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
public class MasterNutrientCatalog {

    private ArrayList<Nutrient> masterNutrientCatalog;

    public MasterNutrientCatalog() {
        masterNutrientCatalog = new ArrayList<Nutrient>();
    }

    public ArrayList<Nutrient> getMasterNutrientCatalog() {
        return masterNutrientCatalog;
    }

    public Nutrient addNutrient() {
        Nutrient nutrient = new Nutrient();
        masterNutrientCatalog.add(nutrient);
        return nutrient;
    }

    public void removeNutrient(Nutrient nutrient) {
        masterNutrientCatalog.remove(nutrient);
    }
}
