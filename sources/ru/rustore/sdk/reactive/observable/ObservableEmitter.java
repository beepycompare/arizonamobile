package ru.rustore.sdk.reactive.observable;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.processor.BufferEmitProcessor;
/* compiled from: ObservableEmitter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/rustore/sdk/reactive/observable/ObservableEmitter;", ExifInterface.GPS_DIRECTION_TRUE, "", "emitProcessor", "Lru/rustore/sdk/reactive/backpressure/processor/BufferEmitProcessor;", "(Lru/rustore/sdk/reactive/backpressure/processor/BufferEmitProcessor;)V", "isDisposed", "", "onComplete", "", "onError", "e", "", "onNext", "item", "(Ljava/lang/Object;)V", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ObservableEmitter<T> {
    private final BufferEmitProcessor<T> emitProcessor;

    public ObservableEmitter(BufferEmitProcessor<T> emitProcessor) {
        Intrinsics.checkNotNullParameter(emitProcessor, "emitProcessor");
        this.emitProcessor = emitProcessor;
    }

    public final boolean isDisposed() {
        return this.emitProcessor.isDisposed();
    }

    public final void onNext(T t) {
        this.emitProcessor.emit(t);
        this.emitProcessor.drain();
    }

    public final void onComplete() {
        this.emitProcessor.complete();
        this.emitProcessor.drain();
    }

    public final void onError(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.emitProcessor.error(e);
        this.emitProcessor.drain();
    }
}
