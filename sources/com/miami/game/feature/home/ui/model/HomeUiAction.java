package com.miami.game.feature.home.ui.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HomeUiAction.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeUiAction;", "", "<init>", "()V", "NavigateToSettings", "NavigateToSelectServers", "NavigateToDownloadDialog", "NavigateToDownloadScreen", "NavigateToErrorDialog", "NavigateToRepairGameSuccess", "NavigateToNotification", "NotifyHwIsNotAllowed", "Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToDownloadDialog;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToDownloadScreen;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToErrorDialog;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToNotification;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToRepairGameSuccess;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToSelectServers;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToSettings;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction$NotifyHwIsNotAllowed;", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class HomeUiAction {
    public static final int $stable = 0;

    public /* synthetic */ HomeUiAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: HomeUiAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToSettings;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NavigateToSettings extends HomeUiAction {
        public static final int $stable = 0;
        public static final NavigateToSettings INSTANCE = new NavigateToSettings();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NavigateToSettings) {
                NavigateToSettings navigateToSettings = (NavigateToSettings) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 816095242;
        }

        public String toString() {
            return "NavigateToSettings";
        }

        private NavigateToSettings() {
            super(null);
        }
    }

    private HomeUiAction() {
    }

    /* compiled from: HomeUiAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToSelectServers;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NavigateToSelectServers extends HomeUiAction {
        public static final int $stable = 0;
        public static final NavigateToSelectServers INSTANCE = new NavigateToSelectServers();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NavigateToSelectServers) {
                NavigateToSelectServers navigateToSelectServers = (NavigateToSelectServers) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 2032549229;
        }

        public String toString() {
            return "NavigateToSelectServers";
        }

        private NavigateToSelectServers() {
            super(null);
        }
    }

    /* compiled from: HomeUiAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToDownloadDialog;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction;", "updateSize", "", "<init>", "(Ljava/lang/String;)V", "getUpdateSize", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NavigateToDownloadDialog extends HomeUiAction {
        public static final int $stable = 0;
        private final String updateSize;

        public static /* synthetic */ NavigateToDownloadDialog copy$default(NavigateToDownloadDialog navigateToDownloadDialog, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = navigateToDownloadDialog.updateSize;
            }
            return navigateToDownloadDialog.copy(str);
        }

        public final String component1() {
            return this.updateSize;
        }

        public final NavigateToDownloadDialog copy(String updateSize) {
            Intrinsics.checkNotNullParameter(updateSize, "updateSize");
            return new NavigateToDownloadDialog(updateSize);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NavigateToDownloadDialog) && Intrinsics.areEqual(this.updateSize, ((NavigateToDownloadDialog) obj).updateSize);
        }

        public int hashCode() {
            return this.updateSize.hashCode();
        }

        public String toString() {
            return "NavigateToDownloadDialog(updateSize=" + this.updateSize + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToDownloadDialog(String updateSize) {
            super(null);
            Intrinsics.checkNotNullParameter(updateSize, "updateSize");
            this.updateSize = updateSize;
        }

        public final String getUpdateSize() {
            return this.updateSize;
        }
    }

    /* compiled from: HomeUiAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToDownloadScreen;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NavigateToDownloadScreen extends HomeUiAction {
        public static final int $stable = 0;
        public static final NavigateToDownloadScreen INSTANCE = new NavigateToDownloadScreen();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NavigateToDownloadScreen) {
                NavigateToDownloadScreen navigateToDownloadScreen = (NavigateToDownloadScreen) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1177160123;
        }

        public String toString() {
            return "NavigateToDownloadScreen";
        }

        private NavigateToDownloadScreen() {
            super(null);
        }
    }

    /* compiled from: HomeUiAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToErrorDialog;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NavigateToErrorDialog extends HomeUiAction {
        public static final int $stable = 0;
        public static final NavigateToErrorDialog INSTANCE = new NavigateToErrorDialog();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NavigateToErrorDialog) {
                NavigateToErrorDialog navigateToErrorDialog = (NavigateToErrorDialog) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1298682921;
        }

        public String toString() {
            return "NavigateToErrorDialog";
        }

        private NavigateToErrorDialog() {
            super(null);
        }
    }

    /* compiled from: HomeUiAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToRepairGameSuccess;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NavigateToRepairGameSuccess extends HomeUiAction {
        public static final int $stable = 0;
        public static final NavigateToRepairGameSuccess INSTANCE = new NavigateToRepairGameSuccess();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NavigateToRepairGameSuccess) {
                NavigateToRepairGameSuccess navigateToRepairGameSuccess = (NavigateToRepairGameSuccess) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1546754595;
        }

        public String toString() {
            return "NavigateToRepairGameSuccess";
        }

        private NavigateToRepairGameSuccess() {
            super(null);
        }
    }

    /* compiled from: HomeUiAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeUiAction$NavigateToNotification;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NavigateToNotification extends HomeUiAction {
        public static final int $stable = 0;
        public static final NavigateToNotification INSTANCE = new NavigateToNotification();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NavigateToNotification) {
                NavigateToNotification navigateToNotification = (NavigateToNotification) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 296362322;
        }

        public String toString() {
            return "NavigateToNotification";
        }

        private NavigateToNotification() {
            super(null);
        }
    }

    /* compiled from: HomeUiAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeUiAction$NotifyHwIsNotAllowed;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NotifyHwIsNotAllowed extends HomeUiAction {
        public static final int $stable = 0;
        public static final NotifyHwIsNotAllowed INSTANCE = new NotifyHwIsNotAllowed();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NotifyHwIsNotAllowed) {
                NotifyHwIsNotAllowed notifyHwIsNotAllowed = (NotifyHwIsNotAllowed) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1301830578;
        }

        public String toString() {
            return "NotifyHwIsNotAllowed";
        }

        private NotifyHwIsNotAllowed() {
            super(null);
        }
    }
}
