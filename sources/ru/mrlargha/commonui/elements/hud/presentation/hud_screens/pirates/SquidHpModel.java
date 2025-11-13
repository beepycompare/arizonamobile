package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.pirates;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SquidHpModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/pirates/SquidHpModel;", "", "currentHp", "", "maxHp", "type", "squidType", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/pirates/SquidType;", "<init>", "(IIILru/mrlargha/commonui/elements/hud/presentation/hud_screens/pirates/SquidType;)V", "getCurrentHp", "()I", "getMaxHp", "getSquidType", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/pirates/SquidType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SquidHpModel {
    private final int currentHp;
    private final int maxHp;
    private final SquidType squidType;
    private final int type;

    private final int component3() {
        return this.type;
    }

    public static /* synthetic */ SquidHpModel copy$default(SquidHpModel squidHpModel, int i, int i2, int i3, SquidType squidType, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = squidHpModel.currentHp;
        }
        if ((i4 & 2) != 0) {
            i2 = squidHpModel.maxHp;
        }
        if ((i4 & 4) != 0) {
            i3 = squidHpModel.type;
        }
        if ((i4 & 8) != 0) {
            squidType = squidHpModel.squidType;
        }
        return squidHpModel.copy(i, i2, i3, squidType);
    }

    public final int component1() {
        return this.currentHp;
    }

    public final int component2() {
        return this.maxHp;
    }

    public final SquidType component4() {
        return this.squidType;
    }

    public final SquidHpModel copy(int i, int i2, int i3, SquidType squidType) {
        Intrinsics.checkNotNullParameter(squidType, "squidType");
        return new SquidHpModel(i, i2, i3, squidType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SquidHpModel) {
            SquidHpModel squidHpModel = (SquidHpModel) obj;
            return this.currentHp == squidHpModel.currentHp && this.maxHp == squidHpModel.maxHp && this.type == squidHpModel.type && this.squidType == squidHpModel.squidType;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.currentHp) * 31) + Integer.hashCode(this.maxHp)) * 31) + Integer.hashCode(this.type)) * 31) + this.squidType.hashCode();
    }

    public String toString() {
        int i = this.currentHp;
        int i2 = this.maxHp;
        int i3 = this.type;
        return "SquidHpModel(currentHp=" + i + ", maxHp=" + i2 + ", type=" + i3 + ", squidType=" + this.squidType + ")";
    }

    public SquidHpModel(int i, int i2, int i3, SquidType squidType) {
        Intrinsics.checkNotNullParameter(squidType, "squidType");
        this.currentHp = i;
        this.maxHp = i2;
        this.type = i3;
        this.squidType = squidType;
    }

    public final int getCurrentHp() {
        return this.currentHp;
    }

    public final int getMaxHp() {
        return this.maxHp;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SquidHpModel(int i, int i2, int i3, SquidType squidType, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i4 & 8) != 0 ? SquidType.Companion.getType(i3) : squidType);
        i3 = (i4 & 4) != 0 ? 0 : i3;
    }

    public final SquidType getSquidType() {
        return this.squidType;
    }
}
