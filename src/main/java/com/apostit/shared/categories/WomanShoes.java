package com.apostit.shared.categories;

import com.apostit.client.Messages;
import com.apostit.shared.size.Country;
import com.apostit.shared.size.EngSize;
import com.apostit.shared.size.Range;

import java.util.ArrayList;
import java.util.List;

/**
 * Размеры женской обуви (туфли, босоножки, сапоги)
 */
public class WomanShoes extends Category {
    static ArrayList<Category> list = new ArrayList<Category>();

    public WomanShoes(int europe, double UK, double l1, double l2, double japan) {
        map.put(x.Russia(), new Country(europe - 1));
        map.put(x.Europe(), new Country(europe));
        map.put(x.England(), new EngSize(UK));
        map.put(x.Australia(), new Country(UK + 1));
        map.put(x.USA(), new Country(UK + 2.5));
        map.put(x.Canada(), new Country(UK + 2.5));
        map.put(x.Mexico(), new Country(UK - 0.5));
        map.put(x.China(), new Country(europe + 0.5));
        map.put(x.Japan(), new Country(japan));

        map.put(x.FootLength(), new Range(l1, l2));
    }

    public WomanShoes(Messages x) {
        super(x);

        list.add(new WomanShoes(35, 2.5, 21.7, 22.3, 21.0));
        list.add(new WomanShoes(36, 3, 22.4, 23.0, 21.5));
        list.add(new WomanShoes(37, 4, 23.1, 23.6, 22.0));
        list.add(new WomanShoes(38, 5, 23.7, 24.3, 22.5));
        list.add(new WomanShoes(39, 5.5, 24.4, 25.0, 23.0));
        list.add(new WomanShoes(40, 6, 25.1, 25.7, 23.5));
        list.add(new WomanShoes(41, 7, 25.8, 26.4, 24));
        list.add(new WomanShoes(42, 8, 26.5, 27.0, 24.5));
        list.add(new WomanShoes(43, 9, 27.1, 27.7, 25));
        list.add(new WomanShoes(44, 10, 27.8, 28.3, 25.5));
        list.add(new WomanShoes(45, 10.5, 28.4, 29.0, 26));
        list.add(new WomanShoes(46, 11, 29.1, 29.7, 27));
        list.add(new WomanShoes(47, 11.5, 29.8, 30.3, 28));
        list.add(new WomanShoes(48, 12, 30.4, 31.0, 29));
        list.add(new WomanShoes(49, 12.5, 31.1, 31.6, 30));
        list.add(new WomanShoes(50, 13, 31.7, 32.3, 31));
        list.add(new WomanShoes(51, 13.5, 32.4, 33.0, 32));
        list.add(new WomanShoes(52, 14.5, 33.1, 33.6, 33));
    }

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.WomenShoes();
    }

    @Override
    public String getHelp() {
        return x.WomenShoesHelp();
    }

}
