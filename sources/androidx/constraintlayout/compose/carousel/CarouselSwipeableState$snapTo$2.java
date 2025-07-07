package androidx.constraintlayout.compose.carousel;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarouselSwipeable.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "anchors", "", "", "emit", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CarouselSwipeableState$snapTo$2<T> implements FlowCollector {
    final /* synthetic */ T $targetValue;
    final /* synthetic */ CarouselSwipeableState<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CarouselSwipeableState$snapTo$2(T t, CarouselSwipeableState<T> carouselSwipeableState) {
        this.$targetValue = t;
        this.this$0 = carouselSwipeableState;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Map) ((Map) obj), (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation) {
        CarouselSwipeableState$snapTo$2$emit$1 carouselSwipeableState$snapTo$2$emit$1;
        int i;
        Float offset;
        Object snapInternalToOffset;
        CarouselSwipeableState$snapTo$2<T> carouselSwipeableState$snapTo$2;
        if (continuation instanceof CarouselSwipeableState$snapTo$2$emit$1) {
            carouselSwipeableState$snapTo$2$emit$1 = (CarouselSwipeableState$snapTo$2$emit$1) continuation;
            if ((carouselSwipeableState$snapTo$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                carouselSwipeableState$snapTo$2$emit$1.label -= Integer.MIN_VALUE;
                Object obj = carouselSwipeableState$snapTo$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = carouselSwipeableState$snapTo$2$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    offset = CarouselSwipeableKt.getOffset(map, this.$targetValue);
                    if (offset == null) {
                        throw new IllegalArgumentException("The target value must have an associated anchor.".toString());
                    }
                    CarouselSwipeableState<T> carouselSwipeableState = this.this$0;
                    float floatValue = offset.floatValue();
                    carouselSwipeableState$snapTo$2$emit$1.L$0 = this;
                    carouselSwipeableState$snapTo$2$emit$1.label = 1;
                    snapInternalToOffset = carouselSwipeableState.snapInternalToOffset(floatValue, carouselSwipeableState$snapTo$2$emit$1);
                    if (snapInternalToOffset == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    carouselSwipeableState$snapTo$2 = this;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    carouselSwipeableState$snapTo$2 = (CarouselSwipeableState$snapTo$2) carouselSwipeableState$snapTo$2$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                carouselSwipeableState$snapTo$2.this$0.setCurrentValue(carouselSwipeableState$snapTo$2.$targetValue);
                return Unit.INSTANCE;
            }
        }
        carouselSwipeableState$snapTo$2$emit$1 = new CarouselSwipeableState$snapTo$2$emit$1(this, continuation);
        Object obj2 = carouselSwipeableState$snapTo$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = carouselSwipeableState$snapTo$2$emit$1.label;
        if (i != 0) {
        }
        carouselSwipeableState$snapTo$2.this$0.setCurrentValue(carouselSwipeableState$snapTo$2.$targetValue);
        return Unit.INSTANCE;
    }
}
