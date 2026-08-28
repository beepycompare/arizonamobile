package com.arizona.launcher.updater.archive.orchestrator;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveSelectivePackageInstaller.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveSelectivePackageInstaller", f = "ArchiveSelectivePackageInstaller.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {264}, m = "install", n = {"archivePackage", "session", "stagingRoot", "onNetworkProgress", "fence", "rangeSession", "fetchedBytes", "staged", "transfer", "desired", TypedValues.AttributesType.S_TARGET, "networkCap"}, nl = {272}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "J$0"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveSelectivePackageInstaller$install$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
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
    public ArchiveSelectivePackageInstaller$install$1(ArchiveSelectivePackageInstaller archiveSelectivePackageInstaller, Continuation<? super ArchiveSelectivePackageInstaller$install$1> continuation) {
        super(continuation);
        this.this$0 = archiveSelectivePackageInstaller;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.install(null, null, null, null, this);
    }
}
