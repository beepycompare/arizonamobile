package com.arizonagames.feature.minigames.atm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AtmScreen.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/arizonagames/feature/minigames/atm/SlotState;", "", "nominal", "Lcom/arizonagames/feature/minigames/atm/BillNominal;", "defaultDrawableRes", "", "selectedDrawableRes", "isBusy", "", "billsCount", "<init>", "(Lcom/arizonagames/feature/minigames/atm/BillNominal;IIZI)V", "getNominal", "()Lcom/arizonagames/feature/minigames/atm/BillNominal;", "getDefaultDrawableRes", "()I", "getSelectedDrawableRes", "()Z", "setBusy", "(Z)V", "getBillsCount", "setBillsCount", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "atm"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlotState {
    private int billsCount;
    private final int defaultDrawableRes;
    private boolean isBusy;
    private final BillNominal nominal;
    private final int selectedDrawableRes;

    public static /* synthetic */ SlotState copy$default(SlotState slotState, BillNominal billNominal, int i, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            billNominal = slotState.nominal;
        }
        if ((i4 & 2) != 0) {
            i = slotState.defaultDrawableRes;
        }
        if ((i4 & 4) != 0) {
            i2 = slotState.selectedDrawableRes;
        }
        if ((i4 & 8) != 0) {
            z = slotState.isBusy;
        }
        if ((i4 & 16) != 0) {
            i3 = slotState.billsCount;
        }
        int i5 = i3;
        int i6 = i2;
        return slotState.copy(billNominal, i, i6, z, i5);
    }

    public final BillNominal component1() {
        return this.nominal;
    }

    public final int component2() {
        return this.defaultDrawableRes;
    }

    public final int component3() {
        return this.selectedDrawableRes;
    }

    public final boolean component4() {
        return this.isBusy;
    }

    public final int component5() {
        return this.billsCount;
    }

    public final SlotState copy(BillNominal nominal, int i, int i2, boolean z, int i3) {
        Intrinsics.checkNotNullParameter(nominal, "nominal");
        return new SlotState(nominal, i, i2, z, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SlotState) {
            SlotState slotState = (SlotState) obj;
            return this.nominal == slotState.nominal && this.defaultDrawableRes == slotState.defaultDrawableRes && this.selectedDrawableRes == slotState.selectedDrawableRes && this.isBusy == slotState.isBusy && this.billsCount == slotState.billsCount;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.nominal.hashCode() * 31) + Integer.hashCode(this.defaultDrawableRes)) * 31) + Integer.hashCode(this.selectedDrawableRes)) * 31) + Boolean.hashCode(this.isBusy)) * 31) + Integer.hashCode(this.billsCount);
    }

    public String toString() {
        BillNominal billNominal = this.nominal;
        int i = this.defaultDrawableRes;
        int i2 = this.selectedDrawableRes;
        boolean z = this.isBusy;
        return "SlotState(nominal=" + billNominal + ", defaultDrawableRes=" + i + ", selectedDrawableRes=" + i2 + ", isBusy=" + z + ", billsCount=" + this.billsCount + ")";
    }

    public SlotState(BillNominal nominal, int i, int i2, boolean z, int i3) {
        Intrinsics.checkNotNullParameter(nominal, "nominal");
        this.nominal = nominal;
        this.defaultDrawableRes = i;
        this.selectedDrawableRes = i2;
        this.isBusy = z;
        this.billsCount = i3;
    }

    public /* synthetic */ SlotState(BillNominal billNominal, int i, int i2, boolean z, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(billNominal, i, i2, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? 0 : i3);
    }

    public final BillNominal getNominal() {
        return this.nominal;
    }

    public final int getDefaultDrawableRes() {
        return this.defaultDrawableRes;
    }

    public final int getSelectedDrawableRes() {
        return this.selectedDrawableRes;
    }

    public final boolean isBusy() {
        return this.isBusy;
    }

    public final void setBusy(boolean z) {
        this.isBusy = z;
    }

    public final int getBillsCount() {
        return this.billsCount;
    }

    public final void setBillsCount(int i) {
        this.billsCount = i;
    }
}
