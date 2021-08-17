package ra.code.restfulapi5.controller.productsize;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.code.restfulapi5.model.ProductSize;
import ra.code.restfulapi5.model.ProductType;
import ra.code.restfulapi5.service.productsize.IProductSizeService;
import ra.code.restfulapi5.service.producttype.IProductTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/16
 */
@RestController
@RequestMapping("/api/v1/productsizes")
public class ProductSizeController {

    @Autowired
    private IProductSizeService productSizeService;

    @Autowired
    private IProductTypeService productTypeService;

//    @Autowired
//    private ModelMapper modelMapper;

    /**
     * Get all product size
     * @return List ProductSizeResponseDto
     */
    @GetMapping
    public ResponseEntity<Iterable<ProductSizeResponseDto>> getAllProductSize() {
        // Find all product size
        List<ProductSize> productSizeList = new ArrayList<>();
        productSizeService.findAll().forEach(productSizeList::add);

        // Map entity to response dto
        List<ProductSizeResponseDto> result = new ArrayList<>();
        productSizeList.forEach(productSize -> {
            result.add(ProductSizeConversion.convertProductSizeToProductSizeResponseDto(productSize));
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get product size by id
     * @param id
     * @return ProductSizeResponseDto
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductSizeResponseDto> getProductSizeById(@PathVariable Long id) {
        // Find product size by id
        Optional<ProductSize> productSizeOptional = productSizeService.findById(id);

        return productSizeOptional
                .map(productSize -> new ResponseEntity<>(
                        ProductSizeConversion.convertProductSizeToProductSizeResponseDto(productSize),
                        HttpStatus.OK
                ))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Create new product size
     * @param productSizeRequestDto
     * @return ProductSizeResponseDto
     */
    @PostMapping
    public ResponseEntity<ProductSizeResponseDto> createProductSize(@RequestBody ProductSizeRequestDto productSizeRequestDto) {
        // Find product type by id
        Optional<ProductType> productTypeOptional = productTypeService.findById(
                productSizeRequestDto.getProductTypeId()
        );

        return productTypeOptional
                .map(productType -> {
                    return new ResponseEntity<>(
                            // Map entity to response dto
                            ProductSizeConversion.convertProductSizeToProductSizeResponseDto(
                                    // Save
                                    productSizeService.save(
                                            // Map request dto to entity
                                            convertProductSizeRequestToProductSize(productSizeRequestDto, productType)
                                    )
                            ),
                            HttpStatus.OK
                    );
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update product size by id
     * @param id
     * @param productSizeRequestDto
     * @return ProductSizeResponseDto
     */
    @PostMapping("/{id}")
    public ResponseEntity<ProductSizeResponseDto> updateProductSize(@PathVariable Long id,
                                                                    @RequestBody ProductSizeRequestDto productSizeRequestDto) {
        // Find product size by id
        Optional<ProductSize> productSizeOptional = productSizeService.findById(id);

        // Find product type by id in product size
        ProductType productType = productTypeService.findById(productSizeRequestDto.getProductTypeId()).get();

        // Map request dto to entity
        ProductSize productSize = convertProductSizeRequestToProductSize(productSizeRequestDto, productType);

        // Save
        return productSizeOptional
                .map(productSize1 -> {
                    productSize.setProductSizeId(productSize1.getProductSizeId());
                    productSize.setCreatedAt(productSize1.getCreatedAt());
                    productSize.setProductTypeId(productType);
                    return new ResponseEntity<>(
                            ProductSizeConversion.convertProductSizeToProductSizeResponseDto(productSizeService.save(productSize)),
                            HttpStatus.OK
                    );
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete product size by id
     * @param id
     * @return DeleteProductSizeResponseDto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteProductSizeResponseDto> deleteProductSizeById(@PathVariable Long id) {
        // Find product size by id
        Optional<ProductSize> productSizeOptional = productSizeService.findById(id);

        // Remove
        DeleteProductSizeResponseDto result = new DeleteProductSizeResponseDto(true);
        return productSizeOptional
                .map(productSize -> {
                    productSizeService.remove(id);
                    return new ResponseEntity<>(result, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    /**
     * Convert ProductSizeRequestDto to ProductSize
     * @param productSizeRequestDto
     * @param productType
     * @return ProductSize
     */
    private ProductSize convertProductSizeRequestToProductSize(ProductSizeRequestDto productSizeRequestDto,
                                                               ProductType productType) {
        ProductSize productSize = new ProductSize();
        productSize.setProductSizeCode(productSizeRequestDto.getProductSizeCode());
        productSize.setProductSizeName(productSizeRequestDto.getProductSizeName());
        productSize.setProductTypeId(productType);
        productSize.setProductSizeWidthMin(productSizeRequestDto.getProductSizeWidthMin());
        productSize.setProductSizeWidthMax(productSizeRequestDto.getProductSizeWidthMax());
        productSize.setProductSizeHeightMin(productSizeRequestDto.getProductSizeHeightMin());
        productSize.setProductSizeHeightMax(productSizeRequestDto.getProductSizeHeightMax());
        return productSize;
    }
}
