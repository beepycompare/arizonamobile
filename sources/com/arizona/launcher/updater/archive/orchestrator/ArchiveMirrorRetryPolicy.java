package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.DownloadFailureDetails;
import com.arizona.launcher.DownloadFailureKind;
import com.arizona.launcher.DownloadRetryPolicy;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloadErrorCode;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterResult;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveMirrorRetryPolicy.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ \u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMirrorRetryPolicy;", "", "<init>", "()V", "mirrorLagHttpStatuses", "", "", "shouldRotateDownloadMirror", "", "result", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;", "hasValidatedNetwork", "shouldRotateCheckMirror", "blockCode", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckBlockCode;", "attemptsLeft", "isEligibleNetworkRetryFailure", "details", "Lcom/arizona/launcher/DownloadFailureDetails;", "isArchiveMirrorLagFailure", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveMirrorRetryPolicy {
    public static final int $stable = 0;
    public static final ArchiveMirrorRetryPolicy INSTANCE = new ArchiveMirrorRetryPolicy();
    private static final Set<Integer> mirrorLagHttpStatuses = SetsKt.setOf((Object[]) new Integer[]{404, 410});

    /* compiled from: ArchiveMirrorRetryPolicy.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadFailureKind.values().length];
            try {
                iArr[DownloadFailureKind.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DownloadFailureKind.TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DownloadFailureKind.DNS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DownloadFailureKind.HTTP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DownloadFailureKind.IO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DownloadFailureKind.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ArchiveMirrorRetryPolicy() {
    }

    public final boolean shouldRotateDownloadMirror(ArchiveUpdaterResult.Failure result, boolean z) {
        DownloadFailureDetails downloadFailure;
        Intrinsics.checkNotNullParameter(result, "result");
        if (z) {
            if (result.getCode() == ArchiveUpdaterErrorCode.ARCHIVE_VERIFICATION_FAILED || result.getDownloadErrorCode() == ArchivePackageDownloadErrorCode.CONTENT_LENGTH_MISMATCH) {
                return true;
            }
            if (result.getCode() == ArchiveUpdaterErrorCode.DOWNLOAD_FAILED && (downloadFailure = result.getDownloadFailure()) != null) {
                ArchiveMirrorRetryPolicy archiveMirrorRetryPolicy = INSTANCE;
                if (archiveMirrorRetryPolicy.isEligibleNetworkRetryFailure(downloadFailure) || archiveMirrorRetryPolicy.isArchiveMirrorLagFailure(downloadFailure)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final boolean shouldRotateCheckMirror(ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode, int i, boolean z) {
        if (i <= 1 || !z) {
            return false;
        }
        return archiveUpdateCheckBlockCode == ArchiveUpdateCheckBlockCode.ARCHIVE_INDEX_UNAVAILABLE || archiveUpdateCheckBlockCode == ArchiveUpdateCheckBlockCode.ARCHIVE_REPRESENTATION_CHANGED;
    }

    public final boolean isEligibleNetworkRetryFailure(DownloadFailureDetails details) {
        Intrinsics.checkNotNullParameter(details, "details");
        switch (WhenMappings.$EnumSwitchMapping$0[details.getKind().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            case 4:
                return CollectionsKt.contains(DownloadRetryPolicy.Companion.getRETRYABLE_HTTP_STATUSES(), details.getHttpStatus());
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isArchiveMirrorLagFailure(DownloadFailureDetails details) {
        Intrinsics.checkNotNullParameter(details, "details");
        return details.getKind() == DownloadFailureKind.HTTP && CollectionsKt.contains(mirrorLagHttpStatuses, details.getHttpStatus());
    }
}
