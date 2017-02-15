# Android Material Picker Dialog
This Library provides a very simple implementation of some android material picker's dialogs which were not available as open source library.
It includes android **Number/Interval picker** which can
be used as **Year picker**, **Month picker** and **any time duration Picker**.
It also includes **Material Gender Picker Dialog** which was much required.

#Screenshots
![pickers](https://github.com/ch-muhammad-adil/Android-Material-Picker-Dialog/blob/master/screenshot_1.png?raw=true)![pickers](https://github.com/ch-muhammad-adil/Android-Material-Picker-Dialog/blob/master/screenshot_2.png?raw=true)


##Compile Library jCenter
```groovy
dependencies {
    ....
    compile 'com.github.ch-muhammad-adil:MaterialPickerDialog:1.0.3'
    ....
}
```

##Compile Library maven

```groovy
dependencies {
    repositories {
        mavenCentral()
    }
    compile 'com.github.ch-muhammad-adil:MaterialPickerDialog:1.0.3'
}
```


##Simple Code for Number Picker

```java

////Using NumberPicker as an interval

NumberPickerDialog dialog=new NumberPickerDialog(MainActivity.this, -50, 50, new NumberPickerDialog.NumberPickerCallBack() {
                    @Override
                    public void onSelectingValue(int value) {
                        Toast.makeText(MainActivity.this, "Selected "+String.valueOf(value), Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

////Using number picker as year interval

NumberPickerDialog dialog=new NumberPickerDialog(MainActivity.this, 1992, 2017, new NumberPickerDialog.NumberPickerCallBack() {
                    @Override
                    public void onSelectingValue(int value) {
                        Toast.makeText(MainActivity.this, "Selected Year "+String.valueOf(value), Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

```


##Simple Code for Gender Picker

```java

////Using gender picker

GenderPickerDialog dialog=new GenderPickerDialog(MainActivity.this);
                dialog.setOnSelectingGender(new GenderPickerDialog.OnGenderSelectListener() {
                    @Override
                    public void onSelectingGender(String value) {
                        Toast.makeText(MainActivity.this, "Selected "+value, Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

```


##Color Attributes of Material Picker Dialog

If you override these attributes in your _**colors.xml**_ file under _**res/values**_
you can customize your **material picker dialog**
```xml

    <!--use these color attributes to customize Material Picker Dialog-->

    <color name="MPD_primaryColor">@color/primaryColor</color>
    <color name="MPD_primaryColorLight">#C5CAE9</color>
    <color name="MPD_backGroundColor">#FFF</color>
    <color name="MPD_pickerItemColorUnSelected">#00FFFFFF</color>
    <color name="MPD_pickerItemColorSelected">@color/MPD_primaryColor</color>
    <color name="MPD_pickerItemTextColorUnSelected">#444</color>
    <color name="MPD_pickerItemTextColorSelected">#bbffffff</color>
    <color name="MPD_pickerSelectedTextColor">#FFF</color>


```


##Localization Attributes
You can update any text and message or you can add localization using these attributes. You just need to override these **string attributes** in your **_strings.xml_** file under **_res/values_**.

```xml

    <string name="MPD_action_done">done</string>
    <string name="MPD_action_cancel">cancel</string>
    <string name="MPD_male">Male</string>
    <string name="MPD_female">Female</string>
    <string name="MPD_empty_message">value can not be empty</string>
    <string name="MPD_incorrect_message">please select correct value</string>

```


### Licence

> Licensed under the Apache License, Version 2.0 (the "License");
> you may not use this work except in compliance with the License.
> You may obtain a copy of the License in the LICENSE file, or at:
>
>  [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)
>
> Unless required by applicable law or agreed to in writing, software
> distributed under the License is distributed on an "AS IS" BASIS,
> WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
> See the License for the specific language governing permissions and
> limitations under the License.