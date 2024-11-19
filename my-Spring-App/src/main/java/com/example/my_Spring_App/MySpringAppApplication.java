package com.example.my_Spring_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.my_Spring_App.product.Product;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class MySpringAppApplication {

	public static void main(String[] args) {
		Product obj=new Product();
		obj.getName();

		SpringApplication.run(MySpringAppApplication.class, args);
	}





}
