package com.example.apparelmarket.models;

import com.example.apparelmarket.models.ApparelItem;
import com.example.apparelmarket.models.ApparelProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SessionClass {
    public static ArrayList<ApparelItem> toppickarray = new ArrayList<ApparelItem>();

    public static void generateData() {
        toppickarray.add(ApparelProvider.dataArray.get(0));
        toppickarray.add(ApparelProvider.dataArray.get(1));
        toppickarray.add(ApparelProvider.dataArray.get(2));
    }

    // Calculates the item with the highest number of views and displays it from highest to lowest.
    // Generates an array with that order for use in MainActivity.
    public static void largestthree() {
        int i, first, second, third;
        int firstindex,secondindex,thirdindex;

        third = first = second = Integer.MIN_VALUE;
        firstindex = secondindex = thirdindex = 0;

        for (i = 0; i < ApparelProvider.dataArray.size() ; i ++)
        {
            /* If current element is greater than
            first*/
            if (ApparelProvider.dataArray.get(i).getItemView() > first)
            {
                third = second;
                second = first;
                first = ApparelProvider.dataArray.get(i).getItemView();

                thirdindex = secondindex;
                secondindex = firstindex;
                firstindex = i;

            }

            /* If dataarray[i] is in between first and
            second then update second  */
            else if (ApparelProvider.dataArray.get(i).getItemView() > second)
            {
                third = second;
                second = ApparelProvider.dataArray.get(i).getItemView();

                thirdindex = secondindex;
                secondindex = i;

            }

            else if (ApparelProvider.dataArray.get(i).getItemView() > third)
            {
                third = ApparelProvider.dataArray.get(i).getItemView();
                thirdindex = i;
            }

        }

        toppickarray.set(2,ApparelProvider.dataArray.get(thirdindex));
        toppickarray.set(1,ApparelProvider.dataArray.get(secondindex));
        toppickarray.set(0,ApparelProvider.dataArray.get(firstindex));
    }
}