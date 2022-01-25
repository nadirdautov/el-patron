package com.company.gb.person.seller;

import com.company.gb.person.personal.Buyer;
import com.company.gb.person.personal.Person;
import com.company.gb.product.Product;

import java.util.List;

public class Seller extends Person {
    private String name;
    private String lastName;
    private List<Product> products;

    public boolean sellProducts(Buyer customer, Product expectedProduct) {
        boolean result = false;
        for(Product product: products) {
            // Проверяем по имени товара, что у продавца есть продукт
            if (product.getName().equals(expectedProduct.getName())) {
                // Проверяем что количество товара >= чем мы хотим купить
                if (product.getQuantity() < expectedProduct.getQuantity()) {
                    continue;
                }
                // Проверяем что кэш покупателя позволяет купить товар
                long requiredCash = (long) product.getPrice() * expectedProduct.getQuantity();
                if (customer.getCash() >= requiredCash) {
                    // Уменьшаем количество продукта у продавца
                    product.setQuantity(product.getQuantity() - expectedProduct.getQuantity());

                    //Создаем новый объект для покупателя, чтобы ссылка не дублировалась
                    Product customerProduct = new Product();
                    customerProduct.setQuantity(expectedProduct.getQuantity());
                    customerProduct.setName(expectedProduct.getName());
                    String currentSeller = String.format("%s %s", getName(), getLastName());
                    customerProduct.setSeller(currentSeller);
                    customerProduct.setSoldAt(String.valueOf(requiredCash));

                    //Добавляем количество продуктов у покупателя
                    customer.addPurchase(customerProduct);
                    //Увеличиваем кэш продавца
                    setCash(getCash() + requiredCash);
                    //Уменьшаем кэш покупателя
                    customer.setCash(customer.getCash() - requiredCash);
                    //Сообщаем потребителю метода, что покупка совершена
                    result = true;
                }
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
