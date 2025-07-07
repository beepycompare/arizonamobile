package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WindowInsetsConnection.android.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020!J+\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u0004\u0018\u00010\rH\u0082@¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\rH\u0016J#\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0096@ø\u0001\u0000¢\u0006\u0004\b3\u00104J*\u00105\u001a\u0002062\u0006\u00102\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0096@ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\"\u0010>\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u0018\u0010A\u001a\u00020!2\u0006\u0010/\u001a\u00020\r2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020!H\u0002J\"\u0010E\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u0010F\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\bG\u0010HR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "view", "Landroid/view/View;", "sideCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "animationController", "Landroid/view/WindowInsetsAnimationController;", "animationJob", "Lkotlinx/coroutines/Job;", "cancellationSignal", "Landroid/os/CancellationSignal;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "isControllerRequested", "", "partialConsumption", "", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "getView", "()Landroid/view/View;", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "adjustInsets", "", "inset", "animationEnded", "dispose", "fling", "Landroidx/compose/ui/unit/Velocity;", "available", "flingAmount", "towardShown", "fling-huYlsQE", "(JFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnimationController", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelled", "controller", "onFinished", "onPostFling", "consumed", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "onReady", "types", "", "requestAnimationController", "scroll", "scrollAmount", "scroll-8S9VItk", "(JF)J", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {
    private WindowInsetsAnimationController animationController;
    private Job animationJob;
    private final CancellationSignal cancellationSignal = new CancellationSignal();
    private CancellableContinuation<? super WindowInsetsAnimationController> continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final SideCalculator sideCalculator;
    private final View view;
    private final AndroidWindowInsets windowInsets;

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets androidWindowInsets, View view, SideCalculator sideCalculator, Density density) {
        this.windowInsets = androidWindowInsets;
        this.view = view;
        this.sideCalculator = sideCalculator;
        this.density = density;
    }

    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    public final View getView() {
        return this.view;
    }

    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    public final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestAnimationController() {
        if (this.isControllerRequested) {
            return;
        }
        this.isControllerRequested = true;
        WindowInsetsController windowInsetsController = this.view.getWindowInsetsController();
        if (windowInsetsController != null) {
            windowInsetsController.controlWindowInsetsAnimation(this.windowInsets.getType$foundation_layout_release(), -1L, null, this.cancellationSignal, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAnimationController(Continuation<? super WindowInsetsAnimationController> continuation) {
        Object obj = this.animationController;
        if (obj == null) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.continuation = cancellableContinuationImpl;
            requestAnimationController();
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
        }
        return obj;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long mo816onPreScrollOzD1aCk(long j, int i) {
        return m814scroll8S9VItk(j, this.sideCalculator.hideMotion(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (4294967295L & j))));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo510onPostScrollDzOQY0M(long j, long j2, int i) {
        return m814scroll8S9VItk(j2, this.sideCalculator.showMotion(Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (4294967295L & j2))));
    }

    /* renamed from: scroll-8S9VItk  reason: not valid java name */
    private final long m814scroll8S9VItk(long j, float f) {
        Job job = this.animationJob;
        if (job != null) {
            job.cancel((CancellationException) new WindowInsetsAnimationCancelledException());
            this.animationJob = null;
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (f != 0.0f) {
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (this.windowInsets.isVisible() != (i > 0) || windowInsetsAnimationController != null) {
                if (windowInsetsAnimationController == null) {
                    this.partialConsumption = 0.0f;
                    requestAnimationController();
                    return this.sideCalculator.mo766consumedOffsetsMKHz9U(j);
                }
                int valueOf = this.sideCalculator.valueOf(windowInsetsAnimationController.getHiddenStateInsets());
                int valueOf2 = this.sideCalculator.valueOf(windowInsetsAnimationController.getShownStateInsets());
                Insets currentInsets = windowInsetsAnimationController.getCurrentInsets();
                int valueOf3 = this.sideCalculator.valueOf(currentInsets);
                if (valueOf3 == (i > 0 ? valueOf2 : valueOf)) {
                    this.partialConsumption = 0.0f;
                    return Offset.Companion.m3853getZeroF1C5BW0();
                }
                float f2 = valueOf3 + f + this.partialConsumption;
                int coerceIn = RangesKt.coerceIn(Math.round(f2), valueOf, valueOf2);
                this.partialConsumption = f2 - Math.round(f2);
                if (coerceIn != valueOf3) {
                    windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, coerceIn), 1.0f, 0.0f);
                }
                return this.sideCalculator.mo766consumedOffsetsMKHz9U(j);
            }
        }
        return Offset.Companion.m3853getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object mo815onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        return m813flinghuYlsQE(j, this.sideCalculator.hideMotion(Velocity.m6922getXimpl(j), Velocity.m6923getYimpl(j)), false, continuation);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    public Object mo509onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        return m813flinghuYlsQE(j2, this.sideCalculator.showMotion(Velocity.m6922getXimpl(j2), Velocity.m6923getYimpl(j2)), true, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb  */
    /* renamed from: fling-huYlsQE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m813flinghuYlsQE(long j, float f, boolean z, Continuation<? super Velocity> continuation) {
        WindowInsetsNestedScrollConnection$fling$1 windowInsetsNestedScrollConnection$fling$1;
        int i;
        WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection;
        long j2;
        WindowInsetsAnimationController windowInsetsAnimationController;
        Ref.FloatRef floatRef;
        long j3;
        WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection2;
        long j4;
        WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection3;
        float f2 = f;
        if (continuation instanceof WindowInsetsNestedScrollConnection$fling$1) {
            windowInsetsNestedScrollConnection$fling$1 = (WindowInsetsNestedScrollConnection$fling$1) continuation;
            if ((windowInsetsNestedScrollConnection$fling$1.label & Integer.MIN_VALUE) != 0) {
                windowInsetsNestedScrollConnection$fling$1.label -= Integer.MIN_VALUE;
                Object obj = windowInsetsNestedScrollConnection$fling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = windowInsetsNestedScrollConnection$fling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Job job = this.animationJob;
                    if (job != null) {
                        job.cancel((CancellationException) new WindowInsetsAnimationCancelledException());
                    }
                    this.animationJob = null;
                    this.partialConsumption = 0.0f;
                    if ((f2 == 0.0f && !z) || (this.animationController == null && this.windowInsets.isVisible() == z)) {
                        return Velocity.m6913boximpl(Velocity.Companion.m6933getZero9UxMQ8M());
                    }
                    windowInsetsNestedScrollConnection$fling$1.L$0 = this;
                    windowInsetsNestedScrollConnection$fling$1.J$0 = j;
                    windowInsetsNestedScrollConnection$fling$1.F$0 = f2;
                    windowInsetsNestedScrollConnection$fling$1.label = 1;
                    Object animationController = getAnimationController(windowInsetsNestedScrollConnection$fling$1);
                    if (animationController != coroutine_suspended) {
                        windowInsetsNestedScrollConnection = this;
                        j2 = j;
                        obj = animationController;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        j3 = windowInsetsNestedScrollConnection$fling$1.J$0;
                        floatRef = (Ref.FloatRef) windowInsetsNestedScrollConnection$fling$1.L$1;
                        windowInsetsNestedScrollConnection2 = (WindowInsetsNestedScrollConnection) windowInsetsNestedScrollConnection$fling$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return Velocity.m6913boximpl(windowInsetsNestedScrollConnection2.sideCalculator.mo767consumedVelocityQWom1Mo(j3, floatRef.element));
                    } else if (i == 3) {
                        j4 = windowInsetsNestedScrollConnection$fling$1.J$0;
                        windowInsetsNestedScrollConnection3 = (WindowInsetsNestedScrollConnection) windowInsetsNestedScrollConnection$fling$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return Velocity.m6913boximpl(windowInsetsNestedScrollConnection3.sideCalculator.mo767consumedVelocityQWom1Mo(j4, 0.0f));
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    f2 = windowInsetsNestedScrollConnection$fling$1.F$0;
                    j2 = windowInsetsNestedScrollConnection$fling$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    windowInsetsNestedScrollConnection = (WindowInsetsNestedScrollConnection) windowInsetsNestedScrollConnection$fling$1.L$0;
                }
                windowInsetsAnimationController = (WindowInsetsAnimationController) obj;
                if (windowInsetsAnimationController != null) {
                    return Velocity.m6913boximpl(Velocity.Companion.m6933getZero9UxMQ8M());
                }
                int valueOf = windowInsetsNestedScrollConnection.sideCalculator.valueOf(windowInsetsAnimationController.getHiddenStateInsets());
                int valueOf2 = windowInsetsNestedScrollConnection.sideCalculator.valueOf(windowInsetsAnimationController.getShownStateInsets());
                int valueOf3 = windowInsetsNestedScrollConnection.sideCalculator.valueOf(windowInsetsAnimationController.getCurrentInsets());
                if ((f2 <= 0.0f && valueOf3 == valueOf) || (f2 >= 0.0f && valueOf3 == valueOf2)) {
                    windowInsetsAnimationController.finish(valueOf3 == valueOf2);
                    windowInsetsNestedScrollConnection.animationController = null;
                    return Velocity.m6913boximpl(Velocity.Companion.m6933getZero9UxMQ8M());
                }
                SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec = new SplineBasedFloatDecayAnimationSpec(windowInsetsNestedScrollConnection.density);
                float flingDistance = valueOf3 + splineBasedFloatDecayAnimationSpec.flingDistance(f2);
                float f3 = valueOf;
                boolean z2 = (flingDistance - f3) / ((float) (valueOf2 - valueOf)) > 0.5f;
                int i2 = z2 ? valueOf2 : valueOf;
                if (flingDistance > valueOf2 || flingDistance < f3) {
                    Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    windowInsetsNestedScrollConnection$fling$1.L$0 = windowInsetsNestedScrollConnection;
                    windowInsetsNestedScrollConnection$fling$1.L$1 = floatRef2;
                    windowInsetsNestedScrollConnection$fling$1.J$0 = j2;
                    windowInsetsNestedScrollConnection$fling$1.label = 2;
                    if (CoroutineScopeKt.coroutineScope(new WindowInsetsNestedScrollConnection$fling$2(windowInsetsNestedScrollConnection, valueOf3, f2, splineBasedFloatDecayAnimationSpec, valueOf, valueOf2, floatRef2, windowInsetsAnimationController, z2, null), windowInsetsNestedScrollConnection$fling$1) != coroutine_suspended) {
                        floatRef = floatRef2;
                        j3 = j2;
                        windowInsetsNestedScrollConnection2 = windowInsetsNestedScrollConnection;
                        return Velocity.m6913boximpl(windowInsetsNestedScrollConnection2.sideCalculator.mo767consumedVelocityQWom1Mo(j3, floatRef.element));
                    }
                } else {
                    windowInsetsNestedScrollConnection$fling$1.L$0 = windowInsetsNestedScrollConnection;
                    windowInsetsNestedScrollConnection$fling$1.J$0 = j2;
                    windowInsetsNestedScrollConnection$fling$1.label = 3;
                    if (CoroutineScopeKt.coroutineScope(new WindowInsetsNestedScrollConnection$fling$3(windowInsetsNestedScrollConnection, valueOf3, i2, f2, windowInsetsAnimationController, z2, null), windowInsetsNestedScrollConnection$fling$1) != coroutine_suspended) {
                        j4 = j2;
                        windowInsetsNestedScrollConnection3 = windowInsetsNestedScrollConnection;
                        return Velocity.m6913boximpl(windowInsetsNestedScrollConnection3.sideCalculator.mo767consumedVelocityQWom1Mo(j4, 0.0f));
                    }
                }
                return coroutine_suspended;
            }
        }
        windowInsetsNestedScrollConnection$fling$1 = new WindowInsetsNestedScrollConnection$fling$1(this, continuation);
        Object obj2 = windowInsetsNestedScrollConnection$fling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = windowInsetsNestedScrollConnection$fling$1.label;
        if (i != 0) {
        }
        windowInsetsAnimationController = (WindowInsetsAnimationController) obj2;
        if (windowInsetsAnimationController != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustInsets(float f) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(windowInsetsAnimationController.getCurrentInsets(), Math.round(f)), 1.0f, 0.0f);
        }
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i) {
        this.animationController = windowInsetsAnimationController;
        this.isControllerRequested = false;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume((CancellableContinuation<? super WindowInsetsAnimationController>) windowInsetsAnimationController, (Function1<? super Throwable, Unit>) new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$onReady$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }
            });
        }
        this.continuation = null;
    }

    public final void dispose() {
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume((CancellableContinuation<? super WindowInsetsAnimationController>) null, new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$dispose$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }
            });
        }
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.finish(!Intrinsics.areEqual(windowInsetsAnimationController.getCurrentInsets(), windowInsetsAnimationController.getHiddenStateInsets()));
        }
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
        animationEnded();
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
        animationEnded();
    }

    private final void animationEnded() {
        WindowInsetsAnimationController windowInsetsAnimationController;
        WindowInsetsAnimationController windowInsetsAnimationController2 = this.animationController;
        if (windowInsetsAnimationController2 != null && windowInsetsAnimationController2.isReady() && (windowInsetsAnimationController = this.animationController) != null) {
            windowInsetsAnimationController.finish(this.windowInsets.isVisible());
        }
        this.animationController = null;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume((CancellableContinuation<? super WindowInsetsAnimationController>) null, new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }
            });
        }
        this.continuation = null;
        Job job = this.animationJob;
        if (job != null) {
            job.cancel((CancellationException) new WindowInsetsAnimationCancelledException());
        }
        this.animationJob = null;
        this.partialConsumption = 0.0f;
        this.isControllerRequested = false;
    }
}
