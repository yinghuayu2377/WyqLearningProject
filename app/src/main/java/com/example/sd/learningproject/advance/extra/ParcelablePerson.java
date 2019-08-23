package com.example.sd.learningproject.advance.extra;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelablePerson implements Parcelable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ParcelablePerson() {
    }

    protected ParcelablePerson(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<ParcelablePerson> CREATOR = new Creator<ParcelablePerson>() {
        @Override
        public ParcelablePerson createFromParcel(Parcel in) {
            return new ParcelablePerson(in);
        }

        @Override
        public ParcelablePerson[] newArray(int size) {
            return new ParcelablePerson[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }
}
