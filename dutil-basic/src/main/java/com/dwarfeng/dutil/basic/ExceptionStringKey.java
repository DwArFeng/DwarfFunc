package com.dwarfeng.dutil.basic;

import com.dwarfeng.dutil.basic.str.DefaultName;
import com.dwarfeng.dutil.basic.str.Name;

/**
 * 关于这个工具包的所有异常文本字段的主键枚举。
 * <p>
 * 此枚举是对内使用的，它的主要作用是返回内部类所需要的一些字段（尤其是异常字段）。 <br>
 * 请不要在外部程序中调用此包的枚举，因为该枚举对内使用，其本身不保证兼容性。
 * <p>
 * <b>注意：</b> 该枚举在设计的时候不考虑兼容性，当发生不向上兼容的改动时，作者没有义务在变更日志中说明。
 * 
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public enum ExceptionStringKey implements Name {

	WELCOME_STRING(new DefaultName("WelcomeString")), //
	CLASSUTIL_0(new DefaultName("ClassUtil.0")), //
	CLASSUTIL_1(new DefaultName("ClassUtil.1")), //
	CLASSUTIL_2(new DefaultName("ClassUtil.2")), //
	CLASSUTIL_3(new DefaultName("ClassUtil.3")), //
	DUPLICATEIDEXCEPTION_0(new DefaultName("DuplicateIdException.0")), //
	TOSTRINGCOMPARATOR_0(new DefaultName("ToStringComparator.0")), //
	JADJUSTABLEBORDERPANEL_0(new DefaultName("JAdjustableBorderPanel.0")), //
	TAGRUNNER_0(new DefaultName("TagRunner.0")), //
	TAGRUNNER_1(new DefaultName("TagRunner.1")), //
	TIMEMEASURER_0(new DefaultName("TimeMeasurer.0")), //
	TIMEMEASURER_1(new DefaultName("TimeMeasurer.1")), //
	TIMEMEASURER_2(new DefaultName("TimeMeasurer.2")), //
	TIMEMEASURER_3(new DefaultName("TimeMeasurer.3")), //
	TIMEMEASURER_4(new DefaultName("TimeMeasurer.4")), //
	TIMEMEASURER_5(new DefaultName("TimeMeasurer.5")), //
	EVENTLISTENERWEAKSET_0(new DefaultName("EventListenerWeakSet.0")), //
	MUALISTMODEL_0(new DefaultName("MuaListModel.0")), //
	MUALISTMODEL_1(new DefaultName("MuaListModel.1")), //
	STRINGOUTPUTSTREAM_0(new DefaultName("StringOutputStream.0")), //
	STRINGINPUTSTREAM_0(new DefaultName("StringInputStream.0")), //
	STRINGINPUTSTREAM_1(new DefaultName("StringInputStream.1")), //
	STRINGINPUTSTREAM_2(new DefaultName("StringInputStream.2")), //
	STRINGINPUTSTREAM_3(new DefaultName("StringInputStream.3")), //
	STRINGINPUTSTREAM_4(new DefaultName("StringInputStream.4")), //
	ARRAYUTIL_0(new DefaultName("ArrayUtil.0")), //
	ARRAYUTIL_1(new DefaultName("ArrayUtil.1")), //
	ARRAYUTIL_2(new DefaultName("ArrayUtil.2")), //
	ARRAYUTIL_3(new DefaultName("ArrayUtil.3")), //
	ARRAYUTIL_4(new DefaultName("ArrayUtil.4")), //
	FOTHALGEBRAUTIL_0(new DefaultName("FothAlgebraUtil.0")), //
	FOTHALGEBRAUTIL_1(new DefaultName("FothAlgebraUtil.1")), //
	FOTHALGEBRAUTIL_2(new DefaultName("FothAlgebraUtil.2")), //
	ALGEBRA_REALNUMBER(new DefaultName("Algebra_RealNumber")), //
	ALGEBRA_VARIABLE(new DefaultName("Algebra_Variable")), //
	Algebra_VariableSpace(new DefaultName("Algebra_VariableSpace")), //
	Linalge_RowVector(new DefaultName("Linalge_RowVector")), //
	Linalge_ColVector(new DefaultName("Linalge_ColVector")), //
	Linalge_Matrix(new DefaultName("Linalge_Matrix")), //
	COLLECTIONUTIL_0(new DefaultName("CollectionUtil.0")), //
	COLLECTIONUTIL_1(new DefaultName("CollectionUtil.1")), //
	COLLECTIONUTIL_2(new DefaultName("CollectionUtil.2")), //
	COLLECTIONUTIL_3(new DefaultName("CollectionUtil.3")), //
	COLLECTIONUTIL_4(new DefaultName("CollectionUtil.4")), //
	COLLECTIONUTIL_5(new DefaultName("CollectionUtil.5")), //
	COLLECTIONUTIL_6(new DefaultName("CollectionUtil.6")), //
	COLLECTIONUTIL_7(new DefaultName("CollectionUtil.7")), //
	COLLECTIONUTIL_8(new DefaultName("CollectionUtil.8")), //
	COLLECTIONUTIL_9(new DefaultName("CollectionUtil.9")), //
	COLLECTIONUTIL_10(new DefaultName("CollectionUtil.10")), //
	COLLECTIONUTIL_11(new DefaultName("CollectionUtil.11")), //
	COLLECTIONUTIL_12(new DefaultName("CollectionUtil.12")), //
	COLLECTIONUTIL_13(new DefaultName("CollectionUtil.13")), //
	COLLECTIONUTIL_14(new DefaultName("CollectionUtil.14")), //
	COLLECTIONUTIL_15(new DefaultName("CollectionUtil.15")), //
	COLLECTIONUTIL_16(new DefaultName("CollectionUtil.16")), //
	COLLECTIONUTIL_17(new DefaultName("CollectionUtil.17")), //
	COLLECTIONUTIL_18(new DefaultName("CollectionUtil.18")), //
	COLLECTIONUTIL_19(new DefaultName("CollectionUtil.19")), //
	COLLECTIONUTIL_20(new DefaultName("CollectionUtil.20")), //
	COLLECTIONUTIL_21(new DefaultName("CollectionUtil.21")), //
	NameableComparator_0(new DefaultName("NameableComparator.0")), //
	FothValueComparator_0(new DefaultName("FothValueComparator.0")), //
	QuickFothVariable_0(new DefaultName("QuickFothVariable.0")), //
	QuickFothVariable_1(new DefaultName("QuickFothVariable.1")), //
	FothVariable_0(new DefaultName("FothVariable.0")), //
	DefaultFormulaRowVector_0(new DefaultName("DefaultFormulaRowVector.0")), //
	DefaultFormulaRowVector_1(new DefaultName("DefaultFormulaRowVector.1")), //
	DefaultFormulaRowVector_2(new DefaultName("DefaultFormulaRowVector.2")), //
	DefaultFormulaRowVector_3(new DefaultName("DefaultFormulaRowVector.3")), //
	DefaultFormulaRowVector_4(new DefaultName("DefaultFormulaRowVector.4")), //
	DefaultFormulaRowVector_5(new DefaultName("DefaultFormulaRowVector.5")), //
	DefaultFormulaRowVector_6(new DefaultName("DefaultFormulaRowVector.6")), //
	DefaultFormulaRowVector_7(new DefaultName("DefaultFormulaRowVector.7")), //
	DefaultFormulaRowVector_8(new DefaultName("DefaultFormulaRowVector.8")), //
	DefaultFormulaColumnVector_0(new DefaultName("DefaultFormulaColumnVector.0")), //
	DefaultFormulaColumnVector_1(new DefaultName("DefaultFormulaColumnVector.1")), //
	DefaultFormulaColumnVector_2(new DefaultName("DefaultFormulaColumnVector.2")), //
	DefaultFormulaColumnVector_3(new DefaultName("DefaultFormulaColumnVector.3")), //
	DefaultFormulaColumnVector_4(new DefaultName("DefaultFormulaColumnVector.4")), //
	DefaultFormulaColumnVector_5(new DefaultName("DefaultFormulaColumnVector.5")), //
	DefaultFormulaColumnVector_6(new DefaultName("DefaultFormulaColumnVector.6")), //
	LinalgeUtil_0(new DefaultName("LinalgeUtil.0")), //
	LinalgeUtil_1(new DefaultName("LinalgeUtil.1")), //
	LinalgeUtil_2(new DefaultName("LinalgeUtil.2")), //
	LinalgeUtil_3(new DefaultName("LinalgeUtil.3")), //
	LinalgeUtil_4(new DefaultName("LinalgeUtil.4")), //
	FothValue_0(new DefaultName("FothValue.0")), //
	DefaultFormulaMatrix_0(new DefaultName("DefaultFormulaMatrix.0")), //
	DefaultFormulaMatrix_1(new DefaultName("DefaultFormulaMatrix.1")), //
	DefaultFormulaMatrix_2(new DefaultName("DefaultFormulaMatrix.2")), //
	DefaultFormulaMatrix_3(new DefaultName("DefaultFormulaMatrix.3")), //
	DefaultFormulaMatrix_4(new DefaultName("DefaultFormulaMatrix.4")), //
	DefaultFormulaMatrix_5(new DefaultName("DefaultFormulaMatrix.5")), //
	DefaultFormulaMatrix_6(new DefaultName("DefaultFormulaMatrix.6")), //
	DefaultColumnVector_0(new DefaultName("DefaultColumnVector.0")), //
	DefaultColumnVector_1(new DefaultName("DefaultColumnVector.1")), //
	DefaultColumnVector_2(new DefaultName("DefaultColumnVector.2")), //
	DefaultColumnVector_3(new DefaultName("DefaultColumnVector.3")), //
	DefaultColumnVector_4(new DefaultName("DefaultColumnVector.4")), //
	DefaultRowVector_0(new DefaultName("DefaultRowVector.0")), //
	DefaultRowVector_1(new DefaultName("DefaultRowVector.1")), //
	DefaultRowVector_2(new DefaultName("DefaultRowVector.2")), //
	DefaultRowVector_3(new DefaultName("DefaultRowVector.3")), //
	DefaultRowVector_4(new DefaultName("DefaultRowVector.4")), //
	DefaultRowVector_5(new DefaultName("DefaultRowVector.5")), //
	DefaultRowVector_6(new DefaultName("DefaultRowVector.6")), //
	DefaultMatrix_0(new DefaultName("DefaultMatrix.0")), //
	DefaultMatrix_1(new DefaultName("DefaultMatrix.1")), //
	DefaultMatrix_2(new DefaultName("DefaultMatrix.2")), //
	DefaultMatrix_3(new DefaultName("DefaultMatrix.3")), //
	DefaultMatrix_4(new DefaultName("DefaultMatrix.4")), //
	DefaultMatrix_5(new DefaultName("DefaultMatrix.5")), //
	FormulaLinalgeUtil_0(new DefaultName("FormulaLinalgeUtil.0")), //
	FormulaLinalgeUtil_1(new DefaultName("FormulaLinalgeUtil.1")), //
	FothVariableSpace_0(new DefaultName("FothVariableSpace.0")), //
	FothVariableSpace_1(new DefaultName("FothVariableSpace.1")), //
	DefaultTag_0(new DefaultName("DefaultTag.0")), //
	DefaultTag_1(new DefaultName("DefaultTag.1")), //
	DefaultListItemModel_0(new DefaultName("DefaultListItemModel.0")), //
	DefaultListItemModel_1(new DefaultName("DefaultListItemModel.1")), //
	DefaultListItemModel_2(new DefaultName("DefaultListItemModel.2")), //
	DefaultListItemModel_3(new DefaultName("DefaultListItemModel.3")), //
	DefaultListItemModel_4(new DefaultName("DefaultListItemModel.4")), //
	DefaultListItemModel_5(new DefaultName("DefaultListItemModel.5")), //
	DefaultListItemModel_6(new DefaultName("DefaultListItemModel.6")), //
	JointIterator_0(new DefaultName("JointIterator.0")), //
	JointIterator_1(new DefaultName("JointIterator.1")), //
	JointIterator_2(new DefaultName("JointIterator.2")), //
	NUMBERUTIL_0(new DefaultName("NumberUtil.0")), //
	NUMBERUTIL_1(new DefaultName("NumberUtil.1")), //
	NUMBERUTIL_2(new DefaultName("NumberUtil.2")), //
	StreamConfigLoader_0(new DefaultName("StreamConfigLoader.0")), //
	StreamConfigSaver_0(new DefaultName("StreamConfigSaver.0")), //
	ConfigKey_0(new DefaultName("ConfigKey.0")), //
	SWINGUTIL_0(new DefaultName("SwingUtil.0")), //
	SWINGUTIL_1(new DefaultName("SwingUtil.1")), //
	ConfigViewModel_0(new DefaultName("ConfigViewModel.0")), //
	ConfigViewModel_1(new DefaultName("ConfigViewModel.1")), //
	ConfigTablePanel_0(new DefaultName("ConfigTablePanel.0")), //
	ConfigTablePanel_1(new DefaultName("ConfigTablePanel.1")), //
	DefaultConfigModel_0(new DefaultName("DefaultConfigModel.0")), //
	DefaultConfigModel_1(new DefaultName("DefaultConfigModel.1")), //
	DefaultConfigModel_2(new DefaultName("DefaultConfigModel.2")), //
	DefaultConfigModel_3(new DefaultName("DefaultConfigModel.3")), //
	DefaultConfigModel_4(new DefaultName("DefaultConfigModel.4")), //
	DefaultConfigModel_5(new DefaultName("DefaultConfigModel.5")), //
	PROPERTIESCONFIGSAVER_0(new DefaultName("PropertiesConfigSaver.0")), //
	PROPERTIESCONFIGSAVER_1(new DefaultName("PropertiesConfigSaver.1")), //
	PROPERTIESCONFIGLOADER_0(new DefaultName("PropertiesConfigLoader.0")), //
	PROPERTIESCONFIGLOADER_1(new DefaultName("PropertiesConfigLoader.1")), //
	CONFIGUTIL_0(new DefaultName("ConfigUtil.0")), //
	CONFIGUTIL_1(new DefaultName("ConfigUtil.1")), //
	DefaultConfigFirmProps_0(new DefaultName("DefaultConfigFirmProps.0")), //
	DefaultConfigFirmProps_1(new DefaultName("DefaultConfigFirmProps.1")), //
	DefaultConfigFirmProps_2(new DefaultName("DefaultConfigFirmProps.2")), //
	FactoriesByString_0(new DefaultName("FactoriesByString.0")), //
	FactoriesByString_1(new DefaultName("FactoriesByString.1")), //
	NumberedThreadFactory_0(new DefaultName("NumberedThreadFactory.0")), //
	JEXCONSOLE_0(new DefaultName("JExconsole.0")), //
	JEXCONSOLE_1(new DefaultName("JExconsole.1")), //
	JEXCONSOLE_2(new DefaultName("JExconsole.2")), //
	JEXCONSOLE_3(new DefaultName("JExconsole.3")), //
	JEXCONSOLE_4(new DefaultName("JExconsole.4")), //
	STREAMLOADER_0(new DefaultName("StreamLoader.0")), //
	STREAMSAVER_0(new DefaultName("StreamSaver.0")), //
	ABSTRACTLISTMODEL_0(new DefaultName("AbstractListModel.0")), //
	ABSTRACTSETMODEL_0(new DefaultName("AbstractSetModel.0")), //
	ABSTRACTMAPMODEL_0(new DefaultName("AbstractMapModel.0")), //
	ABSTRACTKEYLISTMODEL_0(new DefaultName("AbstractKeyListModel.0")), //
	ABSTRACTKEYSETMODEL_0(new DefaultName("AbstractKeySetModel.0")), //
	MODELUTIL_0(new DefaultName("ModelUtil.0")), //
	MODELUTIL_1(new DefaultName("ModelUtil.1")), //
	MODELUTIL_2(new DefaultName("ModelUtil.2")), //
	MODELUTIL_3(new DefaultName("ModelUtil.3")), //
	MODELUTIL_4(new DefaultName("ModelUtil.4")), //
	MODELUTIL_5(new DefaultName("ModelUtil.5")), //
	MODELUTIL_6(new DefaultName("ModelUtil.6")), //
	MODELUTIL_7(new DefaultName("ModelUtil.7")), //
	MODELUTIL_8(new DefaultName("ModelUtil.8")), //
	ABSTRACTEXCONFIGMODEL_0(new DefaultName("AbstractExconfigModel.0")), //
	DEFAULTEXCONFIGMODEL_0(new DefaultName("DefaultExconfigModel.0")), //
	DEFAULTEXCONFIGMODEL_1(new DefaultName("DefaultExconfigModel.1")), //
	DEFAULTEXCONFIGMODEL_2(new DefaultName("DefaultExconfigModel.2")), //
	DEFAULTEXCONFIGMODEL_3(new DefaultName("DefaultExconfigModel.3")), //
	DELEGATELISTMODEL_0(new DefaultName("DelegateListModel.0")), //
	DELEGATELISTMODEL_1(new DefaultName("DelegateListModel.1")), //
	DELEGATESETMODEL_0(new DefaultName("DelegateSetModel.0")), //
	DELEGATESETMODEL_1(new DefaultName("DelegateSetModel.1")), //
	DELEGATEMAPMODEL_0(new DefaultName("DelegateMapModel.0")), //
	DELEGATEMAPMODEL_1(new DefaultName("DelegateMapModel.1")), //
	DELEGATEMAPMODEL_2(new DefaultName("DelegateMapModel.2")), //
	DELEGATEKEYLISTMODEL_0(new DefaultName("DelegateKeyListModel.0")), //
	MAPKEYSETMODEL_0(new DefaultName("MapKeySetModel.0")), //
	MAPKEYSETMODEL_1(new DefaultName("MapKeySetModel.1")), //
	DELEGATEKEYSETMODEL_0(new DefaultName("DelegateKeySetModel.0")), //
	ABSTRACTBACKGROUND_0(new DefaultName("AbstractBackground.0")), //
	EXECUTORSERVICEBACKGROUND_0(new DefaultName("ExecutorServiceBackground.0")), //
	EXECUTORSERVICEBACKGROUND_1(new DefaultName("ExecutorServiceBackground.1")), //
	EXECUTORSERVICEBACKGROUND_2(new DefaultName("ExecutorServiceBackground.2")), //
	BACKGROUNDUTIL_0(new DefaultName("BackgroundUtil.0")), //
	BACKGROUNDUTIL_1(new DefaultName("BackgroundUtil.1")), //
	BACKGROUNDUTIL_2(new DefaultName("BackgroundUtil.2")), //
	BACKGROUNDUTIL_3(new DefaultName("BackgroundUtil.3")), //
	RESOURCEUTIL_0(new DefaultName("ResourceUtil.0")), //
	RESOURCEUTIL_1(new DefaultName("ResourceUtil.1")), //
	RESOURCEUTIL_2(new DefaultName("ResourceUtil.2")), //
	DELEGATERESOURCEHANDLER_0(new DefaultName("DelegateResourceHandler.0")), //
	ABSTRACTRESOURCE_0(new DefaultName("AbstractResource.0")), //
	URL2FILERESOURCE_0(new DefaultName("Url2FileResource.0")), //
	URL2FILERESOURCE_1(new DefaultName("Url2FileResource.1")), //
	XMLJAR2FILERESOURCELOADER_0(new DefaultName("XmlJar2FileResourceLoader.0")), //
	XMLJAR2FILERESOURCELOADER_1(new DefaultName("XmlJar2FileResourceLoader.1")), //
	XMLJAR2FILERESOURCELOADER_2(new DefaultName("XmlJar2FileResourceLoader.2")), //
	XMLJAR2FILERESOURCELOADER_3(new DefaultName("XmlJar2FileResourceLoader.3")), //
	XMLJAR2FILERESOURCELOADER_4(new DefaultName("XmlJar2FileResourceLoader.4")), //
	ABSTRACTI18NINFO_1(new DefaultName("AbstractI18nInfo.1")), //
	I18NUTIL_0(new DefaultName("I18nUtil.0")), //
	I18NUTIL_1(new DefaultName("I18nUtil.1")), //
	I18NUTIL_2(new DefaultName("I28nUtil.2")), //
	DELEGATEI18NHANDLER_0(new DefaultName("DelegateI18nHandler.0")), //
	PROPURLI18NINFO_0(new DefaultName("PropUrlI18nInfo.0")), //
	PROPERTIESI18N_0(new DefaultName("PropertiesI18n.0")), //
	XMLPROPFILEI18NLOADER_0(new DefaultName("XmlPropFileI18nLoader.0")), //
	XMLPROPFILEI18NLOADER_1(new DefaultName("XmlPropFileI18nLoader.1")), //
	XMLPROPFILEI18NLOADER_2(new DefaultName("XmlPropFileI18nLoader.2")), //
	XMLPROPFILEI18NLOADER_3(new DefaultName("XmlPropFileI18nLoader.3")), //
	XMLPROPRESOURCEI18NLOADER_0(new DefaultName("XmlPropResourceI18nLoader.0")), //
	XMLPROPRESOURCEI18NLOADER_1(new DefaultName("XmlPropResourceI18nLoader.1")), //
	XMLPROPRESOURCEI18NLOADER_2(new DefaultName("XmlPropResourceI18nLoader.2")), //
	XMLPROPRESOURCEI18NLOADER_3(new DefaultName("XmlPropResourceI18nLoader.3")), //
	THREADSAFEUTIL_0(new DefaultName("ThreadSafeUtil.0")), //
	FILEUTIL_0(new DefaultName("FileUtil.0")), //
	FILEUTIL_1(new DefaultName("FileUtil.1")), //
	FILEUTIL_2(new DefaultName("FileUtil.2")), //
	INTERVAL_0(new DefaultName("Interval.0")), //
	INTERVAL_1(new DefaultName("Interval.1")), //
	INTERVAL_2(new DefaultName("Interval.2")), //
	INTERVAL_3(new DefaultName("Interval.3")), //
	INTERVAL_4(new DefaultName("Interval.4")), //
	INTERVAL_5(new DefaultName("Interval.5")), //
	INTERVAL_6(new DefaultName("Interval.6")), //
	THREADUTIL_0(new DefaultName("ThreadUtil.0")), //
	ABSTRACTREFERENCEMODEL_0(new DefaultName("AbstractReferenceModel.0")), //
	IMAGEUTIL_0(new DefaultName("ImageUtil.0")), //
	IMAGEUTIL_1(new DefaultName("ImageUtil.1")), //
	IMAGEUTIL_2(new DefaultName("ImageUtil.2")), //
	IMAGEUTIL_3(new DefaultName("ImageUtil.3")), //
	IMAGEUTIL_4(new DefaultName("ImageUtil.4")), //
	IMAGEUTIL_5(new DefaultName("ImageUtil.5")), //
	IMAGEUTIL_6(new DefaultName("ImageUtil.6")), //
	IMAGEUTIL_7(new DefaultName("ImageUtil.7")), //
	IMAGEUTIL_8(new DefaultName("ImageUtil.8")), //
	BYTEBUFFERINPUTSTREAM_0(new DefaultName("ByteBufferInputStream.0")), //
	BYTEBUFFEROUTPUTSTREAM_0(new DefaultName("ByteBufferOutputStream.0")), //
	DEFAULTNAMEFILTER_0(new DefaultName("DefaultNameFilter.0")), //
	DEFAULTNAMEFILTER_1(new DefaultName("DefaultNameFilter.1")), //
	DEFAULTNAME_0(new DefaultName("DefaultName.0")), //
	DEFAULTTAGFILTER_0(new DefaultName("DefaultTagFilter.0")), //
	LOG4JLOGGERINFO_0(new DefaultName("Log4jLoggerInfo.0")), //
	DELEGATELOGGERHANDLER_0(new DefaultName("DelegateLoggerHandler.0")), //
	DELEGATELOGGERHANDLER_1(new DefaultName("DelegateLoggerHandler.1")), //
	DELEGATELOGGERHANDLER_2(new DefaultName("DelegateLoggerHandler.2")), //
	WRITERLOGGER_0(new DefaultName("WriterLogger.0")), //
	OUTPUTSTREAMLOGGER_0(new DefaultName("OutputStreamLogger.0")), //
	CT_0(new DefaultName("CT.0")), //
	CT_1(new DefaultName("CT.1")), //
	CT_2(new DefaultName("CT.2")), //
	LOGGERHANDLER_0(new DefaultName("LoggerHandler.0")), //
	LOGGERHANDLER_1(new DefaultName("LoggerHandler.1")), //
	INTEGRALVALUEPARSER_0(new DefaultName("IntegralValueParser.0")), //
	LOGGERUTIL_0(new DefaultName("LoggerUtil.0")), //
	LOGGERUTIL_1(new DefaultName("LoggerUtil.1")), //
	LOGGERUTIL_2(new DefaultName("LoggerUtil.2")), //
	LOGGERUTIL_3(new DefaultName("LoggerUtil.3")), //
	LOGGERUTIL_4(new DefaultName("LoggerUtil.4")), //
	SYNCINPUTSTREAM_0(new DefaultName("SyncInputStream.0")), //
	SYNCOUTPUTSTREAM_0(new DefaultName("SyncOutputStream.0")), //
	XMLJAR2REPORESOURCELOADER_0(new DefaultName("XmlJar2RepoResourceLoader.0")), //
	XMLJAR2REPORESOURCELOADER_1(new DefaultName("XmlJar2RepoResourceLoader.1")), //
	XMLJAR2REPORESOURCELOADER_2(new DefaultName("XmlJar2RepoResourceLoader.2")), //
	XMLJAR2REPORESOURCELOADER_3(new DefaultName("XmlJar2RepoResourceLoader.3")), //
	XMLJAR2REPORESOURCELOADER_4(new DefaultName("XmlJar2RepoResourceLoader.4")), //
	ABSTRACTSETTINGHANDLER_0(new DefaultName("AbstractSettingHandler.0")), //
	ABSTRACTSETTINGHANDLER_1(new DefaultName("AbstractSettingHandler.1")), //
	ABSTRACTSETTINGHANDLER_2(new DefaultName("AbstractSettingHandler.2")), //
	ABSTRACTSETTINGHANDLER_3(new DefaultName("AbstractSettingHandler.3")), //
	ABSTRACTSETTINGHANDLER_4(new DefaultName("AbstractSettingHandler.4")), //
	ABSTRACTSETTINGHANDLER_5(new DefaultName("AbstractSettingHandler.5")), //
	DEFAULTSETTINGHANDLER_0(new DefaultName("DefaultSettingHandler.0")), //
	DEFAULTSETTINGHANDLER_1(new DefaultName("DefaultSettingHandler.1")), //
	DEFAULTSETTINGHANDLER_2(new DefaultName("DefaultSettingHandler.2")), //
	DEFAULTSETTINGHANDLER_3(new DefaultName("DefaultSettingHandler.3")), //
	ABSTRACTSETTINGINFO_0(new DefaultName("AbstractSettingInfo.0")), //
	ABSTRACTSETTINGINFO_1(new DefaultName("AbstractSettingInfo.1")), //
	SETTINGUTIL_0(new DefaultName("SettingUtil.0")), //
	SETTINGUTIL_1(new DefaultName("SettingUtil.1")), //
	SETTINGUTIL_2(new DefaultName("SettingUtil.2")), //
	SETTINGUTIL_3(new DefaultName("SettingUtil.3")), //
	SETTINGUTIL_4(new DefaultName("SettingUtil.4")), //
	SETTINGUTIL_5(new DefaultName("SettingUtil.5")), //
	SETTINGUTIL_6(new DefaultName("SettingUtil.6")), //
	SETTINGUTIL_7(new DefaultName("SettingUtil.7")), //
	SETTINGUTIL_8(new DefaultName("SettingUtil.8")), //
	SETTINGUTIL_9(new DefaultName("SettingUtil.9")), //
	SETTINGUTIL_10(new DefaultName("SettingUtil.10")), //
	PROPSETTINGVALUELOADER_0(new DefaultName("PropSettingValueLoader.0")), //
	PROPSETTINGVALUELOADER_1(new DefaultName("PropSettingValueLoader.1")), //
	PROPSETTINGVALUESAVER_0(new DefaultName("PropSettingValueSaver.0")), //
	PROPSETTINGVALUESAVER_1(new DefaultName("PropSettingValueSaver.1")), //
	;

	private final Name name;

	private ExceptionStringKey(Name name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return name.getName();
	}
}
