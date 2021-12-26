package ua.com.alevel;

import ua.com.alevel.citylist.MinPrice;
import ua.com.alevel.datelist.DataFormat;
import ua.com.alevel.namelist.UniqueName;

public class StartMain {
    public static void main(String[] args) {
        DataFormat dataFormat = new DataFormat();
        dataFormat.formattedDate();
        UniqueName uniqueName = new UniqueName();
        uniqueName.returnFirstUniqueName();
        MinPrice minPrice = new MinPrice();
        minPrice.run();
    }
}
