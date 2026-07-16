package ru.mrlargha.commonui.elements.dialogs;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.vending.expansion.downloader.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DialogBankHistory.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016J\f\u0010\u0017\u001a\u00020\u0005H\u0007b\u0002\b\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006("}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryRow;", "", "id", "", "operationType", "", "commission", TypedValues.AttributesType.S_TARGET, "amount", "date", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getOperationType", "()I", "getCommission", "getTarget", "getAmount", "getDate", "operationTitle", "context", "Landroid/content/Context;", "operationIconRes", "Landroidx/annotation/DrawableRes;", "amountText", "", "commissionBadgeText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBankHistoryRow {
    private final String amount;
    private final String commission;
    private final String date;
    private final String id;
    private final int operationType;
    private final String target;

    public static /* synthetic */ DialogBankHistoryRow copy$default(DialogBankHistoryRow dialogBankHistoryRow, String str, int i, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = dialogBankHistoryRow.id;
        }
        if ((i2 & 2) != 0) {
            i = dialogBankHistoryRow.operationType;
        }
        if ((i2 & 4) != 0) {
            str2 = dialogBankHistoryRow.commission;
        }
        if ((i2 & 8) != 0) {
            str3 = dialogBankHistoryRow.target;
        }
        if ((i2 & 16) != 0) {
            str4 = dialogBankHistoryRow.amount;
        }
        if ((i2 & 32) != 0) {
            str5 = dialogBankHistoryRow.date;
        }
        String str6 = str4;
        String str7 = str5;
        return dialogBankHistoryRow.copy(str, i, str2, str3, str6, str7);
    }

    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.operationType;
    }

    public final String component3() {
        return this.commission;
    }

    public final String component4() {
        return this.target;
    }

    public final String component5() {
        return this.amount;
    }

    public final String component6() {
        return this.date;
    }

    public final DialogBankHistoryRow copy(String id, int i, String commission, String target, String amount, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(commission, "commission");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(date, "date");
        return new DialogBankHistoryRow(id, i, commission, target, amount, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogBankHistoryRow) {
            DialogBankHistoryRow dialogBankHistoryRow = (DialogBankHistoryRow) obj;
            return Intrinsics.areEqual(this.id, dialogBankHistoryRow.id) && this.operationType == dialogBankHistoryRow.operationType && Intrinsics.areEqual(this.commission, dialogBankHistoryRow.commission) && Intrinsics.areEqual(this.target, dialogBankHistoryRow.target) && Intrinsics.areEqual(this.amount, dialogBankHistoryRow.amount) && Intrinsics.areEqual(this.date, dialogBankHistoryRow.date);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + Integer.hashCode(this.operationType)) * 31) + this.commission.hashCode()) * 31) + this.target.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.date.hashCode();
    }

    public String toString() {
        String str = this.id;
        int i = this.operationType;
        String str2 = this.commission;
        String str3 = this.target;
        String str4 = this.amount;
        return "DialogBankHistoryRow(id=" + str + ", operationType=" + i + ", commission=" + str2 + ", target=" + str3 + ", amount=" + str4 + ", date=" + this.date + ")";
    }

    public DialogBankHistoryRow(String id, int i, String commission, String target, String amount, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(commission, "commission");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(date, "date");
        this.id = id;
        this.operationType = i;
        this.commission = commission;
        this.target = target;
        this.amount = amount;
        this.date = date;
    }

    public final String getId() {
        return this.id;
    }

    public final int getOperationType() {
        return this.operationType;
    }

    public final String getCommission() {
        return this.commission;
    }

    public final String getTarget() {
        return this.target;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getDate() {
        return this.date;
    }

    public final String operationTitle(Context context) {
        Integer valueOf;
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        int i = this.operationType;
        if (i == 0) {
            valueOf = Integer.valueOf(R.string.dialog_bank_history_operation_withdraw);
        } else if (i == 1) {
            valueOf = Integer.valueOf(R.string.dialog_bank_history_operation_deposit);
        } else if (i == 2) {
            valueOf = Integer.valueOf(R.string.dialog_bank_history_operation_topup);
        } else if (i == 3) {
            valueOf = Integer.valueOf(R.string.dialog_bank_history_operation_transfer);
        } else {
            valueOf = i != 4 ? null : Integer.valueOf(R.string.dialog_bank_history_operation_indexation);
        }
        return (valueOf == null || (string = context.getString(valueOf.intValue())) == null) ? String.valueOf(this.operationType) : string;
    }

    public final int operationIconRes() {
        int i = this.operationType;
        if (i != 0) {
            if (i == 3) {
                return R.drawable.dialog_bank_history_ic_translate;
            }
            return R.drawable.dialog_bank_history_ic_replenish;
        }
        return R.drawable.dialog_bank_history_ic_take_off;
    }

    public final CharSequence amountText() {
        long absSafe;
        String str = this.amount;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt) || charAt == '-') {
                sb.append(charAt);
            }
        }
        Long longOrNull = StringsKt.toLongOrNull(sb.toString());
        String str2 = Constants.FILENAME_SEQUENCE_SEPARATOR;
        if (longOrNull == null) {
            String str3 = this.amount;
            if (!StringsKt.isBlank(str3)) {
                str2 = str3;
            }
            return str2;
        }
        long longValue = longOrNull.longValue();
        if (longValue >= 0) {
            str2 = "";
        }
        MoneyFormatter moneyFormatter = MoneyFormatter.INSTANCE;
        absSafe = DialogBankHistoryKt.absSafe(longValue);
        return str2 + "$ " + moneyFormatter.formatPlain(absSafe);
    }

    public final String commissionBadgeText() {
        String obj = StringsKt.trim((CharSequence) this.commission).toString();
        if (StringsKt.isBlank(obj) || Intrinsics.areEqual(obj, Constants.FILENAME_SEQUENCE_SEPARATOR) || Intrinsics.areEqual(obj, "0") || Intrinsics.areEqual(obj, "0%")) {
            return "";
        }
        return StringsKt.endsWith$default(obj, "%", false, 2, (Object) null) ? obj : obj + "%";
    }
}
