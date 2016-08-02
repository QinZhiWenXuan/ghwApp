package xuan.wen.qin.ghw.service.test;

import java.util.List;
import java.util.Map;

import xuan.wen.qin.ghw.core.service.BasiceService;
import xuan.wen.qin.ghw.model.entity.dto.Test;
import xuan.wen.qin.ghw.model.entity.form.test.TestEdit;
import xuan.wen.qin.ghw.model.entity.form.test.TestSave;

/**
 * TestService
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月5日 下午10:14:54
 * @version 1.0
 */
public interface TestService extends BasiceService {

	/***
	 * 获取所有的数据
	 * 
	 * @return 数据集合
	 */
	List<Map<String, Object>> query();

	/***
	 * 保存
	 * 
	 * @param form
	 *            保存参数
	 * @return true : 成功 | false :失败
	 */
	boolean save(TestSave form);

	/***
	 * 删除
	 * 
	 * @param id
	 *            主键ID
	 * @return true : 成功 | false :失败
	 */
	boolean delete(int id);

	/***
	 * 根据主键获取数据
	 * 
	 * @param id
	 *            主键ID
	 * @return 结果
	 */
	Test queryById(int id);

	/***
	 * 编辑
	 * 
	 * @param form
	 *            编辑参数
	 * @return true : 成功 | false :失败
	 */
	boolean edit(TestEdit form);

}
