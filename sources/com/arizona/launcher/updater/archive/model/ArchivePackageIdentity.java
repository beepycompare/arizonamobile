package com.arizona.launcher.updater.archive.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackage.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fÊ\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchivePackageIdentity;", "", TtmlNode.ATTR_ID, "", "archiveSize", "", "crc32", "<init>", "(Ljava/lang/String;JJ)V", "getId", "()Ljava/lang/String;", "getArchiveSize", "()J", "getCrc32", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageIdentity {
    public static final int $stable = 0;
    private final long archiveSize;
    private final long crc32;
    private final String id;

    public static /* synthetic */ ArchivePackageIdentity copy$default(ArchivePackageIdentity archivePackageIdentity, String str, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archivePackageIdentity.id;
        }
        if ((i & 2) != 0) {
            j = archivePackageIdentity.archiveSize;
        }
        if ((i & 4) != 0) {
            j2 = archivePackageIdentity.crc32;
        }
        return archivePackageIdentity.copy(str, j, j2);
    }

    public final String component1() {
        return this.id;
    }

    public final long component2() {
        return this.archiveSize;
    }

    public final long component3() {
        return this.crc32;
    }

    public final ArchivePackageIdentity copy(String id, long j, long j2) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new ArchivePackageIdentity(id, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchivePackageIdentity) {
            ArchivePackageIdentity archivePackageIdentity = (ArchivePackageIdentity) obj;
            return Intrinsics.areEqual(this.id, archivePackageIdentity.id) && this.archiveSize == archivePackageIdentity.archiveSize && this.crc32 == archivePackageIdentity.crc32;
        }
        return false;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + Long.hashCode(this.archiveSize)) * 31) + Long.hashCode(this.crc32);
    }

    public String toString() {
        String str = this.id;
        long j = this.archiveSize;
        return "ArchivePackageIdentity(id=" + str + ", archiveSize=" + j + ", crc32=" + this.crc32 + ")";
    }

    public ArchivePackageIdentity(String id, long j, long j2) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.archiveSize = j;
        this.crc32 = j2;
        ArchiveModelRules.INSTANCE.requirePackageId(id);
        ArchiveModelRules.INSTANCE.requireArchiveSize(j);
        ArchiveModelRules.INSTANCE.requireUnsignedCrc32(j2);
    }

    public final String getId() {
        return this.id;
    }

    public final long getArchiveSize() {
        return this.archiveSize;
    }

    public final long getCrc32() {
        return this.crc32;
    }
}
