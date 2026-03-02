package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: DragHandle.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/DragHandleColors;", "", "color", "Landroidx/compose/ui/graphics/Color;", "pressedColor", "draggedColor", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getPressedColor-0d7_KjU", "getDraggedColor-0d7_KjU", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragHandleColors {
    public static final int $stable = 0;
    private final long color;
    private final long draggedColor;
    private final long pressedColor;

    public /* synthetic */ DragHandleColors(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private DragHandleColors(long j, long j2, long j3) {
        this.color = j;
        this.pressedColor = j2;
        this.draggedColor = j3;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m2041getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: getDraggedColor-0d7_KjU  reason: not valid java name */
    public final long m2042getDraggedColor0d7_KjU() {
        return this.draggedColor;
    }

    /* renamed from: getPressedColor-0d7_KjU  reason: not valid java name */
    public final long m2043getPressedColor0d7_KjU() {
        return this.pressedColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DragHandleColors)) {
            return false;
        }
        DragHandleColors dragHandleColors = (DragHandleColors) obj;
        return Color.m4773equalsimpl0(this.color, dragHandleColors.color) && Color.m4773equalsimpl0(this.pressedColor, dragHandleColors.pressedColor) && Color.m4773equalsimpl0(this.draggedColor, dragHandleColors.draggedColor);
    }

    public int hashCode() {
        return (((Color.m4779hashCodeimpl(this.color) * 31) + Color.m4779hashCodeimpl(this.pressedColor)) * 31) + Color.m4779hashCodeimpl(this.draggedColor);
    }
}
