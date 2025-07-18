package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EnterExitTransition.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\b\u0010J\u001a\u00020KH\u0016J \u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ \u0010Q\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bR\u0010PJ \u0010S\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bT\u0010PJ&\u0010U\u001a\u00020V*\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020.H\u0016ø\u0001\u0000¢\u0006\u0004\b[\u0010\\R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010*\"\u0004\b+\u0010,R&\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020.@BX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\"\u0004\b0\u00101R\u000e\u00103\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\u00020\u0007X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00102R2\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R2\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00106\"\u0004\b:\u00108R.\u0010;\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040=\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070>0<¢\u0006\u0002\b?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR2\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00106\"\u0004\bC\u00108R.\u0010D\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040=\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0>0<¢\u0006\u0002\b?¢\u0006\b\n\u0000\u001a\u0004\bE\u0010AR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006]"}, d2 = {"Landroidx/compose/animation/EnterExitTransitionModifierNode;", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "slideAnimation", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "isEnabled", "Lkotlin/Function0;", "", "graphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "alignment", "Landroidx/compose/ui/Alignment;", "getAlignment", "()Landroidx/compose/ui/Alignment;", "currentAlignment", "getCurrentAlignment", "setCurrentAlignment", "(Landroidx/compose/ui/Alignment;)V", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "getGraphicsLayerBlock", "()Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "setGraphicsLayerBlock", "(Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "value", "Landroidx/compose/ui/unit/Constraints;", "lookaheadConstraints", "setLookaheadConstraints-BRTryo0", "(J)V", "J", "lookaheadConstraintsAvailable", "lookaheadSize", "getOffsetAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setOffsetAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getSizeAnimation", "setSizeAnimation", "sizeTransitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getSizeTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "getSlideAnimation", "setSlideAnimation", "slideSpec", "getSlideSpec", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "(Landroidx/compose/animation/core/Transition;)V", "onAttach", "", "sizeByState", "targetState", "fullSize", "sizeByState-Uzc_VyU", "(Landroidx/compose/animation/EnterExitState;J)J", "slideTargetValueByState", "slideTargetValueByState-oFUgxo0", "targetOffsetByState", "targetOffsetByState-oFUgxo0", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class EnterExitTransitionModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
    private Alignment currentAlignment;
    private EnterTransition enter;
    private ExitTransition exit;
    private GraphicsLayerBlockForEnterExit graphicsLayerBlock;
    private Function0<Boolean> isEnabled;
    private boolean lookaheadConstraintsAvailable;
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;
    private Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> slideAnimation;
    private Transition<EnterExitState> transition;
    private long lookaheadSize = AnimationModifierKt.getInvalidSize();
    private long lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> sizeTransitionSpec = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$sizeTransitionSpec$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final FiniteAnimationSpec<IntSize> invoke(Transition.Segment<EnterExitState> segment) {
            SpringSpec springSpec;
            SpringSpec springSpec2;
            SpringSpec springSpec3 = null;
            if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                ChangeSize changeSize = EnterExitTransitionModifierNode.this.getEnter().getData$animation_release().getChangeSize();
                if (changeSize != null) {
                    springSpec3 = changeSize.getAnimationSpec();
                }
            } else if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                springSpec = EnterExitTransitionKt.DefaultSizeAnimationSpec;
                springSpec3 = springSpec;
            } else {
                ChangeSize changeSize2 = EnterExitTransitionModifierNode.this.getExit().getData$animation_release().getChangeSize();
                if (changeSize2 != null) {
                    springSpec3 = changeSize2.getAnimationSpec();
                }
            }
            if (springSpec3 == null) {
                springSpec2 = EnterExitTransitionKt.DefaultSizeAnimationSpec;
                return springSpec2;
            }
            return springSpec3;
        }
    };
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> slideSpec = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$slideSpec$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final FiniteAnimationSpec<IntOffset> invoke(Transition.Segment<EnterExitState> segment) {
            SpringSpec springSpec;
            SpringSpec springSpec2;
            FiniteAnimationSpec<IntOffset> animationSpec;
            SpringSpec springSpec3;
            FiniteAnimationSpec<IntOffset> animationSpec2;
            if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                Slide slide = EnterExitTransitionModifierNode.this.getEnter().getData$animation_release().getSlide();
                if (slide == null || (animationSpec2 = slide.getAnimationSpec()) == null) {
                    springSpec3 = EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                    return springSpec3;
                }
                return animationSpec2;
            } else if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                springSpec = EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                return springSpec;
            } else {
                Slide slide2 = EnterExitTransitionModifierNode.this.getExit().getData$animation_release().getSlide();
                if (slide2 == null || (animationSpec = slide2.getAnimationSpec()) == null) {
                    springSpec2 = EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                    return springSpec2;
                }
                return animationSpec;
            }
        }
    };

    /* compiled from: EnterExitTransition.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Transition<EnterExitState> getTransition() {
        return this.transition;
    }

    public final void setTransition(Transition<EnterExitState> transition) {
        this.transition = transition;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    public final void setSizeAnimation(Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation) {
        this.sizeAnimation = deferredAnimation;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    public final void setOffsetAnimation(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation) {
        this.offsetAnimation = deferredAnimation;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getSlideAnimation() {
        return this.slideAnimation;
    }

    public final void setSlideAnimation(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation) {
        this.slideAnimation = deferredAnimation;
    }

    public final EnterTransition getEnter() {
        return this.enter;
    }

    public final void setEnter(EnterTransition enterTransition) {
        this.enter = enterTransition;
    }

    public final ExitTransition getExit() {
        return this.exit;
    }

    public final void setExit(ExitTransition exitTransition) {
        this.exit = exitTransition;
    }

    public final Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(Function0<Boolean> function0) {
        this.isEnabled = function0;
    }

    public final GraphicsLayerBlockForEnterExit getGraphicsLayerBlock() {
        return this.graphicsLayerBlock;
    }

    public final void setGraphicsLayerBlock(GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.graphicsLayerBlock = graphicsLayerBlockForEnterExit;
    }

    public EnterExitTransitionModifierNode(Transition<EnterExitState> transition, Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3, EnterTransition enterTransition, ExitTransition exitTransition, Function0<Boolean> function0, GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.transition = transition;
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.slideAnimation = deferredAnimation3;
        this.enter = enterTransition;
        this.exit = exitTransition;
        this.isEnabled = function0;
        this.graphicsLayerBlock = graphicsLayerBlockForEnterExit;
    }

    /* renamed from: setLookaheadConstraints-BRTryo0  reason: not valid java name */
    private final void m103setLookaheadConstraintsBRTryo0(long j) {
        this.lookaheadConstraintsAvailable = true;
        this.lookaheadConstraints = j;
    }

    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    public final void setCurrentAlignment(Alignment alignment) {
        this.currentAlignment = alignment;
    }

    public final Alignment getAlignment() {
        Alignment alignment;
        Alignment alignment2;
        if (this.transition.getSegment().isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
            ChangeSize changeSize = this.enter.getData$animation_release().getChangeSize();
            if (changeSize == null || (alignment2 = changeSize.getAlignment()) == null) {
                ChangeSize changeSize2 = this.exit.getData$animation_release().getChangeSize();
                if (changeSize2 != null) {
                    return changeSize2.getAlignment();
                }
                return null;
            }
            return alignment2;
        }
        ChangeSize changeSize3 = this.exit.getData$animation_release().getChangeSize();
        if (changeSize3 == null || (alignment = changeSize3.getAlignment()) == null) {
            ChangeSize changeSize4 = this.enter.getData$animation_release().getChangeSize();
            if (changeSize4 != null) {
                return changeSize4.getAlignment();
            }
            return null;
        }
        return alignment;
    }

    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    /* renamed from: sizeByState-Uzc_VyU  reason: not valid java name */
    public final long m104sizeByStateUzc_VyU(EnterExitState enterExitState, long j) {
        Function1<IntSize, IntSize> size;
        Function1<IntSize, IntSize> size2;
        int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i != 1) {
            if (i == 2) {
                ChangeSize changeSize = this.enter.getData$animation_release().getChangeSize();
                if (changeSize != null && (size = changeSize.getSize()) != null) {
                    return size.invoke(IntSize.m6847boximpl(j)).m6859unboximpl();
                }
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                ChangeSize changeSize2 = this.exit.getData$animation_release().getChangeSize();
                if (changeSize2 != null && (size2 = changeSize2.getSize()) != null) {
                    return size2.invoke(IntSize.m6847boximpl(j)).m6859unboximpl();
                }
            }
        }
        return j;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        this.lookaheadConstraintsAvailable = false;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
    }

    /* renamed from: targetOffsetByState-oFUgxo0  reason: not valid java name */
    public final long m106targetOffsetByStateoFUgxo0(EnterExitState enterExitState, long j) {
        if (this.currentAlignment != null && getAlignment() != null && !Intrinsics.areEqual(this.currentAlignment, getAlignment())) {
            int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        ChangeSize changeSize = this.exit.getData$animation_release().getChangeSize();
                        if (changeSize != null) {
                            long m6859unboximpl = changeSize.getSize().invoke(IntSize.m6847boximpl(j)).m6859unboximpl();
                            Alignment alignment = getAlignment();
                            Intrinsics.checkNotNull(alignment);
                            long mo3654alignKFBX0sM = alignment.mo3654alignKFBX0sM(j, m6859unboximpl, LayoutDirection.Ltr);
                            Alignment alignment2 = this.currentAlignment;
                            Intrinsics.checkNotNull(alignment2);
                            return IntOffset.m6815minusqkQi6aY(mo3654alignKFBX0sM, alignment2.mo3654alignKFBX0sM(j, m6859unboximpl, LayoutDirection.Ltr));
                        }
                        return IntOffset.Companion.m6823getZeronOccac();
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return IntOffset.Companion.m6823getZeronOccac();
            }
            return IntOffset.Companion.m6823getZeronOccac();
        }
        return IntOffset.Companion.m6823getZeronOccac();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo70measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        State<IntOffset> animate;
        State<IntOffset> animate2;
        if (this.transition.getCurrentState() == this.transition.getTargetState()) {
            this.currentAlignment = null;
        } else if (this.currentAlignment == null) {
            Alignment alignment = getAlignment();
            if (alignment == null) {
                alignment = Alignment.Companion.getTopStart();
            }
            this.currentAlignment = alignment;
        }
        if (measureScope.isLookingAhead()) {
            final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(j);
            long m6850constructorimpl = IntSize.m6850constructorimpl((mo5438measureBRTryo0.getWidth() << 32) | (mo5438measureBRTryo0.getHeight() & 4294967295L));
            this.lookaheadSize = m6850constructorimpl;
            m103setLookaheadConstraintsBRTryo0(j);
            return MeasureScope.layout$default(measureScope, (int) (m6850constructorimpl >> 32), (int) (m6850constructorimpl & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        } else if (this.isEnabled.invoke().booleanValue()) {
            final Function1<GraphicsLayerScope, Unit> init = this.graphicsLayerBlock.init();
            final Placeable mo5438measureBRTryo02 = measurable.mo5438measureBRTryo0(j);
            long m6850constructorimpl2 = IntSize.m6850constructorimpl((mo5438measureBRTryo02.getWidth() << 32) | (mo5438measureBRTryo02.getHeight() & 4294967295L));
            final long j2 = AnimationModifierKt.m74isValidozmzZPI(this.lookaheadSize) ? this.lookaheadSize : m6850constructorimpl2;
            Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation = this.sizeAnimation;
            State<IntSize> animate3 = deferredAnimation != null ? deferredAnimation.animate(this.sizeTransitionSpec, new Function1<EnterExitState, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$animSize$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(EnterExitState enterExitState) {
                    return IntSize.m6847boximpl(m107invokeYEO4UFw(enterExitState));
                }

                /* renamed from: invoke-YEO4UFw  reason: not valid java name */
                public final long m107invokeYEO4UFw(EnterExitState enterExitState) {
                    return EnterExitTransitionModifierNode.this.m104sizeByStateUzc_VyU(enterExitState, j2);
                }
            }) : null;
            if (animate3 != null) {
                m6850constructorimpl2 = animate3.getValue().m6859unboximpl();
            }
            long m6651constrain4WqzIAM = ConstraintsKt.m6651constrain4WqzIAM(j, m6850constructorimpl2);
            Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2 = this.offsetAnimation;
            long m6823getZeronOccac = (deferredAnimation2 == null || (animate2 = deferredAnimation2.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$offsetDelta$1
                @Override // kotlin.jvm.functions.Function1
                public final FiniteAnimationSpec<IntOffset> invoke(Transition.Segment<EnterExitState> segment) {
                    SpringSpec springSpec;
                    springSpec = EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                    return springSpec;
                }
            }, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$offsetDelta$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntOffset invoke(EnterExitState enterExitState) {
                    return IntOffset.m6803boximpl(m108invokeBjo55l4(enterExitState));
                }

                /* renamed from: invoke-Bjo55l4  reason: not valid java name */
                public final long m108invokeBjo55l4(EnterExitState enterExitState) {
                    return EnterExitTransitionModifierNode.this.m106targetOffsetByStateoFUgxo0(enterExitState, j2);
                }
            })) == null) ? IntOffset.Companion.m6823getZeronOccac() : animate2.getValue().m6821unboximpl();
            Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3 = this.slideAnimation;
            long m6823getZeronOccac2 = (deferredAnimation3 == null || (animate = deferredAnimation3.animate(this.slideSpec, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$slideOffset$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntOffset invoke(EnterExitState enterExitState) {
                    return IntOffset.m6803boximpl(m109invokeBjo55l4(enterExitState));
                }

                /* renamed from: invoke-Bjo55l4  reason: not valid java name */
                public final long m109invokeBjo55l4(EnterExitState enterExitState) {
                    return EnterExitTransitionModifierNode.this.m105slideTargetValueByStateoFUgxo0(enterExitState, j2);
                }
            })) == null) ? IntOffset.Companion.m6823getZeronOccac() : animate.getValue().m6821unboximpl();
            Alignment alignment2 = this.currentAlignment;
            final long m6816plusqkQi6aY = IntOffset.m6816plusqkQi6aY(alignment2 != null ? alignment2.mo3654alignKFBX0sM(j2, m6651constrain4WqzIAM, LayoutDirection.Ltr) : IntOffset.Companion.m6823getZeronOccac(), m6823getZeronOccac2);
            final long j3 = m6823getZeronOccac;
            return MeasureScope.layout$default(measureScope, (int) (m6651constrain4WqzIAM >> 32), (int) (m6651constrain4WqzIAM & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    placementScope.placeWithLayer(Placeable.this, IntOffset.m6812getXimpl(j3) + IntOffset.m6812getXimpl(m6816plusqkQi6aY), IntOffset.m6813getYimpl(j3) + IntOffset.m6813getYimpl(m6816plusqkQi6aY), 0.0f, init);
                }
            }, 4, null);
        } else {
            final Placeable mo5438measureBRTryo03 = measurable.mo5438measureBRTryo0(j);
            return MeasureScope.layout$default(measureScope, mo5438measureBRTryo03.getWidth(), mo5438measureBRTryo03.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }
    }

    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> getSlideSpec() {
        return this.slideSpec;
    }

    /* renamed from: slideTargetValueByState-oFUgxo0  reason: not valid java name */
    public final long m105slideTargetValueByStateoFUgxo0(EnterExitState enterExitState, long j) {
        Function1<IntSize, IntOffset> slideOffset;
        Function1<IntSize, IntOffset> slideOffset2;
        Slide slide = this.enter.getData$animation_release().getSlide();
        long m6823getZeronOccac = (slide == null || (slideOffset2 = slide.getSlideOffset()) == null) ? IntOffset.Companion.m6823getZeronOccac() : slideOffset2.invoke(IntSize.m6847boximpl(j)).m6821unboximpl();
        Slide slide2 = this.exit.getData$animation_release().getSlide();
        long m6823getZeronOccac2 = (slide2 == null || (slideOffset = slide2.getSlideOffset()) == null) ? IntOffset.Companion.m6823getZeronOccac() : slideOffset.invoke(IntSize.m6847boximpl(j)).m6821unboximpl();
        int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return m6823getZeronOccac2;
                }
                throw new NoWhenBranchMatchedException();
            }
            return m6823getZeronOccac;
        }
        return IntOffset.Companion.m6823getZeronOccac();
    }
}
