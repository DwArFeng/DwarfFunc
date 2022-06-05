package com.dwarfeng.dutil.develop.i18n.obs;

import com.dwarfeng.dutil.basic.cna.model.obs.SetObserver;
import com.dwarfeng.dutil.develop.i18n.I18n;
import com.dwarfeng.dutil.develop.i18n.I18nInfo;

import java.util.Locale;

/**
 * 国际化处理器观察器。
 *
 * @author DwArFeng
 * @since 0.1.1-beta
 */
public interface I18nObserver extends SetObserver<I18nInfo> {

    /**
     * 通知观察器指当前语言发生了改变。
     *
     * @param oldLocale 旧的语言地点。
     * @param newLocale 新的语言地点。
     * @param newI18n   新的国际化接口。
     */
    void fireCurrentLocaleChanged(Locale oldLocale, Locale newLocale, I18n newI18n);
}
