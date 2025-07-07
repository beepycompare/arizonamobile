package androidx.compose.ui.scrollcapture;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComposeScrollCaptureCallback.android.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback", f = "ComposeScrollCaptureCallback.android.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {132, TsExtractor.TS_STREAM_TYPE_E_AC3}, m = "onScrollCaptureImageRequest", n = {"this", "session", "captureArea", "targetMin", "targetMax", "this", "session", "captureArea", "targetMin", "targetMax"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
/* loaded from: classes2.dex */
public final class ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ComposeScrollCaptureCallback this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2(ComposeScrollCaptureCallback composeScrollCaptureCallback, Continuation<? super ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2> continuation) {
        super(continuation);
        this.this$0 = composeScrollCaptureCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object onScrollCaptureImageRequest;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        onScrollCaptureImageRequest = this.this$0.onScrollCaptureImageRequest(null, null, this);
        return onScrollCaptureImageRequest;
    }
}
