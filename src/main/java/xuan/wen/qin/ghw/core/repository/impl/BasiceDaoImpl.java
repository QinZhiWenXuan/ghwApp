package xuan.wen.qin.ghw.core.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import xuan.wen.qin.ghw.core.repository.BasiceDao;

/**
 * BasiceDaoImpl
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月5日 下午9:13:48
 * @version 1.0
 */
@Repository(value = "basiceDao")
public abstract class BasiceDaoImpl implements BasiceDao {
	@Autowired(required = true)
	@Qualifier(value = "jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;
	@Autowired(required = true)
	@Qualifier(value = "namedParameterJdbcTemplate")
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

}
