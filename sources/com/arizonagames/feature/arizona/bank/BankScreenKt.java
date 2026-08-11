package com.arizonagames.feature.arizona.bank;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankScreen.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0000\u001a(\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a \u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0016"}, d2 = {"shouldResetBankOpeningState", "", "wasVisible", "visible", "resolveBankClick", "Lcom/arizonagames/feature/arizona/bank/BankClick;", "targetId", "", "action", "Lcom/arizonagames/feature/arizona/bank/BankSendSubId;", "resolveEnabledBankTopTabs", "", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "visibleTopTabs", "lockAllTopTabs", "isAtmMode", "resolveBankLogoResource", "shouldPlayBankOpeningAnimation", "hasPlayedOpeningAnimation", "wasClosing", "shouldPlayBankClosingAnimation", "isClosing", "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankScreenKt {

    /* compiled from: BankScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BankSendPayloadMode.values().length];
            try {
                iArr[BankSendPayloadMode.TARGET_AS_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BankSendPayloadMode.TARGET_AS_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BankSendPayloadMode.EMPTY_JSON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BankSendPayloadMode.CHEST_REWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean shouldPlayBankClosingAnimation(boolean z, boolean z2, boolean z3) {
        return (!z || z3 || z2) ? false : true;
    }

    public static final boolean shouldPlayBankOpeningAnimation(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return (z && z2 && !z3) ? false : true;
        }
        return false;
    }

    public static final boolean shouldResetBankOpeningState(boolean z, boolean z2) {
        return z && !z2;
    }

    public static final BankClick resolveBankClick(int i, BankSendSubId action) {
        String valueOf;
        Intrinsics.checkNotNullParameter(action, "action");
        int actionId = WhenMappings.$EnumSwitchMapping$0[action.getPayloadMode().ordinal()] == 1 ? i : action.getActionId();
        int i2 = WhenMappings.$EnumSwitchMapping$0[action.getPayloadMode().ordinal()];
        if (i2 == 2) {
            valueOf = String.valueOf(i);
        } else if (i2 == 3) {
            valueOf = "{}";
        } else if (i2 == 4) {
            valueOf = "bank.other.chestReward|" + i;
        } else {
            valueOf = "";
        }
        return new BankClick(actionId, action.getSubId(), valueOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Set<BankPage> resolveEnabledBankTopTabs(Set<? extends BankPage> visibleTopTabs, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(visibleTopTabs, "visibleTopTabs");
        if (z) {
            return SetsKt.emptySet();
        }
        return z2 ? SetsKt.minus(visibleTopTabs, BankPage.CURRENCY) : visibleTopTabs;
    }

    public static final int resolveBankLogoResource(boolean z) {
        return z ? R.drawable.bank_atm_logo : R.drawable.bank_logo;
    }
}
