package kotlinx.coroutines.rx2;

import androidx.exifinterface.media.ExifInterface;
import com.arizona.launcher.UpdateActivity;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
/* compiled from: RxAwait.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0003\u001a \u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u0006H\u0086@¢\u0006\u0002\u0010\u0007\u001a\u001e\u0010\b\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u0006H\u0086@¢\u0006\u0002\u0010\u0007\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u0006H\u0087@¢\u0006\u0002\u0010\u0007\u001a&\u0010\t\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00062\u0006\u0010\n\u001a\u0002H\u0005H\u0087@¢\u0006\u0002\u0010\u000b\u001a\u001e\u0010\u0000\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\fH\u0086@¢\u0006\u0002\u0010\r\u001a\u001e\u0010\u000e\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0086@¢\u0006\u0002\u0010\u0010\u001a&\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u000f2\u0006\u0010\n\u001a\u0002H\u0005H\u0086@¢\u0006\u0002\u0010\u0012\u001a \u0010\u0013\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0086@¢\u0006\u0002\u0010\u0010\u001a,\u0010\u0014\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0016H\u0086@¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u0018\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0086@¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\b\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0086@¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010\u0019\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000\u001a2\u0010\u001d\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010\n\u001a\u0004\u0018\u0001H\u0005H\u0082@¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"await", "", "Lio/reactivex/CompletableSource;", "(Lio/reactivex/CompletableSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingleOrNull", ExifInterface.GPS_DIRECTION_TRUE, "Lio/reactivex/MaybeSource;", "(Lio/reactivex/MaybeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingle", "awaitOrDefault", "default", "(Lio/reactivex/MaybeSource;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/SingleSource;", "(Lio/reactivex/SingleSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirst", "Lio/reactivex/ObservableSource;", "(Lio/reactivex/ObservableSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrDefault", "(Lio/reactivex/ObservableSource;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrNull", "awaitFirstOrElse", "defaultValue", "Lkotlin/Function0;", "(Lio/reactivex/ObservableSource;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLast", "disposeOnCancellation", "Lkotlinx/coroutines/CancellableContinuation;", "d", "Lio/reactivex/disposables/Disposable;", "awaitOne", UpdateActivity.UPDATE_MODE, "Lkotlinx/coroutines/rx2/Mode;", "(Lio/reactivex/ObservableSource;Lkotlinx/coroutines/rx2/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-rx2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RxAwaitKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object awaitSingle(MaybeSource<T> maybeSource, Continuation<? super T> continuation) {
        RxAwaitKt$awaitSingle$1 rxAwaitKt$awaitSingle$1;
        Object obj;
        int i;
        if (continuation instanceof RxAwaitKt$awaitSingle$1) {
            rxAwaitKt$awaitSingle$1 = (RxAwaitKt$awaitSingle$1) continuation;
            if ((rxAwaitKt$awaitSingle$1.label & Integer.MIN_VALUE) != 0) {
                rxAwaitKt$awaitSingle$1.label -= Integer.MIN_VALUE;
                obj = rxAwaitKt$awaitSingle$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = rxAwaitKt$awaitSingle$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    rxAwaitKt$awaitSingle$1.label = 1;
                    obj = awaitSingleOrNull(maybeSource, rxAwaitKt$awaitSingle$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                if (obj == null) {
                    return obj;
                }
                throw new NoSuchElementException();
            }
        }
        rxAwaitKt$awaitSingle$1 = new RxAwaitKt$awaitSingle$1(continuation);
        obj = rxAwaitKt$awaitSingle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxAwaitKt$awaitSingle$1.label;
        if (i != 0) {
        }
        if (obj == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045 A[RETURN] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of awaitSingleOrNull()", replaceWith = @ReplaceWith(expression = "this.awaitSingleOrNull() ?: default", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitOrDefault(MaybeSource maybeSource, Object obj, Continuation continuation) {
        RxAwaitKt$awaitOrDefault$1 rxAwaitKt$awaitOrDefault$1;
        int i;
        if (continuation instanceof RxAwaitKt$awaitOrDefault$1) {
            rxAwaitKt$awaitOrDefault$1 = (RxAwaitKt$awaitOrDefault$1) continuation;
            if ((rxAwaitKt$awaitOrDefault$1.label & Integer.MIN_VALUE) != 0) {
                rxAwaitKt$awaitOrDefault$1.label -= Integer.MIN_VALUE;
                Object obj2 = rxAwaitKt$awaitOrDefault$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = rxAwaitKt$awaitOrDefault$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    rxAwaitKt$awaitOrDefault$1.L$0 = obj;
                    rxAwaitKt$awaitOrDefault$1.label = 1;
                    obj2 = awaitSingleOrNull(maybeSource, rxAwaitKt$awaitOrDefault$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    obj = rxAwaitKt$awaitOrDefault$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                return obj2 != null ? obj : obj2;
            }
        }
        rxAwaitKt$awaitOrDefault$1 = new RxAwaitKt$awaitOrDefault$1(continuation);
        Object obj22 = rxAwaitKt$awaitOrDefault$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxAwaitKt$awaitOrDefault$1.label;
        if (i != 0) {
        }
        if (obj22 != null) {
        }
    }

    public static final <T> Object awaitFirst(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        return awaitOne$default(observableSource, Mode.FIRST, null, continuation, 2, null);
    }

    public static final <T> Object awaitFirstOrDefault(ObservableSource<T> observableSource, T t, Continuation<? super T> continuation) {
        return awaitOne(observableSource, Mode.FIRST_OR_DEFAULT, t, continuation);
    }

    public static final <T> Object awaitFirstOrNull(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        return awaitOne$default(observableSource, Mode.FIRST_OR_DEFAULT, null, continuation, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object awaitFirstOrElse(ObservableSource<T> observableSource, Function0<? extends T> function0, Continuation<? super T> continuation) {
        RxAwaitKt$awaitFirstOrElse$1 rxAwaitKt$awaitFirstOrElse$1;
        int i;
        if (continuation instanceof RxAwaitKt$awaitFirstOrElse$1) {
            rxAwaitKt$awaitFirstOrElse$1 = (RxAwaitKt$awaitFirstOrElse$1) continuation;
            if ((rxAwaitKt$awaitFirstOrElse$1.label & Integer.MIN_VALUE) != 0) {
                rxAwaitKt$awaitFirstOrElse$1.label -= Integer.MIN_VALUE;
                RxAwaitKt$awaitFirstOrElse$1 rxAwaitKt$awaitFirstOrElse$12 = rxAwaitKt$awaitFirstOrElse$1;
                Object obj = rxAwaitKt$awaitFirstOrElse$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = rxAwaitKt$awaitFirstOrElse$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Mode mode = Mode.FIRST_OR_DEFAULT;
                    rxAwaitKt$awaitFirstOrElse$12.L$0 = function0;
                    rxAwaitKt$awaitFirstOrElse$12.label = 1;
                    obj = awaitOne$default(observableSource, mode, null, rxAwaitKt$awaitFirstOrElse$12, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    function0 = (Function0) rxAwaitKt$awaitFirstOrElse$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return obj != null ? function0.invoke() : obj;
            }
        }
        rxAwaitKt$awaitFirstOrElse$1 = new RxAwaitKt$awaitFirstOrElse$1(continuation);
        RxAwaitKt$awaitFirstOrElse$1 rxAwaitKt$awaitFirstOrElse$122 = rxAwaitKt$awaitFirstOrElse$1;
        Object obj2 = rxAwaitKt$awaitFirstOrElse$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxAwaitKt$awaitFirstOrElse$122.label;
        if (i != 0) {
        }
        if (obj2 != null) {
        }
    }

    public static final <T> Object awaitLast(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        return awaitOne$default(observableSource, Mode.LAST, null, continuation, 2, null);
    }

    public static final <T> Object awaitSingle(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        return awaitOne$default(observableSource, Mode.SINGLE, null, continuation, 2, null);
    }

    public static final void disposeOnCancellation(CancellableContinuation<?> cancellableContinuation, final Disposable disposable) {
        cancellableContinuation.invokeOnCancellation(new Function1() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit disposeOnCancellation$lambda$3;
                disposeOnCancellation$lambda$3 = RxAwaitKt.disposeOnCancellation$lambda$3(Disposable.this, (Throwable) obj);
                return disposeOnCancellation$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit disposeOnCancellation$lambda$3(Disposable disposable, Throwable th) {
        disposable.dispose();
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object awaitOne$default(ObservableSource observableSource, Mode mode, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return awaitOne(observableSource, mode, obj, continuation);
    }

    public static final Object await(CompletableSource completableSource, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        completableSource.subscribe(new CompletableObserver() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$await$2$1
            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                RxAwaitKt.disposeOnCancellation(cancellableContinuationImpl2, disposable);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(Unit.INSTANCE));
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(ResultKt.createFailure(th)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public static final <T> Object awaitSingleOrNull(MaybeSource<T> maybeSource, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        maybeSource.subscribe((MaybeObserver) ((MaybeObserver<T>) new MaybeObserver<T>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$awaitSingleOrNull$2$1
            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                RxAwaitKt.disposeOnCancellation(cancellableContinuationImpl2, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(null));
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(T t) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(t));
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(ResultKt.createFailure(th)));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object await(SingleSource<T> singleSource, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        singleSource.subscribe((SingleObserver) ((SingleObserver<T>) new SingleObserver<T>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$await$5$1
            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                RxAwaitKt.disposeOnCancellation(cancellableContinuationImpl2, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T t) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(t));
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(ResultKt.createFailure(th)));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object awaitOne(ObservableSource<T> observableSource, final Mode mode, final T t, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        observableSource.subscribe((Observer) ((Observer<T>) new Observer<T>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$awaitOne$2$1
            private boolean seenValue;
            private Disposable subscription;
            private T value;

            /* compiled from: RxAwait.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes5.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Mode.values().length];
                    try {
                        iArr[Mode.FIRST.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Mode.FIRST_OR_DEFAULT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Mode.LAST.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Mode.SINGLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(final Disposable disposable) {
                this.subscription = disposable;
                cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$awaitOne$2$1$onSubscribe$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Disposable.this.dispose();
                    }
                });
            }

            @Override // io.reactivex.Observer
            public void onNext(T t2) {
                int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
                Disposable disposable = null;
                if (i == 1 || i == 2) {
                    if (this.seenValue) {
                        return;
                    }
                    this.seenValue = true;
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(t2));
                    Disposable disposable2 = this.subscription;
                    if (disposable2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("subscription");
                    } else {
                        disposable = disposable2;
                    }
                    disposable.dispose();
                } else if (i != 3 && i != 4) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    if (mode == Mode.SINGLE && this.seenValue) {
                        if (cancellableContinuationImpl2.isActive()) {
                            Result.Companion companion2 = Result.Companion;
                            cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(ResultKt.createFailure(new IllegalArgumentException("More than one onNext value for " + mode))));
                        }
                        Disposable disposable3 = this.subscription;
                        if (disposable3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("subscription");
                        } else {
                            disposable = disposable3;
                        }
                        disposable.dispose();
                        return;
                    }
                    this.value = t2;
                    this.seenValue = true;
                }
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                if (this.seenValue) {
                    if (cancellableContinuationImpl2.isActive()) {
                        Result.Companion companion = Result.Companion;
                        cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(this.value));
                    }
                } else if (mode == Mode.FIRST_OR_DEFAULT) {
                    Result.Companion companion2 = Result.Companion;
                    cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(t));
                } else if (cancellableContinuationImpl2.isActive()) {
                    Result.Companion companion3 = Result.Companion;
                    cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(ResultKt.createFailure(new NoSuchElementException("No value received via onNext for " + mode))));
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8443constructorimpl(ResultKt.createFailure(th)));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
