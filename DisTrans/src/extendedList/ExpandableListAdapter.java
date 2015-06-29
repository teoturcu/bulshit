//package extendedList;
//
//import java.util.HashMap;
//import java.util.List;
//import com.example.distrans.*;
//import com.example.distrans.Fragments.S2_Trasee;
//
//import android.content.Context;
//import android.graphics.Typeface;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseExpandableListAdapter;
//import android.widget.TextView;
//
//public class ExpandableListAdapter extends BaseExpandableListAdapter {
//
//	private S2_Trasee _context;
//	private List<String> _listDataHeader;
//	private HashMap<String, List<String>> _listDataChild;
//	
//	public ExpandableListAdapter(S2_Trasee s2_Trasee, List<String> listDataHeader,
//            HashMap<String, List<String>> listChildData) {
//        this._context = s2_Trasee;
//        this._listDataHeader = listDataHeader;
//        this._listDataChild = listChildData;
//    }
//	
//	@Override
//	public Object getChild(int groupPosition, int childPosititon) {
//		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
//                .get(childPosititon);
//	}
//
//	@Override
//    public long getChildId(int groupPosition, int childPosition) {
//        return childPosition;
//    }
//
//	@Override
//    public View getChildView(int groupPosition, final int childPosition,
//            boolean isLastChild, View convertView, ViewGroup parent) {
// 
//        final String childText = (String) getChild(groupPosition, childPosition);
// 
//        if (convertView == null) {
//            LayoutInflater infalInflater = (LayoutInflater) this._context.getActivity()
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.s2_trasee_list_item, null);
//        }
// 
//        TextView txtListChild = (TextView) convertView
//                .findViewById(R.id.lblListItem);
// 
//        txtListChild.setText(childText);
//        return convertView;
//    }
//
//	@Override
//    public int getChildrenCount(int groupPosition) {
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
//                .size();
//    }
// 
//    @Override
//    public Object getGroup(int groupPosition) {
//        return this._listDataHeader.get(groupPosition);
//    }
//
//    @Override
//    public int getGroupCount() {
//        return this._listDataHeader.size();
//    }
// 
//    @Override
//    public long getGroupId(int groupPosition) {
//        return groupPosition;
//    }
// 
//    @Override
//    public View getGroupView(int groupPosition, boolean isExpanded,
//            View convertView, ViewGroup parent) {
//        String headerTitle = (String) getGroup(groupPosition);
//        if (convertView == null) {
//            LayoutInflater infalInflater = (LayoutInflater) this._context.getActivity()
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.s2_trasee_group, null);
//        }
// 
//        TextView lblListHeader = (TextView) convertView
//                .findViewById(R.id.textViewTraseeGroup);
//        lblListHeader.setTypeface(null, Typeface.BOLD);
//        lblListHeader.setText(headerTitle);
// 
//        return convertView;
//    }
// 
//    @Override
//    public boolean hasStableIds() {
//        return false;
//    }
// 
//    @Override
//    public boolean isChildSelectable(int groupPosition, int childPosition) {
//        return true;
//    }
//
//public class SavedTabsListAdapter extends BaseExpandableListAdapter {
//	 
//private String[] groups = { "People Names", "Dog Names", "Cat Names", "Fish Names" };
//
//private String[][] children = {
//{ "Arnold", "Barry", "Chuck", "David" },
//{ "Ace", "Bandit", "Cha-Cha", "Deuce" },
//{ "Fluffy", "Snuggles" },
//{ "Goldy", "Bubbles" }
//};
//
//@Override
//public int getGroupCount() {
//return groups.length;
//}
//
//@Override
//public int getChildrenCount(int i) {
//return children[i].length;
//}
//
//@Override
//public Object getGroup(int i) {
//return groups[i];
//}
//
//@Override
//public Object getChild(int i, int i1) {
//return children[i][i1];
//}
//
//@Override
//public long getGroupId(int i) {
//return i;
//}
//
//@Override
//public long getChildId(int i, int i1) {
//return i1;
//}
//
//@Override
//public boolean hasStableIds() {
//return true;
//}
//
//@Override
//public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
//TextView textView = new TextView(SavedTabsFragment.this.getActivity());
//textView.setText(getGroup(i).toString());
//return textView;
//}
//
//@Override
//public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
//TextView textView = new TextView(SavedTabsFragment.this.getActivity());
//textView.setText(getChild(i, i1).toString());
//return textView;
//}
//
//@Override
//public boolean isChildSelectable(int i, int i1) {
//return true;
//}
//
//} 



