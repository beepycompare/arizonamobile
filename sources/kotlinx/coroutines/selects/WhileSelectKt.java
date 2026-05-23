package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
/* compiled from: WhileSelect.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0006H\u0087H¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"whileSelect", "", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WhileSelectKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006c -> B:12:0x003b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object whileSelect(Function1<? super SelectBuilder<? super Boolean>, Unit> function1, Continuation<? super Unit> continuation) {
        WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$1;
        int i;
        int i2;
        Object doSelect;
        if (continuation instanceof WhileSelectKt$whileSelect$1) {
            whileSelectKt$whileSelect$1 = (WhileSelectKt$whileSelect$1) continuation;
            if ((whileSelectKt$whileSelect$1.label & Integer.MIN_VALUE) != 0) {
                whileSelectKt$whileSelect$1.label -= Integer.MIN_VALUE;
                Object obj = whileSelectKt$whileSelect$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = whileSelectKt$whileSelect$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    i2 = 0;
                    SelectImplementation selectImplementation = new SelectImplementation(whileSelectKt$whileSelect$1.getContext());
                    function1.invoke(selectImplementation);
                    whileSelectKt$whileSelect$1.L$0 = function1;
                    whileSelectKt$whileSelect$1.L$1 = SpillingKt.nullOutSpilledVariable(selectImplementation);
                    whileSelectKt$whileSelect$1.I$0 = i2;
                    whileSelectKt$whileSelect$1.I$1 = 0;
                    whileSelectKt$whileSelect$1.I$2 = 0;
                    whileSelectKt$whileSelect$1.label = 1;
                    doSelect = selectImplementation.doSelect(whileSelectKt$whileSelect$1);
                    if (doSelect != coroutine_suspended) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = whileSelectKt$whileSelect$1.I$2;
                    int i4 = whileSelectKt$whileSelect$1.I$1;
                    int i5 = whileSelectKt$whileSelect$1.I$0;
                    SelectImplementation selectImplementation2 = (SelectImplementation) whileSelectKt$whileSelect$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$12 = whileSelectKt$whileSelect$1;
                    int i6 = i5;
                    function1 = (Function1) whileSelectKt$whileSelect$1.L$0;
                    WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$13 = whileSelectKt$whileSelect$12;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    i2 = i6;
                    whileSelectKt$whileSelect$1 = whileSelectKt$whileSelect$13;
                    SelectImplementation selectImplementation3 = new SelectImplementation(whileSelectKt$whileSelect$1.getContext());
                    function1.invoke(selectImplementation3);
                    whileSelectKt$whileSelect$1.L$0 = function1;
                    whileSelectKt$whileSelect$1.L$1 = SpillingKt.nullOutSpilledVariable(selectImplementation3);
                    whileSelectKt$whileSelect$1.I$0 = i2;
                    whileSelectKt$whileSelect$1.I$1 = 0;
                    whileSelectKt$whileSelect$1.I$2 = 0;
                    whileSelectKt$whileSelect$1.label = 1;
                    doSelect = selectImplementation3.doSelect(whileSelectKt$whileSelect$1);
                    if (doSelect != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    whileSelectKt$whileSelect$12 = whileSelectKt$whileSelect$1;
                    i6 = i2;
                    obj = doSelect;
                    WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$132 = whileSelectKt$whileSelect$12;
                    if (((Boolean) obj).booleanValue()) {
                    }
                }
            }
        }
        whileSelectKt$whileSelect$1 = new WhileSelectKt$whileSelect$1(continuation);
        Object obj2 = whileSelectKt$whileSelect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = whileSelectKt$whileSelect$1.label;
        if (i != 0) {
        }
    }

    private static final Object whileSelect$$forInline(Function1<? super SelectBuilder<? super Boolean>, Unit> function1, Continuation<? super Unit> continuation) {
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }
}
