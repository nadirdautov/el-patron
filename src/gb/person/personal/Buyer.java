package com.company.gb.person.personal;

import com.company.gb.Products;
import com.company.gb.market.Market;
import com.company.gb.person.seller.Seller;
import com.company.gb.person.seller.Sellers;
import com.company.gb.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Person {
    private final List<Product> expectedPurchaseList;
    private List<Product> purchaseList;

    public Buyer(List<Product> expectedPurchaseList, int cash) {
        this.purchaseList = new ArrayList<>();
        this.expectedPurchaseList = expectedPurchaseList;
        this.setCash(cash);
    }

    public void addPurchase(Product product) {
        if (purchaseList == null) {
            purchaseList = new ArrayList<>();
        }

        purchaseList.add(product);
    }

    public void findProductOnMarket(Market market) {
        for (Product product : getExpectedPurchaseList()) {
            for (Seller seller : market.getSellers()) {
                boolean isBought = seller.sellProducts(this, product);
                if (isBought) {
                    break;
                }
            }
        }
    }

    public boolean findProductSeller(Market market, Sellers sellerEnum) {
        boolean result = false;
        for (Product product : getExpectedPurchaseList()) {
            for (Seller seller : market.getSellers()) {
                if (seller.getName().equals(sellerEnum.sellerName) && seller.getLastName().equals(sellerEnum.sellerLastName)) {
                    result = true;
                    boolean isBought = seller.sellProducts(this, product);
                    if (isBought) {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public void info() {
        StringBuilder result = new StringBuilder();
        if (purchaseList.isEmpty()) {
            result.append("Я ничего не купил");
        } else {
            for(Product product: purchaseList) {
                result.append(System.getProperty("line.separator"));
                result.append(product.getSeller());
                result.append(" продал мне товар \"");
                result.append(product.getName());
                result.append("\" в количестве ");
                result.append(product.getQuantity());
                result.append(" за ");
                result.append(product.getSoldAt());
                result.append(" руб.,");
            }
            result.deleteCharAt(result.lastIndexOf(","));
        }

        result.append(System.getProperty("line.separator"));
        result.append("У меня осталось денег в количестве: ");
        result.append(getCash());
        result.append(" руб.");

        System.out.println(result);
    }

    public List<Product> getExpectedPurchaseList() {
        return expectedPurchaseList;
    }

    public List<Product> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Product> purchaseList) {
        this.purchaseList = purchaseList;
    }

}