package ru.rustore.sdk.core.tasks;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Task.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B/\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lru/rustore/sdk/core/tasks/ListenerHandler;", ExifInterface.GPS_DIRECTION_TRUE, "", "onSuccess", "Lru/rustore/sdk/core/tasks/OnSuccessListener;", "onFailure", "Lru/rustore/sdk/core/tasks/OnFailureListener;", "executor", "Ljava/util/concurrent/Executor;", "(Lru/rustore/sdk/core/tasks/OnSuccessListener;Lru/rustore/sdk/core/tasks/OnFailureListener;Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "getOnFailure", "()Lru/rustore/sdk/core/tasks/OnFailureListener;", "getOnSuccess", "()Lru/rustore/sdk/core/tasks/OnSuccessListener;", "sdk-public-core_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
final class ListenerHandler<T> {
    private final Executor executor;
    private final OnFailureListener onFailure;
    private final OnSuccessListener<T> onSuccess;

    public ListenerHandler() {
        this(null, null, null, 7, null);
    }

    public ListenerHandler(OnSuccessListener<T> onSuccessListener, OnFailureListener onFailureListener, Executor executor) {
        this.onSuccess = onSuccessListener;
        this.onFailure = onFailureListener;
        this.executor = executor;
    }

    public /* synthetic */ ListenerHandler(OnSuccessListener onSuccessListener, OnFailureListener onFailureListener, Executor executor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : onSuccessListener, (i & 2) != 0 ? null : onFailureListener, (i & 4) != 0 ? null : executor);
    }

    public final OnSuccessListener<T> getOnSuccess() {
        return this.onSuccess;
    }

    public final OnFailureListener getOnFailure() {
        return this.onFailure;
    }

    public final Executor getExecutor() {
        return this.executor;
    }
}
