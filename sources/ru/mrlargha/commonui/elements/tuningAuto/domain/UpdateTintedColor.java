package ru.mrlargha.commonui.elements.tuningAuto.domain;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
/* compiled from: SendData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR%\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/domain/UpdateTintedColor;", "", TtmlNode.ATTR_ID, "", "color", "opacity", "<init>", "(III)V", "getId", "()I", "getColor", "Lcom/google/gson/annotations/SerializedName;", "value", "color_id", "getOpacity", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UpdateTintedColor {
    @SerializedName("color_id")
    private final int color;
    private final int id;
    private final int opacity;

    public static /* synthetic */ UpdateTintedColor copy$default(UpdateTintedColor updateTintedColor, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = updateTintedColor.id;
        }
        if ((i4 & 2) != 0) {
            i2 = updateTintedColor.color;
        }
        if ((i4 & 4) != 0) {
            i3 = updateTintedColor.opacity;
        }
        return updateTintedColor.copy(i, i2, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.color;
    }

    public final int component3() {
        return this.opacity;
    }

    public final UpdateTintedColor copy(int i, int i2, int i3) {
        return new UpdateTintedColor(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpdateTintedColor) {
            UpdateTintedColor updateTintedColor = (UpdateTintedColor) obj;
            return this.id == updateTintedColor.id && this.color == updateTintedColor.color && this.opacity == updateTintedColor.opacity;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.color)) * 31) + Integer.hashCode(this.opacity);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.color;
        return "UpdateTintedColor(id=" + i + ", color=" + i2 + ", opacity=" + this.opacity + ")";
    }

    public UpdateTintedColor(int i, int i2, int i3) {
        this.id = i;
        this.color = i2;
        this.opacity = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getOpacity() {
        return this.opacity;
    }
}
