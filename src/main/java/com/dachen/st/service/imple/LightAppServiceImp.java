package com.dachen.st.service.imple;

import com.dachen.st.Entity.CompanyApp;
import com.dachen.st.service.ILightAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class LightAppServiceImp implements ILightAppService {
    @Autowired
    ICompanyAppDao dao;
    @Autowired
    RemoteCallService remoteCallService;
    @Override
    public List<CompanyApp> appCenter(Integer param) {
        remoteCallService.queryUserBalance("59a94ea60cf214cca9c4ae49","27972");
        return dao.getALL(param);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
