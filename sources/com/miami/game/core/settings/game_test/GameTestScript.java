package com.miami.game.core.settings.game_test;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameTestScriptModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestScript;", "", "name", "", "startTrigger", "Lcom/miami/game/core/settings/game_test/GameTestStartTrigger;", "listeners", "", "Lcom/miami/game/core/settings/game_test/GameTestBackendMessageListener;", "steps", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "<init>", "(Ljava/lang/String;Lcom/miami/game/core/settings/game_test/GameTestStartTrigger;Ljava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getStartTrigger", "()Lcom/miami/game/core/settings/game_test/GameTestStartTrigger;", "getListeners", "()Ljava/util/List;", "getSteps", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GameTestScript {
    private final List<GameTestBackendMessageListener> listeners;
    private final String name;
    private final GameTestStartTrigger startTrigger;
    private final List<GameTestStep> steps;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameTestScript copy$default(GameTestScript gameTestScript, String str, GameTestStartTrigger gameTestStartTrigger, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameTestScript.name;
        }
        if ((i & 2) != 0) {
            gameTestStartTrigger = gameTestScript.startTrigger;
        }
        if ((i & 4) != 0) {
            list = gameTestScript.listeners;
        }
        if ((i & 8) != 0) {
            list2 = gameTestScript.steps;
        }
        return gameTestScript.copy(str, gameTestStartTrigger, list, list2);
    }

    public final String component1() {
        return this.name;
    }

    public final GameTestStartTrigger component2() {
        return this.startTrigger;
    }

    public final List<GameTestBackendMessageListener> component3() {
        return this.listeners;
    }

    public final List<GameTestStep> component4() {
        return this.steps;
    }

    public final GameTestScript copy(String name, GameTestStartTrigger startTrigger, List<GameTestBackendMessageListener> listeners, List<? extends GameTestStep> steps) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(startTrigger, "startTrigger");
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        Intrinsics.checkNotNullParameter(steps, "steps");
        return new GameTestScript(name, startTrigger, listeners, steps);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameTestScript) {
            GameTestScript gameTestScript = (GameTestScript) obj;
            return Intrinsics.areEqual(this.name, gameTestScript.name) && this.startTrigger == gameTestScript.startTrigger && Intrinsics.areEqual(this.listeners, gameTestScript.listeners) && Intrinsics.areEqual(this.steps, gameTestScript.steps);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.startTrigger.hashCode()) * 31) + this.listeners.hashCode()) * 31) + this.steps.hashCode();
    }

    public String toString() {
        String str = this.name;
        GameTestStartTrigger gameTestStartTrigger = this.startTrigger;
        List<GameTestBackendMessageListener> list = this.listeners;
        return "GameTestScript(name=" + str + ", startTrigger=" + gameTestStartTrigger + ", listeners=" + list + ", steps=" + this.steps + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GameTestScript(String name, GameTestStartTrigger startTrigger, List<GameTestBackendMessageListener> listeners, List<? extends GameTestStep> steps) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(startTrigger, "startTrigger");
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        Intrinsics.checkNotNullParameter(steps, "steps");
        this.name = name;
        this.startTrigger = startTrigger;
        this.listeners = listeners;
        this.steps = steps;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ GameTestScript(String str, GameTestStartTrigger gameTestStartTrigger, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? GameTestStartTrigger.ON_LOGIN : gameTestStartTrigger, (i & 4) != 0 ? CollectionsKt.emptyList() : list, list2);
    }

    public final GameTestStartTrigger getStartTrigger() {
        return this.startTrigger;
    }

    public final List<GameTestBackendMessageListener> getListeners() {
        return this.listeners;
    }

    public final List<GameTestStep> getSteps() {
        return this.steps;
    }
}
