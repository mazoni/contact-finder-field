package mazoni.contactfinder;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactInfo implements Parcelable{

    private String photoThumbnailUri;
    private String displayName;
    private String photoUri;
    private boolean starred;

    public ContactInfo(Parcel source) {
        this.displayName = source.readString();
        this.photoThumbnailUri = source.readString();
        this.photoUri = source.readString();
        this.starred = source.readInt() == 1;
    }

    public ContactInfo() {
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhotoThumbnailUri() {
        return photoThumbnailUri;
    }

    public void setPhotoThumbnailUri(String photoThumbnailUri) {
        this.photoThumbnailUri = photoThumbnailUri;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public boolean isStarred() {
        return starred;
    }

    @Override
    public String toString() {
        return displayName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(displayName);
        dest.writeString(photoThumbnailUri);
        dest.writeString(photoUri);
        dest.writeInt(starred? 1: 0);
    }

    private final Creator<ContactInfo> CREATOR = new Creator<ContactInfo>() {
        @Override
        public ContactInfo createFromParcel(Parcel source) {
            return new ContactInfo(source);
        }

        @Override
        public ContactInfo[] newArray(int size) {
            return new ContactInfo[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ContactInfo.class != o.getClass()) return false;

        ContactInfo that = (ContactInfo) o;

        if (starred != that.starred) return false;
        if (displayName != null ? !displayName.equals(that.displayName) : that.displayName != null)
            return false;
        if (photoThumbnailUri != null ? !photoThumbnailUri.equals(that.photoThumbnailUri) : that.photoThumbnailUri != null)
            return false;
        if (photoUri != null ? !photoUri.equals(that.photoUri) : that.photoUri != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = photoThumbnailUri != null ? photoThumbnailUri.hashCode() : 0;
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (photoUri != null ? photoUri.hashCode() : 0);
        result = 31 * result + (starred ? 1 : 0);
        return result;
    }
}