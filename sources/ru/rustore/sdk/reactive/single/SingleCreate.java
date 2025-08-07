package ru.rustore.sdk.reactive.single;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SingleCreate.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016R \u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/rustore/sdk/reactive/single/SingleCreate;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/single/Single;", "source", "Lkotlin/Function1;", "Lru/rustore/sdk/reactive/single/SingleEmitter;", "", "(Lkotlin/jvm/functions/Function1;)V", "subscribe", "downstream", "Lru/rustore/sdk/reactive/single/SingleObserver;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SingleCreate<T> extends Single<T> {
    private final Function1<SingleEmitter<T>, Unit> source;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleCreate(Function1<? super SingleEmitter<T>, Unit> source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    @Override // ru.rustore.sdk.reactive.single.Single
    public void subscribe(SingleObserver<T> downstream) {
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        SingleEmitterImpl singleEmitterImpl = new SingleEmitterImpl(downstream);
        downstream.onSubscribe(singleEmitterImpl);
        try {
            this.source.invoke(singleEmitterImpl);
        } catch (Throwable th) {
            singleEmitterImpl.error(th);
        }
    }
}
