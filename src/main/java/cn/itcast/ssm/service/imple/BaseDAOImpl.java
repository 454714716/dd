package cn.itcast.ssm.service.imple;

import cn.itcast.ssm.base.dao.imp.base.IBaseDAO;
import org.bson.types.ObjectId;
import org.mongodb.morphia.AdvancedDatastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * created  by  liaojingwei on 2018/5/7
 */
public class BaseDAOImpl<T>    implements IBaseDAO<T>{

     @Resource(name = "dsForRW")
    protected AdvancedDatastore dsForRW;

    @Override
    public T save(T obj) {

        if (obj == null) {
            return null;
        }
        dsForRW.save(obj);
        return obj;
    }

    @Override
    public T insert(T obj) {

        if (obj == null) {
            return null;
        }

        dsForRW.insert(obj);
        return obj;
    }

    public String insertReturnId(T obj) {
        if (obj == null) {
            return null;
        }
        Key<T> key= dsForRW.insert(obj);
        return key.getId().toString();
    }

    @Override
    public T update(Class<T> clazz, String id, Map<String, Object> updateFieldMap) {

        if (updateFieldMap == null || updateFieldMap.size() == 0) {
            return getByPK(clazz, id);
        }

        Query<T> q = dsForRW.createQuery(clazz).filter("_id", new ObjectId(id));
        UpdateOperations<T> ops = dsForRW.createUpdateOperations(clazz);
        for (Map.Entry<String, Object> eachObj : updateFieldMap.entrySet()) {
            if (eachObj.getValue() != null) {
                ops.set(eachObj.getKey(), eachObj.getValue());
            }
        }
        return dsForRW.findAndModify(q, ops);
    }

    @Override
    public T get(Class<T> clazz, String condition, Object value) {

        Query<T> query = dsForRW.createQuery(clazz).filter(condition, value);
        query.limit(1);
        return query.get();
    }

    @Override
    public T getByPK(Class<T> clazz, String pk) {
        Query<T> query = dsForRW.createQuery(clazz).filter("_id", new ObjectId(pk));
        return query.get();
    }

    @Override
    public void delete(Class<T> clazz, List<String> pks) {

        if (CollectionUtils.isEmpty(pks)) {
            return;
        }

        List<ObjectId> objectIds = new ArrayList<>();
        for (String id : pks) {
            objectIds.add(new ObjectId(id));
        }

        dsForRW.delete(clazz, objectIds);
    }

    @Override
    public void delete(Class<T> clazz, String pk) {

        if (StringUtils.isEmpty(pk)) {
            return;
        }

        dsForRW.delete(clazz, new ObjectId(pk));
    }

    @Override
    public void insertList(List<T> list) {

        if (list != null) {
            dsForRW.insert(list);
        }
    }

    @Override
    public List<T> getAllList(Class<T> clazz) {
        Query<T> query = dsForRW.createQuery(clazz);
        return query.asList();
    }
}
