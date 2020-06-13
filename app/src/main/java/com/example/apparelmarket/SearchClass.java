package com.example.apparelmarket;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchClass {
    public static ArrayList<ApparelItem> searchFunction(String query, ArrayList<ApparelItem> toSearch) {
        ArrayList<ApparelItem> toReturn = new ArrayList<ApparelItem>();

        for (int i = 0; i < toSearch.size(); i++){
            if ( (toSearch.get(i).getName().toLowerCase().contains(query.toLowerCase())) || (toSearch.get(i).getCategory().toLowerCase().contains(query.toLowerCase() ))) {
                toReturn.add(toSearch.get(i));
            }
            else if ((query.toLowerCase().contains(toSearch.get(i).getName().toLowerCase() )) || (query.toLowerCase().contains(toSearch.get(i).getCategory().toLowerCase() )) ){
                toReturn.add(toSearch.get(i));
            }
        }
        //TODO IMPLEMENT PROPER NOT FOUND IMAGES
        if (toReturn.isEmpty()) {
            int[] notFound = {R.drawable.no_query,R.drawable.no_query,R.drawable.no_query};

            ApparelItem notfound= new ApparelItem("null","null", "Please try again.", "No results found,", "null", notFound,1);
            toReturn.add(notfound);
        }

        return toReturn;
    }

}