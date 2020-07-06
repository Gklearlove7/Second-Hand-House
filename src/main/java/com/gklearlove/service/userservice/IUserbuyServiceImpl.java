package com.gklearlove.service.userservice;

import com.gklearlove.dao.paydao.Paydao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: GK
 * @Date: 2020/6/11 14:57
 */
@Service
public class IUserbuyServiceImpl implements IUserbuyService {
    @Autowired
    Paydao paydao;
    @Override
    public int set_buy(String house_id, String need_id) {
        int i = paydao.set_buy(house_id);
        int i1 = paydao.set_need_buy(need_id);
        if (i!=0 && i1!=0){
            return 1;
        }else {
            return 0;
        }
    }
}
