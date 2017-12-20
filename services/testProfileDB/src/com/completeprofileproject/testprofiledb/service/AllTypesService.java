/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.completeprofileproject.testprofiledb.service;

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

import com.completeprofileproject.testprofiledb.AllTypes;

/**
 * Service object for domain model class {@link AllTypes}.
 */
public interface AllTypesService {

    /**
     * Creates a new AllTypes. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AllTypes if any.
     *
     * @param allTypes Details of the AllTypes to be created; value cannot be null.
     * @return The newly created AllTypes.
     */
	AllTypes create(@Valid AllTypes allTypes);


	/**
	 * Returns AllTypes by given id if exists.
	 *
	 * @param alltypesId The id of the AllTypes to get; value cannot be null.
	 * @return AllTypes associated with the given alltypesId.
     * @throws EntityNotFoundException If no AllTypes is found.
	 */
	AllTypes getById(Integer alltypesId) throws EntityNotFoundException;

    /**
	 * Find and return the AllTypes by given id if exists, returns null otherwise.
	 *
	 * @param alltypesId The id of the AllTypes to get; value cannot be null.
	 * @return AllTypes associated with the given alltypesId.
	 */
	AllTypes findById(Integer alltypesId);


	/**
	 * Updates the details of an existing AllTypes. It replaces all fields of the existing AllTypes with the given allTypes.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on AllTypes if any.
     *
	 * @param allTypes The details of the AllTypes to be updated; value cannot be null.
	 * @return The updated AllTypes.
	 * @throws EntityNotFoundException if no AllTypes is found with given input.
	 */
	AllTypes update(@Valid AllTypes allTypes) throws EntityNotFoundException;

    /**
	 * Deletes an existing AllTypes with the given id.
	 *
	 * @param alltypesId The id of the AllTypes to be deleted; value cannot be null.
	 * @return The deleted AllTypes.
	 * @throws EntityNotFoundException if no AllTypes found with the given id.
	 */
	AllTypes delete(Integer alltypesId) throws EntityNotFoundException;

	/**
	 * Find all AllTypes matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AllTypes.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<AllTypes> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all AllTypes matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AllTypes.
     *
     * @see Pageable
     * @see Page
	 */
    Page<AllTypes> findAll(String query, Pageable pageable);

    /**
	 * Exports all AllTypes matching the given input query to the given exportType format.
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
	 * Retrieve the count of the AllTypes in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the AllTypes.
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

