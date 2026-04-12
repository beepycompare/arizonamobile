package ru.mrlargha.commonui.elements.dialogs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogWithdrawLimitModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimit;", "", "limits", "Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;", "<init>", "(Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;)V", "getLimits", "()Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogWithdrawLimit {
    private final DialogWithdrawLimitModel limits;

    public static /* synthetic */ DialogWithdrawLimit copy$default(DialogWithdrawLimit dialogWithdrawLimit, DialogWithdrawLimitModel dialogWithdrawLimitModel, int i, Object obj) {
        if ((i & 1) != 0) {
            dialogWithdrawLimitModel = dialogWithdrawLimit.limits;
        }
        return dialogWithdrawLimit.copy(dialogWithdrawLimitModel);
    }

    public final DialogWithdrawLimitModel component1() {
        return this.limits;
    }

    public final DialogWithdrawLimit copy(DialogWithdrawLimitModel limits) {
        Intrinsics.checkNotNullParameter(limits, "limits");
        return new DialogWithdrawLimit(limits);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DialogWithdrawLimit) && Intrinsics.areEqual(this.limits, ((DialogWithdrawLimit) obj).limits);
    }

    public int hashCode() {
        return this.limits.hashCode();
    }

    public String toString() {
        return "DialogWithdrawLimit(limits=" + this.limits + ")";
    }

    public DialogWithdrawLimit(DialogWithdrawLimitModel limits) {
        Intrinsics.checkNotNullParameter(limits, "limits");
        this.limits = limits;
    }

    public final DialogWithdrawLimitModel getLimits() {
        return this.limits;
    }
}
