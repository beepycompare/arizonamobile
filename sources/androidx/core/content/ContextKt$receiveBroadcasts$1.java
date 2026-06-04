package androidx.core.content;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Context.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.core.content.ContextKt", f = "Context.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {282}, m = "receiveBroadcasts", n = {"$this$receiveBroadcasts", "filter", "broadcastPermission", "scheduler", "onReceive", "receiver", DownloaderServiceMarshaller.PARAMS_FLAGS}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 1)
/* loaded from: classes2.dex */
public final class ContextKt$receiveBroadcasts$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContextKt$receiveBroadcasts$1(Continuation<? super ContextKt$receiveBroadcasts$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ContextKt.receiveBroadcasts(null, null, 0, null, null, null, this);
    }
}
