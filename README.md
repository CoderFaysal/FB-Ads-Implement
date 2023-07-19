# FB Audience Network Implement


## This 2 Java Class rakhte hobe "Ads" Name Package Create kore 


## BANNER Ads

### XML 

```

    <LinearLayout
        android:layout_marginBottom="10dp"
        android:id="@+id/banner_container"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:orientation="vertical"
        />

    <View
        android:id="@+id/dividar"
        android:layout_below="@id/banner_container"
        android:layout_width="match_parent"
        android:layout_height="1dp"
        android:background="#D5D5D5"
        />

```

### Java
```
// Banner Ads
Facebook.showBanner(findViewById(R.id.banner_container), this);
```
