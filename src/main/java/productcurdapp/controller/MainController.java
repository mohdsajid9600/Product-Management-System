package productcurdapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcurdapp.dao.ProductDao;
import productcurdapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = productDao.getProducts();
		System.out.println(products + "home page");
		m.addAttribute("products", products);
		return "index";
	}

	@RequestMapping("/addproduct")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	@RequestMapping(value = "/handleform", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest req) {
		RedirectView redirectView = new RedirectView();
		System.out.println(product);
		this.productDao.createProduct(product);
		redirectView.setUrl(req.getContextPath() + "/");
//		redirectView.setUrl("home");
		return redirectView;
	}

	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProductHandler(@PathVariable("productId") int productId, HttpServletRequest req) {
		
		this.productDao.deleteProduct(productId);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath() + "/");
		return redirectView;
	}
	
	@RequestMapping("/getProduct/{productId}")
	public String getProductHandler(@PathVariable("productId") int productId, Model m) {
		
		Product product = this.productDao.getProduct(productId);
		m.addAttribute("Product", product);
		m.addAttribute("title", "Update Product");
		return "update_form";
	}
	
	@RequestMapping(value = "updatehandleform" , method = RequestMethod.POST)
	public RedirectView updateProductHandler(@ModelAttribute Product product , HttpServletRequest req) {
		
		this.productDao.updateProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath() + "/");
		return redirectView;
	}
}
