package ru.mrlargha.commonui.elements.inventory.domain.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UserInventoryBars.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/models/VehicleInfoBars;", "", "skin", "Lru/mrlargha/commonui/elements/inventory/domain/models/SkinItem;", "buttons", "", "health", "", "maxHealth", "oil", "<init>", "(Lru/mrlargha/commonui/elements/inventory/domain/models/SkinItem;IDDI)V", "getSkin", "()Lru/mrlargha/commonui/elements/inventory/domain/models/SkinItem;", "getButtons", "()I", "getHealth", "()D", "getMaxHealth", "getOil", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VehicleInfoBars {
    private final int buttons;
    private final double health;
    @SerializedName("max_health")
    private final double maxHealth;
    private final int oil;
    private final SkinItem skin;

    public static /* synthetic */ VehicleInfoBars copy$default(VehicleInfoBars vehicleInfoBars, SkinItem skinItem, int i, double d, double d2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            skinItem = vehicleInfoBars.skin;
        }
        if ((i3 & 2) != 0) {
            i = vehicleInfoBars.buttons;
        }
        if ((i3 & 4) != 0) {
            d = vehicleInfoBars.health;
        }
        if ((i3 & 8) != 0) {
            d2 = vehicleInfoBars.maxHealth;
        }
        if ((i3 & 16) != 0) {
            i2 = vehicleInfoBars.oil;
        }
        int i4 = i2;
        double d3 = d2;
        return vehicleInfoBars.copy(skinItem, i, d, d3, i4);
    }

    public final SkinItem component1() {
        return this.skin;
    }

    public final int component2() {
        return this.buttons;
    }

    public final double component3() {
        return this.health;
    }

    public final double component4() {
        return this.maxHealth;
    }

    public final int component5() {
        return this.oil;
    }

    public final VehicleInfoBars copy(SkinItem skin, int i, double d, double d2, int i2) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        return new VehicleInfoBars(skin, i, d, d2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VehicleInfoBars) {
            VehicleInfoBars vehicleInfoBars = (VehicleInfoBars) obj;
            return Intrinsics.areEqual(this.skin, vehicleInfoBars.skin) && this.buttons == vehicleInfoBars.buttons && Double.compare(this.health, vehicleInfoBars.health) == 0 && Double.compare(this.maxHealth, vehicleInfoBars.maxHealth) == 0 && this.oil == vehicleInfoBars.oil;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.skin.hashCode() * 31) + Integer.hashCode(this.buttons)) * 31) + Double.hashCode(this.health)) * 31) + Double.hashCode(this.maxHealth)) * 31) + Integer.hashCode(this.oil);
    }

    public String toString() {
        SkinItem skinItem = this.skin;
        int i = this.buttons;
        double d = this.health;
        double d2 = this.maxHealth;
        return "VehicleInfoBars(skin=" + skinItem + ", buttons=" + i + ", health=" + d + ", maxHealth=" + d2 + ", oil=" + this.oil + ")";
    }

    public VehicleInfoBars(SkinItem skin, int i, double d, double d2, int i2) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        this.skin = skin;
        this.buttons = i;
        this.health = d;
        this.maxHealth = d2;
        this.oil = i2;
    }

    public final SkinItem getSkin() {
        return this.skin;
    }

    public final int getButtons() {
        return this.buttons;
    }

    public final double getHealth() {
        return this.health;
    }

    public final double getMaxHealth() {
        return this.maxHealth;
    }

    public final int getOil() {
        return this.oil;
    }
}
