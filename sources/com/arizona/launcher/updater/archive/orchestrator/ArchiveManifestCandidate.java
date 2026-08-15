package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestDescriptor;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate;", "", "Resolved", "OriginalTz", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate$OriginalTz;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate$Resolved;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveManifestCandidate {

    /* compiled from: ArchiveManifestResolver.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate$Resolved;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate;", "manifest", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "<init>", "(Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;)V", "getManifest", "()Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Resolved implements ArchiveManifestCandidate {
        public static final int $stable = ArchiveManifest.$stable;
        private final ArchiveManifest manifest;

        public static /* synthetic */ Resolved copy$default(Resolved resolved, ArchiveManifest archiveManifest, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveManifest = resolved.manifest;
            }
            return resolved.copy(archiveManifest);
        }

        public final ArchiveManifest component1() {
            return this.manifest;
        }

        public final Resolved copy(ArchiveManifest manifest) {
            Intrinsics.checkNotNullParameter(manifest, "manifest");
            return new Resolved(manifest);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Resolved) && Intrinsics.areEqual(this.manifest, ((Resolved) obj).manifest);
        }

        public int hashCode() {
            return this.manifest.hashCode();
        }

        public String toString() {
            return "Resolved(manifest=" + this.manifest + ")";
        }

        public Resolved(ArchiveManifest manifest) {
            Intrinsics.checkNotNullParameter(manifest, "manifest");
            this.manifest = manifest;
        }

        public final ArchiveManifest getManifest() {
            return this.manifest;
        }
    }

    /* compiled from: ArchiveManifestResolver.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate$OriginalTz;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate;", "descriptor", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;", "<init>", "(Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;)V", "getDescriptor", "()Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class OriginalTz implements ArchiveManifestCandidate {
        public static final int $stable = OriginalTzArchiveManifestDescriptor.$stable;
        private final OriginalTzArchiveManifestDescriptor descriptor;

        public static /* synthetic */ OriginalTz copy$default(OriginalTz originalTz, OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor, int i, Object obj) {
            if ((i & 1) != 0) {
                originalTzArchiveManifestDescriptor = originalTz.descriptor;
            }
            return originalTz.copy(originalTzArchiveManifestDescriptor);
        }

        public final OriginalTzArchiveManifestDescriptor component1() {
            return this.descriptor;
        }

        public final OriginalTz copy(OriginalTzArchiveManifestDescriptor descriptor) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return new OriginalTz(descriptor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OriginalTz) && Intrinsics.areEqual(this.descriptor, ((OriginalTz) obj).descriptor);
        }

        public int hashCode() {
            return this.descriptor.hashCode();
        }

        public String toString() {
            return "OriginalTz(descriptor=" + this.descriptor + ")";
        }

        public OriginalTz(OriginalTzArchiveManifestDescriptor descriptor) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            this.descriptor = descriptor;
        }

        public final OriginalTzArchiveManifestDescriptor getDescriptor() {
            return this.descriptor;
        }
    }
}
