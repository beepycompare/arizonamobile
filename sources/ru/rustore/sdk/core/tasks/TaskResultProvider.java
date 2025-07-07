package ru.rustore.sdk.core.tasks;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Task.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fR7\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR7\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\r¨\u0006\u0015"}, d2 = {"Lru/rustore/sdk/core/tasks/TaskResultProvider;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "onDataTaskResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "data", "", "getOnDataTaskResult", "()Lkotlin/jvm/functions/Function1;", "setOnDataTaskResult", "(Lkotlin/jvm/functions/Function1;)V", "onErrorTaskResult", "", "error", "getOnErrorTaskResult", "setOnErrorTaskResult", "setTaskResult", "(Ljava/lang/Object;)V", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskResultProvider<T> {
    private Function1<? super T, Unit> onDataTaskResult;
    private Function1<? super Throwable, Unit> onErrorTaskResult;

    public final Function1<T, Unit> getOnDataTaskResult() {
        return (Function1<? super T, Unit>) this.onDataTaskResult;
    }

    public final void setOnDataTaskResult(Function1<? super T, Unit> function1) {
        this.onDataTaskResult = function1;
    }

    public final Function1<Throwable, Unit> getOnErrorTaskResult() {
        return this.onErrorTaskResult;
    }

    public final void setOnErrorTaskResult(Function1<? super Throwable, Unit> function1) {
        this.onErrorTaskResult = function1;
    }

    public final void setTaskResult(T t) {
        Function1<? super T, Unit> function1 = this.onDataTaskResult;
        if (function1 != null) {
            function1.invoke(t);
        }
    }

    public final void setTaskResult(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Function1<? super Throwable, Unit> function1 = this.onErrorTaskResult;
        if (function1 != null) {
            function1.invoke(error);
        }
    }
}
