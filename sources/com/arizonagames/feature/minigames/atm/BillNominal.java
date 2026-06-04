package com.arizonagames.feature.minigames.atm;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AtmScreen.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/arizonagames/feature/minigames/atm/BillNominal;", "", "<init>", "(Ljava/lang/String;I)V", "ONE", "TEN", "FIFTY", "HUNDRED", "billDrawableRes", "", "type", "atm"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BillNominal {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BillNominal[] $VALUES;
    public static final BillNominal ONE = new BillNominal("ONE", 0);
    public static final BillNominal TEN = new BillNominal("TEN", 1);
    public static final BillNominal FIFTY = new BillNominal("FIFTY", 2);
    public static final BillNominal HUNDRED = new BillNominal("HUNDRED", 3);

    /* compiled from: AtmScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BillNominal.values().length];
            try {
                iArr[BillNominal.ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BillNominal.TEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BillNominal.FIFTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BillNominal.HUNDRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ BillNominal[] $values() {
        return new BillNominal[]{ONE, TEN, FIFTY, HUNDRED};
    }

    public static EnumEntries<BillNominal> getEntries() {
        return $ENTRIES;
    }

    public static BillNominal valueOf(String str) {
        return (BillNominal) Enum.valueOf(BillNominal.class, str);
    }

    public static BillNominal[] values() {
        return (BillNominal[]) $VALUES.clone();
    }

    private BillNominal(String str, int i) {
    }

    static {
        BillNominal[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public final int billDrawableRes(int i) {
        if (i == 0) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return R.drawable.atm_bill_100;
                    }
                    return R.drawable.atm_bill_50;
                }
                return R.drawable.atm_bill_10;
            }
            return R.drawable.atm_bill_1;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return R.drawable.atm_chicken_item_4;
                }
                return R.drawable.atm_chicken_item_3;
            }
            return R.drawable.atm_chicken_item_2;
        }
        return R.drawable.atm_chicken_item_1;
    }
}
