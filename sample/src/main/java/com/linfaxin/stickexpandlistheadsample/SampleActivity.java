package com.linfaxin.stickexpandlistheadsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class SampleActivity extends ActionBarActivity {

    private static String[] ACuntries = new String[]{
            "Afghanistan",
            "Albania",
            "Algeria",
            "Andorra",
            "Angola",
            "Antigua & Barbuda",
            "Argentina",
            "Armenia",
            "Australia",
            "Austria",
            "Azerbaijan",
    };
    private static String[] BCuntries = new String[]{
            "Bahamas",
            "Bahrain",
            "Bangladesh",
            "Barbados",
            "Belarus",
            "Belgium",
            "Belize",
            "Benin",
            "Bhutan",
            "Bolivia",
            "Bosnia and Herzegovina",
            "Botswana",
            "Brazil",
            "Brunei",
            "Bulgaria",
            "Burkina Faso",
            "Burma",
            "Burundi",
    };
    private static String[] CCuntries = new String[]{
            "Cambodia",
            "Cameroon",
            "Canada",
            "Cape Verde",
            "Central African Republic",
            "Chad",
            "Chile",
            "China",
            "Colombia",
            "Comoros",
            "Congo, Democratic Republic of the",
            "Congo, Republic of the",
            "Costa Rica",
            "Cote d\'voire",
            "Croatia",
            "Cuba",
            "Cyprus",
            "Czech Republic",
    };
    private static String[] DCuntries = new String[]{
            "Denmark",
            "Djibouti",
            "Dominica",
            "Dominican Republic",
    };
    private static LinkedHashMap<String, String[]> countries = new LinkedHashMap<>();
    static{
        countries.put("A", ACuntries);
        countries.put("B", BCuntries);
        countries.put("C", CCuntries);
        countries.put("D", DCuntries);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        ExpandableListView listView = (ExpandableListView) findViewById(android.R.id.list);
        listView.setAdapter(new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return countries.size();
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return new ArrayList<>(countries.values()).get(groupPosition).length;
            }

            @Override
            public String getGroup(int groupPosition) {
                return new ArrayList<>(countries.keySet()).get(groupPosition);
            }

            @Override
            public String getChild(int groupPosition, int childPosition) {
                return new ArrayList<>(countries.values()).get(groupPosition)[childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return 0;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                TextView tv = (TextView) convertView;
                if(tv==null){
                    tv=new TextView(SampleActivity.this);
                    tv.setBackgroundResource(android.R.color.darker_gray);
                    tv.setTextSize(16);
                    int padding = (int) (getResources().getDisplayMetrics().density * 6);
                    tv.setPadding(padding, padding, padding, padding);
                }
                tv.setText(getGroup(groupPosition));
                return tv;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView tv = (TextView) convertView;
                if(tv==null){
                    tv=new TextView(SampleActivity.this);
                    tv.setTextSize(18);
                    int padding = (int) (getResources().getDisplayMetrics().density * 8);
                    tv.setPadding(2 * padding, padding, padding, padding);
                }
                tv.setText(getChild(groupPosition, childPosition));
                return tv;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }
        });

        listView.setGroupIndicator(null);
        for(int i=0,size=listView.getExpandableListAdapter().getGroupCount();i<size;i++){
            listView.expandGroup(i);
        }
    }

}
