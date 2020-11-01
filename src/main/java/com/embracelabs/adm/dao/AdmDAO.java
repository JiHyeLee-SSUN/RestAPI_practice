package com.embracelabs.adm.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

public interface AdmDAO {
    Map<String, Object> findPortList(Map<String, Object> param) throws Exception;
}
