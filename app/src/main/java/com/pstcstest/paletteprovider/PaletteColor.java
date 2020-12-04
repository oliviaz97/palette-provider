package com.pstcstest.paletteprovider;

import android.os.Parcel;
import android.os.Parcelable;

class PaletteColor implements Parcelable {
    int colorPercent;
    String colorName;

    PaletteColor(int colorPercent, String colorName){
        this.colorName = colorName;
        this.colorPercent = colorPercent;
    }

    protected PaletteColor(Parcel in) {
        colorPercent = in.readInt();
        colorName = in.readString();
    }

    public static final Creator<PaletteColor> CREATOR = new Creator<PaletteColor>() {
        @Override
        public PaletteColor createFromParcel(Parcel in) {
            return new PaletteColor(in);
        }

        @Override
        public PaletteColor[] newArray(int size) {
            return new PaletteColor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(colorPercent);
        dest.writeString(colorName);
    }
}
