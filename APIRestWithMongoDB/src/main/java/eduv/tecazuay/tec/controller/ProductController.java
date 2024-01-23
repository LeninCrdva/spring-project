package eduv.tecazuay.tec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eduv.tecazuay.tec.entity.Product;
import eduv.tecazuay.tec.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	@Autowired
	private ProductServiceImpl productServiceImp;
	
	@GetMapping
	ResponseEntity<List<?>> list() {
		return ResponseEntity.ok(productServiceImp.findAll());
	}

	@GetMapping("/{id}")
	ResponseEntity<?> findById(@PathVariable String id) {
		return ResponseEntity.ok(productServiceImp.findById(id));
	}

	@PostMapping("/create")
	ResponseEntity<?> create(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productServiceImp.save(product));
	}

	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Product product) {
		
		Product currentProduct = productServiceImp.findById(id);

		currentProduct.setProductName(product.getProductName());
		currentProduct.setPrice(product.getPrice());
		currentProduct.setExpiryDate(product.getExpiryDate());

		//return productRepository.save(currentProduct);

		return ResponseEntity.status(HttpStatus.OK).body(productServiceImp.save(currentProduct));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		Product currentProduct = productServiceImp.findById(id);
		productServiceImp.delete(currentProduct.get_id());
		return ResponseEntity.noContent().build();
	}
}
