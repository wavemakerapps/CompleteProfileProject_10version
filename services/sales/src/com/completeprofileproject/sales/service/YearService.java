/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.completeprofileproject.sales.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.completeprofileproject.sales.Year;

/**
 * Service object for domain model class {@link Year}.
 */
public interface YearService {

    /**
     * Creates a new Year. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Year if any.
     *
     * @param year Details of the Year to be created; value cannot be null.
     * @return The newly created Year.
     */
	Year create(@Valid Year year);


	/**
	 * Returns Year by given id if exists.
	 *
	 * @param yearId The id of the Year to get; value cannot be null.
	 * @return Year associated with the given yearId.
     * @throws EntityNotFoundException If no Year is found.
	 */
	Year getById(Integer yearId) throws EntityNotFoundException;

    /**
	 * Find and return the Year by given id if exists, returns null otherwise.
	 *
	 * @param yearId The id of the Year to get; value cannot be null.
	 * @return Year associated with the given yearId.
	 */
	Year findById(Integer yearId);


	/**
	 * Updates the details of an existing Year. It replaces all fields of the existing Year with the given year.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Year if any.
     *
	 * @param year The details of the Year to be updated; value cannot be null.
	 * @return The updated Year.
	 * @throws EntityNotFoundException if no Year is found with given input.
	 */
	Year update(@Valid Year year) throws EntityNotFoundException;

    /**
	 * Deletes an existing Year with the given id.
	 *
	 * @param yearId The id of the Year to be deleted; value cannot be null.
	 * @return The deleted Year.
	 * @throws EntityNotFoundException if no Year found with the given id.
	 */
	Year delete(Integer yearId) throws EntityNotFoundException;

	/**
	 * Find all Years matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Years.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Year> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Years matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Years.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Year> findAll(String query, Pageable pageable);

    /**
	 * Exports all Years matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Years in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Year.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}

