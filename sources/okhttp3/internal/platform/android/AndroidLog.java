package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;
/* compiled from: AndroidLog.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0006\u0010\u0015\u001a\u00020\rJ\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/platform/android/AndroidLog;", "", "<init>", "()V", "MAX_LOG_LENGTH", "", "configuredLoggers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/logging/Logger;", "knownLoggers", "", "", "androidLog", "", "loggerName", "logLevel", "message", "t", "", "androidLog$okhttp", "loggerTag", "enable", "enableLogging", "logger", "tag", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AndroidLog {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final Map<String, String> knownLoggers;
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    private AndroidLog() {
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r1 = OkHttpClient.class.getPackage();
        String name = r1 != null ? r1.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        linkedHashMap2.put(OkHttpClient.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap2.put(Http2.class.getName(), "okhttp.Http2");
        linkedHashMap2.put(TaskRunner.class.getName(), "okhttp.TaskRunner");
        linkedHashMap2.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = MapsKt.toMap(linkedHashMap2);
    }

    public static /* synthetic */ void androidLog$okhttp$default(AndroidLog androidLog, String str, int i, String str2, Throwable th, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            th = null;
        }
        androidLog.androidLog$okhttp(str, i, str2, th);
    }

    public final void androidLog$okhttp(String loggerName, int i, String message, Throwable th) {
        int min;
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Intrinsics.checkNotNullParameter(message, "message");
        String loggerTag = loggerTag(loggerName);
        if (Log.isLoggable(loggerTag, i)) {
            if (th != null) {
                message = message + '\n' + Log.getStackTraceString(th);
            }
            int length = message.length();
            int i2 = 0;
            while (i2 < length) {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) message, '\n', i2, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    indexOf$default = length;
                }
                while (true) {
                    min = Math.min(indexOf$default, i2 + MAX_LOG_LENGTH);
                    String substring = message.substring(i2, min);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    Log.println(i, loggerTag, substring);
                    if (min >= indexOf$default) {
                        break;
                    }
                    i2 = min;
                }
                i2 = min + 1;
            }
        }
    }

    private final String loggerTag(String str) {
        String str2 = knownLoggers.get(str);
        return str2 == null ? StringsKt.take(str, 23) : str2;
    }

    public final void enable() {
        try {
            for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
                enableLogging(entry.getKey(), entry.getValue());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private final void enableLogging(String str, String str2) {
        Level level;
        Logger logger = Logger.getLogger(str);
        if (configuredLoggers.add(logger)) {
            logger.setUseParentHandlers(false);
            if (Log.isLoggable(str2, 3)) {
                level = Level.FINE;
            } else {
                level = Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING;
            }
            logger.setLevel(level);
            logger.addHandler(AndroidLogHandler.INSTANCE);
        }
    }
}
