package com.barmej.giftsuggestion;

public class Gift {

    public enum GiftType {
        NATURAL, FOOD, CLOTHES, ELECTRONICS, JEWELRY, OTHER
    }

    /**
     * Integer variable that hold string resource id of gift name
     */
    private int name;

    /**
     * Integer variable that hold drawable resource id of gift picture
     */
    private int picture;

    /**
     * Enum variable that hold gift type
     */
    private GiftType giftType;

    /**
     * Constructor to initialize gift attributes
     * @param name
     * @param picture
     * @param giftType {@link com.barmej.giftsuggestion.Gift.GiftType}
     */
    public Gift(int name, int picture, GiftType giftType) {
        this.name = name;
        this.picture = picture;
        this.giftType = giftType;
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
     * @param name gift name string resource id
     */
    public void setName(int name) {
        this.name = name;
    }

    /**
     * Get drawable id of gift picture
     * @return gift picture drawable id
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

    /**
     * Get gift type {@link com.barmej.giftsuggestion.Gift.GiftType}
     * @return gift type
     */
    public GiftType getGiftType() {
        return giftType;
    }

    /**
     * Set gift type {@link com.barmej.giftsuggestion.Gift.GiftType}
     * @param giftType
     */
    public void setGiftType(GiftType giftType) {
        this.giftType = giftType;
    }

}
