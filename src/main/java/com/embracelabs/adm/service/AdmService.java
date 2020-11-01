package com.embracelabs.adm.service;

import com.embracelabs.adm.dao.AdmDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AdmService {
    @Autowired
    AdmDAO admDAO;

    public Map<String, Object> findPortList(Map<String,Object> param) throws Exception {
        return admDAO.findPortList(param);
    }
}
