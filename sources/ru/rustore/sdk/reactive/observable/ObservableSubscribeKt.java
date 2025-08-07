package ru.rustore.sdk.reactive.observable;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Disposable;
import ru.rustore.sdk.reactive.core.ErrorStubKt;
/* compiled from: ObservableSubscribe.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aP\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0005¨\u0006\u000b"}, d2 = {"subscribe", "Lru/rustore/sdk/reactive/core/Disposable;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/observable/Observable;", "onError", "Lkotlin/Function1;", "", "", "onComplete", "Lkotlin/Function0;", "onNext", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ObservableSubscribeKt {
    public static /* synthetic */ Disposable subscribe$default(Observable observable, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ErrorStubKt.getErrorStub();
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: ru.rustore.sdk.reactive.observable.ObservableSubscribeKt$subscribe$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        return subscribe(observable, function1, function0, function12);
    }

    public static final <T> Disposable subscribe(Observable<T> observable, Function1<? super Throwable, Unit> onError, Function0<Unit> onComplete, Function1<? super T, Unit> onNext) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        Intrinsics.checkNotNullParameter(onNext, "onNext");
        ObservableSubscribeObserver observableSubscribeObserver = new ObservableSubscribeObserver(onError, onComplete, onNext);
        observable.subscribe(observableSubscribeObserver);
        return observableSubscribeObserver;
    }
}
