package com.miami.game.feature.notifications.presentation;

import com.miami.game.core.drawable.resources.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: uiState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/miami/game/feature/notifications/presentation/NotificationsUiState;", "", "backGroundId", "", "isArizona", "", "<init>", "(IZ)V", "getBackGroundId", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "notifications_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NotificationsUiState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int backGroundId;
    private final boolean isArizona;

    public static /* synthetic */ NotificationsUiState copy$default(NotificationsUiState notificationsUiState, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = notificationsUiState.backGroundId;
        }
        if ((i2 & 2) != 0) {
            z = notificationsUiState.isArizona;
        }
        return notificationsUiState.copy(i, z);
    }

    public final int component1() {
        return this.backGroundId;
    }

    public final boolean component2() {
        return this.isArizona;
    }

    public final NotificationsUiState copy(int i, boolean z) {
        return new NotificationsUiState(i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NotificationsUiState) {
            NotificationsUiState notificationsUiState = (NotificationsUiState) obj;
            return this.backGroundId == notificationsUiState.backGroundId && this.isArizona == notificationsUiState.isArizona;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.backGroundId) * 31) + Boolean.hashCode(this.isArizona);
    }

    public String toString() {
        int i = this.backGroundId;
        return "NotificationsUiState(backGroundId=" + i + ", isArizona=" + this.isArizona + ")";
    }

    public NotificationsUiState(int i, boolean z) {
        this.backGroundId = i;
        this.isArizona = z;
    }

    public final int getBackGroundId() {
        return this.backGroundId;
    }

    public final boolean isArizona() {
        return this.isArizona;
    }

    /* compiled from: uiState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/feature/notifications/presentation/NotificationsUiState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/notifications/presentation/NotificationsUiState;", "isArizona", "", "notifications_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NotificationsUiState initial(boolean z) {
            return new NotificationsUiState(z ? R.drawable.bg_arizona : R.drawable.bg_rodina, z);
        }
    }
}
