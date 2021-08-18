package ra.code.restfulapi5.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.code.restfulapi5.model.Product;
import ra.code.restfulapi5.model.ProductType;
import ra.code.restfulapi5.service.product.IProductService;
import ra.code.restfulapi5.service.producttype.IProductTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/18
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductTypeService productTypeService;

    /**
     * Get List Product
     * @return List ProductResponseDto
     */
    @GetMapping
    public ResponseEntity<Iterable<ProductResponseDto>> getAllProduct() {
        // Get list product
        List<Product> productList = new ArrayList<>();
        productService.findAll().forEach(productList::add);

        // Map entity to response dto
        List<ProductResponseDto> result = new ArrayList<>();
        productList.forEach(product -> {
            result.add(ProductConversion.convertProductToProductResponseDto(product));
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get Product by Id
     * @param id
     * @return ProductResponseDto
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        // Find product by id
        Optional<Product> productOptional = productService.findById(id);

        // Map entity to response dto
        return productOptional
                .map(product -> new ResponseEntity<>(
                        ProductConversion.convertProductToProductResponseDto(product),
                        HttpStatus.OK
                ))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Create new Product
     * @param productRequestDto
     * @return ProductResponseDto
     */
    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        // Find product type by id
        Optional<ProductType> productTypeOptional = productTypeService.findById(productRequestDto.getProductTypeId());

        return productTypeOptional
                .map(productType -> {
                    return new ResponseEntity<>(
                            // Map entity to response dto
                            ProductConversion.convertProductToProductResponseDto(
                                    // save
                                    productService.save(
                                            // Map request dto to entity
                                            convertProductRequestToProduct(productRequestDto, productType)
                                    )
                            ),
                            HttpStatus.OK
                    );
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update Product by Id
     * @param id
     * @param productRequestDto
     * @return ProductResponseDto
     */
    @PostMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id,
                                                            @RequestBody ProductRequestDto productRequestDto) {
        // Find product by id
        Optional<Product> productOptional = productService.findById(id);

        // Find product type by id in product request
        ProductType productType = productTypeService.findById(productRequestDto.getProductTypeId()).get();

        // Map request dto to entity
        Product product = convertProductRequestToProduct(productRequestDto, productType);

        return productOptional
                .map(product1 -> {
                    product.setProductId(product1.getProductId());
                    product.setCreatedAt(product1.getCreatedAt());
                    return new ResponseEntity<>(
                            ProductConversion.convertProductToProductResponseDto(productService.save(product)),
                            HttpStatus.OK
                    );
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete product by id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteProductResponseDto> deleteProductById(@PathVariable Long id) {
        // Find product by id
        Optional<Product> productOptional = productService.findById(id);

        // Delete
        DeleteProductResponseDto result = new DeleteProductResponseDto(true);
        return productOptional
                .map(product -> {
                    productService.remove(id);
                    return new ResponseEntity<>(result, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Convert ProductRequestDto to Product
     * @param productRequestDto
     * @return
     */
    private Product convertProductRequestToProduct(ProductRequestDto productRequestDto, ProductType productType) {
        Product product = new Product();
        product.setProductCode(productRequestDto.getProductCode());
        product.setProductName(productRequestDto.getProductName());
        product.setProductDetail(productRequestDto.getProductDetail());
        product.setProductDescription(productRequestDto.getProductDescription());
        product.setProductTypeId(productType);
        return product;
    }
}
