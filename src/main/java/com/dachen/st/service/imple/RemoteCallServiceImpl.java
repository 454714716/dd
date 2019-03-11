package com.dachen.st.service.imple;

import com.alibaba.fastjson.JSONObject;
import com.dachen.commons.micro.comsume.RibbonManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
public class RemoteCallServiceImpl implements RemoteCallService {
    @Autowired
    private RibbonManager ribbonManager;
    @Override
    public Long queryUserBalance(String companyId, String userId) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("companyId", companyId);
        paramMap.put("userId", userId);

        String result = ribbonManager.post("http://integral//inner_api/user/getBalance", paramMap);
        System.out.println("###queryuserBalance remote call result: {}==="+ result);

        JSONObject body = JSONObject.parseObject(result);
        if (1 == body.getIntValue("resultCode")) {
            JSONObject data = body.getJSONObject("data");
            return data.getLong("balance");
        }
        return 0L;
    }
}
