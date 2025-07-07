package com.miami.game.feature.download.screen.ui.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: DownloadScreenUiAction.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiAction;", "", "<init>", "()V", "NavigateToHome", "NoNetworkError", "Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiAction$NavigateToHome;", "Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiAction$NoNetworkError;", "download-screen_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class DownloadScreenUiAction {
    public static final int $stable = 0;

    public /* synthetic */ DownloadScreenUiAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: DownloadScreenUiAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiAction$NavigateToHome;", "Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "download-screen_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NavigateToHome extends DownloadScreenUiAction {
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
            return -1144513646;
        }

        public String toString() {
            return "NavigateToHome";
        }

        private NavigateToHome() {
            super(null);
        }
    }

    private DownloadScreenUiAction() {
    }

    /* compiled from: DownloadScreenUiAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiAction$NoNetworkError;", "Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "download-screen_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NoNetworkError extends DownloadScreenUiAction {
        public static final int $stable = 0;
        public static final NoNetworkError INSTANCE = new NoNetworkError();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NoNetworkError) {
                NoNetworkError noNetworkError = (NoNetworkError) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 847773090;
        }

        public String toString() {
            return "NoNetworkError";
        }

        private NoNetworkError() {
            super(null);
        }
    }
}
