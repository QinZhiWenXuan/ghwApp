package xuan.wen.qin.ghw.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import xuan.wen.qin.ghw.core.service.BasiceService;
import xuan.wen.qin.ghw.model.repository.test.TestDao;

/**
 * BasiceServiceImpl
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月5日 下午9:16:30
 * @version 1.0
 */
@Service(value = "basiceService")
public abstract class BasiceServiceImpl implements BasiceService {
	@Autowired(required = true)
	@Qualifier(value = "testDao")
	protected TestDao testDao;
}
