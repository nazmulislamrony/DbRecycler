package com.example.dbrecycler.Mode;

import android.os.Parcel;
import android.os.Parcelable;

public class SecondStore implements Parcelable {

    public int id;
    public String content, name;

    public SecondStore(int id, String content, String name) {
        this.id = id;
        this.content = content;
        this.name = name;
    }

    public SecondStore() {
    }

    protected SecondStore(Parcel in) {
        id = in.readInt();
        content = in.readString();
        name = in.readString();
    }

    public static final Creator<SecondStore> CREATOR = new Creator<SecondStore>() {
        @Override
        public SecondStore createFromParcel(Parcel in) {
            return new SecondStore(in);
        }

        @Override
        public SecondStore[] newArray(int size) {
            return new SecondStore[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(content);
        dest.writeString(name);
    }
}
