package com.arizona.launcher.updater.archive.download;

import androidx.exifinterface.media.ExifInterface;
import com.arizona.launcher.DownloadFailureDetails;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloadResult;
import com.facebook.widget.FacebookDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
/* compiled from: ArchivePackageDownloader.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aQ\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\u0000¢\u0006\u0002\u0010\t\u001aS\u0010\n\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000b\u001a\u00020\f2'\u0010\r\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0080@¢\u0006\u0002\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002¨\u0006\u001b"}, d2 = {"cancelExactOwnedTask", "", ExifInterface.GPS_DIRECTION_TRUE, "", "monitor", "candidate", "findActive", "Lkotlin/Function1;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Z", "runDrainedOwnedBlockingTask", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "execute", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "ensureActiveAtTaskStart", "cancelIfOwned", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "failure", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult$Failure;", "code", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadErrorCode;", "details", "Lcom/arizona/launcher/DownloadFailureDetails;", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageDownloaderKt {
    public static final <T> boolean cancelExactOwnedTask(Object monitor, T candidate, Function1<? super T, ? extends T> findActive, Function1<? super T, Boolean> cancel) {
        boolean z;
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        Intrinsics.checkNotNullParameter(findActive, "findActive");
        Intrinsics.checkNotNullParameter(cancel, "cancel");
        synchronized (monitor) {
            if (findActive.invoke(candidate) == candidate) {
                z = cancel.invoke(candidate).booleanValue();
            }
        }
        return z;
    }

    public static final <T> Object runDrainedOwnedBlockingTask(CoroutineDispatcher coroutineDispatcher, Function1<? super Function0<Unit>, ? extends T> function1, Function0<Unit> function0, Continuation<? super T> continuation) {
        return SupervisorKt.supervisorScope(new ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2(coroutineDispatcher, function0, function1, null), continuation);
    }

    public static /* synthetic */ ArchivePackageDownloadResult.Failure failure$default(ArchivePackageDownloadErrorCode archivePackageDownloadErrorCode, DownloadFailureDetails downloadFailureDetails, int i, Object obj) {
        if ((i & 2) != 0) {
            downloadFailureDetails = null;
        }
        return failure(archivePackageDownloadErrorCode, downloadFailureDetails);
    }

    public static final ArchivePackageDownloadResult.Failure failure(ArchivePackageDownloadErrorCode archivePackageDownloadErrorCode, DownloadFailureDetails downloadFailureDetails) {
        return new ArchivePackageDownloadResult.Failure(archivePackageDownloadErrorCode, downloadFailureDetails);
    }
}
