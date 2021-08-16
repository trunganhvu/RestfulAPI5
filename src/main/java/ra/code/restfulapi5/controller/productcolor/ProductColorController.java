package ra.code.restfulapi5.controller.productcolor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.code.restfulapi5.model.ProductColor;
import ra.code.restfulapi5.service.productcolor.IProductColorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/16
 */
@RestController
@RequestMapping("/api/v1/productcolors")
public class ProductColorController {

    @Autowired
    private IProductColorService productColorService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Get all ProductColor
     * @return List ProductColor
     */
    @GetMapping
    public ResponseEntity<Iterable<ProductColorResponseDto>> getALlProductColor() {
        // Get all ProductColor
        List<ProductColor> productColorList = new ArrayList<>();
        productColorService.findAll().forEach(productColorList::add);

        // Map entity to response dto
        List<ProductColorResponseDto> result = new ArrayList<>();
        productColorList.forEach(productColor -> {
            result.add(convertProductColorToProductColorResponseDto(productColor));
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Find product color by id
     * @param id
     * @return ProductColorResponseDto
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductColorResponseDto> getProductColorById(@PathVariable Long id) {
        // Find product color by id
        Optional<ProductColor> productColorOptional = productColorService.findById(id);

        // Map entity to response dto
        return productColorOptional
                .map(productColor -> {
                    return new ResponseEntity<>(convertProductColorToProductColorResponseDto(productColor), HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Create new product color
     * @param productColorRequestDto
     * @return ProductColorResponseDto
     */
    @PostMapping
    public ResponseEntity<ProductColorResponseDto> createProductColor(@RequestBody ProductColorRequestDto productColorRequestDto) {
        // Map request dto to entity
        ProductColor productColor = convertProductColorRequestToProductColor(productColorRequestDto);

        // Save()
        return new ResponseEntity<>(
                convertProductColorToProductColorResponseDto(productColorService.save(productColor)),
                HttpStatus.OK
        );
    }

    /**
     * Update product color by id
     * @param id
     * @param productColorRequestDto
     * @return ProductColorResponseDto
     */
    @PostMapping("/{id}")
    public ResponseEntity<ProductColorResponseDto> updateProductColor(@PathVariable Long id,
                                                                      @RequestBody ProductColorRequestDto productColorRequestDto) {
        // Find color by id
        Optional<ProductColor> productColorOptional = productColorService.findById(id);

        // Map request dto to entity
        ProductColor productColor = convertProductColorRequestToProductColor(productColorRequestDto);

        // Save
        return productColorOptional
                .map(productColor1 -> {
                    productColor.setProductColorId(productColor1.getProductColorId());
                    productColor.setCreatedAt(productColor1.getCreatedAt());
                    return new ResponseEntity<>(
                            convertProductColorToProductColorResponseDto(productColorService.save(productColor)),
                            HttpStatus.OK
                    );
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete product color by id
     * @param id
     * @return DeleteProductColorResponseDto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteProductColorResponseDto> deleteProductColorById(@PathVariable Long id) {
        // Find color by id
        Optional<ProductColor> productColorOptional = productColorService.findById(id);

        // Remove
        DeleteProductColorResponseDto result = new DeleteProductColorResponseDto(true);
        return productColorOptional
                .map(productColor -> {
                    productColorService.remove(id);
                    return new ResponseEntity<>(result, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Convert ProductColor To ProductColorResponseDto
     * @param productColor
     * @return ProductColorResponseDto
     */
    private ProductColorResponseDto convertProductColorToProductColorResponseDto(ProductColor productColor) {
        return modelMapper.map(productColor, ProductColorResponseDto.class);
    }

    /**
     * Convert ProductColorRequestDto to ProductColor
     * @param productColorRequestDto
     * @return ProductColor
     */
    private ProductColor convertProductColorRequestToProductColor(ProductColorRequestDto productColorRequestDto) {
        return modelMapper.map(productColorRequestDto, ProductColor.class);
    }
}
