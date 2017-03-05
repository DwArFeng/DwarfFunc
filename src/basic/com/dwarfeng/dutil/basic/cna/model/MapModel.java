package com.dwarfeng.dutil.basic.cna.model;

import java.util.Map;

import com.dwarfeng.dutil.basic.cna.model.obv.MapObverser;
import com.dwarfeng.dutil.basic.prog.ObverserSet;

/**
 * ӳ��ģ�͡�
 * <p> �ṩһ���б�����ģ�ͣ���ģ�Ϳɴ洢һϵ�м�-ֵ�ԣ�ģ���еļ��ǲ��ظ��ģ����µļ�-ֵ�Ա��洢��ģ�����Ѿ������ü�ʱ��
 * ����滻���ü���Ӧ�ľ�ֵ��
 * ��ģ���� {@link Map} ��һ��ʵ�֡�
 * <p> ��ӳ���еļ�-ֵ�Ա����ӡ�ɾ�����ı䡢��յ�ʱ�򣬻Ὣ��Ҫ����Ϣ�ṩ��ע����ģ���ϵ����������ϡ�
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface MapModel<K, V> extends Map<K, V>, ObverserSet<MapObverser<K, V>>{

}
