package mazoni.contactfinder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.List;

import mazoni.contactfinder.ContactInfo;
import mazoni.contactfinder.ContactUtils;

public class ContactFinderView extends AutoCompleteTextView {

    ContactInfo selectedContact;

    public ContactFinderView(Context context) {
        super(context);
        init();
    }

    public ContactInfo getSelectedContact() {
        return selectedContact;
    }

    private OnContactSelectedListener onContactSelectedListener;

    public ContactFinderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ContactFinderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void setOnContactSelectedListener(OnContactSelectedListener onContactSelectedListener) {
        this.onContactSelectedListener = onContactSelectedListener;
    }

    private void init() {
        final List<ContactInfo> allContactInfo = ContactUtils.getAllContactInfo(getContext().getContentResolver());
        ArrayAdapter<ContactInfo> contactInfoArrayAdapter = new ArrayAdapter<ContactInfo>(getContext(), android.R.layout.simple_dropdown_item_1line, allContactInfo){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return super.getView(position, convertView, parent);
            }
        };
        setAdapter(contactInfoArrayAdapter);
        setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedContact = allContactInfo.get(position);
                onContactSelectedListener.onContactSelected(selectedContact);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    public interface OnContactSelectedListener {
        public void onContactSelected(ContactInfo contactInfo);
    }
}
