package ru.mrlargha.commonui.elements.inventory.domain.models;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ImageItem.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J%\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/models/ImageItem;", "", "item", "", "bitmapHash", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "<init>", "(ILjava/util/HashMap;)V", "getItem", "()I", "getBitmapHash", "()Ljava/util/HashMap;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageItem {
    private final HashMap<String, byte[]> bitmapHash;
    private final int item;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageItem copy$default(ImageItem imageItem, int i, HashMap hashMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = imageItem.item;
        }
        if ((i2 & 2) != 0) {
            hashMap = imageItem.bitmapHash;
        }
        return imageItem.copy(i, hashMap);
    }

    public final int component1() {
        return this.item;
    }

    public final HashMap<String, byte[]> component2() {
        return this.bitmapHash;
    }

    public final ImageItem copy(int i, HashMap<String, byte[]> bitmapHash) {
        Intrinsics.checkNotNullParameter(bitmapHash, "bitmapHash");
        return new ImageItem(i, bitmapHash);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageItem) {
            ImageItem imageItem = (ImageItem) obj;
            return this.item == imageItem.item && Intrinsics.areEqual(this.bitmapHash, imageItem.bitmapHash);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.item) * 31) + this.bitmapHash.hashCode();
    }

    public String toString() {
        int i = this.item;
        return "ImageItem(item=" + i + ", bitmapHash=" + this.bitmapHash + ")";
    }

    public ImageItem(int i, HashMap<String, byte[]> bitmapHash) {
        Intrinsics.checkNotNullParameter(bitmapHash, "bitmapHash");
        this.item = i;
        this.bitmapHash = bitmapHash;
    }

    public final int getItem() {
        return this.item;
    }

    public final HashMap<String, byte[]> getBitmapHash() {
        return this.bitmapHash;
    }
}
