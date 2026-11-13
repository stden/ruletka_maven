package com.apostit.client;

import com.apostit.shared.Converter;
import com.apostit.shared.size.UnitShow;
import com.apostit.shared.size.Units;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.dom.client.Document;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style.Unit;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ruletka implements EntryPoint {
    public Messages x = GWT.create(Messages.class);
    private RootPanel result;
    private RootPanel fromCountryPanel;
    private RootPanel toCountryPanel;
    private RootPanel fromValuePanel;
    private RootPanel help;
    private ListBox selectCategory;
    private ListBox countryFrom;
    private ListBox countryTo;
    private ListBox sizes;
    private Converter converter;

    /**
     * Создаём выпадающий список
     *
     * @param strings Записи
     * @return Готовый список
     */
    private ListBox createListBox(String[] strings) {
        final ListBox listBox = new ListBox(false);
        for (String s : strings) {
            listBox.addItem(s);
        }
        return listBox;
    }

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        commonInterface();
        resultUnitsComboBox();

        converter = new Converter(x);

        RootPanel categoryContainer = RootPanel.get("categoryContainer");
        selectCategory = createListBox(converter.getCategory());
        if (categoryContainer != null) {
            categoryContainer.add(selectCategory);
        }

        fromCountryPanel = RootPanel.get("fromCountry");
        toCountryPanel = RootPanel.get("toCountry");
        fromValuePanel = RootPanel.get("fromSize");
        result = RootPanel.get("result");
        help = RootPanel.get("help");

        ChangeHandler handler1 = new ChangeHandler() { // Выбор категории
            public void onChange(ChangeEvent changeEvent) {
                updateCountryFrom();
                updateCountryTo();
            }
        };
        selectCategory.addChangeHandler(handler1);
        handler1.onChange(null);
    }

    private void updateCountryFrom() {
        countryFrom = createListBox(converter.getCountries(getSelected(selectCategory)));
        fromCountryPanel.clear();
        fromCountryPanel.add(countryFrom);

        ChangeHandler handler = new ChangeHandler() {
            public void onChange(ChangeEvent changeEvent) {
                updateCountryTo();
                updateSizes();
            }
        };
        countryFrom.addChangeHandler(handler);
        if (countryTo != null && countryFrom != null)
            handler.onChange(null);
    }

    private void updateCountryTo() {
        countryTo = createListBox(converter.getCountriesTo(getSelected(selectCategory), getSelected(countryFrom)));
        toCountryPanel.clear();
        toCountryPanel.add(countryTo);

        ChangeHandler handler = new ChangeHandler() {
            public void onChange(ChangeEvent changeEvent) {
                updateSizes();
            }
        };
        countryTo.addChangeHandler(handler);
        handler.onChange(null);
    }

    private void updateSizes() {
        sizes = createListBox(converter.getSizes(getSelected(selectCategory), getSelected(countryFrom)));
        fromValuePanel.clear();
        fromValuePanel.add(sizes);
        ChangeHandler sizeChange = new ChangeHandler() {
            public void onChange(ChangeEvent changeEvent) {
                updateResult();
            }
        };
        sizes.addChangeHandler(sizeChange);
        sizeChange.onChange(null);
    }

    private void updateResult() {
        result.clear();
        result.add(new HTML(
                converter.convert(
                        getSelected(selectCategory),
                        getSelected(countryFrom),
                        getSelected(countryTo),
                        getSelected(sizes))));
    }

    private void commonInterface() {
        Document.get().setTitle(x.appTitle());
        RootPanel appTitlePanel = RootPanel.get("appTitle");
        if (appTitlePanel != null) {
            appTitlePanel.add(new HTML(x.appTitle()));
        }
        RootPanel.get("category").add(new HTML(x.category()));
        RootPanel.get("fromCountryLabel").add(new HTML(x.fromCountryLabel()));
        RootPanel.get("toCountryLabel").add(new HTML(x.toCountryLabel()));
        RootPanel.get("resultUnitsLabel").add(new HTML(x.resultUnitsLabel()));
        RootPanel.get("fromSizeLabel").add(new HTML(x.fromSizeLabel()));
    }

    private void resultUnitsComboBox() {
        RootPanel resultUnits = RootPanel.get("resultUnits");
        final ListBox listBox = createListBox(new String[]{x.unitCm(), x.unitInch()});
        resultUnits.add(listBox);
        listBox.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent changeEvent) {
                final String system = getSelected(listBox);
                if (system.equals(x.unitCm()))
                    UnitShow.units = Units.CM;
                else if (system.equals(x.unitInch()))
                    UnitShow.units = Units.INCH;
                else
                    throw new RuntimeException(system);
                updateSizes();
            }
        });
    }

    private String getSelected(ListBox selectCategory) {
        return selectCategory.getItemText(selectCategory.getSelectedIndex());
    }
}
