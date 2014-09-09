package mazoni.contactfinder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class ContactInfoAdapter extends ArrayAdapter<ContactInfo> {


    public ContactInfoAdapter(Context context, int resource) {
        super(context, resource);
    }

    public ContactInfoAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ContactInfoAdapter(Context context, int resource, ContactInfo[] objects) {
        super(context, resource, objects);
    }

    public ContactInfoAdapter(Context context, int resource, int textViewResourceId, ContactInfo[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public ContactInfoAdapter(Context context, int resource, List<ContactInfo> objects) {
        super(context, resource, objects);
    }

    public ContactInfoAdapter(Context context, int resource, int textViewResourceId, List<ContactInfo> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
