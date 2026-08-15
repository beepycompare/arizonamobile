package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.download.ArchiveDownloadListener;
import com.arizona.launcher.updater.archive.download.ArchiveDownloadRequest;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloadResult;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadClient;", "", "download", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult;", "request", "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadRequest;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadListener;", "(Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadRequest;Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveDownloadClient {
    Object download(ArchiveDownloadRequest archiveDownloadRequest, ArchiveDownloadListener archiveDownloadListener, Continuation<? super ArchivePackageDownloadResult> continuation);
}
