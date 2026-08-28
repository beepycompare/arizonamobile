package com.arizona.launcher;

import com.arizona.launcher.UpdateService;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckBlockCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"archiveCheckBlockErrno", "Lcom/arizona/launcher/UpdateService$Errno;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckBlockCode;", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateServiceKt {

    /* compiled from: UpdateService.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArchiveUpdateCheckBlockCode.values().length];
            try {
                iArr[ArchiveUpdateCheckBlockCode.ARCHIVE_INDEX_UNAVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final UpdateService.Errno archiveCheckBlockErrno(ArchiveUpdateCheckBlockCode code) {
        Intrinsics.checkNotNullParameter(code, "code");
        if (WhenMappings.$EnumSwitchMapping$0[code.ordinal()] == 1) {
            return UpdateService.Errno.UpdateServerUnreachable;
        }
        return UpdateService.Errno.ArchiveRecoveryBlocked;
    }
}
