package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.download.ArchiveDownloadListener;
import com.arizona.launcher.updater.archive.download.ArchiveDownloadRequest;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloadResult;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloader;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class ArchivePackageUpdater$Companion$create$1 implements ArchiveDownloadClient, FunctionAdapter {
    final /* synthetic */ ArchivePackageDownloader $tmp0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArchivePackageUpdater$Companion$create$1(ArchivePackageDownloader archivePackageDownloader) {
        this.$tmp0 = archivePackageDownloader;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ArchiveDownloadClient) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(3, this.$tmp0, ArchivePackageDownloader.class, "download", "download(Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadRequest;Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveDownloadClient
    public final Object download(ArchiveDownloadRequest archiveDownloadRequest, ArchiveDownloadListener archiveDownloadListener, Continuation<? super ArchivePackageDownloadResult> continuation) {
        return this.$tmp0.download(archiveDownloadRequest, archiveDownloadListener, continuation);
    }
}
