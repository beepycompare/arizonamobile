package ru.rustore.sdk.reactive.observable;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ObservableDistinctUntilChangeBy.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aT\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000126\u0010\u0004\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¨\u0006\u000b"}, d2 = {"distinctUntilChange", "Lru/rustore/sdk/reactive/observable/Observable;", ExifInterface.GPS_DIRECTION_TRUE, "distinctUntilChangeBy", "comparator", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "oldValue", "newValue", "", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ObservableDistinctUntilChangeByKt {
    public static final <T> Observable<T> distinctUntilChange(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        return new ObservableDistinctUntilChangeBy(observable, new Function2<T, T, Boolean>() { // from class: ru.rustore.sdk.reactive.observable.ObservableDistinctUntilChangeByKt$distinctUntilChange$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(T t, T t2) {
                return Boolean.valueOf(Intrinsics.areEqual(t, t2));
            }
        });
    }

    public static final <T> Observable<T> distinctUntilChangeBy(Observable<T> observable, Function2<? super T, ? super T, Boolean> comparator) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new ObservableDistinctUntilChangeBy(observable, comparator);
    }
}
