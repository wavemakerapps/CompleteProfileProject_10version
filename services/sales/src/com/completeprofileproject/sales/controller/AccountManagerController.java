/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.completeprofileproject.sales.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.completeprofileproject.sales.AccountManager;
import com.completeprofileproject.sales.service.AccountManagerService;


/**
 * Controller object for domain model class AccountManager.
 * @see AccountManager
 */
@RestController("sales.AccountManagerController")
@Api(value = "AccountManagerController", description = "Exposes APIs to work with AccountManager resource.")
@RequestMapping("/sales/AccountManager")
public class AccountManagerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountManagerController.class);

    @Autowired
	@Qualifier("sales.AccountManagerService")
	private AccountManagerService accountManagerService;

	@ApiOperation(value = "Creates a new AccountManager instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AccountManager createAccountManager(@RequestBody AccountManager accountManager) {
		LOGGER.debug("Create AccountManager with information: {}" , accountManager);

		accountManager = accountManagerService.create(accountManager);
		LOGGER.debug("Created AccountManager with information: {}" , accountManager);

	    return accountManager;
	}

    @ApiOperation(value = "Returns the AccountManager instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AccountManager getAccountManager(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting AccountManager with id: {}" , id);

        AccountManager foundAccountManager = accountManagerService.getById(id);
        LOGGER.debug("AccountManager details with id: {}" , foundAccountManager);

        return foundAccountManager;
    }

    @ApiOperation(value = "Updates the AccountManager instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AccountManager editAccountManager(@PathVariable("id") Integer id, @RequestBody AccountManager accountManager) throws EntityNotFoundException {
        LOGGER.debug("Editing AccountManager with id: {}" , accountManager.getId());

        accountManager.setId(id);
        accountManager = accountManagerService.update(accountManager);
        LOGGER.debug("AccountManager details with id: {}" , accountManager);

        return accountManager;
    }

    @ApiOperation(value = "Deletes the AccountManager instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAccountManager(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting AccountManager with id: {}" , id);

        AccountManager deletedAccountManager = accountManagerService.delete(id);

        return deletedAccountManager != null;
    }

    /**
     * @deprecated Use {@link #findAccountManagers(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of AccountManager instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AccountManager> searchAccountManagersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering AccountManagers list");
        return accountManagerService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AccountManager instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AccountManager> findAccountManagers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AccountManagers list");
        return accountManagerService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AccountManager instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AccountManager> filterAccountManagers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AccountManagers list");
        return accountManagerService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAccountManagers(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return accountManagerService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of AccountManager instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countAccountManagers( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting AccountManagers");
		return accountManagerService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getAccountManagerAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return accountManagerService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AccountManagerService instance
	 */
	protected void setAccountManagerService(AccountManagerService service) {
		this.accountManagerService = service;
	}

}

