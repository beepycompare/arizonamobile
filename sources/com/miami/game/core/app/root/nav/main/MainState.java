package com.miami.game.core.app.root.nav.main;

import androidx.navigation.compose.DialogNavigator;
import com.miami.game.core.app.root.nav.main.DialogMainState;
import com.miami.game.core.app.root.nav.main.ScreenMainState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MainState.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainState;", "", DialogNavigator.NAME, "Lcom/miami/game/core/app/root/nav/main/DialogMainState;", "screen", "Lcom/miami/game/core/app/root/nav/main/ScreenMainState;", "<init>", "(Lcom/miami/game/core/app/root/nav/main/DialogMainState;Lcom/miami/game/core/app/root/nav/main/ScreenMainState;)V", "getDialog", "()Lcom/miami/game/core/app/root/nav/main/DialogMainState;", "getScreen", "()Lcom/miami/game/core/app/root/nav/main/ScreenMainState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MainState {
    public static final int $stable = 0;
    private final DialogMainState dialog;
    private final ScreenMainState screen;

    public MainState() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ MainState copy$default(MainState mainState, DialogMainState dialogMainState, ScreenMainState screenMainState, int i, Object obj) {
        if ((i & 1) != 0) {
            dialogMainState = mainState.dialog;
        }
        if ((i & 2) != 0) {
            screenMainState = mainState.screen;
        }
        return mainState.copy(dialogMainState, screenMainState);
    }

    public final DialogMainState component1() {
        return this.dialog;
    }

    public final ScreenMainState component2() {
        return this.screen;
    }

    public final MainState copy(DialogMainState dialog, ScreenMainState screen) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(screen, "screen");
        return new MainState(dialog, screen);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MainState) {
            MainState mainState = (MainState) obj;
            return Intrinsics.areEqual(this.dialog, mainState.dialog) && Intrinsics.areEqual(this.screen, mainState.screen);
        }
        return false;
    }

    public int hashCode() {
        return (this.dialog.hashCode() * 31) + this.screen.hashCode();
    }

    public String toString() {
        DialogMainState dialogMainState = this.dialog;
        return "MainState(dialog=" + dialogMainState + ", screen=" + this.screen + ")";
    }

    public MainState(DialogMainState dialog, ScreenMainState screen) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.dialog = dialog;
        this.screen = screen;
    }

    public /* synthetic */ MainState(DialogMainState.Empty empty, ScreenMainState.HomeScreen homeScreen, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DialogMainState.Empty.INSTANCE : empty, (i & 2) != 0 ? new ScreenMainState.HomeScreen(false, 1, null) : homeScreen);
    }

    public final DialogMainState getDialog() {
        return this.dialog;
    }

    public final ScreenMainState getScreen() {
        return this.screen;
    }
}
