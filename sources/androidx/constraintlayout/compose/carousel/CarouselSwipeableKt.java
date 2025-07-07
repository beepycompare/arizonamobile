package androidx.constraintlayout.compose.carousel;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CarouselSwipeable.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aP\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002\u001a$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0002\u001aZ\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00132\u0006\u0010\u0014\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162#\b\u0002\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0001¢\u0006\u0002\u0010\u001d\u001aI\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00132\u0006\u0010\u001f\u001a\u0002H\u00022\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020!0\u00182\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016H\u0001¢\u0006\u0002\u0010\"\u001a¶\u0001\u0010#\u001a\u00020$\"\u0004\b\u0000\u0010\u0002*\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00020&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u001c2\b\b\u0002\u0010*\u001a\u00020\u001c2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,28\b\u0002\u0010\f\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(-\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/0\r2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u0010\u000f\u001a\u000202H\u0000ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a-\u00105\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00020&2\u0006\u0010%\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u00106\"$\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"PreUpPostDownNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/constraintlayout/compose/carousel/CarouselSwipeableState;", "getPreUpPostDownNestedScrollConnection", "(Landroidx/constraintlayout/compose/carousel/CarouselSwipeableState;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "computeTarget", "", TypedValues.CycleType.S_WAVE_OFFSET, "lastValue", "anchors", "", "thresholds", "Lkotlin/Function2;", "velocity", "velocityThreshold", "findBounds", "", "rememberCarouselSwipeableState", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/constraintlayout/compose/carousel/CarouselSwipeableState;", "rememberCarouselSwipeableStateFor", "value", "onValueChange", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/constraintlayout/compose/carousel/CarouselSwipeableState;", "carouselSwipeable", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "from", TypedValues.TransitionType.S_TO, "Landroidx/constraintlayout/compose/carousel/ThresholdConfig;", "resistance", "Landroidx/constraintlayout/compose/carousel/ResistanceConfig;", "Landroidx/compose/ui/unit/Dp;", "carouselSwipeable-pPrIpRY", "(Landroidx/compose/ui/Modifier;Landroidx/constraintlayout/compose/carousel/CarouselSwipeableState;Ljava/util/Map;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/constraintlayout/compose/carousel/ResistanceConfig;F)Landroidx/compose/ui/Modifier;", "getOffset", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Float;", "constraintlayout-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CarouselSwipeableKt {
    public static final <T> CarouselSwipeableState<T> rememberCarouselSwipeableState(final T t, final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1633385233, "C(rememberCarouselSwipeableState)P(2)458@19444L185,452@19245L384:CarouselSwipeable.kt#giyipq");
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<T, Boolean>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$rememberCarouselSwipeableState$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T t2) {
                    return true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                    return invoke((CarouselSwipeableKt$rememberCarouselSwipeableState$1<T>) obj);
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1633385233, i, -1, "androidx.constraintlayout.compose.carousel.rememberCarouselSwipeableState (CarouselSwipeable.kt:451)");
        }
        Object[] objArr = new Object[0];
        Saver<CarouselSwipeableState<T>, T> Saver = CarouselSwipeableState.Companion.Saver(animationSpec, function1);
        ComposerKt.sourceInformationMarkerStart(composer, -1576894157, "CC(remember):CarouselSwipeable.kt#9igjgp");
        boolean changedInstance = ((((i & 14) ^ 6) > 4 && composer.changedInstance(t)) || (i & 6) == 4) | composer.changedInstance(animationSpec) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(function1)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = (Function0) new Function0<CarouselSwipeableState<T>>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$rememberCarouselSwipeableState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    return invoke();
                }

                @Override // kotlin.jvm.functions.Function0
                public final CarouselSwipeableState<T> invoke() {
                    return new CarouselSwipeableState<>(t, animationSpec, function1);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        CarouselSwipeableState<T> carouselSwipeableState = (CarouselSwipeableState) RememberSaveableKt.m3635rememberSaveable(objArr, Saver, (String) null, (Function0<? extends Object>) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return carouselSwipeableState;
    }

    public static final <T> CarouselSwipeableState<T> rememberCarouselSwipeableStateFor(final T t, final Function1<? super T, Unit> function1, AnimationSpec<Float> animationSpec, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2074386230, "C(rememberCarouselSwipeableStateFor)P(2,1)482@20511L177,489@20719L34,490@20807L113,490@20758L162,495@20971L212,495@20925L258:CarouselSwipeable.kt#giyipq");
        if ((i2 & 4) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2074386230, i, -1, "androidx.constraintlayout.compose.carousel.rememberCarouselSwipeableStateFor (CarouselSwipeable.kt:481)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -194668864, "CC(remember):CarouselSwipeable.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new CarouselSwipeableState(t, animationSpec, new Function1<T, Boolean>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$rememberCarouselSwipeableStateFor$swipeableState$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T t2) {
                    return true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                    return invoke((CarouselSwipeableKt$rememberCarouselSwipeableStateFor$swipeableState$1$1<T>) obj);
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        final CarouselSwipeableState<T> carouselSwipeableState = (CarouselSwipeableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -194662351, "CC(remember):CarouselSwipeable.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState = (MutableState) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object value = mutableState.getValue();
        ComposerKt.sourceInformationMarkerStart(composer, -194659456, "CC(remember):CarouselSwipeable.kt#9igjgp");
        int i3 = (i & 14) ^ 6;
        boolean z = (i3 > 4 && composer.changedInstance(t)) || (i & 6) == 4;
        CarouselSwipeableKt$rememberCarouselSwipeableStateFor$1$1 rememberedValue3 = composer.rememberedValue();
        if (z || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new CarouselSwipeableKt$rememberCarouselSwipeableStateFor$1$1(t, carouselSwipeableState, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i4 = i & 8;
        EffectsKt.LaunchedEffect(t, value, (Function2) rememberedValue3, composer, i & 14);
        T currentValue = carouselSwipeableState.getCurrentValue();
        ComposerKt.sourceInformationMarkerStart(composer, -194654109, "CC(remember):CarouselSwipeable.kt#9igjgp");
        boolean z2 = ((i3 > 4 && composer.changedInstance(t)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(function1)) || (i & 48) == 32);
        Object rememberedValue4 = composer.rememberedValue();
        if (z2 || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$rememberCarouselSwipeableStateFor$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    return invoke2(disposableEffectScope);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final DisposableEffectResult invoke2(DisposableEffectScope disposableEffectScope) {
                    if (!Intrinsics.areEqual(t, carouselSwipeableState.getCurrentValue())) {
                        function1.invoke(carouselSwipeableState.getCurrentValue());
                        MutableState<Boolean> mutableState2 = mutableState;
                        mutableState2.setValue(Boolean.valueOf(!mutableState2.getValue().booleanValue()));
                    }
                    return new DisposableEffectResult() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$rememberCarouselSwipeableStateFor$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(currentValue, (Function1) rememberedValue4, composer, i4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return carouselSwipeableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v12 */
    public static final List<Float> findBounds(float f, Set<Float> set) {
        Object obj;
        Set<Float> set2 = set;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : set2) {
            if (((Number) obj2).floatValue() <= f + 0.001d) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        Float f2 = null;
        if (arrayList2.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList2.get(0);
            float floatValue = ((Number) obj).floatValue();
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex) {
                int i = 1;
                while (true) {
                    Object obj3 = arrayList2.get(i);
                    float floatValue2 = ((Number) obj3).floatValue();
                    if (Float.compare(floatValue, floatValue2) < 0) {
                        obj = obj3;
                        floatValue = floatValue2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        Float f3 = (Float) obj;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj4 : set2) {
            if (((Number) obj4).floatValue() >= f - 0.001d) {
                arrayList3.add(obj4);
            }
        }
        ArrayList arrayList4 = arrayList3;
        if (!arrayList4.isEmpty()) {
            Object obj5 = arrayList4.get(0);
            float floatValue3 = ((Number) obj5).floatValue();
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex2) {
                int i2 = 1;
                Object obj6 = obj5;
                while (true) {
                    Object obj7 = arrayList4.get(i2);
                    float floatValue4 = ((Number) obj7).floatValue();
                    obj5 = obj6;
                    if (Float.compare(floatValue3, floatValue4) > 0) {
                        obj5 = obj7;
                        floatValue3 = floatValue4;
                    }
                    if (i2 == lastIndex2) {
                        break;
                    }
                    i2++;
                    obj6 = obj5;
                }
            }
            f2 = obj5;
        }
        Float f4 = f2;
        if (f3 == null) {
            return CollectionsKt.listOfNotNull(f4);
        }
        if (f4 == null) {
            return CollectionsKt.listOf(f3);
        }
        return Intrinsics.areEqual(f3, f4) ? CollectionsKt.listOf(f3) : CollectionsKt.listOf((Object[]) new Float[]{f3, f4});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float computeTarget(float f, float f2, Set<Float> set, Function2<? super Float, ? super Float, Float> function2, float f3, float f4) {
        List<Float> findBounds = findBounds(f, set);
        int size = findBounds.size();
        if (size != 0) {
            if (size == 1) {
                return findBounds.get(0).floatValue();
            }
            float floatValue = findBounds.get(0).floatValue();
            float floatValue2 = findBounds.get(1).floatValue();
            return (f2 > f ? f3 > (-f4) && f > function2.invoke(Float.valueOf(floatValue2), Float.valueOf(floatValue)).floatValue() : f3 >= f4 || f >= function2.invoke(Float.valueOf(floatValue), Float.valueOf(floatValue2)).floatValue()) ? floatValue2 : floatValue;
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float getOffset(Map<Float, ? extends T> map, T t) {
        T t2;
        Iterator<T> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (Intrinsics.areEqual(((Map.Entry) t2).getValue(), t)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) t2;
        if (entry != null) {
            return (Float) entry.getKey();
        }
        return null;
    }

    public static final <T> NestedScrollConnection getPreUpPostDownNestedScrollConnection(CarouselSwipeableState<T> carouselSwipeableState) {
        return new CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1(carouselSwipeableState);
    }

    /* renamed from: carouselSwipeable-pPrIpRY  reason: not valid java name */
    public static final <T> Modifier m7159carouselSwipeablepPrIpRY(Modifier modifier, final CarouselSwipeableState<T> carouselSwipeableState, final Map<Float, ? extends T> map, final Orientation orientation, final boolean z, final boolean z2, final MutableInteractionSource mutableInteractionSource, final Function2<? super T, ? super T, ? extends ThresholdConfig> function2, final ResistanceConfig resistanceConfig, final float f) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$carouselSwipeable-pPrIpRY$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("swipeable");
                inspectorInfo.getProperties().set(RemoteConfigConstants.ResponseFieldKey.STATE, CarouselSwipeableState.this);
                inspectorInfo.getProperties().set("anchors", map);
                inspectorInfo.getProperties().set("orientation", orientation);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(z2));
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("thresholds", function2);
                inspectorInfo.getProperties().set("resistance", resistanceConfig);
                inspectorInfo.getProperties().set("velocityThreshold", Dp.m6682boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$carouselSwipeable$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r26v0, types: [androidx.compose.runtime.Composer] */
            /* JADX WARN: Type inference failed for: r6v5 */
            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(1858597191);
                ComposerKt.sourceInformation(composer, "C571@25107L7,573@25188L495,573@25157L526,592@25972L55:CarouselSwipeable.kt#giyipq");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1858597191, i, -1, "androidx.constraintlayout.compose.carousel.carouselSwipeable.<anonymous> (CarouselSwipeable.kt:567)");
                }
                if (map.isEmpty()) {
                    throw new IllegalArgumentException("You must have at least one anchor.".toString());
                }
                if (CollectionsKt.distinct(map.values()).size() != map.size()) {
                    throw new IllegalArgumentException("You cannot have two anchors mapped to the same state.".toString());
                }
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer);
                Density density = (Density) consume;
                carouselSwipeableState.ensureInit$constraintlayout_compose_release(map);
                Object obj = map;
                Object obj2 = carouselSwipeableState;
                ComposerKt.sourceInformationMarkerStart(composer, 1578268370, "CC(remember):CarouselSwipeable.kt#9igjgp");
                boolean changed = composer.changed(carouselSwipeableState) | composer.changedInstance(map) | composer.changed(resistanceConfig) | composer.changed(function2) | composer.changed(density) | composer.changed(f);
                CarouselSwipeableState carouselSwipeableState2 = carouselSwipeableState;
                Map map2 = map;
                ResistanceConfig resistanceConfig2 = resistanceConfig;
                Function2 function22 = function2;
                float f2 = f;
                CarouselSwipeableKt$carouselSwipeable$3$3$1 rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new CarouselSwipeableKt$carouselSwipeable$3$3$1(carouselSwipeableState2, map2, resistanceConfig2, density, function22, f2, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(obj, obj2, (Function2) rememberedValue, composer, 0);
                Modifier.Companion companion = Modifier.Companion;
                boolean isAnimationRunning = carouselSwipeableState.isAnimationRunning();
                DraggableState draggableState$constraintlayout_compose_release = carouselSwipeableState.getDraggableState$constraintlayout_compose_release();
                Modifier.Companion companion2 = companion;
                Orientation orientation2 = orientation;
                boolean z3 = z;
                MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                ComposerKt.sourceInformationMarkerStart(composer, 1578293018, "CC(remember):CarouselSwipeable.kt#9igjgp");
                boolean changed2 = composer.changed(carouselSwipeableState);
                CarouselSwipeableState carouselSwipeableState3 = carouselSwipeableState;
                CarouselSwipeableKt$carouselSwipeable$3$4$1 rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new CarouselSwipeableKt$carouselSwipeable$3$4$1(carouselSwipeableState3, null);
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier draggable$default = DraggableKt.draggable$default(companion2, draggableState$constraintlayout_compose_release, orientation2, z3, mutableInteractionSource2, isAnimationRunning, null, rememberedValue2, z2, 32, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return draggable$default;
            }
        });
    }
}
