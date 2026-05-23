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
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a,\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0082@¢\u0006\u0002\u0010\r\u001a,\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0082@¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "delayMillis", "", "initialDelayMillis", "context", "Lkotlin/coroutines/CoroutineContext;", UpdateActivity.UPDATE_MODE, "Lkotlinx/coroutines/channels/TickerMode;", "fixedPeriodTicker", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedDelayTicker", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
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
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0170  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0146 -> B:46:0x0149). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0170 -> B:51:0x0178). Please submit an issue!!! */
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
        char c;
        SendChannel<? super Unit> sendChannel3;
        SendChannel<? super Unit> sendChannel4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long nanoTime;
        long j10;
        long coerceAtLeast;
        long delayNanosToMillis;
        char c2;
        SendChannel<? super Unit> sendChannel5;
        Unit unit;
        long j11 = j2;
        if (continuation instanceof TickerChannelsKt$fixedPeriodTicker$1) {
            tickerChannelsKt$fixedPeriodTicker$1 = (TickerChannelsKt$fixedPeriodTicker$1) continuation;
            if ((tickerChannelsKt$fixedPeriodTicker$1.label & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedPeriodTicker$1.label -= Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedPeriodTicker$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tickerChannelsKt$fixedPeriodTicker$1.label;
                int i2 = 2;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
                    long nanoTime2 = (abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime()) + EventLoop_commonKt.delayToNanos(j11);
                    sendChannel2 = sendChannel;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                    tickerChannelsKt$fixedPeriodTicker$1.J$2 = nanoTime2;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 1;
                    if (DelayKt.delay(j11, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                        j3 = nanoTime2;
                        j4 = j;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        j8 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                        j7 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                        j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.timeSource;
                        j9 = j7;
                        nanoTime = abstractTimeSource2 == null ? abstractTimeSource2.nanoTime() : System.nanoTime();
                        j10 = j6;
                        coerceAtLeast = RangesKt.coerceAtLeast(j9 - nanoTime, 0L);
                        if (coerceAtLeast != 0) {
                        }
                        long j12 = j5;
                        delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j12;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                        tickerChannelsKt$fixedPeriodTicker$1.J$2 = j9;
                        tickerChannelsKt$fixedPeriodTicker$1.J$3 = j8;
                        tickerChannelsKt$fixedPeriodTicker$1.J$4 = nanoTime;
                        tickerChannelsKt$fixedPeriodTicker$1.J$5 = coerceAtLeast;
                        c2 = 4;
                        tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                        if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    } else if (i == 3) {
                        long j13 = tickerChannelsKt$fixedPeriodTicker$1.J$6;
                        long j14 = tickerChannelsKt$fixedPeriodTicker$1.J$5;
                        long j15 = tickerChannelsKt$fixedPeriodTicker$1.J$4;
                        long j16 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                        j3 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                        long j17 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        long j18 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        delayToNanos = j16;
                        j11 = j17;
                        j4 = j18;
                        c = 3;
                        sendChannel4 = sendChannel3;
                        i2 = 2;
                        sendChannel5 = sendChannel4;
                        j7 = j3 + delayToNanos;
                        unit = Unit.INSTANCE;
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel5;
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                        tickerChannelsKt$fixedPeriodTicker$1.J$2 = j7;
                        tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                        tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                        if (sendChannel5.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    } else if (i == 4) {
                        long j19 = tickerChannelsKt$fixedPeriodTicker$1.J$5;
                        long j20 = tickerChannelsKt$fixedPeriodTicker$1.J$4;
                        long j21 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                        j3 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                        long j22 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        long j23 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        delayToNanos = j21;
                        j11 = j22;
                        j4 = j23;
                        c2 = 4;
                        sendChannel4 = sendChannel3;
                        i2 = 2;
                        sendChannel5 = sendChannel4;
                        j7 = j3 + delayToNanos;
                        unit = Unit.INSTANCE;
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel5;
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                        tickerChannelsKt$fixedPeriodTicker$1.J$2 = j7;
                        tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                        tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                        if (sendChannel5.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                            long j24 = j4;
                            j6 = j11;
                            j8 = delayToNanos;
                            j5 = j24;
                            sendChannel3 = sendChannel5;
                            AbstractTimeSource abstractTimeSource22 = AbstractTimeSourceKt.timeSource;
                            j9 = j7;
                            nanoTime = abstractTimeSource22 == null ? abstractTimeSource22.nanoTime() : System.nanoTime();
                            j10 = j6;
                            coerceAtLeast = RangesKt.coerceAtLeast(j9 - nanoTime, 0L);
                            if (coerceAtLeast != 0 && j8 != 0) {
                                long j25 = j8 - ((nanoTime - j9) % j8);
                                long j26 = nanoTime + j25;
                                long delayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(j25);
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j5;
                                long j27 = j5;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                                tickerChannelsKt$fixedPeriodTicker$1.J$2 = j26;
                                tickerChannelsKt$fixedPeriodTicker$1.J$3 = j8;
                                tickerChannelsKt$fixedPeriodTicker$1.J$4 = nanoTime;
                                tickerChannelsKt$fixedPeriodTicker$1.J$5 = coerceAtLeast;
                                tickerChannelsKt$fixedPeriodTicker$1.J$6 = j25;
                                c = 3;
                                tickerChannelsKt$fixedPeriodTicker$1.label = 3;
                                if (DelayKt.delay(delayNanosToMillis2, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                                    delayToNanos = j8;
                                    j11 = j10;
                                    j3 = j26;
                                    j4 = j27;
                                    sendChannel4 = sendChannel3;
                                    i2 = 2;
                                    sendChannel5 = sendChannel4;
                                    j7 = j3 + delayToNanos;
                                    unit = Unit.INSTANCE;
                                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel5;
                                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                                    tickerChannelsKt$fixedPeriodTicker$1.J$2 = j7;
                                    tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                                    tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                                    if (sendChannel5.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                                    }
                                }
                            } else {
                                long j122 = j5;
                                delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j122;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                                tickerChannelsKt$fixedPeriodTicker$1.J$2 = j9;
                                tickerChannelsKt$fixedPeriodTicker$1.J$3 = j8;
                                tickerChannelsKt$fixedPeriodTicker$1.J$4 = nanoTime;
                                tickerChannelsKt$fixedPeriodTicker$1.J$5 = coerceAtLeast;
                                c2 = 4;
                                tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                                if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                                    delayToNanos = j8;
                                    j11 = j10;
                                    j3 = j9;
                                    j4 = j122;
                                    sendChannel4 = sendChannel3;
                                    i2 = 2;
                                    sendChannel5 = sendChannel4;
                                    j7 = j3 + delayToNanos;
                                    unit = Unit.INSTANCE;
                                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel5;
                                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                                    tickerChannelsKt$fixedPeriodTicker$1.J$2 = j7;
                                    tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                                    tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                                    if (sendChannel5.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    long j28 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                    long j29 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    j4 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    j3 = j28;
                    j11 = j29;
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                }
                delayToNanos = EventLoop_commonKt.delayToNanos(j4);
                sendChannel5 = sendChannel2;
                j7 = j3 + delayToNanos;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel5;
                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                tickerChannelsKt$fixedPeriodTicker$1.J$2 = j7;
                tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                if (sendChannel5.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        tickerChannelsKt$fixedPeriodTicker$1 = new TickerChannelsKt$fixedPeriodTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedPeriodTicker$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tickerChannelsKt$fixedPeriodTicker$1.label;
        int i22 = 2;
        if (i != 0) {
        }
        delayToNanos = EventLoop_commonKt.delayToNanos(j4);
        sendChannel5 = sendChannel2;
        j7 = j3 + delayToNanos;
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel5;
        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
        tickerChannelsKt$fixedPeriodTicker$1.J$2 = j7;
        tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
        tickerChannelsKt$fixedPeriodTicker$1.label = i22;
        if (sendChannel5.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r10, r0) == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r10, r0) != r1) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008d -> B:14:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedDelayTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedDelayTicker$1 tickerChannelsKt$fixedDelayTicker$1;
        Object coroutine_suspended;
        int i;
        long j3;
        long j4;
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
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
                    tickerChannelsKt$fixedDelayTicker$1.label = 1;
                } else if (i == 1) {
                    j2 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                    j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    sendChannel = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    j4 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                    j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    sendChannel = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
                    tickerChannelsKt$fixedDelayTicker$1.label = 3;
                } else if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j4 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                    j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    sendChannel = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    long j5 = j3;
                    j2 = j4;
                    j = j5;
                }
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) != coroutine_suspended) {
                    long j6 = j2;
                    j3 = j;
                    j4 = j6;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
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
        tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
        tickerChannelsKt$fixedDelayTicker$1.label = 2;
        if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
