package com.arizona.launcher.updater.archive.range;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveRepresentationFencePolicy.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bÊ\u0001\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001c"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/ArchivePublishedRepresentationBinding;", "", "immutableVersionedUrl", "", "expectedStrongEtag", "Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "expectedCentralDirectorySha256", "Lcom/arizona/launcher/updater/archive/range/Sha256Digest;", "<init>", "(ZLcom/arizona/launcher/updater/archive/range/StrongEtag;Lcom/arizona/launcher/updater/archive/range/Sha256Digest;)V", "getImmutableVersionedUrl", "()Z", "getExpectedStrongEtag", "()Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "getExpectedCentralDirectorySha256", "()Lcom/arizona/launcher/updater/archive/range/Sha256Digest;", "hasTrustAnchor", "getHasTrustAnchor", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePublishedRepresentationBinding {
    public static final int $stable = 0;
    private final Sha256Digest expectedCentralDirectorySha256;
    private final StrongEtag expectedStrongEtag;
    private final boolean immutableVersionedUrl;

    public ArchivePublishedRepresentationBinding() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ ArchivePublishedRepresentationBinding copy$default(ArchivePublishedRepresentationBinding archivePublishedRepresentationBinding, boolean z, StrongEtag strongEtag, Sha256Digest sha256Digest, int i, Object obj) {
        if ((i & 1) != 0) {
            z = archivePublishedRepresentationBinding.immutableVersionedUrl;
        }
        if ((i & 2) != 0) {
            strongEtag = archivePublishedRepresentationBinding.expectedStrongEtag;
        }
        if ((i & 4) != 0) {
            sha256Digest = archivePublishedRepresentationBinding.expectedCentralDirectorySha256;
        }
        return archivePublishedRepresentationBinding.copy(z, strongEtag, sha256Digest);
    }

    public final boolean component1() {
        return this.immutableVersionedUrl;
    }

    public final StrongEtag component2() {
        return this.expectedStrongEtag;
    }

    public final Sha256Digest component3() {
        return this.expectedCentralDirectorySha256;
    }

    public final ArchivePublishedRepresentationBinding copy(boolean z, StrongEtag strongEtag, Sha256Digest sha256Digest) {
        return new ArchivePublishedRepresentationBinding(z, strongEtag, sha256Digest);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchivePublishedRepresentationBinding) {
            ArchivePublishedRepresentationBinding archivePublishedRepresentationBinding = (ArchivePublishedRepresentationBinding) obj;
            return this.immutableVersionedUrl == archivePublishedRepresentationBinding.immutableVersionedUrl && Intrinsics.areEqual(this.expectedStrongEtag, archivePublishedRepresentationBinding.expectedStrongEtag) && Intrinsics.areEqual(this.expectedCentralDirectorySha256, archivePublishedRepresentationBinding.expectedCentralDirectorySha256);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.immutableVersionedUrl) * 31;
        StrongEtag strongEtag = this.expectedStrongEtag;
        int hashCode2 = (hashCode + (strongEtag == null ? 0 : strongEtag.hashCode())) * 31;
        Sha256Digest sha256Digest = this.expectedCentralDirectorySha256;
        return hashCode2 + (sha256Digest != null ? sha256Digest.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.immutableVersionedUrl;
        StrongEtag strongEtag = this.expectedStrongEtag;
        return "ArchivePublishedRepresentationBinding(immutableVersionedUrl=" + z + ", expectedStrongEtag=" + strongEtag + ", expectedCentralDirectorySha256=" + this.expectedCentralDirectorySha256 + ")";
    }

    public ArchivePublishedRepresentationBinding(boolean z, StrongEtag strongEtag, Sha256Digest sha256Digest) {
        this.immutableVersionedUrl = z;
        this.expectedStrongEtag = strongEtag;
        this.expectedCentralDirectorySha256 = sha256Digest;
    }

    public /* synthetic */ ArchivePublishedRepresentationBinding(boolean z, StrongEtag strongEtag, Sha256Digest sha256Digest, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : strongEtag, (i & 4) != 0 ? null : sha256Digest);
    }

    public final boolean getImmutableVersionedUrl() {
        return this.immutableVersionedUrl;
    }

    public final StrongEtag getExpectedStrongEtag() {
        return this.expectedStrongEtag;
    }

    public final Sha256Digest getExpectedCentralDirectorySha256() {
        return this.expectedCentralDirectorySha256;
    }

    public final boolean getHasTrustAnchor() {
        return (!this.immutableVersionedUrl && this.expectedStrongEtag == null && this.expectedCentralDirectorySha256 == null) ? false : true;
    }
}
