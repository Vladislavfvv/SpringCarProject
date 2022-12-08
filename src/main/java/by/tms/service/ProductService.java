package by.tms.service;

import by.tms.entity.AbstractProduct;
import by.tms.entity.User;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    @Qualifier("hibernateProductDao")
    private Storage<AbstractProduct, Long> productService;



    public AbstractProduct save(AbstractProduct abstractProduct){
        productService.save(abstractProduct);
        return abstractProduct;
    }

    public Optional<AbstractProduct> findProductByName(String productName){
        return productService.findEntity(productName);
    }

    public AbstractProduct delete(AbstractProduct abstractProduct){
        productService.delete(abstractProduct);
        return abstractProduct;
    }

    public List<AbstractProduct> getUserList(){
        return productService.getListOfEntity();
    }
}
