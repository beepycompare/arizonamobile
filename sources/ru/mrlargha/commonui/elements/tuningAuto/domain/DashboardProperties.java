package ru.mrlargha.commonui.elements.tuningAuto.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResponseData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003JB\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/domain/DashboardProperties;", "", "type", "", "name", "", "value", "", "valueOffset", "valueMax", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;FFF)V", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getValue", "()F", "getValueOffset", "getValueMax", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;FFF)Lru/mrlargha/commonui/elements/tuningAuto/domain/DashboardProperties;", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DashboardProperties {
    private final String name;
    private final Integer type;
    private final float value;
    private final float valueMax;
    private final float valueOffset;

    public static /* synthetic */ DashboardProperties copy$default(DashboardProperties dashboardProperties, Integer num, String str, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = dashboardProperties.type;
        }
        if ((i & 2) != 0) {
            str = dashboardProperties.name;
        }
        if ((i & 4) != 0) {
            f = dashboardProperties.value;
        }
        if ((i & 8) != 0) {
            f2 = dashboardProperties.valueOffset;
        }
        if ((i & 16) != 0) {
            f3 = dashboardProperties.valueMax;
        }
        float f4 = f3;
        float f5 = f;
        return dashboardProperties.copy(num, str, f5, f2, f4);
    }

    public final Integer component1() {
        return this.type;
    }

    public final String component2() {
        return this.name;
    }

    public final float component3() {
        return this.value;
    }

    public final float component4() {
        return this.valueOffset;
    }

    public final float component5() {
        return this.valueMax;
    }

    public final DashboardProperties copy(Integer num, String name, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DashboardProperties(num, name, f, f2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DashboardProperties) {
            DashboardProperties dashboardProperties = (DashboardProperties) obj;
            return Intrinsics.areEqual(this.type, dashboardProperties.type) && Intrinsics.areEqual(this.name, dashboardProperties.name) && Float.compare(this.value, dashboardProperties.value) == 0 && Float.compare(this.valueOffset, dashboardProperties.valueOffset) == 0 && Float.compare(this.valueMax, dashboardProperties.valueMax) == 0;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.type;
        return ((((((((num == null ? 0 : num.hashCode()) * 31) + this.name.hashCode()) * 31) + Float.hashCode(this.value)) * 31) + Float.hashCode(this.valueOffset)) * 31) + Float.hashCode(this.valueMax);
    }

    public String toString() {
        Integer num = this.type;
        String str = this.name;
        float f = this.value;
        float f2 = this.valueOffset;
        return "DashboardProperties(type=" + num + ", name=" + str + ", value=" + f + ", valueOffset=" + f2 + ", valueMax=" + this.valueMax + ")";
    }

    public DashboardProperties(Integer num, String name, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.type = num;
        this.name = name;
        this.value = f;
        this.valueOffset = f2;
        this.valueMax = f3;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final float getValue() {
        return this.value;
    }

    public final float getValueOffset() {
        return this.valueOffset;
    }

    public final float getValueMax() {
        return this.valueMax;
    }
}
