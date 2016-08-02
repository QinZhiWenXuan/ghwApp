package xuan.wen.qin.ghw.model.repository.test;

import java.util.List;
import java.util.Map;

import xuan.wen.qin.ghw.core.repository.BasiceDao;
import xuan.wen.qin.ghw.model.entity.dto.Test;
import xuan.wen.qin.ghw.model.entity.form.test.TestEdit;
import xuan.wen.qin.ghw.model.entity.form.test.TestSave;

/**
 * TestDao
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月5日 下午10:18:11
 * @version 1.0
 */
public interface TestDao extends BasiceDao {

	/***
	 * 获取所有的数据
	 * 
	 * @return 数据集合
	 */
	List<Map<String, Object>> queryForMap();

	/***
	 * 保存
	 * 
	 * @param form
	 *            保存参数
	 * @return 新增主键
	 */
	int save(TestSave form);

	/***
	 * 删除
	 * 
	 * @remark 真实项目中,更多是逻辑删除代替物理删除
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
	Test queryForDTO(int id);

	/***
	 * 编辑
	 * 
	 * @param form
	 *            编辑参数
	 * @return true : 成功 | false :失败
	 */
	boolean edit(TestEdit form);

	/***
	 * 判断主键是否存在
	 * 
	 * @param id
	 *            主键
	 * @return true : 存在 | false :不存在
	 */
	boolean existed(int id);
}
