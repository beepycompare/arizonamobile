package com.miami.game.feature.download.dialog.ui.common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CommonDialogVmState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogVmState;", "", "isProgress", "", "descriptionText", "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getDescriptionText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CommonDialogVmState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String descriptionText;
    private final boolean isProgress;

    public static /* synthetic */ CommonDialogVmState copy$default(CommonDialogVmState commonDialogVmState, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = commonDialogVmState.isProgress;
        }
        if ((i & 2) != 0) {
            str = commonDialogVmState.descriptionText;
        }
        return commonDialogVmState.copy(z, str);
    }

    public final boolean component1() {
        return this.isProgress;
    }

    public final String component2() {
        return this.descriptionText;
    }

    public final CommonDialogVmState copy(boolean z, String descriptionText) {
        Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
        return new CommonDialogVmState(z, descriptionText);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommonDialogVmState) {
            CommonDialogVmState commonDialogVmState = (CommonDialogVmState) obj;
            return this.isProgress == commonDialogVmState.isProgress && Intrinsics.areEqual(this.descriptionText, commonDialogVmState.descriptionText);
        }
        return false;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isProgress) * 31) + this.descriptionText.hashCode();
    }

    public String toString() {
        boolean z = this.isProgress;
        return "CommonDialogVmState(isProgress=" + z + ", descriptionText=" + this.descriptionText + ")";
    }

    public CommonDialogVmState(boolean z, String descriptionText) {
        Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
        this.isProgress = z;
        this.descriptionText = descriptionText;
    }

    public final boolean isProgress() {
        return this.isProgress;
    }

    public final String getDescriptionText() {
        return this.descriptionText;
    }

    /* compiled from: CommonDialogVmState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogVmState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogVmState;", "descriptionText", "", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ CommonDialogVmState initial$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "";
            }
            return companion.initial(str);
        }

        public final CommonDialogVmState initial(String descriptionText) {
            Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
            return new CommonDialogVmState(false, descriptionText);
        }
    }
}
