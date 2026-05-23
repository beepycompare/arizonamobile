package com.miami.game.core.settings.game_test;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameTestScriptModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0005J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestBackendEvent;", "", "backendId", "", "backendName", "", "subId", "message", "receivedAtMs", "", "<init>", "(ILjava/lang/String;ILjava/lang/String;J)V", "getBackendId", "()I", "getBackendName", "()Ljava/lang/String;", "getSubId", "getMessage", "getReceivedAtMs", "()J", "describe", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "settings"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GameTestBackendEvent {
    private final int backendId;
    private final String backendName;
    private final String message;
    private final long receivedAtMs;
    private final int subId;

    public static /* synthetic */ GameTestBackendEvent copy$default(GameTestBackendEvent gameTestBackendEvent, int i, String str, int i2, String str2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = gameTestBackendEvent.backendId;
        }
        if ((i3 & 2) != 0) {
            str = gameTestBackendEvent.backendName;
        }
        if ((i3 & 4) != 0) {
            i2 = gameTestBackendEvent.subId;
        }
        if ((i3 & 8) != 0) {
            str2 = gameTestBackendEvent.message;
        }
        if ((i3 & 16) != 0) {
            j = gameTestBackendEvent.receivedAtMs;
        }
        long j2 = j;
        return gameTestBackendEvent.copy(i, str, i2, str2, j2);
    }

    public final int component1() {
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
        return this.receivedAtMs;
    }

    public final GameTestBackendEvent copy(int i, String backendName, int i2, String message, long j) {
        Intrinsics.checkNotNullParameter(backendName, "backendName");
        Intrinsics.checkNotNullParameter(message, "message");
        return new GameTestBackendEvent(i, backendName, i2, message, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameTestBackendEvent) {
            GameTestBackendEvent gameTestBackendEvent = (GameTestBackendEvent) obj;
            return this.backendId == gameTestBackendEvent.backendId && Intrinsics.areEqual(this.backendName, gameTestBackendEvent.backendName) && this.subId == gameTestBackendEvent.subId && Intrinsics.areEqual(this.message, gameTestBackendEvent.message) && this.receivedAtMs == gameTestBackendEvent.receivedAtMs;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.backendId) * 31) + this.backendName.hashCode()) * 31) + Integer.hashCode(this.subId)) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.receivedAtMs);
    }

    public String toString() {
        int i = this.backendId;
        String str = this.backendName;
        int i2 = this.subId;
        String str2 = this.message;
        return "GameTestBackendEvent(backendId=" + i + ", backendName=" + str + ", subId=" + i2 + ", message=" + str2 + ", receivedAtMs=" + this.receivedAtMs + ")";
    }

    public GameTestBackendEvent(int i, String backendName, int i2, String message, long j) {
        Intrinsics.checkNotNullParameter(backendName, "backendName");
        Intrinsics.checkNotNullParameter(message, "message");
        this.backendId = i;
        this.backendName = backendName;
        this.subId = i2;
        this.message = message;
        this.receivedAtMs = j;
    }

    public final int getBackendId() {
        return this.backendId;
    }

    public final String getBackendName() {
        return this.backendName;
    }

    public final int getSubId() {
        return this.subId;
    }

    public /* synthetic */ GameTestBackendEvent(int i, String str, int i2, String str2, long j, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? System.currentTimeMillis() : j);
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getReceivedAtMs() {
        return this.receivedAtMs;
    }

    public final String describe() {
        int i = this.backendId;
        String str = this.backendName;
        return "backendId=" + i + ", backendName=" + str + ", subId=" + this.subId;
    }
}
