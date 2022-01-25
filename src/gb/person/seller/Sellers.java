package com.company.gb.person.seller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Sellers {
    SELLER_1("Виталий","Ерёмин",0),
    SELLER_2("Алесей","Ушаков",0),
    SELLER_3("Надир","Даутов",0),
    SELLER_4("Карина","Гусева",0),
    SELLER_5("Михаил","Сабанашвили",0),
    SELLER_6("Артем","Югай",0);

    public final String sellerName;
    public final String sellerLastName;
    public final int initCash;

    private static final Map<SellerObject,Sellers> SELLERS_MAP;

    Sellers(String sellerName, String sellerLastName, int initCash) {
        this.sellerName = sellerName;
        this.sellerLastName = sellerLastName;
        this.initCash = initCash;
    }

    static {
        Map<SellerObject,Sellers> map = new HashMap<SellerObject,Sellers>();
        // Передаём количество всех продавцов, их значение 6
        for (Sellers instance : Sellers.values()) {
            SellerObject so = new SellerObject(instance.getSellerName().toLowerCase(),instance.getSellerLastName().toLowerCase());
            map.put(so, instance);
        }
        SELLERS_MAP = Collections.unmodifiableMap(map);
    }

    public static Sellers get(SellerObject mySeller) {
        return SELLERS_MAP.get(mySeller);
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerLastName() {
        return sellerLastName;
    }

    public int getInitCash() {
        return initCash;
    }
}