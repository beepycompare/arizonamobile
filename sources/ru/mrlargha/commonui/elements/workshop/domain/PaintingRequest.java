package ru.mrlargha.commonui.elements.workshop.domain;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: WorkshopUi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/workshop/domain/PaintingRequest;", "", FirebaseAnalytics.Param.INDEX, "", TtmlNode.LEFT, TtmlNode.RIGHT, "color", "<init>", "(IIII)V", "getIndex", "()I", "getLeft", "getRight", "getColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaintingRequest {
    private final int color;
    private final int index;
    private final int left;
    private final int right;

    public static /* synthetic */ PaintingRequest copy$default(PaintingRequest paintingRequest, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = paintingRequest.index;
        }
        if ((i5 & 2) != 0) {
            i2 = paintingRequest.left;
        }
        if ((i5 & 4) != 0) {
            i3 = paintingRequest.right;
        }
        if ((i5 & 8) != 0) {
            i4 = paintingRequest.color;
        }
        return paintingRequest.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.index;
    }

    public final int component2() {
        return this.left;
    }

    public final int component3() {
        return this.right;
    }

    public final int component4() {
        return this.color;
    }

    public final PaintingRequest copy(int i, int i2, int i3, int i4) {
        return new PaintingRequest(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaintingRequest) {
            PaintingRequest paintingRequest = (PaintingRequest) obj;
            return this.index == paintingRequest.index && this.left == paintingRequest.left && this.right == paintingRequest.right && this.color == paintingRequest.color;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.index) * 31) + Integer.hashCode(this.left)) * 31) + Integer.hashCode(this.right)) * 31) + Integer.hashCode(this.color);
    }

    public String toString() {
        int i = this.index;
        int i2 = this.left;
        int i3 = this.right;
        return "PaintingRequest(index=" + i + ", left=" + i2 + ", right=" + i3 + ", color=" + this.color + ")";
    }

    public PaintingRequest(int i, int i2, int i3, int i4) {
        this.index = i;
        this.left = i2;
        this.right = i3;
        this.color = i4;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }
}
