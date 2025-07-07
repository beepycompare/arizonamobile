package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PagingDataPresenter.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PagingDataPresenter", f = "PagingDataPresenter.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {478}, m = "presentNewList", n = {"this", "pages", "sourceLoadStates", "mediatorLoadStates", "newHintReceiver", "newPageStore", "placeholdersBefore", "placeholdersAfter", "dispatchLoadStates"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "Z$0"})
/* loaded from: classes3.dex */
public final class PagingDataPresenter$presentNewList$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PagingDataPresenter<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagingDataPresenter$presentNewList$1(PagingDataPresenter<T> pagingDataPresenter, Continuation<? super PagingDataPresenter$presentNewList$1> continuation) {
        super(continuation);
        this.this$0 = pagingDataPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object presentNewList;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        presentNewList = this.this$0.presentNewList(null, 0, 0, false, null, null, null, this);
        return presentNewList;
    }
}
