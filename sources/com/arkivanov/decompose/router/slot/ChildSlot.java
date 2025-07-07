package com.arkivanov.decompose.router.slot;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildSlot.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u00022\u00020\u0002B\u001f\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005HÆ\u0003J-\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/arkivanov/decompose/router/slot/ChildSlot;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "child", "Lcom/arkivanov/decompose/Child$Created;", "<init>", "(Lcom/arkivanov/decompose/Child$Created;)V", "getChild", "()Lcom/arkivanov/decompose/Child$Created;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildSlot<C, T> {
    private final Child.Created<C, T> child;

    public ChildSlot() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChildSlot copy$default(ChildSlot childSlot, Child.Created created, int i, Object obj) {
        if ((i & 1) != 0) {
            created = childSlot.child;
        }
        return childSlot.copy(created);
    }

    public final Child.Created<C, T> component1() {
        return this.child;
    }

    public final ChildSlot<C, T> copy(Child.Created<? extends C, ? extends T> created) {
        return new ChildSlot<>(created);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChildSlot) && Intrinsics.areEqual(this.child, ((ChildSlot) obj).child);
    }

    public int hashCode() {
        Child.Created<C, T> created = this.child;
        if (created == null) {
            return 0;
        }
        return created.hashCode();
    }

    public String toString() {
        return "ChildSlot(child=" + this.child + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChildSlot(Child.Created<? extends C, ? extends T> created) {
        this.child = created;
    }

    public /* synthetic */ ChildSlot(Child.Created created, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : created);
    }

    public final Child.Created<C, T> getChild() {
        return this.child;
    }
}
