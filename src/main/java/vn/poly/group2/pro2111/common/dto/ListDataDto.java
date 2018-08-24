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
 *  == Created at: 12/10/17 10:52 PM
 */
package vn.poly.group2.pro2111.common.dto;

import java.util.ArrayList;
import java.util.List;


public class ListDataDto<E> {

    /*================================================================================================================
     *===== PRIVATE PROPERTIES                                                                                   =====
     *================================================================================================================*/

    /** Rest API: List data */
    private List<E> list;

    /** Rest API: List paging */
    private ListPagingDto paging;

    /*================================================================================================================
     *===== CONSTRUCTOR METHOD                                                                                   =====
     *================================================================================================================*/

    /**
     * Default constructor without argument
     */
    public ListDataDto() {

        // Initial default value
        this.list = new ArrayList<>();
        this.paging = new ListPagingDto();
    }

    /*================================================================================================================
     *===== GETTER & SETTER                                                                                      =====
     *================================================================================================================*/

    /**
     * Get value of list
     */
    public List<E> getList() {
        return list;
    }

    /**
     * Set value for list
     *
     * @param list The value for list
     */
    public void setList(List<E> list) {
        this.list = list;
    }

    /**
     * Get value of paging
     */
    public ListPagingDto getPaging() {
        return paging;
    }

    /**
     * Set value for paging
     *
     * @param paging The value for paging
     */
    public void setPaging(ListPagingDto paging) {
        this.paging = paging;
    }
}
