package com.apostit.shared.categories;

import com.apostit.client.Messages;
import com.apostit.shared.RomanNumeral;
import com.apostit.shared.size.Country;
import com.apostit.shared.size.Len;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.apostit.shared.Converter.*;

/**
 * Женская одежда
 */
public class WomenClothing extends Category {
    static ArrayList<Category> list = new ArrayList<Category>();
    static HashMap<String, String> china = new HashMap<String, String>();

    public WomenClothing(int russian, double hip, double bust, double waist, String international, int england, int USA) {
        // По странам
        map.put(x.Russia(), new Country(russian));
        map.put(x.International(), new Country(international));
        map.put(x.USA(), new Country(USA));
        map.put(x.Europe(), new Country(england + 32 - 4));
        map.put(x.England(), new Country(england));
        map.put(x.EnglandEurope(), new Country(england + 26));
        map.put(x.Italy(), new Country(england + 32));
        map.put(x.ItalyRoman(), new Country(RomanNumeral.toRoman(USA / 2)));
        map.put(x.France(), new Country(UK_France(england)));
        map.put(x.Spain(), new Country(UK_Spain(england)));
        map.put(x.Germany(), new Country(UK_Germany(england)));

        map.put(x.China(), new Country(china.get(international)));

        map.put(x.Japan(), new Country(UK_Japan(england)));

        map.put(x.bust(), new Len(bust));
        map.put(x.Waist(), new Len(waist));
        map.put(x.Hips(), new Len(hip));
    }

    public WomenClothing(Messages x) {
        super(x);

        china.put(XXS, "155-160 / 82-84");
        china.put(XS, "160-165 / 84-86");
        china.put(S, "165-170 / 88-90");
        china.put(M, "167-172 / 92-96");
        china.put(L, "168-173 / 98-102");
        china.put(XL, "170-176 / 106-110");
        china.put(XXL, "176-184 / 110-116");
        china.put(XXXL, "184-195 / 116-125");

        list.add(new WomenClothing(38, 82, 76, 58, XXS, 4, 0));
        list.add(new WomenClothing(40, 86.4, 81.3, 61, XS, 6, 0));
        list.add(new WomenClothing(42, 88.9, 83.8, 63.5, XS, 6, 2));
        list.add(new WomenClothing(43, 91.5, 86.4, 66, S, 8, 4));
        list.add(new WomenClothing(45, 94, 88.9, 68.6, M, 10, 6));
        list.add(new WomenClothing(46, 96.5, 91.4, 71.1, M, 12, 8));
        list.add(new WomenClothing(47, 99.1, 95.3, 74.9, M, 13, 9));
        list.add(new WomenClothing(48, 102.9, 97.8, 77.5, L, 14, 10));
        list.add(new WomenClothing(50, 108, 102.9, 82.6, L, 16, 14));
        list.add(new WomenClothing(52, 111.8, 105.4, 86.4, XL, 18, 16));
        list.add(new WomenClothing(56, 120, 112, 92, XXL, 22, 18));
        list.add(new WomenClothing(58, 124, 116, 97, XXXL, 24, 20));
    }

    public static double RusToEur(double ru) {
        return ru - 6;
    }

    public static double RusToUSA(double ru) {
        return ru - 34;
    }

    public static double UK_Spain(double v) {
        return v + 28;
    }

    public static double UK_France(double v) {
        return v + 28;
    }

    public static double UK_Italy(double v) {
        return v + 32.0;
    }

    public static double UK_Germany(double v) {
        return v + 26;
    }

    public static double UK_Japan(double v) {
        return v - 3.0;
    }

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.WomenClothing();
    }

    @Override
    public String getHelp() {
        return "";
    }
}
