package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import enums.Material;
import enums.ProductSeparators;
import enums.SkinType;

import java.awt.*;

public class ProductParser {

    public static Product stringToProduct(String productStr) {
        final ProductSeparators productType = ProductSeparators.getIdByChar(productStr.substring(0,1));

        switch (productType) {

            case PRODUCT_ID:
                return convertToProduct(productStr);

            case ClOTH_ID:
                return convertToCloth(productStr);

            case BOOTS_ID:
                return convertToBoots(productStr);
        }

        return null;
    }

    private static Boots convertToBoots(String productStr) {
        String [] productInformation = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(productInformation[1]);
        String productName = productInformation[2];
        Float price = Float.parseFloat(productInformation[3]);
        Float weight = Float.parseFloat(productInformation[4]);
        enums.Color color = ColorParser.parseStrToColor(productInformation[5]);
        Integer productCount = Integer.parseInt(productInformation[6]);
        Integer size = Integer.parseInt(productInformation[7]);
        SkinType skinType = SkinParser.parseStrToSkinType(productInformation[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, skinType);
    }

    private static Cloth convertToCloth(String productStr) {
        String [] productInformations = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        enums.Color color = ColorParser.parseStrToColor(productInformations[5]);
        Integer productCount = Integer.parseInt(productInformations[6]);
        String size = productInformations[7];
        Material material = MaterialParser.parseStrToMaterial(productInformations[8]);

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToProduct(String productStr) {
        String [] productInformations = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        enums.Color color = ColorParser.parseStrToColor(productInformations[5]);
        Integer productCount = Integer.parseInt(productInformations[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }
}
