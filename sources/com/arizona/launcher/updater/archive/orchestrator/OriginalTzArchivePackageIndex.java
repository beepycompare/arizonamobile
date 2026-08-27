package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveResolvedZipIndexMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\bHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\f\b!\u0012\b\b\"\u0012\u0004\b\u0003\u0010\u0000¨\u0006 "}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndex;", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "Lcom/arizona/launcher/updater/archive/model/ArchiveEntryMetadata;", "installedSize", "", OriginalTzArchiveManifestParser.CENTRAL_DIRECTORY_SHA256_KEY, "", "resolvedZipIndexMetadata", "Lcom/arizona/launcher/updater/archive/model/ArchiveResolvedZipIndexMetadata;", "<init>", "(Ljava/util/List;JLjava/lang/String;Lcom/arizona/launcher/updater/archive/model/ArchiveResolvedZipIndexMetadata;)V", "getEntries", "()Ljava/util/List;", "getInstalledSize", "()J", "getCentralDirectorySha256", "()Ljava/lang/String;", "getResolvedZipIndexMetadata", "()Lcom/arizona/launcher/updater/archive/model/ArchiveResolvedZipIndexMetadata;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OriginalTzArchivePackageIndex {
    public static final int $stable = ArchiveResolvedZipIndexMetadata.$stable;
    private final String centralDirectorySha256;
    private final List<ArchiveEntryMetadata> entries;
    private final long installedSize;
    private final ArchiveResolvedZipIndexMetadata resolvedZipIndexMetadata;

    public static /* synthetic */ OriginalTzArchivePackageIndex copy$default(OriginalTzArchivePackageIndex originalTzArchivePackageIndex, List list, long j, String str, ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata, int i, Object obj) {
        List<ArchiveEntryMetadata> list2 = list;
        if ((i & 1) != 0) {
            list2 = originalTzArchivePackageIndex.entries;
        }
        if ((i & 2) != 0) {
            j = originalTzArchivePackageIndex.installedSize;
        }
        if ((i & 4) != 0) {
            str = originalTzArchivePackageIndex.centralDirectorySha256;
        }
        if ((i & 8) != 0) {
            archiveResolvedZipIndexMetadata = originalTzArchivePackageIndex.resolvedZipIndexMetadata;
        }
        return originalTzArchivePackageIndex.copy(list2, j, str, archiveResolvedZipIndexMetadata);
    }

    public final List<ArchiveEntryMetadata> component1() {
        return this.entries;
    }

    public final long component2() {
        return this.installedSize;
    }

    public final String component3() {
        return this.centralDirectorySha256;
    }

    public final ArchiveResolvedZipIndexMetadata component4() {
        return this.resolvedZipIndexMetadata;
    }

    public final OriginalTzArchivePackageIndex copy(List<ArchiveEntryMetadata> entries, long j, String str, ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new OriginalTzArchivePackageIndex(entries, j, str, archiveResolvedZipIndexMetadata);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OriginalTzArchivePackageIndex) {
            OriginalTzArchivePackageIndex originalTzArchivePackageIndex = (OriginalTzArchivePackageIndex) obj;
            return Intrinsics.areEqual(this.entries, originalTzArchivePackageIndex.entries) && this.installedSize == originalTzArchivePackageIndex.installedSize && Intrinsics.areEqual(this.centralDirectorySha256, originalTzArchivePackageIndex.centralDirectorySha256) && Intrinsics.areEqual(this.resolvedZipIndexMetadata, originalTzArchivePackageIndex.resolvedZipIndexMetadata);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.entries.hashCode() * 31) + Long.hashCode(this.installedSize)) * 31;
        String str = this.centralDirectorySha256;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata = this.resolvedZipIndexMetadata;
        return hashCode2 + (archiveResolvedZipIndexMetadata != null ? archiveResolvedZipIndexMetadata.hashCode() : 0);
    }

    public String toString() {
        List<ArchiveEntryMetadata> list = this.entries;
        long j = this.installedSize;
        String str = this.centralDirectorySha256;
        return "OriginalTzArchivePackageIndex(entries=" + list + ", installedSize=" + j + ", centralDirectorySha256=" + str + ", resolvedZipIndexMetadata=" + this.resolvedZipIndexMetadata + ")";
    }

    public OriginalTzArchivePackageIndex(List<ArchiveEntryMetadata> entries, long j, String str, ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        this.installedSize = j;
        this.centralDirectorySha256 = str;
        this.resolvedZipIndexMetadata = archiveResolvedZipIndexMetadata;
    }

    public /* synthetic */ OriginalTzArchivePackageIndex(List list, long j, String str, ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, j, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : archiveResolvedZipIndexMetadata);
    }

    public final List<ArchiveEntryMetadata> getEntries() {
        return this.entries;
    }

    public final long getInstalledSize() {
        return this.installedSize;
    }

    public final String getCentralDirectorySha256() {
        return this.centralDirectorySha256;
    }

    public final ArchiveResolvedZipIndexMetadata getResolvedZipIndexMetadata() {
        return this.resolvedZipIndexMetadata;
    }
}
