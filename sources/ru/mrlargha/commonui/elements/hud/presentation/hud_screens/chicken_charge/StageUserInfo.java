package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/StageUserInfo;", "", "name", "", "chance", "", "moving", "currentPosition", "<init>", "(Ljava/lang/String;III)V", "getName", "()Ljava/lang/String;", "getChance", "()I", "getMoving", "getCurrentPosition", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StageUserInfo {
    private final int chance;
    private final int currentPosition;
    private final int moving;
    private final String name;

    public static /* synthetic */ StageUserInfo copy$default(StageUserInfo stageUserInfo, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = stageUserInfo.name;
        }
        if ((i4 & 2) != 0) {
            i = stageUserInfo.chance;
        }
        if ((i4 & 4) != 0) {
            i2 = stageUserInfo.moving;
        }
        if ((i4 & 8) != 0) {
            i3 = stageUserInfo.currentPosition;
        }
        return stageUserInfo.copy(str, i, i2, i3);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.chance;
    }

    public final int component3() {
        return this.moving;
    }

    public final int component4() {
        return this.currentPosition;
    }

    public final StageUserInfo copy(String name, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new StageUserInfo(name, i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StageUserInfo) {
            StageUserInfo stageUserInfo = (StageUserInfo) obj;
            return Intrinsics.areEqual(this.name, stageUserInfo.name) && this.chance == stageUserInfo.chance && this.moving == stageUserInfo.moving && this.currentPosition == stageUserInfo.currentPosition;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + Integer.hashCode(this.chance)) * 31) + Integer.hashCode(this.moving)) * 31) + Integer.hashCode(this.currentPosition);
    }

    public String toString() {
        String str = this.name;
        int i = this.chance;
        int i2 = this.moving;
        return "StageUserInfo(name=" + str + ", chance=" + i + ", moving=" + i2 + ", currentPosition=" + this.currentPosition + ")";
    }

    public StageUserInfo(String name, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.chance = i;
        this.moving = i2;
        this.currentPosition = i3;
    }

    public final String getName() {
        return this.name;
    }

    public final int getChance() {
        return this.chance;
    }

    public final int getMoving() {
        return this.moving;
    }

    public final int getCurrentPosition() {
        return this.currentPosition;
    }
}
