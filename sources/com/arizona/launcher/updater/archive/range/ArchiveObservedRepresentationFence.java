package com.arizona.launcher.updater.archive.range;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveRepresentationFencePolicy.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/ArchiveObservedRepresentationFence;", "", "strongEtag", "Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "<init>", "(Lcom/arizona/launcher/updater/archive/range/StrongEtag;)V", "getStrongEtag", "()Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveObservedRepresentationFence {
    public static final int $stable = 0;
    private final StrongEtag strongEtag;

    public static /* synthetic */ ArchiveObservedRepresentationFence copy$default(ArchiveObservedRepresentationFence archiveObservedRepresentationFence, StrongEtag strongEtag, int i, Object obj) {
        if ((i & 1) != 0) {
            strongEtag = archiveObservedRepresentationFence.strongEtag;
        }
        return archiveObservedRepresentationFence.copy(strongEtag);
    }

    public final StrongEtag component1() {
        return this.strongEtag;
    }

    public final ArchiveObservedRepresentationFence copy(StrongEtag strongEtag) {
        Intrinsics.checkNotNullParameter(strongEtag, "strongEtag");
        return new ArchiveObservedRepresentationFence(strongEtag);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ArchiveObservedRepresentationFence) && Intrinsics.areEqual(this.strongEtag, ((ArchiveObservedRepresentationFence) obj).strongEtag);
    }

    public int hashCode() {
        return this.strongEtag.hashCode();
    }

    public String toString() {
        return "ArchiveObservedRepresentationFence(strongEtag=" + this.strongEtag + ")";
    }

    public ArchiveObservedRepresentationFence(StrongEtag strongEtag) {
        Intrinsics.checkNotNullParameter(strongEtag, "strongEtag");
        this.strongEtag = strongEtag;
    }

    public final StrongEtag getStrongEtag() {
        return this.strongEtag;
    }
}
