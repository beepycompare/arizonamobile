package com.arizona.launcher.updater.archive.orchestrator;

import coil3.disk.DiskLruCache;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveSelectivePackageInstaller.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveSelectivePackageInstaller", f = "ArchiveSelectivePackageInstaller.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {82, 170}, m = "probe", n = {"archivePackage", DiskLruCache.JOURNAL_FILE, "serverBaseUrl", "desired", "diff", "requestUrl", "archivePackage", DiskLruCache.JOURNAL_FILE, "serverBaseUrl", "desired", "diff", "requestUrl", "fetched", "observedFence", "eligibility", "remoteByTarget", "reusable", "unresolved", "rangeSession", "sortedOffsets", "transfers", "desiredFile", "remote", "preflightBytes", "payloadBytes", "nextOffset"}, nl = {81, 171}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "J$0", "J$1", "J$2"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveSelectivePackageInstaller$probe$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$16;
    Object L$17;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchiveSelectivePackageInstaller this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveSelectivePackageInstaller$probe$1(ArchiveSelectivePackageInstaller archiveSelectivePackageInstaller, Continuation<? super ArchiveSelectivePackageInstaller$probe$1> continuation) {
        super(continuation);
        this.this$0 = archiveSelectivePackageInstaller;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.probe(null, null, null, this);
    }
}
