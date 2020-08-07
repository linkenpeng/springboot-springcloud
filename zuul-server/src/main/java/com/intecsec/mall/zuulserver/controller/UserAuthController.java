package com.intecsec.mall.zuulserver.controller;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author peter.peng
 * @date 2020/8/7
 */
@RestController
public class UserAuthController {

	@RequestMapping(value = "/user", produces = "application/json")
	public Map<String, Object> user(OAuth2Authentication oAuth2Authentication) {
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user", oAuth2Authentication.getUserAuthentication().getPrincipal());
		userInfo.put("authorities", AuthorityUtils.authorityListToSet(oAuth2Authentication.getUserAuthentication().getAuthorities()));
		return userInfo;
	}

}
