package com.arizonagames.feature.arizona.bank;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankCurrencyHistoryPayload;", "", "currencies", "", "Lcom/arizonagames/feature/arizona/bank/BankCurrencyHistoryInfo;", "<init>", "(Ljava/util/List;)V", "getCurrencies", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankCurrencyHistoryPayload {
    private final List<BankCurrencyHistoryInfo> currencies;

    public BankCurrencyHistoryPayload() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BankCurrencyHistoryPayload copy$default(BankCurrencyHistoryPayload bankCurrencyHistoryPayload, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = bankCurrencyHistoryPayload.currencies;
        }
        return bankCurrencyHistoryPayload.copy(list);
    }

    public final List<BankCurrencyHistoryInfo> component1() {
        return this.currencies;
    }

    public final BankCurrencyHistoryPayload copy(List<BankCurrencyHistoryInfo> currencies) {
        Intrinsics.checkNotNullParameter(currencies, "currencies");
        return new BankCurrencyHistoryPayload(currencies);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BankCurrencyHistoryPayload) && Intrinsics.areEqual(this.currencies, ((BankCurrencyHistoryPayload) obj).currencies);
    }

    public int hashCode() {
        return this.currencies.hashCode();
    }

    public String toString() {
        return "BankCurrencyHistoryPayload(currencies=" + this.currencies + ")";
    }

    public BankCurrencyHistoryPayload(List<BankCurrencyHistoryInfo> currencies) {
        Intrinsics.checkNotNullParameter(currencies, "currencies");
        this.currencies = currencies;
    }

    public /* synthetic */ BankCurrencyHistoryPayload(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<BankCurrencyHistoryInfo> getCurrencies() {
        return this.currencies;
    }
}
