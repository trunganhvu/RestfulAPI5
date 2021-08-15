package ra.code.restfulapi5.service.header;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.model.Header;
import ra.code.restfulapi5.repository.IHeaderRepository;

import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@Service
public class HeaderService implements IHeaderService{

    @Autowired
    private IHeaderRepository headerRepository;

    /**
     * Get all header
     * @return
     */
    @Cacheable(value = "headers", key = "'CACHE_KEY_HEADERS'", sync = true)
    @Override
    public Iterable<Header> findAll() {
        return headerRepository.findAll();
    }

    /**
     * Get header by id
     * @param id
     * @return
     */
    @Cacheable(value = "header", key = "#id", sync = true)
    @Override
    public Optional<Header> findById(Long id) {
        return headerRepository.findById(id);
    }

    /**
     * Have object header
     * @param header
     * @return Header
     */
    @Caching(
        evict = {
            @CacheEvict(value = "headers", key = "'CACHE_KEY_HEADERS'",  beforeInvocation = true)
        },
        put = {
            @CachePut(value = "header", key = "#header.id")
        }
    )
    @Override
    public Header save(Header header) {
        if (header.getId() == null) {
            header.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            header.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return headerRepository.save(header);
    }

    /**
     * Delete header by id
     * @param id
     */
    @Caching(evict = {
        @CacheEvict(value = "headers", key = "'CACHE_KEY_HEADERS'", beforeInvocation = true),
        @CacheEvict(value = "header", key = "#id", beforeInvocation = true)
    })
    @Override
    public void remove(Long id) {
        headerRepository.deleteById(id);
    }
}
