package kotlinx.coroutines.rx2;

import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxAwait.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxAwaitKt", f = "RxAwait.kt", i = {0}, l = {DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION}, m = "awaitFirstOrElse", n = {"defaultValue"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class RxAwaitKt$awaitFirstOrElse$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxAwaitKt$awaitFirstOrElse$1(Continuation<? super RxAwaitKt$awaitFirstOrElse$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RxAwaitKt.awaitFirstOrElse(null, null, this);
    }
}
