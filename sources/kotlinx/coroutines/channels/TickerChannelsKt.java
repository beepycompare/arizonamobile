package kotlinx.coroutines.channels;

import com.arizona.launcher.UpdateActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;
/* compiled from: TickerChannels.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a,\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0082@¢\u0006\u0002\u0010\r\u001a,\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0082@¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "delayMillis", "", "initialDelayMillis", "context", "Lkotlin/coroutines/CoroutineContext;", UpdateActivity.UPDATE_MODE, "Lkotlinx/coroutines/channels/TickerMode;", "fixedPeriodTicker", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedDelayTicker", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TickerChannelsKt {
    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }

    public static final ReceiveChannel<Unit> ticker(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode) {
        if (j >= 0) {
            if (j2 < 0) {
                throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
            }
            return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, new TickerChannelsKt$ticker$3(tickerMode, j, j2, null));
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fb, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r4, r1) == r2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0114, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r4, r1) != r2) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cf  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00fe -> B:31:0x00ac). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0114 -> B:15:0x003e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedPeriodTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedPeriodTicker$1 tickerChannelsKt$fixedPeriodTicker$1;
        Object coroutine_suspended;
        int i;
        SendChannel<? super Unit> sendChannel2;
        long j3;
        long j4;
        long delayToNanos;
        long j5;
        long j6;
        SendChannel<? super Unit> sendChannel3;
        char c;
        SendChannel<? super Unit> sendChannel4;
        long j7;
        long coerceAtLeast;
        char c2;
        char c3;
        Unit unit;
        if (continuation instanceof TickerChannelsKt$fixedPeriodTicker$1) {
            tickerChannelsKt$fixedPeriodTicker$1 = (TickerChannelsKt$fixedPeriodTicker$1) continuation;
            if ((tickerChannelsKt$fixedPeriodTicker$1.label & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedPeriodTicker$1.label -= Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedPeriodTicker$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tickerChannelsKt$fixedPeriodTicker$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
                    long nanoTime = (abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime()) + EventLoop_commonKt.delayToNanos(j2);
                    sendChannel2 = sendChannel;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    j3 = j;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = nanoTime;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 1;
                    if (DelayKt.delay(j2, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                        j4 = nanoTime;
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    j4 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    long j8 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    j3 = j8;
                } else if (i != 2) {
                    if (i == 3) {
                        j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        c = 3;
                        long j9 = j5;
                        delayToNanos = j6;
                        j4 = j9;
                        sendChannel4 = sendChannel3;
                        long j10 = j4 + delayToNanos;
                        unit = Unit.INSTANCE;
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j10;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                        tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                        if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    } else if (i == 4) {
                        j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        j7 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        c3 = 4;
                        c2 = 3;
                        long j11 = j7;
                        delayToNanos = j6;
                        j4 = j11;
                        sendChannel4 = sendChannel3;
                        long j102 = j4 + delayToNanos;
                        unit = Unit.INSTANCE;
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j102;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                        tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                        if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                            long j12 = delayToNanos;
                            j7 = j102;
                            j6 = j12;
                            sendChannel3 = sendChannel4;
                            AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.timeSource;
                            long nanoTime2 = abstractTimeSource2 == null ? abstractTimeSource2.nanoTime() : System.nanoTime();
                            coerceAtLeast = RangesKt.coerceAtLeast(j7 - nanoTime2, 0L);
                            if (coerceAtLeast != 0 && j6 != 0) {
                                long j13 = j6 - ((nanoTime2 - j7) % j6);
                                j5 = nanoTime2 + j13;
                                long delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(j13);
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j5;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
                                c = 3;
                                tickerChannelsKt$fixedPeriodTicker$1.label = 3;
                            } else {
                                c2 = 3;
                                long delayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
                                c3 = 4;
                                tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                            }
                        }
                        return coroutine_suspended;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    j7 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    AbstractTimeSource abstractTimeSource22 = AbstractTimeSourceKt.timeSource;
                    if (abstractTimeSource22 == null) {
                    }
                    coerceAtLeast = RangesKt.coerceAtLeast(j7 - nanoTime2, 0L);
                    if (coerceAtLeast != 0) {
                    }
                    c2 = 3;
                    long delayNanosToMillis22 = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
                    c3 = 4;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                }
                delayToNanos = EventLoop_commonKt.delayToNanos(j3);
                sendChannel4 = sendChannel2;
                long j1022 = j4 + delayToNanos;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j1022;
                tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        tickerChannelsKt$fixedPeriodTicker$1 = new TickerChannelsKt$fixedPeriodTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedPeriodTicker$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tickerChannelsKt$fixedPeriodTicker$1.label;
        if (i != 0) {
        }
        delayToNanos = EventLoop_commonKt.delayToNanos(j3);
        sendChannel4 = sendChannel2;
        long j10222 = j4 + delayToNanos;
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j10222;
        tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
        tickerChannelsKt$fixedPeriodTicker$1.label = 2;
        if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r8, r0) == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r6, r0) != r1) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007e -> B:14:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedDelayTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedDelayTicker$1 tickerChannelsKt$fixedDelayTicker$1;
        Object coroutine_suspended;
        int i;
        SendChannel<? super Unit> sendChannel2;
        Unit unit;
        if (continuation instanceof TickerChannelsKt$fixedDelayTicker$1) {
            tickerChannelsKt$fixedDelayTicker$1 = (TickerChannelsKt$fixedDelayTicker$1) continuation;
            if ((tickerChannelsKt$fixedDelayTicker$1.label & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedDelayTicker$1.label -= Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedDelayTicker$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tickerChannelsKt$fixedDelayTicker$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.label = 1;
                } else if (i == 1) {
                    j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    sendChannel = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.label = 3;
                } else if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    sendChannel = sendChannel2;
                }
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) != coroutine_suspended) {
                    sendChannel2 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.label = 3;
                }
                return coroutine_suspended;
            }
        }
        tickerChannelsKt$fixedDelayTicker$1 = new TickerChannelsKt$fixedDelayTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedDelayTicker$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tickerChannelsKt$fixedDelayTicker$1.label;
        if (i != 0) {
        }
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
        tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
        tickerChannelsKt$fixedDelayTicker$1.label = 2;
        if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
