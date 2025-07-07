package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TabRow.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/TabPosition;", "", TtmlNode.LEFT, "Landroidx/compose/ui/unit/Dp;", "width", "contentWidth", "(FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentWidth-D9Ej5fM", "()F", "F", "getLeft-D9Ej5fM", TtmlNode.RIGHT, "getRight-D9Ej5fM", "getWidth-D9Ej5fM", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TabPosition {
    public static final int $stable = 0;
    private final float contentWidth;
    private final float left;
    private final float width;

    public /* synthetic */ TabPosition(float f, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3);
    }

    private TabPosition(float f, float f2, float f3) {
        this.left = f;
        this.width = f2;
        this.contentWidth = f3;
    }

    /* renamed from: getContentWidth-D9Ej5fM  reason: not valid java name */
    public final float m2386getContentWidthD9Ej5fM() {
        return this.contentWidth;
    }

    /* renamed from: getLeft-D9Ej5fM  reason: not valid java name */
    public final float m2387getLeftD9Ej5fM() {
        return this.left;
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m2389getWidthD9Ej5fM() {
        return this.width;
    }

    /* renamed from: getRight-D9Ej5fM  reason: not valid java name */
    public final float m2388getRightD9Ej5fM() {
        return Dp.m6684constructorimpl(this.left + this.width);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TabPosition) {
            TabPosition tabPosition = (TabPosition) obj;
            return Dp.m6689equalsimpl0(this.left, tabPosition.left) && Dp.m6689equalsimpl0(this.width, tabPosition.width) && Dp.m6689equalsimpl0(this.contentWidth, tabPosition.contentWidth);
        }
        return false;
    }

    public int hashCode() {
        return (((Dp.m6690hashCodeimpl(this.left) * 31) + Dp.m6690hashCodeimpl(this.width)) * 31) + Dp.m6690hashCodeimpl(this.contentWidth);
    }

    public String toString() {
        return "TabPosition(left=" + ((Object) Dp.m6695toStringimpl(this.left)) + ", right=" + ((Object) Dp.m6695toStringimpl(m2388getRightD9Ej5fM())) + ", width=" + ((Object) Dp.m6695toStringimpl(this.width)) + ", contentWidth=" + ((Object) Dp.m6695toStringimpl(this.contentWidth)) + ')';
    }
}
