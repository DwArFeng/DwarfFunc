package com.dwarfeng.dutil.demo.develop;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.dwarfeng.dutil.develop.cfg.ConfigChecker;
import com.dwarfeng.dutil.develop.cfg.ConfigEntry;
import com.dwarfeng.dutil.develop.cfg.ConfigFirmProps;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigModel;
import com.dwarfeng.dutil.develop.cfg.ConfigModelObverser;
import com.dwarfeng.dutil.develop.cfg.DefaultConfigModel;
import com.dwarfeng.dutil.develop.cfg.checker.IntegerConfigChecker;
import com.dwarfeng.dutil.develop.cfg.io.PropertiesConfigLoader;
import com.dwarfeng.dutil.develop.cfg.io.StreamConfigLoader;

/**
 * {@link ConfigModel}�Ĵ���ʾ����
 * <p> ��ʾ��������һ�����壬�����������ʹ����������¼��
 * @author DwArFeng
 * @since 1.8
 */
public class ConfigModelDemo {
	
	/**
	 * ��������һ�������У�����һ���������۵����á�
	 * @author DwArFeng
	 * @since 1.8
	 */
	private enum ApperanceConfig implements ConfigEntry{
		
		/**
		 * �������ֶα�ʾ����ĸ߶ȣ�Ϊ600��������ֵ�������һ���������������ȡֵ��1��3000֮�䡣
		 * Ҳ����˵��������ֵ��������1-3000֮���������
		 */
		APPERANCE_HEIGHT("apperance.height","600", new IntegerConfigChecker(1,3000)),
		
		/**
		 * ��ʾ���ڵĸ߶ȣ�ͬ�ϡ�
		 */
		APPERANCE_WIDTH("apperance.width", "800", new IntegerConfigChecker(1, 3000)),
		
		;

		private final String key;
		private final String defaultValue;
		private final ConfigChecker checker;
		private final ConfigFirmProps configFirmProps = new ConfigFirmProps() {
			
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dutil.develop.cfg.ConfigFirmProps#getDefaultValue()
			 */
			@Override
			public String getDefaultValue() {
				return defaultValue;
			}
			
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dutil.develop.cfg.ConfigFirmProps#getConfigChecker()
			 */
			@Override
			public ConfigChecker getConfigChecker() {
				return checker;
			}
		};
		
		private ApperanceConfig(String key, String defaultValue, ConfigChecker checker) {
			this.key = key;
			this.defaultValue = defaultValue;
			this.checker = checker;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigEntry#getConfigKey()
		 */
		@Override
		public ConfigKey getConfigKey() {
			return new ConfigKey(key);
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigEntry#getConfigFirmProps()
		 */
		@Override
		public ConfigFirmProps getConfigFirmProps() {
			return configFirmProps;
		}
		
	}
	
	private final class TestFrame extends JFrame{
		
		private static final long serialVersionUID = 1L;

		private final ConfigModelObverser obverser = new ConfigModelObverser() {
			
			@Override
			public void fireCurrentValueChanged(ConfigKey configKey, String oldValue, String newValue, String validValue) {
				if(configKey.equals(ApperanceConfig.APPERANCE_HEIGHT.getConfigKey())){
					setSize(getWidth(), Integer.parseInt(validValue));
				}
				if(configKey.equals(ApperanceConfig.APPERANCE_WIDTH.getConfigKey())){
					setSize(Integer.parseInt(validValue), getHeight());
				}
			}
			@Override
			public void fireConfigKeyRemoved(ConfigKey configKey) {}
			@Override
			public void fireConfigKeyCleared() {}
			@Override
			public void fireConfigKeyAdded(ConfigKey configKey) {}
			@Override
			public void fireConfigFirmPropsChanged(ConfigKey configKey, ConfigFirmProps oldValue, ConfigFirmProps newValue) {}
		};
		
		public TestFrame() {
			setTitle("ConfigModelDemo");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			applyConfig();
			addListener();
			addButton();
		}

		private void addButton() {
			Container content = getContentPane();
			content.setLayout(new FlowLayout());
			JButton jb1 = new JButton("Config 1");
			JButton jb2 = new JButton("Config 2");
			JButton jb3 = new JButton("Config 3");
			jb1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					StreamConfigLoader loader = null;
					try{
						loader = new PropertiesConfigLoader(this.getClass().getResourceAsStream("/com/dwarfeng/dutil/resource/demo/ConfigModelDemo_1.properties"));
						loader.loadConfig(configModel);
					}catch (Exception e1) {
						e1.printStackTrace();
					}finally {
						if(Objects.nonNull(loader)){
							try {
								loader.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
			jb2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					StreamConfigLoader loader = null;
					try{
						loader = new PropertiesConfigLoader(this.getClass().getResourceAsStream("/com/dwarfeng/dutil/resource/demo/ConfigModelDemo_2.properties"));
						loader.loadConfig(configModel);
					}catch (Exception e1) {
						e1.printStackTrace();
					}finally {
						if(Objects.nonNull(loader)){
							try {
								loader.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
			jb3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					StreamConfigLoader loader = null;
					try{
						loader = new PropertiesConfigLoader(this.getClass().getResourceAsStream("/com/dwarfeng/dutil/resource/demo/ConfigModelDemo_3.properties"));
						loader.loadConfig(configModel);
					}catch (Exception e1) {
						e1.printStackTrace();
					}finally {
						if(Objects.nonNull(loader)){
							try {
								loader.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
			content.add(jb1);
			content.add(jb2);
			content.add(jb3);
		}

		private void addListener() {
			/**
			 * ������ģ������ӹ۲����������÷����仯ʱ������Ӧ����Ӧ��
			 */
			configModel.addObverser(obverser);
		}

		private void applyConfig() {
			/*
			 * ���ǵ��͵����õ�Ӧ�÷���
			 */
			int width = Integer.parseInt(configModel.getValidValue(ApperanceConfig.APPERANCE_WIDTH.getConfigKey()));
			int height = Integer.parseInt(configModel.getValidValue(ApperanceConfig.APPERANCE_HEIGHT.getConfigKey()));
			setSize(width, height);
			setLocationRelativeTo(null);
		}
		
	}
	
	private final ConfigModel configModel;
	private final TestFrame testFrame;
	
	public ConfigModelDemo(){
		
		/*
		 * ʹ��ö�ٶ���������ڵĺô��ǿ��Կ�ݵؽ����е��������������ʽ���ݵ�����ģ���С�
		 * ʹ��ö�ٶ���������ڣ�ö��Ҫʵ�� ConfigEntry �ӿڡ�
		 */
		this.configModel = new DefaultConfigModel(ApperanceConfig.values());
		
		/**
		 * ��ʾ���档
		 */
		this.testFrame = new TestFrame();
		testFrame.setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		new ConfigModelDemo();
	}

}
