package com.crocoro.file;

import java.io.File;
import java.text.DecimalFormat;

/**
 * 文件属性的工具类
 */
public class FilePropUtil {
    /**
     * 格式化文件大小
     *
     * @param file 文件
     * @return 文件大小的字符串 B,KB,MB,GB,TB
     */
    public static String FormatFileSize(File file) {
        return FormatFileSize(file.length());
    }

    /**
     * 格式化文件大小
     *
     * @param file   文件
     * @param format 文件格式 如: ".00",".000"
     * @return 文件大小的字符串 B,KB,MB,GB,TB
     */
    public static String FormatFileSize(File file, String format) {
        return FormatFileSize(file.length(), format);
    }

    /**
     * 格式化文件大小
     *
     * @param size 文件大小
     * @return 文件大小的字符串 B,KB,MB,GB,TB
     */
    public static String FormatFileSize(long size) {
        return FormatFileSize(size, ".00");
    }

    /**
     * 格式化文件大小
     *
     * @param size   文件大小
     * @param format 文件格式 如: ".00",".000"
     * @return 文件大小的字符串 B,KB,MB,GB,TB
     */
    public static String FormatFileSize(long size, String format) {
        DecimalFormat df = new DecimalFormat("#" + format);
        String fileSizeString;
        if (size == 0) {
            fileSizeString = "0";
        } else if (size < 1024) {
            fileSizeString = df.format((double) size) + "B";
        } else if (size < 1048576) {
            fileSizeString = df.format((double) size / 1024) + "KB";
        } else if (size < 1073741824) {
            fileSizeString = df.format((double) size / 1048576) + "MB";
        } else if (size < 1099511627776L) {
            fileSizeString = df.format((double) size / 1073741824) + "GB";
        } else {
            fileSizeString = df.format((double) size / 1099511627776L) + "TB";
        }
        return fileSizeString;
    }
}
