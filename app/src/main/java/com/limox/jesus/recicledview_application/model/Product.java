package com.limox.jesus.recicledview_application.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.limox.jesus.recicledview_application.R;
import com.limox.jesus.recicledview_application.interfaces.IProducto;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Entity of business for the products
 */
// Implement Serializable to can ve order
public class Product implements Parcelable, Serializable, Comparable<Product>, IProducto{
    private int mId;
    private String mName;
    private String mDescription;
    private String mDosage;
    private String mBrand;
    private double mPrice;
    private int mStock;
    private int mImage;
    // Son Comparators para poder ordenar de diferentes formas

    public static final Comparator<Product> NAME_COMARATOR = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getmName().compareTo(o2.getmName());
        }
    };

    public static final Comparator<Product> PRICE_COMPARATOR = new Comparator<Product>() {
        @Override
        public int compare(Product product, Product t1) {
            return Double.compare(product.getmPrice(), t1.getmPrice());

        }
    };
    public static final Comparator<Product> STOCK_COMPARATOR = new Comparator<Product>() {
        @Override
        public int compare(Product product, Product t1) {
            return Double.compare(product.getmStock(), t1.getmStock());

        }
    };


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

    public String getFormattedPrice() {
        return String.format("%s €", mPrice);
    }

    // This pick the format locale for the numbers of the movile
    public String getFormattedStock() {
        return String.format(Locale.getDefault(), "%d u.", mStock);
    }

    public Product(String name, String description, String dosage, String brand, double price, int stock, int image) {
        this.mName = name;
        this.mDescription = description;
        this.mDosage = dosage;
        this.mBrand = brand;
        this.mPrice = price;
        this.mStock = stock;
        this.mImage = image;
    }
    public Product(String name, String description, String dosage, String brand, double price, int stock) {
        this.mName = name;
        this.mDescription = description;
        this.mDosage = dosage;
        this.mBrand = brand;
        this.mPrice = price;
        this.mStock = stock;
        this.mImage = R.drawable.img1;
    }

    @Override
    public boolean equals(Object o) {
        boolean exit = true;
        if (this == o) exit = true;
        if (o == null || getClass() != o.getClass()) exit = false;

        Product product = (Product) o;

        if (!mName.equals(product.mName)) exit = false;
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
    /**
     * Take the object casted to string
     * mName + ", " + mDesc  ription
     */
    public String toString() {
        return mName + ", " + mDescription;
    }

    @Override
    /**
     * Camps if a product is best that other
     */
    public int compareTo(Product product) {
        if (this.getmName().compareTo(product.getmName()) == 0)
            return this.getmBrand().compareTo(product.getmBrand());
        else
            return this.getmName().compareTo(product.getmName());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    /**
     *  Write the camps making it parcelables
     */
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeString(mDosage);
        dest.writeString(mBrand);
        dest.writeDouble(mPrice);
        dest.writeInt(mStock);
        dest.writeInt(mImage);
    }

    /**
     * Fill the object with the camps parceled
     * @param in this object parceled
     */
    protected Product(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mDescription = in.readString();
        mDosage = in.readString();
        mBrand = in.readString();
        mPrice = in.readDouble();
        mStock = in.readInt();
        mImage = in.readInt();
    }

    /**
     * Parcelable creator
     */
    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

}
