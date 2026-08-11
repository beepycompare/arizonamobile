package ru.mrlargha.commonui.utils;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/utils/ArchiveEntryBytes;", "", "exists", "", "bytes", "", "<init>", "(Z[B)V", "getExists", "()Z", "getBytes", "()[B", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArchiveEntryBytes {
    private final byte[] bytes;
    private final boolean exists;

    public static /* synthetic */ ArchiveEntryBytes copy$default(ArchiveEntryBytes archiveEntryBytes, boolean z, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            z = archiveEntryBytes.exists;
        }
        if ((i & 2) != 0) {
            bArr = archiveEntryBytes.bytes;
        }
        return archiveEntryBytes.copy(z, bArr);
    }

    public final boolean component1() {
        return this.exists;
    }

    public final byte[] component2() {
        return this.bytes;
    }

    public final ArchiveEntryBytes copy(boolean z, byte[] bArr) {
        return new ArchiveEntryBytes(z, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveEntryBytes) {
            ArchiveEntryBytes archiveEntryBytes = (ArchiveEntryBytes) obj;
            return this.exists == archiveEntryBytes.exists && Intrinsics.areEqual(this.bytes, archiveEntryBytes.bytes);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.exists) * 31;
        byte[] bArr = this.bytes;
        return hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr));
    }

    public String toString() {
        boolean z = this.exists;
        return "ArchiveEntryBytes(exists=" + z + ", bytes=" + Arrays.toString(this.bytes) + ")";
    }

    public ArchiveEntryBytes(boolean z, byte[] bArr) {
        this.exists = z;
        this.bytes = bArr;
    }

    public final boolean getExists() {
        return this.exists;
    }

    public final byte[] getBytes() {
        return this.bytes;
    }
}
