package com.dinesh.sheduleit.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelableModel implements Parcelable {
    private int image;
    private String mText1;
    private String mText2;

    public MyParcelableModel(int image, String mText1, String mText2) {
        this.image = image;
        this.mText1 = mText1;
        this.mText2 = mText2;
    }

    public int getImage() { return image; }
    public void setImage(int image) { this.image = image; }
    public String getmText1() { return mText1; }
    public void setmText1(String mText1) { this.mText1 = mText1; }
    public String getmText2() { return mText2; }
    public void setmText2(String mText2) { this.mText2 = mText2; }




   // AFTER IMPLEMENTING PARCELABLE

    protected MyParcelableModel(Parcel in) {
        image = in.readInt();
        mText1 = in.readString();
        mText2 = in.readString();
    }

    public static final Creator<MyParcelableModel> CREATOR = new Creator<MyParcelableModel>() {
        @Override
        public MyParcelableModel createFromParcel(Parcel in) {
            return new MyParcelableModel(in);
        }

        @Override
        public MyParcelableModel[] newArray(int size) {
            return new MyParcelableModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(mText1);
        dest.writeString(mText2);
    }

}
