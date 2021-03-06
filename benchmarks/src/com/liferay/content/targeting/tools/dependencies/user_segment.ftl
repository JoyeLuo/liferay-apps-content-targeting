<#assign assetVocabularyModel = dataFactory.newUserSegmentAssetVocabularyModel(groupId) />

insert into AssetVocabulary values ('${assetVocabularyModel.uuid}', ${assetVocabularyModel.vocabularyId}, ${assetVocabularyModel.groupId}, ${assetVocabularyModel.companyId}, ${assetVocabularyModel.userId}, '${assetVocabularyModel.userName}', '${dataFactory.getDateString(assetVocabularyModel.createDate)}', '${dataFactory.getDateString(assetVocabularyModel.modifiedDate)}', '${assetVocabularyModel.name}', '${assetVocabularyModel.title}', '${assetVocabularyModel.description}', '${assetVocabularyModel.settings}');

<@insertResourcePermissions
	_entry = assetVocabularyModel
/>

<#assign assetEntryModels = dataFactory.getAssetEntryModels() />
<#assign userSegmentModels = dataFactory.newUserSegmentModels(groupId) />

<#list userSegmentModels as userSegmentModel>
	<#assign assetCategoryModel = dataFactory.newUserSegmentAssetCategoryModel(groupId, assetVocabularyModel.vocabularyId, userSegmentModel) />

	insert into AssetCategory values ('${assetCategoryModel.uuid}', ${assetCategoryModel.categoryId}, ${assetCategoryModel.groupId}, ${assetCategoryModel.companyId}, ${assetCategoryModel.userId}, '${assetCategoryModel.userName}', '${dataFactory.getDateString(assetCategoryModel.createDate)}', '${dataFactory.getDateString(assetCategoryModel.modifiedDate)}', ${assetCategoryModel.parentCategoryId}, ${assetCategoryModel.leftCategoryId}, ${assetCategoryModel.rightCategoryId}, '${assetCategoryModel.name}', '${assetCategoryModel.title}', '${assetCategoryModel.description}', ${assetCategoryModel.vocabularyId});

	<@insertResourcePermissions
		_entry = assetCategoryModel
	/>

	<#list assetEntryModels as assetEntryModel>
	insert into AssetEntries_AssetCategories values (${assetCategoryModel.categoryId}, ${assetEntryModel.entryId});
	</#list>

	${dataFactory.setAssetCategoryToUserSegment(assetCategoryModel.categoryId, userSegmentModel_index)}

	insert into CT_UserSegment values ('${userSegmentModel.uuid}', ${userSegmentModel.userSegmentId}, ${userSegmentModel.groupId}, ${assetCategoryModel.categoryId}, ${userSegmentModel.companyId}, ${userSegmentModel.userId}, '${userSegmentModel.userName}', '${dataFactory.getDateString(userSegmentModel.createDate)}', '${dataFactory.getDateString(userSegmentModel.modifiedDate)}', '${userSegmentModel.name}', '${userSegmentModel.description}');

	<@insertResourcePermissions
		_entry = userSegmentModel
	/>

	<#assign ruleInstanceModels = dataFactory.newRuleInstanceModels(groupId, userSegmentModel.userSegmentId) />

	<#list ruleInstanceModels as ruleInstanceModel>
		insert into CT_RuleInstance values ('${ruleInstanceModel.uuid}', ${ruleInstanceModel.ruleInstanceId}, ${ruleInstanceModel.groupId}, ${ruleInstanceModel.companyId}, ${ruleInstanceModel.userId}, '${ruleInstanceModel.userName}', '${dataFactory.getDateString(ruleInstanceModel.createDate)}', '${dataFactory.getDateString(ruleInstanceModel.modifiedDate)}', '${ruleInstanceModel.ruleKey}', ${ruleInstanceModel.userSegmentId}, '${ruleInstanceModel.typeSettings}');

		<@insertResourcePermissions
			_entry = ruleInstanceModel
		/>
	</#list>
</#list>