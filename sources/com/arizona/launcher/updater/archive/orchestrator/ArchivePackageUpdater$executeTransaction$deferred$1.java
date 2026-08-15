package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.download.ArchiveDownloadListener;
import com.arizona.launcher.updater.archive.download.ArchiveDownloadRequest;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloadResult;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater$executeTransaction$deferred$1", f = "ArchivePackageUpdater.kt", i = {}, l = {477}, m = "invokeSuspend", n = {}, nl = {494}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class ArchivePackageUpdater$executeTransaction$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchivePackageDownloadResult>, Object> {
    final /* synthetic */ ArchiveUpdaterListener $listener;
    final /* synthetic */ ArchivePackageUpdater.DownloadNetworkPhaseRelay $networkPhaseRelay;
    final /* synthetic */ ArchivePackage $nextPackage;
    final /* synthetic */ String $nextUrl;
    final /* synthetic */ long $packageBase;
    final /* synthetic */ Ref.LongRef $totalDownloadBytes;
    int label;
    final /* synthetic */ ArchivePackageUpdater this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchivePackageUpdater$executeTransaction$deferred$1(ArchivePackageUpdater archivePackageUpdater, ArchivePackage archivePackage, String str, long j, Ref.LongRef longRef, ArchiveUpdaterListener archiveUpdaterListener, ArchivePackageUpdater.DownloadNetworkPhaseRelay downloadNetworkPhaseRelay, Continuation<? super ArchivePackageUpdater$executeTransaction$deferred$1> continuation) {
        super(2, continuation);
        this.this$0 = archivePackageUpdater;
        this.$nextPackage = archivePackage;
        this.$nextUrl = str;
        this.$packageBase = j;
        this.$totalDownloadBytes = longRef;
        this.$listener = archiveUpdaterListener;
        this.$networkPhaseRelay = downloadNetworkPhaseRelay;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArchivePackageUpdater$executeTransaction$deferred$1(this.this$0, this.$nextPackage, this.$nextUrl, this.$packageBase, this.$totalDownloadBytes, this.$listener, this.$networkPhaseRelay, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchivePackageDownloadResult> continuation) {
        return ((ArchivePackageUpdater$executeTransaction$deferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ArchiveDownloadClient archiveDownloadClient;
        File file;
        ArchiveDownloadListener forwardingDownloadListener;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        archiveDownloadClient = this.this$0.downloadClient;
        String id = this.$nextPackage.getId();
        String str = this.$nextUrl;
        ArchivePackagePaths archivePackagePaths = ArchivePackagePaths.INSTANCE;
        file = this.this$0.downloadRoot;
        ArchiveDownloadRequest archiveDownloadRequest = new ArchiveDownloadRequest(id, str, archivePackagePaths.archiveFile(file, this.$nextPackage), this.$nextPackage.getArchiveSize(), this.$nextPackage.getCrc32());
        forwardingDownloadListener = this.this$0.forwardingDownloadListener(this.$packageBase, this.$totalDownloadBytes.element, this.$listener, this.$networkPhaseRelay);
        this.label = 1;
        Object download = archiveDownloadClient.download(archiveDownloadRequest, forwardingDownloadListener, this);
        return download == coroutine_suspended ? coroutine_suspended : download;
    }
}
