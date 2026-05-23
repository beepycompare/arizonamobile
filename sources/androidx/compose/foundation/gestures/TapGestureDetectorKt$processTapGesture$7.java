package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$7", f = "TapGestureDetector.kt", i = {}, l = {TsExtractor.TS_PACKET_SIZE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
public final class TapGestureDetectorKt$processTapGesture$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
    final /* synthetic */ PressGestureScopeImpl $pressScope;
    final /* synthetic */ PointerInputChange $secondDown;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TapGestureDetectorKt$processTapGesture$7(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super TapGestureDetectorKt$processTapGesture$7> continuation) {
        super(2, continuation);
        this.$onPress = function3;
        this.$pressScope = pressGestureScopeImpl;
        this.$secondDown = pointerInputChange;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TapGestureDetectorKt$processTapGesture$7(this.$onPress, this.$pressScope, this.$secondDown, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TapGestureDetectorKt$processTapGesture$7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
            PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
            Offset m5092boximpl = Offset.m5092boximpl(this.$secondDown.m6685getPositionF1C5BW0());
            this.label = 1;
            if (function3.invoke(pressGestureScopeImpl, m5092boximpl, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
