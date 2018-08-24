/*
 * ================================================================================
 *   == COPYRIGHT HYPERTECH ENTERPRISE SOLUTIONS. ALL RIGHT RESERVED.            ==
 *   == HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.   ==
 *   ==                                                                          ==
 *   == VISIT HTTP://HYPERTECH.COM.VN FOR MORE INFORMATION                       ==
 * ================================================================================
 *
 *  == Project: iam-api
 *  == Created by: duongnguyen
 *  == Created at: 12/10/17 10:48 PM
 */
package vn.poly.group2.pro2111.common.bases;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;


public class BaseController {

    /*================================================================================================================
     *===== PROTECTED PROPERTIES                                                                                 =====
     *================================================================================================================*/

    /** Logger */
    protected final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    protected MessageSource messageSource;

    /*================================================================================================================
     *===== PROTECTED METHOD                                                                                     =====
     *================================================================================================================*/


}
