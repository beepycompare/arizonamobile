package com.arizona.launcher.updater.apk;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LauncherApkDownloader.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.apk.LauncherApkDownloader", f = "LauncherApkDownloader.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {1120, 465}, m = "executeHop", n = {"networkRequest", "request", "preparation", "observer", NotificationCompat.CATEGORY_CALL, "drained", "attempt", "networkRequest", "request", "preparation", "observer", NotificationCompat.CATEGORY_CALL, "drained", "cancelled", "attempt"}, nl = {1120, 466}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 2)
/* loaded from: classes3.dex */
public final class LauncherApkDownloader$executeHop$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LauncherApkDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherApkDownloader$executeHop$1(LauncherApkDownloader launcherApkDownloader, Continuation<? super LauncherApkDownloader$executeHop$1> continuation) {
        super(continuation);
        this.this$0 = launcherApkDownloader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object executeHop;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        executeHop = this.this$0.executeHop(null, null, null, 0, null, this);
        return executeHop;
    }
}
