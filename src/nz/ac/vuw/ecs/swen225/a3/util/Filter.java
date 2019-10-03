package nz.ac.vuw.ecs.swen225.a3.util;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * Filter class is responsible for filtering files that can
 * be opened. Defaults to JSON files.
 */
public class Filter extends FileFilter {

	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String name = f.getName();

		String extension = Utils.getFileExtension(name);

		if (extension == null) {
			return false;
		}

		if (extension.equals("json")) {
			return true;
		}

		return false;
	}

	/**
	 * Returns the description of the file.
	 */
	@Override
	public String getDescription() {
		return "JSON files (*.json)";
	}

	/**
	 * Utility class. Returns the extension of file.
	 */
	public static class Utils {
		/**
		 * Get the file Extension.
		 * 
		 * @param name
		 * @return String
		 */
		public static String getFileExtension(String name) {
			int pointIndex = name.lastIndexOf(".");

			if (pointIndex == -1) {
				return null;
			}

			if (pointIndex == name.length() - 1) {
				return null;
			}

			return name.substring(pointIndex + 1, name.length());
		}
	}
}
