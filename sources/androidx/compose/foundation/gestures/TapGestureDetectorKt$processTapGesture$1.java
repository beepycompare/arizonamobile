package androidx.compose.foundation.gestures;

import androidx.compose.runtime.ComposerKt;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TapGestureDetector.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7}, l = {131, 142, 145, 148, 176, DownloaderService.STATUS_WAITING_TO_RETRY, DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION, ComposerKt.reuseKey}, m = "processTapGesture", n = {"$this$processTapGesture", "scope", "pressScope", "onDoubleTap", "onLongPress", "onPress", "onTap", "$this$processTapGesture", "scope", "pressScope", "onDoubleTap", "onLongPress", "onPress", "onTap", "resetJob", "$this$processTapGesture", "scope", "pressScope", "onDoubleTap", "onLongPress", "onPress", "onTap", "down", "resetJob", "scope", "pressScope", "resetJob", "$this$processTapGesture", "scope", "pressScope", "onDoubleTap", "onLongPress", "onPress", "onTap", "upOrCancel", "cancelOrReleaseJob", "scope", "pressScope", "onDoubleTap", "onTap", "resetJob", "upOrCancel", "$this$processTapGesture", "scope", "pressScope", "onDoubleTap", "onLongPress", "onTap", "resetJob", "upOrCancel", "secondDown", "scope", "pressScope", "resetJob"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2"}, v = 1)
/* loaded from: classes.dex */
public final class TapGestureDetectorKt$processTapGesture$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TapGestureDetectorKt$processTapGesture$1(Continuation<? super TapGestureDetectorKt$processTapGesture$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TapGestureDetectorKt.processTapGesture(null, null, null, null, null, null, null, this);
    }
}
