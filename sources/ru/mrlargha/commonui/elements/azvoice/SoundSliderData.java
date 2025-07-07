package ru.mrlargha.commonui.elements.azvoice;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SoundSliderData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0013¨\u0006#"}, d2 = {"Lru/mrlargha/commonui/elements/azvoice/SoundSliderData;", "", "name", "", "maxValue", "", "minValue", "currentValue", "playerId", "sliderUId", "<init>", "(Ljava/lang/String;IIIII)V", "getName", "()Ljava/lang/String;", "getMaxValue", "()I", "getMinValue", "getCurrentValue", "setCurrentValue", "(I)V", "getPlayerId", "getSliderUId", "setSliderUId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SoundSliderData {
    private int currentValue;
    private final int maxValue;
    private final int minValue;
    private final String name;
    private final int playerId;
    private int sliderUId;

    public static /* synthetic */ SoundSliderData copy$default(SoundSliderData soundSliderData, String str, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = soundSliderData.name;
        }
        if ((i6 & 2) != 0) {
            i = soundSliderData.maxValue;
        }
        if ((i6 & 4) != 0) {
            i2 = soundSliderData.minValue;
        }
        if ((i6 & 8) != 0) {
            i3 = soundSliderData.currentValue;
        }
        if ((i6 & 16) != 0) {
            i4 = soundSliderData.playerId;
        }
        if ((i6 & 32) != 0) {
            i5 = soundSliderData.sliderUId;
        }
        int i7 = i4;
        int i8 = i5;
        return soundSliderData.copy(str, i, i2, i3, i7, i8);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.maxValue;
    }

    public final int component3() {
        return this.minValue;
    }

    public final int component4() {
        return this.currentValue;
    }

    public final int component5() {
        return this.playerId;
    }

    public final int component6() {
        return this.sliderUId;
    }

    public final SoundSliderData copy(String name, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new SoundSliderData(name, i, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SoundSliderData) {
            SoundSliderData soundSliderData = (SoundSliderData) obj;
            return Intrinsics.areEqual(this.name, soundSliderData.name) && this.maxValue == soundSliderData.maxValue && this.minValue == soundSliderData.minValue && this.currentValue == soundSliderData.currentValue && this.playerId == soundSliderData.playerId && this.sliderUId == soundSliderData.sliderUId;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + Integer.hashCode(this.maxValue)) * 31) + Integer.hashCode(this.minValue)) * 31) + Integer.hashCode(this.currentValue)) * 31) + Integer.hashCode(this.playerId)) * 31) + Integer.hashCode(this.sliderUId);
    }

    public String toString() {
        String str = this.name;
        int i = this.maxValue;
        int i2 = this.minValue;
        int i3 = this.currentValue;
        int i4 = this.playerId;
        return "SoundSliderData(name=" + str + ", maxValue=" + i + ", minValue=" + i2 + ", currentValue=" + i3 + ", playerId=" + i4 + ", sliderUId=" + this.sliderUId + ")";
    }

    public SoundSliderData(String name, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.maxValue = i;
        this.minValue = i2;
        this.currentValue = i3;
        this.playerId = i4;
        this.sliderUId = i5;
    }

    public /* synthetic */ SoundSliderData(String str, int i, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i3, (i6 & 16) != 0 ? -1 : i4, (i6 & 32) != 0 ? -1 : i5);
    }

    public final String getName() {
        return this.name;
    }

    public final int getMaxValue() {
        return this.maxValue;
    }

    public final int getMinValue() {
        return this.minValue;
    }

    public final int getCurrentValue() {
        return this.currentValue;
    }

    public final void setCurrentValue(int i) {
        this.currentValue = i;
    }

    public final int getPlayerId() {
        return this.playerId;
    }

    public final int getSliderUId() {
        return this.sliderUId;
    }

    public final void setSliderUId(int i) {
        this.sliderUId = i;
    }
}
