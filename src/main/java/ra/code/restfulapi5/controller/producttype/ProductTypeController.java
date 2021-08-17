package ra.code.restfulapi5.controller.producttype;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.code.restfulapi5.controller.productsize.ProductSizeConversion;
import ra.code.restfulapi5.controller.productsize.ProductSizeResponseDto;
import ra.code.restfulapi5.model.ProductSize;
import ra.code.restfulapi5.model.ProductType;
import ra.code.restfulapi5.repository.IProductSizeRepository;
import ra.code.restfulapi5.service.producttype.IProductTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@RestController
@RequestMapping("/api/v1/producttypes")
public class ProductTypeController {

    @Autowired
    private IProductTypeService productTypeService;

    @Autowired
    private IProductSizeRepository productSizeRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Get all product type
     * @return List ProductTypeResponseDto
     */
    @GetMapping
    public ResponseEntity<Iterable<ProductTypeResponseDto>> getAllProductType() {
        // Get list product type
        List<ProductType> productTypeList = new ArrayList<>();
        productTypeService.findAll().forEach(productTypeList::add);

        // Map entity to response dto
        List<ProductTypeResponseDto> result = new ArrayList<>();
        productTypeList.forEach(productType -> {
            result.add(convertProductTypeToProductTypeResponseDto(productType));
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get product type by id
     * @param id
     * @return ProductTypeResponseDto
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductTypeResponseDto> getProductTypeById(@PathVariable Long id) {
        // Get product type by id
        Optional<ProductType> productTypeOptional = productTypeService.findById(id);

        return productTypeOptional
                .map(productType -> new ResponseEntity<>(convertProductTypeToProductTypeResponseDto(productType), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Get all product size in product type
     * @param id
     * @return List ProductSizeResponseDto
     */
    @GetMapping("/{id}/productsizes")
    public ResponseEntity<List<ProductSizeResponseDto>> getAllProductSizeInProductType(@PathVariable Long id) {
        // Find all product size by product type id
        List<ProductSize> productSizeList = productSizeRepository.getProductSizeInProductType(id);

        // Map entity to response dto
        List<ProductSizeResponseDto> result = new ArrayList<>();
        productSizeList.forEach(productSize -> {
            result.add(ProductSizeConversion.convertProductSizeToProductSizeResponseDto(productSize));
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Create new product type
     * @param productTypeRequestDto
     * @return ProductTypeResponseDto
     */
    @PostMapping
    public ResponseEntity<ProductTypeResponseDto> createProductType(@RequestBody ProductTypeRequestDto productTypeRequestDto) {
        // Map request dto to entity
        ProductType productType = convertProductTypeRequestDtoToProductType(productTypeRequestDto);

        // save()
        return new ResponseEntity<>(
                convertProductTypeToProductTypeResponseDto(productTypeService.save(productType)),
                HttpStatus.OK
        );
    }

    /**
     * Update product type by id
     * @param id
     * @param productTypeRequestDto
     * @return ProductTypeResponseDto
     */
    @PostMapping("/{id}")
    public ResponseEntity<ProductTypeResponseDto> updateProductType(@PathVariable Long id,
                                                                    @RequestBody ProductTypeRequestDto productTypeRequestDto) {
        // Map request dto to entity
        ProductType productType = convertProductTypeRequestDtoToProductType(productTypeRequestDto);

        // Find product type by id
        Optional<ProductType> productTypeOptional = productTypeService.findById(id);

        // Save product type
        return productTypeOptional
                .map(productType1 -> {
                    productType.setProductTypeId(productType1.getProductTypeId());
                    productType.setCreatedAt(productType1.getCreatedAt());
                    return new ResponseEntity<>(
                            convertProductTypeToProductTypeResponseDto(productTypeService.save(productType)),
                            HttpStatus.OK
                    );
                }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete product type by id
     * @param id
     * @return DeleteProductTypeResponseDto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteProductTypeResponseDto> removeProductType(@PathVariable Long id) {
        // Find product type by id
        Optional<ProductType> productTypeOptional = productTypeService.findById(id);

        // Remove()
        DeleteProductTypeResponseDto result = new DeleteProductTypeResponseDto(true);
        return productTypeOptional
                .map(productType -> {
                    productTypeService.remove(id);
                    return new ResponseEntity<>(result, HttpStatus.OK);
                }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Convert ProductType to ProductTypeResponseDto
     * @param productType
     * @return ProductTypeResponseDto
     */
    private ProductTypeResponseDto convertProductTypeToProductTypeResponseDto(ProductType productType) {
        return modelMapper.map(productType, ProductTypeResponseDto.class);
    }

    /**
     * Convert ProductTypeRequestDto to ProductType
     * @param productTypeRequestDto
     * @return ProductType
     */
    private ProductType convertProductTypeRequestDtoToProductType(ProductTypeRequestDto productTypeRequestDto) {
        return modelMapper.map(productTypeRequestDto, ProductType.class);
    }
}
