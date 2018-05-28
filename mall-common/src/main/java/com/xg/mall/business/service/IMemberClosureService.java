package com.xg.mall.business.service;

import java.util.LinkedList;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-5
 */
public interface IMemberClosureService {

    LinkedList selectDescendant(Integer descendant, Integer distance, Integer page);
      double selectTotal (Integer descendant);
}
