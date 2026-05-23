package androidx.paging;

import androidx.compose.ui.spatial.RectListKt;
import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageEvent.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageEvent$StaticList", f = "PageEvent.kt", i = {0, 0}, l = {RectListKt.BitOffsetForGesturable}, m = "flatMap", n = {"transform", "destination$iv$iv"}, s = {"L$0", "L$1"}, v = 1)
/* loaded from: classes3.dex */
public final class PageEvent$StaticList$flatMap$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PageEvent.StaticList<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageEvent$StaticList$flatMap$1(PageEvent.StaticList<T> staticList, Continuation<? super PageEvent$StaticList$flatMap$1> continuation) {
        super(continuation);
        this.this$0 = staticList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.flatMap(null, this);
    }
}
