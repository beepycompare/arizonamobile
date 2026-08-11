package com.arizonagames.feature.arizona.bank.pages;

import com.arizonagames.feature.arizona.bank.BankCurrencyHistoryInfo;
import com.arizonagames.feature.arizona.bank.BankCurrencyInfo;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
/* compiled from: BankCurrencyPageController.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0000\u001a\u001a\u0010\f\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"valuesFor", "", "", "Lcom/arizonagames/feature/arizona/bank/BankCurrencyHistoryInfo;", "range", "Lcom/arizonagames/feature/arizona/bank/pages/CurrencyHistoryRange;", "resolveCurrencyPercent", "", FirebaseAnalytics.Param.CURRENCY, "Lcom/arizonagames/feature/arizona/bank/BankCurrencyInfo;", "history", "fallbackPercent", "currencyValue", FirebaseAnalytics.Param.INDEX, "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankCurrencyPageControllerKt {

    /* compiled from: BankCurrencyPageController.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CurrencyHistoryRange.values().length];
            try {
                iArr[CurrencyHistoryRange.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CurrencyHistoryRange.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CurrencyHistoryRange.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Long> valuesFor(BankCurrencyHistoryInfo bankCurrencyHistoryInfo, CurrencyHistoryRange currencyHistoryRange) {
        int i = WhenMappings.$EnumSwitchMapping$0[currencyHistoryRange.ordinal()];
        List<Long> list = null;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (bankCurrencyHistoryInfo != null) {
                    list = bankCurrencyHistoryInfo.getMonth();
                }
            } else if (bankCurrencyHistoryInfo != null) {
                list = bankCurrencyHistoryInfo.getWeek();
            }
        } else if (bankCurrencyHistoryInfo != null) {
            list = bankCurrencyHistoryInfo.getDay();
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final int resolveCurrencyPercent(BankCurrencyInfo bankCurrencyInfo, BankCurrencyHistoryInfo bankCurrencyHistoryInfo, int i) {
        Integer percent;
        return (bankCurrencyInfo == null || (percent = bankCurrencyInfo.getPercent()) == null) ? bankCurrencyHistoryInfo != null ? bankCurrencyHistoryInfo.getDiff() : i : percent.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long currencyValue(List<Long> list, int i) {
        Long l = (Long) CollectionsKt.getOrNull(list, i);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }
}
