package com.arizona.launcher.updater.apk;

import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LauncherApkDownloader.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.apk.LauncherApkDownloader", f = "LauncherApkDownloader.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {167, ComposerKt.compositionLocalMapKey}, m = "downloadOwned", n = {"request", "observer", "preparation", "attempt", "resumedFrom", "request", "observer", "preparation", "outcome", "attempt", "resumedFrom", "nextAttempt", "delayMs"}, nl = {168, ComposerKt.providerValuesKey}, s = {"L$0", "L$1", "L$2", "I$0", "J$0", "L$0", "L$1", "L$2", "L$3", "I$0", "J$0", "I$1", "J$1"}, v = 2)
/* loaded from: classes3.dex */
public final class LauncherApkDownloader$downloadOwned$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LauncherApkDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherApkDownloader$downloadOwned$1(LauncherApkDownloader launcherApkDownloader, Continuation<? super LauncherApkDownloader$downloadOwned$1> continuation) {
        super(continuation);
        this.this$0 = launcherApkDownloader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object downloadOwned;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        downloadOwned = this.this$0.downloadOwned(null, null, this);
        return downloadOwned;
    }
}
