package com.miami.game.core.settings.game_test;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameTestScriptModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003JD\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/miami/game/core/settings/game_test/BackendFixtureEvent;", "", "backendId", "", "backendName", "", "subId", "message", "delayMs", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;J)V", "getBackendId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackendName", "()Ljava/lang/String;", "getSubId", "()I", "getMessage", "getDelayMs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;J)Lcom/miami/game/core/settings/game_test/BackendFixtureEvent;", "equals", "", "other", "hashCode", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BackendFixtureEvent {
    private final Integer backendId;
    private final String backendName;
    private final long delayMs;
    private final String message;
    private final int subId;

    public static /* synthetic */ BackendFixtureEvent copy$default(BackendFixtureEvent backendFixtureEvent, Integer num, String str, int i, String str2, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = backendFixtureEvent.backendId;
        }
        if ((i2 & 2) != 0) {
            str = backendFixtureEvent.backendName;
        }
        if ((i2 & 4) != 0) {
            i = backendFixtureEvent.subId;
        }
        if ((i2 & 8) != 0) {
            str2 = backendFixtureEvent.message;
        }
        if ((i2 & 16) != 0) {
            j = backendFixtureEvent.delayMs;
        }
        long j2 = j;
        return backendFixtureEvent.copy(num, str, i, str2, j2);
    }

    public final Integer component1() {
        return this.backendId;
    }

    public final String component2() {
        return this.backendName;
    }

    public final int component3() {
        return this.subId;
    }

    public final String component4() {
        return this.message;
    }

    public final long component5() {
        return this.delayMs;
    }

    public final BackendFixtureEvent copy(Integer num, String str, int i, String message, long j) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new BackendFixtureEvent(num, str, i, message, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BackendFixtureEvent) {
            BackendFixtureEvent backendFixtureEvent = (BackendFixtureEvent) obj;
            return Intrinsics.areEqual(this.backendId, backendFixtureEvent.backendId) && Intrinsics.areEqual(this.backendName, backendFixtureEvent.backendName) && this.subId == backendFixtureEvent.subId && Intrinsics.areEqual(this.message, backendFixtureEvent.message) && this.delayMs == backendFixtureEvent.delayMs;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.backendId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.backendName;
        return ((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.subId)) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.delayMs);
    }

    public String toString() {
        Integer num = this.backendId;
        String str = this.backendName;
        int i = this.subId;
        String str2 = this.message;
        return "BackendFixtureEvent(backendId=" + num + ", backendName=" + str + ", subId=" + i + ", message=" + str2 + ", delayMs=" + this.delayMs + ")";
    }

    public BackendFixtureEvent(Integer num, String str, int i, String message, long j) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.backendId = num;
        this.backendName = str;
        this.subId = i;
        this.message = message;
        this.delayMs = j;
    }

    public final Integer getBackendId() {
        return this.backendId;
    }

    public final String getBackendName() {
        return this.backendName;
    }

    public final int getSubId() {
        return this.subId;
    }

    public /* synthetic */ BackendFixtureEvent(Integer num, String str, int i, String str2, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, i, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? 0L : j);
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getDelayMs() {
        return this.delayMs;
    }
}
