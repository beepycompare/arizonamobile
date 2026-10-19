package com.arizona.launcher;

import com.arizona.launcher.UpdateService;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckBlockCode;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionSnapshot;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0005*\u00020\tH\u0002¨\u0006\n"}, d2 = {"archiveCheckBlockErrno", "Lcom/arizona/launcher/UpdateService$Errno;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckBlockCode;", "shouldPurgeMapCache", "", "snapshot", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionSnapshot;", "isViceCityStateSensitive", "Lcom/arizona/launcher/UpdateOperationKind;", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateServiceKt {

    /* compiled from: UpdateService.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ArchiveUpdateCheckBlockCode.values().length];
            try {
                iArr[ArchiveUpdateCheckBlockCode.ARCHIVE_INDEX_UNAVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[UpdateOperationKind.values().length];
            try {
                iArr2[UpdateOperationKind.CHECK_UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[UpdateOperationKind.CHECK_AND_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[UpdateOperationKind.ARCHIVE_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[UpdateOperationKind.FILE_CHECK.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[UpdateOperationKind.LAUNCHER_CHECK.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[UpdateOperationKind.LAUNCHER_APK.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final UpdateService.Errno archiveCheckBlockErrno(ArchiveUpdateCheckBlockCode code) {
        Intrinsics.checkNotNullParameter(code, "code");
        if (WhenMappings.$EnumSwitchMapping$0[code.ordinal()] == 1) {
            return UpdateService.Errno.UpdateServerUnreachable;
        }
        return UpdateService.Errno.ArchiveRecoveryBlocked;
    }

    public static final boolean shouldPurgeMapCache(ArchiveUpdateSessionSnapshot snapshot) {
        List<ArchivePackage> packages;
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        ArchiveUpdatePlan plan = snapshot.getPlan();
        if (plan == null) {
            return false;
        }
        if (snapshot.isFinalizationOnly()) {
            packages = plan.getRemoteManifest().getPackages();
        } else {
            packages = plan.getPackages();
        }
        List<ArchivePackage> list = packages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (ArchivePackage archivePackage : list) {
            List<ArchiveEntryMetadata> entries = archivePackage.getEntries();
            if (entries == null) {
                entries = CollectionsKt.emptyList();
            }
            List<ArchiveEntryMetadata> list2 = entries;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                for (ArchiveEntryMetadata archiveEntryMetadata : list2) {
                    if (StringsKt.endsWith(archiveEntryMetadata.getTargetRelativePath(), "data.pkg", true)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isViceCityStateSensitive(UpdateOperationKind updateOperationKind) {
        switch (WhenMappings.$EnumSwitchMapping$1[updateOperationKind.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
