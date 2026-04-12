package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/ExtraData;", "", "value", "", "textColor", "", "cardColor", "<init>", "(Ljava/lang/String;II)V", "getValue", "()Ljava/lang/String;", "getTextColor", "()I", "getCardColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ExtraData {
    private final int cardColor;
    private final int textColor;
    private final String value;

    public static /* synthetic */ ExtraData copy$default(ExtraData extraData, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = extraData.value;
        }
        if ((i3 & 2) != 0) {
            i = extraData.textColor;
        }
        if ((i3 & 4) != 0) {
            i2 = extraData.cardColor;
        }
        return extraData.copy(str, i, i2);
    }

    public final String component1() {
        return this.value;
    }

    public final int component2() {
        return this.textColor;
    }

    public final int component3() {
        return this.cardColor;
    }

    public final ExtraData copy(String value, int i, int i2) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new ExtraData(value, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExtraData) {
            ExtraData extraData = (ExtraData) obj;
            return Intrinsics.areEqual(this.value, extraData.value) && this.textColor == extraData.textColor && this.cardColor == extraData.cardColor;
        }
        return false;
    }

    public int hashCode() {
        return (((this.value.hashCode() * 31) + Integer.hashCode(this.textColor)) * 31) + Integer.hashCode(this.cardColor);
    }

    public String toString() {
        String str = this.value;
        int i = this.textColor;
        return "ExtraData(value=" + str + ", textColor=" + i + ", cardColor=" + this.cardColor + ")";
    }

    public ExtraData(String value, int i, int i2) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.textColor = i;
        this.cardColor = i2;
    }

    public final String getValue() {
        return this.value;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getCardColor() {
        return this.cardColor;
    }
}
