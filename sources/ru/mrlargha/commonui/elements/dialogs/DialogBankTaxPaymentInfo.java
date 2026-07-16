package ru.mrlargha.commonui.elements.dialogs;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogBankTaxPayment.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentInfo;", "", "id", "", "name", "", FirebaseAnalytics.Param.TAX, "", "<init>", "(ILjava/lang/String;J)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getTax", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBankTaxPaymentInfo {
    private final int id;
    private final String name;
    private final long tax;

    public DialogBankTaxPaymentInfo() {
        this(0, null, 0L, 7, null);
    }

    public static /* synthetic */ DialogBankTaxPaymentInfo copy$default(DialogBankTaxPaymentInfo dialogBankTaxPaymentInfo, int i, String str, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dialogBankTaxPaymentInfo.id;
        }
        if ((i2 & 2) != 0) {
            str = dialogBankTaxPaymentInfo.name;
        }
        if ((i2 & 4) != 0) {
            j = dialogBankTaxPaymentInfo.tax;
        }
        return dialogBankTaxPaymentInfo.copy(i, str, j);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final long component3() {
        return this.tax;
    }

    public final DialogBankTaxPaymentInfo copy(int i, String name, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DialogBankTaxPaymentInfo(i, name, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogBankTaxPaymentInfo) {
            DialogBankTaxPaymentInfo dialogBankTaxPaymentInfo = (DialogBankTaxPaymentInfo) obj;
            return this.id == dialogBankTaxPaymentInfo.id && Intrinsics.areEqual(this.name, dialogBankTaxPaymentInfo.name) && this.tax == dialogBankTaxPaymentInfo.tax;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Long.hashCode(this.tax);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        return "DialogBankTaxPaymentInfo(id=" + i + ", name=" + str + ", tax=" + this.tax + ")";
    }

    public DialogBankTaxPaymentInfo(int i, String name, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.tax = j;
    }

    public final int getId() {
        return this.id;
    }

    public /* synthetic */ DialogBankTaxPaymentInfo(int i, String str, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0L : j);
    }

    public final String getName() {
        return this.name;
    }

    public final long getTax() {
        return this.tax;
    }
}
