package ru.rustore.sdk.appupdate;

import android.content.ServiceConnection;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import ru.rustore.sdk.core.exception.RuStoreException;
import ru.rustore.sdk.core.util.CancellableContinuationExtKt;
@DebugMetadata(c = "ru.rustore.sdk.appupdate.impl.data.AppUpdateProvider$aidlConnection$3", f = "AppUpdateProvider.kt", i = {0}, l = {276}, m = "invokeSuspend", n = {"$this$withTimeoutOrThrow"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* renamed from: a  reason: collision with root package name */
    public int f1338a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Function1<CancellableContinuation<Object>, ServiceConnection> c;
    public final /* synthetic */ Ref.ObjectRef<ServiceConnection> d;
    public final /* synthetic */ j e;

    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function1<RuStoreException, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation<Object> f1339a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CancellableContinuationImpl cancellableContinuationImpl) {
            super(1);
            this.f1339a = cancellableContinuationImpl;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(RuStoreException ruStoreException) {
            RuStoreException error = ruStoreException;
            Intrinsics.checkNotNullParameter(error, "error");
            CancellableContinuationExtKt.resumeWithExceptionIfActive(this.f1339a, error);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super CancellableContinuation<Object>, ? extends ServiceConnection> function1, Ref.ObjectRef<ServiceConnection> objectRef, j jVar, Continuation<? super c> continuation) {
        super(2, continuation);
        this.c = function1;
        this.d = objectRef;
        this.e = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        c cVar = new c(this.c, this.d, this.e, continuation);
        cVar.b = obj;
        return cVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [T, android.content.ServiceConnection] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m8443constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f1338a;
        if (i != 0) {
            if (i == 1) {
                CoroutineScope coroutineScope = (CoroutineScope) this.b;
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Function1<CancellableContinuation<Object>, ServiceConnection> function1 = this.c;
        Ref.ObjectRef<ServiceConnection> objectRef = this.d;
        j jVar = this.e;
        this.b = (CoroutineScope) this.b;
        this.f1338a = 1;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
        cancellableContinuationImpl.initCancellability();
        try {
            Result.Companion companion = Result.Companion;
            ServiceConnection invoke = function1.invoke(cancellableContinuationImpl);
            objectRef.element = invoke;
            j.a(jVar, jVar.f1351a, new a(cancellableContinuationImpl), invoke);
            m8443constructorimpl = Result.m8443constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m8443constructorimpl = Result.m8443constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m8446exceptionOrNullimpl = Result.m8446exceptionOrNullimpl(m8443constructorimpl);
        if (m8446exceptionOrNullimpl != null) {
            CancellableContinuationExtKt.resumeWithExceptionIfActive(cancellableContinuationImpl, m8446exceptionOrNullimpl);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(this);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}
