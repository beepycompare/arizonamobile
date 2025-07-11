package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.android.volley.DefaultRetryPolicy;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
/* compiled from: LazyLayoutScrollScope.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0082\b\u001a2\u0010\f\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0080@¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0016"}, d2 = {"BoundDistance", "Landroidx/compose/ui/unit/Dp;", "F", "DEBUG", "", "MinimumDistance", "TargetDistance", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "animateScrollToItem", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", FirebaseAnalytics.Param.INDEX, "", "scrollOffset", "numOfItemsForTeleport", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;IIILandroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isItemVisible", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutScrollScopeKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = Dp.m6684constructorimpl((float) DefaultRetryPolicy.DEFAULT_TIMEOUT_MS);
    private static final float BoundDistance = Dp.m6684constructorimpl((float) ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
    private static final float MinimumDistance = Dp.m6684constructorimpl(50);

    private static final void debugLog(Function0<String> function0) {
    }

    public static final boolean isItemVisible(LazyLayoutScrollScope lazyLayoutScrollScope, int i) {
        return i <= lazyLayoutScrollScope.getLastVisibleItemIndex() && lazyLayoutScrollScope.getFirstVisibleItemIndex() <= i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00eb A[Catch: ItemFoundInScroll -> 0x01ea, TryCatch #3 {ItemFoundInScroll -> 0x01ea, blocks: (B:35:0x00e7, B:37:0x00eb, B:39:0x00f1, B:53:0x0120, B:57:0x015c), top: B:112:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x024e  */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Type inference failed for: r8v16, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x01b6 -> B:18:0x0073). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object animateScrollToItem(LazyLayoutScrollScope lazyLayoutScrollScope, int i, int i2, int i3, Density density, Continuation<? super Unit> continuation) {
        LazyLayoutScrollScopeKt$animateScrollToItem$1 lazyLayoutScrollScopeKt$animateScrollToItem$1;
        Object coroutine_suspended;
        int i4;
        float f;
        final LazyLayoutScrollScope lazyLayoutScrollScope2;
        int i5;
        int i6;
        int i7;
        float mo389toPx0680j_4;
        float mo389toPx0680j_42;
        float mo389toPx0680j_43;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef objectRef;
        final int i8;
        final int i9;
        final float f2;
        final Ref.IntRef intRef;
        float f3;
        LazyLayoutScrollScopeKt$animateScrollToItem$1 lazyLayoutScrollScopeKt$animateScrollToItem$12;
        float f4;
        int i10;
        int i11;
        LazyLayoutScrollScope lazyLayoutScrollScope3;
        AnimationState copy$default;
        final float itemOffset;
        final Ref.FloatRef floatRef;
        Float boxFloat;
        int i12;
        LazyLayoutScrollScope lazyLayoutScrollScope4;
        int i13;
        int i14;
        LazyLayoutScrollScopeKt$animateScrollToItem$1 lazyLayoutScrollScopeKt$animateScrollToItem$13;
        int calculateDistanceTo$default;
        float f5;
        final float f6;
        AnimationState animationState;
        Float boxFloat2;
        boolean z;
        final LazyLayoutScrollScope lazyLayoutScrollScope5;
        final int i15;
        int i16;
        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1;
        if (continuation instanceof LazyLayoutScrollScopeKt$animateScrollToItem$1) {
            lazyLayoutScrollScopeKt$animateScrollToItem$1 = (LazyLayoutScrollScopeKt$animateScrollToItem$1) continuation;
            if ((lazyLayoutScrollScopeKt$animateScrollToItem$1.label & Integer.MIN_VALUE) != 0) {
                lazyLayoutScrollScopeKt$animateScrollToItem$1.label -= Integer.MIN_VALUE;
                Object obj = lazyLayoutScrollScopeKt$animateScrollToItem$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i4 = lazyLayoutScrollScopeKt$animateScrollToItem$1.label;
                int i17 = 0;
                int i18 = 1;
                if (i4 != 0) {
                    f = 0.0f;
                    ResultKt.throwOnFailure(obj);
                    if (!(((float) i) >= 0.0f)) {
                        InlineClassHelperKt.throwIllegalArgumentException("Index should be non-negative");
                    }
                    try {
                        mo389toPx0680j_4 = density.mo389toPx0680j_4(TargetDistance);
                        mo389toPx0680j_42 = density.mo389toPx0680j_4(BoundDistance);
                        mo389toPx0680j_43 = density.mo389toPx0680j_4(MinimumDistance);
                        booleanRef = new Ref.BooleanRef();
                        booleanRef.element = true;
                        objectRef = new Ref.ObjectRef();
                        objectRef.element = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0L, 0L, false, 30, null);
                    } catch (ItemFoundInScroll e) {
                        e = e;
                        lazyLayoutScrollScope2 = lazyLayoutScrollScope;
                        i5 = 0;
                    }
                    if (isItemVisible(lazyLayoutScrollScope, i)) {
                        lazyLayoutScrollScope2 = lazyLayoutScrollScope;
                        i5 = 0;
                        try {
                            throw new ItemFoundInScroll(LazyLayoutScrollScope.calculateDistanceTo$default(lazyLayoutScrollScope2, i, 0, 2, null), (AnimationState) objectRef.element);
                        } catch (ItemFoundInScroll e2) {
                            e = e2;
                            i6 = i2;
                            i7 = i;
                            copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                            itemOffset = e.getItemOffset() + i6;
                            floatRef = new Ref.FloatRef();
                            boxFloat = Boxing.boxFloat(itemOffset);
                            if (((Number) copy$default.getVelocity()).floatValue() == f) {
                            }
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.L$0 = lazyLayoutScrollScope2;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.L$1 = null;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.L$2 = null;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.L$3 = null;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.I$0 = i7;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.I$1 = i6;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.label = 2;
                            if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, i12 ^ 1, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$6
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    invoke2(animationScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    float f7 = itemOffset;
                                    float f8 = 0.0f;
                                    if (f7 > 0.0f) {
                                        f8 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset);
                                    } else if (f7 < 0.0f) {
                                        f8 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset);
                                    }
                                    float f9 = f8 - floatRef.element;
                                    if (f9 != lazyLayoutScrollScope2.scrollBy(f9) || f8 != animationScope.getValue().floatValue()) {
                                        animationScope.cancelAnimation();
                                    }
                                    floatRef.element += f9;
                                }
                            }, lazyLayoutScrollScopeKt$animateScrollToItem$1, 2, null) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                    }
                    try {
                        int i19 = i > lazyLayoutScrollScope.getFirstVisibleItemIndex() ? 1 : 0;
                        Ref.IntRef intRef2 = new Ref.IntRef();
                        intRef2.element = 1;
                        i8 = i2;
                        i9 = i3;
                        f2 = mo389toPx0680j_42;
                        intRef = intRef2;
                        f3 = mo389toPx0680j_4;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12 = lazyLayoutScrollScopeKt$animateScrollToItem$1;
                        f4 = mo389toPx0680j_43;
                        i10 = i;
                        i11 = i19;
                        lazyLayoutScrollScope3 = lazyLayoutScrollScope;
                        if (booleanRef.element) {
                        }
                    } catch (ItemFoundInScroll e3) {
                        e = e3;
                        lazyLayoutScrollScope2 = lazyLayoutScrollScope;
                        i6 = i2;
                        i7 = i;
                        i5 = 0;
                        copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                        itemOffset = e.getItemOffset() + i6;
                        floatRef = new Ref.FloatRef();
                        boxFloat = Boxing.boxFloat(itemOffset);
                        if (((Number) copy$default.getVelocity()).floatValue() == f) {
                        }
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.L$0 = lazyLayoutScrollScope2;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.L$1 = null;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.L$2 = null;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.L$3 = null;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.I$0 = i7;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.I$1 = i6;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.label = 2;
                        if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, i12 ^ 1, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$6
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                invoke2(animationScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                float f7 = itemOffset;
                                float f8 = 0.0f;
                                if (f7 > 0.0f) {
                                    f8 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset);
                                } else if (f7 < 0.0f) {
                                    f8 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset);
                                }
                                float f9 = f8 - floatRef.element;
                                if (f9 != lazyLayoutScrollScope2.scrollBy(f9) || f8 != animationScope.getValue().floatValue()) {
                                    animationScope.cancelAnimation();
                                }
                                floatRef.element += f9;
                            }
                        }, lazyLayoutScrollScopeKt$animateScrollToItem$1, 2, null) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                } else if (i4 != 1) {
                    if (i4 == 2) {
                        i13 = lazyLayoutScrollScopeKt$animateScrollToItem$1.I$1;
                        i14 = lazyLayoutScrollScopeKt$animateScrollToItem$1.I$0;
                        lazyLayoutScrollScope4 = (LazyLayoutScrollScope) lazyLayoutScrollScopeKt$animateScrollToItem$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        lazyLayoutScrollScope4.snapToItem(i14, i13);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    i11 = lazyLayoutScrollScopeKt$animateScrollToItem$1.I$3;
                    float f7 = lazyLayoutScrollScopeKt$animateScrollToItem$1.F$2;
                    float f8 = lazyLayoutScrollScopeKt$animateScrollToItem$1.F$1;
                    f3 = lazyLayoutScrollScopeKt$animateScrollToItem$1.F$0;
                    int i20 = lazyLayoutScrollScopeKt$animateScrollToItem$1.I$2;
                    int i21 = lazyLayoutScrollScopeKt$animateScrollToItem$1.I$1;
                    i7 = lazyLayoutScrollScopeKt$animateScrollToItem$1.I$0;
                    Ref.IntRef intRef3 = (Ref.IntRef) lazyLayoutScrollScopeKt$animateScrollToItem$1.L$3;
                    f = 0.0f;
                    Ref.ObjectRef objectRef2 = (Ref.ObjectRef) lazyLayoutScrollScopeKt$animateScrollToItem$1.L$2;
                    Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) lazyLayoutScrollScopeKt$animateScrollToItem$1.L$1;
                    LazyLayoutScrollScope lazyLayoutScrollScope6 = (LazyLayoutScrollScope) lazyLayoutScrollScopeKt$animateScrollToItem$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        objectRef = objectRef2;
                        booleanRef = booleanRef2;
                        f2 = f8;
                        i16 = i20;
                        i8 = i21;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12 = lazyLayoutScrollScopeKt$animateScrollToItem$1;
                        f4 = f7;
                        lazyLayoutScrollScope3 = lazyLayoutScrollScope6;
                        i10 = i7;
                    } catch (ItemFoundInScroll e4) {
                        e = e4;
                        lazyLayoutScrollScope2 = lazyLayoutScrollScope6;
                        i5 = 0;
                        i6 = i21;
                    }
                    try {
                        try {
                            intRef3.element++;
                        } catch (ItemFoundInScroll e5) {
                            e = e5;
                            i7 = i10;
                            lazyLayoutScrollScopeKt$animateScrollToItem$13 = lazyLayoutScrollScopeKt$animateScrollToItem$12;
                            i6 = i8;
                            lazyLayoutScrollScope2 = lazyLayoutScrollScope3;
                        }
                        i9 = i16;
                        intRef = intRef3;
                        i17 = 0;
                        i18 = 1;
                    } catch (ItemFoundInScroll e6) {
                        e = e6;
                        i7 = i10;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1 = lazyLayoutScrollScopeKt$animateScrollToItem$12;
                        i6 = i8;
                        i5 = 0;
                        lazyLayoutScrollScope2 = lazyLayoutScrollScope3;
                        copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                        itemOffset = e.getItemOffset() + i6;
                        floatRef = new Ref.FloatRef();
                        boxFloat = Boxing.boxFloat(itemOffset);
                        if (((Number) copy$default.getVelocity()).floatValue() == f) {
                        }
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.L$0 = lazyLayoutScrollScope2;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.L$1 = null;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.L$2 = null;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.L$3 = null;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.I$0 = i7;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.I$1 = i6;
                        lazyLayoutScrollScopeKt$animateScrollToItem$1.label = 2;
                        if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, i12 ^ 1, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$6
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                invoke2(animationScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                float f72 = itemOffset;
                                float f82 = 0.0f;
                                if (f72 > 0.0f) {
                                    f82 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset);
                                } else if (f72 < 0.0f) {
                                    f82 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset);
                                }
                                float f9 = f82 - floatRef.element;
                                if (f9 != lazyLayoutScrollScope2.scrollBy(f9) || f82 != animationScope.getValue().floatValue()) {
                                    animationScope.cancelAnimation();
                                }
                                floatRef.element += f9;
                            }
                        }, lazyLayoutScrollScopeKt$animateScrollToItem$1, 2, null) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (booleanRef.element && lazyLayoutScrollScope3.getItemCount() > 0) {
                        try {
                            try {
                                try {
                                    calculateDistanceTo$default = LazyLayoutScrollScope.calculateDistanceTo$default(lazyLayoutScrollScope3, i10, i17, 2, null) + i8;
                                } catch (ItemFoundInScroll e7) {
                                    e = e7;
                                    lazyLayoutScrollScopeKt$animateScrollToItem$13 = lazyLayoutScrollScopeKt$animateScrollToItem$12;
                                    lazyLayoutScrollScope2 = lazyLayoutScrollScope5;
                                    i7 = i15;
                                    i6 = i8;
                                }
                            } catch (ItemFoundInScroll e8) {
                                e = e8;
                                lazyLayoutScrollScopeKt$animateScrollToItem$13 = lazyLayoutScrollScopeKt$animateScrollToItem$12;
                            }
                        } catch (ItemFoundInScroll e9) {
                            e = e9;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1 = lazyLayoutScrollScopeKt$animateScrollToItem$13;
                            i5 = 0;
                            copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                            itemOffset = e.getItemOffset() + i6;
                            floatRef = new Ref.FloatRef();
                            boxFloat = Boxing.boxFloat(itemOffset);
                            if (((Number) copy$default.getVelocity()).floatValue() == f) {
                            }
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.L$0 = lazyLayoutScrollScope2;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.L$1 = null;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.L$2 = null;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.L$3 = null;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.I$0 = i7;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.I$1 = i6;
                            lazyLayoutScrollScopeKt$animateScrollToItem$1.label = 2;
                            if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, i12 ^ 1, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$6
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    invoke2(animationScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    float f72 = itemOffset;
                                    float f82 = 0.0f;
                                    if (f72 > 0.0f) {
                                        f82 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset);
                                    } else if (f72 < 0.0f) {
                                        f82 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset);
                                    }
                                    float f9 = f82 - floatRef.element;
                                    if (f9 != lazyLayoutScrollScope2.scrollBy(f9) || f82 != animationScope.getValue().floatValue()) {
                                        animationScope.cancelAnimation();
                                    }
                                    floatRef.element += f9;
                                }
                            }, lazyLayoutScrollScopeKt$animateScrollToItem$1, 2, null) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        if (Math.abs(calculateDistanceTo$default) < f3) {
                            if (i11 != 0) {
                                f6 = f3;
                                objectRef.element = AnimationStateKt.copy$default((AnimationState) objectRef.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                                final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                                animationState = (AnimationState) objectRef.element;
                                boxFloat2 = Boxing.boxFloat(f6);
                                z = (((Number) ((AnimationState) objectRef.element).getVelocity()).floatValue() != f ? i18 : i17) ^ i18;
                                final boolean z2 = i11 == 0 ? i18 : i17;
                                lazyLayoutScrollScope5 = lazyLayoutScrollScope3;
                                i15 = i10;
                                final Ref.BooleanRef booleanRef3 = booleanRef;
                                final Ref.ObjectRef objectRef3 = objectRef;
                                lazyLayoutScrollScope2 = lazyLayoutScrollScope5;
                                i7 = i15;
                                float f9 = f2;
                                intRef3 = intRef;
                                i16 = i9;
                                i6 = i8;
                                function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$4
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                        invoke2(animationScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                        boolean animateScrollToItem$isOvershot;
                                        float coerceAtLeast;
                                        boolean animateScrollToItem$isOvershot2;
                                        if (!LazyLayoutScrollScopeKt.isItemVisible(LazyLayoutScrollScope.this, i15)) {
                                            if (f6 > 0.0f) {
                                                coerceAtLeast = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), f6);
                                            } else {
                                                coerceAtLeast = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), f6);
                                            }
                                            float f10 = coerceAtLeast - floatRef2.element;
                                            float scrollBy = LazyLayoutScrollScope.this.scrollBy(f10);
                                            if (!LazyLayoutScrollScopeKt.isItemVisible(LazyLayoutScrollScope.this, i15)) {
                                                animateScrollToItem$isOvershot2 = LazyLayoutScrollScopeKt.animateScrollToItem$isOvershot(z2, LazyLayoutScrollScope.this, i15, i8);
                                                if (!animateScrollToItem$isOvershot2) {
                                                    if (f10 != scrollBy) {
                                                        animationScope.cancelAnimation();
                                                        booleanRef3.element = false;
                                                        return;
                                                    }
                                                    floatRef2.element += f10;
                                                    if (z2) {
                                                        if (animationScope.getValue().floatValue() > f2) {
                                                            animationScope.cancelAnimation();
                                                        }
                                                    } else if (animationScope.getValue().floatValue() < (-f2)) {
                                                        animationScope.cancelAnimation();
                                                    }
                                                    if (z2) {
                                                        if (intRef.element >= 2) {
                                                            int lastVisibleItemIndex = i15 - LazyLayoutScrollScope.this.getLastVisibleItemIndex();
                                                            int i22 = i9;
                                                            if (lastVisibleItemIndex > i22) {
                                                                LazyLayoutScrollScope.this.snapToItem(i15 - i22, 0);
                                                            }
                                                        }
                                                    } else if (intRef.element >= 2) {
                                                        int firstVisibleItemIndex = LazyLayoutScrollScope.this.getFirstVisibleItemIndex();
                                                        int i23 = i15;
                                                        int i24 = firstVisibleItemIndex - i23;
                                                        int i25 = i9;
                                                        if (i24 > i25) {
                                                            LazyLayoutScrollScope.this.snapToItem(i23 + i25, 0);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        animateScrollToItem$isOvershot = LazyLayoutScrollScopeKt.animateScrollToItem$isOvershot(z2, LazyLayoutScrollScope.this, i15, i8);
                                        if (animateScrollToItem$isOvershot) {
                                            LazyLayoutScrollScope.this.snapToItem(i15, i8);
                                            booleanRef3.element = false;
                                            animationScope.cancelAnimation();
                                        } else if (LazyLayoutScrollScopeKt.isItemVisible(LazyLayoutScrollScope.this, i15)) {
                                            throw new ItemFoundInScroll(LazyLayoutScrollScope.calculateDistanceTo$default(LazyLayoutScrollScope.this, i15, 0, 2, null), objectRef3.element);
                                        }
                                    }
                                };
                                lazyLayoutScrollScopeKt$animateScrollToItem$12.L$0 = lazyLayoutScrollScope2;
                                lazyLayoutScrollScopeKt$animateScrollToItem$12.L$1 = booleanRef3;
                                lazyLayoutScrollScopeKt$animateScrollToItem$12.L$2 = objectRef3;
                                lazyLayoutScrollScopeKt$animateScrollToItem$12.L$3 = intRef3;
                                lazyLayoutScrollScopeKt$animateScrollToItem$12.I$0 = i7;
                                lazyLayoutScrollScopeKt$animateScrollToItem$12.I$1 = i6;
                                lazyLayoutScrollScopeKt$animateScrollToItem$12.I$2 = i16;
                                lazyLayoutScrollScopeKt$animateScrollToItem$12.F$0 = f3;
                                lazyLayoutScrollScopeKt$animateScrollToItem$12.F$1 = f9;
                                lazyLayoutScrollScopeKt$animateScrollToItem$12.F$2 = f4;
                                lazyLayoutScrollScopeKt$animateScrollToItem$12.I$3 = i11;
                                lazyLayoutScrollScopeKt$animateScrollToItem$12.label = 1;
                                lazyLayoutScrollScopeKt$animateScrollToItem$13 = lazyLayoutScrollScopeKt$animateScrollToItem$12;
                                if (SuspendAnimationKt.animateTo$default(animationState, boxFloat2, null, z, function1, lazyLayoutScrollScopeKt$animateScrollToItem$13, 2, null) != coroutine_suspended) {
                                    objectRef = objectRef3;
                                    booleanRef = booleanRef3;
                                    lazyLayoutScrollScope3 = lazyLayoutScrollScope2;
                                    lazyLayoutScrollScopeKt$animateScrollToItem$12 = lazyLayoutScrollScopeKt$animateScrollToItem$13;
                                    f2 = f9;
                                    i8 = i6;
                                    i10 = i7;
                                    intRef3.element++;
                                    i9 = i16;
                                    intRef = intRef3;
                                    i17 = 0;
                                    i18 = 1;
                                    if (booleanRef.element) {
                                        calculateDistanceTo$default = LazyLayoutScrollScope.calculateDistanceTo$default(lazyLayoutScrollScope3, i10, i17, 2, null) + i8;
                                        if (Math.abs(calculateDistanceTo$default) < f3) {
                                            try {
                                                f5 = Math.max(Math.abs(calculateDistanceTo$default), f4);
                                                if (i11 == 0) {
                                                    f5 = -f5;
                                                }
                                            } catch (ItemFoundInScroll e10) {
                                                e = e10;
                                                i7 = i10;
                                                lazyLayoutScrollScopeKt$animateScrollToItem$1 = lazyLayoutScrollScopeKt$animateScrollToItem$12;
                                                i5 = i17;
                                                i6 = i8;
                                                lazyLayoutScrollScope2 = lazyLayoutScrollScope3;
                                                copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                                                itemOffset = e.getItemOffset() + i6;
                                                floatRef = new Ref.FloatRef();
                                                boxFloat = Boxing.boxFloat(itemOffset);
                                                if (((Number) copy$default.getVelocity()).floatValue() == f) {
                                                }
                                                lazyLayoutScrollScopeKt$animateScrollToItem$1.L$0 = lazyLayoutScrollScope2;
                                                lazyLayoutScrollScopeKt$animateScrollToItem$1.L$1 = null;
                                                lazyLayoutScrollScopeKt$animateScrollToItem$1.L$2 = null;
                                                lazyLayoutScrollScopeKt$animateScrollToItem$1.L$3 = null;
                                                lazyLayoutScrollScopeKt$animateScrollToItem$1.I$0 = i7;
                                                lazyLayoutScrollScopeKt$animateScrollToItem$1.I$1 = i6;
                                                lazyLayoutScrollScopeKt$animateScrollToItem$1.label = 2;
                                                if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, i12 ^ 1, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$6
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                                        invoke2(animationScope);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                    public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                                        float f72 = itemOffset;
                                                        float f82 = 0.0f;
                                                        if (f72 > 0.0f) {
                                                            f82 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset);
                                                        } else if (f72 < 0.0f) {
                                                            f82 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset);
                                                        }
                                                        float f92 = f82 - floatRef.element;
                                                        if (f92 != lazyLayoutScrollScope2.scrollBy(f92) || f82 != animationScope.getValue().floatValue()) {
                                                            animationScope.cancelAnimation();
                                                        }
                                                        floatRef.element += f92;
                                                    }
                                                }, lazyLayoutScrollScopeKt$animateScrollToItem$1, 2, null) != coroutine_suspended) {
                                                }
                                                return coroutine_suspended;
                                            }
                                        }
                                    }
                                }
                                return coroutine_suspended;
                            }
                            f5 = -f3;
                        }
                        f6 = f5;
                        objectRef.element = AnimationStateKt.copy$default((AnimationState) objectRef.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                        final Ref.FloatRef floatRef22 = new Ref.FloatRef();
                        animationState = (AnimationState) objectRef.element;
                        boxFloat2 = Boxing.boxFloat(f6);
                        z = (((Number) ((AnimationState) objectRef.element).getVelocity()).floatValue() != f ? i18 : i17) ^ i18;
                        if (i11 == 0) {
                        }
                        lazyLayoutScrollScope5 = lazyLayoutScrollScope3;
                        i15 = i10;
                        final Ref.BooleanRef booleanRef32 = booleanRef;
                        final Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef32 = objectRef;
                        lazyLayoutScrollScope2 = lazyLayoutScrollScope5;
                        i7 = i15;
                        float f92 = f2;
                        intRef3 = intRef;
                        i16 = i9;
                        i6 = i8;
                        function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$4
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                invoke2(animationScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                boolean animateScrollToItem$isOvershot;
                                float coerceAtLeast;
                                boolean animateScrollToItem$isOvershot2;
                                if (!LazyLayoutScrollScopeKt.isItemVisible(LazyLayoutScrollScope.this, i15)) {
                                    if (f6 > 0.0f) {
                                        coerceAtLeast = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), f6);
                                    } else {
                                        coerceAtLeast = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), f6);
                                    }
                                    float f10 = coerceAtLeast - floatRef22.element;
                                    float scrollBy = LazyLayoutScrollScope.this.scrollBy(f10);
                                    if (!LazyLayoutScrollScopeKt.isItemVisible(LazyLayoutScrollScope.this, i15)) {
                                        animateScrollToItem$isOvershot2 = LazyLayoutScrollScopeKt.animateScrollToItem$isOvershot(z2, LazyLayoutScrollScope.this, i15, i8);
                                        if (!animateScrollToItem$isOvershot2) {
                                            if (f10 != scrollBy) {
                                                animationScope.cancelAnimation();
                                                booleanRef32.element = false;
                                                return;
                                            }
                                            floatRef22.element += f10;
                                            if (z2) {
                                                if (animationScope.getValue().floatValue() > f2) {
                                                    animationScope.cancelAnimation();
                                                }
                                            } else if (animationScope.getValue().floatValue() < (-f2)) {
                                                animationScope.cancelAnimation();
                                            }
                                            if (z2) {
                                                if (intRef.element >= 2) {
                                                    int lastVisibleItemIndex = i15 - LazyLayoutScrollScope.this.getLastVisibleItemIndex();
                                                    int i22 = i9;
                                                    if (lastVisibleItemIndex > i22) {
                                                        LazyLayoutScrollScope.this.snapToItem(i15 - i22, 0);
                                                    }
                                                }
                                            } else if (intRef.element >= 2) {
                                                int firstVisibleItemIndex = LazyLayoutScrollScope.this.getFirstVisibleItemIndex();
                                                int i23 = i15;
                                                int i24 = firstVisibleItemIndex - i23;
                                                int i25 = i9;
                                                if (i24 > i25) {
                                                    LazyLayoutScrollScope.this.snapToItem(i23 + i25, 0);
                                                }
                                            }
                                        }
                                    }
                                }
                                animateScrollToItem$isOvershot = LazyLayoutScrollScopeKt.animateScrollToItem$isOvershot(z2, LazyLayoutScrollScope.this, i15, i8);
                                if (animateScrollToItem$isOvershot) {
                                    LazyLayoutScrollScope.this.snapToItem(i15, i8);
                                    booleanRef32.element = false;
                                    animationScope.cancelAnimation();
                                } else if (LazyLayoutScrollScopeKt.isItemVisible(LazyLayoutScrollScope.this, i15)) {
                                    throw new ItemFoundInScroll(LazyLayoutScrollScope.calculateDistanceTo$default(LazyLayoutScrollScope.this, i15, 0, 2, null), objectRef32.element);
                                }
                            }
                        };
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$0 = lazyLayoutScrollScope2;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$1 = booleanRef32;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$2 = objectRef32;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$3 = intRef3;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.I$0 = i7;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.I$1 = i6;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.I$2 = i16;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.F$0 = f3;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.F$1 = f92;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.F$2 = f4;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.I$3 = i11;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.label = 1;
                        lazyLayoutScrollScopeKt$animateScrollToItem$13 = lazyLayoutScrollScopeKt$animateScrollToItem$12;
                        if (SuspendAnimationKt.animateTo$default(animationState, boxFloat2, null, z, function1, lazyLayoutScrollScopeKt$animateScrollToItem$13, 2, null) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                itemOffset = e.getItemOffset() + i6;
                floatRef = new Ref.FloatRef();
                boxFloat = Boxing.boxFloat(itemOffset);
                i12 = ((Number) copy$default.getVelocity()).floatValue() == f ? 1 : i5;
                lazyLayoutScrollScopeKt$animateScrollToItem$1.L$0 = lazyLayoutScrollScope2;
                lazyLayoutScrollScopeKt$animateScrollToItem$1.L$1 = null;
                lazyLayoutScrollScopeKt$animateScrollToItem$1.L$2 = null;
                lazyLayoutScrollScopeKt$animateScrollToItem$1.L$3 = null;
                lazyLayoutScrollScopeKt$animateScrollToItem$1.I$0 = i7;
                lazyLayoutScrollScopeKt$animateScrollToItem$1.I$1 = i6;
                lazyLayoutScrollScopeKt$animateScrollToItem$1.label = 2;
                if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, i12 ^ 1, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$6
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                        invoke2(animationScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                        float f72 = itemOffset;
                        float f82 = 0.0f;
                        if (f72 > 0.0f) {
                            f82 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset);
                        } else if (f72 < 0.0f) {
                            f82 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset);
                        }
                        float f922 = f82 - floatRef.element;
                        if (f922 != lazyLayoutScrollScope2.scrollBy(f922) || f82 != animationScope.getValue().floatValue()) {
                            animationScope.cancelAnimation();
                        }
                        floatRef.element += f922;
                    }
                }, lazyLayoutScrollScopeKt$animateScrollToItem$1, 2, null) != coroutine_suspended) {
                    lazyLayoutScrollScope4 = lazyLayoutScrollScope2;
                    i13 = i6;
                    i14 = i7;
                    lazyLayoutScrollScope4.snapToItem(i14, i13);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
        }
        lazyLayoutScrollScopeKt$animateScrollToItem$1 = new LazyLayoutScrollScopeKt$animateScrollToItem$1(continuation);
        Object obj2 = lazyLayoutScrollScopeKt$animateScrollToItem$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i4 = lazyLayoutScrollScopeKt$animateScrollToItem$1.label;
        int i172 = 0;
        int i182 = 1;
        if (i4 != 0) {
        }
        copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
        itemOffset = e.getItemOffset() + i6;
        floatRef = new Ref.FloatRef();
        boxFloat = Boxing.boxFloat(itemOffset);
        if (((Number) copy$default.getVelocity()).floatValue() == f) {
        }
        lazyLayoutScrollScopeKt$animateScrollToItem$1.L$0 = lazyLayoutScrollScope2;
        lazyLayoutScrollScopeKt$animateScrollToItem$1.L$1 = null;
        lazyLayoutScrollScopeKt$animateScrollToItem$1.L$2 = null;
        lazyLayoutScrollScopeKt$animateScrollToItem$1.L$3 = null;
        lazyLayoutScrollScopeKt$animateScrollToItem$1.I$0 = i7;
        lazyLayoutScrollScopeKt$animateScrollToItem$1.I$1 = i6;
        lazyLayoutScrollScopeKt$animateScrollToItem$1.label = 2;
        if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, i12 ^ 1, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                invoke2(animationScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                float f72 = itemOffset;
                float f82 = 0.0f;
                if (f72 > 0.0f) {
                    f82 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset);
                } else if (f72 < 0.0f) {
                    f82 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset);
                }
                float f922 = f82 - floatRef.element;
                if (f922 != lazyLayoutScrollScope2.scrollBy(f922) || f82 != animationScope.getValue().floatValue()) {
                    animationScope.cancelAnimation();
                }
                floatRef.element += f922;
            }
        }, lazyLayoutScrollScopeKt$animateScrollToItem$1, 2, null) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean animateScrollToItem$isOvershot(boolean z, LazyLayoutScrollScope lazyLayoutScrollScope, int i, int i2) {
        if (z) {
            if (lazyLayoutScrollScope.getFirstVisibleItemIndex() > i) {
                return true;
            }
            return lazyLayoutScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutScrollScope.getFirstVisibleItemScrollOffset() > i2;
        } else if (lazyLayoutScrollScope.getFirstVisibleItemIndex() < i) {
            return true;
        } else {
            return lazyLayoutScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutScrollScope.getFirstVisibleItemScrollOffset() < i2;
        }
    }
}
