package ru.mrlargha.commonui.elements.workshop.domain;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: WorkshopUi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/workshop/domain/SharpenRequest;", "", FirebaseAnalytics.Param.INDEX, "", TtmlNode.LEFT, TtmlNode.RIGHT, "<init>", "(III)V", "getIndex", "()I", "getLeft", "getRight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SharpenRequest {
    private final int index;
    private final int left;
    private final int right;

    public static /* synthetic */ SharpenRequest copy$default(SharpenRequest sharpenRequest, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = sharpenRequest.index;
        }
        if ((i4 & 2) != 0) {
            i2 = sharpenRequest.left;
        }
        if ((i4 & 4) != 0) {
            i3 = sharpenRequest.right;
        }
        return sharpenRequest.copy(i, i2, i3);
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

    public final SharpenRequest copy(int i, int i2, int i3) {
        return new SharpenRequest(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SharpenRequest) {
            SharpenRequest sharpenRequest = (SharpenRequest) obj;
            return this.index == sharpenRequest.index && this.left == sharpenRequest.left && this.right == sharpenRequest.right;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.index) * 31) + Integer.hashCode(this.left)) * 31) + Integer.hashCode(this.right);
    }

    public String toString() {
        int i = this.index;
        int i2 = this.left;
        return "SharpenRequest(index=" + i + ", left=" + i2 + ", right=" + this.right + ")";
    }

    public SharpenRequest(int i, int i2, int i3) {
        this.index = i;
        this.left = i2;
        this.right = i3;
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
