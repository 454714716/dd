package cn.itcast.ssm.service.imple;

import cn.itcast.ssm.Entity.CompanyApp;
import cn.itcast.ssm.service.ILightAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LightAppServiceImp implements ILightAppService {
    @Autowired
    ICompanyAppDao dao;
    @Override
    public List<CompanyApp> appCenter(Integer param) {
        return dao.getALL(param);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
