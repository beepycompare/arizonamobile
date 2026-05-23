package androidx.compose.foundation.style;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StyleModifier.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0002J#\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/style/StyleInnerNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "<init>", "()V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "outerNode", "Landroidx/compose/foundation/style/StyleOuterNode;", "getOuterNode", "()Landroidx/compose/foundation/style/StyleOuterNode;", "setOuterNode", "(Landroidx/compose/foundation/style/StyleOuterNode;)V", "currentLayoutStyle", "Landroidx/compose/foundation/style/ResolvedStyle;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "onAttach", "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StyleInnerNode extends Modifier.Node implements LayoutModifierNode {
    public static final int $stable = 8;
    private StyleOuterNode outerNode;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final StyleOuterNode getOuterNode() {
        return this.outerNode;
    }

    public final void setOuterNode(StyleOuterNode styleOuterNode) {
        this.outerNode = styleOuterNode;
    }

    private final ResolvedStyle currentLayoutStyle() {
        StyleOuterNode styleOuterNode = this.outerNode;
        Intrinsics.checkNotNull(styleOuterNode);
        return StyleOuterNode.resolveAnimatedStyleFor$foundation$default(styleOuterNode, 1, null, 2, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo69measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        ResolvedStyle currentLayoutStyle = currentLayoutStyle();
        final float contentPaddingStart$foundation = currentLayoutStyle.getContentPaddingStart$foundation() + currentLayoutStyle.getBorderWidth$foundation();
        float contentPaddingEnd$foundation = currentLayoutStyle.getContentPaddingEnd$foundation() + currentLayoutStyle.getBorderWidth$foundation();
        final float contentPaddingTop$foundation = currentLayoutStyle.getContentPaddingTop$foundation() + currentLayoutStyle.getBorderWidth$foundation();
        float contentPaddingBottom$foundation = currentLayoutStyle.getContentPaddingBottom$foundation() + currentLayoutStyle.getBorderWidth$foundation();
        int round = Math.round(contentPaddingEnd$foundation + contentPaddingStart$foundation);
        int round2 = Math.round(contentPaddingBottom$foundation + contentPaddingTop$foundation);
        final Placeable mo6818measureBRTryo0 = measurable.mo6818measureBRTryo0(ConstraintsKt.m8132offsetNN6EwU(j, -round, -round2));
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m8130constrainWidthK40F9xA(j, mo6818measureBRTryo0.getWidth() + round), ConstraintsKt.m8129constrainHeightK40F9xA(j, mo6818measureBRTryo0.getHeight() + round2), null, new Function1() { // from class: androidx.compose.foundation.style.StyleInnerNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StyleInnerNode.measure_3p2s80s$lambda$0(Placeable.this, contentPaddingStart$foundation, contentPaddingTop$foundation, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        TraversableNode findNearestAncestor = TraversableNodeKt.findNearestAncestor(this, StyleModifierKt.OuterNodeKey);
        Intrinsics.checkNotNull(findNearestAncestor, "null cannot be cast to non-null type androidx.compose.foundation.style.StyleOuterNode");
        StyleOuterNode styleOuterNode = (StyleOuterNode) findNearestAncestor;
        styleOuterNode.setInnerNode$foundation(this);
        this.outerNode = styleOuterNode;
        styleOuterNode.resolveStyleAndInvalidate(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, float f, float f2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, Math.round(f), Math.round(f2), 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
