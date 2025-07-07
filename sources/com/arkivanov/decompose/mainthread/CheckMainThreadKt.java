package com.arkivanov.decompose.mainthread;

import android.os.Looper;
import com.arkivanov.decompose.errorhandler.ErrorHandlersKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
/* compiled from: CheckMainThread.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0000\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"mainThreadId", "", "getMainThreadId", "()Ljava/lang/Long;", "mainThreadId$delegate", "Lkotlin/Lazy;", "checkMainThread", "", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CheckMainThreadKt {
    private static final Lazy mainThreadId$delegate = LazyKt.lazy(new Function0() { // from class: com.arkivanov.decompose.mainthread.CheckMainThreadKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Long mainThreadId_delegate$lambda$0;
            mainThreadId_delegate$lambda$0 = CheckMainThreadKt.mainThreadId_delegate$lambda$0();
            return mainThreadId_delegate$lambda$0;
        }
    });

    private static final Long getMainThreadId() {
        return (Long) mainThreadId$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long mainThreadId_delegate$lambda$0() {
        try {
            return Long.valueOf(Looper.getMainLooper().getThread().getId());
        } catch (Exception unused) {
            return null;
        }
    }

    public static final void checkMainThread() {
        if (getMainThreadId() != null) {
            long id = Thread.currentThread().getId();
            Long mainThreadId = getMainThreadId();
            if (mainThreadId != null && id == mainThreadId.longValue()) {
                return;
            }
            ErrorHandlersKt.getOnDecomposeError().invoke(new NotOnMainThreadException(Thread.currentThread().getName()));
        }
    }
}
