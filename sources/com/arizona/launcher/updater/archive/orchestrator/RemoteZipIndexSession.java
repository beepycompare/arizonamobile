package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.range.ArchiveObservedRepresentationFence;
import com.arizona.launcher.updater.archive.range.RemoteZipIndex;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RemoteZipIndexFetcher.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013Ê\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexSession;", "", FirebaseAnalytics.Param.INDEX, "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndex;", "observedFence", "Lcom/arizona/launcher/updater/archive/range/ArchiveObservedRepresentationFence;", "effectiveUrl", "", "fetchedBytes", "", "<init>", "(Lcom/arizona/launcher/updater/archive/range/RemoteZipIndex;Lcom/arizona/launcher/updater/archive/range/ArchiveObservedRepresentationFence;Ljava/lang/String;J)V", "getIndex", "()Lcom/arizona/launcher/updater/archive/range/RemoteZipIndex;", "getObservedFence", "()Lcom/arizona/launcher/updater/archive/range/ArchiveObservedRepresentationFence;", "getEffectiveUrl", "()Ljava/lang/String;", "getFetchedBytes", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteZipIndexSession {
    public static final int $stable = ArchiveObservedRepresentationFence.$stable | RemoteZipIndex.$stable;
    private final String effectiveUrl;
    private final long fetchedBytes;
    private final RemoteZipIndex index;
    private final ArchiveObservedRepresentationFence observedFence;

    public static /* synthetic */ RemoteZipIndexSession copy$default(RemoteZipIndexSession remoteZipIndexSession, RemoteZipIndex remoteZipIndex, ArchiveObservedRepresentationFence archiveObservedRepresentationFence, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            remoteZipIndex = remoteZipIndexSession.index;
        }
        if ((i & 2) != 0) {
            archiveObservedRepresentationFence = remoteZipIndexSession.observedFence;
        }
        if ((i & 4) != 0) {
            str = remoteZipIndexSession.effectiveUrl;
        }
        if ((i & 8) != 0) {
            j = remoteZipIndexSession.fetchedBytes;
        }
        String str2 = str;
        return remoteZipIndexSession.copy(remoteZipIndex, archiveObservedRepresentationFence, str2, j);
    }

    public final RemoteZipIndex component1() {
        return this.index;
    }

    public final ArchiveObservedRepresentationFence component2() {
        return this.observedFence;
    }

    public final String component3() {
        return this.effectiveUrl;
    }

    public final long component4() {
        return this.fetchedBytes;
    }

    public final RemoteZipIndexSession copy(RemoteZipIndex index, ArchiveObservedRepresentationFence archiveObservedRepresentationFence, String effectiveUrl, long j) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(effectiveUrl, "effectiveUrl");
        return new RemoteZipIndexSession(index, archiveObservedRepresentationFence, effectiveUrl, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RemoteZipIndexSession) {
            RemoteZipIndexSession remoteZipIndexSession = (RemoteZipIndexSession) obj;
            return Intrinsics.areEqual(this.index, remoteZipIndexSession.index) && Intrinsics.areEqual(this.observedFence, remoteZipIndexSession.observedFence) && Intrinsics.areEqual(this.effectiveUrl, remoteZipIndexSession.effectiveUrl) && this.fetchedBytes == remoteZipIndexSession.fetchedBytes;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.index.hashCode() * 31;
        ArchiveObservedRepresentationFence archiveObservedRepresentationFence = this.observedFence;
        return ((((hashCode + (archiveObservedRepresentationFence == null ? 0 : archiveObservedRepresentationFence.hashCode())) * 31) + this.effectiveUrl.hashCode()) * 31) + Long.hashCode(this.fetchedBytes);
    }

    public String toString() {
        RemoteZipIndex remoteZipIndex = this.index;
        ArchiveObservedRepresentationFence archiveObservedRepresentationFence = this.observedFence;
        String str = this.effectiveUrl;
        return "RemoteZipIndexSession(index=" + remoteZipIndex + ", observedFence=" + archiveObservedRepresentationFence + ", effectiveUrl=" + str + ", fetchedBytes=" + this.fetchedBytes + ")";
    }

    public RemoteZipIndexSession(RemoteZipIndex index, ArchiveObservedRepresentationFence archiveObservedRepresentationFence, String effectiveUrl, long j) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(effectiveUrl, "effectiveUrl");
        this.index = index;
        this.observedFence = archiveObservedRepresentationFence;
        this.effectiveUrl = effectiveUrl;
        this.fetchedBytes = j;
    }

    public final RemoteZipIndex getIndex() {
        return this.index;
    }

    public final ArchiveObservedRepresentationFence getObservedFence() {
        return this.observedFence;
    }

    public final String getEffectiveUrl() {
        return this.effectiveUrl;
    }

    public final long getFetchedBytes() {
        return this.fetchedBytes;
    }
}
