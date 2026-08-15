package com.arizona.launcher.updater.archive.orchestrator;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.RemoteOriginalTzArchivePackageIndexSource", f = "ArchiveManifestResolver.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {624, 667}, m = "read", n = {"packageDescriptor", "serverBaseUrl", "archiveUrl", "tailStart", "packageDescriptor", "serverBaseUrl", "archiveUrl", "tail", FirebaseAnalytics.Param.LOCATION, "fence", "tailStart", "centralDirectoryEnd"}, nl = {633, 677}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "J$1"}, v = 2)
/* loaded from: classes3.dex */
public final class RemoteOriginalTzArchivePackageIndexSource$read$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteOriginalTzArchivePackageIndexSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteOriginalTzArchivePackageIndexSource$read$1(RemoteOriginalTzArchivePackageIndexSource remoteOriginalTzArchivePackageIndexSource, Continuation<? super RemoteOriginalTzArchivePackageIndexSource$read$1> continuation) {
        super(continuation);
        this.this$0 = remoteOriginalTzArchivePackageIndexSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.read(null, null, this);
    }
}
