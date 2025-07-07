package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.snapping.SnapPosition;
import kotlin.Metadata;
import kotlin.math.MathKt;
/* compiled from: KeylineSnapPosition.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0000¨\u0006\n"}, d2 = {"KeylineSnapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageSize", "Landroidx/compose/material3/carousel/CarouselPageSize;", "getSnapPositionOffset", "", "strategy", "Landroidx/compose/material3/carousel/Strategy;", "itemIndex", "itemCount", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeylineSnapPositionKt {
    public static final int getSnapPositionOffset(Strategy strategy, int i, int i2) {
        if (strategy.isValid()) {
            int lastFocalIndex = strategy.getDefaultKeylines().getLastFocalIndex() - strategy.getDefaultKeylines().getFirstFocalIndex();
            int size = strategy.getStartKeylineSteps().size() + lastFocalIndex;
            int size2 = strategy.getEndKeylineSteps().size() + lastFocalIndex;
            int roundToInt = MathKt.roundToInt(strategy.getDefaultKeylines().getFirstFocal().getUnadjustedOffset() - (strategy.getItemMainAxisSize() / 2.0f));
            if (i < size) {
                roundToInt = MathKt.roundToInt(strategy.getStartKeylineSteps().get(Math.min(strategy.getStartKeylineSteps().size() - 1, Math.max(0, (size - 1) - i))).getFirstFocal().getUnadjustedOffset() - (strategy.getItemMainAxisSize() / 2.0f));
            }
            if (i2 <= lastFocalIndex + 1 || i < i2 - size2) {
                return roundToInt;
            }
            return MathKt.roundToInt(strategy.getEndKeylineSteps().get(Math.min(strategy.getEndKeylineSteps().size() - 1, Math.max(0, (i - i2) + size2))).getFirstFocal().getUnadjustedOffset() - (strategy.getItemMainAxisSize() / 2.0f));
        }
        return 0;
    }

    public static final SnapPosition KeylineSnapPosition(final CarouselPageSize carouselPageSize) {
        return new SnapPosition() { // from class: androidx.compose.material3.carousel.KeylineSnapPositionKt$KeylineSnapPosition$1
            @Override // androidx.compose.foundation.gestures.snapping.SnapPosition
            public int position(int i, int i2, int i3, int i4, int i5, int i6) {
                return KeylineSnapPositionKt.getSnapPositionOffset(CarouselPageSize.this.getStrategy(), i5, i6);
            }
        };
    }
}
