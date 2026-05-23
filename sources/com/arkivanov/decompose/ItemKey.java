package com.arkivanov.decompose;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0001HÂ\u0003J\t\u0010\b\u001a\u00020\u0004HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/arkivanov/decompose/ItemKey;", "", "value", FirebaseAnalytics.Param.INDEX, "", "<init>", "(Ljava/lang/Object;I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ItemKey {
    private final int index;
    private final Object value;

    private final Object component1() {
        return this.value;
    }

    private final int component2() {
        return this.index;
    }

    public static /* synthetic */ ItemKey copy$default(ItemKey itemKey, Object obj, int i, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = itemKey.value;
        }
        if ((i2 & 2) != 0) {
            i = itemKey.index;
        }
        return itemKey.copy(obj, i);
    }

    public final ItemKey copy(Object value, int i) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new ItemKey(value, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ItemKey) {
            ItemKey itemKey = (ItemKey) obj;
            return Intrinsics.areEqual(this.value, itemKey.value) && this.index == itemKey.index;
        }
        return false;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + Integer.hashCode(this.index);
    }

    public String toString() {
        return "ItemKey(value=" + this.value + ", index=" + this.index + ')';
    }

    public ItemKey(Object value, int i) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.index = i;
    }
}
