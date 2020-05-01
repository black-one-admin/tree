package com.black.one.annotations;

import java.lang.annotation.*;

/**
 * 系统分组
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemClassAnnotation {

    /**
     * 操作内容
     * @return
     */
    String value() default "";
}
