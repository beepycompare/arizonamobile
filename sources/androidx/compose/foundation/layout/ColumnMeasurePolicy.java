package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Column.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\b\u001a\u00020\u0004HÂ\u0003J\t\u0010\t\u001a\u00020\u0006HÂ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J=\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J2\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0002J\t\u0010\"\u001a\u00020\u000eHÖ\u0001Jg\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000eH\u0016¢\u0006\u0002\u00100J(\u00101\u001a\u0002022\u0006\u0010+\u001a\u00020\u000e2\u0006\u00103\u001a\u00020*2\u0006\u0010)\u001a\u00020*2\u0006\u0010'\u001a\u00020(H\u0016J\t\u00104\u001a\u000205HÖ\u0001J\f\u00106\u001a\u00020\u000e*\u00020\u001bH\u0016J\f\u00107\u001a\u00020\u000e*\u00020\u001bH\u0016J\"\u00108\u001a\u00020\u000e*\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010=\u001a\u00020\u000eH\u0016J\"\u0010>\u001a\u00020\u000e*\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010?\u001a\u00020\u000eH\u0016J,\u0010@\u001a\u00020$*\u00020(2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020A0;2\u0006\u0010B\u001a\u00020\fH\u0016ø\u0001\u0001¢\u0006\u0004\bC\u0010DJ\"\u0010E\u001a\u00020\u000e*\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010=\u001a\u00020\u000eH\u0016J\"\u0010F\u001a\u00020\u000e*\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010?\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"Landroidx/compose/foundation/layout/ColumnMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;)V", "component1", "component2", "copy", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "equals", "other", "", "getCrossAxisPosition", "placeable", "Landroidx/compose/ui/layout/Placeable;", "parentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "crossAxisLayoutSize", "beforeCrossAxisAlignmentLine", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "hashCode", "placeHelper", "Landroidx/compose/ui/layout/MeasureResult;", "placeables", "", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "mainAxisPositions", "", "mainAxisLayoutSize", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "populateMainAxisPositions", "", "childrenMainAxisSize", "toString", "", "crossAxisSize", "mainAxisSize", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColumnMeasurePolicy implements MeasurePolicy, RowColumnMeasurePolicy {
    public static final int $stable = 0;
    private final Alignment.Horizontal horizontalAlignment;
    private final Arrangement.Vertical verticalArrangement;

    private final Arrangement.Vertical component1() {
        return this.verticalArrangement;
    }

    private final Alignment.Horizontal component2() {
        return this.horizontalAlignment;
    }

    public static /* synthetic */ ColumnMeasurePolicy copy$default(ColumnMeasurePolicy columnMeasurePolicy, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, int i, Object obj) {
        if ((i & 1) != 0) {
            vertical = columnMeasurePolicy.verticalArrangement;
        }
        if ((i & 2) != 0) {
            horizontal = columnMeasurePolicy.horizontalAlignment;
        }
        return columnMeasurePolicy.copy(vertical, horizontal);
    }

    public final ColumnMeasurePolicy copy(Arrangement.Vertical vertical, Alignment.Horizontal horizontal) {
        return new ColumnMeasurePolicy(vertical, horizontal);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ColumnMeasurePolicy) {
            ColumnMeasurePolicy columnMeasurePolicy = (ColumnMeasurePolicy) obj;
            return Intrinsics.areEqual(this.verticalArrangement, columnMeasurePolicy.verticalArrangement) && Intrinsics.areEqual(this.horizontalAlignment, columnMeasurePolicy.horizontalAlignment);
        }
        return false;
    }

    public int hashCode() {
        return (this.verticalArrangement.hashCode() * 31) + this.horizontalAlignment.hashCode();
    }

    public String toString() {
        return "ColumnMeasurePolicy(verticalArrangement=" + this.verticalArrangement + ", horizontalAlignment=" + this.horizontalAlignment + ')';
    }

    public ColumnMeasurePolicy(Arrangement.Vertical vertical, Alignment.Horizontal horizontal) {
        this.verticalArrangement = vertical;
        this.horizontalAlignment = horizontal;
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int mainAxisSize(Placeable placeable) {
        return placeable.getHeight();
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int crossAxisSize(Placeable placeable) {
        return placeable.getWidth();
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public void populateMainAxisPositions(int i, int[] iArr, int[] iArr2, MeasureScope measureScope) {
        this.verticalArrangement.arrange(measureScope, i, iArr, iArr2);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public MeasureResult placeHelper(final Placeable[] placeableArr, final MeasureScope measureScope, final int i, final int[] iArr, int i2, final int i3, int[] iArr2, int i4, int i5, int i6) {
        return MeasureScope.layout$default(measureScope, i3, i2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.ColumnMeasurePolicy$placeHelper$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                int crossAxisPosition;
                Placeable[] placeableArr2 = placeableArr;
                ColumnMeasurePolicy columnMeasurePolicy = this;
                int i7 = i3;
                int i8 = i;
                MeasureScope measureScope2 = measureScope;
                int[] iArr3 = iArr;
                int length = placeableArr2.length;
                int i9 = 0;
                int i10 = 0;
                while (i9 < length) {
                    Placeable placeable = placeableArr2[i9];
                    Intrinsics.checkNotNull(placeable);
                    crossAxisPosition = columnMeasurePolicy.getCrossAxisPosition(placeable, RowColumnImplKt.getRowColumnParentData(placeable), i7, i8, measureScope2.getLayoutDirection());
                    Placeable.PlacementScope.place$default(placementScope, placeable, crossAxisPosition, iArr3[i10], 0.0f, 4, null);
                    i9++;
                    i10++;
                }
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCrossAxisPosition(Placeable placeable, RowColumnParentData rowColumnParentData, int i, int i2, LayoutDirection layoutDirection) {
        CrossAxisAlignment crossAxisAlignment = rowColumnParentData != null ? rowColumnParentData.getCrossAxisAlignment() : null;
        if (crossAxisAlignment != null) {
            return crossAxisAlignment.align$foundation_layout_release(i - placeable.getWidth(), layoutDirection, placeable, i2);
        }
        return this.horizontalAlignment.align(0, i - placeable.getWidth(), layoutDirection);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* renamed from: createConstraints-xF2OJ5Q  reason: not valid java name */
    public long mo651createConstraintsxF2OJ5Q(int i, int i2, int i3, int i4, boolean z) {
        return ColumnKt.createColumnConstraints(z, i, i2, i3, i4);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo42measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        MeasureResult measure;
        measure = RowColumnMeasurePolicyKt.measure(this, Constraints.m6638getMinHeightimpl(j), Constraints.m6639getMinWidthimpl(j), Constraints.m6636getMaxHeightimpl(j), Constraints.m6637getMaxWidthimpl(j), measureScope.mo383roundToPx0680j_4(this.verticalArrangement.mo625getSpacingD9Ej5fM()), measureScope, list, new Placeable[list.size()], 0, list.size(), (r28 & 1024) != 0 ? null : null, (r28 & 2048) != 0 ? 0 : 0);
        return measure;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMinWidth(list, i, intrinsicMeasureScope.mo383roundToPx0680j_4(this.verticalArrangement.mo625getSpacingD9Ej5fM()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMinHeight(list, i, intrinsicMeasureScope.mo383roundToPx0680j_4(this.verticalArrangement.mo625getSpacingD9Ej5fM()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMaxWidth(list, i, intrinsicMeasureScope.mo383roundToPx0680j_4(this.verticalArrangement.mo625getSpacingD9Ej5fM()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMaxHeight(list, i, intrinsicMeasureScope.mo383roundToPx0680j_4(this.verticalArrangement.mo625getSpacingD9Ej5fM()));
    }
}
