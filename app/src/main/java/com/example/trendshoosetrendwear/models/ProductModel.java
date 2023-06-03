package com.example.trendshoosetrendwear.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import java.io.Serializable;

public class ProductModel implements Serializable, Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name ="name")
    private String name;

    @ColumnInfo(name ="brand")
    private String brand;

    @ColumnInfo(name ="price")
    private String price;

    @ColumnInfo(name = "photo", typeAffinity = ColumnInfo.BLOB)
    private byte[] photo;

    @ColumnInfo(name = "photo_int")
    private int photo_int;

    public ProductModel(String name, String brand, String price,  int photo_int) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.photo_int = photo_int;
    }
    public ProductModel(long id, String name, String brand, String price, byte[] photo) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.photo = photo;
    }
    public ProductModel(String name, String brand, String price, byte[] photo) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.photo = photo;
    }

    protected ProductModel(Parcel in) {
        id = in.readLong();
        name = in.readString();
        brand = in.readString();
        price = in.readString();
        photo = in.createByteArray();
        photo_int = in.readInt();
    }

    public static final Creator<ProductModel> CREATOR = new Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel in) {

            return new ProductModel(in);
        }

        @Override
        public ProductModel[] newArray(int size) {

            return new ProductModel[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public int getPhoto_int() {
        return photo_int;
    }

    public void setPhoto_int(int photo_int) {
        this.photo_int = photo_int;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeString(brand);
        parcel.writeString(price);
        parcel.writeInt(photo_int);
        parcel.createByteArray();
    }
}
