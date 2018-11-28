package cn.itcast.ssm.base.dao.imp;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author GengChao
 * @desc
 * @date:2017/10/2711:31 Copyright (c) 2017, DaChen All Rights Reserved.
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends MongoRepository<T, ID> {

  long count(Query query);

  List<T> find(Query query);

  T findAndModify(Query query, Update update);

  T findAndModify(Query query, Update update, FindAndModifyOptions options);

  long updateMulti(Query query, Update update);

  default long updateMulti(Query query, Map<String, Object> update){
    Update u = new Update();
    for (Map.Entry<String, Object> eachObj : update.entrySet()) {
      if (eachObj.getValue() != null) {
        u.set(eachObj.getKey(), eachObj.getValue());
      }
    }
    return updateMulti(query,update);
  }

}
