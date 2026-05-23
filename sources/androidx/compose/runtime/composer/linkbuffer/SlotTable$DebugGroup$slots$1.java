package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.composer.linkbuffer.SlotTable;
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
@DebugMetadata(c = "androidx.compose.runtime.composer.linkbuffer.SlotTable$DebugGroup$slots$1", f = "SlotTable.kt", i = {0, 0}, l = {600}, m = "invokeSuspend", n = {"$this$sequence", "address"}, s = {"L$0", "I$0"}, v = 1)
/* loaded from: classes.dex */
final class SlotTable$DebugGroup$slots$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Object>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SlotTable.DebugGroup this$0;
    final /* synthetic */ SlotTable this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlotTable$DebugGroup$slots$1(SlotTable.DebugGroup debugGroup, SlotTable slotTable, Continuation<? super SlotTable$DebugGroup$slots$1> continuation) {
        super(2, continuation);
        this.this$0 = debugGroup;
        this.this$1 = slotTable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SlotTable$DebugGroup$slots$1 slotTable$DebugGroup$slots$1 = new SlotTable$DebugGroup$slots$1(this.this$0, this.this$1, continuation);
        slotTable$DebugGroup$slots$1.L$0 = obj;
        return slotTable$DebugGroup$slots$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Object> sequenceScope, Continuation<? super Unit> continuation) {
        return invoke2((SequenceScope<Object>) sequenceScope, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<Object> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SlotTable$DebugGroup$slots$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0059 -> B:13:0x005c). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int address;
        int end;
        SequenceScope sequenceScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SlotTable.DebugSlotRange slotRange = this.this$0.getSlotRange();
            address = slotRange.getAddress() + GroupFlagsKt.utilitySlotsCountForFlags(this.this$0.getFlags());
            end = slotRange.getEnd();
            sequenceScope = (SequenceScope) this.L$0;
            if (address < end) {
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            end = this.I$1;
            address = this.I$0;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            address++;
            if (address < end) {
                this.L$0 = sequenceScope;
                this.I$0 = address;
                this.I$1 = end;
                this.label = 1;
                if (sequenceScope.yield(this.this$1.getSlots()[address], this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                address++;
                if (address < end) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
