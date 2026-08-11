package com.arizonagames.feature.arizona.bank;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankExchangeCurrencyDialogPayload;", "", "bankBalance", "", FirebaseAnalytics.Param.CURRENCY, "", "headerInfo", "Lcom/arizonagames/feature/arizona/bank/BankDialogHeaderInfo;", "additionalInfo", "", "buttonsTimer", "", "<init>", "(JILcom/arizonagames/feature/arizona/bank/BankDialogHeaderInfo;Ljava/lang/String;Ljava/util/List;)V", "getBankBalance", "()J", "getCurrency", "()I", "getHeaderInfo", "()Lcom/arizonagames/feature/arizona/bank/BankDialogHeaderInfo;", "getAdditionalInfo", "()Ljava/lang/String;", "getButtonsTimer", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankExchangeCurrencyDialogPayload {
    private final String additionalInfo;
    private final long bankBalance;
    private final List<Integer> buttonsTimer;
    private final int currency;
    private final BankDialogHeaderInfo headerInfo;

    public BankExchangeCurrencyDialogPayload() {
        this(0L, 0, null, null, null, 31, null);
    }

    public static /* synthetic */ BankExchangeCurrencyDialogPayload copy$default(BankExchangeCurrencyDialogPayload bankExchangeCurrencyDialogPayload, long j, int i, BankDialogHeaderInfo bankDialogHeaderInfo, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = bankExchangeCurrencyDialogPayload.bankBalance;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            i = bankExchangeCurrencyDialogPayload.currency;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            bankDialogHeaderInfo = bankExchangeCurrencyDialogPayload.headerInfo;
        }
        BankDialogHeaderInfo bankDialogHeaderInfo2 = bankDialogHeaderInfo;
        if ((i2 & 8) != 0) {
            str = bankExchangeCurrencyDialogPayload.additionalInfo;
        }
        String str2 = str;
        List<Integer> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = bankExchangeCurrencyDialogPayload.buttonsTimer;
        }
        return bankExchangeCurrencyDialogPayload.copy(j2, i3, bankDialogHeaderInfo2, str2, list2);
    }

    public final long component1() {
        return this.bankBalance;
    }

    public final int component2() {
        return this.currency;
    }

    public final BankDialogHeaderInfo component3() {
        return this.headerInfo;
    }

    public final String component4() {
        return this.additionalInfo;
    }

    public final List<Integer> component5() {
        return this.buttonsTimer;
    }

    public final BankExchangeCurrencyDialogPayload copy(long j, int i, BankDialogHeaderInfo bankDialogHeaderInfo, String additionalInfo, List<Integer> buttonsTimer) {
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        Intrinsics.checkNotNullParameter(buttonsTimer, "buttonsTimer");
        return new BankExchangeCurrencyDialogPayload(j, i, bankDialogHeaderInfo, additionalInfo, buttonsTimer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankExchangeCurrencyDialogPayload) {
            BankExchangeCurrencyDialogPayload bankExchangeCurrencyDialogPayload = (BankExchangeCurrencyDialogPayload) obj;
            return this.bankBalance == bankExchangeCurrencyDialogPayload.bankBalance && this.currency == bankExchangeCurrencyDialogPayload.currency && Intrinsics.areEqual(this.headerInfo, bankExchangeCurrencyDialogPayload.headerInfo) && Intrinsics.areEqual(this.additionalInfo, bankExchangeCurrencyDialogPayload.additionalInfo) && Intrinsics.areEqual(this.buttonsTimer, bankExchangeCurrencyDialogPayload.buttonsTimer);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.bankBalance) * 31) + Integer.hashCode(this.currency)) * 31;
        BankDialogHeaderInfo bankDialogHeaderInfo = this.headerInfo;
        return ((((hashCode + (bankDialogHeaderInfo == null ? 0 : bankDialogHeaderInfo.hashCode())) * 31) + this.additionalInfo.hashCode()) * 31) + this.buttonsTimer.hashCode();
    }

    public String toString() {
        long j = this.bankBalance;
        int i = this.currency;
        BankDialogHeaderInfo bankDialogHeaderInfo = this.headerInfo;
        String str = this.additionalInfo;
        return "BankExchangeCurrencyDialogPayload(bankBalance=" + j + ", currency=" + i + ", headerInfo=" + bankDialogHeaderInfo + ", additionalInfo=" + str + ", buttonsTimer=" + this.buttonsTimer + ")";
    }

    public BankExchangeCurrencyDialogPayload(long j, int i, BankDialogHeaderInfo bankDialogHeaderInfo, String additionalInfo, List<Integer> buttonsTimer) {
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        Intrinsics.checkNotNullParameter(buttonsTimer, "buttonsTimer");
        this.bankBalance = j;
        this.currency = i;
        this.headerInfo = bankDialogHeaderInfo;
        this.additionalInfo = additionalInfo;
        this.buttonsTimer = buttonsTimer;
    }

    public final long getBankBalance() {
        return this.bankBalance;
    }

    public final int getCurrency() {
        return this.currency;
    }

    public final BankDialogHeaderInfo getHeaderInfo() {
        return this.headerInfo;
    }

    public /* synthetic */ BankExchangeCurrencyDialogPayload(long j, int i, BankDialogHeaderInfo bankDialogHeaderInfo, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : bankDialogHeaderInfo, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final List<Integer> getButtonsTimer() {
        return this.buttonsTimer;
    }
}
