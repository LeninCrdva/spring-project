package eduv.tecazuay.tec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduv.tecazuay.tec.entity.Product;
import eduv.tecazuay.tec.repository.IProductsRepository;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product>{
	@Autowired
	private IProductsRepository productRepository;

	@Override
	public Product save(Product entity) {
		return productRepository.save(entity);
	}

	public Product update(String id, Product product) {
		Product currentProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product Not Found."));

		currentProduct.setProductName(product.getProductName());
		currentProduct.setPrice(product.getPrice());
		currentProduct.setExpiryDate(product.getExpiryDate());

		return productRepository.save(currentProduct);
	};

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
