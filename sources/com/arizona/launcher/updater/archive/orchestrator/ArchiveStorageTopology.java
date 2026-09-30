package com.arizona.launcher.updater.archive.orchestrator;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.system.Os;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageTopology;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.io.File;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveStorageTopology.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB1\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageTopology;", "", "deviceId", "Lkotlin/Function1;", "Ljava/io/File;", "", "volumeId", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "usesSingleStorageDevice", "", "first", "second", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStorageTopology {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Function1<File, Long> deviceId;
    private final Function1<File, String> volumeId;

    /* JADX WARN: Multi-variable type inference failed */
    public ArchiveStorageTopology(Function1<? super File, Long> deviceId, Function1<? super File, String> volumeId) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(volumeId, "volumeId");
        this.deviceId = deviceId;
        this.volumeId = volumeId;
    }

    public final boolean usesSingleStorageDevice(File first, File second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        if (this.deviceId.invoke(first).longValue() == this.deviceId.invoke(second).longValue()) {
            return true;
        }
        String invoke = this.volumeId.invoke(first);
        String invoke2 = this.volumeId.invoke(second);
        if (invoke == null || invoke2 == null) {
            return true;
        }
        return Intrinsics.areEqual(invoke, invoke2);
    }

    /* compiled from: ArchiveStorageTopology.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageTopology$Companion;", "", "<init>", "()V", ConstantDeviceInfo.APP_PLATFORM, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageTopology;", "context", "Landroid/content/Context;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchiveStorageTopology android(final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new ArchiveStorageTopology(new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageTopology$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Long.valueOf(ArchiveStorageTopology.Companion.android$lambda$0((File) obj));
                }
            }, new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageTopology$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ArchiveStorageTopology.Companion.android$lambda$1(context, (File) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final long android$lambda$0(File it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Os.stat(it.getAbsolutePath()).st_dev;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final String android$lambda$1(Context context, File root) {
            UUID uuid;
            Object m9921constructorimpl;
            StorageVolume storageVolume;
            Object m9921constructorimpl2;
            Intrinsics.checkNotNullParameter(root, "root");
            StorageManager storageManager = (StorageManager) context.getSystemService(StorageManager.class);
            if (Build.VERSION.SDK_INT >= 26) {
                Companion companion = ArchiveStorageTopology.Companion;
                try {
                    Result.Companion companion2 = Result.Companion;
                    m9921constructorimpl2 = Result.m9921constructorimpl(storageManager != null ? storageManager.getUuidForPath(root) : null);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.Companion;
                    m9921constructorimpl2 = Result.m9921constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m9927isFailureimpl(m9921constructorimpl2)) {
                    m9921constructorimpl2 = null;
                }
                uuid = (UUID) m9921constructorimpl2;
            } else {
                uuid = null;
            }
            String str = "default";
            if (uuid != null) {
                if (Intrinsics.areEqual(uuid, StorageManager.UUID_DEFAULT)) {
                    return "default";
                }
                String uuid2 = uuid.toString();
                Intrinsics.checkNotNull(uuid2);
                return uuid2;
            }
            Companion companion4 = ArchiveStorageTopology.Companion;
            try {
                Result.Companion companion5 = Result.Companion;
                if (Os.stat(root.getAbsolutePath()).st_dev != Os.stat(Environment.getDataDirectory().getAbsolutePath()).st_dev) {
                    if (storageManager != null && (storageVolume = storageManager.getStorageVolume(root)) != null) {
                        String uuid3 = storageVolume.getUuid();
                        if (uuid3 != null) {
                            Locale ROOT = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                            String lowerCase = uuid3.toLowerCase(ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            if (lowerCase != null) {
                                str = lowerCase;
                            }
                        }
                        if (storageVolume.isEmulated()) {
                        }
                    }
                    str = null;
                }
                m9921constructorimpl = Result.m9921constructorimpl(str);
            } catch (Throwable th2) {
                Result.Companion companion6 = Result.Companion;
                m9921constructorimpl = Result.m9921constructorimpl(ResultKt.createFailure(th2));
            }
            return Result.m9927isFailureimpl(m9921constructorimpl) ? null : m9921constructorimpl;
        }
    }
}
