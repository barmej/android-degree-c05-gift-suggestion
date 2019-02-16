package com.barmej.giftsuggestion;

public class Gift {

    /**
     * Integer variable that hold string resource id of gift name
     */
    private int name;

    /**
     * Integer variable that hold drawable resource id of gift picture
     */
    private int picture;

    /**
     * Constructor to initialize gift attributes
     * @param name
     * @param picture
     */
    public Gift(int name, int picture) {
        this.name = name;
        this.picture = picture;
    }

    /**
     * Get string resource id of gift name
     * @return string resource id
     */
    public int getName() {
        return name;
    }

    /**
     * Set gift name string resource id
     * @param name string resource id
     */
    public void setName(int name) {
        this.name = name;
    }

    /**
     * Get drawable id of gift picture
     * @return
     */
    public int getPicture() {
        return picture;
    }

    /**
     * Set gift image drawable resource id
     * @param picture
     */
    public void setPicture(int picture) {
        this.picture = picture;
    }

}
