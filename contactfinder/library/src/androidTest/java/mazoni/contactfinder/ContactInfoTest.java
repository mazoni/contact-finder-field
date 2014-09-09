package mazoni.contactfinder;

import android.os.Bundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class ContactInfoTest {

    public static final String DISPLAY_NAME = "Test Name";
    public static final String FILE_URISAMPLE = "file://urisample";
    public static final String FILE_URISAMPLE2 = "file://urisample2";
    public static final boolean STARRED = true;
    public static final String CONTACT_INFO_KEY = "CONTACT_INFO";

    @Test
    public void testContactInfoSettersAndGetters() {
        ContactInfo contactInfo = getContactInfo();

        assertEquals(contactInfo.getDisplayName(), DISPLAY_NAME);
        assertEquals(contactInfo.getPhotoThumbnailUri(), FILE_URISAMPLE);
        assertEquals(contactInfo.getPhotoUri(), FILE_URISAMPLE2);
        assertEquals(contactInfo.isStarred(), STARRED);
    }

    @Test
    public void writeAndReadToBundleToBundleAsParcelShouldBeEquals() {
        ContactInfo contactInfo = getContactInfo();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CONTACT_INFO_KEY, contactInfo);
        ContactInfo fromBundle = bundle.getParcelable(CONTACT_INFO_KEY);
        assertEquals(contactInfo, fromBundle);
    }

    private ContactInfo getContactInfo() {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setDisplayName(DISPLAY_NAME);
        contactInfo.setPhotoThumbnailUri(FILE_URISAMPLE);
        contactInfo.setPhotoUri(FILE_URISAMPLE2);
        contactInfo.setStarred(STARRED);
        return contactInfo;
    }

}
