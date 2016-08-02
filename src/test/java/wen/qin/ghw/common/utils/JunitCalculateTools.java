package wen.qin.ghw.common.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JunitCalculateTools
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月9日 上午10:35:23
 * @version 1.0
 */
public class JunitCalculateTools {
	private final static Logger logger = LoggerFactory
			.getLogger(JunitCalculateTools.class);
	private List<Map<String, Object>> data;

	@Before
	public void init() {
		logger.debug("init ...............");
		data = new ArrayList<>();
		Random random = new Random();
		for (int j = 1; j <= 10; j++) {
			Map<String, Object> mapColl = new HashMap<String, Object>();
			mapColl.put("code", UUID.randomUUID().toString());
			mapColl.put("id", j * 100);
			for (int i = 1; i <= 16; i++) {
				mapColl.put("enrollment", random.nextInt(100));
				mapColl.put("count_" + i, random.nextInt(100));
				mapColl.put("amount_" + i, random.nextInt(100));
			}
			data.add(mapColl);
		}
		logger.debug("data : {}", data.toString());
	}

	@Test
	public void test() {
		logger.debug("\n+++++++++++++++++++++++++++\n");
		CalculateTools tools = new CalculateTools();
		tools.calculate();
	}

	public final class CalculateTools {
		private String count = "c_";
		private String amount = "a_";
		private final DecimalFormat format = new DecimalFormat("0.00");

		public List<Map<String, Object>> calculate() {
			List<Map<String, Object>> calculateData = new ArrayList<>(
					data.size());
			String format = "0.00";
			String newkey = null;
			for (Map<String, Object> mapColl : data) {
				if (null != mapColl && mapColl.size() > 0) {
					Map<String, Object> coll = new HashMap<String, Object>(
							mapColl.size() * 2);
					Integer enrollment = (Integer) mapColl.get("enrollment");
					Set<String> keySet = mapColl.keySet();
					for (String key : keySet) {
						coll.put(key, mapColl.get(key));
						if (key.indexOf("_") > 0) {
							String index = key.split("_")[1];
							Integer temp = (Integer) mapColl.get(key);
							if (key.indexOf("amount") > -1) {
								format = this.format(temp, enrollment, 100);
								format += "%";
								newkey = amount + index;
							} else if (key.indexOf("count") > -1) {
								format = this.format(temp, enrollment, 0);
								newkey = count + index;
							}
							if (newkey != null) {
								coll.put(newkey, format);
								newkey = null;
							}
						}
					}
					calculateData.add(this.groupBy(coll));
				}
			}
			logger.debug("calculateData : {}", calculateData.toString());
			return calculateData;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Object> groupBy(Map<String, Object> mapColl) {
			Map<String, Object> map = null;
			if (null != mapColl && mapColl.size() > 0) {
				map = new HashMap<>(mapColl.size() / 2);
				List<Map<String, Object>> listColl = null;
				Set<String> keySet = mapColl.keySet();
				for (String key : keySet) {
					if (key.indexOf("_") > -1) {
						Map<String, Object> coll = new HashMap<>(1);
						Object value = mapColl.get(key);
						String index = key.split("_")[1];
						String con = key.split("_")[0];
						coll.put(con, value);
						if (map.containsKey(index)) {
							listColl = (List<Map<String, Object>>) map
									.get(index);
						} else {
							listColl = new ArrayList<>(4);
						}
						listColl.add(coll);
						map.put(index, listColl);
					} else {
						map.put(key, mapColl.get(key));
					}
				}
			}
			return map;
		}

		public String format(Integer first, Integer two, int multiplier) {
			Double quotient = 0.00;
			if (two > 0) {
				quotient = Double.longBitsToDouble(first)
						/ Double.longBitsToDouble(two);
				quotient = multiplier > 0 ? (multiplier * quotient) : quotient;
			}
			return format.format(quotient);

		}
	}

}
