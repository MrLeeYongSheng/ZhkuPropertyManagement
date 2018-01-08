package com.lys.zhku.initializer;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
//注册DelegatingFilterPorxy Filter,借助该Filter来将处理逻辑委托给Spring应用上下文中的Filter bean来提供安全性能
}
