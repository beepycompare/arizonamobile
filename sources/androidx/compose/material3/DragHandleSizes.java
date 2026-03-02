package androidx.compose.material3;

import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: DragHandle.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/DragHandleSizes;", "", "size", "Landroidx/compose/ui/unit/DpSize;", "pressedSize", "draggedSize", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSize-MYxV2XQ", "()J", "J", "getPressedSize-MYxV2XQ", "getDraggedSize-MYxV2XQ", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragHandleSizes {
    public static final int $stable = 0;
    private final long draggedSize;
    private final long pressedSize;
    private final long size;

    public /* synthetic */ DragHandleSizes(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private DragHandleSizes(long j, long j2, long j3) {
        this.size = j;
        this.pressedSize = j2;
        this.draggedSize = j3;
    }

    /* renamed from: getDraggedSize-MYxV2XQ  reason: not valid java name */
    public final long m2044getDraggedSizeMYxV2XQ() {
        return this.draggedSize;
    }

    /* renamed from: getPressedSize-MYxV2XQ  reason: not valid java name */
    public final long m2045getPressedSizeMYxV2XQ() {
        return this.pressedSize;
    }

    /* renamed from: getSize-MYxV2XQ  reason: not valid java name */
    public final long m2046getSizeMYxV2XQ() {
        return this.size;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DragHandleSizes)) {
            return false;
        }
        DragHandleSizes dragHandleSizes = (DragHandleSizes) obj;
        return DpSize.m7650equalsimpl0(this.size, dragHandleSizes.size) && DpSize.m7650equalsimpl0(this.pressedSize, dragHandleSizes.pressedSize) && DpSize.m7650equalsimpl0(this.draggedSize, dragHandleSizes.draggedSize);
    }

    public int hashCode() {
        return (((DpSize.m7655hashCodeimpl(this.size) * 31) + DpSize.m7655hashCodeimpl(this.pressedSize)) * 31) + DpSize.m7655hashCodeimpl(this.draggedSize);
    }
}
