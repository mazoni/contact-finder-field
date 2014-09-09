contact-finder-field - WIP
====================

This library provides a simpler way to search through the contacts and select a contact from the filtered ones

#### Instruction to use

Add the following line to you AndroidManifest.xml

```
  <uses-permission android:name="android.permission.READ_CONTACTS" />
```

Add the ContactFinderView in any layout you want to use it:
```
     <mazoni.contactfinder.view.ContactFinderView
          android:layout_width="match_parent"
          android:layout_height="wrap_content"/>
```
Keep in mind that the ContactFinderView extends a native android AutoCompleteTextView, so you'll be able to edit its style anyway you would be in the native android component.

Use the methods: getSelectedContact or setOnContactSelected to be informed about what contact was selected

License
=======

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


 [1]: http://github.com/mazoni/contact-finder-field/
