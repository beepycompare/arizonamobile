package androidx.paging;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.paging.PageFetcherSnapshot$pageEventFlow$1;
import com.google.android.material.internal.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageFetcherSnapshot.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1", f = "PageFetcherSnapshot.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 13, 13, 13, 14, 15, 15}, l = {694, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 127, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 731, 744, 127, 756, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, ViewUtils.EDGE_TO_EDGE_FLAGS, 781, 127, 793, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 805}, m = "emit", n = {"this_$iv", "$this$withLock_u24default$iv$iv", "this_$iv", "loadType", "this_$iv", "$this$withLock_u24default$iv$iv", "this_$iv", "loadType", "$this$withLock_u24default$iv$iv", "this_$iv", "loadType", "this_$iv", "$this$withLock_u24default$iv$iv", "this_$iv", "loadType", "this_$iv", "this_$iv", "$this$withLock_u24default$iv$iv", "this_$iv", "loadType", "this_$iv", "$this$withLock_u24default$iv$iv", "this_$iv", "loadType", "$this$withLock_u24default$iv$iv", "this_$iv", "loadType", "this_$iv", "$this$withLock_u24default$iv$iv", "this_$iv", "loadType", "this_$iv", "this_$iv", "$this$withLock_u24default$iv$iv", "loadType", "this_$iv", "$this$withLock_u24default$iv$iv", "loadType", "$this$withLock_u24default$iv$iv", "loadType", "this_$iv", "$this$withLock_u24default$iv$iv", "loadType", "this_$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$3", "L$4", "L$5", "L$0", "L$3", "L$4", "L$0", "L$3", "L$4", "L$5", "L$0", "L$3", "L$0", "L$3", "L$4", "L$0", "L$3", "L$4", "L$5", "L$0", "L$3", "L$4", "L$0", "L$3", "L$4", "L$5", "L$0", "L$3", "L$0", "L$3", "L$4", "L$2", "L$3", "L$4", "L$2", "L$3", "L$2", "L$3", "L$4", "L$2", "L$2", "L$3"}, v = 1)
/* loaded from: classes3.dex */
public final class PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PageFetcherSnapshot$pageEventFlow$1.AnonymousClass4.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1(PageFetcherSnapshot$pageEventFlow$1.AnonymousClass4.AnonymousClass1<? super T> anonymousClass1, Continuation<? super PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Unit) null, (Continuation<? super Unit>) this);
    }
}
