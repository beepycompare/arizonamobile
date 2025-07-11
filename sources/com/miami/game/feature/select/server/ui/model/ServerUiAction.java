package com.miami.game.feature.select.server.ui.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ServerUiState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/miami/game/feature/select/server/ui/model/ServerUiAction;", "", "<init>", "()V", "NavigateToHome", "Lcom/miami/game/feature/select/server/ui/model/ServerUiAction$NavigateToHome;", "select-server_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ServerUiAction {
    public static final int $stable = 0;

    public /* synthetic */ ServerUiAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ServerUiState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/select/server/ui/model/ServerUiAction$NavigateToHome;", "Lcom/miami/game/feature/select/server/ui/model/ServerUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "select-server_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NavigateToHome extends ServerUiAction {
        public static final int $stable = 0;
        public static final NavigateToHome INSTANCE = new NavigateToHome();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NavigateToHome) {
                NavigateToHome navigateToHome = (NavigateToHome) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -147123520;
        }

        public String toString() {
            return "NavigateToHome";
        }

        private NavigateToHome() {
            super(null);
        }
    }

    private ServerUiAction() {
    }
}
