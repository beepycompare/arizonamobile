package androidx.compose.foundation.gestures;

import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TrackpadScrollingLogic.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TrackpadScrollingLogic", f = "TrackpadScrollingLogic.kt", i = {}, l = {173, DownloaderService.STATUS_PENDING}, m = "dispatchTrackpadScroll", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
public final class TrackpadScrollingLogic$dispatchTrackpadScroll$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TrackpadScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackpadScrollingLogic$dispatchTrackpadScroll$1(TrackpadScrollingLogic trackpadScrollingLogic, Continuation<? super TrackpadScrollingLogic$dispatchTrackpadScroll$1> continuation) {
        super(continuation);
        this.this$0 = trackpadScrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object dispatchTrackpadScroll;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        dispatchTrackpadScroll = this.this$0.dispatchTrackpadScroll(null, null, this);
        return dispatchTrackpadScroll;
    }
}
