package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
/* compiled from: ConflatedBufferedChannel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00028\u0000H\u0090@¢\u0006\u0004\b\u0014\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0004\b \u0010\u0018J\u001e\u0010!\u001a\u00020\t2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#2\b\u0010\u0011\u001a\u0004\u0018\u00010$H\u0014J\r\u0010%\u001a\u00020\u000eH\u0010¢\u0006\u0002\b&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006'"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BufferedChannel;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "isConflatedDropOldest", "", "()Z", "send", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendImpl", "isSendOp", "trySendImpl-Mj0NB7M", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "trySendDropLatest", "trySendDropLatest-Mj0NB7M", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ConflatedBufferedChannel<E> extends BufferedChannel<E> {
    private final int capacity;
    private final BufferOverflow onBufferOverflow;

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        return send$suspendImpl((ConflatedBufferedChannel) this, (Object) e, continuation);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public Object sendBroadcast$kotlinx_coroutines_core(E e, Continuation<? super Boolean> continuation) {
        return sendBroadcast$suspendImpl((ConflatedBufferedChannel) this, (Object) e, continuation);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return false;
    }

    public ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(i, function1);
        this.capacity = i;
        this.onBufferOverflow = bufferOverflow;
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
        }
        if (i < 1) {
            throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i + " was specified").toString());
        }
    }

    public /* synthetic */ ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bufferOverflow, (i2 & 4) != 0 ? null : function1);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected boolean isConflatedDropOldest() {
        return this.onBufferOverflow == BufferOverflow.DROP_OLDEST;
    }

    static /* synthetic */ <E> Object send$suspendImpl(ConflatedBufferedChannel<E> conflatedBufferedChannel, E e, Continuation<? super Unit> continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        Object m11486trySendImplMj0NB7M = conflatedBufferedChannel.m11486trySendImplMj0NB7M(e, true);
        if (m11486trySendImplMj0NB7M instanceof ChannelResult.Closed) {
            ChannelResult.m11472exceptionOrNullimpl(m11486trySendImplMj0NB7M);
            Function1<E, Unit> function1 = conflatedBufferedChannel.onUndeliveredElement;
            if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) != null) {
                ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, conflatedBufferedChannel.getSendException());
                throw callUndeliveredElementCatchingException$default;
            }
            throw conflatedBufferedChannel.getSendException();
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ <E> Object sendBroadcast$suspendImpl(ConflatedBufferedChannel<E> conflatedBufferedChannel, E e, Continuation<? super Boolean> continuation) {
        Object m11486trySendImplMj0NB7M = conflatedBufferedChannel.m11486trySendImplMj0NB7M(e, true);
        if (!(m11486trySendImplMj0NB7M instanceof ChannelResult.Failed)) {
            Unit unit = (Unit) m11486trySendImplMj0NB7M;
            return Boxing.boxBoolean(true);
        }
        return Boxing.boxBoolean(false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo9057trySendJP2dKIU(E e) {
        return m11486trySendImplMj0NB7M(e, false);
    }

    /* renamed from: trySendImpl-Mj0NB7M  reason: not valid java name */
    private final Object m11486trySendImplMj0NB7M(E e, boolean z) {
        return this.onBufferOverflow == BufferOverflow.DROP_LATEST ? m11484trySendDropLatestMj0NB7M(e, z) : m11485trySendDropOldestJP2dKIU(e);
    }

    /* renamed from: trySendDropLatest-Mj0NB7M  reason: not valid java name */
    private final Object m11484trySendDropLatestMj0NB7M(E e, boolean z) {
        Function1<E, Unit> function1;
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        Object mo9057trySendJP2dKIU = super.mo9057trySendJP2dKIU(e);
        if (ChannelResult.m11478isSuccessimpl(mo9057trySendJP2dKIU) || ChannelResult.m11476isClosedimpl(mo9057trySendJP2dKIU)) {
            return mo9057trySendJP2dKIU;
        }
        if (z && (function1 = this.onUndeliveredElement) != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) != null) {
            throw callUndeliveredElementCatchingException$default;
        }
        return ChannelResult.Companion.m11483successJP2dKIU(Unit.INSTANCE);
    }

    /* renamed from: trySendDropOldest-JP2dKIU  reason: not valid java name */
    private final Object m11485trySendDropOldestJP2dKIU(E e) {
        ConflatedBufferedChannel<E> conflatedBufferedChannel = this;
        Symbol symbol = BufferedChannelKt.BUFFERED;
        ChannelSegment channelSegment = (ChannelSegment) BufferedChannel.sendSegment$volatile$FU.get(conflatedBufferedChannel);
        while (true) {
            long andIncrement = BufferedChannel.sendersAndCloseStatus$volatile$FU.getAndIncrement(conflatedBufferedChannel);
            long j = 1152921504606846975L & andIncrement;
            boolean isClosedForSend0 = conflatedBufferedChannel.isClosedForSend0(andIncrement);
            long j2 = j / BufferedChannelKt.SEGMENT_SIZE;
            int i = (int) (j % BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != j2) {
                ChannelSegment findSegmentSend = conflatedBufferedChannel.findSegmentSend(j2, channelSegment);
                if (findSegmentSend != null) {
                    channelSegment = findSegmentSend;
                } else if (isClosedForSend0) {
                    return ChannelResult.Companion.m11481closedJP2dKIU(getSendException());
                }
            }
            E e2 = e;
            int updateCellSend = conflatedBufferedChannel.updateCellSend(channelSegment, i, e2, j, symbol, isClosedForSend0);
            if (updateCellSend == 0) {
                channelSegment.cleanPrev();
                return ChannelResult.Companion.m11483successJP2dKIU(Unit.INSTANCE);
            } else if (updateCellSend == 1) {
                return ChannelResult.Companion.m11483successJP2dKIU(Unit.INSTANCE);
            } else {
                if (updateCellSend == 2) {
                    if (isClosedForSend0) {
                        channelSegment.onSlotCleaned();
                        return ChannelResult.Companion.m11481closedJP2dKIU(getSendException());
                    }
                    Waiter waiter = symbol instanceof Waiter ? (Waiter) symbol : null;
                    if (waiter != null) {
                        conflatedBufferedChannel.prepareSenderForSuspension(waiter, channelSegment, i);
                    }
                    dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment.id * BufferedChannelKt.SEGMENT_SIZE) + i);
                    return ChannelResult.Companion.m11483successJP2dKIU(Unit.INSTANCE);
                } else if (updateCellSend == 3) {
                    throw new IllegalStateException("unexpected".toString());
                } else {
                    if (updateCellSend == 4) {
                        if (j < conflatedBufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        return ChannelResult.Companion.m11481closedJP2dKIU(getSendException());
                    }
                    if (updateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                    e = e2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void registerSelectForSend(SelectInstance<?> selectInstance, Object obj) {
        Object mo9057trySendJP2dKIU = mo9057trySendJP2dKIU(obj);
        if (!(mo9057trySendJP2dKIU instanceof ChannelResult.Failed)) {
            Unit unit = (Unit) mo9057trySendJP2dKIU;
            selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
        } else if (!(mo9057trySendJP2dKIU instanceof ChannelResult.Closed)) {
            throw new IllegalStateException("unreachable".toString());
        } else {
            ChannelResult.m11472exceptionOrNullimpl(mo9057trySendJP2dKIU);
            selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
        }
    }
}
