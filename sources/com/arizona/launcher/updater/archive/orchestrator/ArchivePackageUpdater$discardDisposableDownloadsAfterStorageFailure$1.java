package com.arizona.launcher.updater.archive.orchestrator;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater", f = "ArchivePackageUpdater.kt", i = {0, 0}, l = {1063}, m = "discardDisposableDownloadsAfterStorageFailure", n = {"slot", RemoteConfigConstants.ResponseFieldKey.STATE}, nl = {1065}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchivePackageUpdater this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1(ArchivePackageUpdater archivePackageUpdater, Continuation<? super ArchivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1> continuation) {
        super(continuation);
        this.this$0 = archivePackageUpdater;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object discardDisposableDownloadsAfterStorageFailure;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        discardDisposableDownloadsAfterStorageFailure = this.this$0.discardDisposableDownloadsAfterStorageFailure(null, null, this);
        return discardDisposableDownloadsAfterStorageFailure;
    }
}
