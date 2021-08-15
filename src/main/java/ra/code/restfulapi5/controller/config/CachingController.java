package ra.code.restfulapi5.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author trunganhvu
 * 2021/08/14
 */
@RestController
@RequestMapping("/api/v1/caches")
public class CachingController {
    @Autowired
    private CacheManager cacheManager;

    /**
     * Clear all data in cache
     * @return CachingResponseDto
     */
    @DeleteMapping
    public ResponseEntity<CachingResponseDto> clearAllCaches() {
        CachingResponseDto result = new CachingResponseDto(true);
        try {
            cacheManager
                    .getCacheNames()
                    .stream()
                    .forEach(cacheName -> {
                        System.out.println(cacheManager.getCache(cacheName));
                    });
        } catch (Exception ex) {
            result.setSuccess(false);
        }
        return new ResponseEntity<>(result, HttpStatus.OK) ;
    }
}
