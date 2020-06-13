package com.example.apparelmarket.models;

import com.example.apparelmarket.R;

import java.util.ArrayList;

public class SearchClass {

    // Function that handles search queries and returns an array of items matching that given query.
    public static ArrayList<ApparelItem> searchFunction(String query, ArrayList<ApparelItem> toSearch) {

        ArrayList<ApparelItem> toReturn = new ArrayList<ApparelItem>();

        // Adds the item to the array if the query is contained within the item's name.
        for (int i = 0; i < toSearch.size(); i++){
            if ( (toSearch.get(i).getName().toLowerCase().contains(query.toLowerCase())) || (toSearch.get(i).getCategory().toLowerCase().contains(query.toLowerCase() ))) {
                toReturn.add(toSearch.get(i));
            }
            else if ((query.toLowerCase().contains(toSearch.get(i).getName().toLowerCase() )) || (query.toLowerCase().contains(toSearch.get(i).getCategory().toLowerCase() )) ){
                toReturn.add(toSearch.get(i));
            }
        }

        // Returns a single Card if no results are found in ListActivity.
        if (toReturn.isEmpty()) {
            int[] notFound = {R.drawable.no_query,R.drawable.no_query,R.drawable.no_query};
            ApparelItem notfound= new ApparelItem("null","null", "Please try again.", "No results found,", "null", notFound,1);
            toReturn.add(notfound);
        }

        return toReturn;
    }

}