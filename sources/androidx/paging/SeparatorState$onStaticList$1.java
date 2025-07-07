package androidx.paging;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Separators.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.SeparatorState", f = "Separators.kt", i = {0, 0, 0, 0, 0}, l = {564}, m = "onStaticList", n = {"this", NotificationCompat.CATEGORY_EVENT, "data", "item", CmcdData.OBJECT_TYPE_INIT_SEGMENT}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
/* loaded from: classes3.dex */
public final class SeparatorState$onStaticList$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SeparatorState<R, T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeparatorState$onStaticList$1(SeparatorState<R, T> separatorState, Continuation<? super SeparatorState$onStaticList$1> continuation) {
        super(continuation);
        this.this$0 = separatorState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onStaticList(null, this);
    }
}
