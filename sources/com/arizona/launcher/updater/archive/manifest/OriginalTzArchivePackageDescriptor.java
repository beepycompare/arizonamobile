package com.arizona.launcher.updater.archive.manifest;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.updater.archive.model.ArchiveModelRules;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OriginalTzArchiveManifestParser.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rÊ\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\u0003\u0010\u0002¨\u0006!"}, d2 = {"Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;", "", TtmlNode.ATTR_ID, "", "sourcePath", "url", "archiveSize", "", "crc32", OriginalTzArchiveManifestParser.CENTRAL_DIRECTORY_SHA256_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSourcePath", "getUrl", "getArchiveSize", "()J", "getCrc32", "getCentralDirectorySha256", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OriginalTzArchivePackageDescriptor {
    public static final int $stable = 0;
    private final long archiveSize;
    private final String centralDirectorySha256;
    private final long crc32;
    private final String id;
    private final String sourcePath;
    private final String url;

    public static /* synthetic */ OriginalTzArchivePackageDescriptor copy$default(OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor, String str, String str2, String str3, long j, long j2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = originalTzArchivePackageDescriptor.id;
        }
        if ((i & 2) != 0) {
            str2 = originalTzArchivePackageDescriptor.sourcePath;
        }
        if ((i & 4) != 0) {
            str3 = originalTzArchivePackageDescriptor.url;
        }
        if ((i & 8) != 0) {
            j = originalTzArchivePackageDescriptor.archiveSize;
        }
        if ((i & 16) != 0) {
            j2 = originalTzArchivePackageDescriptor.crc32;
        }
        if ((i & 32) != 0) {
            str4 = originalTzArchivePackageDescriptor.centralDirectorySha256;
        }
        String str5 = str4;
        long j3 = j2;
        String str6 = str3;
        return originalTzArchivePackageDescriptor.copy(str, str2, str6, j, j3, str5);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.sourcePath;
    }

    public final String component3() {
        return this.url;
    }

    public final long component4() {
        return this.archiveSize;
    }

    public final long component5() {
        return this.crc32;
    }

    public final String component6() {
        return this.centralDirectorySha256;
    }

    public final OriginalTzArchivePackageDescriptor copy(String id, String sourcePath, String url, long j, long j2, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sourcePath, "sourcePath");
        Intrinsics.checkNotNullParameter(url, "url");
        return new OriginalTzArchivePackageDescriptor(id, sourcePath, url, j, j2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OriginalTzArchivePackageDescriptor) {
            OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor = (OriginalTzArchivePackageDescriptor) obj;
            return Intrinsics.areEqual(this.id, originalTzArchivePackageDescriptor.id) && Intrinsics.areEqual(this.sourcePath, originalTzArchivePackageDescriptor.sourcePath) && Intrinsics.areEqual(this.url, originalTzArchivePackageDescriptor.url) && this.archiveSize == originalTzArchivePackageDescriptor.archiveSize && this.crc32 == originalTzArchivePackageDescriptor.crc32 && Intrinsics.areEqual(this.centralDirectorySha256, originalTzArchivePackageDescriptor.centralDirectorySha256);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((this.id.hashCode() * 31) + this.sourcePath.hashCode()) * 31) + this.url.hashCode()) * 31) + Long.hashCode(this.archiveSize)) * 31) + Long.hashCode(this.crc32)) * 31;
        String str = this.centralDirectorySha256;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.id;
        String str2 = this.sourcePath;
        String str3 = this.url;
        long j = this.archiveSize;
        long j2 = this.crc32;
        return "OriginalTzArchivePackageDescriptor(id=" + str + ", sourcePath=" + str2 + ", url=" + str3 + ", archiveSize=" + j + ", crc32=" + j2 + ", centralDirectorySha256=" + this.centralDirectorySha256 + ")";
    }

    public OriginalTzArchivePackageDescriptor(String id, String sourcePath, String url, long j, long j2, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sourcePath, "sourcePath");
        Intrinsics.checkNotNullParameter(url, "url");
        this.id = id;
        this.sourcePath = sourcePath;
        this.url = url;
        this.archiveSize = j;
        this.crc32 = j2;
        this.centralDirectorySha256 = str;
        if (str != null && !Intrinsics.areEqual(str, ArchiveModelRules.INSTANCE.requireSha256Hex(str))) {
            throw new IllegalArgumentException("centralDirectorySha256 must be a lowercase 64-character hexadecimal SHA-256".toString());
        }
    }

    public /* synthetic */ OriginalTzArchivePackageDescriptor(String str, String str2, String str3, long j, long j2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j, j2, (i & 32) != 0 ? null : str4);
    }

    public final String getId() {
        return this.id;
    }

    public final String getSourcePath() {
        return this.sourcePath;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getArchiveSize() {
        return this.archiveSize;
    }

    public final long getCrc32() {
        return this.crc32;
    }

    public final String getCentralDirectorySha256() {
        return this.centralDirectorySha256;
    }
}
