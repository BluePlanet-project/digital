package com.digital.backend.common.file;

import java.io.File;
import java.util.Calendar;

import org.apache.commons.io.FilenameUtils;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class CustomFileRenamePolicy implements FileRenamePolicy{
	public File rename(File oldFile) {
		Calendar calendar = Calendar.getInstance();
		long newFileName = calendar.getTimeInMillis();
		String oldFileExt = FilenameUtils.getExtension(oldFile.getName());
		return new File(oldFile.getParentFile(), String.valueOf(newFileName) + "." + oldFileExt);
	}
}
