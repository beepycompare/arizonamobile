package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
/* compiled from: ContextualFlowLayout.kt */
@LayoutScopeMarker
@Deprecated(message = "ContextualFlowLayouts are no longer maintained")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u0011H'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001a\u00020\tX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\tX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "Landroidx/compose/foundation/layout/RowScope;", "indexInLine", "", "getIndexInLine", "()I", "lineIndex", "getLineIndex", "maxHeight", "Landroidx/compose/ui/unit/Dp;", "getMaxHeight-D9Ej5fM", "()F", "maxWidthInLine", "getMaxWidthInLine-D9Ej5fM", "fillMaxRowHeight", "Landroidx/compose/ui/Modifier;", "fraction", "", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ContextualFlowRowScope extends RowScope {
    Modifier fillMaxRowHeight(Modifier modifier, float f);

    int getIndexInLine();

    int getLineIndex();

    /* renamed from: getMaxHeight-D9Ej5fM  reason: not valid java name */
    float mo656getMaxHeightD9Ej5fM();

    /* renamed from: getMaxWidthInLine-D9Ej5fM  reason: not valid java name */
    float mo657getMaxWidthInLineD9Ej5fM();

    static /* synthetic */ Modifier fillMaxRowHeight$default(ContextualFlowRowScope contextualFlowRowScope, Modifier modifier, float f, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                f = 1.0f;
            }
            return contextualFlowRowScope.fillMaxRowHeight(modifier, f);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillMaxRowHeight");
    }
}
