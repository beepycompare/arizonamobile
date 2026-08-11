package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankDialogHeaderInfo;", "", "text", "", "value", "", "color", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getText", "()Ljava/lang/String;", "getValue", "()J", "getColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankDialogHeaderInfo {
    private final String color;
    private final String text;
    private final long value;

    public BankDialogHeaderInfo() {
        this(null, 0L, null, 7, null);
    }

    public static /* synthetic */ BankDialogHeaderInfo copy$default(BankDialogHeaderInfo bankDialogHeaderInfo, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bankDialogHeaderInfo.text;
        }
        if ((i & 2) != 0) {
            j = bankDialogHeaderInfo.value;
        }
        if ((i & 4) != 0) {
            str2 = bankDialogHeaderInfo.color;
        }
        return bankDialogHeaderInfo.copy(str, j, str2);
    }

    public final String component1() {
        return this.text;
    }

    public final long component2() {
        return this.value;
    }

    public final String component3() {
        return this.color;
    }

    public final BankDialogHeaderInfo copy(String text, long j, String color) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(color, "color");
        return new BankDialogHeaderInfo(text, j, color);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankDialogHeaderInfo) {
            BankDialogHeaderInfo bankDialogHeaderInfo = (BankDialogHeaderInfo) obj;
            return Intrinsics.areEqual(this.text, bankDialogHeaderInfo.text) && this.value == bankDialogHeaderInfo.value && Intrinsics.areEqual(this.color, bankDialogHeaderInfo.color);
        }
        return false;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + Long.hashCode(this.value)) * 31) + this.color.hashCode();
    }

    public String toString() {
        String str = this.text;
        long j = this.value;
        return "BankDialogHeaderInfo(text=" + str + ", value=" + j + ", color=" + this.color + ")";
    }

    public BankDialogHeaderInfo(String text, long j, String color) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(color, "color");
        this.text = text;
        this.value = j;
        this.color = color;
    }

    public /* synthetic */ BankDialogHeaderInfo(String str, long j, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? "" : str2);
    }

    public final String getText() {
        return this.text;
    }

    public final long getValue() {
        return this.value;
    }

    public final String getColor() {
        return this.color;
    }
}
