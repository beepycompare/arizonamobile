package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudGathersCountModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountBonus;", "", "icon", "", "time", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", "<init>", "(Ljava/lang/String;IZ)V", "getIcon", "()Ljava/lang/String;", "getTime", "()I", "getActive", "()Z", "getType", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountBonusType;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudGathersCountBonus {
    private final boolean active;
    private final String icon;
    private final int time;

    public static /* synthetic */ HudGathersCountBonus copy$default(HudGathersCountBonus hudGathersCountBonus, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = hudGathersCountBonus.icon;
        }
        if ((i2 & 2) != 0) {
            i = hudGathersCountBonus.time;
        }
        if ((i2 & 4) != 0) {
            z = hudGathersCountBonus.active;
        }
        return hudGathersCountBonus.copy(str, i, z);
    }

    public final String component1() {
        return this.icon;
    }

    public final int component2() {
        return this.time;
    }

    public final boolean component3() {
        return this.active;
    }

    public final HudGathersCountBonus copy(String icon, int i, boolean z) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new HudGathersCountBonus(icon, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudGathersCountBonus) {
            HudGathersCountBonus hudGathersCountBonus = (HudGathersCountBonus) obj;
            return Intrinsics.areEqual(this.icon, hudGathersCountBonus.icon) && this.time == hudGathersCountBonus.time && this.active == hudGathersCountBonus.active;
        }
        return false;
    }

    public int hashCode() {
        return (((this.icon.hashCode() * 31) + Integer.hashCode(this.time)) * 31) + Boolean.hashCode(this.active);
    }

    public String toString() {
        String str = this.icon;
        int i = this.time;
        return "HudGathersCountBonus(icon=" + str + ", time=" + i + ", active=" + this.active + ")";
    }

    public HudGathersCountBonus(String icon, int i, boolean z) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.icon = icon;
        this.time = i;
        this.active = z;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getTime() {
        return this.time;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final HudGathersCountBonusType getType() {
        Object obj;
        Iterator<E> it = HudGathersCountBonusType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((HudGathersCountBonusType) obj).getType(), this.icon)) {
                break;
            }
        }
        HudGathersCountBonusType hudGathersCountBonusType = (HudGathersCountBonusType) obj;
        return hudGathersCountBonusType == null ? HudGathersCountBonusType.SPEED : hudGathersCountBonusType;
    }
}
