package com.limox.jesus.manageproducts_application.model;

/**
 * Created by jesus on 20/10/16.
 */

public class Product {
    private int mId;
    private String mName;
    private String mDescription;
    private String mDosage;
    private String mBrand;
    private double mPrice;
    private int mStock;
    private int mImage;




    public String getmDosage() {
        return mDosage;
    }

    public void setmDosage(String mDosage) {
        this.mDosage = mDosage;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmBrand() {
        return mBrand;
    }

    public void setmBrand(String mBrand) {
        this.mBrand = mBrand;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public int getmStock() {
        return mStock;
    }

    public void setmStock(int mStock) {
        this.mStock = mStock;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public Product( String name, String description, String dosage,String brand, double price, int stock, int image) {
        this.mName = name;
        this.mDescription = description;
        this.mDosage = dosage;
        this.mBrand = brand;
        this.mPrice = price;
        this.mStock = stock;
        this.mImage = image;
    }

    @Override
    public boolean equals(Object o) {
        boolean exit = true;
        if (this == o) exit = true;
        if (o == null || getClass() != o.getClass()) exit = false;

        Product product = (Product) o;

        if (!mName.equals(product.mName)) exit =false;
        if (!mDosage.equals(product.mDosage)) exit = false;
        if (mBrand.equals(product.mBrand) == false) exit = false;

        return exit;


    }

    @Override
    public int hashCode() {
        int result = mName.hashCode();
        result = 31 * result + mDosage.hashCode();
        result = 31 * result + mBrand.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return mName + ", " + mDescription;
    }
}
