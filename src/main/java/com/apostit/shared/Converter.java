package com.apostit.shared;

import com.apostit.client.Messages;
import com.apostit.shared.categories.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Конвертирование
 */
public class Converter {
    public static final String XXS = "XXS";
    public static final String XS = "XS";
    public static final String S = "S";
    public static final String M = "M";
    public static final String L = "L";
    public static final String XL = "XL";
    public static final String XXL = "XXL";
    public static final String XXXL = "XXXL";
    public static final String XXXXL = "XXXXL";
    public static final String LL = "LL"; // Japan
    // Для поиска категории по названию
    public static HashMap<String, Category> classes = new HashMap<String, Category>();
    // Категории в порядке для вывода
    public static ArrayList<String> categories = new ArrayList<String>();

    public Converter(Messages x) {
        // Мужская одежда
        addCategory(new MenClothing(x));
        // Мужская обувь
        addCategory(new ManShoes(x));
        // Женская одежда
        addCategory(new WomenClothing(x));
        // Женская обувь
        addCategory(new WomanShoes(x));
        // Детская одежда
        addCategory(new ChildWear(x));
        // Подростковая, молодежная обувь
        //addCategory(new TeenShoes(x));
        // Детская обувь
        addCategory(new ChildShoes(x));
        // Одежда для малышей
        addCategory(new ClothesForKids(x));
        // Нижнее белье
        addCategory(new Underwear(x));
        // Носки
        //addCategory(new SocksSize(x));
        addCategory(new Shirts(x));
    }

    private void addCategory(Category value) {
        classes.put(value.getName(), value);
        categories.add(value.getName());
    }

    public String convert(String category, String from, String to, String value) {
        if (value == null)
            return category + " - " + from + " - " + value;
        for (Category size : classes.get(category).getSizes()) {
            for (String param : size.getCountries()) {
                if (from.equals(param) && value.equals(size.map.get(param).toString()))
                    return size.forCountry(to);
            }
        }
        return null;
    }

    public String[] getCategory() {
        return categories.toArray(new String[]{"x"});
    }

    public String[] getSizes(String category, String system) {
        ArrayList<String> strings = new ArrayList<String>();
        for (Category size : classes.get(category).getSizes()) {
            for (String param : size.getCountries()) {
                if (system.equals(param)) {
                    if (!strings.contains(size.map.get(param).toString()))
                        strings.add(size.map.get(param).toString());
                }
            }
        }
        return strings.toArray(new String[]{"x"});
    }

    public String[] getCountries(String category) {
        return classes.get(category).getCountries();
    }

    /**
     * Исключаем одну страну чтобы не показывалась страна из которой конвертируем
     *
     * @param category    Категория
     * @param countryFrom Какую страну исключить?
     * @return Список стран без countryFrom
     */
    public String[] getCountriesTo(String category, String countryFrom) {
        ArrayList<String> strings = new ArrayList<String>();
        for (String country : getCountries(category)) {
            if (country.equals(countryFrom)) continue; // Исключаем
            strings.add(country);
        }
        return strings.toArray(new String[]{"x"});
    }
}
