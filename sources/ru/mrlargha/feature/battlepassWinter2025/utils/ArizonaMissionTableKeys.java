package ru.mrlargha.feature.battlepassWinter2025.utils;

import kotlin.Metadata;
/* compiled from: ArizonaMissionHelpers.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/utils/ArizonaMissionTableKeys;", "", "<init>", "()V", "DEFAULT", "", "PREMIUM", "PREMIUM_PLUS", "clampPremiumTier", "", "premium", "tableKeyForPremium", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaMissionTableKeys {
    public static final String DEFAULT = "bp_mission_default";
    public static final ArizonaMissionTableKeys INSTANCE = new ArizonaMissionTableKeys();
    public static final String PREMIUM = "bp_mission_premium";
    public static final String PREMIUM_PLUS = "bp_mission_premium_plus";

    public final int clampPremiumTier(int i) {
        if (i < 0 || i >= 3) {
            return 2;
        }
        return i;
    }

    private ArizonaMissionTableKeys() {
    }

    public final String tableKeyForPremium(int i) {
        int clampPremiumTier = clampPremiumTier(i);
        if (clampPremiumTier != 0) {
            if (clampPremiumTier == 1) {
                return PREMIUM;
            }
            return PREMIUM_PLUS;
        }
        return DEFAULT;
    }
}
