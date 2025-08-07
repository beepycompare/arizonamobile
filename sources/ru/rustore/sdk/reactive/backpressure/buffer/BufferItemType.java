package ru.rustore.sdk.reactive.backpressure.buffer;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BufferItemType.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/rustore/sdk/reactive/backpressure/buffer/BufferItemType;", "", "()V", "Complete", "Error", "Item", "Lru/rustore/sdk/reactive/backpressure/buffer/BufferItemType$Complete;", "Lru/rustore/sdk/reactive/backpressure/buffer/BufferItemType$Error;", "Lru/rustore/sdk/reactive/backpressure/buffer/BufferItemType$Item;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BufferItemType {
    public /* synthetic */ BufferItemType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BufferItemType() {
    }

    /* compiled from: BufferItemType.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/rustore/sdk/reactive/backpressure/buffer/BufferItemType$Complete;", "Lru/rustore/sdk/reactive/backpressure/buffer/BufferItemType;", "()V", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Complete extends BufferItemType {
        public static final Complete INSTANCE = new Complete();

        private Complete() {
            super(null);
        }
    }

    /* compiled from: BufferItemType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/rustore/sdk/reactive/backpressure/buffer/BufferItemType$Error;", "Lru/rustore/sdk/reactive/backpressure/buffer/BufferItemType;", "e", "", "(Ljava/lang/Throwable;)V", "getE", "()Ljava/lang/Throwable;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Error extends BufferItemType {
        private final Throwable e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable e) {
            super(null);
            Intrinsics.checkNotNullParameter(e, "e");
            this.e = e;
        }

        public final Throwable getE() {
            return this.e;
        }
    }

    /* compiled from: BufferItemType.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lru/rustore/sdk/reactive/backpressure/buffer/BufferItemType$Item;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/backpressure/buffer/BufferItemType;", "item", "(Ljava/lang/Object;)V", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Item<T> extends BufferItemType {
        private final T item;

        public Item(T t) {
            super(null);
            this.item = t;
        }

        public final T getItem() {
            return this.item;
        }
    }
}
