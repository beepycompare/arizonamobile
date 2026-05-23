package androidx.compose.runtime.composer.gapbuffer;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.composer.gapbuffer.SlotTable$getSlots$1$iterator$1", f = "SlotTable.kt", i = {0, 0}, l = {TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE}, m = "invokeSuspend", n = {"$this$iterator", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "I$0"}, v = 1)
/* loaded from: classes.dex */
final class SlotTable$getSlots$1$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Object>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SlotTable this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlotTable$getSlots$1$iterator$1(SlotTable slotTable, Continuation<? super SlotTable$getSlots$1$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = slotTable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SlotTable$getSlots$1$iterator$1 slotTable$getSlots$1$iterator$1 = new SlotTable$getSlots$1$iterator$1(this.this$0, continuation);
        slotTable$getSlots$1$iterator$1.L$0 = obj;
        return slotTable$getSlots$1$iterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Object> sequenceScope, Continuation<? super Unit> continuation) {
        return invoke2((SequenceScope<Object>) sequenceScope, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<Object> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SlotTable$getSlots$1$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0047 -> B:13:0x004a). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int slotsSize;
        int i;
        SequenceScope sequenceScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            slotsSize = this.this$0.getSlotsSize();
            i = 0;
            sequenceScope = (SequenceScope) this.L$0;
            if (i < slotsSize) {
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            slotsSize = this.I$1;
            i = this.I$0;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i++;
            if (i < slotsSize) {
                this.L$0 = sequenceScope;
                this.I$0 = i;
                this.I$1 = slotsSize;
                this.label = 1;
                if (sequenceScope.yield(this.this$0.m4553getSlots()[i], this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i++;
                if (i < slotsSize) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
