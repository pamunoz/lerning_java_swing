package com.pfariasmunoz.swing.controller;

import com.pfariasmunoz.swing.gui.FormEvent;
import com.pfariasmunoz.swing.model.AgeCategory;
import com.pfariasmunoz.swing.model.Database;
import com.pfariasmunoz.swing.model.EmploymentCategory;
import com.pfariasmunoz.swing.model.GenderCategory;
import com.pfariasmunoz.swing.model.Person;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    
    Database db = new Database();
    
    public List<Person> getPeople() {
        return db.getPeople();
    }
    
    public void addPerson(FormEvent e) {
        String name = e.getName();
        String occupation = e.getOccupation();
        int ageCatId = e.getAgeCategory();
        String empCat = e.getEmploymentCategory();
        boolean isUs = e.isUsCitizen();
        String taxId = e.getTaxId();
        String gender = e.getGender();
        
        AgeCategory ageCategory;
        
        switch(ageCatId) {
            case 0: ageCategory = AgeCategory.CHILD;
                break;
            case 1: ageCategory = AgeCategory.ADULT;
                break;
            default: ageCategory = AgeCategory.SENIOR;
        }
        
        EmploymentCategory employmentCategory;
        
        switch(empCat) {
            case "employed": employmentCategory = EmploymentCategory.EMPLOYED;
                break;
            case "unemployed": employmentCategory = EmploymentCategory.UNEMPLOYED;
                break;
            case "selfemployed": employmentCategory = EmploymentCategory.SELF_EMPLOYED;
                break;
            default: employmentCategory = EmploymentCategory.OTHER;
                System.err.println(empCat);
        }
        
        
        GenderCategory genderCategory;
        
        genderCategory = (gender.equals("female")) ? GenderCategory.FEMALE : GenderCategory.MALE;
        
        
        
        Person person = new Person(name, occupation, ageCategory, 
                employmentCategory, taxId, isUs, genderCategory);
        db.addPerson(person);
    }
    
    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }
    
    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
    
}
