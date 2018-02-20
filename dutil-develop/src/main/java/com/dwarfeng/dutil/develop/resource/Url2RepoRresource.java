package com.dwarfeng.dutil.develop.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Objects;

import com.dwarfeng.dutil.basic.io.FileUtil;
import com.dwarfeng.dutil.basic.io.IOUtil;

/**
 * URL到仓库的资源。
 * 
 * <p>
 * 该资源的位置在本地，资源文件为资源仓库中的文件。
 * 
 * <p>
 * 所谓的资源仓库，是指一个系统的，用于分类存放资源的仓库。资源仓库由根目录、资源分类、文件名称三个部分组成。 <br>
 * 资源仓库的根目录是仓库的根路径，仓库中所有的资源都放在根目录下。<br>
 * 资源分类是资源仓库的子文件夹，该文件夹对不同类型的资源做出区分。<br>
 * 文件名称是资源的文件部分，负责存储具体的数据。
 * 
 * @author DwArFeng
 * @since 0.2.0-beta
 */
public class Url2RepoRresource extends AbstractResource {

	/** 默认资源的位置。 */
	protected final URL def;

	/** 资源仓库的根目录。 */
	protected final File repoDir;
	/** 资源仓库的资源分类。 */
	protected final String classify;
	/** 资源仓库的文件名称。 */
	protected final String fileName;

	/**
	 * 生成新的URL到仓库资源。
	 * 
	 * @param key
	 *            指定的键。
	 * @param def
	 *            默认资源的URL。
	 * @param repoDir
	 *            资源仓库的根目录。
	 * @param classify
	 *            资源的分类，不允许含有文件夹分隔符。
	 * @param fileName
	 *            文件名称，不允许含有文件夹分隔符。
	 * @throws NullPointerException
	 *             指定的入口参数为 <code> null </code>。
	 */
	public Url2RepoRresource(String key, URL def, File repoDir, String classify, String fileName) {
		super(key);

		this.def = def;
		this.repoDir = repoDir;
		this.classify = classify;
		this.fileName = fileName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InputStream openInputStream() throws IOException {
		File res = getResourceFile();
		return new FileInputStream(res);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OutputStream openOutputStream() throws IOException {
		File res = getResourceFile();
		return new FileOutputStream(res);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reset() throws IOException {
		File res = getResourceFile();
		FileUtil.createFileIfNotExists(res);

		InputStream in = null;
		OutputStream out = null;

		try {
			in = def.openStream();
			out = new FileOutputStream(res);
			IOUtil.trans(in, out, 8192);
		} finally {
			if (Objects.nonNull(in)) {
				in.close();
			}
			if (Objects.nonNull(out)) {
				out.close();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValid() {
		return getResourceFile().exists();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classify == null) ? 0 : classify.hashCode());
		result = prime * result + ((def == null) ? 0 : def.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((repoDir == null) ? 0 : repoDir.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Url2RepoRresource other = (Url2RepoRresource) obj;
		if (classify == null) {
			if (other.classify != null)
				return false;
		} else if (!classify.equals(other.classify))
			return false;
		if (def == null) {
			if (other.def != null)
				return false;
		} else if (!def.equals(other.def))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (repoDir == null) {
			if (other.repoDir != null)
				return false;
		} else if (!repoDir.equals(other.repoDir))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Url2RepoRresource [def=" + def + ", repoDir=" + repoDir + ", classify=" + classify + ", fileName="
				+ fileName + "]";
	}

	/**
	 * 通过资源仓库的属性返回直接指向该资源的文件。
	 * 
	 * @return 指向该资源的文件。
	 */
	private File getResourceFile() {
		return new File(repoDir,
				new StringBuilder().append(classify).append(File.separator).append(fileName).toString());
	}
}
