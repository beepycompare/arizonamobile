package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
/* compiled from: AndroidOverscroll.android.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0$H\u0016¢\u0006\u0004\b%\u0010&J<\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\"\u0010*\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0,\u0012\u0006\u0012\u0004\u0018\u00010-0+H\u0096@¢\u0006\u0004\b.\u0010/J\u0017\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u000201H\u0000¢\u0006\u0004\b5\u00106J\u000f\u00109\u001a\u00020\rH\u0000¢\u0006\u0004\b:\u0010;J\r\u0010B\u001a\u00020\u0013H\u0000¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\u0013H\u0002J\u0017\u0010E\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bN\u0010LJ\u0017\u0010O\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bP\u0010LJ\u0017\u0010Q\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bR\u0010LR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u00102\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001bR\u0010\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020?X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A¨\u0006S"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "density", "Landroidx/compose/ui/unit/Density;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroid/content/Context;Landroidx/compose/ui/unit/Density;JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "", "getRedrawSignal$foundation", "()Landroidx/compose/runtime/MutableState;", "invalidationEnabled", "", "getInvalidationEnabled$foundation$annotations", "()V", "getInvalidationEnabled$foundation", "()Z", "setInvalidationEnabled$foundation", "(Z)V", "scrollCycleInProgress", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "containerSize", "Landroidx/compose/ui/geometry/Size;", "isInProgress", "updateSize", "size", "updateSize-uvyYCjk$foundation", "(J)V", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "displacement", "displacement-F1C5BW0$foundation", "()J", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "invalidateOverscroll", "invalidateOverscroll$foundation", "animateToReleaseIfNeeded", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "pullTop", "", "scroll", "pullTop-k-4lQ0M", "(J)F", "pullBottom", "pullBottom-k-4lQ0M", "pullLeft", "pullLeft-k-4lQ0M", "pullRight", "pullRight-k-4lQ0M", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    private long containerSize;
    private final Density density;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private boolean invalidationEnabled;
    private final DelegatableNode node;
    private long pointerId;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private long pointerPosition;
    private final MutableState<Unit> redrawSignal;
    private boolean scrollCycleInProgress;

    public /* synthetic */ AndroidEdgeEffectOverscrollEffect(Context context, Density density, long j, PaddingValues paddingValues, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, density, j, paddingValues);
    }

    public static /* synthetic */ void getInvalidationEnabled$foundation$annotations() {
    }

    private AndroidEdgeEffectOverscrollEffect(Context context, Density density, long j, PaddingValues paddingValues) {
        GlowOverscrollNode glowOverscrollNode;
        this.density = density;
        this.pointerPosition = Offset.Companion.m4542getUnspecifiedF1C5BW0();
        EdgeEffectWrapper edgeEffectWrapper = new EdgeEffectWrapper(context, ColorKt.m4826toArgb8_81llA(j));
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.m4605getZeroNHjbRc();
        this.pointerId = PointerId.m6065constructorimpl(-1L);
        SuspendingPointerInputModifierNode SuspendingPointerInputModifierNode = SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1

            /* compiled from: AndroidOverscroll.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1$1", f = "AndroidOverscroll.android.kt", i = {0, 1}, l = {783, 787}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0"}, v = 1)
            /* renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1$1  reason: invalid class name */
            /* loaded from: classes.dex */
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = androidEdgeEffectOverscrollEffect;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
                    if (r15 != r0) goto L6;
                 */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0061 -> B:18:0x0064). Please submit an issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    Object obj2;
                    long j;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope2;
                        this.label = 1;
                        obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null);
                        if (obj != coroutine_suspended) {
                            awaitPointerEventScope = awaitPointerEventScope2;
                        }
                        return coroutine_suspended;
                    } else if (i == 1) {
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        List<PointerInputChange> changes = ((PointerEvent) obj).getChanges();
                        ArrayList arrayList = new ArrayList(changes.size());
                        int size = changes.size();
                        int i2 = 0;
                        for (int i3 = 0; i3 < size; i3++) {
                            PointerInputChange pointerInputChange = changes.get(i3);
                            if (pointerInputChange.getPressed()) {
                                arrayList.add(pointerInputChange);
                            }
                        }
                        ArrayList arrayList2 = arrayList;
                        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = this.this$0;
                        ArrayList arrayList3 = arrayList2;
                        int size2 = arrayList3.size();
                        while (true) {
                            if (i2 >= size2) {
                                obj2 = null;
                                break;
                            }
                            obj2 = arrayList2.get(i2);
                            long m6083getIdJ3iCeTQ = ((PointerInputChange) obj2).m6083getIdJ3iCeTQ();
                            j = androidEdgeEffectOverscrollEffect.pointerId;
                            if (PointerId.m6067equalsimpl0(m6083getIdJ3iCeTQ, j)) {
                                break;
                            }
                            i2++;
                        }
                        PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                        if (pointerInputChange2 == null) {
                            pointerInputChange2 = (PointerInputChange) CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
                        }
                        if (pointerInputChange2 != null) {
                            this.this$0.pointerId = pointerInputChange2.m6083getIdJ3iCeTQ();
                            this.this$0.pointerPosition = pointerInputChange2.m6085getPositionF1C5BW0();
                        }
                        if (arrayList3.isEmpty()) {
                            this.this$0.pointerId = PointerId.m6065constructorimpl(-1L);
                            return Unit.INSTANCE;
                        }
                        this.L$0 = awaitPointerEventScope;
                        this.label = 2;
                        obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                    }
                    PointerInputChange pointerInputChange3 = (PointerInputChange) obj;
                    this.this$0.pointerId = pointerInputChange3.m6083getIdJ3iCeTQ();
                    this.this$0.pointerPosition = pointerInputChange3.m6085getPositionF1C5BW0();
                    this.L$0 = awaitPointerEventScope;
                    this.label = 2;
                    obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1(AndroidEdgeEffectOverscrollEffect.this, null), continuation);
                return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
            }
        });
        this.pointerInputNode = SuspendingPointerInputModifierNode;
        if (Build.VERSION.SDK_INT >= 31) {
            glowOverscrollNode = new StretchOverscrollNode(SuspendingPointerInputModifierNode, this, edgeEffectWrapper);
        } else {
            glowOverscrollNode = new GlowOverscrollNode(SuspendingPointerInputModifierNode, this, edgeEffectWrapper, paddingValues);
        }
        this.node = glowOverscrollNode;
    }

    public final MutableState<Unit> getRedrawSignal$foundation() {
        return this.redrawSignal;
    }

    public final boolean getInvalidationEnabled$foundation() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation(boolean z) {
        this.invalidationEnabled = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x023f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fb  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToScroll-Rhakbz0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo242applyToScrollRhakbz0(long j, int i, Function1<? super Offset, Offset> function1) {
        float m236pullBottomk4lQ0M;
        float intBitsToFloat;
        int i2;
        float m238pullRightk4lQ0M;
        float intBitsToFloat2;
        long m4519constructorimpl;
        long m4531minusMKHz9U;
        EdgeEffectWrapper edgeEffectWrapper;
        long j2;
        boolean z;
        boolean z2;
        int i3;
        boolean z3;
        if (Size.m4598isEmptyimpl(this.containerSize)) {
            return function1.invoke(Offset.m4516boximpl(j)).m4537unboximpl();
        }
        if (!this.scrollCycleInProgress) {
            if (this.edgeEffectWrapper.isLeftStretched()) {
                m237pullLeftk4lQ0M(Offset.Companion.m4543getZeroF1C5BW0());
            }
            if (this.edgeEffectWrapper.isRightStretched()) {
                m238pullRightk4lQ0M(Offset.Companion.m4543getZeroF1C5BW0());
            }
            if (this.edgeEffectWrapper.isTopStretched()) {
                m239pullTopk4lQ0M(Offset.Companion.m4543getZeroF1C5BW0());
            }
            if (this.edgeEffectWrapper.isBottomStretched()) {
                m236pullBottomk4lQ0M(Offset.Companion.m4543getZeroF1C5BW0());
            }
            this.scrollCycleInProgress = true;
        }
        float m260access$destretchMultiplierGyEprt8 = AndroidOverscroll_androidKt.m260access$destretchMultiplierGyEprt8(i);
        long m4534timestuRUvjQ = Offset.m4534timestuRUvjQ(j, m260access$destretchMultiplierGyEprt8);
        int i4 = (int) (j & 4294967295L);
        if (Float.intBitsToFloat(i4) != 0.0f) {
            if (this.edgeEffectWrapper.isTopStretched() && Float.intBitsToFloat(i4) < 0.0f) {
                m236pullBottomk4lQ0M = m239pullTopk4lQ0M(m4534timestuRUvjQ);
                if (!this.edgeEffectWrapper.isTopStretched()) {
                    this.edgeEffectWrapper.getOrCreateTopEffect().finish();
                }
                if (m236pullBottomk4lQ0M == Float.intBitsToFloat((int) (m4534timestuRUvjQ & 4294967295L))) {
                    intBitsToFloat = Float.intBitsToFloat(i4);
                }
                intBitsToFloat = m236pullBottomk4lQ0M / m260access$destretchMultiplierGyEprt8;
            } else if (this.edgeEffectWrapper.isBottomStretched() && Float.intBitsToFloat(i4) > 0.0f) {
                m236pullBottomk4lQ0M = m236pullBottomk4lQ0M(m4534timestuRUvjQ);
                if (!this.edgeEffectWrapper.isBottomStretched()) {
                    this.edgeEffectWrapper.getOrCreateBottomEffect().finish();
                }
                if (m236pullBottomk4lQ0M == Float.intBitsToFloat((int) (m4534timestuRUvjQ & 4294967295L))) {
                    intBitsToFloat = Float.intBitsToFloat(i4);
                }
                intBitsToFloat = m236pullBottomk4lQ0M / m260access$destretchMultiplierGyEprt8;
            }
            i2 = (int) (j >> 32);
            if (Float.intBitsToFloat(i2) != 0.0f) {
                if (this.edgeEffectWrapper.isLeftStretched() && Float.intBitsToFloat(i2) < 0.0f) {
                    m238pullRightk4lQ0M = m237pullLeftk4lQ0M(m4534timestuRUvjQ);
                    if (!this.edgeEffectWrapper.isLeftStretched()) {
                        this.edgeEffectWrapper.getOrCreateLeftEffect().finish();
                    }
                    if (m238pullRightk4lQ0M == Float.intBitsToFloat((int) (m4534timestuRUvjQ >> 32))) {
                        intBitsToFloat2 = Float.intBitsToFloat(i2);
                    }
                    intBitsToFloat2 = m238pullRightk4lQ0M / m260access$destretchMultiplierGyEprt8;
                } else if (this.edgeEffectWrapper.isRightStretched() && Float.intBitsToFloat(i2) > 0.0f) {
                    m238pullRightk4lQ0M = m238pullRightk4lQ0M(m4534timestuRUvjQ);
                    if (!this.edgeEffectWrapper.isRightStretched()) {
                        this.edgeEffectWrapper.getOrCreateRightEffect().finish();
                    }
                    if (m238pullRightk4lQ0M == Float.intBitsToFloat((int) (m4534timestuRUvjQ >> 32))) {
                        intBitsToFloat2 = Float.intBitsToFloat(i2);
                    }
                    intBitsToFloat2 = m238pullRightk4lQ0M / m260access$destretchMultiplierGyEprt8;
                }
                m4519constructorimpl = Offset.m4519constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L));
                if (!Offset.m4524equalsimpl0(m4519constructorimpl, Offset.Companion.m4543getZeroF1C5BW0())) {
                    invalidateOverscroll$foundation();
                }
                m4531minusMKHz9U = Offset.m4531minusMKHz9U(j, m4519constructorimpl);
                long m4537unboximpl = function1.invoke(Offset.m4516boximpl(m4531minusMKHz9U)).m4537unboximpl();
                long m4531minusMKHz9U2 = Offset.m4531minusMKHz9U(m4531minusMKHz9U, m4537unboximpl);
                if ((Float.intBitsToFloat((int) (m4531minusMKHz9U >> 32)) == 0.0f || Float.intBitsToFloat((int) (m4531minusMKHz9U & 4294967295L)) != 0.0f) && (Float.intBitsToFloat((int) (m4537unboximpl >> 32)) != 0.0f || Float.intBitsToFloat((int) (m4537unboximpl & 4294967295L)) != 0.0f)) {
                    edgeEffectWrapper = this.edgeEffectWrapper;
                    if (!edgeEffectWrapper.isLeftStretched() || edgeEffectWrapper.isTopStretched() || edgeEffectWrapper.isRightStretched() || edgeEffectWrapper.isBottomStretched()) {
                        animateToReleaseIfNeeded();
                    }
                }
                if (NestedScrollSource.m5953equalsimpl0(i, NestedScrollSource.Companion.m5965getUserInputWNlRxjI())) {
                    int i5 = (int) (m4531minusMKHz9U2 >> 32);
                    if (Float.intBitsToFloat(i5) > 0.5f) {
                        m237pullLeftk4lQ0M(m4531minusMKHz9U2);
                    } else if (Float.intBitsToFloat(i5) < -0.5f) {
                        m238pullRightk4lQ0M(m4531minusMKHz9U2);
                    } else {
                        j2 = m4519constructorimpl;
                        z2 = false;
                        i3 = (int) (m4531minusMKHz9U2 & 4294967295L);
                        if (Float.intBitsToFloat(i3) <= 0.5f) {
                            m239pullTopk4lQ0M(m4531minusMKHz9U2);
                        } else if (Float.intBitsToFloat(i3) < -0.5f) {
                            m236pullBottomk4lQ0M(m4531minusMKHz9U2);
                        } else {
                            z3 = false;
                            if (!z2 || z3) {
                                z = true;
                                if (!Offset.m4524equalsimpl0(m4531minusMKHz9U, Offset.Companion.m4543getZeroF1C5BW0())) {
                                    z = m240releaseOppositeOverscrollk4lQ0M(j) || z;
                                }
                                if (z) {
                                    invalidateOverscroll$foundation();
                                }
                                return Offset.m4532plusMKHz9U(j2, m4537unboximpl);
                            }
                        }
                        z3 = true;
                        if (!z2) {
                        }
                        z = true;
                        if (!Offset.m4524equalsimpl0(m4531minusMKHz9U, Offset.Companion.m4543getZeroF1C5BW0())) {
                        }
                        if (z) {
                        }
                        return Offset.m4532plusMKHz9U(j2, m4537unboximpl);
                    }
                    z2 = true;
                    j2 = m4519constructorimpl;
                    i3 = (int) (m4531minusMKHz9U2 & 4294967295L);
                    if (Float.intBitsToFloat(i3) <= 0.5f) {
                    }
                    z3 = true;
                    if (!z2) {
                    }
                    z = true;
                    if (!Offset.m4524equalsimpl0(m4531minusMKHz9U, Offset.Companion.m4543getZeroF1C5BW0())) {
                    }
                    if (z) {
                    }
                    return Offset.m4532plusMKHz9U(j2, m4537unboximpl);
                }
                j2 = m4519constructorimpl;
                z = false;
                if (!Offset.m4524equalsimpl0(m4531minusMKHz9U, Offset.Companion.m4543getZeroF1C5BW0())) {
                }
                if (z) {
                }
                return Offset.m4532plusMKHz9U(j2, m4537unboximpl);
            }
            intBitsToFloat2 = 0.0f;
            m4519constructorimpl = Offset.m4519constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L));
            if (!Offset.m4524equalsimpl0(m4519constructorimpl, Offset.Companion.m4543getZeroF1C5BW0())) {
            }
            m4531minusMKHz9U = Offset.m4531minusMKHz9U(j, m4519constructorimpl);
            long m4537unboximpl2 = function1.invoke(Offset.m4516boximpl(m4531minusMKHz9U)).m4537unboximpl();
            long m4531minusMKHz9U22 = Offset.m4531minusMKHz9U(m4531minusMKHz9U, m4537unboximpl2);
            if (Float.intBitsToFloat((int) (m4531minusMKHz9U >> 32)) == 0.0f) {
            }
            edgeEffectWrapper = this.edgeEffectWrapper;
            if (!edgeEffectWrapper.isLeftStretched()) {
            }
            animateToReleaseIfNeeded();
            if (NestedScrollSource.m5953equalsimpl0(i, NestedScrollSource.Companion.m5965getUserInputWNlRxjI())) {
            }
            z = false;
            if (!Offset.m4524equalsimpl0(m4531minusMKHz9U, Offset.Companion.m4543getZeroF1C5BW0())) {
            }
            if (z) {
            }
            return Offset.m4532plusMKHz9U(j2, m4537unboximpl2);
        }
        intBitsToFloat = 0.0f;
        i2 = (int) (j >> 32);
        if (Float.intBitsToFloat(i2) != 0.0f) {
        }
        intBitsToFloat2 = 0.0f;
        m4519constructorimpl = Offset.m4519constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L));
        if (!Offset.m4524equalsimpl0(m4519constructorimpl, Offset.Companion.m4543getZeroF1C5BW0())) {
        }
        m4531minusMKHz9U = Offset.m4531minusMKHz9U(j, m4519constructorimpl);
        long m4537unboximpl22 = function1.invoke(Offset.m4516boximpl(m4531minusMKHz9U)).m4537unboximpl();
        long m4531minusMKHz9U222 = Offset.m4531minusMKHz9U(m4531minusMKHz9U, m4537unboximpl22);
        if (Float.intBitsToFloat((int) (m4531minusMKHz9U >> 32)) == 0.0f) {
        }
        edgeEffectWrapper = this.edgeEffectWrapper;
        if (!edgeEffectWrapper.isLeftStretched()) {
        }
        animateToReleaseIfNeeded();
        if (NestedScrollSource.m5953equalsimpl0(i, NestedScrollSource.Companion.m5965getUserInputWNlRxjI())) {
        }
        z = false;
        if (!Offset.m4524equalsimpl0(m4531minusMKHz9U, Offset.Companion.m4543getZeroF1C5BW0())) {
        }
        if (z) {
        }
        return Offset.m4532plusMKHz9U(j2, m4537unboximpl22);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (r14.invoke(r11, r0) == r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0135, code lost:
        if (r15 == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToFling-BMRW4eQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo241applyToFlingBMRW4eQ(long j, Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 androidEdgeEffectOverscrollEffect$applyToFling$1;
        int i;
        float f;
        float f2;
        long m7796minusAH228Gc;
        if (continuation instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1) {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = (AndroidEdgeEffectOverscrollEffect$applyToFling$1) continuation;
            if ((androidEdgeEffectOverscrollEffect$applyToFling$1.label & Integer.MIN_VALUE) != 0) {
                androidEdgeEffectOverscrollEffect$applyToFling$1.label -= Integer.MIN_VALUE;
                Object obj = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    } else if (i == 2) {
                        m7796minusAH228Gc = androidEdgeEffectOverscrollEffect$applyToFling$1.J$0;
                        ResultKt.throwOnFailure(obj);
                        long m7796minusAH228Gc2 = Velocity.m7796minusAH228Gc(m7796minusAH228Gc, ((Velocity) obj).m7802unboximpl());
                        this.scrollCycleInProgress = false;
                        if (Velocity.m7793getXimpl(m7796minusAH228Gc2) > 0.0f) {
                            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.m7793getXimpl(m7796minusAH228Gc2)));
                        } else if (Velocity.m7793getXimpl(m7796minusAH228Gc2) < 0.0f) {
                            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.m7793getXimpl(m7796minusAH228Gc2)));
                        }
                        if (Velocity.m7794getYimpl(m7796minusAH228Gc2) > 0.0f) {
                            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.m7794getYimpl(m7796minusAH228Gc2)));
                        } else if (Velocity.m7794getYimpl(m7796minusAH228Gc2) < 0.0f) {
                            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.m7794getYimpl(m7796minusAH228Gc2)));
                        }
                        animateToReleaseIfNeeded();
                        return Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                ResultKt.throwOnFailure(obj);
                if (Size.m4598isEmptyimpl(this.containerSize)) {
                    Velocity m7784boximpl = Velocity.m7784boximpl(j);
                    androidEdgeEffectOverscrollEffect$applyToFling$1.label = 1;
                } else {
                    if (this.edgeEffectWrapper.isLeftStretched() && Velocity.m7793getXimpl(j) < 0.0f) {
                        f = EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateLeftEffect(), Velocity.m7793getXimpl(j), Float.intBitsToFloat((int) (this.containerSize >> 32)), this.density);
                    } else {
                        f = (!this.edgeEffectWrapper.isRightStretched() || Velocity.m7793getXimpl(j) <= 0.0f) ? 0.0f : -EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateRightEffect(), -Velocity.m7793getXimpl(j), Float.intBitsToFloat((int) (this.containerSize >> 32)), this.density);
                    }
                    if (this.edgeEffectWrapper.isTopStretched() && Velocity.m7794getYimpl(j) < 0.0f) {
                        f2 = EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateTopEffect(), Velocity.m7794getYimpl(j), Float.intBitsToFloat((int) (4294967295L & this.containerSize)), this.density);
                    } else {
                        f2 = (!this.edgeEffectWrapper.isBottomStretched() || Velocity.m7794getYimpl(j) <= 0.0f) ? 0.0f : -EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateBottomEffect(), -Velocity.m7794getYimpl(j), Float.intBitsToFloat((int) (4294967295L & this.containerSize)), this.density);
                    }
                    long Velocity = VelocityKt.Velocity(f, f2);
                    if (!Velocity.m7792equalsimpl0(Velocity, Velocity.Companion.m7804getZero9UxMQ8M())) {
                        invalidateOverscroll$foundation();
                    }
                    m7796minusAH228Gc = Velocity.m7796minusAH228Gc(j, Velocity);
                    Velocity m7784boximpl2 = Velocity.m7784boximpl(m7796minusAH228Gc);
                    androidEdgeEffectOverscrollEffect$applyToFling$1.J$0 = m7796minusAH228Gc;
                    androidEdgeEffectOverscrollEffect$applyToFling$1.label = 2;
                    obj = function2.invoke(m7784boximpl2, androidEdgeEffectOverscrollEffect$applyToFling$1);
                }
                return coroutine_suspended;
            }
        }
        androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, continuation);
        Object obj2 = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
        if (i == 0) {
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect == null || EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
            if (edgeEffect2 == null || EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect2) == 0.0f) {
                EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
                if (edgeEffect3 == null || EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect3) == 0.0f) {
                    EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
                    return (edgeEffect4 == null || EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect4) == 0.0f) ? false : true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* renamed from: updateSize-uvyYCjk$foundation  reason: not valid java name */
    public final void m244updateSizeuvyYCjk$foundation(long j) {
        boolean m4592equalsimpl0 = Size.m4592equalsimpl0(this.containerSize, Size.Companion.m4605getZeroNHjbRc());
        boolean m4592equalsimpl02 = Size.m4592equalsimpl0(j, this.containerSize);
        this.containerSize = j;
        if (!m4592equalsimpl02) {
            EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
            int roundToInt = MathKt.roundToInt(Float.intBitsToFloat((int) (j >> 32)));
            edgeEffectWrapper.m318updateSizeozmzZPI(IntSize.m7721constructorimpl((MathKt.roundToInt(Float.intBitsToFloat((int) (j & 4294967295L))) & 4294967295L) | (roundToInt << 32)));
        }
        if (m4592equalsimpl0 || m4592equalsimpl02) {
            return;
        }
        animateToReleaseIfNeeded();
    }

    /* renamed from: displacement-F1C5BW0$foundation  reason: not valid java name */
    public final long m243displacementF1C5BW0$foundation() {
        long j = this.pointerPosition;
        if ((9223372034707292159L & j) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            j = SizeKt.m4606getCenteruvyYCjk(this.containerSize);
        }
        float intBitsToFloat = Float.intBitsToFloat((int) (j & 4294967295L)) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        return Offset.m4519constructorimpl((Float.floatToRawIntBits(intBitsToFloat) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) / Float.intBitsToFloat((int) (this.containerSize >> 32))) << 32));
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public DelegatableNode getNode() {
        return this.node;
    }

    public final void invalidateOverscroll$foundation() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    private final void animateToReleaseIfNeeded() {
        boolean z;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        boolean z2 = true;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = !edgeEffect.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z = !edgeEffect2.isFinished() || z;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z = !edgeEffect3.isFinished() || z;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            if (edgeEffect4.isFinished() && !z) {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            invalidateOverscroll$foundation();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* renamed from: releaseOppositeOverscroll-k-4lQ0M  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean m240releaseOppositeOverscrollk4lQ0M(long j) {
        boolean z;
        if (this.edgeEffectWrapper.isLeftAnimating()) {
            int i = (int) (j >> 32);
            if (Float.intBitsToFloat(i) < 0.0f) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Float.intBitsToFloat(i));
                z = this.edgeEffectWrapper.isLeftAnimating();
                if (this.edgeEffectWrapper.isRightAnimating()) {
                    int i2 = (int) (j >> 32);
                    if (Float.intBitsToFloat(i2) > 0.0f) {
                        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Float.intBitsToFloat(i2));
                        z = z || this.edgeEffectWrapper.isRightAnimating();
                    }
                }
                if (this.edgeEffectWrapper.isTopAnimating()) {
                    int i3 = (int) (j & 4294967295L);
                    if (Float.intBitsToFloat(i3) < 0.0f) {
                        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Float.intBitsToFloat(i3));
                        z = z || this.edgeEffectWrapper.isTopAnimating();
                    }
                }
                if (this.edgeEffectWrapper.isBottomAnimating()) {
                    int i4 = (int) (j & 4294967295L);
                    if (Float.intBitsToFloat(i4) > 0.0f) {
                        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Float.intBitsToFloat(i4));
                        return z || this.edgeEffectWrapper.isBottomAnimating();
                    }
                }
                return z;
            }
        }
        z = false;
        if (this.edgeEffectWrapper.isRightAnimating()) {
        }
        if (this.edgeEffectWrapper.isTopAnimating()) {
        }
        if (this.edgeEffectWrapper.isBottomAnimating()) {
        }
        return z;
    }

    /* renamed from: pullTop-k-4lQ0M  reason: not valid java name */
    private final float m239pullTopk4lQ0M(long j) {
        float intBitsToFloat = Float.intBitsToFloat((int) (m243displacementF1C5BW0$foundation() >> 32));
        int i = (int) (j & 4294967295L);
        float intBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateTopEffect) == 0.0f ? EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateTopEffect, intBitsToFloat2, intBitsToFloat) * Float.intBitsToFloat((int) (this.containerSize & 4294967295L)) : Float.intBitsToFloat(i);
    }

    /* renamed from: pullBottom-k-4lQ0M  reason: not valid java name */
    private final float m236pullBottomk4lQ0M(long j) {
        float intBitsToFloat = Float.intBitsToFloat((int) (m243displacementF1C5BW0$foundation() >> 32));
        int i = (int) (j & 4294967295L);
        float intBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateBottomEffect) == 0.0f ? (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateBottomEffect, -intBitsToFloat2, 1.0f - intBitsToFloat)) * Float.intBitsToFloat((int) (this.containerSize & 4294967295L)) : Float.intBitsToFloat(i);
    }

    /* renamed from: pullLeft-k-4lQ0M  reason: not valid java name */
    private final float m237pullLeftk4lQ0M(long j) {
        float intBitsToFloat = Float.intBitsToFloat((int) (m243displacementF1C5BW0$foundation() & 4294967295L));
        int i = (int) (j >> 32);
        float intBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateLeftEffect) == 0.0f ? EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateLeftEffect, intBitsToFloat2, 1.0f - intBitsToFloat) * Float.intBitsToFloat((int) (this.containerSize >> 32)) : Float.intBitsToFloat(i);
    }

    /* renamed from: pullRight-k-4lQ0M  reason: not valid java name */
    private final float m238pullRightk4lQ0M(long j) {
        float intBitsToFloat = Float.intBitsToFloat((int) (m243displacementF1C5BW0$foundation() & 4294967295L));
        int i = (int) (j >> 32);
        float intBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateRightEffect) == 0.0f ? (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateRightEffect, -intBitsToFloat2, intBitsToFloat)) * Float.intBitsToFloat((int) (this.containerSize >> 32)) : Float.intBitsToFloat(i);
    }
}
