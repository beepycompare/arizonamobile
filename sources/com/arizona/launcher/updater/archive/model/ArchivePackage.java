package com.arizona.launcher.updater.archive.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackage.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u00032\u0006\u0010.\u001a\u00020\u0003H\u0002J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\t\u00106\u001a\u00020\u000fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0085\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0014\u0010;\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010=\u001a\u00020>HÖ\u0081\u0004J\n\u0010?\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*Ê\u0001\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0002¨\u0006@"}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "", TtmlNode.ATTR_ID, "", "type", "Lcom/arizona/launcher/updater/archive/model/ArchivePackageType;", "url", "archiveSize", "", "installedSize", "crc32", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "Lcom/arizona/launcher/updater/archive/model/ArchiveEntryMetadata;", "immutableVersionedUrl", "", OriginalTzArchiveManifestParser.CENTRAL_DIRECTORY_SHA256_KEY, "resolvedCentralDirectorySha256", "resolvedZipIndexMetadata", "Lcom/arizona/launcher/updater/archive/model/ArchiveResolvedZipIndexMetadata;", "<init>", "(Ljava/lang/String;Lcom/arizona/launcher/updater/archive/model/ArchivePackageType;Ljava/lang/String;JJJLjava/util/List;ZLjava/lang/String;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/model/ArchiveResolvedZipIndexMetadata;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/arizona/launcher/updater/archive/model/ArchivePackageType;", "getUrl", "getArchiveSize", "()J", "getInstalledSize", "getCrc32", "getEntries", "()Ljava/util/List;", "getImmutableVersionedUrl", "()Z", "getCentralDirectorySha256", "getResolvedCentralDirectorySha256", "getResolvedZipIndexMetadata", "()Lcom/arizona/launcher/updater/archive/model/ArchiveResolvedZipIndexMetadata;", "identity", "Lcom/arizona/launcher/updater/archive/model/ArchivePackageIdentity;", "getIdentity", "()Lcom/arizona/launcher/updater/archive/model/ArchivePackageIdentity;", "requireCanonicalCentralDirectorySha256", "", "value", "name", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackage {
    public static final int $stable = 0;
    private final long archiveSize;
    private final String centralDirectorySha256;
    private final long crc32;
    private final List<ArchiveEntryMetadata> entries;
    private final String id;
    private final ArchivePackageIdentity identity;
    private final boolean immutableVersionedUrl;
    private final long installedSize;
    private final String resolvedCentralDirectorySha256;
    private final transient ArchiveResolvedZipIndexMetadata resolvedZipIndexMetadata;
    private final ArchivePackageType type;
    private final String url;

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.resolvedCentralDirectorySha256;
    }

    public final ArchiveResolvedZipIndexMetadata component11() {
        return this.resolvedZipIndexMetadata;
    }

    public final ArchivePackageType component2() {
        return this.type;
    }

    public final String component3() {
        return this.url;
    }

    public final long component4() {
        return this.archiveSize;
    }

    public final long component5() {
        return this.installedSize;
    }

    public final long component6() {
        return this.crc32;
    }

    public final List<ArchiveEntryMetadata> component7() {
        return this.entries;
    }

    public final boolean component8() {
        return this.immutableVersionedUrl;
    }

    public final String component9() {
        return this.centralDirectorySha256;
    }

    public final ArchivePackage copy(String id, ArchivePackageType type, String url, long j, long j2, long j3, List<ArchiveEntryMetadata> list, boolean z, String str, String str2, ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(url, "url");
        return new ArchivePackage(id, type, url, j, j2, j3, list, z, str, str2, archiveResolvedZipIndexMetadata);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchivePackage) {
            ArchivePackage archivePackage = (ArchivePackage) obj;
            return Intrinsics.areEqual(this.id, archivePackage.id) && this.type == archivePackage.type && Intrinsics.areEqual(this.url, archivePackage.url) && this.archiveSize == archivePackage.archiveSize && this.installedSize == archivePackage.installedSize && this.crc32 == archivePackage.crc32 && Intrinsics.areEqual(this.entries, archivePackage.entries) && this.immutableVersionedUrl == archivePackage.immutableVersionedUrl && Intrinsics.areEqual(this.centralDirectorySha256, archivePackage.centralDirectorySha256) && Intrinsics.areEqual(this.resolvedCentralDirectorySha256, archivePackage.resolvedCentralDirectorySha256) && Intrinsics.areEqual(this.resolvedZipIndexMetadata, archivePackage.resolvedZipIndexMetadata);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.url.hashCode()) * 31) + Long.hashCode(this.archiveSize)) * 31) + Long.hashCode(this.installedSize)) * 31) + Long.hashCode(this.crc32)) * 31;
        List<ArchiveEntryMetadata> list = this.entries;
        int hashCode2 = (((hashCode + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.immutableVersionedUrl)) * 31;
        String str = this.centralDirectorySha256;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.resolvedCentralDirectorySha256;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata = this.resolvedZipIndexMetadata;
        return hashCode4 + (archiveResolvedZipIndexMetadata != null ? archiveResolvedZipIndexMetadata.hashCode() : 0);
    }

    public String toString() {
        String str = this.id;
        ArchivePackageType archivePackageType = this.type;
        String str2 = this.url;
        long j = this.archiveSize;
        long j2 = this.installedSize;
        long j3 = this.crc32;
        List<ArchiveEntryMetadata> list = this.entries;
        boolean z = this.immutableVersionedUrl;
        String str3 = this.centralDirectorySha256;
        String str4 = this.resolvedCentralDirectorySha256;
        return "ArchivePackage(id=" + str + ", type=" + archivePackageType + ", url=" + str2 + ", archiveSize=" + j + ", installedSize=" + j2 + ", crc32=" + j3 + ", entries=" + list + ", immutableVersionedUrl=" + z + ", centralDirectorySha256=" + str3 + ", resolvedCentralDirectorySha256=" + str4 + ", resolvedZipIndexMetadata=" + this.resolvedZipIndexMetadata + ")";
    }

    public ArchivePackage(String id, ArchivePackageType type, String url, long j, long j2, long j3, List<ArchiveEntryMetadata> list, boolean z, String str, String str2, ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(url, "url");
        this.id = id;
        this.type = type;
        this.url = url;
        this.archiveSize = j;
        this.installedSize = j2;
        this.crc32 = j3;
        this.entries = list;
        this.immutableVersionedUrl = z;
        this.centralDirectorySha256 = str;
        this.resolvedCentralDirectorySha256 = str2;
        this.resolvedZipIndexMetadata = archiveResolvedZipIndexMetadata;
        this.identity = new ArchivePackageIdentity(id, j, j3);
        ArchiveModelRules.INSTANCE.requirePackageUrl(url);
        if (j2 <= 0) {
            throw new IllegalArgumentException("installed size must be positive".toString());
        }
        if (list != null && list.isEmpty()) {
            throw new IllegalArgumentException("entries must be omitted or contain at least one item".toString());
        }
        requireCanonicalCentralDirectorySha256(str, OriginalTzArchiveManifestParser.CENTRAL_DIRECTORY_SHA256_KEY);
        requireCanonicalCentralDirectorySha256(str2, "resolvedCentralDirectorySha256");
        if (archiveResolvedZipIndexMetadata != null && archiveResolvedZipIndexMetadata.getCentralDirectoryOffset() >= j) {
            throw new IllegalArgumentException("ZIP central directory must be inside archive bounds".toString());
        }
    }

    public /* synthetic */ ArchivePackage(String str, ArchivePackageType archivePackageType, String str2, long j, long j2, long j3, List list, boolean z, String str3, String str4, ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, archivePackageType, str2, j, j2, j3, (i & 64) != 0 ? null : list, (i & 128) != 0 ? false : z, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : archiveResolvedZipIndexMetadata);
    }

    public final String getId() {
        return this.id;
    }

    public final ArchivePackageType getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getArchiveSize() {
        return this.archiveSize;
    }

    public final long getInstalledSize() {
        return this.installedSize;
    }

    public final long getCrc32() {
        return this.crc32;
    }

    public final List<ArchiveEntryMetadata> getEntries() {
        return this.entries;
    }

    public final boolean getImmutableVersionedUrl() {
        return this.immutableVersionedUrl;
    }

    public final String getCentralDirectorySha256() {
        return this.centralDirectorySha256;
    }

    public final String getResolvedCentralDirectorySha256() {
        return this.resolvedCentralDirectorySha256;
    }

    public final ArchiveResolvedZipIndexMetadata getResolvedZipIndexMetadata() {
        return this.resolvedZipIndexMetadata;
    }

    public final ArchivePackageIdentity getIdentity() {
        return this.identity;
    }

    private final void requireCanonicalCentralDirectorySha256(String str, String str2) {
        if (str != null && !Intrinsics.areEqual(str, ArchiveModelRules.INSTANCE.requireSha256Hex(str))) {
            throw new IllegalArgumentException((str2 + " must be a lowercase 64-character hexadecimal SHA-256").toString());
        }
    }
}
