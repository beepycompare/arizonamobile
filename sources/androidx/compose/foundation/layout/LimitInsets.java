package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WindowInsets.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00020\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/LimitInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getSides-JoeWqyM", "()I", "I", "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "equals", "", "other", "", "hashCode", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LimitInsets implements WindowInsets {
    private final WindowInsets insets;
    private final int sides;

    public /* synthetic */ LimitInsets(WindowInsets windowInsets, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsets, i);
    }

    private LimitInsets(WindowInsets windowInsets, int i) {
        this.insets = windowInsets;
        this.sides = i;
    }

    public final WindowInsets getInsets() {
        return this.insets;
    }

    /* renamed from: getSides-JoeWqyM  reason: not valid java name */
    public final int m772getSidesJoeWqyM() {
        return this.sides;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        int m908getAllowLeftInRtlJoeWqyM$foundation_layout;
        if (layoutDirection == LayoutDirection.Ltr) {
            m908getAllowLeftInRtlJoeWqyM$foundation_layout = WindowInsetsSides.Companion.m907getAllowLeftInLtrJoeWqyM$foundation_layout();
        } else {
            m908getAllowLeftInRtlJoeWqyM$foundation_layout = WindowInsetsSides.Companion.m908getAllowLeftInRtlJoeWqyM$foundation_layout();
        }
        if (WindowInsetsSides.m901hasAnybkgdKaI$foundation_layout(this.sides, m908getAllowLeftInRtlJoeWqyM$foundation_layout)) {
            return this.insets.getLeft(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        if (WindowInsetsSides.m901hasAnybkgdKaI$foundation_layout(this.sides, WindowInsetsSides.Companion.m917getTopJoeWqyM())) {
            return this.insets.getTop(density);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        int m910getAllowRightInRtlJoeWqyM$foundation_layout;
        if (layoutDirection == LayoutDirection.Ltr) {
            m910getAllowRightInRtlJoeWqyM$foundation_layout = WindowInsetsSides.Companion.m909getAllowRightInLtrJoeWqyM$foundation_layout();
        } else {
            m910getAllowRightInRtlJoeWqyM$foundation_layout = WindowInsetsSides.Companion.m910getAllowRightInRtlJoeWqyM$foundation_layout();
        }
        if (WindowInsetsSides.m901hasAnybkgdKaI$foundation_layout(this.sides, m910getAllowRightInRtlJoeWqyM$foundation_layout)) {
            return this.insets.getRight(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        if (WindowInsetsSides.m901hasAnybkgdKaI$foundation_layout(this.sides, WindowInsetsSides.Companion.m911getBottomJoeWqyM())) {
            return this.insets.getBottom(density);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LimitInsets) {
            LimitInsets limitInsets = (LimitInsets) obj;
            return Intrinsics.areEqual(this.insets, limitInsets.insets) && WindowInsetsSides.m900equalsimpl0(this.sides, limitInsets.sides);
        }
        return false;
    }

    public int hashCode() {
        return (this.insets.hashCode() * 31) + WindowInsetsSides.m902hashCodeimpl(this.sides);
    }

    public String toString() {
        return "(" + this.insets + " only " + ((Object) WindowInsetsSides.m904toStringimpl(this.sides)) + ')';
    }
}
