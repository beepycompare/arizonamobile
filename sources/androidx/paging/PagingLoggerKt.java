package androidx.paging;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PagingLogger.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0086\bø\u0001\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"LOG_TAG", "", "log", "", FirebaseAnalytics.Param.LEVEL, "", "tr", "", "block", "Lkotlin/Function0;", "VERBOSE", "DEBUG", "paging-common"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PagingLoggerKt {
    public static final int DEBUG = 3;
    public static final String LOG_TAG = "Paging";
    public static final int VERBOSE = 2;

    public static /* synthetic */ void log$default(int i, Throwable th, Function0 block, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        PagingLogger pagingLogger = PagingLogger.INSTANCE;
        if (pagingLogger.isLoggable(i)) {
            pagingLogger.log(i, (String) block.invoke(), th);
        }
    }

    public static final void log(int i, Throwable th, Function0<String> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        PagingLogger pagingLogger = PagingLogger.INSTANCE;
        if (pagingLogger.isLoggable(i)) {
            pagingLogger.log(i, block.invoke(), th);
        }
    }
}
