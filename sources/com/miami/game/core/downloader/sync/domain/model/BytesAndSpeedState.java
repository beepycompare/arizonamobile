package com.miami.game.core.downloader.sync.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BytesAndSpeedState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/miami/game/core/downloader/sync/domain/model/BytesAndSpeedState;", "", "bytes", "", "speed", "<init>", "(JJ)V", "getBytes", "()J", "getSpeed", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "downloader-sync_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BytesAndSpeedState {
    private final long bytes;
    private final long speed;

    public BytesAndSpeedState() {
        this(0L, 0L, 3, null);
    }

    public static /* synthetic */ BytesAndSpeedState copy$default(BytesAndSpeedState bytesAndSpeedState, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = bytesAndSpeedState.bytes;
        }
        if ((i & 2) != 0) {
            j2 = bytesAndSpeedState.speed;
        }
        return bytesAndSpeedState.copy(j, j2);
    }

    public final long component1() {
        return this.bytes;
    }

    public final long component2() {
        return this.speed;
    }

    public final BytesAndSpeedState copy(long j, long j2) {
        return new BytesAndSpeedState(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BytesAndSpeedState) {
            BytesAndSpeedState bytesAndSpeedState = (BytesAndSpeedState) obj;
            return this.bytes == bytesAndSpeedState.bytes && this.speed == bytesAndSpeedState.speed;
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.bytes) * 31) + Long.hashCode(this.speed);
    }

    public String toString() {
        long j = this.bytes;
        return "BytesAndSpeedState(bytes=" + j + ", speed=" + this.speed + ")";
    }

    public BytesAndSpeedState(long j, long j2) {
        this.bytes = j;
        this.speed = j2;
    }

    public /* synthetic */ BytesAndSpeedState(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2);
    }

    public final long getBytes() {
        return this.bytes;
    }

    public final long getSpeed() {
        return this.speed;
    }
}
