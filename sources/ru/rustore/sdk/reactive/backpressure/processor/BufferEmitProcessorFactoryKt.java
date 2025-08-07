package ru.rustore.sdk.reactive.backpressure.processor;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.BackpressureStrategy;
import ru.rustore.sdk.reactive.core.Dispatcher;
import ru.rustore.sdk.reactive.observable.ObservableObserver;
/* compiled from: BufferEmitProcessorFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000¨\u0006\b"}, d2 = {"createBufferEmitProcessor", "Lru/rustore/sdk/reactive/backpressure/processor/BufferEmitProcessor;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;", "downstream", "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "dispatcher", "Lru/rustore/sdk/reactive/core/Dispatcher;", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BufferEmitProcessorFactoryKt {
    public static /* synthetic */ BufferEmitProcessor createBufferEmitProcessor$default(BackpressureStrategy backpressureStrategy, ObservableObserver observableObserver, Dispatcher dispatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            dispatcher = null;
        }
        return createBufferEmitProcessor(backpressureStrategy, observableObserver, dispatcher);
    }

    public static final <T> BufferEmitProcessor<T> createBufferEmitProcessor(BackpressureStrategy backpressureStrategy, ObservableObserver<T> downstream, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(backpressureStrategy, "<this>");
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        if (backpressureStrategy instanceof BackpressureStrategy.BufferDropLast) {
            return new BufferDropLastEmitProcessor(downstream, ((BackpressureStrategy.BufferDropLast) backpressureStrategy).getBufferSize(), dispatcher);
        }
        if (backpressureStrategy instanceof BackpressureStrategy.BufferDropOldest) {
            return new BufferDropOldestEmitProcessor(downstream, ((BackpressureStrategy.BufferDropOldest) backpressureStrategy).getBufferSize(), dispatcher);
        }
        throw new NoWhenBranchMatchedException();
    }
}
