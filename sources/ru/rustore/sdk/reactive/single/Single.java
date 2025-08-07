package ru.rustore.sdk.reactive.single;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Single.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\bB\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&¨\u0006\t"}, d2 = {"Lru/rustore/sdk/reactive/single/Single;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "subscribe", "", "downstream", "Lru/rustore/sdk/reactive/single/SingleObserver;", "Companion", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class Single<T> {
    public static final Companion Companion = new Companion(null);

    public abstract void subscribe(SingleObserver<T> singleObserver);

    /* compiled from: Single.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\b\u0012\u0004\u0012\u00020\t0\u0007J \u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b¨\u0006\f"}, d2 = {"Lru/rustore/sdk/reactive/single/Single$Companion;", "", "()V", "create", "Lru/rustore/sdk/reactive/single/Single;", ExifInterface.GPS_DIRECTION_TRUE, "source", "Lkotlin/Function1;", "Lru/rustore/sdk/reactive/single/SingleEmitter;", "", "from", "Lkotlin/Function0;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Single<T> from(Function0<? extends T> source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new SingleFrom(source);
        }

        public final <T> Single<T> create(Function1<? super SingleEmitter<T>, Unit> source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new SingleCreate(source);
        }
    }
}
