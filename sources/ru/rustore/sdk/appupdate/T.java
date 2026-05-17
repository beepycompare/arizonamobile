package ru.rustore.sdk.appupdate;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.core.tasks.OnCompletionListener;
import ru.rustore.sdk.core.tasks.Task;
import ru.rustore.sdk.reactive.core.Disposable;
import ru.rustore.sdk.reactive.single.Single;
import ru.rustore.sdk.reactive.single.SingleSubscribeKt;
/* loaded from: classes6.dex */
public final class T {

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function1<Throwable, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Task<T>.TaskResultProvider f1525a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Task<T>.TaskResultProvider taskResultProvider) {
            super(1);
            this.f1525a = taskResultProvider;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable error = th;
            Intrinsics.checkNotNullParameter(error, "error");
            this.f1525a.setTaskErrorResult(error);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes6.dex */
    public static final class b<T> extends Lambda implements Function1<T, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Task<T>.TaskResultProvider f1526a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Task<T>.TaskResultProvider taskResultProvider) {
            super(1);
            this.f1526a = taskResultProvider;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Object obj) {
            this.f1526a.setTaskSuccessResult(obj);
            return Unit.INSTANCE;
        }
    }

    public static final <T> Task<T> a(Single<T> single) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        Pair<Task<T>, Task<T>.TaskResultProvider> create = Task.Companion.create();
        Task<T> component1 = create.component1();
        Task<T>.TaskResultProvider component2 = create.component2();
        final Disposable subscribe = SingleSubscribeKt.subscribe(single, new a(component2), new b(component2));
        component1.addOnCompletionListener(new OnCompletionListener() { // from class: ru.rustore.sdk.appupdate.T$$ExternalSyntheticLambda0
            @Override // ru.rustore.sdk.core.tasks.OnCompletionListener
            public final void onComplete(Throwable th) {
                T.a(Disposable.this, th);
            }
        });
        return component1;
    }

    public static final void a(Disposable disposable, Throwable th) {
        Intrinsics.checkNotNullParameter(disposable, "$disposable");
        disposable.dispose();
    }
}
