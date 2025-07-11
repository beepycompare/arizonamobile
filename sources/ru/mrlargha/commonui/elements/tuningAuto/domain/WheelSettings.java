package ru.mrlargha.commonui.elements.tuningAuto.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResponseData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003JL\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/domain/WheelSettings;", "", "id", "", "title", "", "min", "", "step", "max", "value", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;DDDD)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getMin", "()D", "getStep", "getMax", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;DDDD)Lru/mrlargha/commonui/elements/tuningAuto/domain/WheelSettings;", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WheelSettings {
    private final Integer id;
    private final double max;
    private final double min;
    private final double step;
    private final String title;
    private final double value;

    public static /* synthetic */ WheelSettings copy$default(WheelSettings wheelSettings, Integer num, String str, double d, double d2, double d3, double d4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = wheelSettings.id;
        }
        if ((i & 2) != 0) {
            str = wheelSettings.title;
        }
        if ((i & 4) != 0) {
            d = wheelSettings.min;
        }
        if ((i & 8) != 0) {
            d2 = wheelSettings.step;
        }
        if ((i & 16) != 0) {
            d3 = wheelSettings.max;
        }
        if ((i & 32) != 0) {
            d4 = wheelSettings.value;
        }
        double d5 = d4;
        double d6 = d3;
        double d7 = d2;
        return wheelSettings.copy(num, str, d, d7, d6, d5);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final double component3() {
        return this.min;
    }

    public final double component4() {
        return this.step;
    }

    public final double component5() {
        return this.max;
    }

    public final double component6() {
        return this.value;
    }

    public final WheelSettings copy(Integer num, String title, double d, double d2, double d3, double d4) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new WheelSettings(num, title, d, d2, d3, d4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WheelSettings) {
            WheelSettings wheelSettings = (WheelSettings) obj;
            return Intrinsics.areEqual(this.id, wheelSettings.id) && Intrinsics.areEqual(this.title, wheelSettings.title) && Double.compare(this.min, wheelSettings.min) == 0 && Double.compare(this.step, wheelSettings.step) == 0 && Double.compare(this.max, wheelSettings.max) == 0 && Double.compare(this.value, wheelSettings.value) == 0;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.id;
        return ((((((((((num == null ? 0 : num.hashCode()) * 31) + this.title.hashCode()) * 31) + Double.hashCode(this.min)) * 31) + Double.hashCode(this.step)) * 31) + Double.hashCode(this.max)) * 31) + Double.hashCode(this.value);
    }

    public String toString() {
        Integer num = this.id;
        String str = this.title;
        double d = this.min;
        double d2 = this.step;
        double d3 = this.max;
        return "WheelSettings(id=" + num + ", title=" + str + ", min=" + d + ", step=" + d2 + ", max=" + d3 + ", value=" + this.value + ")";
    }

    public WheelSettings(Integer num, String title, double d, double d2, double d3, double d4) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = num;
        this.title = title;
        this.min = d;
        this.step = d2;
        this.max = d3;
        this.value = d4;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final double getMin() {
        return this.min;
    }

    public final double getStep() {
        return this.step;
    }

    public final double getMax() {
        return this.max;
    }

    public final double getValue() {
        return this.value;
    }
}
