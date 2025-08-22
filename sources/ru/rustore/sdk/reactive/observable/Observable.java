package ru.rustore.sdk.reactive.observable;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.BackpressureStrategy;
/* compiled from: Observable.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\bB\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&¨\u0006\t"}, d2 = {"Lru/rustore/sdk/reactive/observable/Observable;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "subscribe", "", "downstream", "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "Companion", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class Observable<T> {
    public static final Companion Companion = new Companion(null);

    public abstract void subscribe(ObservableObserver<T> observableObserver);

    /* compiled from: Observable.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\n\u0012\u0004\u0012\u00020\u000b0\t¨\u0006\f"}, d2 = {"Lru/rustore/sdk/reactive/observable/Observable$Companion;", "", "()V", "create", "Lru/rustore/sdk/reactive/observable/Observable;", ExifInterface.GPS_DIRECTION_TRUE, "backpressureStrategy", "Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;", "source", "Lkotlin/Function1;", "Lru/rustore/sdk/reactive/observable/ObservableEmitter;", "", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Observable create$default(Companion companion, BackpressureStrategy backpressureStrategy, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                backpressureStrategy = new BackpressureStrategy.BufferDropLast(128);
            }
            return companion.create(backpressureStrategy, function1);
        }

        public final <T> Observable<T> create(BackpressureStrategy backpressureStrategy, Function1<? super ObservableEmitter<T>, Unit> source) {
            Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
            Intrinsics.checkNotNullParameter(source, "source");
            return new ObservableCreate(backpressureStrategy, source);
        }
    }
}
