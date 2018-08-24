/*
 *@Author P.Tuong
 *@Date Aug 6, 2018
 *@Version 1.0
*/
package vn.poly.group2.pro2111.common.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Auth {
	public enum Role {
		LOGIN,
		ADMIN,
		LECTURER
	};
	

	public Role role() default Role.LOGIN;
}
