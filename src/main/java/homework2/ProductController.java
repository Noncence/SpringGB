package homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping(path = "/showProductById/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductById(@PathVariable("sid")) int id){
        Product product = productService.getProductByid(id);
        return product;
    }

    @RequestMapping(path = "/showAll")
    public String showAllProducts(Model uiModel) {
        List<Product> products = productService.getAllProducts();
        uiModel.addAttribute("products", products);
        return "product-all";
    }

    @RequestMapping("/showForm")
    public String showSimpleForm(Model uiModel){
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product-form";
    }

    @RequestMapping("/resultForm")
    public String processForm(@ModelAttribute("product") Product product){
        productService.addProduct(product.getTitle(), product.getCoast());
        return "product-form-result";
    }
}
