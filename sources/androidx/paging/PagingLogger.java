package androidx.paging;

import android.os.Build;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PagingLogger.android.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"Landroidx/paging/PagingLogger;", "", "<init>", "()V", "isLoggable", "", FirebaseAnalytics.Param.LEVEL, "", "log", "", "message", "", "tr", "", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PagingLogger {
    public static final PagingLogger INSTANCE = new PagingLogger();

    private PagingLogger() {
    }

    public final boolean isLoggable(int i) {
        return Build.ID != null && Log.isLoggable(PagingLoggerKt.LOG_TAG, i);
    }

    public static /* synthetic */ void log$default(PagingLogger pagingLogger, int i, String str, Throwable th, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            th = null;
        }
        pagingLogger.log(i, str, th);
    }

    public final void log(int i, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (i == 2) {
            Log.v(PagingLoggerKt.LOG_TAG, message, th);
        } else if (i == 3) {
            Log.d(PagingLoggerKt.LOG_TAG, message, th);
        } else {
            throw new IllegalArgumentException("debug level " + i + " is requested but Paging only supports default logging for level 2 (VERBOSE) or level 3 (DEBUG)");
        }
    }
}
