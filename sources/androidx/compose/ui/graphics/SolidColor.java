package androidx.compose.ui.graphics;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Brush.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001d\u001a\u00020\u0011H\u0016R\u0013\u0010\u0003\u001a\u00020\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/SolidColor;", "Landroidx/compose/ui/graphics/Brush;", "Landroidx/compose/ui/graphics/Interpolatable;", "value", "Landroidx/compose/ui/graphics/Color;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-0d7_KjU", "()J", "J", "applyTo", "", "size", "Landroidx/compose/ui/geometry/Size;", TtmlNode.TAG_P, "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "equals", "", "other", "", "hashCode", "", "toString", "", "lerp", "t", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SolidColor extends Brush implements Interpolatable {
    public static final int $stable = 0;
    private final long value;

    public /* synthetic */ SolidColor(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    private SolidColor(long j) {
        super(null);
        this.value = j;
    }

    /* renamed from: getValue-0d7_KjU  reason: not valid java name */
    public final long m5704getValue0d7_KjU() {
        return this.value;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* renamed from: applyTo-Pq9zytI */
    public void mo5293applyToPq9zytI(long j, Paint paint, float f) {
        paint.setAlpha(1.0f);
        int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
        long j2 = this.value;
        if (i != 0) {
            j2 = Color.m5347copywmQWz5c$default(j2, Color.m5350getAlphaimpl(j2) * f, 0.0f, 0.0f, 0.0f, 14, null);
        }
        paint.mo5224setColor8_81llA(j2);
        if (paint.getShader() != null) {
            paint.setShader(null);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SolidColor) && Color.m5349equalsimpl0(this.value, ((SolidColor) obj).value);
    }

    public int hashCode() {
        return Color.m5355hashCodeimpl(this.value);
    }

    public String toString() {
        return "SolidColor(value=" + ((Object) Color.m5356toStringimpl(this.value)) + ')';
    }

    @Override // androidx.compose.ui.graphics.Interpolatable
    public Object lerp(Object obj, float f) {
        if (obj == null) {
            obj = new SolidColor(Color.Companion.m5383getTransparent0d7_KjU(), null);
        }
        if (obj instanceof SolidColor) {
            return new SolidColor(ColorKt.m5399lerpjxsXWHM(this.value, ((SolidColor) obj).value, f), null);
        }
        return null;
    }
}
