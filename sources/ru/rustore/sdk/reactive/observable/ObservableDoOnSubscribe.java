package ru.rustore.sdk.reactive.observable;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Disposable;
/* compiled from: ObservableDoOnSubscribe.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/rustore/sdk/reactive/observable/ObservableDoOnSubscribe;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/observable/Observable;", "upstream", "onSubscribe", "Lkotlin/Function1;", "Lru/rustore/sdk/reactive/core/Disposable;", "", "(Lru/rustore/sdk/reactive/observable/Observable;Lkotlin/jvm/functions/Function1;)V", "subscribe", "downstream", "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
final class ObservableDoOnSubscribe<T> extends Observable<T> {
    private final Function1<Disposable, Unit> onSubscribe;
    private final Observable<T> upstream;

    /* JADX WARN: Multi-variable type inference failed */
    public ObservableDoOnSubscribe(Observable<T> upstream, Function1<? super Disposable, Unit> onSubscribe) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        Intrinsics.checkNotNullParameter(onSubscribe, "onSubscribe");
        this.upstream = upstream;
        this.onSubscribe = onSubscribe;
    }

    @Override // ru.rustore.sdk.reactive.observable.Observable
    public void subscribe(final ObservableObserver<T> downstream) {
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        this.upstream.subscribe(new ObservableObserver<T>(this) { // from class: ru.rustore.sdk.reactive.observable.ObservableDoOnSubscribe$subscribe$wrappedObserver$1
            final /* synthetic */ ObservableDoOnSubscribe<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
            public void onSubscribe(Disposable d) {
                Object m9106constructorimpl;
                Function1 function1;
                Intrinsics.checkNotNullParameter(d, "d");
                ObservableDoOnSubscribe<T> observableDoOnSubscribe = this.this$0;
                try {
                    Result.Companion companion = Result.Companion;
                    ObservableDoOnSubscribe$subscribe$wrappedObserver$1<T> observableDoOnSubscribe$subscribe$wrappedObserver$1 = this;
                    function1 = ((ObservableDoOnSubscribe) observableDoOnSubscribe).onSubscribe;
                    function1.invoke(d);
                    m9106constructorimpl = Result.m9106constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m9106constructorimpl = Result.m9106constructorimpl(ResultKt.createFailure(th));
                }
                ObservableObserver<T> observableObserver = downstream;
                Throwable m9109exceptionOrNullimpl = Result.m9109exceptionOrNullimpl(m9106constructorimpl);
                if (m9109exceptionOrNullimpl != null) {
                    d.dispose();
                    observableObserver.onSubscribe(d);
                    observableObserver.onError(m9109exceptionOrNullimpl);
                }
                ObservableObserver<T> observableObserver2 = downstream;
                if (Result.m9113isSuccessimpl(m9106constructorimpl)) {
                    Unit unit = (Unit) m9106constructorimpl;
                    observableObserver2.onSubscribe(d);
                }
            }

            @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
            public void onComplete() {
                downstream.onComplete();
            }

            @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
            public void onNext(T t) {
                downstream.onNext(t);
            }

            @Override // ru.rustore.sdk.reactive.observable.ObservableObserver
            public void onError(Throwable e) {
                Intrinsics.checkNotNullParameter(e, "e");
                downstream.onError(e);
            }
        });
    }
}
