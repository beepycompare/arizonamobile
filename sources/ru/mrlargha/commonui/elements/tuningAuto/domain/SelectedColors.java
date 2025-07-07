package ru.mrlargha.commonui.elements.tuningAuto.domain;

import kotlin.Metadata;
/* compiled from: ResponseData.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/domain/SelectedColors;", "", "color", "", "isSelected", "", "<init>", "(IZ)V", "getColor", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectedColors {
    private final int color;
    private final boolean isSelected;

    public static /* synthetic */ SelectedColors copy$default(SelectedColors selectedColors, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = selectedColors.color;
        }
        if ((i2 & 2) != 0) {
            z = selectedColors.isSelected;
        }
        return selectedColors.copy(i, z);
    }

    public final int component1() {
        return this.color;
    }

    public final boolean component2() {
        return this.isSelected;
    }

    public final SelectedColors copy(int i, boolean z) {
        return new SelectedColors(i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelectedColors) {
            SelectedColors selectedColors = (SelectedColors) obj;
            return this.color == selectedColors.color && this.isSelected == selectedColors.isSelected;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.color) * 31) + Boolean.hashCode(this.isSelected);
    }

    public String toString() {
        int i = this.color;
        return "SelectedColors(color=" + i + ", isSelected=" + this.isSelected + ")";
    }

    public SelectedColors(int i, boolean z) {
        this.color = i;
        this.isSelected = z;
    }

    public final int getColor() {
        return this.color;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }
}
