StickExpandListHead
===================

a simple way to stick your ExpandableListView's head view at the top of list

 ![image](https://github.com/linfaxin/StickExpandListHead/blob/master/sample/sample.gif)
 

 Usage
-----

```java
new StickExpandListHead(expandableListView);
```
Or wrap your `View` with `MaterialRippleLayout` in your layout file:

```xml
<com.linfaxin.stickexpandlisthead.StickExpandListHead
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ExpandableListView
        android:id="@android:id/list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</com.linfaxin.stickexpandlisthead.StickExpandListHead>
```
