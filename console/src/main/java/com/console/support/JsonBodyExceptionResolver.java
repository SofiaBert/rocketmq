package com.console.support;

import com.console.exception.ServiceException;
import com.console.support.annotation.JsonBody;
import com.console.util.JsonUtil;
import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 * Defacult is the 1st ExceptionResolver, {@link #doResolveException} return ull for next Resolver.
 */
public class JsonBodyExceptionResolver extends SimpleMappingExceptionResolver {
    private final static Logger logger = LoggerFactory.getLogger(JsonBodyExceptionResolver.class);

    public JsonBodyExceptionResolver() {
        this.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response,
                                              Object _handler, Exception ex) {
        HandlerMethod handler = (HandlerMethod) _handler;
        if (handler == null) {
            return null;
        }
        Method method = handler.getMethod();
        if (method.isAnnotationPresent(JsonBody.class) && ex != null) {
            logger.error("server is error", ex);
            Object value = null;
            if (ex instanceof ServiceException) {
                value = new JsonResult<Object>(((ServiceException) ex).getCode(), ex.getMessage());
            } else {
                value = new JsonResult<Object>(-1, ex.getMessage());
            }
            try {
                JsonUtil.writeValue(response.getWriter(), value);
            } catch (IOException e) {
                Throwables.propagateIfPossible(e);
            }
            return ModelAndViewResolver.UNRESOLVED;
        }
        return null;
    }
}
