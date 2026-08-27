package com.arizona.launcher.updater.archive.download;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveDownloadResumeSidecar.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadDestinationRegistry;", "", "<init>", "()V", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/arizona/launcher/updater/archive/download/ArchiveOwnedDownloadSession;", "tryAcquire", "", "destinationKey", "session", "release", "", FirebaseAnalytics.Param.DESTINATION, "Ljava/io/File;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveDownloadDestinationRegistry {
    public static final int $stable = 0;
    public static final ArchiveDownloadDestinationRegistry INSTANCE = new ArchiveDownloadDestinationRegistry();
    private static final ConcurrentHashMap<String, ArchiveOwnedDownloadSession> active = new ConcurrentHashMap<>();

    private ArchiveDownloadDestinationRegistry() {
    }

    public final boolean tryAcquire(String destinationKey, ArchiveOwnedDownloadSession session) {
        Intrinsics.checkNotNullParameter(destinationKey, "destinationKey");
        Intrinsics.checkNotNullParameter(session, "session");
        return active.putIfAbsent(destinationKey, session) == null;
    }

    public final void release(String destinationKey, ArchiveOwnedDownloadSession session) {
        Intrinsics.checkNotNullParameter(destinationKey, "destinationKey");
        Intrinsics.checkNotNullParameter(session, "session");
        active.remove(destinationKey, session);
    }

    public final String destinationKey(File destination) {
        String m9919constructorimpl;
        Intrinsics.checkNotNullParameter(destination, "destination");
        try {
            Result.Companion companion = Result.Companion;
            ArchiveDownloadDestinationRegistry archiveDownloadDestinationRegistry = this;
            m9919constructorimpl = Result.m9919constructorimpl(destination.getCanonicalFile().getPath());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9922exceptionOrNullimpl(m9919constructorimpl) != null) {
            File absoluteFile = destination.getAbsoluteFile();
            Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
            m9919constructorimpl = FilesKt.normalize(absoluteFile).getPath();
        }
        Intrinsics.checkNotNullExpressionValue(m9919constructorimpl, "getOrElse(...)");
        return (String) m9919constructorimpl;
    }
}
