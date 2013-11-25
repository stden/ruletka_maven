package com.apostit.shared.categories;

import java.util.ArrayList;
import java.util.List;

/**
 * Брюки, шорты
 */
public class PantsShorts extends Category {
    static ArrayList<Category> list = new ArrayList<Category>();

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.PantsShorts();
    }

    @Override
    public String getHelp() {
        return x.PantsShortsHelp();
    }
}
