package com.miami.game.core.settings.game_test;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameTestScriptModel.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0005J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestVisibilityEvent;", "", "backendId", "", "backendName", "", "visible", "", "receivedAtMs", "", "<init>", "(ILjava/lang/String;ZJ)V", "getBackendId", "()I", "getBackendName", "()Ljava/lang/String;", "getVisible", "()Z", "getReceivedAtMs", "()J", "describe", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GameTestVisibilityEvent {
    private final int backendId;
    private final String backendName;
    private final long receivedAtMs;
    private final boolean visible;

    public static /* synthetic */ GameTestVisibilityEvent copy$default(GameTestVisibilityEvent gameTestVisibilityEvent, int i, String str, boolean z, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gameTestVisibilityEvent.backendId;
        }
        if ((i2 & 2) != 0) {
            str = gameTestVisibilityEvent.backendName;
        }
        if ((i2 & 4) != 0) {
            z = gameTestVisibilityEvent.visible;
        }
        if ((i2 & 8) != 0) {
            j = gameTestVisibilityEvent.receivedAtMs;
        }
        boolean z2 = z;
        return gameTestVisibilityEvent.copy(i, str, z2, j);
    }

    public final int component1() {
        return this.backendId;
    }

    public final String component2() {
        return this.backendName;
    }

    public final boolean component3() {
        return this.visible;
    }

    public final long component4() {
        return this.receivedAtMs;
    }

    public final GameTestVisibilityEvent copy(int i, String backendName, boolean z, long j) {
        Intrinsics.checkNotNullParameter(backendName, "backendName");
        return new GameTestVisibilityEvent(i, backendName, z, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameTestVisibilityEvent) {
            GameTestVisibilityEvent gameTestVisibilityEvent = (GameTestVisibilityEvent) obj;
            return this.backendId == gameTestVisibilityEvent.backendId && Intrinsics.areEqual(this.backendName, gameTestVisibilityEvent.backendName) && this.visible == gameTestVisibilityEvent.visible && this.receivedAtMs == gameTestVisibilityEvent.receivedAtMs;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.backendId) * 31) + this.backendName.hashCode()) * 31) + Boolean.hashCode(this.visible)) * 31) + Long.hashCode(this.receivedAtMs);
    }

    public String toString() {
        int i = this.backendId;
        String str = this.backendName;
        boolean z = this.visible;
        return "GameTestVisibilityEvent(backendId=" + i + ", backendName=" + str + ", visible=" + z + ", receivedAtMs=" + this.receivedAtMs + ")";
    }

    public GameTestVisibilityEvent(int i, String backendName, boolean z, long j) {
        Intrinsics.checkNotNullParameter(backendName, "backendName");
        this.backendId = i;
        this.backendName = backendName;
        this.visible = z;
        this.receivedAtMs = j;
    }

    public final int getBackendId() {
        return this.backendId;
    }

    public final String getBackendName() {
        return this.backendName;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public /* synthetic */ GameTestVisibilityEvent(int i, String str, boolean z, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, z, (i2 & 8) != 0 ? System.currentTimeMillis() : j);
    }

    public final long getReceivedAtMs() {
        return this.receivedAtMs;
    }

    public final String describe() {
        int i = this.backendId;
        String str = this.backendName;
        return "backendId=" + i + ", backendName=" + str + ", visible=" + this.visible;
    }
}
