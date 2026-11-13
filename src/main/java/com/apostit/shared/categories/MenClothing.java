package com.apostit.shared.categories;

import com.apostit.client.Messages;
import com.apostit.shared.size.Country;
import com.apostit.shared.size.Inches;
import com.apostit.shared.size.Len;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.apostit.shared.Converter.*;

/**
 * Мужская одежда
 */
public class MenClothing extends Category {
    static ArrayList<Category> list = new ArrayList<Category>();
    static HashMap<String, String> china = new HashMap<String, String>();
    static HashMap<String, SizeInInches> dim = new HashMap<String, SizeInInches>();

    public MenClothing(int russian) {
        double bust = Rus_Bust(russian);
        double waist = Rus_Waist2(russian);
        long USA = Rus_USA2(russian);
        double shoulders = Rus_Shoulders(russian);
        final String international1 = Rus_International(russian);
        // Российский
        map.put(x.Russia(), new Country(russian));
        // Международный
        map.put(x.International(), new Country(international1));
        // США
        map.put(x.USA(), new Country(USA));
        map.put(x.Canada(), new Country(USA));
        // Европейский
        final int europe = Rus_Europe(russian);
        map.put(x.Europe(), new Country(europe));
        // TODO: Английский
        // Англия (европейский)
        final int englang = Rus_England(russian);
        map.put(x.EnglandEurope(), new Country(englang));
        // Италия
        map.put(x.Italy(), new Country(Rus_Italy(russian)));
        // Франция
        map.put(x.France(), new Country(russian - 2));
        // Испания
        map.put(x.Spain(), new Country(UK_Spain(englang)));
        // Германия
        map.put(x.Germany(), new Country(UK_German(englang)));
        // Япония
        map.put(x.Japan(), new Country(EU_Japan(europe)));

        map.put(x.China(), new Country(china.get(international1)));

        map.put(x.bust(), new Len(bust));
        map.put(x.Waist(), new Len(waist));
        map.put(x.Shoulders(), new Len(shoulders));

        SizeInInches inInches = dim.get(international1);
        map.put(x.Neck(), inInches.Neck);
        map.put(x.Chest(), inInches.Chest);
        map.put(x.Sleeve(), inInches.Sleeve);
        map.put(x.Waist(), inInches.Waist);
    }

    public MenClothing(Messages x) {
        super(x);
        china.clear();
        china.put(XS, "160/86-88");
        china.put(S, "165/88-90");
        china.put(M, "170/96-98");
        china.put(L, "175/108-110");
        china.put(XL, "180/118-122");
        china.put(XXL, "185/126-130");

        String[] sizes = {XS, S, M, L, XL, XXL, XXXL, XXXXL};
        double[][] neck = {{13, 13.5}, {14, 14.5}, {15, 15.5}, {16, 16.5}, {17, 17.5}, {18, 18.5}, {19, 19.5}, {20, 20.5}};
        double[][] chest = {{33, 34}, {35, 37}, {38, 40}, {42, 44}, {46, 48}, {50, 52}, {54, 56}, {58, 60}};
        double[][] sleeve = {{31.5, 32}, {32.5, 33}, {33.5, 34}, {34.5, 35}, {35.5, 36}, {36, 36.5}, {36.5, 37}, {37, 37.5}};
        double[][] waist = {{27, 28}, {29, 31}, {32, 34}, {36, 38}, {40, 42}, {44, 48}, {50, 52}, {52, 54}};
        for (int i = 0; i < sizes.length; i++) {
            dim.put(sizes[i], new SizeInInches(
                    new Inches(neck[i][0], neck[i][1]),
                    new Inches(chest[i][0], chest[i][1]),
                    new Inches(sleeve[i][0], sleeve[i][1]),
                    new Inches(waist[i][0], waist[i][1]))
            );
        }

        list.clear();
        for (int i = 40; i < 58; i++)
            list.add(new MenClothing(i));
    }

    public static int Rus_England(int russian) {
        return russian >= 52 ? russian - 10 : russian - 8;
    }

    public static int Rus_Italy(int russian) {
        return russian - 2;
    }

    /**
     * @param russian Российский размер
     * @return Обхват груди (см)
     */
    public static int Rus_Chest(int russian) {
        return russian * 2;
    }

    /**
     * @param russian Российский размер
     * @return Обхват талии (см)
     */
    public static int Rus_Waist(int russian) {
        return russian >= 48 ? russian * 2 - 12 : russian * 2 - 10;
    }

    public static String Rus_International(int russian) {
        if (russian >= 64)
            return XXXL;
        if (russian >= 60)
            return XXL;
        if (russian >= 56)
            return XL;
        if (russian >= 52)
            return L;
        if (russian >= 48)
            return M;
        if (russian >= 44)
            return S;
        return XS;
    }

    /**
     * @param russian Российский размер
     * @return Европа
     */
    public static int Rus_Europe(int russian) {
        return russian - 6;
    }

    public static int UK_Spain(int uk) {
        if (uk >= 48)
            return uk + 14;
        if (uk >= 46)
            return uk + 13;
        if (uk >= 42)
            return uk + 12;
        if (uk >= 40)
            return uk + 11;
        return uk + 10;
    }

    public static String EU_Japan(int europe) {
        if (europe >= 54)
            return LL;
        if (europe >= 50)
            return L;
        if (europe >= 48)
            return M;
        return S;
    }

    public static int UK_German(int uk) {
        return uk + 10;
    }

    public static int Rus_USA(int russian) {
        return russian - 40;
    }

    /**
     * linear fit {{81.3, 0.0}, {83.8, 2.0}, {86.4, 4.0}, {88.9, 6.0}, {91.4, 8.0}, {95.3, 10.0}, {97.8, 12.0}, {102.9, 14.0}, {105.4, 16.0}, {113.0, 18.0}}
     * quadratic fit {{81.3, 0.0}, {83.8, 2.0}, {86.4, 4.0}, {88.9, 6.0}, {91.4, 8.0}, {95.3, 10.0}, {97.8, 12.0}, {102.9, 14.0}, {105.4, 16.0}, {113.0, 18.0}}
     */
    public static int Bust_USA(double x) {
        return (int) Math.round((-134.83 + 2.43611 * x - 0.00958068 * x * x) / 2.0) * 2;
    }

    public static int waist_USA(double x) {
        return (int) Math.round((-46.5383 + 0.856957 * x - 0.00163232 * x * x) / 2.0) * 2;
    }

    public static long Rus_USA2(int x) {
        return Math.round((-70.6946 + 2.02188 * x - 0.00682689 * x * x) / 2.0) * 2;
    }

    public static long Rus_Shoulders(int x) {
        return Math.round(-9.20631 + 1.48781 * x - 0.00861394 * x * x);
    }

    public static double Rus_Bust(int x) {
        return 119.851 - 3.41998 * x + 0.0609819 * x * x;
    }

    public static double Rus_Waist2(int x) {
        return -16.8986 + 1.74065 * x + 0.00506307 * x * x;
    }

    @Override
    public List<Category> getList() {
        return list;
    }

    @Override
    public String getName() {
        return x.MenClothing();
    }

    @Override
    public String getHelp() {
        return x.MenClothingHelp();
    }

    class SizeInInches {
        public Inches Neck, Chest, Sleeve, Waist;

        public SizeInInches(Inches neck, Inches chest, Inches sleeve, Inches waist) {
            Neck = neck;
            Chest = chest;
            Sleeve = sleeve;
            Waist = waist;
        }
    }


}
