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

import com.fasterxml.jackson.annotation.JsonIgnore;


public class ListPagingDto {

    /*================================================================================================================
     *===== CONSTANTS                                                                                            =====
     *================================================================================================================*/

    /** Default value: current page */
    private static final Long DEFAULT_CURRENT_PAGE = 1L;

    /** Default value: total records */
    private static final Long DEFAULT_TOTAL_RECORDS = 0L;

    /** Default value: page items */
    private static final Long DEFAULT_PAGE_ITEMS = 5L;

    /** Default value: page items */
    private static final int DEFAULT_DISPLAY_PAGES = 5;
    
    /** Default value: page items */
    private static final int DEFAULT_DISPLAY_FIRST = 1;

    /*================================================================================================================
     *===== PRIVATE PROPERTIES                                                                                   =====
     *================================================================================================================*/

    /** Total records */
    private Long totalRecords;

    /** Total pages */
    private Long totalPages;

    /** Current page number */
    private Long currentPage;

    /** Display items in each pages */
    private Long pageSize;

    /*================================================================================================================
     *===== CONSTRUCTOR METHOD                                                                                   =====
     *================================================================================================================*/

    /**
     * Default constructor without any arguments
     */
    public ListPagingDto() {

        // Set default value
        this.totalRecords   = DEFAULT_TOTAL_RECORDS;
        this.currentPage    = DEFAULT_CURRENT_PAGE;
        this.pageSize       = DEFAULT_PAGE_ITEMS;

        // Calculate paging
        this.calculate();
    }

    /*================================================================================================================
     *===== PRIVATE METHOD                                                                                       =====
     *================================================================================================================*/

    /**
     * Calculating paging information
     */
    private void calculate() {

        // Calculate total pages
        this.totalPages = Math.round(Math.ceil((double) this.totalRecords / this.pageSize));
    }

    /*================================================================================================================
     *===== GETTER & SETTER                                                                                      =====
     *================================================================================================================*/

    /**
     * Set total records
     *
     * @param totalRecords Total records
     */
    public void setTotalRecords(Long totalRecords) {

        // Check total records
        if (totalRecords < 0L) {
            throw new IllegalArgumentException("Total record cannot less than 0.");
        }

        // Set total records
        this.totalRecords = totalRecords;

        // Calculate paging
        this.calculate();
    }

    /**
     * Set current page number
     *
     * @param currentPage Current page number
     */
    public void setCurrentPage(Long currentPage) {

        // Check current page number
        if (currentPage < 1L) {
            throw new IllegalArgumentException("Current page number cannot less than 1.");
        }

        // Set current page number
        this.currentPage = currentPage;

        // Calculate paging
        this.calculate();
    }

    /**
     * Set page items (total item per each pages)
     *
     * @param pageSize Page items
     */
    public void setPageSize(Long pageSize) {

        // Check page items
        if (pageSize < 1L) {
            throw new IllegalArgumentException("Page items cannot less than 1.");
        }

        // Set page items
        this.pageSize = pageSize;

        // Calculate paging
        this.calculate();
    }

    /**
     * Get total records
     *
     * @return Total records
     */
    public Long getTotalRecords() {
        return totalRecords;
    }

    /**
     * Get total pages
     *
     * @return Total pages
     */
    public Long getTotalPages() {
        return totalPages;
    }

    /**
     * Get current page number
     *
     * @return The current page number
     */
    public Long getCurrentPage() {
        return currentPage;
    }

    /**
     * Get page items (total items per each pages)
     *
     * @return The page items
     */
    public Long getPageSize() {
        return pageSize;
    }

    /**
     * Get offset for database query
     *
     * @return The offset - query first records
     */
    @JsonIgnore
    public int getOffset() {
        Long offset = (this.currentPage - 1L) * this.pageSize;
        return offset.intValue();
    }

    /**
     * Get limit for database query
     *
     * @return The limit - query max records
     */
    @JsonIgnore
    public int getLimit() {
        return this.pageSize.intValue();
    }

    /**
     * Get display page from
     * 
     * @return
     */
    public int getFrom() {

        int midPage = (int) Math.ceil((double) DEFAULT_DISPLAY_PAGES / 2);

        if (this.currentPage.intValue() <= midPage) {
            return DEFAULT_DISPLAY_FIRST;
        }

        return this.currentPage.intValue() - midPage;
    }

    /**
     * Get display page to
     * 
     * @return
     */
    public int getTo() {

        int midPage = (int) Math.ceil((double) DEFAULT_DISPLAY_PAGES / 2);

        if (this.currentPage.intValue() + midPage > this.totalPages.intValue()) {
            return this.totalPages.intValue();
        }

        if (this.currentPage.intValue() + midPage < DEFAULT_DISPLAY_PAGES
                && DEFAULT_DISPLAY_PAGES > this.totalPages.intValue()) {
            this.totalPages.intValue();
        }

        if (this.currentPage.intValue() + midPage < DEFAULT_DISPLAY_PAGES
                && DEFAULT_DISPLAY_PAGES <= this.totalPages.intValue()) {
            return DEFAULT_DISPLAY_PAGES;
        }

        return this.currentPage.intValue() + midPage;
    }

    /**
     * Get first display page
     * 
     * @return
     */
    public int getFirst() {
        return this.totalPages.intValue() > 0 ? DEFAULT_DISPLAY_FIRST : 0;
    }

    /**
     * Get last display page
     * 
     * @return
     */
    public int getLast() {
        return this.totalPages.intValue();
    }
}