package ru.rustore.sdk.reactive.single;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Disposable;
import ru.rustore.sdk.reactive.core.ErrorStubKt;
/* compiled from: SingleSubscribe.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a@\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0005¨\u0006\t"}, d2 = {"subscribe", "Lru/rustore/sdk/reactive/core/Disposable;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/single/Single;", "onError", "Lkotlin/Function1;", "", "", "onSuccess", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SingleSubscribeKt {
    public static /* synthetic */ Disposable subscribe$default(Single single, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ErrorStubKt.getErrorStub();
        }
        return subscribe(single, function1, function12);
    }

    public static final <T> Disposable subscribe(Single<T> single, Function1<? super Throwable, Unit> onError, Function1<? super T, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        SingleSubscribeObserver singleSubscribeObserver = new SingleSubscribeObserver(onError, onSuccess);
        single.subscribe(singleSubscribeObserver);
        return singleSubscribeObserver;
    }
}
