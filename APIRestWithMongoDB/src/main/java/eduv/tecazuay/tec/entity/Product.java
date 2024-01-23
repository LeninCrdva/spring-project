package eduv.tecazuay.tec.entity;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
@Document(collection = "products")
public class Product {
	@Id
	private String _id;
	private String productName;
	private Double price;
	private LocalDate expiryDate;
}
