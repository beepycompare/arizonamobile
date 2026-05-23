package com.miami.game.core.settings.game_test;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameTestScriptModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestBackendMessageListener;", "", "name", "", "matcher", "Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;", "once", "", "steps", "", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "<init>", "(Ljava/lang/String;Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;ZLjava/util/List;)V", "getName", "()Ljava/lang/String;", "getMatcher", "()Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;", "getOnce", "()Z", "getSteps", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GameTestBackendMessageListener {
    private final BackendMessageMatcher matcher;
    private final String name;
    private final boolean once;
    private final List<GameTestStep> steps;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameTestBackendMessageListener copy$default(GameTestBackendMessageListener gameTestBackendMessageListener, String str, BackendMessageMatcher backendMessageMatcher, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameTestBackendMessageListener.name;
        }
        if ((i & 2) != 0) {
            backendMessageMatcher = gameTestBackendMessageListener.matcher;
        }
        if ((i & 4) != 0) {
            z = gameTestBackendMessageListener.once;
        }
        if ((i & 8) != 0) {
            list = gameTestBackendMessageListener.steps;
        }
        return gameTestBackendMessageListener.copy(str, backendMessageMatcher, z, list);
    }

    public final String component1() {
        return this.name;
    }

    public final BackendMessageMatcher component2() {
        return this.matcher;
    }

    public final boolean component3() {
        return this.once;
    }

    public final List<GameTestStep> component4() {
        return this.steps;
    }

    public final GameTestBackendMessageListener copy(String name, BackendMessageMatcher matcher, boolean z, List<? extends GameTestStep> steps) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(steps, "steps");
        return new GameTestBackendMessageListener(name, matcher, z, steps);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameTestBackendMessageListener) {
            GameTestBackendMessageListener gameTestBackendMessageListener = (GameTestBackendMessageListener) obj;
            return Intrinsics.areEqual(this.name, gameTestBackendMessageListener.name) && Intrinsics.areEqual(this.matcher, gameTestBackendMessageListener.matcher) && this.once == gameTestBackendMessageListener.once && Intrinsics.areEqual(this.steps, gameTestBackendMessageListener.steps);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.matcher.hashCode()) * 31) + Boolean.hashCode(this.once)) * 31) + this.steps.hashCode();
    }

    public String toString() {
        String str = this.name;
        BackendMessageMatcher backendMessageMatcher = this.matcher;
        boolean z = this.once;
        return "GameTestBackendMessageListener(name=" + str + ", matcher=" + backendMessageMatcher + ", once=" + z + ", steps=" + this.steps + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GameTestBackendMessageListener(String name, BackendMessageMatcher matcher, boolean z, List<? extends GameTestStep> steps) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(steps, "steps");
        this.name = name;
        this.matcher = matcher;
        this.once = z;
        this.steps = steps;
    }

    public /* synthetic */ GameTestBackendMessageListener(String str, BackendMessageMatcher backendMessageMatcher, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, backendMessageMatcher, (i & 4) != 0 ? false : z, list);
    }

    public final String getName() {
        return this.name;
    }

    public final BackendMessageMatcher getMatcher() {
        return this.matcher;
    }

    public final boolean getOnce() {
        return this.once;
    }

    public final List<GameTestStep> getSteps() {
        return this.steps;
    }
}
