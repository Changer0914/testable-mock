package com.alibaba.testable.core.util;

/**
 * @author flin
 */
public class LogUtil {

    public enum LogLevel {
        /**
         * Mute
         */
        LEVEL_MUTE(0),
        /**
         * Warn only
         */
        LEVEL_WARN(1),
        /**
         * Show diagnose messages
         */
        LEVEL_DIAGNOSE(2),
        /**
         * Show detail progress logs
         */
        LEVEL_VERBOSE(3);

        int level;
        LogLevel(int l) {
            level = l;
        }
    }

    private static LogLevel defaultLogLevel = LogLevel.LEVEL_WARN;
    private static LogLevel currentLogLevel = LogLevel.LEVEL_WARN;

    public static void verbose(String msg, Object... args) {
        if (currentLogLevel.level >= LogLevel.LEVEL_VERBOSE.level) {
            System.out.println(String.format("[VERBOSE] " + msg, args));
        }
    }

    public static void diagnose(String msg, Object... args) {
        if (currentLogLevel.level >= LogLevel.LEVEL_DIAGNOSE.level) {
            System.out.println(String.format("[DIAGNOSE] " + msg, args));
        }
    }

    public static void warn(String msg, Object... args) {
        if (currentLogLevel.level >= LogLevel.LEVEL_WARN.level) {
            System.out.println(String.format("[WARN] " + msg, args));
        }
    }

    public static void error(String msg, Object... args) {
        System.err.println(String.format("[FAIL] " + msg, args));
    }

    public static void enableDiagnose(boolean enable) {
        currentLogLevel = enable ? LogLevel.LEVEL_DIAGNOSE : LogLevel.LEVEL_MUTE;
    }

    public static void setDefaultLevel(LogLevel level) {
        defaultLogLevel = level;
        resetLogLevel();
    }

    public static void resetLogLevel() {
        currentLogLevel = defaultLogLevel;
    }

}
