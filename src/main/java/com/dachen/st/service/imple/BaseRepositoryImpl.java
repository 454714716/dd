package com.dachen.st.service.imple;

import com.dachen.st.base.dao.imp.BaseRepository;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.io.Serializable;
import java.util.List;

/**
 * @author GengChao
 * @desc
 * @date:2017/10/2711:37 Copyright (c) 2017, DaChen All Rights Reserved.
 */
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleMongoRepository<T, ID>
  implements BaseRepository<T, ID> {

  protected final MongoOperations mongoTemplate;

  protected final MongoEntityInformation<T, ID> entityInformation;

  /**
   * Creates a new {@link SimpleMongoRepository} for the given {@link MongoEntityInformation} and
   * {@link MongoOperations}.
   *
   * @param metadata must not be {@literal null}.
   * @param mongoOperations must not be {@literal null}.
   */
  public BaseRepositoryImpl(
      MongoEntityInformation<T, ID> metadata,
      MongoOperations mongoOperations) {
    super(metadata, mongoOperations);
    this.mongoTemplate=mongoOperations;
    this.entityInformation = metadata;
  }

  @Override
  public long count(Query query){
    return mongoTemplate.count(query,entityInformation.getJavaType());
  }

  @Override
  public List<T> find(Query query){
    return mongoTemplate.find(query,entityInformation.getJavaType());
  }

  @Override
  public T findAndModify(Query query, Update update) {
    return mongoTemplate.findAndModify(query,update,entityInformation.getJavaType());
  }

  @Override
  public T findAndModify(Query query, Update update, FindAndModifyOptions options){
    return mongoTemplate.findAndModify(query,update,options,entityInformation.getJavaType());
  }

  @Override
  public long updateMulti(Query query, Update update) {
    WriteResult writeResult = mongoTemplate.updateMulti(query, update, entityInformation.getJavaType());
    return writeResult.getN();
  }

}
