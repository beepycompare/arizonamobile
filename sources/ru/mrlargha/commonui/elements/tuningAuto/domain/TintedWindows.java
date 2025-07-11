package ru.mrlargha.commonui.elements.tuningAuto.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResponseData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/domain/TintedWindows;", "", "id", "", "color", "opacity", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColor", "getOpacity", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/tuningAuto/domain/TintedWindows;", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TintedWindows {
    private final Integer color;
    private final Integer id;
    private final Integer opacity;

    public static /* synthetic */ TintedWindows copy$default(TintedWindows tintedWindows, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = tintedWindows.id;
        }
        if ((i & 2) != 0) {
            num2 = tintedWindows.color;
        }
        if ((i & 4) != 0) {
            num3 = tintedWindows.opacity;
        }
        return tintedWindows.copy(num, num2, num3);
    }

    public final Integer component1() {
        return this.id;
    }

    public final Integer component2() {
        return this.color;
    }

    public final Integer component3() {
        return this.opacity;
    }

    public final TintedWindows copy(Integer num, Integer num2, Integer num3) {
        return new TintedWindows(num, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TintedWindows) {
            TintedWindows tintedWindows = (TintedWindows) obj;
            return Intrinsics.areEqual(this.id, tintedWindows.id) && Intrinsics.areEqual(this.color, tintedWindows.color) && Intrinsics.areEqual(this.opacity, tintedWindows.opacity);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.color;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.opacity;
        return hashCode2 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.id;
        Integer num2 = this.color;
        return "TintedWindows(id=" + num + ", color=" + num2 + ", opacity=" + this.opacity + ")";
    }

    public TintedWindows(Integer num, Integer num2, Integer num3) {
        this.id = num;
        this.color = num2;
        this.opacity = num3;
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final Integer getOpacity() {
        return this.opacity;
    }
}
