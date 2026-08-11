package com.arizonagames.feature.arizona.bank;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankMoneyTransferDialogPayload;", "", "headerInfo", "Lcom/arizonagames/feature/arizona/bank/BankDialogHeaderInfo;", "additionalInfo", "", "buttonsTimer", "", "", "<init>", "(Lcom/arizonagames/feature/arizona/bank/BankDialogHeaderInfo;Ljava/lang/String;Ljava/util/List;)V", "getHeaderInfo", "()Lcom/arizonagames/feature/arizona/bank/BankDialogHeaderInfo;", "getAdditionalInfo", "()Ljava/lang/String;", "getButtonsTimer", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankMoneyTransferDialogPayload {
    private final String additionalInfo;
    private final List<Integer> buttonsTimer;
    private final BankDialogHeaderInfo headerInfo;

    public BankMoneyTransferDialogPayload() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BankMoneyTransferDialogPayload copy$default(BankMoneyTransferDialogPayload bankMoneyTransferDialogPayload, BankDialogHeaderInfo bankDialogHeaderInfo, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            bankDialogHeaderInfo = bankMoneyTransferDialogPayload.headerInfo;
        }
        if ((i & 2) != 0) {
            str = bankMoneyTransferDialogPayload.additionalInfo;
        }
        if ((i & 4) != 0) {
            list = bankMoneyTransferDialogPayload.buttonsTimer;
        }
        return bankMoneyTransferDialogPayload.copy(bankDialogHeaderInfo, str, list);
    }

    public final BankDialogHeaderInfo component1() {
        return this.headerInfo;
    }

    public final String component2() {
        return this.additionalInfo;
    }

    public final List<Integer> component3() {
        return this.buttonsTimer;
    }

    public final BankMoneyTransferDialogPayload copy(BankDialogHeaderInfo bankDialogHeaderInfo, String additionalInfo, List<Integer> buttonsTimer) {
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        Intrinsics.checkNotNullParameter(buttonsTimer, "buttonsTimer");
        return new BankMoneyTransferDialogPayload(bankDialogHeaderInfo, additionalInfo, buttonsTimer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankMoneyTransferDialogPayload) {
            BankMoneyTransferDialogPayload bankMoneyTransferDialogPayload = (BankMoneyTransferDialogPayload) obj;
            return Intrinsics.areEqual(this.headerInfo, bankMoneyTransferDialogPayload.headerInfo) && Intrinsics.areEqual(this.additionalInfo, bankMoneyTransferDialogPayload.additionalInfo) && Intrinsics.areEqual(this.buttonsTimer, bankMoneyTransferDialogPayload.buttonsTimer);
        }
        return false;
    }

    public int hashCode() {
        BankDialogHeaderInfo bankDialogHeaderInfo = this.headerInfo;
        return ((((bankDialogHeaderInfo == null ? 0 : bankDialogHeaderInfo.hashCode()) * 31) + this.additionalInfo.hashCode()) * 31) + this.buttonsTimer.hashCode();
    }

    public String toString() {
        BankDialogHeaderInfo bankDialogHeaderInfo = this.headerInfo;
        String str = this.additionalInfo;
        return "BankMoneyTransferDialogPayload(headerInfo=" + bankDialogHeaderInfo + ", additionalInfo=" + str + ", buttonsTimer=" + this.buttonsTimer + ")";
    }

    public BankMoneyTransferDialogPayload(BankDialogHeaderInfo bankDialogHeaderInfo, String additionalInfo, List<Integer> buttonsTimer) {
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        Intrinsics.checkNotNullParameter(buttonsTimer, "buttonsTimer");
        this.headerInfo = bankDialogHeaderInfo;
        this.additionalInfo = additionalInfo;
        this.buttonsTimer = buttonsTimer;
    }

    public final BankDialogHeaderInfo getHeaderInfo() {
        return this.headerInfo;
    }

    public /* synthetic */ BankMoneyTransferDialogPayload(BankDialogHeaderInfo bankDialogHeaderInfo, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bankDialogHeaderInfo, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final List<Integer> getButtonsTimer() {
        return this.buttonsTimer;
    }
}
