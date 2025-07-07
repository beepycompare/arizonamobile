package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PagingDataEvent;
import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncPagingDataDiffer.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Landroidx/paging/PlaceholderPaddedDiffResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$2$diffResult$1", f = "AsyncPagingDataDiffer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$2$diffResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PlaceholderPaddedDiffResult>, Object> {
    final /* synthetic */ PagingDataEvent.Refresh<T> $this_apply;
    int label;
    final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$2$diffResult$1(PagingDataEvent.Refresh<T> refresh, AsyncPagingDataDiffer<T> asyncPagingDataDiffer, Continuation<? super AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$2$diffResult$1> continuation) {
        super(2, continuation);
        this.$this_apply = refresh;
        this.this$0 = asyncPagingDataDiffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$2$diffResult$1(this.$this_apply, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PlaceholderPaddedDiffResult> continuation) {
        return ((AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$2$diffResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DiffUtil.ItemCallback itemCallback;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PlaceholderPaddedList previousList = this.$this_apply.getPreviousList();
        PlaceholderPaddedList newList = this.$this_apply.getNewList();
        itemCallback = ((AsyncPagingDataDiffer) this.this$0).diffCallback;
        return PlaceholderPaddedListDiffHelperKt.computeDiff(previousList, newList, itemCallback);
    }
}
