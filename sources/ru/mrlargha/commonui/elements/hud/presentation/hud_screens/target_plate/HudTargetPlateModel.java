package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.target_plate;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
/* compiled from: HudTargetPlateModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003Jw\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006/"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/target_plate/HudTargetPlateModel;", "", "userName", "", "userNumber", "", FirebaseAnalytics.Param.LEVEL, "shield", "luck", "bullet", "energy", "health", "maxHealth", "armor", "maxArmor", "<init>", "(Ljava/lang/String;ILjava/lang/String;IIIIIIII)V", "getUserName", "()Ljava/lang/String;", "getUserNumber", "()I", "getLevel", "getShield", "getLuck", "getBullet", "getEnergy", "getHealth", "getMaxHealth", "getArmor", "getMaxArmor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
/* loaded from: classes6.dex */
public final class HudTargetPlateModel {
    private final int armor;
    private final int bullet;
    private final int energy;
    private final int health;
    private final String level;
    private final int luck;
    private final int maxArmor;
    private final int maxHealth;
    private final int shield;
    @SerializedName("userName")
    private final String userName;
    @SerializedName("userNumber")
    private final int userNumber;

    public static /* synthetic */ HudTargetPlateModel copy$default(HudTargetPlateModel hudTargetPlateModel, String str, int i, String str2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = hudTargetPlateModel.userName;
        }
        if ((i10 & 2) != 0) {
            i = hudTargetPlateModel.userNumber;
        }
        if ((i10 & 4) != 0) {
            str2 = hudTargetPlateModel.level;
        }
        if ((i10 & 8) != 0) {
            i2 = hudTargetPlateModel.shield;
        }
        if ((i10 & 16) != 0) {
            i3 = hudTargetPlateModel.luck;
        }
        if ((i10 & 32) != 0) {
            i4 = hudTargetPlateModel.bullet;
        }
        if ((i10 & 64) != 0) {
            i5 = hudTargetPlateModel.energy;
        }
        if ((i10 & 128) != 0) {
            i6 = hudTargetPlateModel.health;
        }
        if ((i10 & 256) != 0) {
            i7 = hudTargetPlateModel.maxHealth;
        }
        if ((i10 & 512) != 0) {
            i8 = hudTargetPlateModel.armor;
        }
        if ((i10 & 1024) != 0) {
            i9 = hudTargetPlateModel.maxArmor;
        }
        int i11 = i8;
        int i12 = i9;
        int i13 = i6;
        int i14 = i7;
        int i15 = i4;
        int i16 = i5;
        int i17 = i3;
        String str3 = str2;
        return hudTargetPlateModel.copy(str, i, str3, i2, i17, i15, i16, i13, i14, i11, i12);
    }

    public final String component1() {
        return this.userName;
    }

    public final int component10() {
        return this.armor;
    }

    public final int component11() {
        return this.maxArmor;
    }

    public final int component2() {
        return this.userNumber;
    }

    public final String component3() {
        return this.level;
    }

    public final int component4() {
        return this.shield;
    }

    public final int component5() {
        return this.luck;
    }

    public final int component6() {
        return this.bullet;
    }

    public final int component7() {
        return this.energy;
    }

    public final int component8() {
        return this.health;
    }

    public final int component9() {
        return this.maxHealth;
    }

    public final HudTargetPlateModel copy(String userName, int i, String level, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(level, "level");
        return new HudTargetPlateModel(userName, i, level, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudTargetPlateModel) {
            HudTargetPlateModel hudTargetPlateModel = (HudTargetPlateModel) obj;
            return Intrinsics.areEqual(this.userName, hudTargetPlateModel.userName) && this.userNumber == hudTargetPlateModel.userNumber && Intrinsics.areEqual(this.level, hudTargetPlateModel.level) && this.shield == hudTargetPlateModel.shield && this.luck == hudTargetPlateModel.luck && this.bullet == hudTargetPlateModel.bullet && this.energy == hudTargetPlateModel.energy && this.health == hudTargetPlateModel.health && this.maxHealth == hudTargetPlateModel.maxHealth && this.armor == hudTargetPlateModel.armor && this.maxArmor == hudTargetPlateModel.maxArmor;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((this.userName.hashCode() * 31) + Integer.hashCode(this.userNumber)) * 31) + this.level.hashCode()) * 31) + Integer.hashCode(this.shield)) * 31) + Integer.hashCode(this.luck)) * 31) + Integer.hashCode(this.bullet)) * 31) + Integer.hashCode(this.energy)) * 31) + Integer.hashCode(this.health)) * 31) + Integer.hashCode(this.maxHealth)) * 31) + Integer.hashCode(this.armor)) * 31) + Integer.hashCode(this.maxArmor);
    }

    public String toString() {
        String str = this.userName;
        int i = this.userNumber;
        String str2 = this.level;
        int i2 = this.shield;
        int i3 = this.luck;
        int i4 = this.bullet;
        int i5 = this.energy;
        int i6 = this.health;
        int i7 = this.maxHealth;
        int i8 = this.armor;
        return "HudTargetPlateModel(userName=" + str + ", userNumber=" + i + ", level=" + str2 + ", shield=" + i2 + ", luck=" + i3 + ", bullet=" + i4 + ", energy=" + i5 + ", health=" + i6 + ", maxHealth=" + i7 + ", armor=" + i8 + ", maxArmor=" + this.maxArmor + ")";
    }

    public HudTargetPlateModel(String userName, int i, String level, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(level, "level");
        this.userName = userName;
        this.userNumber = i;
        this.level = level;
        this.shield = i2;
        this.luck = i3;
        this.bullet = i4;
        this.energy = i5;
        this.health = i6;
        this.maxHealth = i7;
        this.armor = i8;
        this.maxArmor = i9;
    }

    public /* synthetic */ HudTargetPlateModel(String str, int i, String str2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, i2, i3, i4, i5, i6, i7, (i10 & 512) != 0 ? -1 : i8, i9);
    }

    public final String getUserName() {
        return this.userName;
    }

    public final int getUserNumber() {
        return this.userNumber;
    }

    public final String getLevel() {
        return this.level;
    }

    public final int getShield() {
        return this.shield;
    }

    public final int getLuck() {
        return this.luck;
    }

    public final int getBullet() {
        return this.bullet;
    }

    public final int getEnergy() {
        return this.energy;
    }

    public final int getHealth() {
        return this.health;
    }

    public final int getMaxHealth() {
        return this.maxHealth;
    }

    public final int getArmor() {
        return this.armor;
    }

    public final int getMaxArmor() {
        return this.maxArmor;
    }
}
