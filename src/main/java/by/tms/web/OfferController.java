package by.tms.web;

import by.tms.dto.OfferDto;
import by.tms.entity.*;
import by.tms.service.AbstractProductService;
import by.tms.service.CategoryService;
import by.tms.service.OfferService;
import by.tms.service.mapper.OfferMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;
    private final AbstractProductService abstractProductService;
    private final OfferMapper offerMapper;
    private final CategoryService categoryservice;

    public OfferController(OfferService offerService, AbstractProductService abstractProductService, OfferMapper offerMapper, CategoryService categoryService) {
        this.offerService = offerService;
        this.abstractProductService = abstractProductService;
        this.offerMapper = offerMapper;
        this.categoryservice = categoryService;
    }

    @GetMapping("/selectProductCategory")
    public String selectProductCategory(@ModelAttribute("newCategory") Category category /*@RequestParam(value = "category", required = false) String category, HttpSession httpSession, Model model*/) {
//        model.addAttribute("category", category);
//        System.out.println(category);
        return "offer/selectProductCategory";
    }


    @PostMapping("/selectProductCategory")
    public String selectProductCategory(/*@Valid*/ @ModelAttribute("newCategory") Category category, BindingResult bindingResult, /*@RequestParam(value = "category", required = false) String category, @Valid @ModelAttribute("newAbstractProduct") AbstractProduct abstractProduct, BindingResult bindingResult,*/ @ModelAttribute("newCategory") Category categoryNew, String product, Model model, HttpSession httpSession) {
//        if (bindingResult.hasErrors()) {
//            return "offer/selectProductCategory";
//        }
        category.setNameCategory("Car");
        Optional<Category> categoryByName = categoryservice.findCategoryByName(category);
        Optional<Category> categoryById = categoryservice.findCategoryById(category.getId());
        if (categoryByName.isPresent()) {

            model.addAttribute("product", product);
            model.addAttribute("category", category);

            httpSession.setAttribute("categoryHttp1Variable", category);
            httpSession.setAttribute("categoryNewHttp2Object", categoryNew);
            return "offer/categoryIsExist";
        } else {
            categoryservice.save(category);
//        System.out.println(model.getAttribute(product));
//        System.out.println(product);
//        httpSession.setAttribute("product", product);
//        System.out.println(httpSession.getAttribute("product"));
            //User currentUser = (User) httpSession.getAttribute("currentUser");
//        currentUser.setProductList(product);
//        Seller newSeller =
//        List<AbstractProduct> productList = abstractProductService.getAbstractProductList(productCategory);
//        model.addAttribute("productList", productList);
            return "offer/saveCategory";
                    //abstractProductService.getPageNameForProduct("newCategory");//abstractProductService.getPageNameForProduct(productCategory);
        }
    }


//    @GetMapping("/selectProductCategory")
//    public String selectProductCategory(@RequestParam(value = "product", required = false) String product, Model model) {
//        model.addAttribute("product", product);
//        System.out.println(product);
//        return "addOfferUser/selectProductCategory";
//    }

//    @PostMapping("/selectProductCategory")
//    public String selectProductCategory(@RequestParam(value = "product", required = false) String product,/*@ModelAttribute("newSeller") Seller seller, BindingResult bindingResult,*/ String productCategory, Model model, HttpSession httpSession) {
//       /* if (bindingResult.hasErrors()){
//            return "addOfferUser/selectProductCategory";
//        }*/
//        model.addAttribute("product", product);
//
////        System.out.println(model.getAttribute(product));
////        System.out.println(product);
////        httpSession.setAttribute("product", product);
////        System.out.println(httpSession.getAttribute("product"));
//        //User currentUser = (User) httpSession.getAttribute("currentUser");
////        currentUser.setProductList(product);
////        Seller newSeller =
////        List<AbstractProduct> productList = abstractProductService.getAbstractProductList(productCategory);
////        model.addAttribute("productList", productList);
//        return "addOfferUser/completedOffer";//abstractProductService.getPageNameForProduct(productCategory);
//    }


    @GetMapping("/addCar")
    public String addCar(@ModelAttribute("newCar") Car car) {
        //System.out.println(httpSession.getAttribute("product"));

        return "offer/addCar";
    }

    @PostMapping("/addCar")
    public String addCar(@Valid @ModelAttribute("newCar") Car car, BindingResult bindingResult, HttpSession httpSession, Model model) {
        if (bindingResult.hasErrors()) {
            return "/offer/addCar";
        }
        Optional<AbstractProduct> isExist = abstractProductService.findProductByName(car.getNameProduct());
        if (isExist.isEmpty()) {
//            Category categoryCar = (Category) model.getAttribute("category");
            Category categoryCar = (Category) httpSession.getAttribute("categoryNewHttp2Object");
            car.setCategory(categoryCar);

            AbstractProduct newCar = abstractProductService.save(car);
            User addCurrentUser = (User) httpSession.getAttribute("currentUser");
            //Seller seller =
            Offer offer = offerService.createOfferWithUserAndVehicleCategory(addCurrentUser, newCar);

            httpSession.setAttribute("offer", offer);
//            System.out.println(car);
//            System.out.println(offer);

            return "offer/completedOffer";
//            return "redirect:/user/personalAccount";
        }

        model.addAttribute("message", "Car is already exists");
        return "/offer/addCar";
//        return "redirect:/user/personalAccount";
    }



    @PostMapping("/createOffer")
    public String createOffer(@Valid @ModelAttribute("OfferDTO") OfferDto offerDTO, BindingResult bindingResult, HttpSession httpSession, Model model) {
        if (bindingResult.hasErrors()) {
            return "offer/createOffer";
        }
        Offer offer = (Offer) httpSession.getAttribute("offer");
        offer.setUser((User) httpSession.getAttribute("currentUser"));
        offer = offerMapper.convertOfferDTOtoOffer(offerDTO, offer);
        offerService.save(offer);
        httpSession.removeAttribute("offer");
        return "user/personalAccount";
    }


    @GetMapping("offerListOfSeller")
    public String offerListOfSeller(HttpSession httpSession, Model model) {

        List<Offer> listOfOffers = offerService.getOfferList();
        if (listOfOffers.isEmpty()) {
            model.addAttribute("message", "Offer list is empty");
            return "offer/offerListOfSeller";
        }
        model.addAttribute("listOfOffers", listOfOffers);
        httpSession.setAttribute("listOfOffers", listOfOffers);

        return "offer/offerListOfSeller";
    }
}
