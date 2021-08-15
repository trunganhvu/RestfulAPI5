package ra.code.restfulapi5.controller.delivery;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.code.restfulapi5.model.Delivery;
import ra.code.restfulapi5.service.delivery.IDeliveryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@RestController
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {
    @Autowired
    private IDeliveryService deliveryService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Get all delivery
     * @return List DeliveryResponseDto
     */
    @GetMapping
    public ResponseEntity<Iterable<DeliveryResponseDto>> getAllDelivery() {
        // Get list delivery
        List<Delivery> deliveryList = new ArrayList<>();
        deliveryService.findAll().forEach(deliveryList::add);

        List<DeliveryResponseDto> result = new ArrayList<>();
        deliveryList.forEach(delivery -> {
            result.add(convertDeliveryToDeliveryResponseDto(delivery));
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get delivery by id
     * @param id
     * @return DeliveryResponseDto
     */
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryResponseDto> getDeliveryById(@PathVariable Long id) {
        Optional<Delivery> deliveryOptional = deliveryService.findById(id);

        return deliveryOptional
                .map(delivery -> new ResponseEntity<>(convertDeliveryToDeliveryResponseDto(delivery), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Get list delivery using
     * @return List delivery
     */
    @GetMapping("/using")
    public ResponseEntity<List<DeliveryResponseDto>> getDeliveryUsing() {
        List<Delivery> deliveryList = deliveryService.getAllDeliveryUsing();

        List<DeliveryResponseDto> result = new ArrayList<>();
        deliveryList.forEach(delivery -> {
            result.add(convertDeliveryToDeliveryResponseDto(delivery));
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Create new delivery
     * @param deliveryRequestDto
     * @return DeliveryResponseDto
     */
    @PostMapping
    public ResponseEntity<DeliveryResponseDto> createDelivery(@RequestBody DeliveryRequestDto deliveryRequestDto) {
        // Map dto to entity
        Delivery delivery = convertDeliveryRequestDtoToDelivery(deliveryRequestDto);

        // Save()
        return new ResponseEntity<>(
                convertDeliveryToDeliveryResponseDto(deliveryService.save(delivery)),
                HttpStatus.OK
        );
    }

    /**
     * Update delivery by id
     * @param id
     * @param deliveryRequestDto
     * @return DeliveryResponseDto
     */
    @PostMapping("/{id}")
    public ResponseEntity<DeliveryResponseDto> updateDelivery(@PathVariable Long id,
                                                              @RequestBody DeliveryRequestDto deliveryRequestDto) {
        // Find delivery by id
        Optional<Delivery> deliveryOptional = deliveryService.findById(id);

        // Map request dto to entity
        Delivery delivery = convertDeliveryRequestDtoToDelivery(deliveryRequestDto);

        return deliveryOptional.map(delivery1 -> {
            delivery.setDeliveryId(delivery1.getDeliveryId());
            delivery.setCreatedAt(delivery1.getCreatedAt());
            return new ResponseEntity<>(
                    convertDeliveryToDeliveryResponseDto(deliveryService.save(delivery)),
                    HttpStatus.OK
            );
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete delivery by id
     * @param id
     * @return DeleteDeliveryResponseDto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteDeliveryResponseDto> deleteDelivery(@PathVariable Long id) {
        // Find delivery by id
        Optional<Delivery> deliveryOptional = deliveryService.findById(id);

        //
        DeleteDeliveryResponseDto result = new DeleteDeliveryResponseDto(true);
        return deliveryOptional
                .map(delivery -> {
                    deliveryService.remove(id);
                    return new ResponseEntity<>(result, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Convert Delivery to response dto
     * @param delivery
     * @return DeliveryResponseDto
     */
    private DeliveryResponseDto convertDeliveryToDeliveryResponseDto(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryResponseDto.class);
    }

    /**
     * Convert delivery request dto to delivery entity
     * @param deliveryRequestDto
     * @return Delivery
     */
    private Delivery convertDeliveryRequestDtoToDelivery(DeliveryRequestDto deliveryRequestDto) {
        return modelMapper.map(deliveryRequestDto, Delivery.class);
    }
}
