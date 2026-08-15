package com.arizona.launcher.updater.archive.orchestrator;

import android.os.StatFs;
import android.system.Os;
import androidx.media3.exoplayer.offline.DownloadService;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageSpaceChecker;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveStorageSpaceChecker.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B=\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\"\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ!\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0005H\u0002R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageSpaceChecker;", "", "storageDeviceId", "Lkotlin/Function1;", "Ljava/io/File;", "", "availableBytes", "reserveBytes", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;J)V", "hasEnoughSpace", "", "gameRoot", "downloadRoot", DownloadService.KEY_REQUIREMENTS, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsSnapshot;", "usesSingleStorageDevice", "(Ljava/io/File;Ljava/io/File;)Ljava/lang/Boolean;", "hasAvailableBytesWithReserve", "root", "requiredBytes", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStorageSpaceChecker {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Function1<File, Long> availableBytes;
    private final long reserveBytes;
    private final Function1<File, Long> storageDeviceId;

    /* JADX WARN: Multi-variable type inference failed */
    public ArchiveStorageSpaceChecker(Function1<? super File, Long> storageDeviceId, Function1<? super File, Long> availableBytes, long j) {
        Intrinsics.checkNotNullParameter(storageDeviceId, "storageDeviceId");
        Intrinsics.checkNotNullParameter(availableBytes, "availableBytes");
        this.storageDeviceId = storageDeviceId;
        this.availableBytes = availableBytes;
        this.reserveBytes = j;
        if (j < 0) {
            throw new IllegalArgumentException("archive free-space reserve must be nonnegative".toString());
        }
    }

    public /* synthetic */ ArchiveStorageSpaceChecker(Function1 function1, Function1 function12, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, (i & 4) != 0 ? ArchiveStorageEstimatorKt.ARCHIVE_FREE_SPACE_RESERVE_BYTES : j);
    }

    public final boolean hasEnoughSpace(File file, File file2, ArchiveStorageRequirementsSnapshot requirements) {
        Boolean usesSingleStorageDevice;
        long gameStorageBytes;
        Intrinsics.checkNotNullParameter(requirements, "requirements");
        if (file != null && file2 != null && (usesSingleStorageDevice = usesSingleStorageDevice(file, file2)) != null) {
            boolean booleanValue = usesSingleStorageDevice.booleanValue();
            if (booleanValue) {
                gameStorageBytes = requirements.getRequiredFreeSpaceBytes();
            } else {
                gameStorageBytes = requirements.getGameStorageBytes();
            }
            boolean hasAvailableBytesWithReserve = hasAvailableBytesWithReserve(file, gameStorageBytes);
            if (booleanValue) {
                return hasAvailableBytesWithReserve;
            }
            if (hasAvailableBytesWithReserve && hasAvailableBytesWithReserve(file2, requirements.getDownloadStorageBytes())) {
                return true;
            }
        }
        return false;
    }

    public final Boolean usesSingleStorageDevice(File file, File file2) {
        Long invoke;
        if (file != null && file2 != null && (invoke = this.storageDeviceId.invoke(file)) != null) {
            long longValue = invoke.longValue();
            Long invoke2 = this.storageDeviceId.invoke(file2);
            if (invoke2 != null) {
                return Boolean.valueOf(longValue == invoke2.longValue());
            }
        }
        return null;
    }

    private final boolean hasAvailableBytesWithReserve(File file, long j) {
        long addExact;
        Long invoke;
        try {
            addExact = Math.addExact(j, this.reserveBytes);
            invoke = this.availableBytes.invoke(file);
        } catch (ArithmeticException unused) {
        }
        return invoke != null && invoke.longValue() >= addExact;
    }

    /* compiled from: ArchiveStorageSpaceChecker.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u00020\u00052:\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0017\u0012\u00150\fj\u0002`\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000f0\u0007¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageSpaceChecker$Companion;", "", "<init>", "()V", ConstantDeviceInfo.APP_PLATFORM, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageSpaceChecker;", "onInspectionFailure", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "message", "Ljava/lang/Exception;", "error", "Lkotlin/Exception;", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchiveStorageSpaceChecker android(final Function2<? super String, ? super Exception, Unit> onInspectionFailure) {
            Intrinsics.checkNotNullParameter(onInspectionFailure, "onInspectionFailure");
            return new ArchiveStorageSpaceChecker(new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageSpaceChecker$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ArchiveStorageSpaceChecker.Companion.android$lambda$0(Function2.this, (File) obj);
                }
            }, new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageSpaceChecker$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ArchiveStorageSpaceChecker.Companion.android$lambda$1(Function2.this, (File) obj);
                }
            }, 0L, 4, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Long android$lambda$0(Function2 function2, File root) {
            Intrinsics.checkNotNullParameter(root, "root");
            try {
                return Long.valueOf(Os.stat(root.getAbsolutePath()).st_dev);
            } catch (Exception e) {
                function2.invoke("Unable to inspect archive storage topology at " + root.getAbsolutePath(), e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Long android$lambda$1(Function2 function2, File root) {
            Intrinsics.checkNotNullParameter(root, "root");
            try {
                return Long.valueOf(new StatFs(root.getAbsolutePath()).getAvailableBytes());
            } catch (RuntimeException e) {
                function2.invoke("Unable to inspect archive free space at " + root.getAbsolutePath(), e);
                return null;
            }
        }
    }
}
