package com.miami.game.feature.download.dialog.ui.error.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ErrorDialogUiState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;", "", "isProgress", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorDialogUiState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final boolean isProgress;

    public static /* synthetic */ ErrorDialogUiState copy$default(ErrorDialogUiState errorDialogUiState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = errorDialogUiState.isProgress;
        }
        return errorDialogUiState.copy(z);
    }

    public final boolean component1() {
        return this.isProgress;
    }

    public final ErrorDialogUiState copy(boolean z) {
        return new ErrorDialogUiState(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ErrorDialogUiState) && this.isProgress == ((ErrorDialogUiState) obj).isProgress;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isProgress);
    }

    public String toString() {
        return "ErrorDialogUiState(isProgress=" + this.isProgress + ")";
    }

    public ErrorDialogUiState(boolean z) {
        this.isProgress = z;
    }

    public final boolean isProgress() {
        return this.isProgress;
    }

    /* compiled from: ErrorDialogUiState.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ErrorDialogUiState initial() {
            return new ErrorDialogUiState(false);
        }
    }
}
