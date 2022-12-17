package by.tms.web;


import by.tms.dto.OfferDto;
import by.tms.entity.*;
import by.tms.service.*;
import by.tms.service.mapper.OfferMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@MultipartConfig
@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;
    private final CarService carService;
    private final OfferMapper offerMapper;
    private final CategoryService categoryservice;
    private final UserService userService;
    private final FileUploaderService fileUploaderService;


    public OfferController(OfferService offerService, AbstractProductService abstractProductService, CarService carService, OfferMapper offerMapper, CategoryService categoryService, UserService userService, FileUploaderService fileUploaderService) {
        this.offerService = offerService;

        this.carService = carService;
        this.offerMapper = offerMapper;
        this.categoryservice = categoryService;
        this.userService = userService;
        this.fileUploaderService = fileUploaderService;
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

    @GetMapping("/addCarHtml")
    public String addCarHtml() {
        return "offer/addCarHtml";
    }

    @GetMapping("/uploadImage")
    public String uploadImage() {
        return "uploadImage";
    }

//    @PostMapping("doUpload")
//    public String doUpload(@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
//        if (fileUpload != null && fileUpload.length > 0) {
//            for (CommonsMultipartFile aFile : fileUpload) {
//
//                System.out.println("Saving file: " + aFile.getOriginalFilename());
//
//                org.apache.commons.fileupload.FileUpload uploadFile = new org.apache.commons.fileupload.FileUpload();
//                uploadFile.setFileItemFactory(aFile.getOriginalFilename());
//                uploadFile.setData(aFile.getBytes());
//                fileUploadService.save(uploadFile);
//            }
//        }
//        return "offer/success";
//    }


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
    public String addCar2(@Valid @ModelAttribute("newCar") Car car,
                          BindingResult bindingResult,
                          HttpSession httpSession,
                          Model model) {
        if (bindingResult.hasErrors()) {
            return "/offer/addCar";
        }
        User currentUser = (User) httpSession.getAttribute("currentUser");
        Optional<AbstractVehicle> isExist = carService.findVehicleByName(car.getNameProduct());
        if (isExist.isPresent()) {
            Optional<AbstractVehicle> isExistByOwner = carService.findVehicleByOwner(currentUser);
            if (isExistByOwner.isPresent()) {
                model.addAttribute("message", "Such a vehicle with a user already exists");
                return "/offer/addCar";
            }
            model.addAttribute("message", "Car is already exists");
            return "/offer/addCar";
        }
        car.setUser(currentUser);
        carService.save(car);
        return "offer/completedOffer";
    }

    @PostMapping("/addCarWithUploadImage")
    public String addCar2(@RequestParam MultipartFile file,
                          @Valid @ModelAttribute("newCar") Car car,
                          BindingResult bindingResult,
                          HttpSession httpSession,
                          Model model) throws IOException {

        if (bindingResult.hasErrors() && file.isEmpty()) {
            return "/offer/noResults";
        }


        Optional<AbstractVehicle> isExist = carService.findVehicleByName(car.getNameProduct());
        if (isExist.isPresent()) {
            model.addAttribute("message", "Car is already exists");
            return "/offer/noResults";
        }
//
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            model.addAttribute("message", "Name of image is not valid");
            return "/offer/noResults";
        }

        FileUploader upload = new FileUploader();
        upload.setFileName(fileName);
        upload.setData(file.getBytes());
        fileUploaderService.save(upload);


        User addCurrentUser = (User) httpSession.getAttribute("currentUser");
        car.setUser(addCurrentUser);
        car.setFileUpload(upload);

        carService.save(car);


        return "offer/completedOffer";
//            return "redirect:/user/personalAccount";
    }


 /*   @PostMapping("/addCar")
    public String addCar(@Valid @ModelAttribute("newCar") Car car, BindingResult bindingResult, HttpSession httpSession, Model model) {
        if (bindingResult.hasErrors()) {
            return "/offer/addCar";
        }

        Optional<AbstractVehicle> isExist = carService.findVehicleByName(car.getNameProduct());
        //////////Optional<AbstractProduct> isExist = abstractProductService.findProductByName(car.getNameProduct());
        if (isExist.isPresent()) {
            model.addAttribute("message", "Car is already exists");
            return "/offer/addCar";
        }
//            Category categoryCar = (Category) model.getAttribute("category");
//            Category categoryCar = (Category) httpSession.getAttribute("categoryNewHttp2Object");
//            car.setCategory(categoryCar);

        User addCurrentUser = (User) httpSession.getAttribute("currentUser");
        car.setUser(addCurrentUser);
        AbstractVehicle newCar = carService.save(car);
        ///////// AbstractProduct newCar = abstractProductService.save(car);
        //Seller seller =
//            Offer offer = offerService.createOfferWithUserAndVehicleCategory(addCurrentUser, newCar);
//
//            httpSession.setAttribute("offer", offer);
//            System.out.println(car);
//            System.out.println(offer);

        return "offer/completedOffer";
//            return "redirect:/user/personalAccount";
    }


//        return "redirect:/user/personalAccount";
*/

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
        List<AbstractVehicle> carList = carService.getAbstractVehicle();
        //List<Offer> listOfOffers = offerService.getOfferList();
        if (carList.isEmpty()) {
            model.addAttribute("message", "Offer list is empty");
            return "offer/offerListOfSeller";
        }
        model.addAttribute("carList", carList);
        httpSession.setAttribute("carList", carList);

        return "offer/offerListOfSeller";
    }


    @GetMapping(value = "/doUpload")
    public String showUploadForm() {
        return "uploadImage";
    }

    @PostMapping(value = "/doUpload")
    public String handleFileUpload(@RequestParam MultipartFile fileUpload) throws Exception {

        if (fileUpload != null) {
//            byte fileInByte[] = fileUpload.getBytes();
            FileUploader upload = new FileUploader();
            upload.setFileName(fileUpload.getOriginalFilename());
            upload.setData(fileUpload.getBytes());
            fileUploaderService.save(upload);
        }


        return "offer/Success";
    }


}
