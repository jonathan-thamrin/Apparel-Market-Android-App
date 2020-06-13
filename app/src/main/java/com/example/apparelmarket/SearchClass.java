package com.example.apparelmarket;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchClass {
    public static ArrayList<ApparelItem> searchFunction(String query, ArrayList<ApparelItem> toSearch) {
        ArrayList<ApparelItem> toReturn = new ArrayList<ApparelItem>();

        for (int i = 0; i < toSearch.size(); i++){
            if (toSearch.get(i).getName().contains(query) || toSearch.get(i).getCategory().contains(query)) {
                toReturn.add(toSearch.get(i));
            }
        }
        if (toReturn.isEmpty()) {
            int[] notFound = {R.drawable.chinos_1_1,R.drawable.chinos_1_1,R.drawable.chinos_1_1};

            ApparelItem notfound= new ApparelItem("No results found","No results found", "null", "null", "null", notFound,1);
            toReturn.add(notfound);
        }

        return toReturn;
    }

}