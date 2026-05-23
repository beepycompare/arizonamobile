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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\f\u0012\b\u0012\u00060\u0003R\u00020\u00040\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugGroup;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.composer.linkbuffer.SlotTable$toDebugTree$1", f = "SlotTable.kt", i = {0, 0, 0}, l = {585}, m = "invokeSuspend", n = {"$this$sequence", "groups$iv$iv", "current$iv$iv"}, s = {"L$0", "L$2", "I$0"}, v = 1)
/* loaded from: classes.dex */
final class SlotTable$toDebugTree$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super SlotTable.DebugGroup>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SlotTable this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlotTable$toDebugTree$1(SlotTable slotTable, Continuation<? super SlotTable$toDebugTree$1> continuation) {
        super(2, continuation);
        this.this$0 = slotTable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SlotTable$toDebugTree$1 slotTable$toDebugTree$1 = new SlotTable$toDebugTree$1(this.this$0, continuation);
        slotTable$toDebugTree$1.L$0 = obj;
        return slotTable$toDebugTree$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super SlotTable.DebugGroup> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SlotTable$toDebugTree$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0055 -> B:13:0x0058). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SlotTable slotTable;
        int[] groups;
        int i;
        SequenceScope sequenceScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            SlotTable slotTable2 = this.this$0;
            int root = slotTable2.getRoot();
            slotTable = this.this$0;
            groups = slotTable2.getAddressSpace().getGroups();
            i = root;
            sequenceScope = (SequenceScope) this.L$0;
            if (i >= 0) {
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i = this.I$0;
            groups = (int[]) this.L$2;
            slotTable = (SlotTable) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i = groups[i + 1];
            if (i >= 0) {
                SlotTable.DebugGroup debugGroup = new SlotTable.DebugGroup(i);
                this.L$0 = sequenceScope;
                this.L$1 = slotTable;
                this.L$2 = groups;
                this.I$0 = i;
                this.label = 1;
                if (sequenceScope.yield(debugGroup, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = groups[i + 1];
                if (i >= 0) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
