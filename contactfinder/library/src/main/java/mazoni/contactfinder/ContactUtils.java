package mazoni.contactfinder;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ContactUtils {

    public static List<String> getAllContactNames(ContentResolver contentResolver) {
        List<String> contactNamesList = new ArrayList<String>();
        try {
            List<ContactInfo> allContactInfo = getAllContactInfo(contentResolver);
            for(ContactInfo contactInfo: allContactInfo) {
                contactNamesList.add(contactInfo.getDisplayName());
            }
        } catch (NullPointerException e) {
            Log.e("getAllContactNames()", e.getMessage());
        }
        return contactNamesList;
    }

    public static List<ContactInfo> getAllContactInfo(ContentResolver contentResolver) {
        List<ContactInfo> contactNamesList = new ArrayList<ContactInfo>();
        try {
            populateArray(contentResolver, contactNamesList);
        } catch (NullPointerException e) {
            Log.e("getAllContactNames()", e.getMessage());
        }
        return contactNamesList;
    }

    private static void populateArray(ContentResolver contentResolver, List<ContactInfo> contactInfoList) {
        Cursor contactCursor = getCursorToAllContacts(contentResolver);
        if (contactCursor != null) {
            while (contactCursor.moveToNext()) {
                contactInfoList.add(getContactInfo(contentResolver, contactCursor));
            }
        }
        contactCursor.close();
    }

    private static ContactInfo getContactInfo(ContentResolver contentResolver, Cursor contactCursor) {
        String contactId = getContactId(contactCursor);
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setDisplayName(contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
        String thumbnailUri = contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.Contacts.PHOTO_THUMBNAIL_URI));
        contactInfo.setPhotoThumbnailUri(thumbnailUri);
        return contactInfo;
    }

    private static Cursor getCursorToAllContacts(ContentResolver contentResolver) {
        return contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
    }

    private static String getContactId(Cursor contactCursor) {
        return contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.Contacts._ID));
    }


    public static class ContactInfo{

        private String photoThumbnailUri;
        private String displayName;

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

        @Override
        public String toString() {
            return displayName;
        }
    }
}
