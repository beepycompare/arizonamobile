package com.arizona.launcher.updater.archive.range;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveRepresentationFencePolicy.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/ArchiveResolvedRepresentationBinding;", "", "expectedCentralDirectorySha256", "Lcom/arizona/launcher/updater/archive/range/Sha256Digest;", "<init>", "(Lcom/arizona/launcher/updater/archive/range/Sha256Digest;)V", "getExpectedCentralDirectorySha256", "()Lcom/arizona/launcher/updater/archive/range/Sha256Digest;", "hasTrustAnchor", "", "getHasTrustAnchor", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveResolvedRepresentationBinding {
    public static final int $stable = 0;
    private final Sha256Digest expectedCentralDirectorySha256;

    public ArchiveResolvedRepresentationBinding() {
        this(null, 1, null);
    }

    public static /* synthetic */ ArchiveResolvedRepresentationBinding copy$default(ArchiveResolvedRepresentationBinding archiveResolvedRepresentationBinding, Sha256Digest sha256Digest, int i, Object obj) {
        if ((i & 1) != 0) {
            sha256Digest = archiveResolvedRepresentationBinding.expectedCentralDirectorySha256;
        }
        return archiveResolvedRepresentationBinding.copy(sha256Digest);
    }

    public final Sha256Digest component1() {
        return this.expectedCentralDirectorySha256;
    }

    public final ArchiveResolvedRepresentationBinding copy(Sha256Digest sha256Digest) {
        return new ArchiveResolvedRepresentationBinding(sha256Digest);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ArchiveResolvedRepresentationBinding) && Intrinsics.areEqual(this.expectedCentralDirectorySha256, ((ArchiveResolvedRepresentationBinding) obj).expectedCentralDirectorySha256);
    }

    public int hashCode() {
        Sha256Digest sha256Digest = this.expectedCentralDirectorySha256;
        if (sha256Digest == null) {
            return 0;
        }
        return sha256Digest.hashCode();
    }

    public String toString() {
        return "ArchiveResolvedRepresentationBinding(expectedCentralDirectorySha256=" + this.expectedCentralDirectorySha256 + ")";
    }

    public ArchiveResolvedRepresentationBinding(Sha256Digest sha256Digest) {
        this.expectedCentralDirectorySha256 = sha256Digest;
    }

    public /* synthetic */ ArchiveResolvedRepresentationBinding(Sha256Digest sha256Digest, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sha256Digest);
    }

    public final Sha256Digest getExpectedCentralDirectorySha256() {
        return this.expectedCentralDirectorySha256;
    }

    public final boolean getHasTrustAnchor() {
        return this.expectedCentralDirectorySha256 != null;
    }
}
