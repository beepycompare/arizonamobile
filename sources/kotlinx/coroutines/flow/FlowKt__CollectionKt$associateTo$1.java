package kotlinx.coroutines.flow;

import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collection.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", f = "Collection.kt", i = {0, 0, 0, 0}, l = {DownloaderService.STATUS_WAITING_FOR_NETWORK}, m = "associateTo", n = {"$this$associateTo", FirebaseAnalytics.Param.DESTINATION, "transform", "$i$f$associateTo"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__CollectionKt$associateTo$1<T, K, V, M extends Map<? super K, ? super V>> extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__CollectionKt$associateTo$1(Continuation<? super FlowKt__CollectionKt$associateTo$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt__CollectionKt.associateTo(null, null, null, this);
    }
}
