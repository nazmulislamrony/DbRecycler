package com.example.dbrecycler.Mode;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Store implements Parcelable {
    public int id;
    public String name, email;

    public Store(int id, String name) {
        this.id = id;
        this.name = name;
        this.email= email;
    }

    public Store() {
    }


    protected Store(Parcel in) {
        id = in.readInt();
        name = in.readString();
        email = in.readString();
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(email);
    }
}
