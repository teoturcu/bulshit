package com.example.distrans.Fragments;


import com.example.distrans.R;
import com.example.distrans.database.CategorieAuto;
import com.example.distrans.database.DBHelper;
import com.example.distrans.database.Trasee;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class S2_Trasee extends Fragment {
	// Database
    private static SQLiteDatabase sqlDatabase;
    
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View s2_trasee_view = inflater.inflate(R.layout.s2_trasee_fragm, null);
		
		 ExpandableListView elv = (ExpandableListView) s2_trasee_view.findViewById(R.id.lvExp);
		 elv.setAdapter(new SavedTabsListAdapter());
		 Log.d("===LOAD===", "Loaded Trasee");
		 
		 return s2_trasee_view; 
		
	}
//	   /*
//     * Preparing the list data
//     */
//    private void prepareListData() {
//        listDataHeader = new ArrayList<String>();
//        listDataChild = new HashMap<String, List<String>>();
// 
//        // Adding child data
//        listDataHeader.add("Top 250");
//        listDataHeader.add("Now Showing");
//        listDataHeader.add("Coming Soon..");
// 
//        // Adding child data
//        List<String> top250 = new ArrayList<String>();
//        top250.add("The Shawshank Redemption");
//        top250.add("The Godfather");
//        top250.add("The Godfather: Part II");
//        top250.add("Pulp Fiction");
//        top250.add("The Good, the Bad and the Ugly");
//        top250.add("The Dark Knight");
//        top250.add("12 Angry Men");
// 
//        List<String> nowShowing = new ArrayList<String>();
//        nowShowing.add("The Conjuring");
//        nowShowing.add("Despicable Me 2");
//        nowShowing.add("Turbo");
//        nowShowing.add("Grown Ups 2");
//        nowShowing.add("Red 2");
//        nowShowing.add("The Wolverine");
// 
//        List<String> comingSoon = new ArrayList<String>();
//        comingSoon.add("2 Guns");
//        comingSoon.add("The Smurfs 2");
//        comingSoon.add("The Spectacular Now");
//        comingSoon.add("The Canyons");
//        comingSoon.add("Europa Report");
// 
//        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), nowShowing);
//        listDataChild.put(listDataHeader.get(2), comingSoon);
//    }
	
	 public class SavedTabsListAdapter extends BaseExpandableListAdapter {

		DBHelper dbHelper = new DBHelper(getActivity());
		 List<Trasee> trasee = dbHelper.getTrasee();
		 List<CategorieAuto> categorieAuto = dbHelper.getCategorieAuto();
		 private String[] groups = new String[categorieAuto.size()];
//		 private String[][] children = new String[categorieAuto.size()][trasee.size()];
		 private String[][] children = new String[categorieAuto.size()][1];
//		 private String[][] children = new String[categorieAuto.size()][trasee.size()];
//		 privatte String[][] children3 = new String[categorieAuto.size()][];

		 
		 public SavedTabsListAdapter() {
				//Create database
			 sqlDatabase = dbHelper.getWritableDatabase();
			 ShowCategorieAuto();
			 ShowTrasee();

		}
		 
		 public void ShowCategorieAuto(){
			 int i = 0;
			 for (CategorieAuto ca : categorieAuto) {
				 groups[i] = "" + ca.getTipAuto();
				 Log.d("TEST", "showCA");
				 i++;
			 }
		 }
		 
		 public void ShowTrasee() {
//			 int i = 0;
			 int j = 0;
			 Log.d("TEST", "showTR");
		     for (Trasee tr : trasee) {
			     String log = "Numar traseu: "+tr.getNrt()+" , Durata traseu: " + tr.getDurata() +
			     " , Statie start: " + tr.getNrStStart() + " , Statie end: "
			     + tr.getNrStEnd() + " , nrc: "+ tr.getNrc();
			     // Writing trasee to log
//			     Log.d("Name: ", log);
			     
			     Log.d("Name: ", "nrc="+tr.getNrc());
			     if (tr.getNrc() == 1) {
				     Log.d("Name: ", "1");
			    	 children[0][j] = ""+tr.getNrt() + "\t\t\t" + tr.getNrStStart() ;
			     } else if (tr.getNrc() == 2) {
			    	 Log.d("Name: ", "2");
			    	 children[1][j] = ""+tr.getNrt() + "\t\t\t" + tr.getNrStStart() ;
			     } else {
			    	 Log.d("Name: ", "3");
			    	 children[2][j] = ""+tr.getNrt() + "\t\t\t" + tr.getNrStStart() ;
//			    	 children[2][j+1] = ""+tr.getNrt() + "\t\t\t" + tr.getNrStStart() ;
			     }
//			     children[0][j] = ""+tr.getNrt() + "\t\t\t" + tr.getNrStStart() ;
		    	 
//		    	 i=i+3;
//		    	 j++;
		    	 
		     }
		 }
		 
		  
		 @Override
		 public int getGroupCount() {
			 Log.d("TEST", "length=" + groups.length);
		 return groups.length;
		 }
		  
		 @Override
		 public int getChildrenCount(int i) {
		 return children[i].length;
		 }
		  
		 @Override
		 public Object getGroup(int i) {
		 return groups[i];
		 }
		  
		 @Override
		 public Object getChild(int i, int i1) {
		 return children[i][i1];
		 }
		  
		 @Override
		 public long getGroupId(int i) {
		 return i;
		 }
		  
		 @Override
		 public long getChildId(int i, int i1) {
		 return i1;
		 }
		  
		 @Override
		 public boolean hasStableIds() {
		 return true;
		 }
		  
		 @Override
		 public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
		 TextView textView = new TextView(S2_Trasee.this.getActivity());
		 textView.setText(getGroup(i).toString());
		 return textView;
		 }
		  
		 @Override
		 public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
		 TextView textView = new TextView(S2_Trasee.this.getActivity());
		 textView.setText(getChild(i, i1).toString());
		 	Log.d("TEST", "getChild=" + getChild(i, i1) + "\ni="+i + "\ni1="+i1);
		 	
		 return textView;
		 }
		  
		 @Override
		 public boolean isChildSelectable(int i, int i1) {
		 return true;
		 }
		  
		 }
}
