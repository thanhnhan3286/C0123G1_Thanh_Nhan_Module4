package com.example.productsmanagement.repository.impl;

import com.example.productsmanagement.model.Product;
import com.example.productsmanagement.repository.BaseRepository;
import com.example.productsmanagement.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
//    private static final List<Product> productList = new ArrayList<>();
//    static {
//        productList.add(new Product(1, "ASUS ROG Zephyrus G14",
//                "2.8GHz AMD Ryzen 7 5800HS octa-core processor (turbo up to 4.4GHz) and 16GB of DDR4 RAM is equipped to handle your most resource-intensive games with ease " +
//                        "512GB M.2 NVMe PCIe 3.0 solid state drive (SSD) gives you plenty reliable storage space with speedy load times " +
//                        "NVIDIA GeForce GTX 1650 graphics card with 4GB of dedicated memory presents every image or scene in smooth, " +
//                        "lifelike clarity ROG Intelligent Cooling System features self-cleaning, anti-dust tunnels to maintain cooling power and stability 14 Pantone-validated, " +
//                        "Full HD (1920 x 1080) display with a 60Hz refresh rate, 16:9 aspect ratio and 300nits brightness delivers breathtaking visuals with true-to-life detail", "ASUS", 1000F));
//        productList.add(new Product(2, "Acer Nitro R7 15.6' Gaming Laptop - Black",
//                "3.2GHz AMD Ryzen R76800H CPU and 16GB DDR5 RAM are powerful enough for heavy AAA games, image editing, video rendering, and a multitude of tasks 1TB " +
//                        "solid state drive provides reliable storage, and speeds up game loading times, data transfers, boot up and more Dedicated NVIDIA RTX 3070 Ti GPU outputs ultra-realistic ray-traced visuals and immersive graphics in " +
//                        "your games 15.6-inch IPS LED-backlit display with 2560 x 1440 native resolution, 165Hz refresh rate, and 3ms overdrive response time give you fluid gameplay with eye-catching visuals",
//                "Acer", 1399F));
//        productList.add(new Product(3, "Acer Nitro R7 15.6' Gaming Laptop - Black",
//                "3.2GHz AMD Ryzen R76800H CPU and 16GB DDR5 RAM are powerful enough for heavy AAA games, image editing, video rendering, and a multitude of tasks 1TB " +
//                        "solid state drive provides reliable storage, and speeds up game loading times, data transfers, boot up and more Dedicated NVIDIA RTX 3070 Ti GPU outputs ultra-realistic ray-traced visuals and immersive graphics in " +
//                        "your games 15.6-inch IPS LED-backlit display with 2560 x 1440 native resolution, 165Hz refresh rate, and 3ms overdrive response time give you fluid gameplay with eye-catching visuals",
//                "Acer", 1399F));
//        productList.add(new Product(4, "Acer Nitro R7 15.6' Gaming Laptop - Black",
//                "3.2GHz AMD Ryzen R76800H CPU and 16GB DDR5 RAM are powerful enough for heavy AAA games, image editing, video rendering, and a multitude of tasks 1TB " +
//                        "solid state drive provides reliable storage, and speeds up game loading times, data transfers, boot up and more Dedicated NVIDIA RTX 3070 Ti GPU outputs ultra-realistic ray-traced visuals and immersive graphics in " +
//                        "your games 15.6-inch IPS LED-backlit display with 2560 x 1440 native resolution, 165Hz refresh rate, and 3ms overdrive response time give you fluid gameplay with eye-catching visuals",
//                "Acer", 1399F));
//        productList.add(new Product(5, "Acer Nitro R7 15.6' Gaming Laptop - Black", "3.2GHz AMD Ryzen R76800H CPU and 16GB DDR5 RAM are powerful enough for heavy AAA games, image editing, video rendering, and a multitude of tasks 1TB " +
//                "solid state drive provides reliable storage, and speeds up game loading times, data transfers, boot up and more Dedicated NVIDIA RTX 3070 Ti GPU outputs ultra-realistic ray-traced visuals and immersive graphics in " +
//                "your games 15.6-inch IPS LED-backlit display with 2560 x 1440 native resolution, 165Hz refresh rate, and 3ms overdrive response time give you fluid gameplay with eye-catching visuals",
//                "Acer", 1399F));
//    }

    @Override
    public List<Product> getList() {
        List<Product> productList1 = BaseRepository.entityManager.createQuery("SELECT p FROM Product AS p", Product.class).getResultList();
//        createNativeQuery => SQL
        return productList1;
    }

    @Override
    public void add(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public void update(Product product) {
        List<Product> productList =
                BaseRepository.entityManager.createQuery("SELECT p FROM Product AS p", Product.class).getResultList();
        for (Product p : productList) {
            if (p.getId().equals(product.getId())) {
                BaseRepository.entityManager.merge(product);
//                p.setName(product.getName());
//                p.setBrand(product.getBrand());
//                p.setDescription(product.getDescription());
//                p.setPrice(product.getPrice());
            }
        }
    }

    @Override
    public void delete(int id) {
//        List<Product> productList =
//                BaseRepository.entityManager.createQuery("SELECT p FROM Product AS p", Product.class).getResultList();
//        for (int i = 0; i < productList.size(); i++) {
//            if(productList.get(i).getId().equals(id)){
//                BaseRepository.entityManager.remove();
//                break;
//            }
//        }
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        Product product = BaseRepository.entityManager.find(Product.class,id);
        BaseRepository.entityManager.remove(product);
        transaction.commit();
    }

    @Override
    public List<Product> findByName(String name) {
        String names = name.trim();
        TypedQuery<Product> productList =
                BaseRepository.entityManager.createQuery("SELECT p FROM Product AS p WHERE p.name LIKE :name", Product.class);
        productList.setParameter("name", "%" + names + "%");
//        List<Product> productLists = new ArrayList<>();
//        for (Product p : productList) {
//            if (p.getName().equals(name)) {
//                productLists.add(p);
//            }
//        }
        return productList.getResultList();
    }
}
