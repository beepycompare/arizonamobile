package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageFetcherSnapshot.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", i = {0, 0, 0}, l = {694}, m = "getLoadKey$paging_common", n = {"page", "this_$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1", "L$2"}, v = 1)
/* loaded from: classes3.dex */
public final class PageFetcherSnapshot$getLoadKey$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$getLoadKey$1(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super PageFetcherSnapshot$getLoadKey$1> continuation) {
        super(continuation);
        this.this$0 = pageFetcherSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getLoadKey$paging_common(null, this);
    }
}
