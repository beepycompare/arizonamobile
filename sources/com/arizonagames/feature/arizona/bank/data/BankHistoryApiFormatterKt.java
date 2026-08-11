package com.arizonagames.feature.arizona.bank.data;

import com.arizonagames.feature.arizona.bank.BankAccountHistoryApiItem;
import com.arizonagames.feature.arizona.bank.BankDepositHistoryApiItem;
import com.arizonagames.feature.arizona.bank.BankOrganizationHistoryApiItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankHistoryApiFormatter.kt */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003*\u0001\r\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0000\u001a\u0012\u0010\b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0\u0004H\u0000\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"COLUMN_SEPARATOR", "", "EMPTY_CELL", "toAccountHistoryDialogBody", "", "Lcom/arizonagames/feature/arizona/bank/BankAccountHistoryApiItem;", "toDepositHistoryDialogBody", "Lcom/arizonagames/feature/arizona/bank/BankDepositHistoryApiItem;", "toOrganizationHistoryDialogBody", "Lcom/arizonagames/feature/arizona/bank/BankOrganizationHistoryApiItem;", "toBankHistoryDateText", "", "BANK_HISTORY_DATE_FORMAT", "com/arizonagames/feature/arizona/bank/data/BankHistoryApiFormatterKt$BANK_HISTORY_DATE_FORMAT$1", "Lcom/arizonagames/feature/arizona/bank/data/BankHistoryApiFormatterKt$BANK_HISTORY_DATE_FORMAT$1;", "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankHistoryApiFormatterKt {
    private static final BankHistoryApiFormatterKt$BANK_HISTORY_DATE_FORMAT$1 BANK_HISTORY_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: com.arizonagames.feature.arizona.bank.data.BankHistoryApiFormatterKt$BANK_HISTORY_DATE_FORMAT$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault());
        }
    };
    private static final String COLUMN_SEPARATOR = "\t";
    private static final String EMPTY_CELL = "";

    public static final String toAccountHistoryDialogBody(List<BankAccountHistoryApiItem> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt.joinToString$default(list, "\n", null, null, 0, null, new Function1() { // from class: com.arizonagames.feature.arizona.bank.data.BankHistoryApiFormatterKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BankHistoryApiFormatterKt.toAccountHistoryDialogBody$lambda$0((BankAccountHistoryApiItem) obj);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence toAccountHistoryDialogBody$lambda$0(BankAccountHistoryApiItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{String.valueOf(item.getId()), String.valueOf(item.getType()), item.getCommission(), item.getTargetName(), String.valueOf(item.getMoney()), toBankHistoryDateText(item.getTimestamp())}), COLUMN_SEPARATOR, null, null, 0, null, null, 62, null);
    }

    public static final String toDepositHistoryDialogBody(List<BankDepositHistoryApiItem> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt.joinToString$default(list, "\n", null, null, 0, null, new Function1() { // from class: com.arizonagames.feature.arizona.bank.data.BankHistoryApiFormatterKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BankHistoryApiFormatterKt.toDepositHistoryDialogBody$lambda$0((BankDepositHistoryApiItem) obj);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence toDepositHistoryDialogBody$lambda$0(BankDepositHistoryApiItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{String.valueOf(item.getId()), String.valueOf(item.getType()), "0", "", String.valueOf(item.getMoney()), toBankHistoryDateText(item.getTimestamp())}), COLUMN_SEPARATOR, null, null, 0, null, null, 62, null);
    }

    public static final String toOrganizationHistoryDialogBody(List<BankOrganizationHistoryApiItem> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt.joinToString$default(list, "\n", null, null, 0, null, new Function1() { // from class: com.arizonagames.feature.arizona.bank.data.BankHistoryApiFormatterKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BankHistoryApiFormatterKt.toOrganizationHistoryDialogBody$lambda$0((BankOrganizationHistoryApiItem) obj);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence toOrganizationHistoryDialogBody$lambda$0(BankOrganizationHistoryApiItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        String[] strArr = new String[6];
        strArr[0] = String.valueOf(item.getId());
        strArr[1] = String.valueOf(item.getType());
        strArr[2] = "0";
        strArr[3] = item.getPlayerName();
        strArr[4] = String.valueOf(item.getMoney());
        Long valueOf = Long.valueOf(item.getTimestamp());
        if (valueOf.longValue() <= 0) {
            valueOf = null;
        }
        String bankHistoryDateText = valueOf != null ? toBankHistoryDateText(valueOf.longValue()) : null;
        if (bankHistoryDateText == null) {
            bankHistoryDateText = "";
        }
        strArr[5] = bankHistoryDateText;
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) strArr), COLUMN_SEPARATOR, null, null, 0, null, null, 62, null);
    }

    private static final String toBankHistoryDateText(long j) {
        if (j <= 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = BANK_HISTORY_DATE_FORMAT.get();
        Intrinsics.checkNotNull(simpleDateFormat);
        String format = simpleDateFormat.format(new Date(j * 1000));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
