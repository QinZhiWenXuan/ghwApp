package xuan.wen.qin.ghw.common.web.servlet.impl;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import xuan.wen.qin.ghw.common.web.servlet.HandlerGlobalExceptionResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * HandlerGlobalExceptionResolverImpl
 * 
 * @remark 全局异常处理
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月5日 下午10:29:32
 * @version 1.0
 */
@Component(value = "handlerGlobalExceptionResolver")
public class HandlerGlobalExceptionResolverImpl implements
		HandlerGlobalExceptionResolver {
	private static final Logger logger = LoggerFactory
			.getLogger(HandlerGlobalExceptionResolverImpl.class);
	private static final ObjectMapper mapper = new ObjectMapper();

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView mav = new ModelAndView();
		PrintWriter print = null;
		/** 设置返回状态码 */
		response.setStatus(HttpStatus.OK.value());
		/** 设置返回ContentType */
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		/** 避免乱码 */
		response.setCharacterEncoding("UTF-8");
		/** 设置返回header */
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		Map<String, String> resutl = new HashMap<String, String>(2);
		resutl.put("code", "500");
		String message = "server data anomalies";
		try {
			print = response.getWriter();
			resutl.put("message", message);
			String json = mapper.writeValueAsString(resutl);
			logger.error("全局异常处理信息 : {}", ex.getLocalizedMessage());
			print.write(json);
		} catch (Exception e) {
			logger.error("全局异常处理 失败: {}", e.getLocalizedMessage());
		} finally {
			if (null != print) {
				print.close();
			}
		}
		return mav;
	}

}
