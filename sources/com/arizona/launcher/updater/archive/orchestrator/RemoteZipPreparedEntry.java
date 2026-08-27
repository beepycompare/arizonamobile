package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.range.RemoteZipEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RemoteZipEntryRangeReader.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\bHÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fÊ\u0001\f\b#\u0012\b\b$\u0012\u0004\b\u0003\u0010\u0000¨\u0006\""}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipPreparedEntry;", "", "entry", "Lcom/arizona/launcher/updater/archive/range/RemoteZipEntry;", "payloadStart", "", "payloadEndExclusive", "nameLength", "", "extraLength", "<init>", "(Lcom/arizona/launcher/updater/archive/range/RemoteZipEntry;JJII)V", "getEntry", "()Lcom/arizona/launcher/updater/archive/range/RemoteZipEntry;", "getPayloadStart", "()J", "getPayloadEndExclusive", "getNameLength", "()I", "getExtraLength", "payloadLength", "getPayloadLength", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteZipPreparedEntry {
    public static final int $stable = RemoteZipEntry.$stable;
    private final RemoteZipEntry entry;
    private final int extraLength;
    private final int nameLength;
    private final long payloadEndExclusive;
    private final long payloadStart;

    public static /* synthetic */ RemoteZipPreparedEntry copy$default(RemoteZipPreparedEntry remoteZipPreparedEntry, RemoteZipEntry remoteZipEntry, long j, long j2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            remoteZipEntry = remoteZipPreparedEntry.entry;
        }
        if ((i3 & 2) != 0) {
            j = remoteZipPreparedEntry.payloadStart;
        }
        if ((i3 & 4) != 0) {
            j2 = remoteZipPreparedEntry.payloadEndExclusive;
        }
        if ((i3 & 8) != 0) {
            i = remoteZipPreparedEntry.nameLength;
        }
        if ((i3 & 16) != 0) {
            i2 = remoteZipPreparedEntry.extraLength;
        }
        long j3 = j2;
        return remoteZipPreparedEntry.copy(remoteZipEntry, j, j3, i, i2);
    }

    public final RemoteZipEntry component1() {
        return this.entry;
    }

    public final long component2() {
        return this.payloadStart;
    }

    public final long component3() {
        return this.payloadEndExclusive;
    }

    public final int component4() {
        return this.nameLength;
    }

    public final int component5() {
        return this.extraLength;
    }

    public final RemoteZipPreparedEntry copy(RemoteZipEntry entry, long j, long j2, int i, int i2) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return new RemoteZipPreparedEntry(entry, j, j2, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RemoteZipPreparedEntry) {
            RemoteZipPreparedEntry remoteZipPreparedEntry = (RemoteZipPreparedEntry) obj;
            return Intrinsics.areEqual(this.entry, remoteZipPreparedEntry.entry) && this.payloadStart == remoteZipPreparedEntry.payloadStart && this.payloadEndExclusive == remoteZipPreparedEntry.payloadEndExclusive && this.nameLength == remoteZipPreparedEntry.nameLength && this.extraLength == remoteZipPreparedEntry.extraLength;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.entry.hashCode() * 31) + Long.hashCode(this.payloadStart)) * 31) + Long.hashCode(this.payloadEndExclusive)) * 31) + Integer.hashCode(this.nameLength)) * 31) + Integer.hashCode(this.extraLength);
    }

    public String toString() {
        RemoteZipEntry remoteZipEntry = this.entry;
        long j = this.payloadStart;
        long j2 = this.payloadEndExclusive;
        int i = this.nameLength;
        return "RemoteZipPreparedEntry(entry=" + remoteZipEntry + ", payloadStart=" + j + ", payloadEndExclusive=" + j2 + ", nameLength=" + i + ", extraLength=" + this.extraLength + ")";
    }

    public RemoteZipPreparedEntry(RemoteZipEntry entry, long j, long j2, int i, int i2) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.entry = entry;
        this.payloadStart = j;
        this.payloadEndExclusive = j2;
        this.nameLength = i;
        this.extraLength = i2;
    }

    public final RemoteZipEntry getEntry() {
        return this.entry;
    }

    public final long getPayloadStart() {
        return this.payloadStart;
    }

    public final long getPayloadEndExclusive() {
        return this.payloadEndExclusive;
    }

    public final int getNameLength() {
        return this.nameLength;
    }

    public final int getExtraLength() {
        return this.extraLength;
    }

    public final long getPayloadLength() {
        return this.payloadEndExclusive - this.payloadStart;
    }
}
