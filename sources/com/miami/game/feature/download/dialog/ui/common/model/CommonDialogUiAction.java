package com.miami.game.feature.download.dialog.ui.common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: CommonDialogUiAction.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiAction;", "", "<init>", "()V", "Confirm", "Cancel", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiAction$Cancel;", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiAction$Confirm;", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class CommonDialogUiAction {
    public static final int $stable = 0;

    public /* synthetic */ CommonDialogUiAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: CommonDialogUiAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiAction$Confirm;", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Confirm extends CommonDialogUiAction {
        public static final int $stable = 0;
        public static final Confirm INSTANCE = new Confirm();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Confirm) {
                Confirm confirm = (Confirm) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 955684887;
        }

        public String toString() {
            return "Confirm";
        }

        private Confirm() {
            super(null);
        }
    }

    private CommonDialogUiAction() {
    }

    /* compiled from: CommonDialogUiAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiAction$Cancel;", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Cancel extends CommonDialogUiAction {
        public static final int $stable = 0;
        public static final Cancel INSTANCE = new Cancel();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Cancel) {
                Cancel cancel = (Cancel) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 849180227;
        }

        public String toString() {
            return "Cancel";
        }

        private Cancel() {
            super(null);
        }
    }
}
