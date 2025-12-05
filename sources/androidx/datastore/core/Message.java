package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
/* compiled from: Message.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\t\nB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Landroidx/datastore/core/Message;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "lastState", "Landroidx/datastore/core/State;", "getLastState", "()Landroidx/datastore/core/State;", "Read", "Update", "Landroidx/datastore/core/Message$Read;", "Landroidx/datastore/core/Message$Update;", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class Message<T> {
    public /* synthetic */ Message(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract State<T> getLastState();

    private Message() {
    }

    /* compiled from: Message.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/datastore/core/Message$Read;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/Message;", "lastState", "Landroidx/datastore/core/State;", "<init>", "(Landroidx/datastore/core/State;)V", "getLastState", "()Landroidx/datastore/core/State;", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Read<T> extends Message<T> {
        private final State<T> lastState;

        public Read(State<T> state) {
            super(null);
            this.lastState = state;
        }

        @Override // androidx.datastore.core.Message
        public State<T> getLastState() {
            return this.lastState;
        }
    }

    /* compiled from: Message.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B`\u00121\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R>\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/datastore/core/Message$Update;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/Message;", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "ack", "Lkotlinx/coroutines/CompletableDeferred;", "lastState", "Landroidx/datastore/core/State;", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CompletableDeferred;Landroidx/datastore/core/State;Lkotlin/coroutines/CoroutineContext;)V", "getTransform", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getAck", "()Lkotlinx/coroutines/CompletableDeferred;", "getLastState", "()Landroidx/datastore/core/State;", "getCallerContext", "()Lkotlin/coroutines/CoroutineContext;", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Update<T> extends Message<T> {
        private final CompletableDeferred<T> ack;
        private final CoroutineContext callerContext;
        private final State<T> lastState;
        private final Function2<T, Continuation<? super T>, Object> transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Update(Function2<? super T, ? super Continuation<? super T>, ? extends Object> transform, CompletableDeferred<T> ack, State<T> state, CoroutineContext callerContext) {
            super(null);
            Intrinsics.checkNotNullParameter(transform, "transform");
            Intrinsics.checkNotNullParameter(ack, "ack");
            Intrinsics.checkNotNullParameter(callerContext, "callerContext");
            this.transform = transform;
            this.ack = ack;
            this.lastState = state;
            this.callerContext = callerContext;
        }

        public final Function2<T, Continuation<? super T>, Object> getTransform() {
            return this.transform;
        }

        public final CompletableDeferred<T> getAck() {
            return this.ack;
        }

        @Override // androidx.datastore.core.Message
        public State<T> getLastState() {
            return this.lastState;
        }

        public final CoroutineContext getCallerContext() {
            return this.callerContext;
        }
    }
}
