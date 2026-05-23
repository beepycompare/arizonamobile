package com.miami.game.core.settings.game_test;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameTestScriptModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestSavedScript;", "", "fileName", "", "displayName", "updatedAtMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getFileName", "()Ljava/lang/String;", "getDisplayName", "getUpdatedAtMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GameTestSavedScript {
    private final String displayName;
    private final String fileName;
    private final long updatedAtMs;

    public static /* synthetic */ GameTestSavedScript copy$default(GameTestSavedScript gameTestSavedScript, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameTestSavedScript.fileName;
        }
        if ((i & 2) != 0) {
            str2 = gameTestSavedScript.displayName;
        }
        if ((i & 4) != 0) {
            j = gameTestSavedScript.updatedAtMs;
        }
        return gameTestSavedScript.copy(str, str2, j);
    }

    public final String component1() {
        return this.fileName;
    }

    public final String component2() {
        return this.displayName;
    }

    public final long component3() {
        return this.updatedAtMs;
    }

    public final GameTestSavedScript copy(String fileName, String displayName, long j) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return new GameTestSavedScript(fileName, displayName, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameTestSavedScript) {
            GameTestSavedScript gameTestSavedScript = (GameTestSavedScript) obj;
            return Intrinsics.areEqual(this.fileName, gameTestSavedScript.fileName) && Intrinsics.areEqual(this.displayName, gameTestSavedScript.displayName) && this.updatedAtMs == gameTestSavedScript.updatedAtMs;
        }
        return false;
    }

    public int hashCode() {
        return (((this.fileName.hashCode() * 31) + this.displayName.hashCode()) * 31) + Long.hashCode(this.updatedAtMs);
    }

    public String toString() {
        String str = this.fileName;
        String str2 = this.displayName;
        return "GameTestSavedScript(fileName=" + str + ", displayName=" + str2 + ", updatedAtMs=" + this.updatedAtMs + ")";
    }

    public GameTestSavedScript(String fileName, String displayName, long j) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.fileName = fileName;
        this.displayName = displayName;
        this.updatedAtMs = j;
    }

    public /* synthetic */ GameTestSavedScript(String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? 0L : j);
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getUpdatedAtMs() {
        return this.updatedAtMs;
    }
}
