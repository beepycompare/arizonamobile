package kotlinx.coroutines.reactive;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReactiveFlow.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherAsFlow", f = "ReactiveFlow.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {TsExtractor.TS_STREAM_TYPE_DVBSUBS, 91}, m = "collectImpl", n = {"injectContext", "collector", "subscriber", "consumed", "injectContext", "collector", "subscriber", "value", "consumed"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"}, v = 1)
/* loaded from: classes5.dex */
public final class PublisherAsFlow$collectImpl$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PublisherAsFlow<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublisherAsFlow$collectImpl$1(PublisherAsFlow<T> publisherAsFlow, Continuation<? super PublisherAsFlow$collectImpl$1> continuation) {
        super(continuation);
        this.this$0 = publisherAsFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object collectImpl;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        collectImpl = this.this$0.collectImpl(null, null, this);
        return collectImpl;
    }
}
