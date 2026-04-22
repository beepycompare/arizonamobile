package androidx.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasicMarquee.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B7\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J=\u0010=\u001a\u00020;2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020;2\u0006\u0010A\u001a\u00020BH\u0016J#\u0010C\u001a\u00020D*\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0016¢\u0006\u0004\bJ\u0010KJ\u001c\u0010L\u001a\u00020\u0006*\u00020M2\u0006\u0010F\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0006H\u0016J\u001c\u0010P\u001a\u00020\u0006*\u00020M2\u0006\u0010F\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0006H\u0016J\u001c\u0010Q\u001a\u00020\u0006*\u00020M2\u0006\u0010F\u001a\u00020N2\u0006\u0010R\u001a\u00020\u0006H\u0016J\u001c\u0010S\u001a\u00020\u0006*\u00020M2\u0006\u0010F\u001a\u00020N2\u0006\u0010R\u001a\u00020\u0006H\u0016J\f\u0010T\u001a\u00020;*\u00020UH\u0016J\b\u0010V\u001a\u00020;H\u0002J\u000e\u0010W\u001a\u00020;H\u0082@¢\u0006\u0002\u0010XR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R+\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u001e8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010%\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R+\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010%\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00106\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b7\u0010\u0015¨\u0006Y"}, d2 = {"Landroidx/compose/foundation/MarqueeModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "delayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "<init>", "(IIIILandroidx/compose/foundation/MarqueeSpacing;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "<set-?>", "contentWidth", "getContentWidth", "()I", "setContentWidth", "(I)V", "contentWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "containerWidth", "getContainerWidth", "setContainerWidth", "containerWidth$delegate", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "Landroidx/compose/runtime/MutableState;", "animationJob", "Lkotlinx/coroutines/Job;", "marqueeLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "setSpacing", "(Landroidx/compose/foundation/MarqueeSpacing;)V", "spacing$delegate", "getAnimationMode-ZbEOnfQ", "setAnimationMode-97h66l8", "animationMode$delegate", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "spacingPx", "getSpacingPx", "spacingPx$delegate", "Landroidx/compose/runtime/State;", "onAttach", "", "onDetach", "update", "update-lWfNwf4", "(IIIILandroidx/compose/foundation/MarqueeSpacing;F)V", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "restartAnimation", "runAnimation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MarqueeModifierNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, FocusEventModifierNode {
    private Job animationJob;
    private final MutableState animationMode$delegate;
    private final MutableIntState containerWidth$delegate;
    private final MutableIntState contentWidth$delegate;
    private int delayMillis;
    private final MutableState hasFocus$delegate;
    private int initialDelayMillis;
    private int iterations;
    private GraphicsLayer marqueeLayer;
    private final Animatable<Float, AnimationVector1D> offset;
    private final MutableState spacing$delegate;
    private final State spacingPx$delegate;
    private float velocity;

    /* compiled from: BasicMarquee.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ MarqueeModifierNode(int i, int i2, int i3, int i4, MarqueeSpacing marqueeSpacing, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, marqueeSpacing, f);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return 0;
    }

    private MarqueeModifierNode(int i, int i2, int i3, int i4, final MarqueeSpacing marqueeSpacing, float f) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        this.iterations = i;
        this.delayMillis = i3;
        this.initialDelayMillis = i4;
        this.velocity = f;
        this.contentWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.containerWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.hasFocus$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(marqueeSpacing, null, 2, null);
        this.spacing$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MarqueeAnimationMode.m334boximpl(i2), null, 2, null);
        this.animationMode$delegate = mutableStateOf$default3;
        this.offset = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.spacingPx$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.MarqueeModifierNode$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int calculateSpacing;
                calculateSpacing = MarqueeSpacing.this.calculateSpacing(DelegatableNodeKt.requireDensity(r1), r1.getContentWidth(), this.getContainerWidth());
                return Integer.valueOf(calculateSpacing);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getContentWidth() {
        return this.contentWidth$delegate.getIntValue();
    }

    private final void setContentWidth(int i) {
        this.contentWidth$delegate.setIntValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getContainerWidth() {
        return this.containerWidth$delegate.getIntValue();
    }

    private final void setContainerWidth(int i) {
        this.containerWidth$delegate.setIntValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    private final void setHasFocus(boolean z) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z));
    }

    public final MarqueeSpacing getSpacing() {
        return (MarqueeSpacing) this.spacing$delegate.getValue();
    }

    public final void setSpacing(MarqueeSpacing marqueeSpacing) {
        this.spacing$delegate.setValue(marqueeSpacing);
    }

    /* renamed from: getAnimationMode-ZbEOnfQ  reason: not valid java name */
    public final int m348getAnimationModeZbEOnfQ() {
        return ((MarqueeAnimationMode) this.animationMode$delegate.getValue()).m340unboximpl();
    }

    /* renamed from: setAnimationMode-97h66l8  reason: not valid java name */
    public final void m349setAnimationMode97h66l8(int i) {
        this.animationMode$delegate.setValue(MarqueeAnimationMode.m334boximpl(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSpacingPx() {
        return ((Number) this.spacingPx$delegate.getValue()).intValue();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        GraphicsLayer graphicsLayer = this.marqueeLayer;
        GraphicsContext requireGraphicsContext = DelegatableNodeKt.requireGraphicsContext(this);
        if (graphicsLayer != null) {
            requireGraphicsContext.releaseGraphicsLayer(graphicsLayer);
        }
        this.marqueeLayer = requireGraphicsContext.createGraphicsLayer();
        restartAnimation();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.animationJob = null;
        GraphicsLayer graphicsLayer = this.marqueeLayer;
        if (graphicsLayer != null) {
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer);
            this.marqueeLayer = null;
        }
    }

    /* renamed from: update-lWfNwf4  reason: not valid java name */
    public final void m350updatelWfNwf4(int i, int i2, int i3, int i4, MarqueeSpacing marqueeSpacing, float f) {
        setSpacing(marqueeSpacing);
        m349setAnimationMode97h66l8(i2);
        if (this.iterations == i && this.delayMillis == i3 && this.initialDelayMillis == i4 && Dp.m7560equalsimpl0(this.velocity, f)) {
            return;
        }
        this.iterations = i;
        this.delayMillis = i3;
        this.initialDelayMillis = i4;
        this.velocity = f;
        restartAnimation();
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void onFocusEvent(FocusState focusState) {
        setHasFocus(focusState.getHasFocus());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo69measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo6216measureBRTryo0 = measurable.mo6216measureBRTryo0(Constraints.m7498copyZbe2FdA$default(j, 0, Integer.MAX_VALUE, 0, 0, 13, null));
        setContainerWidth(ConstraintsKt.m7525constrainWidthK40F9xA(j, mo6216measureBRTryo0.getWidth()));
        setContentWidth(mo6216measureBRTryo0.getWidth());
        return MeasureScope.layout$default(measureScope, getContainerWidth(), mo6216measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.MarqueeModifierNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MarqueeModifierNode.measure_3p2s80s$lambda$0(Placeable.this, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, 0, 0.0f, (Function1) null, 12, (Object) null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x016b  */
    @Override // androidx.compose.ui.node.DrawModifierNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(final ContentDrawScope contentDrawScope) {
        float contentWidth;
        float floatValue;
        int containerWidth;
        GraphicsLayer graphicsLayer;
        ContentDrawScope contentDrawScope2;
        DrawContext drawContext;
        GraphicsLayer graphicsLayer2;
        if (Dp.m7554compareTo0680j_4(this.velocity, Dp.m7555constructorimpl(0.0f)) <= 0) {
            int i = WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()];
            if (i == 1) {
                contentWidth = (-this.offset.getValue().floatValue()) + getContentWidth() + getSpacingPx();
                if (contentWidth >= ((float) getContentWidth())) {
                }
                if (((float) getContainerWidth()) + contentWidth > ((float) (getContentWidth() + getSpacingPx()))) {
                }
                float contentWidth2 = getContentWidth() + getSpacingPx();
                float intBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope.mo5346getSizeNHjbRc() & 4294967295L));
                graphicsLayer = this.marqueeLayer;
                if (graphicsLayer != null) {
                }
                contentDrawScope2 = contentDrawScope;
                float containerWidth2 = getContainerWidth();
                float intBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope2.mo5346getSizeNHjbRc() & 4294967295L));
                int m4761getIntersectrtfAjoo = ClipOp.Companion.m4761getIntersectrtfAjoo();
                drawContext = contentDrawScope2.getDrawContext();
                long mo5267getSizeNHjbRc = drawContext.mo5267getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().mo5270clipRectN_I0leg(0.0f, 0.0f, containerWidth2, intBitsToFloat2, m4761getIntersectrtfAjoo);
                float f = -contentWidth;
                contentDrawScope2.getDrawContext().getTransform().translate(f, 0.0f);
                graphicsLayer2 = this.marqueeLayer;
                if (graphicsLayer2 == null) {
                }
                contentDrawScope2.getDrawContext().getTransform().translate(-f, -0.0f);
            } else if (i != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                floatValue = this.offset.getValue().floatValue() + getContentWidth();
                containerWidth = getContainerWidth();
                contentWidth = floatValue - containerWidth;
                if (contentWidth >= ((float) getContentWidth())) {
                }
                if (((float) getContainerWidth()) + contentWidth > ((float) (getContentWidth() + getSpacingPx()))) {
                }
                float contentWidth22 = getContentWidth() + getSpacingPx();
                float intBitsToFloat3 = Float.intBitsToFloat((int) (contentDrawScope.mo5346getSizeNHjbRc() & 4294967295L));
                graphicsLayer = this.marqueeLayer;
                if (graphicsLayer != null) {
                }
                contentDrawScope2 = contentDrawScope;
                float containerWidth22 = getContainerWidth();
                float intBitsToFloat22 = Float.intBitsToFloat((int) (contentDrawScope2.mo5346getSizeNHjbRc() & 4294967295L));
                int m4761getIntersectrtfAjoo2 = ClipOp.Companion.m4761getIntersectrtfAjoo();
                drawContext = contentDrawScope2.getDrawContext();
                long mo5267getSizeNHjbRc2 = drawContext.mo5267getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().mo5270clipRectN_I0leg(0.0f, 0.0f, containerWidth22, intBitsToFloat22, m4761getIntersectrtfAjoo2);
                float f2 = -contentWidth;
                contentDrawScope2.getDrawContext().getTransform().translate(f2, 0.0f);
                graphicsLayer2 = this.marqueeLayer;
                if (graphicsLayer2 == null) {
                }
                contentDrawScope2.getDrawContext().getTransform().translate(-f2, -0.0f);
            }
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()];
        if (i2 == 1) {
            contentWidth = this.offset.getValue().floatValue();
            if (contentWidth >= ((float) getContentWidth())) {
            }
            if (((float) getContainerWidth()) + contentWidth > ((float) (getContentWidth() + getSpacingPx()))) {
            }
            float contentWidth222 = getContentWidth() + getSpacingPx();
            float intBitsToFloat32 = Float.intBitsToFloat((int) (contentDrawScope.mo5346getSizeNHjbRc() & 4294967295L));
            graphicsLayer = this.marqueeLayer;
            if (graphicsLayer != null) {
            }
            contentDrawScope2 = contentDrawScope;
            float containerWidth222 = getContainerWidth();
            float intBitsToFloat222 = Float.intBitsToFloat((int) (contentDrawScope2.mo5346getSizeNHjbRc() & 4294967295L));
            int m4761getIntersectrtfAjoo22 = ClipOp.Companion.m4761getIntersectrtfAjoo();
            drawContext = contentDrawScope2.getDrawContext();
            long mo5267getSizeNHjbRc22 = drawContext.mo5267getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().mo5270clipRectN_I0leg(0.0f, 0.0f, containerWidth222, intBitsToFloat222, m4761getIntersectrtfAjoo22);
            float f22 = -contentWidth;
            contentDrawScope2.getDrawContext().getTransform().translate(f22, 0.0f);
            graphicsLayer2 = this.marqueeLayer;
            if (graphicsLayer2 == null) {
            }
            contentDrawScope2.getDrawContext().getTransform().translate(-f22, -0.0f);
        } else if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            floatValue = (-this.offset.getValue().floatValue()) + (getContentWidth() * 2) + getSpacingPx();
            containerWidth = getContainerWidth();
            contentWidth = floatValue - containerWidth;
            boolean z = contentWidth >= ((float) getContentWidth());
            boolean z2 = ((float) getContainerWidth()) + contentWidth > ((float) (getContentWidth() + getSpacingPx()));
            float contentWidth2222 = getContentWidth() + getSpacingPx();
            float intBitsToFloat322 = Float.intBitsToFloat((int) (contentDrawScope.mo5346getSizeNHjbRc() & 4294967295L));
            graphicsLayer = this.marqueeLayer;
            if (graphicsLayer != null) {
                contentDrawScope.mo5347recordJVtK1S4(graphicsLayer, IntSize.m7721constructorimpl((getContentWidth() << 32) | (MathKt.roundToInt(intBitsToFloat322) & 4294967295L)), new Function1() { // from class: androidx.compose.foundation.MarqueeModifierNode$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit draw$lambda$0$0;
                        draw$lambda$0$0 = MarqueeModifierNode.draw$lambda$0$0(ContentDrawScope.this, (DrawScope) obj);
                        return draw$lambda$0$0;
                    }
                });
            }
            contentDrawScope2 = contentDrawScope;
            float containerWidth2222 = getContainerWidth();
            float intBitsToFloat2222 = Float.intBitsToFloat((int) (contentDrawScope2.mo5346getSizeNHjbRc() & 4294967295L));
            int m4761getIntersectrtfAjoo222 = ClipOp.Companion.m4761getIntersectrtfAjoo();
            drawContext = contentDrawScope2.getDrawContext();
            long mo5267getSizeNHjbRc222 = drawContext.mo5267getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo5270clipRectN_I0leg(0.0f, 0.0f, containerWidth2222, intBitsToFloat2222, m4761getIntersectrtfAjoo222);
                float f222 = -contentWidth;
                contentDrawScope2.getDrawContext().getTransform().translate(f222, 0.0f);
                graphicsLayer2 = this.marqueeLayer;
                if (graphicsLayer2 == null) {
                    if (z) {
                        GraphicsLayerKt.drawLayer(contentDrawScope2, graphicsLayer2);
                    }
                    if (z2) {
                        contentDrawScope2.getDrawContext().getTransform().translate(contentWidth2222, 0.0f);
                        try {
                            GraphicsLayerKt.drawLayer(contentDrawScope2, graphicsLayer2);
                            contentDrawScope2.getDrawContext().getTransform().translate(-contentWidth2222, -0.0f);
                        } finally {
                        }
                    }
                } else {
                    if (z) {
                        contentDrawScope.drawContent();
                    }
                    if (z2) {
                        contentDrawScope2.getDrawContext().getTransform().translate(contentWidth2222, 0.0f);
                        try {
                            contentDrawScope.drawContent();
                            contentDrawScope2.getDrawContext().getTransform().translate(-contentWidth2222, -0.0f);
                        } finally {
                        }
                    }
                }
                contentDrawScope2.getDrawContext().getTransform().translate(-f222, -0.0f);
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo5268setSizeuvyYCjk(mo5267getSizeNHjbRc222);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit draw$lambda$0$0(ContentDrawScope contentDrawScope, DrawScope drawScope) {
        contentDrawScope.drawContent();
        return Unit.INSTANCE;
    }

    private final void restartAnimation() {
        Job launch$default;
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (isAttached()) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new MarqueeModifierNode$restartAnimation$1(job, this, null), 3, null);
            this.animationJob = launch$default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runAnimation(Continuation<? super Unit> continuation) {
        if (this.iterations <= 0) {
            return Unit.INSTANCE;
        }
        Object withContext = BuildersKt.withContext(FixedMotionDurationScale.INSTANCE, new MarqueeModifierNode$runAnimation$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
