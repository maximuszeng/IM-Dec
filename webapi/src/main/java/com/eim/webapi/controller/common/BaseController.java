/**
 * 
 */
package com.eim.webapi.controller.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.eim.service.base.AccessUserService;
import com.eim.service.base.ApplicationService;
import com.eim.service.base.IPLocationService;
import com.eim.service.base.StaffService;
import com.eim.service.base.UserService;
import com.eim.service.common.ServiceException;
import com.eim.service.tag.ObjectCategoryService;
import com.eim.service.tag.TagCategoryService;
import com.eim.service.tag.TagObjectRelationService;
import com.eim.service.tag.TagsService;
import com.eim.webapi.vo.common.BaseVO;
import com.eim.webapi.vo.common.ResultVO;

/**
 * @author maximus.zeng
 * 
 */
public class BaseController<B, V extends BaseVO> {
	protected Logger LOGGER = LoggerFactory.getLogger(getClass());
	@Autowired
	protected ApplicationService applicationService;
	
	@Autowired
	protected AccessUserService accessUserService;

	@Autowired
	protected IPLocationService IPLocationService;

	@Autowired
	protected TagsService tagsService;

	@Autowired
	protected TagObjectRelationService tagObjectRelationService;

	@Autowired
	protected TagCategoryService tagCategoryService;

	@Autowired
	protected ObjectCategoryService objectCategoryService;
	
	@Autowired
	protected UserService userService;
	@Autowired
	protected StaffService staffService;

	private Class<B> boType;
	private Class<V> voType;

	@Resource(name = "messageSource")
	protected MessageSource messageSources;

	@Resource(name = "errorMessageSources")
	protected MessageSource errorMessageSources;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseController() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		boType = (Class) pt.getActualTypeArguments()[0];
		voType = (Class) pt.getActualTypeArguments()[1];
	}

	protected V copyBOToVO(B bo) {
		V po = null;
		try {
			po = voType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		BeanUtils.copyProperties(bo, po);
		return po;
	}

	protected B copyVOToBO(V po) {
		B bo = null;
		try {
			bo = boType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		BeanUtils.copyProperties(po, bo);
		return bo;
	}

	protected String getMessage(String code, Object[] params, HttpServletRequest request) {
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		return messageSources.getMessage(code, params, localeResolver.resolveLocale(request));
	}

	protected String getMessage(String code, HttpServletRequest request) {
		return getMessage(code, null, request);
	}

	protected String getErrorMessage(String code, Object[] params, HttpServletRequest request) {
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);

		return errorMessageSources.getMessage(code, params, localeResolver.resolveLocale(request));
	}

	protected String getErrorMessage(String code, HttpServletRequest request) {
		return getErrorMessage(code, null, request);
	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResultVO handleServerErrors(Exception ex, HttpServletRequest request) {
		ResultVO result = new ResultVO();
		LOGGER.error(ex.getMessage(), ex);
		result.setStatus(ResultVO.STATUS_NO);
		result.setErrorMessage(ex.getMessage());
		return result;
	}

	@ExceptionHandler(ServiceException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResultVO handleServiceExceptions(ServiceException ex, HttpServletRequest request) {
		ResultVO result = new ResultVO();
		String errorMessage = getErrorMessage(ex.getErrorCode(), ex.getParams(), request);
		LOGGER.error(errorMessage, ex);
		result.setErrorCode(ex.getErrorCode());
		result.setStatus(ResultVO.STATUS_NO);
		result.setErrorMessage(errorMessage);
		return result;
	}

	protected String decodeIP(String ip) {
		return StringUtils.isNotBlank(ip) ? ip.replaceAll("_", ".") : null;
	}

	protected String encodeIP(String ip) {
		return StringUtils.isNotBlank(ip) ? ip.replaceAll(".", "_") : null;
	}
}