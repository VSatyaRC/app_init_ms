package in.appinit.appconfig.repositories;

import in.appinit.appconfig.model.screens.ScreenInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScreenInfoRepository extends MongoRepository<ScreenInfo, String> {
    List<ScreenInfo> findAllByAppId(String appId);

    @Query(fields = "{layout:1, layoutName:1, id:1, rootKey : 1}")
    Optional<ScreenInfo> findById(String id);

    Optional<ScreenInfo> findByIdAndAppId(String id, String appId);

    @Query(fields = "{id:1, screenName:1, pageVariables:1}")
    List<ScreenInfo> findAllByAppIdAndScreenNameIgnoreCaseStartsWith(String appId, String screenName);
}
