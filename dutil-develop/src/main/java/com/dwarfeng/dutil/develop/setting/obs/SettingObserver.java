package com.dwarfeng.dutil.develop.setting.obs;

import com.dwarfeng.dutil.basic.prog.Observer;
import com.dwarfeng.dutil.develop.setting.SettingInfo;

/**
 * 设置观察器。
 *
 * @author DwArFeng
 * @since 0.3.0-beta
 */
public interface SettingObserver extends Observer {

    /**
     * 通知观察器指定的键值被添加。
     *
     * @param key          指定的键值。
     * @param settingInfo  指定的键对应的配置信息。
     * @param currentValue 指定的键对应的当前值。
     */
    void fireKeyPut(String key, SettingInfo settingInfo, String currentValue);

    /**
     * 通知观察器指定的键值被移除。
     *
     * @param key 指定的键值。
     */
    void fireKeyRemoved(String key);

    /**
     * 通知观察器键值被清空。
     */
    void fireKeyCleared();

    /**
     * 通知观察器指定键值的设置信息被改变。
     *
     * @param key      指定的键。
     * @param oldValue 指定的键对应的旧的配置信息。
     * @param newValue 指定的键对应的新的配置信息。
     */
    void fireSettingInfoChanged(String key, SettingInfo oldValue, SettingInfo newValue);

    /**
     * 通知指定键值的当前值被改变。
     *
     * @param key      指定的键值。
     * @param oldValue 指定的键对应的旧的当前值。
     * @param newValue 指定的键对应的新的当前值。
     */
    void fireCurrentValueChanged(String key, String oldValue, String newValue);
}
