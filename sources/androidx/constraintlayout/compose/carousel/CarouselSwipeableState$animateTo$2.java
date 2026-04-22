package androidx.constraintlayout.compose.carousel;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.MutableFloatState;
import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarouselSwipeable.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "anchors", "", "", "emit", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CarouselSwipeableState$animateTo$2<T> implements FlowCollector {
    final /* synthetic */ AnimationSpec<Float> $anim;
    final /* synthetic */ T $targetValue;
    final /* synthetic */ CarouselSwipeableState<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CarouselSwipeableState$animateTo$2(T t, CarouselSwipeableState<T> carouselSwipeableState, AnimationSpec<Float> animationSpec) {
        this.$targetValue = t;
        this.this$0 = carouselSwipeableState;
        this.$anim = animationSpec;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Map) ((Map) obj), (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation) {
        CarouselSwipeableState$animateTo$2$emit$1 carouselSwipeableState$animateTo$2$emit$1;
        int i;
        MutableFloatState mutableFloatState;
        Float offset;
        Object animateInternalToOffset;
        MutableFloatState mutableFloatState2;
        Object firstOrNull;
        try {
            if (continuation instanceof CarouselSwipeableState$animateTo$2$emit$1) {
                carouselSwipeableState$animateTo$2$emit$1 = (CarouselSwipeableState$animateTo$2$emit$1) continuation;
                if ((carouselSwipeableState$animateTo$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    carouselSwipeableState$animateTo$2$emit$1.label -= Integer.MIN_VALUE;
                    Object obj = carouselSwipeableState$animateTo$2$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = carouselSwipeableState$animateTo$2$emit$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        offset = CarouselSwipeableKt.getOffset(map, this.$targetValue);
                        if (offset == null) {
                            throw new IllegalArgumentException("The target value must have an associated anchor.".toString());
                        }
                        CarouselSwipeableState<T> carouselSwipeableState = this.this$0;
                        float floatValue = offset.floatValue();
                        AnimationSpec<Float> animationSpec = this.$anim;
                        carouselSwipeableState$animateTo$2$emit$1.L$0 = this;
                        carouselSwipeableState$animateTo$2$emit$1.L$1 = map;
                        carouselSwipeableState$animateTo$2$emit$1.label = 1;
                        animateInternalToOffset = carouselSwipeableState.animateInternalToOffset(floatValue, animationSpec, carouselSwipeableState$animateTo$2$emit$1);
                        if (animateInternalToOffset == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        map = (Map) carouselSwipeableState$animateTo$2$emit$1.L$1;
                        this = (CarouselSwipeableState$animateTo$2) carouselSwipeableState$animateTo$2$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    mutableFloatState2 = ((CarouselSwipeableState) this.this$0).absoluteOffset;
                    float floatValue2 = mutableFloatState2.getFloatValue();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<Float, ? extends T> entry : map.entrySet()) {
                        if (Math.abs(entry.getKey().floatValue() - floatValue2) < 0.5f) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    firstOrNull = CollectionsKt.firstOrNull(linkedHashMap.values());
                    if (firstOrNull == null) {
                        firstOrNull = this.this$0.getCurrentValue();
                    }
                    this.this$0.setCurrentValue(firstOrNull);
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            mutableFloatState2 = ((CarouselSwipeableState) this.this$0).absoluteOffset;
            float floatValue22 = mutableFloatState2.getFloatValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (r7.hasNext()) {
            }
            firstOrNull = CollectionsKt.firstOrNull(linkedHashMap2.values());
            if (firstOrNull == null) {
            }
            this.this$0.setCurrentValue(firstOrNull);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutableFloatState = ((CarouselSwipeableState) this.this$0).absoluteOffset;
            float floatValue3 = mutableFloatState.getFloatValue();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry<Float, ? extends T> entry2 : map.entrySet()) {
                if (Math.abs(entry2.getKey().floatValue() - floatValue3) < 0.5f) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            Object firstOrNull2 = CollectionsKt.firstOrNull(linkedHashMap3.values());
            if (firstOrNull2 == null) {
                firstOrNull2 = this.this$0.getCurrentValue();
            }
            this.this$0.setCurrentValue(firstOrNull2);
            throw th;
        }
        carouselSwipeableState$animateTo$2$emit$1 = new CarouselSwipeableState$animateTo$2$emit$1(this, continuation);
        Object obj2 = carouselSwipeableState$animateTo$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = carouselSwipeableState$animateTo$2$emit$1.label;
    }
}
