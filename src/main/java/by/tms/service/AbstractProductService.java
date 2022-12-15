package by.tms.service;

import by.tms.entity.*;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbstractProductService {
    @Autowired
    @Qualifier("hibernateAbstractProductDao")
    private Storage<AbstractProduct, Long> abstractProductService;


    public AbstractProduct save(AbstractProduct abstractProduct) {
        abstractProductService.save(abstractProduct);
        return abstractProduct;
    }

    public Optional<AbstractProduct> findProductByName(String productName) {
        return abstractProductService.findEntity(productName);
    }

    public Optional<AbstractProduct> findProductById(Long productId) {
        return abstractProductService.findById(productId);
    }

    public AbstractProduct delete(AbstractProduct abstractProduct) {
        abstractProductService.delete(abstractProduct);
        return abstractProduct;
    }

    public List<AbstractProduct> getAbstractProductList(String productCategory) {
        if (abstractProductService.getListOfEntity().isEmpty()) {
            fillProductListToTest();
        }
        List<AbstractProduct> productList = null;
        switch (productCategory) {
            case ("bus"): {
                productList = getBusList();
                break;
            }
            case ("car"): {
                productList = getCarList();
                break;
            }
//            case ("tire"): {
//                productList = getTireList();
//                break;
//            }
//            case ("trailer"): {
//                productList = getTrailerList();
//                break;
//            }
            case ("truck"): {
                productList = getTruckList();
                break;
            }

        }
        return productList;

    }

//    private List<AbstractProduct> getTrailerList() {
//        List<AbstractProduct> listOfEntity = abstractProductService.getListOfEntity();
//        List<AbstractProduct> abstractProductList = null;
//        for (AbstractProduct abstractProduct : listOfEntity) {
//            if (abstractProduct instanceof Trailer) {
//                abstractProductList.add(abstractProduct);
//            }
//        }
//        return abstractProductList;
//    }

//    private List<AbstractProduct> getTireList() {
//        List<AbstractProduct> listOfEntity = abstractProductService.getListOfEntity();
//        List<AbstractProduct> abstractProductList = null;
//        for (AbstractProduct abstractProduct : listOfEntity) {
//            if (abstractProduct instanceof Tire) {
//                abstractProductList.add(abstractProduct);
//            }
//        }
//        return abstractProductList;
//    }

    private List<AbstractProduct> getBusList() {
        List<AbstractProduct> listOfEntity = abstractProductService.getListOfEntity();
        List<AbstractProduct> abstractProductList = null;
        for (AbstractProduct abstractProduct : listOfEntity) {
            if (abstractProduct instanceof Bus) {
                abstractProductList.add(abstractProduct);
            }
        }
        return abstractProductList;
    }

    private List<AbstractProduct> getTruckList() {
        List<AbstractProduct> listOfEntity = abstractProductService.getListOfEntity();
        List<AbstractProduct> abstractProductList = null;
        for (AbstractProduct abstractProduct : listOfEntity) {
            if (abstractProduct instanceof Truck) {
                abstractProductList.add(abstractProduct);
            }
        }
        return abstractProductList;
    }


    private List<AbstractProduct> getCarList() {
        List<AbstractProduct> listOfEntity = abstractProductService.getListOfEntity();
        return listOfEntity.stream().filter(abstractProduct -> abstractProduct instanceof Car).toList();
    }

    private void fillProductListToTest() {
        save(new Car("https://klike.net/uploads/posts/2019-05/1559021799_1.jpg", "Chevrolet", "yellow", "Lada", "2010", 2));
        save(new Car("https://bipbap.ru/wp-content/uploads/2017/09/92830063_0031-2.jpg", "Peugeot", "violet", "MustafaInc", "2015", 2));
        save(new Car("https://klike.net/uploads/posts/2019-06/1560838551_1.jpg", "Bugatti", "yellow", "AmarettoInc", "2017", 2));
        save(new Car("https://kartinkin.net/uploads/posts/2022-03/1648047156_3-kartinkin-net-p-krasivie-kartinki-avto-4.jpg", "Leksah", "blue", "Ford", "2016", 4));
        save(new Car("https://klike.net/uploads/posts/2021-12/1638432889_2.jpg", "Maserati", "orange", "Noname", "2010", 2));
    }

    public String getPageNameForProduct(String productCategory){
        return "offer/add" + productCategory;
    }

    public AbstractProduct createAbstractProductWithProductAndCategoryVehicle(Category category, AbstractProduct abstractProduct){
        AbstractProduct abstractProductNew = new AbstractProduct();
        abstractProductNew.setCategory(category);
        return abstractProductNew;
    }

}
