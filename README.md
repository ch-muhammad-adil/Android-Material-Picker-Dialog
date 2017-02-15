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
