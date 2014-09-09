contact-finder-field - WIP
====================

This library provides a simpler way to search through the contacts and select a contact from the filtered ones

Add the following line to you AndroidManifest.xml


> <uses-permission android:name="android.permission.READ_CONTACTS" />

Add the ContactFinderView in any layout you want to use it:

>     <mazoni.contactfinder.view.ContactFinderView
>          android:layout_width="match_parent"
>          android:layout_height="wrap_content"/>

Keep in mind that the ContactFinderView extends a native android AutoCompleteTextView, so you'll be able to edit its style anyway you would be in the native android component.

Use the methods: getSelectedContact or setOnContactSelected to be informed about what contact was selected