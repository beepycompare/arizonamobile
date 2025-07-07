package androidx.constraintlayout.compose.carousel;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: CarouselSwipeable.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0011\u0018\u0000 r*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001rBB\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\u0010\rJ$\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00062\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@¢\u0006\u0002\u0010_J&\u0010`\u001a\u00020\\2\u0006\u0010M\u001a\u00028\u00002\u000e\b\u0002\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@¢\u0006\u0002\u0010bJ!\u0010c\u001a\u00020\\2\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H\u0000¢\u0006\u0002\beJ\u000e\u0010f\u001a\u00020\u00062\u0006\u0010g\u001a\u00020\u0006J\u0016\u0010h\u001a\u00020\\2\u0006\u0010i\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010jJ8\u0010k\u001a\u00020\\2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H\u0080@¢\u0006\u0004\bm\u0010nJ\u0016\u0010o\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010jJ\u0016\u0010p\u001a\u00020\\2\u0006\u0010M\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010qR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000RC\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR+\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0018\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010%\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R+\u0010,\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0018\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u001102X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010'\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010'\"\u0004\b9\u00106R\u0011\u0010:\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010?\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\b@\u0010=R\u000e\u0010A\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000C8F¢\u0006\u0006\u001a\u0004\bD\u0010ER/\u0010G\u001a\u0004\u0018\u00010F2\b\u0010\u0010\u001a\u0004\u0018\u00010F8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010\u0018\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0011\u0010M\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\bN\u0010!RO\u0010P\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060O2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060O8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bU\u0010\u0018\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR+\u0010V\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\bW\u0010'\"\u0004\bX\u00106¨\u0006s"}, d2 = {"Landroidx/constraintlayout/compose/carousel/CarouselSwipeableState;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "absoluteOffset", "Landroidx/compose/runtime/MutableFloatState;", "<set-?>", "", "anchors", "getAnchors$constraintlayout_compose_release", "()Ljava/util/Map;", "setAnchors$constraintlayout_compose_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$constraintlayout_compose_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "Landroidx/compose/runtime/MutableState;", "getConfirmStateChange$constraintlayout_compose_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "direction", "getDirection", "()F", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$constraintlayout_compose_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "isAnimationRunning", "()Z", "setAnimationRunning", "(Z)V", "isAnimationRunning$delegate", "latestNonEmptyAnchorsFlow", "Lkotlinx/coroutines/flow/Flow;", "maxBound", "getMaxBound$constraintlayout_compose_release", "setMaxBound$constraintlayout_compose_release", "(F)V", "minBound", "getMinBound$constraintlayout_compose_release", "setMinBound$constraintlayout_compose_release", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/runtime/FloatState;", "getOffset", "()Landroidx/compose/runtime/FloatState;", "offsetState", "overflow", "getOverflow", "overflowState", "progress", "Landroidx/constraintlayout/compose/carousel/SwipeProgress;", "getProgress", "()Landroidx/constraintlayout/compose/carousel/SwipeProgress;", "Landroidx/constraintlayout/compose/carousel/ResistanceConfig;", "resistance", "getResistance$constraintlayout_compose_release", "()Landroidx/constraintlayout/compose/carousel/ResistanceConfig;", "setResistance$constraintlayout_compose_release", "(Landroidx/constraintlayout/compose/carousel/ResistanceConfig;)V", "resistance$delegate", "targetValue", "getTargetValue", "Lkotlin/Function2;", "thresholds", "getThresholds$constraintlayout_compose_release", "()Lkotlin/jvm/functions/Function2;", "setThresholds$constraintlayout_compose_release", "(Lkotlin/jvm/functions/Function2;)V", "thresholds$delegate", "velocityThreshold", "getVelocityThreshold$constraintlayout_compose_release", "setVelocityThreshold$constraintlayout_compose_release", "velocityThreshold$delegate", "Landroidx/compose/runtime/MutableFloatState;", "animateInternalToOffset", "", TypedValues.AttributesType.S_TARGET, "spec", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "anim", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureInit", "newAnchors", "ensureInit$constraintlayout_compose_release", "performDrag", "delta", "performFling", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNewAnchors", "oldAnchors", "processNewAnchors$constraintlayout_compose_release", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapInternalToOffset", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public class CarouselSwipeableState<T> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final MutableFloatState absoluteOffset;
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState<Float> animationTarget;
    private final Function1<T, Boolean> confirmStateChange;
    private final MutableState currentValue$delegate;
    private final DraggableState draggableState;
    private final MutableState isAnimationRunning$delegate;
    private final Flow<Map<Float, T>> latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;
    private final MutableFloatState offsetState;
    private final MutableFloatState overflowState;
    private final MutableState resistance$delegate;
    private final MutableState thresholds$delegate;
    private final MutableFloatState velocityThreshold$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public CarouselSwipeableState(T t, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState<Float> mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        this.animationSpec = animationSpec;
        this.confirmStateChange = function1;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.currentValue$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isAnimationRunning$delegate = mutableStateOf$default2;
        this.offsetState = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.overflowState = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.absoluteOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.animationTarget = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
        this.anchors$delegate = mutableStateOf$default4;
        final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Map<Float, ? extends T>>(this) { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$latestNonEmptyAnchorsFlow$1
            final /* synthetic */ CarouselSwipeableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<Float, T> invoke() {
                return this.this$0.getAnchors$constraintlayout_compose_release();
            }
        });
        this.latestNonEmptyAnchorsFlow = FlowKt.take(new Flow<Map<Float, ? extends T>>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1$2", f = "CarouselSwipeable.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                /* renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1$2$1  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (!((Map) obj).isEmpty()) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, 1);
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Function2<Float, Float, Float>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$thresholds$2
            public final Float invoke(float f, float f2) {
                return Float.valueOf(0.0f);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Float invoke(Float f, Float f2) {
                return invoke(f.floatValue(), f2.floatValue());
            }
        }, null, 2, null);
        this.thresholds$delegate = mutableStateOf$default5;
        this.velocityThreshold$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.resistance$delegate = mutableStateOf$default6;
        this.draggableState = DraggableKt.DraggableState(new Function1<Float, Unit>(this) { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$draggableState$1
            final /* synthetic */ CarouselSwipeableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke(f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                MutableFloatState mutableFloatState;
                MutableFloatState mutableFloatState2;
                MutableFloatState mutableFloatState3;
                MutableFloatState mutableFloatState4;
                mutableFloatState = ((CarouselSwipeableState) this.this$0).absoluteOffset;
                float floatValue = mutableFloatState.getFloatValue() + f;
                float coerceIn = RangesKt.coerceIn(floatValue, this.this$0.getMinBound$constraintlayout_compose_release(), this.this$0.getMaxBound$constraintlayout_compose_release());
                float f2 = floatValue - coerceIn;
                ResistanceConfig resistance$constraintlayout_compose_release = this.this$0.getResistance$constraintlayout_compose_release();
                float computeResistance = resistance$constraintlayout_compose_release != null ? resistance$constraintlayout_compose_release.computeResistance(f2) : 0.0f;
                mutableFloatState2 = ((CarouselSwipeableState) this.this$0).offsetState;
                mutableFloatState2.setFloatValue(coerceIn + computeResistance);
                mutableFloatState3 = ((CarouselSwipeableState) this.this$0).overflowState;
                mutableFloatState3.setFloatValue(f2);
                mutableFloatState4 = ((CarouselSwipeableState) this.this$0).absoluteOffset;
                mutableFloatState4.setFloatValue(floatValue);
            }
        });
    }

    public /* synthetic */ CarouselSwipeableState(Object obj, SpringSpec<Float> springSpec, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : springSpec, (i & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(T t) {
                return true;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj2) {
                return invoke((AnonymousClass1) obj2);
            }
        } : anonymousClass1);
    }

    public final AnimationSpec<Float> getAnimationSpec$constraintlayout_compose_release() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmStateChange$constraintlayout_compose_release() {
        return this.confirmStateChange;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationRunning(boolean z) {
        this.isAnimationRunning$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning$delegate.getValue()).booleanValue();
    }

    public final FloatState getOffset() {
        return this.offsetState;
    }

    public final FloatState getOverflow() {
        return this.overflowState;
    }

    public final Map<Float, T> getAnchors$constraintlayout_compose_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final void setAnchors$constraintlayout_compose_release(Map<Float, ? extends T> map) {
        this.anchors$delegate.setValue(map);
    }

    public final float getMinBound$constraintlayout_compose_release() {
        return this.minBound;
    }

    public final void setMinBound$constraintlayout_compose_release(float f) {
        this.minBound = f;
    }

    public final float getMaxBound$constraintlayout_compose_release() {
        return this.maxBound;
    }

    public final void setMaxBound$constraintlayout_compose_release(float f) {
        this.maxBound = f;
    }

    public final void ensureInit$constraintlayout_compose_release(Map<Float, ? extends T> map) {
        Float offset;
        if (getAnchors$constraintlayout_compose_release().isEmpty()) {
            offset = CarouselSwipeableKt.getOffset(map, getCurrentValue());
            if (offset == null) {
                throw new IllegalArgumentException("The initial value must have an associated anchor.".toString());
            }
            this.offsetState.setFloatValue(offset.floatValue());
            this.absoluteOffset.setFloatValue(offset.floatValue());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
        if (snapInternalToOffset(r10, r0) == r1) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0215  */
    /* JADX WARN: Type inference failed for: r10v21, types: [float] */
    /* JADX WARN: Type inference failed for: r10v76, types: [float] */
    /* JADX WARN: Type inference failed for: r10v78, types: [float] */
    /* JADX WARN: Type inference failed for: r10v89 */
    /* JADX WARN: Type inference failed for: r10v90 */
    /* JADX WARN: Type inference failed for: r10v91 */
    /* JADX WARN: Type inference failed for: r10v92 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processNewAnchors$constraintlayout_compose_release(Map<Float, ? extends T> map, Map<Float, ? extends T> map2, Continuation<? super Unit> continuation) {
        CarouselSwipeableState$processNewAnchors$1 carouselSwipeableState$processNewAnchors$1;
        ?? r2;
        CarouselSwipeableState<T> carouselSwipeableState;
        Float offset;
        CarouselSwipeableState<T> carouselSwipeableState2;
        CarouselSwipeableState<T> carouselSwipeableState3;
        Float offset2;
        Float offset3;
        CarouselSwipeableState<T> carouselSwipeableState4;
        float f;
        float f2;
        try {
            if (continuation instanceof CarouselSwipeableState$processNewAnchors$1) {
                carouselSwipeableState$processNewAnchors$1 = (CarouselSwipeableState$processNewAnchors$1) continuation;
                if ((carouselSwipeableState$processNewAnchors$1.label & Integer.MIN_VALUE) != 0) {
                    carouselSwipeableState$processNewAnchors$1.label -= Integer.MIN_VALUE;
                    Object obj = carouselSwipeableState$processNewAnchors$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r2 = carouselSwipeableState$processNewAnchors$1.label;
                    if (r2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (map.isEmpty()) {
                            Float minOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                            Intrinsics.checkNotNull(minOrNull);
                            this.minBound = minOrNull.floatValue();
                            Float maxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                            Intrinsics.checkNotNull(maxOrNull);
                            this.maxBound = maxOrNull.floatValue();
                            offset3 = CarouselSwipeableKt.getOffset(map2, getCurrentValue());
                            if (offset3 == null) {
                                throw new IllegalArgumentException("The initial value must have an associated anchor.".toString());
                            }
                            float floatValue = offset3.floatValue();
                            carouselSwipeableState$processNewAnchors$1.label = 1;
                        } else if (!Intrinsics.areEqual(map2, map)) {
                            this.minBound = Float.NEGATIVE_INFINITY;
                            this.maxBound = Float.POSITIVE_INFINITY;
                            Float value = this.animationTarget.getValue();
                            T t = null;
                            if (value != null) {
                                offset2 = CarouselSwipeableKt.getOffset(map2, map.get(value));
                                if (offset2 != null) {
                                    map = (Map<Float, ? extends T>) offset2.floatValue();
                                } else {
                                    Iterator<T> it = map2.keySet().iterator();
                                    if (it.hasNext()) {
                                        t = it.next();
                                        if (it.hasNext()) {
                                            float abs = Math.abs(((Number) t).floatValue() - value.floatValue());
                                            do {
                                                T next = it.next();
                                                float abs2 = Math.abs(((Number) next).floatValue() - value.floatValue());
                                                if (Float.compare(abs, abs2) > 0) {
                                                    t = next;
                                                    abs = abs2;
                                                }
                                            } while (it.hasNext());
                                        }
                                    }
                                    Intrinsics.checkNotNull(t);
                                    map = (Map<Float, ? extends T>) ((Number) t).floatValue();
                                }
                            } else {
                                T t2 = map.get(Boxing.boxFloat(getOffset().getFloatValue()));
                                if (Intrinsics.areEqual(t2, getCurrentValue())) {
                                    t2 = getCurrentValue();
                                }
                                offset = CarouselSwipeableKt.getOffset(map2, t2);
                                if (offset != null) {
                                    map = offset.floatValue();
                                } else {
                                    Iterator<T> it2 = map2.keySet().iterator();
                                    if (it2.hasNext()) {
                                        t = it2.next();
                                        if (it2.hasNext()) {
                                            float abs3 = Math.abs(((Number) t).floatValue() - getOffset().getFloatValue());
                                            do {
                                                T next2 = it2.next();
                                                float abs4 = Math.abs(((Number) next2).floatValue() - getOffset().getFloatValue());
                                                if (Float.compare(abs3, abs4) > 0) {
                                                    t = next2;
                                                    abs3 = abs4;
                                                }
                                            } while (it2.hasNext());
                                        }
                                    }
                                    Intrinsics.checkNotNull(t);
                                    map = ((Number) t).floatValue();
                                }
                            }
                            try {
                                AnimationSpec<Float> animationSpec = this.animationSpec;
                                carouselSwipeableState$processNewAnchors$1.L$0 = this;
                                carouselSwipeableState$processNewAnchors$1.L$1 = map2;
                                carouselSwipeableState$processNewAnchors$1.F$0 = (float) map;
                                carouselSwipeableState$processNewAnchors$1.label = 2;
                                if (animateInternalToOffset((float) map, animationSpec, carouselSwipeableState$processNewAnchors$1) != coroutine_suspended) {
                                    carouselSwipeableState3 = this;
                                    f = map;
                                    carouselSwipeableState3.setCurrentValue(MapsKt.getValue(map2, Boxing.boxFloat(f)));
                                    Float minOrNull2 = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                                    Intrinsics.checkNotNull(minOrNull2);
                                    carouselSwipeableState3.minBound = minOrNull2.floatValue();
                                    Float maxOrNull2 = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                                    Intrinsics.checkNotNull(maxOrNull2);
                                    carouselSwipeableState3.maxBound = maxOrNull2.floatValue();
                                }
                            } catch (CancellationException unused) {
                                carouselSwipeableState2 = this;
                                carouselSwipeableState$processNewAnchors$1.L$0 = carouselSwipeableState2;
                                carouselSwipeableState$processNewAnchors$1.L$1 = map2;
                                carouselSwipeableState$processNewAnchors$1.F$0 = map;
                                carouselSwipeableState$processNewAnchors$1.label = 3;
                                if (carouselSwipeableState2.snapInternalToOffset(map, carouselSwipeableState$processNewAnchors$1) != coroutine_suspended) {
                                }
                                return coroutine_suspended;
                            } catch (Throwable th) {
                                th = th;
                                carouselSwipeableState = this;
                                carouselSwipeableState.setCurrentValue(MapsKt.getValue(map2, Boxing.boxFloat(map)));
                                Float minOrNull3 = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                                Intrinsics.checkNotNull(minOrNull3);
                                carouselSwipeableState.minBound = minOrNull3.floatValue();
                                Float maxOrNull3 = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                                Intrinsics.checkNotNull(maxOrNull3);
                                carouselSwipeableState.maxBound = maxOrNull3.floatValue();
                                throw th;
                            }
                        }
                        return coroutine_suspended;
                    } else if (r2 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    } else if (r2 == 2) {
                        map = (Map<Float, ? extends T>) carouselSwipeableState$processNewAnchors$1.F$0;
                        map2 = (Map) carouselSwipeableState$processNewAnchors$1.L$1;
                        carouselSwipeableState2 = (CarouselSwipeableState) carouselSwipeableState$processNewAnchors$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            carouselSwipeableState3 = carouselSwipeableState2;
                            f = map;
                            carouselSwipeableState3.setCurrentValue(MapsKt.getValue(map2, Boxing.boxFloat(f)));
                            Float minOrNull22 = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                            Intrinsics.checkNotNull(minOrNull22);
                            carouselSwipeableState3.minBound = minOrNull22.floatValue();
                            Float maxOrNull22 = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                            Intrinsics.checkNotNull(maxOrNull22);
                            carouselSwipeableState3.maxBound = maxOrNull22.floatValue();
                        } catch (CancellationException unused2) {
                            carouselSwipeableState$processNewAnchors$1.L$0 = carouselSwipeableState2;
                            carouselSwipeableState$processNewAnchors$1.L$1 = map2;
                            carouselSwipeableState$processNewAnchors$1.F$0 = map;
                            carouselSwipeableState$processNewAnchors$1.label = 3;
                            if (carouselSwipeableState2.snapInternalToOffset(map, carouselSwipeableState$processNewAnchors$1) != coroutine_suspended) {
                                carouselSwipeableState4 = carouselSwipeableState2;
                                f2 = map;
                                carouselSwipeableState4.setCurrentValue(MapsKt.getValue(map2, Boxing.boxFloat(f2)));
                                Float minOrNull4 = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                                Intrinsics.checkNotNull(minOrNull4);
                                carouselSwipeableState4.minBound = minOrNull4.floatValue();
                                Float maxOrNull4 = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                                Intrinsics.checkNotNull(maxOrNull4);
                                carouselSwipeableState4.maxBound = maxOrNull4.floatValue();
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        }
                    } else if (r2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        map = (Map<Float, ? extends T>) carouselSwipeableState$processNewAnchors$1.F$0;
                        map2 = (Map) carouselSwipeableState$processNewAnchors$1.L$1;
                        carouselSwipeableState = (CarouselSwipeableState) carouselSwipeableState$processNewAnchors$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            carouselSwipeableState4 = carouselSwipeableState;
                            f2 = map;
                            carouselSwipeableState4.setCurrentValue(MapsKt.getValue(map2, Boxing.boxFloat(f2)));
                            Float minOrNull42 = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                            Intrinsics.checkNotNull(minOrNull42);
                            carouselSwipeableState4.minBound = minOrNull42.floatValue();
                            Float maxOrNull42 = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                            Intrinsics.checkNotNull(maxOrNull42);
                            carouselSwipeableState4.maxBound = maxOrNull42.floatValue();
                        } catch (Throwable th2) {
                            th = th2;
                            carouselSwipeableState.setCurrentValue(MapsKt.getValue(map2, Boxing.boxFloat(map)));
                            Float minOrNull32 = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                            Intrinsics.checkNotNull(minOrNull32);
                            carouselSwipeableState.minBound = minOrNull32.floatValue();
                            Float maxOrNull32 = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                            Intrinsics.checkNotNull(maxOrNull32);
                            carouselSwipeableState.maxBound = maxOrNull32.floatValue();
                            throw th;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            if (r2 != 0) {
            }
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            carouselSwipeableState = r2;
        }
        carouselSwipeableState$processNewAnchors$1 = new CarouselSwipeableState$processNewAnchors$1(this, continuation);
        Object obj2 = carouselSwipeableState$processNewAnchors$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = carouselSwipeableState$processNewAnchors$1.label;
    }

    public final Function2<Float, Float, Float> getThresholds$constraintlayout_compose_release() {
        return (Function2) this.thresholds$delegate.getValue();
    }

    public final void setThresholds$constraintlayout_compose_release(Function2<? super Float, ? super Float, Float> function2) {
        this.thresholds$delegate.setValue(function2);
    }

    public final float getVelocityThreshold$constraintlayout_compose_release() {
        return this.velocityThreshold$delegate.getFloatValue();
    }

    public final void setVelocityThreshold$constraintlayout_compose_release(float f) {
        this.velocityThreshold$delegate.setFloatValue(f);
    }

    public final ResistanceConfig getResistance$constraintlayout_compose_release() {
        return (ResistanceConfig) this.resistance$delegate.getValue();
    }

    public final void setResistance$constraintlayout_compose_release(ResistanceConfig resistanceConfig) {
        this.resistance$delegate.setValue(resistanceConfig);
    }

    public final DraggableState getDraggableState$constraintlayout_compose_release() {
        return this.draggableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object snapInternalToOffset(float f, Continuation<? super Unit> continuation) {
        Object drag$default = DraggableState.drag$default(this.draggableState, null, new CarouselSwipeableState$snapInternalToOffset$2(f, this, null), continuation, 1, null);
        return drag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateInternalToOffset(float f, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object drag$default = DraggableState.drag$default(this.draggableState, null, new CarouselSwipeableState$animateInternalToOffset$2(this, f, animationSpec, null), continuation, 1, null);
        return drag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag$default : Unit.INSTANCE;
    }

    public final T getTargetValue() {
        Float offset;
        float computeTarget;
        Float value = this.animationTarget.getValue();
        if (value != null) {
            computeTarget = value.floatValue();
        } else {
            float floatValue = getOffset().getFloatValue();
            offset = CarouselSwipeableKt.getOffset(getAnchors$constraintlayout_compose_release(), getCurrentValue());
            computeTarget = CarouselSwipeableKt.computeTarget(floatValue, offset != null ? offset.floatValue() : getOffset().getFloatValue(), getAnchors$constraintlayout_compose_release().keySet(), getThresholds$constraintlayout_compose_release(), 0.0f, Float.POSITIVE_INFINITY);
        }
        T t = getAnchors$constraintlayout_compose_release().get(Float.valueOf(computeTarget));
        return t == null ? getCurrentValue() : t;
    }

    public final SwipeProgress<T> getProgress() {
        List findBounds;
        Object currentValue;
        Object obj;
        float f;
        Pair pair;
        findBounds = CarouselSwipeableKt.findBounds(getOffset().getFloatValue(), getAnchors$constraintlayout_compose_release().keySet());
        int size = findBounds.size();
        if (size == 0) {
            T currentValue2 = getCurrentValue();
            currentValue = getCurrentValue();
            obj = currentValue2;
            f = 1.0f;
        } else if (size == 1) {
            Object value = MapsKt.getValue(getAnchors$constraintlayout_compose_release(), findBounds.get(0));
            currentValue = MapsKt.getValue(getAnchors$constraintlayout_compose_release(), findBounds.get(0));
            f = 1.0f;
            obj = value;
        } else {
            if (getDirection() > 0.0f) {
                pair = TuplesKt.to(findBounds.get(0), findBounds.get(1));
            } else {
                pair = TuplesKt.to(findBounds.get(1), findBounds.get(0));
            }
            float floatValue = ((Number) pair.component1()).floatValue();
            float floatValue2 = ((Number) pair.component2()).floatValue();
            obj = MapsKt.getValue(getAnchors$constraintlayout_compose_release(), Float.valueOf(floatValue));
            currentValue = MapsKt.getValue(getAnchors$constraintlayout_compose_release(), Float.valueOf(floatValue2));
            f = (getOffset().getFloatValue() - floatValue) / (floatValue2 - floatValue);
        }
        return new SwipeProgress<>(obj, currentValue, f);
    }

    public final float getDirection() {
        Float offset;
        offset = CarouselSwipeableKt.getOffset(getAnchors$constraintlayout_compose_release(), getCurrentValue());
        if (offset != null) {
            return Math.signum(getOffset().getFloatValue() - offset.floatValue());
        }
        return 0.0f;
    }

    public final Object snapTo(T t, Continuation<? super Unit> continuation) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new CarouselSwipeableState$snapTo$2(t, this), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(CarouselSwipeableState carouselSwipeableState, Object obj, AnimationSpec animationSpec, Continuation continuation, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 2) != 0) {
                animationSpec = carouselSwipeableState.animationSpec;
            }
            return carouselSwipeableState.animateTo(obj, animationSpec, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
    }

    public final Object animateTo(T t, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new CarouselSwipeableState$animateTo$2(t, this, animationSpec), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final Object performFling(final float f, Continuation<? super Unit> continuation) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new FlowCollector(this) { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$performFling$2
            final /* synthetic */ CarouselSwipeableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Map) ((Map) obj), (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation2) {
                Float offset;
                float computeTarget;
                Object animateInternalToOffset;
                offset = CarouselSwipeableKt.getOffset(map, this.this$0.getCurrentValue());
                Intrinsics.checkNotNull(offset);
                float floatValue = offset.floatValue();
                computeTarget = CarouselSwipeableKt.computeTarget(this.this$0.getOffset().getFloatValue(), floatValue, map.keySet(), this.this$0.getThresholds$constraintlayout_compose_release(), f, this.this$0.getVelocityThreshold$constraintlayout_compose_release());
                T t = map.get(Boxing.boxFloat(computeTarget));
                if (t != null && this.this$0.getConfirmStateChange$constraintlayout_compose_release().invoke(t).booleanValue()) {
                    Object animateTo$default = CarouselSwipeableState.animateTo$default(this.this$0, t, null, continuation2, 2, null);
                    return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
                }
                CarouselSwipeableState<T> carouselSwipeableState = this.this$0;
                animateInternalToOffset = carouselSwipeableState.animateInternalToOffset(floatValue, carouselSwipeableState.getAnimationSpec$constraintlayout_compose_release(), continuation2);
                return animateInternalToOffset == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateInternalToOffset : Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final float performDrag(float f) {
        float coerceIn = RangesKt.coerceIn(this.absoluteOffset.getFloatValue() + f, this.minBound, this.maxBound) - this.absoluteOffset.getFloatValue();
        if (Math.abs(coerceIn) > 0.0f) {
            this.draggableState.dispatchRawDelta(coerceIn);
        }
        return coerceIn;
    }

    /* compiled from: CarouselSwipeable.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"Landroidx/constraintlayout/compose/carousel/CarouselSwipeableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/constraintlayout/compose/carousel/CarouselSwipeableState;", ExifInterface.GPS_DIRECTION_TRUE, "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Saver<CarouselSwipeableState<T>, T> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> function1) {
            return SaverKt.Saver(new Function2<SaverScope, CarouselSwipeableState<T>, T>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, Object obj) {
                    return invoke(saverScope, (CarouselSwipeableState) ((CarouselSwipeableState) obj));
                }

                public final T invoke(SaverScope saverScope, CarouselSwipeableState<T> carouselSwipeableState) {
                    return carouselSwipeableState.getCurrentValue();
                }
            }, new Function1<T, CarouselSwipeableState<T>>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$Companion$Saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((CarouselSwipeableState$Companion$Saver$2<T>) obj);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CarouselSwipeableState<T> invoke(T t) {
                    return new CarouselSwipeableState<>(t, animationSpec, function1);
                }
            });
        }
    }
}
