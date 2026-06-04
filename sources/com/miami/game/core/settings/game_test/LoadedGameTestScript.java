package com.miami.game.core.settings.game_test;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameTestScriptModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/miami/game/core/settings/game_test/LoadedGameTestScript;", "", "displayName", "", "sourceLabel", "script", "Lcom/miami/game/core/settings/game_test/GameTestScript;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/miami/game/core/settings/game_test/GameTestScript;)V", "getDisplayName", "()Ljava/lang/String;", "getSourceLabel", "getScript", "()Lcom/miami/game/core/settings/game_test/GameTestScript;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoadedGameTestScript {
    private final String displayName;
    private final GameTestScript script;
    private final String sourceLabel;

    public static /* synthetic */ LoadedGameTestScript copy$default(LoadedGameTestScript loadedGameTestScript, String str, String str2, GameTestScript gameTestScript, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loadedGameTestScript.displayName;
        }
        if ((i & 2) != 0) {
            str2 = loadedGameTestScript.sourceLabel;
        }
        if ((i & 4) != 0) {
            gameTestScript = loadedGameTestScript.script;
        }
        return loadedGameTestScript.copy(str, str2, gameTestScript);
    }

    public final String component1() {
        return this.displayName;
    }

    public final String component2() {
        return this.sourceLabel;
    }

    public final GameTestScript component3() {
        return this.script;
    }

    public final LoadedGameTestScript copy(String displayName, String sourceLabel, GameTestScript script) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(sourceLabel, "sourceLabel");
        Intrinsics.checkNotNullParameter(script, "script");
        return new LoadedGameTestScript(displayName, sourceLabel, script);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LoadedGameTestScript) {
            LoadedGameTestScript loadedGameTestScript = (LoadedGameTestScript) obj;
            return Intrinsics.areEqual(this.displayName, loadedGameTestScript.displayName) && Intrinsics.areEqual(this.sourceLabel, loadedGameTestScript.sourceLabel) && Intrinsics.areEqual(this.script, loadedGameTestScript.script);
        }
        return false;
    }

    public int hashCode() {
        return (((this.displayName.hashCode() * 31) + this.sourceLabel.hashCode()) * 31) + this.script.hashCode();
    }

    public String toString() {
        String str = this.displayName;
        String str2 = this.sourceLabel;
        return "LoadedGameTestScript(displayName=" + str + ", sourceLabel=" + str2 + ", script=" + this.script + ")";
    }

    public LoadedGameTestScript(String displayName, String sourceLabel, GameTestScript script) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(sourceLabel, "sourceLabel");
        Intrinsics.checkNotNullParameter(script, "script");
        this.displayName = displayName;
        this.sourceLabel = sourceLabel;
        this.script = script;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getSourceLabel() {
        return this.sourceLabel;
    }

    public final GameTestScript getScript() {
        return this.script;
    }
}
