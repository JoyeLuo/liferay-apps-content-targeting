/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.content.targeting.model.impl;

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.model.UserSegmentModel;
import com.liferay.content.targeting.model.UserSegmentSoap;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the UserSegment service. Represents a row in the &quot;CT_UserSegment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.content.targeting.model.UserSegmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserSegmentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentImpl
 * @see com.liferay.content.targeting.model.UserSegment
 * @see com.liferay.content.targeting.model.UserSegmentModel
 * @generated
 */
@JSON(strict = true)
public class UserSegmentModelImpl extends BaseModelImpl<UserSegment>
	implements UserSegmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user segment model instance should use the {@link com.liferay.content.targeting.model.UserSegment} interface instead.
	 */
	public static final String TABLE_NAME = "CT_UserSegment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "userSegmentId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "assetCategoryId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table CT_UserSegment (uuid_ VARCHAR(75) null,userSegmentId LONG not null primary key,groupId LONG,assetCategoryId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name STRING null,description STRING null)";
	public static final String TABLE_SQL_DROP = "drop table CT_UserSegment";
	public static final String ORDER_BY_JPQL = " ORDER BY userSegment.name DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CT_UserSegment.name DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.content.targeting.model.UserSegment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.content.targeting.model.UserSegment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.content.targeting.model.UserSegment"),
			true);
	public static long ASSETCATEGORYID_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long UUID_COLUMN_BITMASK = 8L;
	public static long NAME_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UserSegment toModel(UserSegmentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UserSegment model = new UserSegmentImpl();

		model.setUuid(soapModel.getUuid());
		model.setUserSegmentId(soapModel.getUserSegmentId());
		model.setGroupId(soapModel.getGroupId());
		model.setAssetCategoryId(soapModel.getAssetCategoryId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UserSegment> toModels(UserSegmentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UserSegment> models = new ArrayList<UserSegment>(soapModels.length);

		for (UserSegmentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final String MAPPING_TABLE_CT_CAMPAIGNS_USERSEGMENTS_NAME = "CT_Campaigns_UserSegments";
	public static final Object[][] MAPPING_TABLE_CT_CAMPAIGNS_USERSEGMENTS_COLUMNS =
		{
			{ "campaignId", Types.BIGINT },
			{ "userSegmentId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_CT_CAMPAIGNS_USERSEGMENTS_SQL_CREATE =
		"create table CT_Campaigns_UserSegments (campaignId LONG not null,userSegmentId LONG not null,primary key (campaignId, userSegmentId))";
	public static final boolean FINDER_CACHE_ENABLED_CT_CAMPAIGNS_USERSEGMENTS = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.CT_Campaigns_UserSegments"),
			true);
	public static final String MAPPING_TABLE_CT_TACTICS_USERSEGMENTS_NAME = "CT_Tactics_UserSegments";
	public static final Object[][] MAPPING_TABLE_CT_TACTICS_USERSEGMENTS_COLUMNS =
		{
			{ "tacticId", Types.BIGINT },
			{ "userSegmentId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_CT_TACTICS_USERSEGMENTS_SQL_CREATE = "create table CT_Tactics_UserSegments (tacticId LONG not null,userSegmentId LONG not null,primary key (tacticId, userSegmentId))";
	public static final boolean FINDER_CACHE_ENABLED_CT_TACTICS_USERSEGMENTS = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.CT_Tactics_UserSegments"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.content.targeting.model.UserSegment"));

	public UserSegmentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userSegmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserSegmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userSegmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UserSegment.class;
	}

	@Override
	public String getModelClassName() {
		return UserSegment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userSegmentId", getUserSegmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("assetCategoryId", getAssetCategoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long assetCategoryId = (Long)attributes.get("assetCategoryId");

		if (assetCategoryId != null) {
			setAssetCategoryId(assetCategoryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getUserSegmentId() {
		return _userSegmentId;
	}

	@Override
	public void setUserSegmentId(long userSegmentId) {
		_userSegmentId = userSegmentId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getAssetCategoryId() {
		return _assetCategoryId;
	}

	@Override
	public void setAssetCategoryId(long assetCategoryId) {
		_columnBitmask |= ASSETCATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalAssetCategoryId) {
			_setOriginalAssetCategoryId = true;

			_originalAssetCategoryId = _assetCategoryId;
		}

		_assetCategoryId = assetCategoryId;
	}

	public long getOriginalAssetCategoryId() {
		return _originalAssetCategoryId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getName(), languageId,
			useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(LocalizationUtil.updateLocalization(getName(), "Name",
					name, languageId, defaultLanguageId));
		}
		else {
			setName(LocalizationUtil.removeLocalization(getName(), "Name",
					languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(LocalizationUtil.updateLocalization(nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescription(), languageId,
			useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setDescription(String description, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale) {
		if (descriptionMap == null) {
			return;
		}

		setDescription(LocalizationUtil.updateLocalization(descriptionMap,
				getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				UserSegment.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			UserSegment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(getDescription(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public UserSegment toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserSegment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserSegmentImpl userSegmentImpl = new UserSegmentImpl();

		userSegmentImpl.setUuid(getUuid());
		userSegmentImpl.setUserSegmentId(getUserSegmentId());
		userSegmentImpl.setGroupId(getGroupId());
		userSegmentImpl.setAssetCategoryId(getAssetCategoryId());
		userSegmentImpl.setCompanyId(getCompanyId());
		userSegmentImpl.setUserId(getUserId());
		userSegmentImpl.setUserName(getUserName());
		userSegmentImpl.setCreateDate(getCreateDate());
		userSegmentImpl.setModifiedDate(getModifiedDate());
		userSegmentImpl.setName(getName());
		userSegmentImpl.setDescription(getDescription());

		userSegmentImpl.resetOriginalValues();

		return userSegmentImpl;
	}

	@Override
	public int compareTo(UserSegment userSegment) {
		int value = 0;

		value = getName().compareTo(userSegment.getName());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserSegment)) {
			return false;
		}

		UserSegment userSegment = (UserSegment)obj;

		long primaryKey = userSegment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		UserSegmentModelImpl userSegmentModelImpl = this;

		userSegmentModelImpl._originalUuid = userSegmentModelImpl._uuid;

		userSegmentModelImpl._originalGroupId = userSegmentModelImpl._groupId;

		userSegmentModelImpl._setOriginalGroupId = false;

		userSegmentModelImpl._originalAssetCategoryId = userSegmentModelImpl._assetCategoryId;

		userSegmentModelImpl._setOriginalAssetCategoryId = false;

		userSegmentModelImpl._originalCompanyId = userSegmentModelImpl._companyId;

		userSegmentModelImpl._setOriginalCompanyId = false;

		userSegmentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserSegment> toCacheModel() {
		UserSegmentCacheModel userSegmentCacheModel = new UserSegmentCacheModel();

		userSegmentCacheModel.uuid = getUuid();

		String uuid = userSegmentCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			userSegmentCacheModel.uuid = null;
		}

		userSegmentCacheModel.userSegmentId = getUserSegmentId();

		userSegmentCacheModel.groupId = getGroupId();

		userSegmentCacheModel.assetCategoryId = getAssetCategoryId();

		userSegmentCacheModel.companyId = getCompanyId();

		userSegmentCacheModel.userId = getUserId();

		userSegmentCacheModel.userName = getUserName();

		String userName = userSegmentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			userSegmentCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			userSegmentCacheModel.createDate = createDate.getTime();
		}
		else {
			userSegmentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			userSegmentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			userSegmentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		userSegmentCacheModel.name = getName();

		String name = userSegmentCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			userSegmentCacheModel.name = null;
		}

		userSegmentCacheModel.description = getDescription();

		String description = userSegmentCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			userSegmentCacheModel.description = null;
		}

		return userSegmentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", userSegmentId=");
		sb.append(getUserSegmentId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", assetCategoryId=");
		sb.append(getAssetCategoryId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.content.targeting.model.UserSegment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userSegmentId</column-name><column-value><![CDATA[");
		sb.append(getUserSegmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assetCategoryId</column-name><column-value><![CDATA[");
		sb.append(getAssetCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = UserSegment.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			UserSegment.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _userSegmentId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _assetCategoryId;
	private long _originalAssetCategoryId;
	private boolean _setOriginalAssetCategoryId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private long _columnBitmask;
	private UserSegment _escapedModel;
}