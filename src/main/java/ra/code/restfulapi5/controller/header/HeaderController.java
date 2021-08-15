package ra.code.restfulapi5.controller.header;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.code.restfulapi5.model.Header;
import ra.code.restfulapi5.service.header.IHeaderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@RestController
@RequestMapping("/api/v1/headers")
public class HeaderController {
    @Autowired
    private IHeaderService headerService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Get list header
     * @return List header
     */
    @GetMapping
    public ResponseEntity<Iterable<HeaderResponseDto>> getAllHeader() {
        // Get list header
        List<Header> headerList = new ArrayList<>();
        headerService.findAll().forEach(headerList::add);

        // Map header to header response dto
        List<HeaderResponseDto> result = new ArrayList<>();
        headerList.forEach(header -> {
            result.add(convertHeaderToHeaderResponseDto(header));
        });

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get header by id
     * @param id
     * @return header
     */
    @GetMapping("/{id}")
    public ResponseEntity<HeaderResponseDto> getHeaderById(@PathVariable Long id) {
        // Find header by id
        Optional<Header> headerOptional = headerService.findById(id);

        return headerOptional
                .map(header -> new ResponseEntity<>(convertHeaderToHeaderResponseDto(header), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Create new header
     * @param headerRequestDto
     * @return
     */
    @PostMapping
    public ResponseEntity<HeaderResponseDto> createHeader(@RequestBody HeaderRequestDto headerRequestDto) {
        // Map request dto to object
        Header header = convertHeaderRequestDtoToHeader(headerRequestDto);

        // Save()
        return new ResponseEntity<>(
                convertHeaderToHeaderResponseDto(headerService.save(header)),
                HttpStatus.OK);
    }

    /**
     * Update header
     * @param id
     * @param headerRequestDto
     * @return HeaderResponseDto
     */
    @PostMapping("/{id}")
    public ResponseEntity<HeaderResponseDto> updateHeader(@PathVariable Long id,
                                                          @RequestBody HeaderRequestDto headerRequestDto) {
        // Find header in id
        Optional<Header> headerOptional = headerService.findById(id);

        // Map header request dto to header entity
        Header header = convertHeaderRequestDtoToHeader(headerRequestDto);

        return headerOptional.map(header1 -> {
            header.setId(header1.getId());
            header.setCreatedAt(header1.getCreatedAt());

            return new ResponseEntity<>(
                    convertHeaderToHeaderResponseDto(headerService.save(header)),
                    HttpStatus.OK
            );
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete Header by id
     * @param id
     * @return DeleteHeaderResponseDto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteHeaderResponseDto> deleteHeader(@PathVariable Long id) {
        // Get header by id
        Optional<Header> headerOptional = headerService.findById(id);

        DeleteHeaderResponseDto result = new DeleteHeaderResponseDto(true);
        return headerOptional.map(header -> {
            headerService.remove(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Convert Header to response dto
     * @param header
     * @return HeaderResponseDto
     */
    private HeaderResponseDto convertHeaderToHeaderResponseDto(Header header) {
        return modelMapper.map(header, HeaderResponseDto.class);
    }

    /**
     * Convert Header request dto to header entity
     * @param headerRequestDto
     * @return Header
     */
    private Header convertHeaderRequestDtoToHeader(HeaderRequestDto headerRequestDto) {
        return modelMapper.map(headerRequestDto, Header.class);
    }
}
