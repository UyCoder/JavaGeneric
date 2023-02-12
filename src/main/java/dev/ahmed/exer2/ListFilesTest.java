package dev.ahmed.exer2;

import java.io.File;
/**
 * 3. Traverse all file names in the specified directory, including files in sub-file directories.
 Extension 1: and calculate the size of the space occupied by the specified directory
 Extension 2: Delete the specified file directory and all files under it

 * @author Ahmed Bughra
 * @create 2023-02-13  12:13 AM
 *
 */
public class ListFilesTest {

	public static void main(String[] args) {
// recursion: file directory
/** Print out the names of all files in the specified directory, including files in subdirectories */

// 1. Create a directory object
		File dir = new File("E:\\teach\\01_javaSE\\_Silicon Valley Java Programming Language\\3_Software");

// 2. Print the subfiles of the directory
		printSubFile(dir);
	}

	public static void printSubFile(File dir) {
// Print the subfiles of the directory
		File[] subfiles = dir.listFiles();

		for (File f : subfiles) {
			if (f.isDirectory()) {//File Directory
				printSubFile(f);
			} else {// document
				System.out.println(f.getAbsolutePath());
			}

		}
	}

	// Method 2: loop implementation
// List the lower-level content of the file directory, only the first-level words are listed
// Using the String[] list() of the File class is relatively simple
	public void listSubFiles(File file) {
		if (file.isDirectory()) {
			String[] all = file.list();
			for (String s : all) {
				System.out.println(s);
			}
		} else {
			System.out.println(file + "is a file！");
		}
	}

	// List the subordinates of the file directory, if its subordinates are still directories, then list the subordinates of the subordinates, and so on
// It is recommended to use File[] listFiles() of the File class
	public void listAllSubFiles(File file) {
		if (file. isFile()) {
			System.out.println(file);
		} else {
			File[] all = file. listFiles();
// If all[i] is a file, print it directly
// If all[i] is a directory, then get its next level
			for (File f : all) {
				listAllSubFiles(f);// Recursive call: Calling yourself is called recursion
			}
		}
	}

	// Extension 1: Find the size of the space where the specified directory is located
// Find the total size of any directory
	public long getDirectorySize(File file) {
// file is a file, then directly return file.length()
// file is a directory, the sum of all the sizes of its next level is its total size
		long size = 0;
		if (file. isFile()) {
			size += file. length();
		} else {
			File[] all = file.listFiles();// Get the next level of file
// Accumulate the size of all[i]
			for (File f : all) {
				size += getDirectorySize(f);// The size of f;
			}
		}
		return size;
	}

	// Extension 2: delete the specified directory
	public void deleteDirectory(File file) {
// If file is a file, delete it directly
// If file is a directory, first kill its next level, and then delete itself
		if (file. isDirectory()) {
			File[] all = file. listFiles();
// The cycle deletes the next level of file
			for (File f : all) {// f represents each subordinate of file
				deleteDirectory(f);
			}
		}
// delete self
		file.delete();
	}

}
