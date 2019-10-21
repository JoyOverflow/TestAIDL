package ouyj.hyena.com.logservice;

import android.os.Parcel;
import android.os.Parcelable;

public class Message implements Parcelable {
    private String tag;
    private String text;

    /**
     * 构造方法
     * @param in
     */
    protected Message(Parcel in) {
        this.tag = in.readString();
        this.text = in.readString();
    }
    public String getTag() { return tag; }
    public void setTag(String tag) { this.tag = tag; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }


    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tag);
        dest.writeString(this.text);
    }
    /**
     * 读取顺序和writeToParcel()方法中一致
     * @param dest
     */
    public void readFromParcel(Parcel dest) {
        this.tag = dest.readString();
        this.text = dest.readString();
    }


    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel source) {
            return new Message(source);
        }
        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };
}
