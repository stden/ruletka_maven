package com.apostit.shared.categories;

import com.apostit.client.Messages;
import com.apostit.shared.size.Country;
import com.apostit.shared.size.Range;

import java.util.ArrayList;
import java.util.List;

import static com.apostit.shared.Converter.*;
import static com.apostit.shared.RomanNumeral.toRoman;

/**
 * http://www.stylepark.ru/help/sizes/
 */
public class Underwear extends Category {
    static ArrayList<Category> list = new ArrayList<Category>();

    public Underwear(double l1, double l2, int russian, int italy, String international) {
        map.put(x.Russia(), new Country(russian));
        map.put(x.Germany(), new Country(russian));
        map.put(x.France(), new Country(russian + 15));
        map.put(x.Italy(), new Country(italy));
        map.put(x.ItalyRoman(), new Country(toRoman(italy)));
        map.put(x.Ukraine(), new Country(italy * 2 + 28));
        map.put(x.International(), new Country(international));

        map.put(x.BustCircumference(), new Range(l1, l2));
    }

    public Underwear(Messages x) {
        super(x);

        list.add(new Underwear(63, 67, 65, 1, XS));
        list.add(new Underwear(68, 72, 70, 2, S));
        list.add(new Underwear(73, 77, 75, 3, M));
        list.add(new Underwear(78, 82, 80, 4, L));
        list.add(new Underwear(83, 87, 85, 5, XL));
        list.add(new Underwear(88, 92, 90, 6, XXL));
        list.add(new Underwear(93, 97, 95, 7, XXXL));
        list.add(new Underwear(98, 102, 100, 8, XXXL));
        list.add(new Underwear(103, 107, 105, 9, XXXL));
        list.add(new Underwear(108, 112, 110, 10, XXXL));
        list.add(new Underwear(113, 117, 115, 11, XXXL));
        list.add(new Underwear(118, 122, 120, 12, XXXL));
        list.add(new Underwear(123, 127, 125, 13, XXXL));
    }

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.Underwear();
    }

    @Override
    public String getHelp() {
        return "";
    }
}
