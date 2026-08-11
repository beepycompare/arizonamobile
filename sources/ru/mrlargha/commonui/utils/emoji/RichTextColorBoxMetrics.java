package ru.mrlargha.commonui.utils.emoji;

import kotlin.Metadata;
/* compiled from: RichTextColorBoxSpan.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/utils/emoji/RichTextColorBoxMetrics;", "", "width", "", "contentWidth", "height", "textSize", "", "cornerRadius", "strokeWidth", "<init>", "(IIIFFF)V", "getWidth", "()I", "getContentWidth", "getHeight", "getTextSize", "()F", "getCornerRadius", "getStrokeWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final class RichTextColorBoxMetrics {
    private final int contentWidth;
    private final float cornerRadius;
    private final int height;
    private final float strokeWidth;
    private final float textSize;
    private final int width;

    public static /* synthetic */ RichTextColorBoxMetrics copy$default(RichTextColorBoxMetrics richTextColorBoxMetrics, int i, int i2, int i3, float f, float f2, float f3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = richTextColorBoxMetrics.width;
        }
        if ((i4 & 2) != 0) {
            i2 = richTextColorBoxMetrics.contentWidth;
        }
        if ((i4 & 4) != 0) {
            i3 = richTextColorBoxMetrics.height;
        }
        if ((i4 & 8) != 0) {
            f = richTextColorBoxMetrics.textSize;
        }
        if ((i4 & 16) != 0) {
            f2 = richTextColorBoxMetrics.cornerRadius;
        }
        if ((i4 & 32) != 0) {
            f3 = richTextColorBoxMetrics.strokeWidth;
        }
        float f4 = f2;
        float f5 = f3;
        return richTextColorBoxMetrics.copy(i, i2, i3, f, f4, f5);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.contentWidth;
    }

    public final int component3() {
        return this.height;
    }

    public final float component4() {
        return this.textSize;
    }

    public final float component5() {
        return this.cornerRadius;
    }

    public final float component6() {
        return this.strokeWidth;
    }

    public final RichTextColorBoxMetrics copy(int i, int i2, int i3, float f, float f2, float f3) {
        return new RichTextColorBoxMetrics(i, i2, i3, f, f2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RichTextColorBoxMetrics) {
            RichTextColorBoxMetrics richTextColorBoxMetrics = (RichTextColorBoxMetrics) obj;
            return this.width == richTextColorBoxMetrics.width && this.contentWidth == richTextColorBoxMetrics.contentWidth && this.height == richTextColorBoxMetrics.height && Float.compare(this.textSize, richTextColorBoxMetrics.textSize) == 0 && Float.compare(this.cornerRadius, richTextColorBoxMetrics.cornerRadius) == 0 && Float.compare(this.strokeWidth, richTextColorBoxMetrics.strokeWidth) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.contentWidth)) * 31) + Integer.hashCode(this.height)) * 31) + Float.hashCode(this.textSize)) * 31) + Float.hashCode(this.cornerRadius)) * 31) + Float.hashCode(this.strokeWidth);
    }

    public String toString() {
        int i = this.width;
        int i2 = this.contentWidth;
        int i3 = this.height;
        float f = this.textSize;
        float f2 = this.cornerRadius;
        return "RichTextColorBoxMetrics(width=" + i + ", contentWidth=" + i2 + ", height=" + i3 + ", textSize=" + f + ", cornerRadius=" + f2 + ", strokeWidth=" + this.strokeWidth + ")";
    }

    public RichTextColorBoxMetrics(int i, int i2, int i3, float f, float f2, float f3) {
        this.width = i;
        this.contentWidth = i2;
        this.height = i3;
        this.textSize = f;
        this.cornerRadius = f2;
        this.strokeWidth = f3;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getContentWidth() {
        return this.contentWidth;
    }

    public final int getHeight() {
        return this.height;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }
}
