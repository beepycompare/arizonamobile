package com.arizona.launcher.updater.archive.download;

import androidx.compose.runtime.ComposerKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchivePackageDownloader.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.download.ArchivePackageDownloader", f = "ArchivePackageDownloader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {175, ComposerKt.providerMapsKey, 247, 263}, m = "download", n = {"request", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "parent", "displayedProgress", "retriesConsumed", "invalidResumeReset", "busyRetries", "reconnectWaitConsumed", "request", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "parent", "displayedProgress", "attempt", "retriesConsumed", "invalidResumeReset", "busyRetries", "reconnectWaitConsumed", "request", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "parent", "displayedProgress", "attempt", "details", "decision", "retriesConsumed", "invalidResumeReset", "busyRetries", "reconnectWaitConsumed", "request", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "parent", "displayedProgress", "attempt", "details", "decision", "retriesConsumed", "invalidResumeReset", "busyRetries", "reconnectWaitConsumed"}, nl = {186, ArchiveResumableHttpEngine.HTTP_RESET_CONTENT, 249, 228}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchivePackageDownloader$download$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchivePackageDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchivePackageDownloader$download$1(ArchivePackageDownloader archivePackageDownloader, Continuation<? super ArchivePackageDownloader$download$1> continuation) {
        super(continuation);
        this.this$0 = archivePackageDownloader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.download(null, null, this);
    }
}
