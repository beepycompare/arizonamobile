package com.arizona.launcher.updater.apk;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LauncherApkDownloader.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.apk.LauncherApkDownloader", f = "LauncherApkDownloader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {261}, m = "executeAttempt", n = {"request", "preparation", "observer", "currentUrl", "visited", "networkRequest", "attempt", "redirects"}, nl = {260}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 2)
/* loaded from: classes3.dex */
public final class LauncherApkDownloader$executeAttempt$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LauncherApkDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherApkDownloader$executeAttempt$1(LauncherApkDownloader launcherApkDownloader, Continuation<? super LauncherApkDownloader$executeAttempt$1> continuation) {
        super(continuation);
        this.this$0 = launcherApkDownloader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object executeAttempt;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        executeAttempt = this.this$0.executeAttempt(null, null, 0, null, this);
        return executeAttempt;
    }
}
