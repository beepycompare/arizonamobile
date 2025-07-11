package com.miami.game.core.app.root.nav.main;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: MainState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/ScreenMainState;", "", "<init>", "()V", "HomeScreen", "Lcom/miami/game/core/app/root/nav/main/ScreenMainState$HomeScreen;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ScreenMainState {
    public static final int $stable = 0;

    public /* synthetic */ ScreenMainState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: MainState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/ScreenMainState$HomeScreen;", "Lcom/miami/game/core/app/root/nav/main/ScreenMainState;", "isCheckUpdate", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class HomeScreen extends ScreenMainState {
        public static final int $stable = 0;
        private final boolean isCheckUpdate;

        public HomeScreen() {
            this(false, 1, null);
        }

        public static /* synthetic */ HomeScreen copy$default(HomeScreen homeScreen, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = homeScreen.isCheckUpdate;
            }
            return homeScreen.copy(z);
        }

        public final boolean component1() {
            return this.isCheckUpdate;
        }

        public final HomeScreen copy(boolean z) {
            return new HomeScreen(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HomeScreen) && this.isCheckUpdate == ((HomeScreen) obj).isCheckUpdate;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isCheckUpdate);
        }

        public String toString() {
            return "HomeScreen(isCheckUpdate=" + this.isCheckUpdate + ")";
        }

        public HomeScreen(boolean z) {
            super(null);
            this.isCheckUpdate = z;
        }

        public /* synthetic */ HomeScreen(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean isCheckUpdate() {
            return this.isCheckUpdate;
        }
    }

    private ScreenMainState() {
    }
}
