package retrofit2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.KotlinNothingValueException;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
/* compiled from: KotlinExtensions.kt */
@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004\u001a\"\u0010\u0005\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u0007\u001a(\u0010\u0005\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006H\u0087@¢\u0006\u0004\b\b\u0010\u0007\u001a\u001a\u0010\u0005\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\t0\u0006H\u0087@¢\u0006\u0004\b\n\u0010\u0007\u001a$\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00010\f\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u0007\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0080@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"create", ExifInterface.GPS_DIRECTION_TRUE, "", "Lretrofit2/Retrofit;", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", "await", "Lretrofit2/Call;", "(Lretrofit2/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitNullable", "", "awaitUnit", "awaitResponse", "Lretrofit2/Response;", "suspendAndThrow", "", "", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KotlinExtensions {
    public static final /* synthetic */ <T> T create(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) retrofit.create(Object.class);
        Intrinsics.checkNotNullExpressionValue(t, "create(...)");
        return t;
    }

    public static final Object awaitUnit(Call<Unit> call, Continuation<? super Unit> continuation) {
        Intrinsics.checkNotNull(call, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
        return awaitNullable(call, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object suspendAndThrow(final Throwable th, Continuation<?> continuation) {
        KotlinExtensions$suspendAndThrow$1 kotlinExtensions$suspendAndThrow$1;
        int i;
        if (continuation instanceof KotlinExtensions$suspendAndThrow$1) {
            kotlinExtensions$suspendAndThrow$1 = (KotlinExtensions$suspendAndThrow$1) continuation;
            if ((kotlinExtensions$suspendAndThrow$1.label & Integer.MIN_VALUE) != 0) {
                kotlinExtensions$suspendAndThrow$1.label -= Integer.MIN_VALUE;
                Object obj = kotlinExtensions$suspendAndThrow$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kotlinExtensions$suspendAndThrow$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    kotlinExtensions$suspendAndThrow$1.L$0 = th;
                    kotlinExtensions$suspendAndThrow$1.label = 1;
                    final KotlinExtensions$suspendAndThrow$1 kotlinExtensions$suspendAndThrow$12 = kotlinExtensions$suspendAndThrow$1;
                    Dispatchers.getDefault().mo10050dispatch(kotlinExtensions$suspendAndThrow$12.getContext(), new Runnable() { // from class: retrofit2.KotlinExtensions$suspendAndThrow$2$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Continuation intercepted = IntrinsicsKt.intercepted(kotlinExtensions$suspendAndThrow$12);
                            Result.Companion companion = Result.Companion;
                            intercepted.resumeWith(Result.m8471constructorimpl(ResultKt.createFailure(th)));
                        }
                    });
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (coroutine_suspended2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(kotlinExtensions$suspendAndThrow$12);
                    }
                    if (coroutine_suspended2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Throwable th2 = (Throwable) kotlinExtensions$suspendAndThrow$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        kotlinExtensions$suspendAndThrow$1 = new KotlinExtensions$suspendAndThrow$1(continuation);
        Object obj2 = kotlinExtensions$suspendAndThrow$1.result;
        Object coroutine_suspended3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kotlinExtensions$suspendAndThrow$1.label;
        if (i != 0) {
        }
        throw new KotlinNothingValueException();
    }

    public static final <T> Object await(final Call<T> call, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                call.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    T body = response.body();
                    if (body == null) {
                        Object tag = call2.request().tag(Invocation.class);
                        Intrinsics.checkNotNull(tag);
                        Invocation invocation = (Invocation) tag;
                        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response from " + invocation.service().getName() + '.' + invocation.method().getName() + " was null but response body type was declared as non-null");
                        Result.Companion companion = Result.Companion;
                        cancellableContinuationImpl2.resumeWith(Result.m8471constructorimpl(ResultKt.createFailure(kotlinNullPointerException)));
                        return;
                    }
                    Result.Companion companion2 = Result.Companion;
                    cancellableContinuationImpl2.resumeWith(Result.m8471constructorimpl(body));
                    return;
                }
                Result.Companion companion3 = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8471constructorimpl(ResultKt.createFailure(new HttpException(response))));
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8471constructorimpl(ResultKt.createFailure(t)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object awaitNullable(final Call<T> call, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$4$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                call.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl2.resumeWith(Result.m8471constructorimpl(response.body()));
                    return;
                }
                Result.Companion companion2 = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8471constructorimpl(ResultKt.createFailure(new HttpException(response))));
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8471constructorimpl(ResultKt.createFailure(t)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object awaitResponse(final Call<T> call, Continuation<? super Response<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                call.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8471constructorimpl(response));
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8471constructorimpl(ResultKt.createFailure(t)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
