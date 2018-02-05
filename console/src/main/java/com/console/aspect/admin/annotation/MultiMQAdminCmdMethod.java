package com.console.aspect.admin.annotation;

import java.lang.annotation.*;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 * One method invoked method of MQAdmin too often
 * Add the annotation for link/interrupt frequently
 */
@Target({ ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MultiMQAdminCmdMethod {
}
