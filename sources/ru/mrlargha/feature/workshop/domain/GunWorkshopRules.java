package ru.mrlargha.feature.workshop.domain;

import androidx.window.core.layout.WindowSizeClass;
import com.arizona.launcher.UpdateActivity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ItemTypes;
/* compiled from: GunWorkshopRules.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0002\u0010\u0017J'\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0002\u0010\u0019J'\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0005J0\u0010$\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u001e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013J&\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lru/mrlargha/feature/workshop/domain/GunWorkshopRules;", "", "<init>", "()V", "INVENTORY_UPDATE_TYPE", "", "STANDARD_WORKSHOP_CONTEXT_TYPE", "INVENTORY_CONTEXT_TYPE", "LEGACY_GUN_ITEM_TYPE", "getLEGACY_GUN_ITEM_TYPE", "()I", "WEAPON_SKIN_ITEM_TYPE", "getWEAPON_SKIN_ITEM_TYPE", "ATTACHMENT_ITEM_TYPE", "getATTACHMENT_ITEM_TYPE", "MAX_GUN_ENCHANT", "weaponResourceAmounts", "", "acceptsInventoryResponse", "", "currentContextType", "isGunContext", "incomingType", "(Ljava/lang/Integer;ZI)Z", "fallbackContextType", "(Ljava/lang/Integer;ZI)Ljava/lang/Integer;", "slotRole", "Lru/mrlargha/feature/workshop/domain/GunWorkshopSlotRole;", UpdateActivity.UPDATE_MODE, "Lru/mrlargha/feature/workshop/domain/GunWorkshopMode;", "itemId", "itemType", "(Lru/mrlargha/feature/workshop/domain/GunWorkshopMode;ILjava/lang/Integer;)Lru/mrlargha/feature/workshop/domain/GunWorkshopSlotRole;", "requirement", "Lru/mrlargha/feature/workshop/domain/GunWorkshopRequirement;", "currentEnchant", "canRequestAvailability", "mainSlot", "resourceSlot", "sharpeningSlot", "availabilityRefreshDecision", "Lru/mrlargha/feature/workshop/domain/GunWorkshopAvailabilityRefreshDecision;", "pendingRefresh", "isInteractionDisabled", "canApplyAvailabilityResponse", "isGunWorkshopContext", "hasValidSelection", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GunWorkshopRules {
    public static final int INVENTORY_CONTEXT_TYPE = 28;
    public static final int INVENTORY_UPDATE_TYPE = 1;
    public static final int MAX_GUN_ENCHANT = 12;
    public static final int STANDARD_WORKSHOP_CONTEXT_TYPE = 5;
    public static final GunWorkshopRules INSTANCE = new GunWorkshopRules();
    private static final int LEGACY_GUN_ITEM_TYPE = ItemTypes.ITEM_TYPE_IMPROV_GUN.getId();
    private static final int WEAPON_SKIN_ITEM_TYPE = ItemTypes.ITEM_TYPE_GUN_SKIN.getId();
    private static final int ATTACHMENT_ITEM_TYPE = ItemTypes.ITEM_TYPE_STRIPE_WEAPON.getId();
    private static final int[] weaponResourceAmounts = {500, 900, 1000, WindowSizeClass.WIDTH_DP_LARGE_LOWER_BOUND, 1500, 1800, 2000, 2500, 2800, 3000, 3200, 3500};

    /* compiled from: GunWorkshopRules.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GunWorkshopMode.values().length];
            try {
                iArr[GunWorkshopMode.ATTACHMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GunWorkshopMode.WEAPON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean canApplyAvailabilityResponse(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z4) {
            if (z) {
                return (z2 || z3) ? false : true;
            }
            return true;
        }
        return false;
    }

    private GunWorkshopRules() {
    }

    public final int getLEGACY_GUN_ITEM_TYPE() {
        return LEGACY_GUN_ITEM_TYPE;
    }

    public final int getWEAPON_SKIN_ITEM_TYPE() {
        return WEAPON_SKIN_ITEM_TYPE;
    }

    public final int getATTACHMENT_ITEM_TYPE() {
        return ATTACHMENT_ITEM_TYPE;
    }

    public final boolean acceptsInventoryResponse(Integer num, boolean z, int i) {
        if (i == 1) {
            return num != null;
        } else if (i == 28 || i == 5 || num == null) {
            return true;
        } else {
            return z ? i == 28 : i == num.intValue();
        }
    }

    public final Integer fallbackContextType(Integer num, boolean z, int i) {
        ((Number) 5).intValue();
        return (num == null && !z && i == 1) ? 5 : null;
    }

    public final GunWorkshopSlotRole slotRole(GunWorkshopMode mode, int i, Integer num) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (i == 511) {
            if (mode == GunWorkshopMode.WEAPON) {
                return GunWorkshopSlotRole.RESOURCE;
            }
            return null;
        } else if (i == 1187) {
            if (mode == GunWorkshopMode.ATTACHMENT) {
                return GunWorkshopSlotRole.RESOURCE;
            }
            return null;
        } else if (i == 8701) {
            if (mode == GunWorkshopMode.ATTACHMENT) {
                return GunWorkshopSlotRole.SHARPENING;
            }
            return null;
        } else if (i == 10253) {
            if (mode == GunWorkshopMode.WEAPON) {
                return GunWorkshopSlotRole.SHARPENING;
            }
            return null;
        } else {
            int i2 = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
            if (i2 == 1) {
                int i3 = ATTACHMENT_ITEM_TYPE;
                if (num == null || num.intValue() != i3) {
                    int i4 = LEGACY_GUN_ITEM_TYPE;
                    if (num == null || num.intValue() != i4) {
                        return null;
                    }
                }
                return GunWorkshopSlotRole.MAIN;
            } else if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                int i5 = WEAPON_SKIN_ITEM_TYPE;
                if (num == null || num.intValue() != i5) {
                    int i6 = LEGACY_GUN_ITEM_TYPE;
                    if (num == null || num.intValue() != i6) {
                        return null;
                    }
                }
                return GunWorkshopSlotRole.MAIN;
            }
        }
    }

    public final GunWorkshopRequirement requirement(GunWorkshopMode mode, int i) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int i2 = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        int i3 = 1;
        if (i2 == 1) {
            if (i < 0 || i >= 12) {
                return null;
            }
            return new GunWorkshopRequirement(i + 1, 1);
        } else if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            Integer orNull = ArraysKt.getOrNull(weaponResourceAmounts, i);
            if (orNull != null) {
                int intValue = orNull.intValue();
                if (i < 0 || i >= 9) {
                    if (9 <= i && i < 11) {
                        i3 = 2;
                    } else if (i != 11) {
                        return null;
                    } else {
                        i3 = 3;
                    }
                }
                return new GunWorkshopRequirement(i3, intValue);
            }
            return null;
        }
    }

    public final boolean canRequestAvailability(GunWorkshopMode gunWorkshopMode, int i, int i2, int i3, int i4) {
        return gunWorkshopMode != null && i2 >= 0 && i3 >= 0 && i4 >= 0 && requirement(gunWorkshopMode, i) != null;
    }

    public final GunWorkshopAvailabilityRefreshDecision availabilityRefreshDecision(boolean z, boolean z2, boolean z3) {
        if (z && z3) {
            if (z2) {
                return new GunWorkshopAvailabilityRefreshDecision(true, false);
            }
            return new GunWorkshopAvailabilityRefreshDecision(false, true);
        }
        return new GunWorkshopAvailabilityRefreshDecision(false, false);
    }
}
