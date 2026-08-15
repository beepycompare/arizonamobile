package com.arizona.launcher.updater.archive.range;

import com.arizona.launcher.updater.archive.range.ArchiveDeltaEligibility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveRepresentationFencePolicy.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bÊ\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/ArchiveRepresentationFencePolicy;", "", "<init>", "()V", "evaluate", "Lcom/arizona/launcher/updater/archive/range/ArchiveDeltaEligibility;", "published", "Lcom/arizona/launcher/updater/archive/range/ArchivePublishedRepresentationBinding;", "observed", "Lcom/arizona/launcher/updater/archive/range/ArchiveObservedRepresentationFence;", "actualCentralDirectorySha256", "Lcom/arizona/launcher/updater/archive/range/Sha256Digest;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveRepresentationFencePolicy {
    public static final int $stable = 0;
    public static final ArchiveRepresentationFencePolicy INSTANCE = new ArchiveRepresentationFencePolicy();

    private ArchiveRepresentationFencePolicy() {
    }

    public final ArchiveDeltaEligibility evaluate(ArchivePublishedRepresentationBinding published, ArchiveObservedRepresentationFence archiveObservedRepresentationFence, Sha256Digest sha256Digest) {
        Intrinsics.checkNotNullParameter(published, "published");
        if (archiveObservedRepresentationFence == null) {
            return new ArchiveDeltaEligibility.Ineligible(ArchiveDeltaIneligibilityReason.MISSING_OBSERVED_STRONG_ETAG);
        }
        if (!published.getHasTrustAnchor()) {
            return new ArchiveDeltaEligibility.Ineligible(ArchiveDeltaIneligibilityReason.MISSING_PUBLISHED_REPRESENTATION_BINDING);
        }
        if (published.getExpectedStrongEtag() != null && !Intrinsics.areEqual(published.getExpectedStrongEtag(), archiveObservedRepresentationFence.getStrongEtag())) {
            return new ArchiveDeltaEligibility.Ineligible(ArchiveDeltaIneligibilityReason.PUBLISHED_ETAG_MISMATCH);
        }
        Sha256Digest expectedCentralDirectorySha256 = published.getExpectedCentralDirectorySha256();
        if (expectedCentralDirectorySha256 != null && sha256Digest == null) {
            return new ArchiveDeltaEligibility.Ineligible(ArchiveDeltaIneligibilityReason.CENTRAL_DIRECTORY_DIGEST_UNAVAILABLE);
        }
        if (expectedCentralDirectorySha256 != null && !Intrinsics.areEqual(expectedCentralDirectorySha256, sha256Digest)) {
            return new ArchiveDeltaEligibility.Ineligible(ArchiveDeltaIneligibilityReason.PUBLISHED_CENTRAL_DIRECTORY_DIGEST_MISMATCH);
        }
        return ArchiveDeltaEligibility.Eligible.INSTANCE;
    }
}
