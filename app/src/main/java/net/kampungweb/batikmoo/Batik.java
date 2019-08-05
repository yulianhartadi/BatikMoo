package net.kampungweb.batikmoo;

import android.os.Parcel;
import android.os.Parcelable;

public class Batik implements Parcelable {

    private String name;
    private String from;
    private String content;
    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.from);
        dest.writeString(this.content);
        dest.writeString(this.photo);
    }

    public Batik() {
    }

    protected Batik(Parcel in) {
        this.name = in.readString();
        this.from = in.readString();
        this.content = in.readString();
        this.photo = in.readString();
    }

    public static final Parcelable.Creator<Batik> CREATOR = new Parcelable.Creator<Batik>() {
        @Override
        public Batik createFromParcel(Parcel source) {
            return new Batik(source);
        }

        @Override
        public Batik[] newArray(int size) {
            return new Batik[size];
        }
    };
}
