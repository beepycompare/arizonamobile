package com.arizona.launcher;

import kotlin.Metadata;
/* compiled from: LauncherUpdateLifecyclePolicy.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007Ê\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/LauncherUpdateLifecyclePolicy;", "", "<init>", "()V", "checkRequest", "Lcom/arizona/launcher/LauncherCheckRequestDisposition;", "activeOperation", "Lcom/arizona/launcher/UpdateOperationSnapshot;", "hasReadyApk", "", "apkRequest", "Lcom/arizona/launcher/LauncherApkRequestDisposition;", "mayReplaceActivityRecipient", "messageCode", "", "keepRunningAfterTaskRemoved", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherUpdateLifecyclePolicy {
    public static final int $stable = 0;
    public static final LauncherUpdateLifecyclePolicy INSTANCE = new LauncherUpdateLifecyclePolicy();

    /* compiled from: LauncherUpdateLifecyclePolicy.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpdateOperationKind.values().length];
            try {
                iArr[UpdateOperationKind.LAUNCHER_APK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UpdateOperationKind.LAUNCHER_CHECK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private LauncherUpdateLifecyclePolicy() {
    }

    public final LauncherCheckRequestDisposition checkRequest(UpdateOperationSnapshot updateOperationSnapshot, boolean z) {
        UpdateOperationKind kind = updateOperationSnapshot != null ? updateOperationSnapshot.getKind() : null;
        int i = kind == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (z) {
                    return LauncherCheckRequestDisposition.REPLAY_READY_APK;
                }
                return LauncherCheckRequestDisposition.START_CHECK;
            }
            return LauncherCheckRequestDisposition.REATTACH_ACTIVE_CHECK;
        }
        return LauncherCheckRequestDisposition.ROUTE_TO_ACTIVE_APK;
    }

    public final LauncherApkRequestDisposition apkRequest(UpdateOperationSnapshot updateOperationSnapshot, boolean z) {
        if ((updateOperationSnapshot != null ? updateOperationSnapshot.getKind() : null) == UpdateOperationKind.LAUNCHER_APK) {
            return LauncherApkRequestDisposition.REATTACH_ACTIVE_APK;
        }
        if (z) {
            return LauncherApkRequestDisposition.REPLAY_READY_APK;
        }
        return LauncherApkRequestDisposition.START_APK;
    }

    public final boolean mayReplaceActivityRecipient(UpdateOperationSnapshot updateOperationSnapshot, int i) {
        return (updateOperationSnapshot != null ? updateOperationSnapshot.getKind() : null) != UpdateOperationKind.LAUNCHER_APK || i == 6;
    }

    public final boolean keepRunningAfterTaskRemoved(UpdateOperationSnapshot updateOperationSnapshot) {
        return (updateOperationSnapshot != null ? updateOperationSnapshot.getKind() : null) == UpdateOperationKind.LAUNCHER_APK;
    }
}
