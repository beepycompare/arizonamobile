package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MeasurePassDelegate.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0017\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b=\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010{\u001a\u000e\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020W0|H\u0016J\b\u0010~\u001a\u00020/H\u0002J\b\u0010\u007f\u001a\u00020/H\u0002J\u001e\u0010\u0080\u0001\u001a\u00020/2\u0013\u0010\u0081\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020/0-H\u0016J\u001f\u0010\u0082\u0001\u001a\u00020/2\u0013\u0010\u0081\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020/0-H\u0082\bJ\u0013\u0010\u0083\u0001\u001a\u00020W2\u0007\u0010\u0084\u0001\u001a\u00020}H\u0096\u0002J\u0010\u0010\u0085\u0001\u001a\u00020/2\u0007\u0010\u0086\u0001\u001a\u00020\u0013J\u0007\u0010\u0087\u0001\u001a\u00020/J\t\u0010\u0088\u0001\u001a\u00020/H\u0016J\u000f\u0010\u0089\u0001\u001a\u00020/H\u0000¢\u0006\u0003\b\u008a\u0001J\u0007\u0010\u008b\u0001\u001a\u00020/J\u000f\u0010\u008c\u0001\u001a\u00020/H\u0000¢\u0006\u0003\b\u008d\u0001J\t\u0010\u008e\u0001\u001a\u00020/H\u0002J\t\u0010\u008f\u0001\u001a\u00020/H\u0002J\u0012\u0010\u0090\u0001\u001a\u00020W2\u0007\u0010\u0091\u0001\u001a\u00020WH\u0016J\u0012\u0010\u0092\u0001\u001a\u00020W2\u0007\u0010\u0093\u0001\u001a\u00020WH\u0016J\u001e\u0010\u0094\u0001\u001a\u00020\u00022\u0007\u0010\u0095\u0001\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0012\u0010\u0098\u0001\u001a\u00020W2\u0007\u0010\u0091\u0001\u001a\u00020WH\u0016J\u0012\u0010\u0099\u0001\u001a\u00020W2\u0007\u0010\u0093\u0001\u001a\u00020WH\u0016J\u0007\u0010\u009a\u0001\u001a\u00020/J\t\u0010\u009b\u0001\u001a\u00020/H\u0002J\t\u0010\u009c\u0001\u001a\u00020/H\u0002J\u0007\u0010\u009d\u0001\u001a\u00020/J\u000f\u0010\u009e\u0001\u001a\u00020/H\u0000¢\u0006\u0003\b\u009f\u0001J\u001e\u0010 \u0001\u001a\u00020/2\u0007\u0010\u0095\u0001\u001a\u00020'H\u0000ø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¢\u0001JB\u0010£\u0001\u001a\u00020/2\u0007\u0010¤\u0001\u001a\u0002012\u0006\u0010x\u001a\u0002072\u001a\u0010¥\u0001\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-¢\u0006\u0002\b0H\u0014ø\u0001\u0000¢\u0006\u0006\b¦\u0001\u0010§\u0001J/\u0010£\u0001\u001a\u00020/2\u0007\u0010¤\u0001\u001a\u0002012\u0006\u0010x\u001a\u0002072\u0007\u0010¨\u0001\u001a\u00020+H\u0014ø\u0001\u0000¢\u0006\u0006\b¦\u0001\u0010©\u0001JM\u0010ª\u0001\u001a\u00020/2\u0007\u0010¤\u0001\u001a\u0002012\u0006\u0010x\u001a\u0002072\u001a\u0010¥\u0001\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-¢\u0006\u0002\b02\t\u0010¨\u0001\u001a\u0004\u0018\u00010+H\u0002ø\u0001\u0000¢\u0006\u0006\b«\u0001\u0010¬\u0001JM\u0010\u00ad\u0001\u001a\u00020/2\u0007\u0010¤\u0001\u001a\u0002012\u0006\u0010x\u001a\u0002072\u001a\u0010¥\u0001\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-¢\u0006\u0002\b02\t\u0010¨\u0001\u001a\u0004\u0018\u00010+H\u0002ø\u0001\u0000¢\u0006\u0006\b®\u0001\u0010¬\u0001J\u001c\u0010¯\u0001\u001a\u00020\u00132\u0007\u0010\u0095\u0001\u001a\u00020'ø\u0001\u0000¢\u0006\u0006\b°\u0001\u0010±\u0001J\u0007\u0010²\u0001\u001a\u00020/J\t\u0010³\u0001\u001a\u00020/H\u0016J\t\u0010´\u0001\u001a\u00020/H\u0016J\u0012\u0010µ\u0001\u001a\u00020/2\u0007\u0010¶\u0001\u001a\u00020=H\u0002J\u0007\u0010·\u0001\u001a\u00020\u0013J\u0012\u0010¸\u0001\u001a\u00020/2\u0007\u0010¹\u0001\u001a\u00020\u0013H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R$\u0010\"\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010$\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u0019\u0010&\u001a\u0004\u0018\u00010'8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010,\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-¢\u0006\u0002\b0X\u0082\u000e¢\u0006\u0002\n\u0000R&\u00102\u001a\u0002012\u0006\u0010\u001f\u001a\u000201@BX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0015R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020/0;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010<\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0015R\u000e\u0010B\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010E\u001a\u00020D2\u0006\u0010C\u001a\u00020D8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0016\u0010J\u001a\u0004\u0018\u00010K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001e\u0010N\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0015R\u001a\u0010P\u001a\u00020QX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020W8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u000e\u0010Z\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\u00020W8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010YR\u000e\u0010]\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010_\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b`\u0010\u001eR\u0016\u0010a\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\"\u0010e\u001a\u0004\u0018\u00010d2\b\u0010\u001f\u001a\u0004\u0018\u00010d@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u000e\u0010h\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020/0;X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0016\u0010l\u001a\u00020'X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00105R\u001e\u0010m\u001a\u00020W2\u0006\u0010\u001f\u001a\u00020W@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bn\u0010YR\u0014\u0010o\u001a\b\u0012\u0004\u0012\u00020/0;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010q\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-¢\u0006\u0002\b0X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010r\u001a\u000201X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00105R\u000e\u0010s\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010u\u001a\u00020W2\u0006\u0010\u001f\u001a\u00020W@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bv\u0010YR\u000e\u0010w\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010x\u001a\u0002072\u0006\u0010\u001f\u001a\u000207@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\by\u0010z\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006º\u0001"}, d2 = {"Landroidx/compose/ui/node/MeasurePassDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "layoutNodeLayoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "childDelegates", "", "getChildDelegates$ui_release", "()Ljava/util/List;", "childDelegatesDirty", "", "getChildDelegatesDirty$ui_release", "()Z", "setChildDelegatesDirty$ui_release", "(Z)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "<set-?>", "isPlaced", "setPlaced$ui_release", "isPlacedByParent", "setPlacedByParent$ui_release", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastExplicitLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/unit/IntOffset;", "lastPosition", "getLastPosition-nOcc-ac$ui_release", "()J", "J", "lastZIndex", "", "layingOutChildren", "getLayingOutChildren", "layoutChildrenBlock", "Lkotlin/Function0;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "layoutPending", "getLayoutPending$ui_release", "layoutPendingForAlignment", "value", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "setLayoutState", "(Landroidx/compose/ui/node/LayoutNode$LayoutState;)V", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LookaheadPassDelegate;", "getLookaheadPassDelegate", "()Landroidx/compose/ui/node/LookaheadPassDelegate;", "measurePending", "getMeasurePending$ui_release", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "needsCoordinatesUpdate", "onNodePlacedCalled", "outerCoordinator", "getOuterCoordinator", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "", "parentData", "getParentData", "()Ljava/lang/Object;", "parentDataDirty", "performMeasureBlock", "getPerformMeasureBlock$ui_release", "()Lkotlin/jvm/functions/Function0;", "performMeasureConstraints", "placeOrder", "getPlaceOrder$ui_release", "placeOuterCoordinatorBlock", "placeOuterCoordinatorLayer", "placeOuterCoordinatorLayerBlock", "placeOuterCoordinatorPosition", "placeOuterCoordinatorZIndex", "placedOnce", "previousPlaceOrder", "getPreviousPlaceOrder$ui_release", "relayoutWithoutParentInProgress", "zIndex", "getZIndex$ui_release", "()F", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "checkChildrenPlaceOrderForUpdates", "clearPlaceOrder", "forEachChildAlignmentLinesOwner", "block", "forEachChildDelegate", "get", "alignmentLine", "invalidateIntrinsicsParent", "forceRequest", "invalidateParentData", "layoutChildren", "markDetachedFromParentLookaheadPass", "markDetachedFromParentLookaheadPass$ui_release", "markLayoutPending", "markMeasurePending", "markMeasurePending$ui_release", "markNodeAndSubtreeAsPlaced", "markSubtreeAsNotPlaced", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "notifyChildrenUsingCoordinatesWhilePlacing", "onBeforeLayoutChildren", "onIntrinsicsQueried", "onNodeDetached", "onNodePlaced", "onNodePlaced$ui_release", "performMeasure", "performMeasure-BRTryo0$ui_release", "(J)V", "placeAt", "position", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", AdRevenueConstants.LAYER_KEY, "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeOuterCoordinator", "placeOuterCoordinator-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "placeSelf-MLgxB_4", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "requestLayout", "requestMeasure", "trackMeasurementByParent", "node", "updateParentData", "updatePlacedUnderMotionFrameOfReference", "newMFR", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    public static final int $stable = 8;
    private boolean duringAlignmentLinesQuery;
    private boolean isPlaced;
    private boolean isPlacedByParent;
    private boolean isPlacedUnderMotionFrameOfReference;
    private GraphicsLayer lastExplicitLayer;
    private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
    private float lastZIndex;
    private boolean layingOutChildren;
    private final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
    private boolean layoutPending;
    private boolean layoutPendingForAlignment;
    private boolean measurePending;
    private boolean measuredOnce;
    private boolean needsCoordinatesUpdate;
    private boolean onNodePlacedCalled;
    private Object parentData;
    private GraphicsLayer placeOuterCoordinatorLayer;
    private Function1<? super GraphicsLayerScope, Unit> placeOuterCoordinatorLayerBlock;
    private float placeOuterCoordinatorZIndex;
    private boolean placedOnce;
    private boolean relayoutWithoutParentInProgress;
    private float zIndex;
    private int previousPlaceOrder = Integer.MAX_VALUE;
    private int placeOrder = Integer.MAX_VALUE;
    private LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
    private long lastPosition = IntOffset.Companion.m6823getZeronOccac();
    private boolean parentDataDirty = true;
    private final AlignmentLines alignmentLines = new LayoutNodeAlignmentLines(this);
    private final MutableVector<MeasurePassDelegate> _childDelegates = new MutableVector<>(new MeasurePassDelegate[16], 0);
    private boolean childDelegatesDirty = true;
    private long performMeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    private final Function0<Unit> performMeasureBlock = new Function0<Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$performMeasureBlock$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            long j;
            NodeCoordinator outerCoordinator = MeasurePassDelegate.this.getOuterCoordinator();
            j = MeasurePassDelegate.this.performMeasureConstraints;
            outerCoordinator.mo5438measureBRTryo0(j);
        }
    };
    private final Function0<Unit> layoutChildrenBlock = new Function0<Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MeasurePassDelegate.this.clearPlaceOrder();
            MeasurePassDelegate.this.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    invoke2(alignmentLinesOwner);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                    alignmentLinesOwner.getAlignmentLines().setUsedDuringParentLayout$ui_release(false);
                }
            });
            MeasurePassDelegate.this.getInnerCoordinator().getMeasureResult$ui_release().placeChildren();
            MeasurePassDelegate.this.checkChildrenPlaceOrderForUpdates();
            MeasurePassDelegate.this.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    invoke2(alignmentLinesOwner);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                    alignmentLinesOwner.getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(alignmentLinesOwner.getAlignmentLines().getUsedDuringParentLayout$ui_release());
                }
            });
        }
    };
    private long placeOuterCoordinatorPosition = IntOffset.Companion.m6823getZeronOccac();
    private final Function0<Unit> placeOuterCoordinatorBlock = new Function0<Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$placeOuterCoordinatorBlock$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Placeable.PlacementScope placementScope;
            Function1<? super GraphicsLayerScope, Unit> function1;
            GraphicsLayer graphicsLayer;
            long j;
            float f;
            long j2;
            float f2;
            long j3;
            float f3;
            NodeCoordinator wrappedBy$ui_release = MeasurePassDelegate.this.getOuterCoordinator().getWrappedBy$ui_release();
            if (wrappedBy$ui_release == null || (placementScope = wrappedBy$ui_release.getPlacementScope()) == null) {
                placementScope = LayoutNodeKt.requireOwner(MeasurePassDelegate.this.getLayoutNode()).getPlacementScope();
            }
            Placeable.PlacementScope placementScope2 = placementScope;
            MeasurePassDelegate measurePassDelegate = MeasurePassDelegate.this;
            function1 = measurePassDelegate.placeOuterCoordinatorLayerBlock;
            graphicsLayer = measurePassDelegate.placeOuterCoordinatorLayer;
            if (graphicsLayer != null) {
                j3 = measurePassDelegate.placeOuterCoordinatorPosition;
                f3 = measurePassDelegate.placeOuterCoordinatorZIndex;
                placementScope2.m5517placeWithLayeraW9wM(measurePassDelegate.getOuterCoordinator(), j3, graphicsLayer, f3);
            } else if (function1 == null) {
                j2 = measurePassDelegate.placeOuterCoordinatorPosition;
                f2 = measurePassDelegate.placeOuterCoordinatorZIndex;
                placementScope2.m5508place70tqf50(measurePassDelegate.getOuterCoordinator(), j2, f2);
            } else {
                j = measurePassDelegate.placeOuterCoordinatorPosition;
                f = measurePassDelegate.placeOuterCoordinatorZIndex;
                placementScope2.m5516placeWithLayeraW9wM(measurePassDelegate.getOuterCoordinator(), j, f, function1);
            }
        }
    };

    /* compiled from: MeasurePassDelegate.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
            try {
                iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public MeasurePassDelegate(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        this.layoutNodeLayoutDelegate = layoutNodeLayoutDelegate;
    }

    public final int getPreviousPlaceOrder$ui_release() {
        return this.previousPlaceOrder;
    }

    public final int getPlaceOrder$ui_release() {
        return this.placeOrder;
    }

    /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
    public final Constraints m5653getLastConstraintsDWUhwKw() {
        if (this.measuredOnce) {
            return Constraints.m6624boximpl(m5498getMeasurementConstraintsmsEJaDk());
        }
        return null;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNodeLayoutDelegate.getLayoutNode$ui_release();
    }

    public final LayoutNode.UsageByParent getMeasuredByParent$ui_release() {
        return this.measuredByParent;
    }

    public final void setMeasuredByParent$ui_release(LayoutNode.UsageByParent usageByParent) {
        this.measuredByParent = usageByParent;
    }

    public final boolean getDuringAlignmentLinesQuery$ui_release() {
        return this.duringAlignmentLinesQuery;
    }

    public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
        this.duringAlignmentLinesQuery = z;
    }

    /* renamed from: getLastPosition-nOcc-ac$ui_release  reason: not valid java name */
    public final long m5654getLastPositionnOccac$ui_release() {
        return this.lastPosition;
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        return this.parentData;
    }

    private final LookaheadPassDelegate getLookaheadPassDelegate() {
        return this.layoutNodeLayoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public boolean isPlaced() {
        return this.isPlaced;
    }

    public void setPlaced$ui_release(boolean z) {
        this.isPlaced = z;
    }

    public final boolean isPlacedByParent() {
        return this.isPlacedByParent;
    }

    public final void setPlacedByParent$ui_release(boolean z) {
        this.isPlacedByParent = z;
    }

    public final boolean getMeasurePending$ui_release() {
        return this.measurePending;
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutPending;
    }

    public final LayoutNode.LayoutState getLayoutState() {
        return this.layoutNodeLayoutDelegate.getLayoutState$ui_release();
    }

    public final void setLayoutState(LayoutNode.LayoutState layoutState) {
        this.layoutNodeLayoutDelegate.setLayoutState$ui_release(layoutState);
    }

    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public NodeCoordinator getInnerCoordinator() {
        return getLayoutNode().getInnerCoordinator$ui_release();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLines getAlignmentLines() {
        return this.alignmentLines;
    }

    public final boolean getChildDelegatesDirty$ui_release() {
        return this.childDelegatesDirty;
    }

    public final void setChildDelegatesDirty$ui_release(boolean z) {
        this.childDelegatesDirty = z;
    }

    public final List<MeasurePassDelegate> getChildDelegates$ui_release() {
        getLayoutNode().updateChildrenIfDirty$ui_release();
        if (this.childDelegatesDirty) {
            LayoutNode layoutNode = getLayoutNode();
            MutableVector<MeasurePassDelegate> mutableVector = this._childDelegates;
            MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui_release();
            LayoutNode[] layoutNodeArr = mutableVector2.content;
            int size = mutableVector2.getSize();
            for (int i = 0; i < size; i++) {
                LayoutNode layoutNode2 = layoutNodeArr[i];
                if (mutableVector.getSize() <= i) {
                    mutableVector.add(layoutNode2.getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release());
                } else {
                    mutableVector.set(i, layoutNode2.getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release());
                }
            }
            mutableVector.removeRange(layoutNode.getChildren$ui_release().size(), mutableVector.getSize());
            this.childDelegatesDirty = false;
            return this._childDelegates.asMutableList();
        }
        return this._childDelegates.asMutableList();
    }

    public final void markDetachedFromParentLookaheadPass$ui_release() {
        this.layoutNodeLayoutDelegate.setDetachedFromParentLookaheadPass$ui_release(true);
    }

    public final boolean getLayingOutChildren() {
        return this.layingOutChildren;
    }

    public final Function0<Unit> getPerformMeasureBlock$ui_release() {
        return this.performMeasureBlock;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void layoutChildren() {
        this.layingOutChildren = true;
        getAlignmentLines().recalculateQueryOwner();
        if (this.layoutPending) {
            onBeforeLayoutChildren();
        }
        if (this.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().isPlacingForAlignment$ui_release() && this.layoutPending)) {
            this.layoutPending = false;
            LayoutNode.LayoutState layoutState = getLayoutState();
            setLayoutState(LayoutNode.LayoutState.LayingOut);
            this.layoutNodeLayoutDelegate.setCoordinatesAccessedDuringPlacement(false);
            LayoutNode layoutNode = getLayoutNode();
            LayoutNodeKt.requireOwner(layoutNode).getSnapshotObserver().observeLayoutSnapshotReads$ui_release(layoutNode, false, this.layoutChildrenBlock);
            setLayoutState(layoutState);
            if (getInnerCoordinator().isPlacingForAlignment$ui_release() && this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringPlacement()) {
                requestLayout();
            }
            this.layoutPendingForAlignment = false;
        }
        if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
            getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
        }
        if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
            getAlignmentLines().recalculate();
        }
        this.layingOutChildren = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkChildrenPlaceOrderForUpdates() {
        LayoutNode layoutNode = getLayoutNode();
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (layoutNode2.getMeasurePassDelegate$ui_release().previousPlaceOrder != layoutNode2.getPlaceOrder$ui_release()) {
                layoutNode.onZSortedChildrenInvalidated$ui_release();
                layoutNode.invalidateLayer$ui_release();
                if (layoutNode2.getPlaceOrder$ui_release() == Integer.MAX_VALUE) {
                    if (layoutNode2.getLayoutDelegate$ui_release().getDetachedFromParentLookaheadPlacement$ui_release()) {
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode2.getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                        lookaheadPassDelegate$ui_release.markNodeAndSubtreeAsNotPlaced$ui_release(false);
                    }
                    layoutNode2.getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
                }
            }
        }
    }

    private final void markSubtreeAsNotPlaced() {
        if (isPlaced()) {
            setPlaced$ui_release(false);
            LayoutNode layoutNode = getLayoutNode();
            NodeCoordinator wrapped$ui_release = layoutNode.getInnerCoordinator$ui_release().getWrapped$ui_release();
            for (NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped$ui_release) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release()) {
                outerCoordinator$ui_release.onUnplaced();
                outerCoordinator$ui_release.releaseLayer();
            }
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                layoutNodeArr[i].getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
            }
        }
    }

    private final void markNodeAndSubtreeAsPlaced() {
        boolean isPlaced = isPlaced();
        setPlaced$ui_release(true);
        LayoutNode layoutNode = getLayoutNode();
        if (!isPlaced) {
            layoutNode.getInnerCoordinator$ui_release().onPlaced();
            if (layoutNode.getMeasurePending$ui_release()) {
                LayoutNode.requestRemeasure$ui_release$default(layoutNode, true, false, false, 6, null);
            } else if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNode, true, false, false, 6, null);
            }
        }
        NodeCoordinator wrapped$ui_release = layoutNode.getInnerCoordinator$ui_release().getWrapped$ui_release();
        for (NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped$ui_release) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release()) {
            if (outerCoordinator$ui_release.getLastLayerDrawingWasSkipped$ui_release()) {
                outerCoordinator$ui_release.invalidateLayer();
            }
        }
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (layoutNode2.getPlaceOrder$ui_release() != Integer.MAX_VALUE) {
                layoutNode2.getMeasurePassDelegate$ui_release().markNodeAndSubtreeAsPlaced();
                layoutNode.rescheduleRemeasureOrRelayout$ui_release(layoutNode2);
            }
        }
    }

    public final float getZIndex$ui_release() {
        return this.zIndex;
    }

    public final void onNodePlaced$ui_release() {
        this.onNodePlacedCalled = true;
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        float zIndex = getInnerCoordinator().getZIndex();
        LayoutNode layoutNode = getLayoutNode();
        NodeCoordinator innerCoordinator$ui_release = layoutNode.getInnerCoordinator$ui_release();
        for (NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release(); outerCoordinator$ui_release != innerCoordinator$ui_release; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release()) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            zIndex += ((LayoutModifierNodeCoordinator) outerCoordinator$ui_release).getZIndex();
        }
        if (zIndex != this.zIndex) {
            this.zIndex = zIndex;
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated$ui_release();
            }
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
        }
        if (!isPlaced()) {
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
            markNodeAndSubtreeAsPlaced();
            if (this.relayoutWithoutParentInProgress && parent$ui_release != null) {
                LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
            }
        } else {
            getLayoutNode().getInnerCoordinator$ui_release().onPlaced();
        }
        if (parent$ui_release != null) {
            if (!this.relayoutWithoutParentInProgress && parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
                if (!(this.placeOrder == Integer.MAX_VALUE)) {
                    InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
                }
                this.placeOrder = parent$ui_release.getLayoutDelegate$ui_release().getNextChildPlaceOrder$ui_release();
                LayoutNodeLayoutDelegate layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release();
                layoutDelegate$ui_release.setNextChildPlaceOrder$ui_release(layoutDelegate$ui_release.getNextChildPlaceOrder$ui_release() + 1);
            }
        } else {
            this.placeOrder = 0;
        }
        layoutChildren();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPlaceOrder() {
        this.layoutNodeLayoutDelegate.setNextChildPlaceOrder$ui_release(0);
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            MeasurePassDelegate measurePassDelegate$ui_release = layoutNodeArr[i].getMeasurePassDelegate$ui_release();
            measurePassDelegate$ui_release.previousPlaceOrder = measurePassDelegate$ui_release.placeOrder;
            measurePassDelegate$ui_release.placeOrder = Integer.MAX_VALUE;
            measurePassDelegate$ui_release.isPlacedByParent = false;
            if (measurePassDelegate$ui_release.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                measurePassDelegate$ui_release.measuredByParent = LayoutNode.UsageByParent.NotUsed;
            }
        }
    }

    private final void forEachChildDelegate(Function1<? super MeasurePassDelegate, Unit> function1) {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            function1.invoke(layoutNodeArr[i].getMeasurePassDelegate$ui_release());
        }
    }

    /* renamed from: performMeasure-BRTryo0$ui_release  reason: not valid java name */
    public final void m5655performMeasureBRTryo0$ui_release(long j) {
        if (!(getLayoutState() == LayoutNode.LayoutState.Idle)) {
            InlineClassHelperKt.throwIllegalStateException("layout state is not idle before measure starts");
        }
        this.performMeasureConstraints = j;
        setLayoutState(LayoutNode.LayoutState.Measuring);
        this.measurePending = false;
        LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver().observeMeasureSnapshotReads$ui_release(getLayoutNode(), false, this.performMeasureBlock);
        if (getLayoutState() == LayoutNode.LayoutState.Measuring) {
            markLayoutPending();
            setLayoutState(LayoutNode.LayoutState.Idle);
        }
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* renamed from: measure-BRTryo0 */
    public Placeable mo5438measureBRTryo0(long j) {
        if (getLayoutNode().getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
            getLayoutNode().clearSubtreeIntrinsicsUsage$ui_release();
        }
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            lookaheadPassDelegate.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
            lookaheadPassDelegate.mo5438measureBRTryo0(j);
        }
        trackMeasurementByParent(getLayoutNode());
        m5656remeasureBRTryo0(j);
        return this;
    }

    /* renamed from: remeasure-BRTryo0  reason: not valid java name */
    public final boolean m5656remeasureBRTryo0(long j) {
        if (getLayoutNode().isDeactivated()) {
            InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
        }
        Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        boolean z = true;
        getLayoutNode().setCanMultiMeasure$ui_release(getLayoutNode().getCanMultiMeasure$ui_release() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure$ui_release()));
        if (getLayoutNode().getMeasurePending$ui_release() || !Constraints.m6630equalsimpl0(m5498getMeasurementConstraintsmsEJaDk(), j)) {
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$remeasure$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    invoke2(alignmentLinesOwner);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                    alignmentLinesOwner.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
                }
            });
            this.measuredOnce = true;
            long mo5446getSizeYbymL2g = getOuterCoordinator().mo5446getSizeYbymL2g();
            m5501setMeasurementConstraintsBRTryo0(j);
            m5655performMeasureBRTryo0$ui_release(j);
            if (IntSize.m6853equalsimpl0(getOuterCoordinator().mo5446getSizeYbymL2g(), mo5446getSizeYbymL2g) && getOuterCoordinator().getWidth() == getWidth() && getOuterCoordinator().getHeight() == getHeight()) {
                z = false;
            }
            m5500setMeasuredSizeozmzZPI(IntSize.m6850constructorimpl((getOuterCoordinator().getHeight() & 4294967295L) | (getOuterCoordinator().getWidth() << 32)));
            return z;
        }
        Owner.forceMeasureTheSubtree$default(requireOwner, getLayoutNode(), false, 2, null);
        getLayoutNode().resetSubtreeIntrinsicsUsage$ui_release();
        return false;
    }

    private final void trackMeasurementByParent(LayoutNode layoutNode) {
        LayoutNode.UsageByParent usageByParent;
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            if (!(this.measuredByParent == LayoutNode.UsageByParent.NotUsed || layoutNode.getCanMultiMeasure$ui_release())) {
                InlineClassHelperKt.throwIllegalStateException(LayoutNodeLayoutDelegateKt.MeasuredTwiceErrorMessage);
            }
            int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
            if (i == 1) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else if (i == 2) {
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            } else {
                throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui_release.getLayoutState$ui_release());
            }
            this.measuredByParent = usageByParent;
            return;
        }
        this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        return getOuterCoordinator().getMeasuredWidth();
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        return getOuterCoordinator().getMeasuredHeight();
    }

    @Override // androidx.compose.ui.layout.Measured
    public int get(AlignmentLine alignmentLine) {
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.Measuring) {
            getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
        } else {
            LayoutNode parent$ui_release2 = getLayoutNode().getParent$ui_release();
            if ((parent$ui_release2 != null ? parent$ui_release2.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LayingOut) {
                getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
            }
        }
        this.duringAlignmentLinesQuery = true;
        int i = getOuterCoordinator().get(alignmentLine);
        this.duringAlignmentLinesQuery = false;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5439placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        m5652placeSelfMLgxB_4(j, f, function1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5499placeAtf8xVGno(long j, float f, GraphicsLayer graphicsLayer) {
        m5652placeSelfMLgxB_4(j, f, null, graphicsLayer);
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public boolean isPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    public void setPlacedUnderMotionFrameOfReference(boolean z) {
        this.isPlacedUnderMotionFrameOfReference = z;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void updatePlacedUnderMotionFrameOfReference(boolean z) {
        if (z != getOuterCoordinator().isPlacedUnderMotionFrameOfReference()) {
            getOuterCoordinator().setPlacedUnderMotionFrameOfReference(z);
            this.needsCoordinatesUpdate = true;
        }
        setPlacedUnderMotionFrameOfReference(z);
    }

    /* renamed from: placeSelf-MLgxB_4  reason: not valid java name */
    private final void m5652placeSelfMLgxB_4(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1, GraphicsLayer graphicsLayer) {
        Placeable.PlacementScope placementScope;
        boolean z = true;
        this.isPlacedByParent = true;
        if (!IntOffset.m6811equalsimpl0(j, this.lastPosition) || this.needsCoordinatesUpdate) {
            if (this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringModifierPlacement() || this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringPlacement() || this.needsCoordinatesUpdate) {
                this.layoutPending = true;
                this.needsCoordinatesUpdate = false;
            }
            notifyChildrenUsingCoordinatesWhilePlacing();
        }
        LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        if (lookaheadPassDelegate != null && lookaheadPassDelegate.getNeedsToBePlacedInApproach()) {
            NodeCoordinator wrappedBy$ui_release = getOuterCoordinator().getWrappedBy$ui_release();
            if (wrappedBy$ui_release == null || (placementScope = wrappedBy$ui_release.getPlacementScope()) == null) {
                placementScope = LayoutNodeKt.requireOwner(getLayoutNode()).getPlacementScope();
            }
            Placeable.PlacementScope placementScope2 = placementScope;
            LookaheadPassDelegate lookaheadPassDelegate2 = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate2);
            LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.getLayoutDelegate$ui_release().setNextChildLookaheadPlaceOrder$ui_release(0);
            }
            lookaheadPassDelegate2.setPlaceOrder$ui_release(Integer.MAX_VALUE);
            Placeable.PlacementScope.place$default(placementScope2, lookaheadPassDelegate2, IntOffset.m6812getXimpl(j), IntOffset.m6813getYimpl(j), 0.0f, 4, null);
        }
        LookaheadPassDelegate lookaheadPassDelegate3 = getLookaheadPassDelegate();
        if (lookaheadPassDelegate3 == null || lookaheadPassDelegate3.getPlacedOnce$ui_release()) {
            z = false;
        }
        if (z) {
            InlineClassHelperKt.throwIllegalStateException("Error: Placement happened before lookahead.");
        }
        m5651placeOuterCoordinatorMLgxB_4(j, f, function1, graphicsLayer);
    }

    /* renamed from: placeOuterCoordinator-MLgxB_4  reason: not valid java name */
    private final void m5651placeOuterCoordinatorMLgxB_4(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1, GraphicsLayer graphicsLayer) {
        if (getLayoutNode().isDeactivated()) {
            InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
        }
        setLayoutState(LayoutNode.LayoutState.LayingOut);
        this.lastPosition = j;
        this.lastZIndex = f;
        this.lastLayerBlock = function1;
        this.lastExplicitLayer = graphicsLayer;
        this.placedOnce = true;
        this.onNodePlacedCalled = false;
        Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        requireOwner.getRectManager().m5935onLayoutPositionChanged70tqf50(getLayoutNode(), j, !this.placedOnce);
        if (!this.layoutPending && isPlaced()) {
            getOuterCoordinator().m5690placeSelfApparentToRealOffsetMLgxB_4(j, f, function1, graphicsLayer);
            onNodePlaced$ui_release();
        } else {
            getAlignmentLines().setUsedByModifierLayout$ui_release(false);
            this.layoutNodeLayoutDelegate.setCoordinatesAccessedDuringModifierPlacement(false);
            this.placeOuterCoordinatorLayerBlock = function1;
            this.placeOuterCoordinatorPosition = j;
            this.placeOuterCoordinatorZIndex = f;
            this.placeOuterCoordinatorLayer = graphicsLayer;
            requireOwner.getSnapshotObserver().observeLayoutModifierSnapshotReads$ui_release(getLayoutNode(), false, this.placeOuterCoordinatorBlock);
        }
        setLayoutState(LayoutNode.LayoutState.Idle);
    }

    public final void replace() {
        MeasurePassDelegate measurePassDelegate;
        LayoutNode parent$ui_release;
        try {
            this.relayoutWithoutParentInProgress = true;
            if (!this.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("replace called on unplaced item");
            }
            boolean isPlaced = isPlaced();
            measurePassDelegate = this;
            try {
                measurePassDelegate.m5651placeOuterCoordinatorMLgxB_4(this.lastPosition, this.lastZIndex, this.lastLayerBlock, this.lastExplicitLayer);
                if (isPlaced && !measurePassDelegate.onNodePlacedCalled && (parent$ui_release = getLayoutNode().getParent$ui_release()) != null) {
                    LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
                }
                measurePassDelegate.relayoutWithoutParentInProgress = false;
            } catch (Throwable th) {
                th = th;
                measurePassDelegate.relayoutWithoutParentInProgress = false;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            measurePassDelegate = this;
        }
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int i) {
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            return lookaheadPassDelegate.minIntrinsicWidth(i);
        }
        onIntrinsicsQueried();
        return getOuterCoordinator().minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int i) {
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            return lookaheadPassDelegate.maxIntrinsicWidth(i);
        }
        onIntrinsicsQueried();
        return getOuterCoordinator().maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int i) {
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            return lookaheadPassDelegate.minIntrinsicHeight(i);
        }
        onIntrinsicsQueried();
        return getOuterCoordinator().minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int i) {
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            return lookaheadPassDelegate.maxIntrinsicHeight(i);
        }
        onIntrinsicsQueried();
        return getOuterCoordinator().maxIntrinsicHeight(i);
    }

    private final void onIntrinsicsQueried() {
        LayoutNode.UsageByParent usageByParent;
        LayoutNode.requestRemeasure$ui_release$default(getLayoutNode(), false, false, false, 7, null);
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if (parent$ui_release == null || getLayoutNode().getIntrinsicsUsageByParent$ui_release() != LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        LayoutNode layoutNode = getLayoutNode();
        int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
        if (i == 1) {
            usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
        } else if (i == 2) {
            usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
        } else {
            usageByParent = parent$ui_release.getIntrinsicsUsageByParent$ui_release();
        }
        layoutNode.setIntrinsicsUsageByParent$ui_release(usageByParent);
    }

    public final void invalidateParentData() {
        this.parentDataDirty = true;
    }

    public final boolean updateParentData() {
        if (!(getParentData() == null && getOuterCoordinator().getParentData() == null) && this.parentDataDirty) {
            this.parentDataDirty = false;
            this.parentData = getOuterCoordinator().getParentData();
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public Map<AlignmentLine, Integer> calculateAlignmentLines() {
        if (!this.duringAlignmentLinesQuery) {
            if (getLayoutState() == LayoutNode.LayoutState.Measuring) {
                getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                if (getAlignmentLines().getDirty$ui_release()) {
                    markLayoutPending();
                }
            } else {
                getAlignmentLines().setUsedByModifierLayout$ui_release(true);
            }
        }
        getInnerCoordinator().setPlacingForAlignment$ui_release(true);
        layoutChildren();
        getInnerCoordinator().setPlacingForAlignment$ui_release(false);
        return getAlignmentLines().getLastCalculation();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLinesOwner getParentAlignmentLinesOwner() {
        LayoutNodeLayoutDelegate layoutDelegate$ui_release;
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if (parent$ui_release == null || (layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release()) == null) {
            return null;
        }
        return layoutDelegate$ui_release.getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> function1) {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            function1.invoke(layoutNodeArr[i].getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release());
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void requestLayout() {
        LayoutNode.requestRelayout$ui_release$default(getLayoutNode(), false, 1, null);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void requestMeasure() {
        LayoutNode.requestRemeasure$ui_release$default(getLayoutNode(), false, false, false, 7, null);
    }

    public final void notifyChildrenUsingCoordinatesWhilePlacing() {
        if (this.layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                LayoutNode layoutNode = layoutNodeArr[i];
                LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
                if ((layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement() || layoutDelegate$ui_release.getCoordinatesAccessedDuringModifierPlacement()) && !layoutDelegate$ui_release.getLayoutPending$ui_release()) {
                    LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                }
                layoutDelegate$ui_release.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            }
        }
    }

    private final void onBeforeLayoutChildren() {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = layoutNodeArr[i];
            if (layoutNode.getMeasurePending$ui_release() && layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.m5611remeasure_Sx5XlM$ui_release$default(layoutNode, null, 1, null)) {
                LayoutNode.requestRemeasure$ui_release$default(getLayoutNode(), false, false, false, 7, null);
            }
        }
    }

    public final void invalidateIntrinsicsParent(boolean z) {
        LayoutNode layoutNode;
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        LayoutNode.UsageByParent intrinsicsUsageByParent$ui_release = getLayoutNode().getIntrinsicsUsageByParent$ui_release();
        if (parent$ui_release == null || intrinsicsUsageByParent$ui_release == LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        do {
            layoutNode = parent$ui_release;
            if (layoutNode.getIntrinsicsUsageByParent$ui_release() != intrinsicsUsageByParent$ui_release) {
                break;
            }
            parent$ui_release = layoutNode.getParent$ui_release();
        } while (parent$ui_release != null);
        int i = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent$ui_release.ordinal()];
        if (i == 1) {
            LayoutNode.requestRemeasure$ui_release$default(layoutNode, z, false, false, 6, null);
        } else if (i == 2) {
            layoutNode.requestRelayout$ui_release(z);
        } else {
            throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
        }
    }

    public final void onNodeDetached() {
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        setPlaced$ui_release(false);
    }

    public final void markLayoutPending() {
        this.layoutPending = true;
        this.layoutPendingForAlignment = true;
    }

    public final void markMeasurePending$ui_release() {
        this.measurePending = true;
    }
}
