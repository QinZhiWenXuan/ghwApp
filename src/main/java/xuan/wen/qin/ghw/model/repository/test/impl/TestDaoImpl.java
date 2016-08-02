package xuan.wen.qin.ghw.model.repository.test.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import xuan.wen.qin.ghw.core.repository.impl.BasiceDaoImpl;
import xuan.wen.qin.ghw.model.entity.dto.Test;
import xuan.wen.qin.ghw.model.entity.form.test.TestEdit;
import xuan.wen.qin.ghw.model.entity.form.test.TestSave;
import xuan.wen.qin.ghw.model.repository.test.TestDao;

/**
 * TestDaoImpl
 * 
 * @remark `ghw_db`.`ghw_test`相关操作java class , 更多请参考 :<br>
 *         http://docs.spring.io/spring/docs/current/spring-framework-reference/
 *         htmlsingle/#jdbc-JdbcTemplate<br>
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月5日 下午10:18:40
 * @version 1.0
 */
@Repository(value = "testDao")
public class TestDaoImpl extends BasiceDaoImpl implements TestDao {
	/** logger **/
	private static final Logger logger = LoggerFactory
			.getLogger(TestDaoImpl.class);

	/***
	 * 获取所有的数据
	 * 
	 * @return 数据集合
	 */
	@Override
	public List<Map<String, Object>> queryForMap() {
		String sql = "SELECT `id` AS id,`test_remark` AS reamrk,`test_description` AS description,`is_delete` AS deleted,`add_time` AS 'addTime',`edit_time` AS editTime FROM `ghw_db`.`ghw_test`";
		logger.debug("queryForMap |sql : {}", sql);
		return this.jdbcTemplate.queryForList(sql);
	}

	/***
	 * 保存
	 * 
	 * @param form
	 *            保存参数
	 * @return 新增主键
	 */
	@Override
	public int save(TestSave form) {
		/***
		 * Interface for retrieving keys, typically used for auto-generated keys
		 * as potentially returned by JDBC insert statements.
		 */
		KeyHolder keyHolder = new GeneratedKeyHolder();
		/** sql 此处采用的是命名绑定参数 :remark 的形式而不是?的形式 **/
		StringBuilder sql = new StringBuilder(
				"INSERT INTO `ghw_db`.`ghw_test` ( ");
		sql.append(
				"`test_remark`,`test_description`,`is_delete`,`add_time`,`edit_time`)")
				.append("VALUES (:remark,:description,:deleted,:addTime,:editTime)");
		logger.debug("save |sql : {}", sql);
		/** 构造执行参数 **/
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("remark", form.getRemark())
				.addValue("description", form.getDescription())
				.addValue("deleted", 0).addValue("addTime", new Date())
				.addValue("editTime", new Date());
		/**
		 * 因为sql 是采用命名绑定参数的形式,所以使用的是namedParameterJdbcTemplate ,
		 * 如果采用的是?的形式可以采用jdbcTemplate
		 **/
		this.namedParameterJdbcTemplate.update(sql.toString(), parameter,
				keyHolder);
		/** 获取新增的主键 **/
		int key = keyHolder.getKey().intValue();
		form.setId(key);
		return key;
	}

	/***
	 * 删除
	 * 
	 * @remark 真实项目中,更多是逻辑删除代替物理删除
	 * @param id
	 *            主键ID
	 * @return true : 成功 | false :失败
	 */
	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM `ghw_db`.`ghw_test` WHERE `id` = :id ";
		logger.debug("delete |sql : {} \t id : {}", sql, id);
		MapSqlParameterSource parameter = new MapSqlParameterSource("id", id);
		/** 返回受影响行数,＞0,则说明成功,否则失败,异常往上抛, **/
		return this.namedParameterJdbcTemplate.update(sql, parameter) > 0;
	}

	/***
	 * 根据主键获取数据
	 * 
	 * @param id
	 *            主键ID
	 * @return 结果
	 */
	@Override
	public Test queryForDTO(int id) {
		String sql = "SELECT `id` AS id,`test_remark` AS reamrk,`test_description` AS description,`is_delete` AS deleted,`add_time` AS 'createDate',`edit_time` AS editDate FROM `ghw_db`.`ghw_test`  WHERE `id` = :id ";
		logger.debug("queryForDTO |sql : {} \t id : {}", sql, id);
		MapSqlParameterSource parameter = new MapSqlParameterSource("id", id);
		RowMapper<Test> rowMapper = new RowMapper<Test>() {

			@Override
			public Test mapRow(ResultSet resultSet, int rowNum)
					throws SQLException {
				Test result = new Test();
				result.setId(resultSet.getInt("id"));
				result.setRemark(resultSet.getString("reamrk"));
				result.setDeleted(resultSet.getBoolean("deleted"));
				result.setDescription(resultSet.getString("description"));
				result.setEditDate(resultSet.getDate("editDate"));
				result.setCreateDate(resultSet.getDate("createDate"));
				return result;
			}
		};
		/** queryForObject是最常用的查询方法如果查询不到符合结果是不会返回null,而是直接抛异常 **/
		return this.namedParameterJdbcTemplate.queryForObject(sql, parameter,
				rowMapper);
	}

	/***
	 * 编辑
	 * 
	 * @param form
	 *            编辑参数
	 * @return true : 成功 | false :失败
	 */
	@Override
	public boolean edit(TestEdit form) {
		StringBuilder sql = new StringBuilder("UPDATE `ghw_db`.`ghw_test` SET ")
				.append("`test_remark` = :reamrk,")
				.append("`test_description` = :description,")
				.append("`is_delete` = :deleted,")
				.append("`edit_time` = :editTime ").append(" WHERE `id` = :id");
		logger.debug("edit |sql : {}", sql);
		MapSqlParameterSource parameter = new MapSqlParameterSource("id",
				form.getId()).addValue("reamrk", form.getRemark())
				.addValue("description", form.getDescription())
				.addValue("deleted", form.isDeleted())
				.addValue("editTime", new Date());
		return this.namedParameterJdbcTemplate
				.update(sql.toString(), parameter) > 0;
	}

	/***
	 * 判断主键是否存在
	 * 
	 * @param id
	 *            主键
	 * @return true : 存在 | false :不存在
	 */
	@Override
	public boolean existed(int id) {
		String sql = "SELECT COUNT(`id`) FROM `ghw_db`.`ghw_test` WHERE `id` = :id";
		logger.debug("existed |sql : {} \t id : {}", sql, id);
		MapSqlParameterSource parameter = new MapSqlParameterSource("id", id);
		/** 这个方法永远都会有返回值,除非数据库或者表被人删掉了 **/
		return this.namedParameterJdbcTemplate.queryForObject(sql, parameter,
				Integer.class) > 0;
	}

}
