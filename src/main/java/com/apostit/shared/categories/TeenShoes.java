package com.apostit.shared.categories;

import com.apostit.client.Messages;
import com.apostit.shared.size.Country;

import java.util.ArrayList;
import java.util.List;

public class TeenShoes extends Category {
    static ArrayList<Category> list = new ArrayList<Category>();

    public TeenShoes(double russia, double england) {
        map.put(x.Russia(), new Country(russia));
        map.put(x.Europe(), new Country(russia + 1));
        map.put(x.England(), new Country(england));
        map.put(x.USA(), new Country(england + 1));
        map.put(x.Canada(), new Country(england + 1));
    }

    public TeenShoes(Messages x) {
        super(x);

        list.add(new TeenShoes(32, 1));
        list.add(new TeenShoes(33, 1.5));
        list.add(new TeenShoes(33.5, 2));
        list.add(new TeenShoes(34, 2.5));
        list.add(new TeenShoes(34.5, 3));
        list.add(new TeenShoes(35, 3.5));
        list.add(new TeenShoes(36, 4));
        list.add(new TeenShoes(36.5, 4.5));
        list.add(new TeenShoes(37, 5));
        list.add(new TeenShoes(38, 5.5));
        list.add(new TeenShoes(38.5, 6));
        list.add(new TeenShoes(39, 6.5));
    }

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.TeenagerShoes();
    }

    @Override
    public String getHelp() {
        return ""; // x.TeenagerShoesHelp();
    }
}
