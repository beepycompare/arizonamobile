package androidx.tracing;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class Trace {
    static final int MAX_TRACE_LABEL_LENGTH = 127;
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static boolean sHasAppTracingEnabled;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return TraceApi29Impl.isEnabled();
        }
        return isEnabledFallback();
    }

    public static void forceEnableAppTracing() {
        if (Build.VERSION.SDK_INT < 31) {
            try {
                if (sHasAppTracingEnabled) {
                    return;
                }
                sHasAppTracingEnabled = true;
                android.os.Trace.class.getMethod("setAppTracingAllowed", Boolean.TYPE).invoke(null, true);
            } catch (Exception e) {
                handleException("setAppTracingAllowed", e);
            }
        }
    }

    public static void beginSection(String str) {
        TraceApi18Impl.beginSection(truncatedTraceSectionLabel(str));
    }

    public static void endSection() {
        TraceApi18Impl.endSection();
    }

    public static void beginAsyncSection(String str, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.beginAsyncSection(truncatedTraceSectionLabel(str), i);
        } else {
            beginAsyncSectionFallback(truncatedTraceSectionLabel(str), i);
        }
    }

    public static void endAsyncSection(String str, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.endAsyncSection(truncatedTraceSectionLabel(str), i);
        } else {
            endAsyncSectionFallback(truncatedTraceSectionLabel(str), i);
        }
    }

    public static void setCounter(String str, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.setCounter(truncatedTraceSectionLabel(str), i);
        } else {
            setCounterFallback(truncatedTraceSectionLabel(str), i);
        }
    }

    private static boolean isEnabledFallback() {
        try {
            if (sIsTagEnabledMethod == null) {
                sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
        } catch (Exception e) {
            handleException("isTagEnabled", e);
            return false;
        }
    }

    private static void beginAsyncSectionFallback(String str, int i) {
        try {
            if (sAsyncTraceBeginMethod == null) {
                sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            sAsyncTraceBeginMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i));
        } catch (Exception e) {
            handleException("asyncTraceBegin", e);
        }
    }

    private static void endAsyncSectionFallback(String str, int i) {
        try {
            if (sAsyncTraceEndMethod == null) {
                sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            sAsyncTraceEndMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i));
        } catch (Exception e) {
            handleException("asyncTraceEnd", e);
        }
    }

    private static void setCounterFallback(String str, int i) {
        try {
            if (sTraceCounterMethod == null) {
                sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            sTraceCounterMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i));
        } catch (Exception e) {
            handleException("traceCounter", e);
        }
    }

    private static void handleException(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v(TAG, "Unable to call " + str + " via reflection", exc);
    }

    private static String truncatedTraceSectionLabel(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }

    private Trace() {
    }
}
