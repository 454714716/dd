package cn.itcast.ssm.service.imple;

import cn.itcast.ssm.Entity.CompanyApp;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyAppDaoImpl    extends  BaseDAOImpl<CompanyApp> implements ICompanyAppDao {


    @Override
    public List<CompanyApp> getALL(Integer status) {
     Query<CompanyApp> query = dsForRW.createQuery(CompanyApp.class);
        System.out.println("===========");
        if( status!=null  ){
            List<Integer> list = new ArrayList<>();
            list.add(status);
            //   query.filter("status >", status);
              query.field("status").equal(status);

        }
        ArrayList<CompanyApp> list = (ArrayList<CompanyApp>) query.asList();
/*System.out.print(dsForRW.createQuery(CompanyApp.class)
        .filter("appId","1002").get()+"-----find--------------");*/
if (list!=null){
   /* if (list.size()>10){
        list = (ArrayList<CompanyApp>) list.subList(0,10);
    }*/
}
System.out.println(list);
        return list;
    }
}
