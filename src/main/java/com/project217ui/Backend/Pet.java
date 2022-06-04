package com.project217ui.Backend;

import java.util.ArrayList;
import java.util.HashMap;

public class Pet {

    private static HashMap<String,String> usedIDs= new HashMap<String,String>(); 

    public Pet() {
    }
    
    
    public Pet(Pet o_Pet)
    {
        this(new String(o_Pet.getPetName()), new String(o_Pet.getOwnerName()), new String(o_Pet.getOwnerPhone()),new String(o_Pet.getPetID()),new String(o_Pet.getBreed()), o_Pet.getAge(), new String(o_Pet.getIssue()), new String(o_Pet.getDiagnosis()));
    }    
    
    
    public Pet(String o_PetName, String o_OwnerName, String o_PetID, String o_Issue, String o_Diagnosis) throws IllegalArgumentException{
        setPetName(o_PetName);
        setOwnerName(o_OwnerName);
        setPetID(o_PetID);
        setIssue(o_Issue);
        setDiagnosis(o_Diagnosis);
    }
    
    
    public Pet(String o_PetName, String o_OwnerName, String o_OwnerPhone, String o_PetID, String o_Breed, float o_Age,
    String o_Issue, String o_Diagnosis) throws IllegalArgumentException {
        setPetName(o_PetName);
        setOwnerName(o_OwnerName);
        setOwnerPhone(o_OwnerPhone);
        setPetID(o_PetID);
        setBreed(o_Breed);        
        setAge(o_Age);
        setIssue(o_Issue);
        setDiagnosis(o_Diagnosis);
    }
    

    @Override
    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(((Pet)o).getPetID()==this.getPetID())
            return true;   
        return false;
    }


    public String getPetName() {
        return m_PetName;
    }
    
    
    public void setPetName(String o_PetName) {
        this.m_PetName = o_PetName;
    }
    
    
    public String getOwnerName() {
        return m_OwnerName;
    }
    
    
    public void setOwnerName(String o_OwnerName) throws IllegalArgumentException {
        if (ContainsNonAlpha(o_OwnerName))
            throw new IllegalArgumentException("Name can not contain non-alphabetic characters");
        this.m_OwnerName = o_OwnerName;
    }
    
    
    public String getOwnerPhone() {
        return m_OwnerPhone;
    }
    
    
    public void setOwnerPhone(String o_OwnerPhone) throws IllegalArgumentException {
        if(checkInvalidPhoneNum(o_OwnerPhone))
            throw new IllegalArgumentException("Phone number cannot contain non-digit charachters or + sign");
        this.m_OwnerPhone = o_OwnerPhone;
    }
    
    
    public String getPetID() {
        return m_PetID;
    }
    
    
    public void setPetID(String o_PetID) throws IllegalArgumentException{
        if ((usedIDs.keySet().contains(o_PetID))&&!this.m_PetName.equals(usedIDs.get(o_PetID)))
            throw new IllegalArgumentException("ID already in use");
        usedIDs.remove(this.m_PetID);
        this.m_PetID = o_PetID;
        usedIDs.put(this.m_PetID,this.getPetName());
    }
    
    
    public String getBreed() {
        return m_Breed;
    }
    
    
    public void setBreed(String o_Breed) {
        this.m_Breed = o_Breed;
    }
    
    
    public float getAge() {
        return m_Age;
    }
    
    
    public void setAge(float o_Age) throws IllegalArgumentException{
        if (o_Age<=0)
            throw new IllegalArgumentException("Age Cannot be less than or equal to 0");
        this.m_Age = o_Age;
    }
    
    
    public String getIssue() {
        return m_Issue;
    }
    
    
    public void setIssue(String o_Issue) {
        this.m_Issue = o_Issue;
    }
    
    
    public String getDiagnosis() {
        return m_Diagnosis;
    }
    
    
    public void setDiagnosis(String o_Diagnosis) {
        this.m_Diagnosis = o_Diagnosis;
    }    
    

    @Override
    public String toString()
    {
        return new String("Pet name: " + this.m_PetName +"\nOwner name: "+ this.m_OwnerName+"\nOwner phone: "+this.m_OwnerPhone+"\nPet ID: "+this.m_PetID+"\nBreed: "+ this.m_Breed+"\nAge: "+ this.m_Age+"\nIssue: "+ this.m_Issue+"\nDiagnosis: "+m_Diagnosis);
    } 


    private boolean ContainsNonAlpha(String other)
    {
        for (char c : other.toCharArray())
        {
            if(!(Character.isWhitespace(c)||Character.isAlphabetic(c)))
                return true;   
        }
        return false;
    }

    private boolean checkInvalidPhoneNum (String other)
    {
        for (char c : other.toCharArray())
        {
            if(!(Character.isDigit(c)||c=='+'))
                return true;   
        }
        return false;
    }
    
    private String m_PetName = "N/A";
    private String m_OwnerName = "N/A";
    private String m_OwnerPhone = "N/A";
    private String m_PetID = "N/A";
    private String m_Breed = "N/A";
    private float m_Age = -1;
    private String m_Issue = "N/A";
    private String m_Diagnosis = "N/A";
    private ArrayList<Visit> m_Visits;
}
