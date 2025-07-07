package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: DatePicker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$1$1", f = "DatePicker.kt", i = {}, l = {1506}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class DatePickerKt$DatePickerContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $monthIndex;
    final /* synthetic */ LazyListState $monthsListState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$DatePickerContent$1$1(LazyListState lazyListState, int i, Continuation<? super DatePickerKt$DatePickerContent$1$1> continuation) {
        super(2, continuation);
        this.$monthsListState = lazyListState;
        this.$monthIndex = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DatePickerKt$DatePickerContent$1$1(this.$monthsListState, this.$monthIndex, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DatePickerKt$DatePickerContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.$monthsListState.isScrollInProgress()) {
                int firstVisibleItemIndex = this.$monthsListState.getFirstVisibleItemIndex();
                int i2 = this.$monthIndex;
                if (firstVisibleItemIndex != i2) {
                    this.label = 1;
                    if (LazyListState.scrollToItem$default(this.$monthsListState, i2, 0, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
