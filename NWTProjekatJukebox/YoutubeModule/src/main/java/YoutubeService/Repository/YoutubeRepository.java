package YoutubeService.Repository;

import YoutubeService.Models.PjesmaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fare_ on 21.03.2017..
 */
public interface YoutubeRepository extends CrudRepository<PjesmaEntity, Integer> {
    @Override
    Iterable<PjesmaEntity> findAll();

    @Override
    void delete(Integer integer);

    @Override
    PjesmaEntity findOne(Integer integer);

    Page<PjesmaEntity> findAll(Pageable iterable);

    @Override
    long count();

    @Override
    void delete(PjesmaEntity userEntity);

    @Override
    void delete(Iterable<? extends PjesmaEntity> iterable);

    @Override
    void deleteAll();

    @Override
    <S extends PjesmaEntity> Iterable<S> save(Iterable<S> iterable);

    @Override
    <S extends PjesmaEntity> S save(S s);

    @Override
    boolean exists(Integer integer);
    @Query("select f from PjesmaEntity f where f.id=?1")
    List<PjesmaEntity> findAllById(Integer userId);
    @Modifying
    @Transactional
    @Query("Update PjesmaEntity p set p.urlPlesme=?2 where p.id=?1")
    void updateURL( String url);
}
