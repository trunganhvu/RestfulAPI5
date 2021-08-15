package ra.code.restfulapi5.service;

import org.springframework.cache.annotation.Cacheable;

import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/13
 */
public interface IGeneralService<T> {

    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
