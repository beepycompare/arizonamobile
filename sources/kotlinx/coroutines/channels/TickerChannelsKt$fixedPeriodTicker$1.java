package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TickerChannels.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {80, 84, 90, 92}, m = "fixedPeriodTicker", n = {"channel", "delayMillis", "initialDelayMillis", "deadline", "channel", "delayMillis", "initialDelayMillis", "deadline", "delayNs", "channel", "delayMillis", "initialDelayMillis", "deadline", "delayNs", "now", "nextDelay", "adjustedDelay", "channel", "delayMillis", "initialDelayMillis", "deadline", "delayNs", "now", "nextDelay"}, s = {"L$0", "J$0", "J$1", "J$2", "L$0", "J$0", "J$1", "J$2", "J$3", "L$0", "J$0", "J$1", "J$2", "J$3", "J$4", "J$5", "J$6", "L$0", "J$0", "J$1", "J$2", "J$3", "J$4", "J$5"}, v = 1)
/* loaded from: classes5.dex */
public final class TickerChannelsKt$fixedPeriodTicker$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    long J$3;
    long J$4;
    long J$5;
    long J$6;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TickerChannelsKt$fixedPeriodTicker$1(Continuation<? super TickerChannelsKt$fixedPeriodTicker$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fixedPeriodTicker;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fixedPeriodTicker = TickerChannelsKt.fixedPeriodTicker(0L, 0L, null, this);
        return fixedPeriodTicker;
    }
}
