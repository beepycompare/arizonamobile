package ru.rustore.sdk.reactive.subject;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.BackpressureStrategy;
import ru.rustore.sdk.reactive.observable.Observable;
/* compiled from: ReadOnlyStateSubject.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00028\u0000X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lru/rustore/sdk/reactive/subject/ReadOnlyStateSubject;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/subject/StateSubject;", "stateSubject", "(Lru/rustore/sdk/reactive/subject/StateSubject;)V", "value", "getValue", "()Ljava/lang/Object;", "observe", "Lru/rustore/sdk/reactive/observable/Observable;", "backpressureStrategy", "Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ReadOnlyStateSubject<T> implements StateSubject<T> {
    private final StateSubject<T> stateSubject;

    @Override // ru.rustore.sdk.reactive.subject.StateSubject
    public T getValue() {
        return this.stateSubject.getValue();
    }

    @Override // ru.rustore.sdk.reactive.subject.Subject
    public Observable<T> observe(BackpressureStrategy backpressureStrategy) {
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        return this.stateSubject.observe(backpressureStrategy);
    }

    public ReadOnlyStateSubject(StateSubject<T> stateSubject) {
        Intrinsics.checkNotNullParameter(stateSubject, "stateSubject");
        this.stateSubject = stateSubject;
    }
}
