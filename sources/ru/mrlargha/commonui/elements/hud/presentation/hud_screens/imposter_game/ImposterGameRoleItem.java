package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.imposter_game;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/imposter_game/ImposterGameRoleItem;", "", "name", "", "type", "", "countWorker", "countImposter", "isZoneType", "timerValue", "", "<init>", "(Ljava/lang/String;IIIIJ)V", "getName", "()Ljava/lang/String;", "getType", "()I", "getCountWorker", "getCountImposter", "getTimerValue", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ImposterGameRoleItem {
    private final int countImposter;
    private final int countWorker;
    private final int isZoneType;
    private final String name;
    private final long timerValue;
    private final int type;

    public static /* synthetic */ ImposterGameRoleItem copy$default(ImposterGameRoleItem imposterGameRoleItem, String str, int i, int i2, int i3, int i4, long j, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = imposterGameRoleItem.name;
        }
        if ((i5 & 2) != 0) {
            i = imposterGameRoleItem.type;
        }
        if ((i5 & 4) != 0) {
            i2 = imposterGameRoleItem.countWorker;
        }
        if ((i5 & 8) != 0) {
            i3 = imposterGameRoleItem.countImposter;
        }
        if ((i5 & 16) != 0) {
            i4 = imposterGameRoleItem.isZoneType;
        }
        if ((i5 & 32) != 0) {
            j = imposterGameRoleItem.timerValue;
        }
        long j2 = j;
        int i6 = i4;
        int i7 = i2;
        return imposterGameRoleItem.copy(str, i, i7, i3, i6, j2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.countWorker;
    }

    public final int component4() {
        return this.countImposter;
    }

    public final int component5() {
        return this.isZoneType;
    }

    public final long component6() {
        return this.timerValue;
    }

    public final ImposterGameRoleItem copy(String name, int i, int i2, int i3, int i4, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ImposterGameRoleItem(name, i, i2, i3, i4, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImposterGameRoleItem) {
            ImposterGameRoleItem imposterGameRoleItem = (ImposterGameRoleItem) obj;
            return Intrinsics.areEqual(this.name, imposterGameRoleItem.name) && this.type == imposterGameRoleItem.type && this.countWorker == imposterGameRoleItem.countWorker && this.countImposter == imposterGameRoleItem.countImposter && this.isZoneType == imposterGameRoleItem.isZoneType && this.timerValue == imposterGameRoleItem.timerValue;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.countWorker)) * 31) + Integer.hashCode(this.countImposter)) * 31) + Integer.hashCode(this.isZoneType)) * 31) + Long.hashCode(this.timerValue);
    }

    public String toString() {
        String str = this.name;
        int i = this.type;
        int i2 = this.countWorker;
        int i3 = this.countImposter;
        int i4 = this.isZoneType;
        return "ImposterGameRoleItem(name=" + str + ", type=" + i + ", countWorker=" + i2 + ", countImposter=" + i3 + ", isZoneType=" + i4 + ", timerValue=" + this.timerValue + ")";
    }

    public ImposterGameRoleItem(String name, int i, int i2, int i3, int i4, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.type = i;
        this.countWorker = i2;
        this.countImposter = i3;
        this.isZoneType = i4;
        this.timerValue = j;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public final int getCountWorker() {
        return this.countWorker;
    }

    public final int getCountImposter() {
        return this.countImposter;
    }

    public final int isZoneType() {
        return this.isZoneType;
    }

    public final long getTimerValue() {
        return this.timerValue;
    }
}
