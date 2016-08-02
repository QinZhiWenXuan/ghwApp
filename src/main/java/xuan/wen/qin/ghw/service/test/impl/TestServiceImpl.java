package xuan.wen.qin.ghw.service.test.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xuan.wen.qin.ghw.core.exception.AppException;
import xuan.wen.qin.ghw.core.service.impl.BasiceServiceImpl;
import xuan.wen.qin.ghw.model.entity.dto.Test;
import xuan.wen.qin.ghw.model.entity.form.test.TestEdit;
import xuan.wen.qin.ghw.model.entity.form.test.TestSave;
import xuan.wen.qin.ghw.service.test.TestService;

/**
 * TestServiceImpl
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月5日 下午10:15:13
 * @version 1.0
 */
@Service(value = "testService")
@Transactional(readOnly = true, rollbackFor = AppException.class)
public class TestServiceImpl extends BasiceServiceImpl implements TestService {
	/***
	 * 获取所有的数据
	 * 
	 * @return 数据集合
	 */
	@Override
	public List<Map<String, Object>> query() {
		return testDao.queryForMap();
	}

	/***
	 * 保存
	 * 
	 * @param form
	 *            保存参数
	 * @return true : 成功 | false :失败
	 */
	@Transactional(readOnly = false)
	@Override
	public boolean save(TestSave form) {
		testDao.save(form);
		return (null != form && form.getId() > 0);
	}

	/***
	 * 删除
	 * 
	 * @param id
	 *            主键ID
	 * @return true : 成功 | false :失败
	 */
	@Override
	@Transactional(readOnly = false)
	public boolean delete(int id) {
		return testDao.delete(id);
	}

	/***
	 * 根据主键获取数据
	 * 
	 * @param id
	 *            主键ID
	 * @return 结果
	 */
	@Override
	public Test queryById(int id) {
		return testDao.queryForDTO(id);
	}

	/***
	 * 编辑
	 * 
	 * @param form
	 *            编辑参数
	 * @return true : 成功 | false :失败
	 */
	@Override
	@Transactional(readOnly = false)
	public boolean edit(TestEdit form) {
		return testDao.edit(form);
	}

}
