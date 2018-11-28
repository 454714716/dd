package cn.itcast.ssm.base.dao.imp.base;


import java.util.List;
import java.util.Map;

public interface IBaseDAO<T> {

    public T save(T obj);

    public T insert(T obj);

    public String insertReturnId(T obj);

    public T update(final Class<T> clazz, String id, Map<String, Object> updateFieldMap);

    public T get(final Class<T> clazz, String condition, Object value);

    public T getByPK(final Class<T> clazz, String pk);

    public void delete(final Class<T> clazz, List<String> pks);

    public void delete(final Class<T> clazz, String pk);

    void insertList(List<T> list);

    List<T> getAllList(Class<T> clazz);

}
