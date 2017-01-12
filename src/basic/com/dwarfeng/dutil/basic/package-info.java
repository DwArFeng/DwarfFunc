/**
 * **DwarfUtil���߰�**��
 * <br> dwarfutil �Ļ������߰���
 * 
 * <p> <b>DwarfUtil</b>
 * <p> �������DwArFeng ���� Ҳ���������ң��ڱ�д����ʱ���������ģ��ҿ���������߰���Ŀ����ʹ�Լ��Ŀ����ٶ�
 * �õ���ߡ����ܽ�����д���ĳ��򣬳�ȡ��������û���ʵ�������ܸ��ӵ��࣬���������ɹ��߰����Ա�����һ��ʹ�á�
 * 
 * <br> ������е����п�������õģ�Ҳ�п����ǲ����� ���� ����ʵ�������ܸ��ӵ��ࡣ
 * <br> ������Щʱ���д������������ ���� DwArFunc �� �������ڱ��ˮƽ���ޣ�DwArFunc����˵��һ���ɹ����࣬
 * ����û�ж�����֧�֣����Ĳ��Ҳ�ǳ��Ļ��ң��㲻��һ���õĹ��߰���Ҳ�����ԭ���Ҵ��㿪�����ĵڶ�����Ҳ����DwarfFunction Reload��
 * 
 * <p> DwarfFunction������Ч����ǿ���⣬����һֱ����Alpha�汾�����ĽṹҲ���ڽ��в��ϵĸĶ���
 * Ȼ����DwarfFunction���߰���չ��Խ��Խ׳�󣬹�������ҲԽ��Խȫ�档�����أ�������еĹ����Ѿ����������ڳ���
 * �����ˣ�����������ѧ���ߡ���ʽ���ߡ������ߵȡ�
 * <br> �𽥵ģ�DwarfFunction���Ľṹ�Ѿ��޷�������Щ�����ˣ���Ҫһ��ȫ�µĹ��߰��ṹ��������Щ�������ӵ�ר��
 * ���߰���
 * 
 * <p><b>DwarfUtil���߰�</b>
 * <br>�ù��߰����ö���ṹ�����ù��߰�����װ��{@linkplain com.dwarfeng.dutil.basic}���У������Ĳ�ͬ��ר�ð����ֱ��װ��������
 * ���У���ÿ�������Ӱ����������Ӧ��jar�������û���ʹ�ó��õĹ��߰�ʱ��ֻ��Ҫ����dutil_basic.jar���ɣ����û���ʹ���ض���ר��
 * ���߰�ʱ��ֻ�赼�빤�߰������������ǰ�ð����ɡ�
 * 
 * <table cellpadding="0" cellspacing="3" border="0" style="text-align: left; width: 100%;">
 *   <caption><b> ר�ù��߰���һ����</b></caption>
 *   <tbody>
 *     <tr>
 *       <th style="vertical-align: top; background-color: rgb(204, 204, 255);
 *           text-align: center; ">����<br>
 *       </th>
 *       <th style="vertical-align: top; background-color: rgb(204, 204, 255);
 *           text-align: center;">��;<br>
 *       </th>
 *     </tr>
 *     <tr>
 *       <td style="vertical-align: middle; width = 66%">
 *              <code> {@linkplain com.dwarfeng.dutil.math}<br></code>
 *       </td>
 *       <td style="vertical-align: middle;">
 *              <code>��ѧ���߰�<br></code>
 *       </td>
 *     </tr>
 *     <tr>
 *       <td style="vertical-align: middle; background-color: rgb(238, 238, 255);">
 *              <code>{@linkplain com.dwarfeng.dutil.foth}<br></code>
 *       </td>
 *       <td style="vertical-align: middle; background-color: rgb(238, 238, 255);">
 *              <code>���и�ʽ����ѧ���߰�<br></code>
 *       </td>
 *     </tr>
 *     <tr>
 *       <td style="vertical-align: middle;">
 *              <code>{@linkplain com.dwarfeng.dutil.phic}<br></code>
 *       </td>
 *       <td style="vertical-align: middle;">
 *              <code>�����߰�<br></code>
 *       </td>
 *     </tr>
 *     <tr>
 *       <td style="vertical-align: middle; background-color: rgb(238, 238, 255);">
 *              <code>{@linkplain com.dwarfeng.dutil.detool}<br></code>
 *       </td>
 *       <td style="vertical-align: middle; background-color: rgb(238, 238, 255);">
 *              <code>������Թ��߰�<br></code>
 *       </td>
 *     </tr>
 *     <tr>
 *       <td style="vertical-align: middle;">
 *              <code>{@linkplain com.dwarfeng.dutil.demo}<br></code>
 *       </td>
 *       <td style="vertical-align: middle;">
 *              <code>ʾ����<br></code>
 *       </td>
 *     </tr>
 *     <tr>
 *       <td style="vertical-align: middle; background-color: rgb(238, 238, 255);">
 *              <code>{@linkplain com.dwarfeng.dutil.develop}<br></code>
 *       </td>
 *       <td style="vertical-align: middle; background-color: rgb(238, 238, 255);">
 *              <code>�������߰�<br></code>
 *       </td>
 *     </tr>
 *   </tbody>
 * </table>
 * 
 * <br> dwarfutil-basic.jar��
 * 
 * <p> ������� DwarfUtil���߰��еĳ��ù��߰������ڵĹ��߶�����ƽ���ĳ����д�г��õĹ��ߡ�
 * <br> ������߰���DwarfUtil���߰���������Ĺ��߰������Ĵ����������ṹֱ������������ǰһ������
 * DwarfFunction����ӵ���������߰������� {@link com.dwarfeng.dutil.basic.DwarfUtil}����������ר�ù��߰�
 * ��ǰ�ð���
 * 
 * <p><b>�йؼ����ԣ�</b>
 * <br> �����ر������������°汾�����ݾɰ汾����Ϊ����ר�ù��ߵ�ǰ�ð��������°汾ͬ�����Ա������ɰ汾ר��
 * ���߰���ǰ�ð�����ˣ��������ù��߰�ʱ������ǰ�ð���ԭ���ϲ�Ӱ����ð���ʹ�á�
 * 
 * @author DwArFeng
 * @since 0.0.2-beta
 */
package com.dwarfeng.dutil.basic;