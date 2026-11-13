package com.apostit.shared.categories;

import java.util.ArrayList;
import java.util.List;

/**
 * T-Shirt Size Table
 */
public class TShirtSize extends Category {
    static ArrayList<Category> list = new ArrayList<Category>();

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.TShirt();
    }

    @Override
    public String getHelp() {
        return x.TShirtHelp();
    }
}
