package coil3.network;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.metadata.internal.metadata.builtins.BuiltInsProtoBuf;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkFetcher.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", i = {0, 0, 1, 1, 1}, l = {TsExtractor.TS_STREAM_TYPE_DTS, BuiltInsProtoBuf.PROPERTY_SETTER_ANNOTATION_FIELD_NUMBER}, m = "writeToDiskCache", n = {"snapshot", "networkResponse", "networkResponse", "modifiedNetworkResponse", "editor"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
public final class NetworkFetcher$writeToDiskCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkFetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$writeToDiskCache$1(NetworkFetcher networkFetcher, Continuation<? super NetworkFetcher$writeToDiskCache$1> continuation) {
        super(continuation);
        this.this$0 = networkFetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object writeToDiskCache;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        writeToDiskCache = this.this$0.writeToDiskCache(null, null, null, null, this);
        return writeToDiskCache;
    }
}
