package com.example.beattheblues4;

public class Support {
    String email;
    String name;
    String id;
    int burden;
    int emotional;
    int tangible;
    int informational;
    boolean closetie;
    int companionship;

    public Support (){

    }

    public Support(String email, String id, String name, int burden, int emotional, int tangible, int informational, int companionship, boolean closetie) {
        this.email = email;
        this.name = name;
        this.burden = burden;
        this.emotional = emotional;
        this.tangible = tangible;
        this.informational = informational;
        this.companionship = companionship;
        this.closetie = closetie;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBurden() {
        return burden;
    }

    public void setBurden(int burden) {
        this.burden = burden;
    }

    public int getEmotional() {
        return emotional;
    }

    public void setEmotional(int emotional) {
        this.emotional = emotional;
    }

    public int getTangible() {
        return tangible;
    }

    public void setTangible(int tangible) {
        this.tangible = tangible;
    }

    public int getInformational() {
        return informational;
    }

    public void setInformational(int informational) {
        this.informational = informational;
    }

    public int getCompanionship() {
        return companionship;
    }

    public void setCompanionship(int companionship) {
        this.companionship = companionship;
    }

    public boolean isClosetie() {
        return closetie;
    }

    public void setClosetie(boolean closetie) {
        this.closetie = closetie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}