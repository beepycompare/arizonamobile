package com.arizona.launcher.updater.archive.orchestrator;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteZipIndexFetcher.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.RemoteZipIndexFetcher", f = "RemoteZipIndexFetcher.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {37, 84}, m = RemoteConfigComponent.FETCH_FILE_NAME, n = {"packageId", "archiveUrl", "archiveSize", "tailStart", "packageId", "archiveUrl", "tail", FirebaseAnalytics.Param.LOCATION, "fence", "archiveSize", "tailStart", "centralDirectoryEnd", "fetchedBytes"}, nl = {46, 94}, s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1", "J$2", "J$3"}, v = 2)
/* loaded from: classes3.dex */
public final class RemoteZipIndexFetcher$fetch$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    long J$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteZipIndexFetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteZipIndexFetcher$fetch$1(RemoteZipIndexFetcher remoteZipIndexFetcher, Continuation<? super RemoteZipIndexFetcher$fetch$1> continuation) {
        super(continuation);
        this.this$0 = remoteZipIndexFetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetch(null, null, 0L, this);
    }
}
