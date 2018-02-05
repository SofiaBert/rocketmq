package com.console.support.annotation;

import java.lang.annotation.*;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 * when success return JsonResult(data)
 * @see com.console.support.JsonBodyReturnValueProcessor
 * when error return JsonResult(errCode,errMsg)
 * @see com.console.support.JsonBodyExceptionResolver
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JsonBody {

}
