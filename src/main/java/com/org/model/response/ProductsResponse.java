package com.org.model.response;

import com.org.model.Products;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ProductsResponse {

    private List<Products> data;
}
