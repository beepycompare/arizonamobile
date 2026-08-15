package com.arizona.launcher.updater.archive.range;

import kotlin.Metadata;
/* compiled from: RemoteZipIndexModels.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012Ê\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\u0003\u0010\u0002¨\u0006!"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocation;", "", "archiveSize", "", "eocdOffset", "centralDirectoryOffset", "centralDirectorySize", "entryCount", "", "commentLength", "<init>", "(JJJJII)V", "getArchiveSize", "()J", "getEocdOffset", "getCentralDirectoryOffset", "getCentralDirectorySize", "getEntryCount", "()I", "getCommentLength", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteZipDirectoryLocation {
    public static final int $stable = 0;
    private final long archiveSize;
    private final long centralDirectoryOffset;
    private final long centralDirectorySize;
    private final int commentLength;
    private final int entryCount;
    private final long eocdOffset;

    public static /* synthetic */ RemoteZipDirectoryLocation copy$default(RemoteZipDirectoryLocation remoteZipDirectoryLocation, long j, long j2, long j3, long j4, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = remoteZipDirectoryLocation.archiveSize;
        }
        long j5 = j;
        if ((i3 & 2) != 0) {
            j2 = remoteZipDirectoryLocation.eocdOffset;
        }
        return remoteZipDirectoryLocation.copy(j5, j2, (i3 & 4) != 0 ? remoteZipDirectoryLocation.centralDirectoryOffset : j3, (i3 & 8) != 0 ? remoteZipDirectoryLocation.centralDirectorySize : j4, (i3 & 16) != 0 ? remoteZipDirectoryLocation.entryCount : i, (i3 & 32) != 0 ? remoteZipDirectoryLocation.commentLength : i2);
    }

    public final long component1() {
        return this.archiveSize;
    }

    public final long component2() {
        return this.eocdOffset;
    }

    public final long component3() {
        return this.centralDirectoryOffset;
    }

    public final long component4() {
        return this.centralDirectorySize;
    }

    public final int component5() {
        return this.entryCount;
    }

    public final int component6() {
        return this.commentLength;
    }

    public final RemoteZipDirectoryLocation copy(long j, long j2, long j3, long j4, int i, int i2) {
        return new RemoteZipDirectoryLocation(j, j2, j3, j4, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RemoteZipDirectoryLocation) {
            RemoteZipDirectoryLocation remoteZipDirectoryLocation = (RemoteZipDirectoryLocation) obj;
            return this.archiveSize == remoteZipDirectoryLocation.archiveSize && this.eocdOffset == remoteZipDirectoryLocation.eocdOffset && this.centralDirectoryOffset == remoteZipDirectoryLocation.centralDirectoryOffset && this.centralDirectorySize == remoteZipDirectoryLocation.centralDirectorySize && this.entryCount == remoteZipDirectoryLocation.entryCount && this.commentLength == remoteZipDirectoryLocation.commentLength;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.archiveSize) * 31) + Long.hashCode(this.eocdOffset)) * 31) + Long.hashCode(this.centralDirectoryOffset)) * 31) + Long.hashCode(this.centralDirectorySize)) * 31) + Integer.hashCode(this.entryCount)) * 31) + Integer.hashCode(this.commentLength);
    }

    public String toString() {
        long j = this.archiveSize;
        long j2 = this.eocdOffset;
        long j3 = this.centralDirectoryOffset;
        long j4 = this.centralDirectorySize;
        int i = this.entryCount;
        return "RemoteZipDirectoryLocation(archiveSize=" + j + ", eocdOffset=" + j2 + ", centralDirectoryOffset=" + j3 + ", centralDirectorySize=" + j4 + ", entryCount=" + i + ", commentLength=" + this.commentLength + ")";
    }

    public RemoteZipDirectoryLocation(long j, long j2, long j3, long j4, int i, int i2) {
        this.archiveSize = j;
        this.eocdOffset = j2;
        this.centralDirectoryOffset = j3;
        this.centralDirectorySize = j4;
        this.entryCount = i;
        this.commentLength = i2;
    }

    public final long getArchiveSize() {
        return this.archiveSize;
    }

    public final long getEocdOffset() {
        return this.eocdOffset;
    }

    public final long getCentralDirectoryOffset() {
        return this.centralDirectoryOffset;
    }

    public final long getCentralDirectorySize() {
        return this.centralDirectorySize;
    }

    public final int getEntryCount() {
        return this.entryCount;
    }

    public final int getCommentLength() {
        return this.commentLength;
    }
}
