package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SearchBar.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u0000 02\u00020\u0001:\u00010BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010%\u001a\u00020&*\u00020&H\u0016J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u00061"}, d2 = {"Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior;", "Landroidx/compose/material3/SearchBarScrollBehavior;", "initialOffset", "", "initialOffsetLimit", "canScroll", "Lkotlin/Function0;", "", "reverseLayout", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "<init>", "(FFLkotlin/jvm/functions/Function0;ZLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;)V", "getCanScroll", "()Lkotlin/jvm/functions/Function0;", "getReverseLayout", "()Z", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getFlingAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "_offset", "Landroidx/compose/runtime/MutableFloatState;", "newOffset", "scrollOffset", "getScrollOffset", "()F", "setScrollOffset", "(F)V", "<set-?>", "scrollOffsetLimit", "getScrollOffsetLimit", "setScrollOffsetLimit", "scrollOffsetLimit$delegate", "Landroidx/compose/runtime/MutableFloatState;", "searchBarScrollBehavior", "Landroidx/compose/ui/Modifier;", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "settleSearchBar", "Landroidx/compose/ui/unit/Velocity;", "velocity", "settleSearchBar-OhffZ5M", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EnterAlwaysSearchBarScrollBehavior implements SearchBarScrollBehavior {
    public static final Companion Companion = new Companion(null);
    private MutableFloatState _offset;
    private final Function0<Boolean> canScroll;
    private final DecayAnimationSpec<Float> flingAnimationSpec;
    private final NestedScrollConnection nestedScrollConnection = new NestedScrollConnection() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$nestedScrollConnection$1
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPreScroll-OzD1aCk */
        public long mo896onPreScrollOzD1aCk(long j, int i) {
            if (EnterAlwaysSearchBarScrollBehavior.this.getCanScroll().invoke().booleanValue()) {
                float scrollOffset = EnterAlwaysSearchBarScrollBehavior.this.getScrollOffset();
                EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior = EnterAlwaysSearchBarScrollBehavior.this;
                enterAlwaysSearchBarScrollBehavior.setScrollOffset(enterAlwaysSearchBarScrollBehavior.getScrollOffset() + Float.intBitsToFloat((int) (4294967295L & j)));
                if (!EnterAlwaysSearchBarScrollBehavior.this.getReverseLayout() && scrollOffset != EnterAlwaysSearchBarScrollBehavior.this.getScrollOffset()) {
                    return Offset.m4521copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
                }
                return Offset.Companion.m4543getZeroF1C5BW0();
            }
            return Offset.Companion.m4543getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPostScroll-DzOQY0M */
        public long mo573onPostScrollDzOQY0M(long j, long j2, int i) {
            if (EnterAlwaysSearchBarScrollBehavior.this.getCanScroll().invoke().booleanValue()) {
                if (EnterAlwaysSearchBarScrollBehavior.this.getReverseLayout()) {
                    int i2 = (int) (j2 & 4294967295L);
                    if (Float.intBitsToFloat(i2) > 0.0f) {
                        EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior = EnterAlwaysSearchBarScrollBehavior.this;
                        enterAlwaysSearchBarScrollBehavior.setScrollOffset(enterAlwaysSearchBarScrollBehavior.getScrollOffset() + Float.intBitsToFloat(i2));
                        return Offset.m4521copydBAh8RU$default(j2, 0.0f, 0.0f, 2, null);
                    }
                }
                if (!EnterAlwaysSearchBarScrollBehavior.this.getReverseLayout()) {
                    EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior2 = EnterAlwaysSearchBarScrollBehavior.this;
                    enterAlwaysSearchBarScrollBehavior2.setScrollOffset(enterAlwaysSearchBarScrollBehavior2.getScrollOffset() + Float.intBitsToFloat((int) (j & 4294967295L)));
                }
                return Offset.Companion.m4543getZeroF1C5BW0();
            }
            return Offset.Companion.m4543getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPostFling-RZ2iAVY */
        public Object mo572onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
            Object m2053settleSearchBarOhffZ5M;
            if (EnterAlwaysSearchBarScrollBehavior.this.getCanScroll().invoke().booleanValue()) {
                m2053settleSearchBarOhffZ5M = EnterAlwaysSearchBarScrollBehavior.this.m2053settleSearchBarOhffZ5M(Velocity.m7794getYimpl(j2), continuation);
                return m2053settleSearchBarOhffZ5M;
            }
            return Velocity.m7784boximpl(Velocity.Companion.m7804getZero9UxMQ8M());
        }
    };
    private final boolean reverseLayout;
    private final MutableFloatState scrollOffsetLimit$delegate;
    private final AnimationSpec<Float> snapAnimationSpec;

    public EnterAlwaysSearchBarScrollBehavior(float f, float f2, Function0<Boolean> function0, boolean z, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec) {
        this.canScroll = function0;
        this.reverseLayout = z;
        this.snapAnimationSpec = animationSpec;
        this.flingAnimationSpec = decayAnimationSpec;
        this._offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.scrollOffsetLimit$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f2);
    }

    public final Function0<Boolean> getCanScroll() {
        return this.canScroll;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    public final DecayAnimationSpec<Float> getFlingAnimationSpec() {
        return this.flingAnimationSpec;
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public float getScrollOffset() {
        return this._offset.getFloatValue();
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public void setScrollOffset(float f) {
        this._offset.setFloatValue(RangesKt.coerceIn(f, getScrollOffsetLimit(), 0.0f));
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public float getScrollOffsetLimit() {
        return this.scrollOffsetLimit$delegate.getFloatValue();
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public void setScrollOffsetLimit(float f) {
        this.scrollOffsetLimit$delegate.setFloatValue(f);
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public Modifier searchBarScrollBehavior(Modifier modifier) {
        return OnRemeasuredModifierKt.onSizeChanged(LayoutModifierKt.layout(ClipKt.clipToBounds(DraggableKt.draggable$default(modifier, DraggableKt.DraggableState(new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnterAlwaysSearchBarScrollBehavior.searchBarScrollBehavior$lambda$0(EnterAlwaysSearchBarScrollBehavior.this, ((Float) obj).floatValue());
            }
        }), Orientation.Vertical, this.canScroll.invoke().booleanValue(), null, false, null, new EnterAlwaysSearchBarScrollBehavior$searchBarScrollBehavior$2(this, null), false, 184, null)), new Function3() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return EnterAlwaysSearchBarScrollBehavior.searchBarScrollBehavior$lambda$2(EnterAlwaysSearchBarScrollBehavior.this, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        }), new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnterAlwaysSearchBarScrollBehavior.searchBarScrollBehavior$lambda$3(EnterAlwaysSearchBarScrollBehavior.this, (IntSize) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit searchBarScrollBehavior$lambda$0(EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior, float f) {
        enterAlwaysSearchBarScrollBehavior.setScrollOffset(enterAlwaysSearchBarScrollBehavior.getScrollOffset() + f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final MeasureResult searchBarScrollBehavior$lambda$2(EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable mo6216measureBRTryo0 = measurable.mo6216measureBRTryo0(constraints.m7514unboximpl());
        final int roundToInt = MathKt.roundToInt(enterAlwaysSearchBarScrollBehavior.getScrollOffset());
        return MeasureScope.layout$default(measureScope, mo6216measureBRTryo0.getWidth(), RangesKt.coerceAtLeast(mo6216measureBRTryo0.getHeight() + roundToInt, 0), null, new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnterAlwaysSearchBarScrollBehavior.searchBarScrollBehavior$lambda$2$lambda$1(Placeable.this, roundToInt, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit searchBarScrollBehavior$lambda$2$lambda$1(Placeable placeable, int i, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, i, 0.0f, (Function1) null, 12, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit searchBarScrollBehavior$lambda$3(EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior, IntSize intSize) {
        enterAlwaysSearchBarScrollBehavior.setScrollOffsetLimit(-((int) (intSize.m7730unboximpl() & 4294967295L)));
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0101  */
    /* renamed from: settleSearchBar-OhffZ5M  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m2053settleSearchBarOhffZ5M(float f, Continuation<? super Velocity> continuation) {
        EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1 enterAlwaysSearchBarScrollBehavior$settleSearchBar$1;
        int i;
        float scrollOffset;
        final Ref.FloatRef floatRef;
        float f2;
        Ref.FloatRef floatRef2;
        AnimationState AnimationState$default;
        Float boxFloat;
        AnimationSpec<Float> animationSpec;
        Function1 function1;
        Ref.FloatRef floatRef3;
        if (continuation instanceof EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1) {
            enterAlwaysSearchBarScrollBehavior$settleSearchBar$1 = (EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1) continuation;
            if ((enterAlwaysSearchBarScrollBehavior$settleSearchBar$1.label & Integer.MIN_VALUE) != 0) {
                enterAlwaysSearchBarScrollBehavior$settleSearchBar$1.label -= Integer.MIN_VALUE;
                EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1 enterAlwaysSearchBarScrollBehavior$settleSearchBar$12 = enterAlwaysSearchBarScrollBehavior$settleSearchBar$1;
                Object obj = enterAlwaysSearchBarScrollBehavior$settleSearchBar$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = enterAlwaysSearchBarScrollBehavior$settleSearchBar$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    scrollOffset = getScrollOffsetLimit() == 0.0f ? 0.0f : getScrollOffset() / getScrollOffsetLimit();
                    if (scrollOffset < 0.01f || scrollOffset == 1.0f) {
                        return Velocity.m7784boximpl(Velocity.Companion.m7804getZero9UxMQ8M());
                    }
                    floatRef = new Ref.FloatRef();
                    floatRef.element = f;
                    if (Math.abs(f) > 1.0f) {
                        final Ref.FloatRef floatRef4 = new Ref.FloatRef();
                        AnimationState AnimationState$default2 = AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null);
                        DecayAnimationSpec<Float> decayAnimationSpec = this.flingAnimationSpec;
                        Function1 function12 = new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return EnterAlwaysSearchBarScrollBehavior.settleSearchBar_OhffZ5M$lambda$4(Ref.FloatRef.this, this, floatRef, (AnimationScope) obj2);
                            }
                        };
                        enterAlwaysSearchBarScrollBehavior$settleSearchBar$12.L$0 = floatRef;
                        enterAlwaysSearchBarScrollBehavior$settleSearchBar$12.F$0 = scrollOffset;
                        enterAlwaysSearchBarScrollBehavior$settleSearchBar$12.label = 1;
                        if (SuspendAnimationKt.animateDecay$default(AnimationState$default2, decayAnimationSpec, false, function12, enterAlwaysSearchBarScrollBehavior$settleSearchBar$12, 2, null) != coroutine_suspended) {
                            f2 = scrollOffset;
                            floatRef2 = floatRef;
                        }
                        return coroutine_suspended;
                    }
                    if (getScrollOffsetLimit() < getScrollOffset() && getScrollOffset() < 0.0f) {
                        AnimationState$default = AnimationStateKt.AnimationState$default(getScrollOffset(), 0.0f, 0L, 0L, false, 30, null);
                        boxFloat = Boxing.boxFloat(scrollOffset >= 0.5f ? 0.0f : getScrollOffsetLimit());
                        animationSpec = this.snapAnimationSpec;
                        function1 = new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return EnterAlwaysSearchBarScrollBehavior.settleSearchBar_OhffZ5M$lambda$5(EnterAlwaysSearchBarScrollBehavior.this, (AnimationScope) obj2);
                            }
                        };
                        enterAlwaysSearchBarScrollBehavior$settleSearchBar$12.L$0 = floatRef;
                        enterAlwaysSearchBarScrollBehavior$settleSearchBar$12.label = 2;
                        if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec, false, function1, enterAlwaysSearchBarScrollBehavior$settleSearchBar$12, 4, null) != coroutine_suspended) {
                            floatRef3 = floatRef;
                            floatRef = floatRef3;
                        }
                        return coroutine_suspended;
                    }
                    return Velocity.m7784boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
                } else if (i != 1) {
                    if (i == 2) {
                        floatRef3 = (Ref.FloatRef) enterAlwaysSearchBarScrollBehavior$settleSearchBar$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        floatRef = floatRef3;
                        return Velocity.m7784boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    f2 = enterAlwaysSearchBarScrollBehavior$settleSearchBar$12.F$0;
                    floatRef2 = (Ref.FloatRef) enterAlwaysSearchBarScrollBehavior$settleSearchBar$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                scrollOffset = f2;
                floatRef = floatRef2;
                if (getScrollOffsetLimit() < getScrollOffset()) {
                    AnimationState$default = AnimationStateKt.AnimationState$default(getScrollOffset(), 0.0f, 0L, 0L, false, 30, null);
                    boxFloat = Boxing.boxFloat(scrollOffset >= 0.5f ? 0.0f : getScrollOffsetLimit());
                    animationSpec = this.snapAnimationSpec;
                    function1 = new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return EnterAlwaysSearchBarScrollBehavior.settleSearchBar_OhffZ5M$lambda$5(EnterAlwaysSearchBarScrollBehavior.this, (AnimationScope) obj2);
                        }
                    };
                    enterAlwaysSearchBarScrollBehavior$settleSearchBar$12.L$0 = floatRef;
                    enterAlwaysSearchBarScrollBehavior$settleSearchBar$12.label = 2;
                    if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec, false, function1, enterAlwaysSearchBarScrollBehavior$settleSearchBar$12, 4, null) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                return Velocity.m7784boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
            }
        }
        enterAlwaysSearchBarScrollBehavior$settleSearchBar$1 = new EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1(this, continuation);
        EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1 enterAlwaysSearchBarScrollBehavior$settleSearchBar$122 = enterAlwaysSearchBarScrollBehavior$settleSearchBar$1;
        Object obj2 = enterAlwaysSearchBarScrollBehavior$settleSearchBar$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = enterAlwaysSearchBarScrollBehavior$settleSearchBar$122.label;
        if (i != 0) {
        }
        scrollOffset = f2;
        floatRef = floatRef2;
        if (getScrollOffsetLimit() < getScrollOffset()) {
        }
        return Velocity.m7784boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settleSearchBar_OhffZ5M$lambda$4(Ref.FloatRef floatRef, EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior, Ref.FloatRef floatRef2, AnimationScope animationScope) {
        float floatValue = ((Number) animationScope.getValue()).floatValue() - floatRef.element;
        float scrollOffset = enterAlwaysSearchBarScrollBehavior.getScrollOffset();
        enterAlwaysSearchBarScrollBehavior.setScrollOffset(scrollOffset + floatValue);
        float abs = Math.abs(scrollOffset - enterAlwaysSearchBarScrollBehavior.getScrollOffset());
        floatRef.element = ((Number) animationScope.getValue()).floatValue();
        floatRef2.element = ((Number) animationScope.getVelocity()).floatValue();
        if (Math.abs(floatValue - abs) > 0.5f) {
            animationScope.cancelAnimation();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settleSearchBar_OhffZ5M$lambda$5(EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior, AnimationScope animationScope) {
        enterAlwaysSearchBarScrollBehavior.setScrollOffset(((Number) animationScope.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* compiled from: SearchBar.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<EnterAlwaysSearchBarScrollBehavior, ?> Saver(final Function0<Boolean> function0, final AnimationSpec<Float> animationSpec, final DecayAnimationSpec<Float> decayAnimationSpec) {
            return ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    List listOf;
                    SaverScope saverScope = (SaverScope) obj;
                    listOf = CollectionsKt.listOf(Float.valueOf(r2.getScrollOffset()), Float.valueOf(r2.getScrollOffsetLimit()), Boolean.valueOf(((EnterAlwaysSearchBarScrollBehavior) obj2).getReverseLayout()));
                    return listOf;
                }
            }, new Function1() { // from class: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EnterAlwaysSearchBarScrollBehavior.Companion.Saver$lambda$1(Function0.this, animationSpec, decayAnimationSpec, (List) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final EnterAlwaysSearchBarScrollBehavior Saver$lambda$1(Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, List list) {
            Object obj = list.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) obj).floatValue();
            Object obj2 = list.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            float floatValue2 = ((Float) obj2).floatValue();
            Object obj3 = list.get(2);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            return new EnterAlwaysSearchBarScrollBehavior(floatValue, floatValue2, function0, ((Boolean) obj3).booleanValue(), animationSpec, decayAnimationSpec);
        }
    }
}
