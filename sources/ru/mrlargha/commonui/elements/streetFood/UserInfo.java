package ru.mrlargha.commonui.elements.streetFood;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FoodInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/streetFood/UserInfo;", "", "health", "", "armour", "satiety", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHealth", "()Ljava/lang/String;", "getArmour", "getSatiety", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserInfo {
    private final String armour;
    private final String health;
    private final String satiety;

    public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfo.health;
        }
        if ((i & 2) != 0) {
            str2 = userInfo.armour;
        }
        if ((i & 4) != 0) {
            str3 = userInfo.satiety;
        }
        return userInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.health;
    }

    public final String component2() {
        return this.armour;
    }

    public final String component3() {
        return this.satiety;
    }

    public final UserInfo copy(String health, String armour, String satiety) {
        Intrinsics.checkNotNullParameter(health, "health");
        Intrinsics.checkNotNullParameter(armour, "armour");
        Intrinsics.checkNotNullParameter(satiety, "satiety");
        return new UserInfo(health, armour, satiety);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserInfo) {
            UserInfo userInfo = (UserInfo) obj;
            return Intrinsics.areEqual(this.health, userInfo.health) && Intrinsics.areEqual(this.armour, userInfo.armour) && Intrinsics.areEqual(this.satiety, userInfo.satiety);
        }
        return false;
    }

    public int hashCode() {
        return (((this.health.hashCode() * 31) + this.armour.hashCode()) * 31) + this.satiety.hashCode();
    }

    public String toString() {
        String str = this.health;
        String str2 = this.armour;
        return "UserInfo(health=" + str + ", armour=" + str2 + ", satiety=" + this.satiety + ")";
    }

    public UserInfo(String health, String armour, String satiety) {
        Intrinsics.checkNotNullParameter(health, "health");
        Intrinsics.checkNotNullParameter(armour, "armour");
        Intrinsics.checkNotNullParameter(satiety, "satiety");
        this.health = health;
        this.armour = armour;
        this.satiety = satiety;
    }

    public final String getArmour() {
        return this.armour;
    }

    public final String getHealth() {
        return this.health;
    }

    public final String getSatiety() {
        return this.satiety;
    }
}
