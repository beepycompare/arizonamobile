package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.download.ArchiveDownloadRequest;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloadResult;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloader;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
/* compiled from: ArchiveBootstrapPrefetcher.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class ArchiveBootstrapPrefetcher$Companion$forAndroid$1 extends AdaptedFunctionReference implements Function2<ArchiveDownloadRequest, Continuation<? super ArchivePackageDownloadResult>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ArchiveBootstrapPrefetcher$Companion$forAndroid$1(Object obj) {
        super(2, obj, ArchivePackageDownloader.class, "download", "download(Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadRequest;Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ArchiveDownloadRequest archiveDownloadRequest, Continuation<? super ArchivePackageDownloadResult> continuation) {
        return ArchivePackageDownloader.download$default((ArchivePackageDownloader) this.receiver, archiveDownloadRequest, null, continuation, 2, null);
    }
}
