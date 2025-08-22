package ru.rustore.sdk.reactive.backpressure.processor;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.buffer.Buffer;
import ru.rustore.sdk.reactive.backpressure.buffer.BufferItemType;
import ru.rustore.sdk.reactive.core.Dispatcher;
import ru.rustore.sdk.reactive.core.Disposable;
import ru.rustore.sdk.reactive.observable.ObservableObserver;
/* compiled from: BufferEmitProcessor.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0006\u0010\u0014\u001a\u00020\u0012J\u0013\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0002J$\u0010 \u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000!H&R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lru/rustore/sdk/reactive/backpressure/processor/BufferEmitProcessor;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/core/Disposable;", "downStream", "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "bufferSize", "", "dispatcher", "Lru/rustore/sdk/reactive/core/Dispatcher;", "(Lru/rustore/sdk/reactive/observable/ObservableObserver;ILru/rustore/sdk/reactive/core/Dispatcher;)V", "buffer", "Lru/rustore/sdk/reactive/backpressure/buffer/Buffer;", "isDrainActive", "", "monitor", "", "streamDone", "complete", "", "dispose", "drain", "emit", "item", "(Ljava/lang/Object;)V", "emitAll", FirebaseAnalytics.Param.ITEMS, "", "error", "e", "", "isDisposed", "loop", "onOverflow", "Lru/rustore/sdk/reactive/backpressure/buffer/BufferItemType$Item;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class BufferEmitProcessor<T> implements Disposable {
    private final Buffer<T> buffer;
    private final int bufferSize;
    private final Dispatcher dispatcher;
    private final ObservableObserver<T> downStream;
    private boolean isDrainActive;
    private final Object monitor;
    private boolean streamDone;

    public abstract void onOverflow(Buffer<T> buffer, BufferItemType.Item<T> item);

    public BufferEmitProcessor(ObservableObserver<T> downStream, int i, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(downStream, "downStream");
        this.downStream = downStream;
        this.bufferSize = i;
        this.dispatcher = dispatcher;
        Object obj = new Object();
        this.monitor = obj;
        this.buffer = new Buffer<>(obj);
    }

    public final void complete() {
        synchronized (this.monitor) {
            if (this.streamDone) {
                return;
            }
            this.streamDone = true;
            this.buffer.offer(BufferItemType.Complete.INSTANCE);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void error(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        synchronized (this.monitor) {
            if (this.streamDone) {
                return;
            }
            this.streamDone = true;
            this.buffer.clear();
            this.buffer.offer(new BufferItemType.Error(e));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void emit(T t) {
        synchronized (this.monitor) {
            if (this.streamDone) {
                return;
            }
            if (this.buffer.size() >= this.bufferSize) {
                onOverflow(this.buffer, new BufferItemType.Item<>(t));
            } else {
                this.buffer.offer(new BufferItemType.Item(t));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void emitAll(List<? extends T> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        synchronized (this.monitor) {
            for (T t : items) {
                emit(t);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void drain() {
        synchronized (this.monitor) {
            if (this.isDrainActive) {
                return;
            }
            this.isDrainActive = true;
            Unit unit = Unit.INSTANCE;
            Dispatcher dispatcher = this.dispatcher;
            if (dispatcher != null) {
                dispatcher.execute(new Function0<Unit>(this) { // from class: ru.rustore.sdk.reactive.backpressure.processor.BufferEmitProcessor$drain$2
                    final /* synthetic */ BufferEmitProcessor<T> this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        this.this$0.loop();
                    }
                });
            } else {
                loop();
            }
        }
    }

    @Override // ru.rustore.sdk.reactive.core.Disposable
    public boolean isDisposed() {
        boolean z;
        synchronized (this.monitor) {
            z = this.streamDone;
        }
        return z;
    }

    @Override // ru.rustore.sdk.reactive.core.Disposable
    public void dispose() {
        synchronized (this.monitor) {
            this.streamDone = true;
            this.buffer.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void loop() {
        BufferItemType popFirstOrNull;
        while (true) {
            synchronized (this.monitor) {
                popFirstOrNull = this.buffer.popFirstOrNull();
                if (popFirstOrNull == null) {
                    this.isDrainActive = false;
                    return;
                }
            }
            if (popFirstOrNull instanceof BufferItemType.Item) {
                this.downStream.onNext(((BufferItemType.Item) popFirstOrNull).getItem());
            } else if (popFirstOrNull instanceof BufferItemType.Error) {
                this.downStream.onError(((BufferItemType.Error) popFirstOrNull).getE());
            } else if (Intrinsics.areEqual(popFirstOrNull, BufferItemType.Complete.INSTANCE)) {
                this.downStream.onComplete();
            }
        }
    }
}
