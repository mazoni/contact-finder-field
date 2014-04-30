package mazoni.contactfinder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

import mazoni.contactfinder.ContactUtils;

public class ContactFinderView extends AutoCompleteTextView {

    private String contactImageUri;

    public ContactFinderView(Context context) {
        super(context);
        init();
    }

    public ContactFinderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ContactFinderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        List<ContactUtils.ContactInfo> allContactInfo = ContactUtils.getAllContactInfo(getContext().getContentResolver());
        ArrayAdapter<ContactUtils.ContactInfo> contactInfoArrayAdapter = new ArrayAdapter<ContactUtils.ContactInfo>(getContext(), android.R.layout.simple_dropdown_item_1line, allContactInfo){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                return super.getView(position, convertView, parent);
            }
        };

        setAdapter(contactInfoArrayAdapter);
//        setAdapter();
    }
}
