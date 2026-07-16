package ru.mrlargha.commonui.elements.dialogs;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: DialogPlaceholderModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogInputCommissionTier;", "", "from", "", "percent", "", "<init>", "(JI)V", "getFrom", "()J", "getPercent", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogInputCommissionTier {
    private final long from;
    private final int percent;

    public DialogInputCommissionTier() {
        this(0L, 0, 3, null);
    }

    public static /* synthetic */ DialogInputCommissionTier copy$default(DialogInputCommissionTier dialogInputCommissionTier, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = dialogInputCommissionTier.from;
        }
        if ((i2 & 2) != 0) {
            i = dialogInputCommissionTier.percent;
        }
        return dialogInputCommissionTier.copy(j, i);
    }

    public final long component1() {
        return this.from;
    }

    public final int component2() {
        return this.percent;
    }

    public final DialogInputCommissionTier copy(long j, int i) {
        return new DialogInputCommissionTier(j, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogInputCommissionTier) {
            DialogInputCommissionTier dialogInputCommissionTier = (DialogInputCommissionTier) obj;
            return this.from == dialogInputCommissionTier.from && this.percent == dialogInputCommissionTier.percent;
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.from) * 31) + Integer.hashCode(this.percent);
    }

    public String toString() {
        long j = this.from;
        return "DialogInputCommissionTier(from=" + j + ", percent=" + this.percent + ")";
    }

    public DialogInputCommissionTier(long j, int i) {
        this.from = j;
        this.percent = i;
    }

    public /* synthetic */ DialogInputCommissionTier(long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? 0 : i);
    }

    public final long getFrom() {
        return this.from;
    }

    public final int getPercent() {
        return this.percent;
    }
}
