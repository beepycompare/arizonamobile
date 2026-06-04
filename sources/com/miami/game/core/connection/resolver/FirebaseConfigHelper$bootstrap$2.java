package com.miami.game.core.connection.resolver;

import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FirebaseServerHandler.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/miami/game/core/connection/resolver/FirebaseConfigLinks;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.connection.resolver.FirebaseConfigHelper$bootstrap$2", f = "FirebaseServerHandler.kt", i = {0}, l = {156}, m = "invokeSuspend", n = {"$this$withContext"}, nl = {-1}, s = {"L$0"}, v = 2)
/* loaded from: classes5.dex */
public final class FirebaseConfigHelper$bootstrap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<FirebaseConfigLinks, ? extends String>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseConfigHelper$bootstrap$2(Continuation<? super FirebaseConfigHelper$bootstrap$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FirebaseConfigHelper$bootstrap$2 firebaseConfigHelper$bootstrap$2 = new FirebaseConfigHelper$bootstrap$2(continuation);
        firebaseConfigHelper$bootstrap$2.L$0 = obj;
        return firebaseConfigHelper$bootstrap$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<FirebaseConfigLinks, ? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Map<FirebaseConfigLinks, String>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Map<FirebaseConfigLinks, String>> continuation) {
        return ((FirebaseConfigHelper$bootstrap$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9896constructorimpl;
        Object m9896constructorimpl2;
        FirebaseRemoteConfig remoteConfig;
        FirebaseRemoteConfig remoteConfig2;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            Result.Companion companion = Result.Companion;
            remoteConfig2 = FirebaseConfigHelper.INSTANCE.getRemoteConfig();
            m9896constructorimpl = Result.m9896constructorimpl((Void) Tasks.await(remoteConfig2.setDefaultsAsync(R.xml.remote_config_defaults), 5L, TimeUnit.SECONDS));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9896constructorimpl = Result.m9896constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9899exceptionOrNullimpl = Result.m9899exceptionOrNullimpl(m9896constructorimpl);
        if (m9899exceptionOrNullimpl != null) {
            Log.w("FirebaseSrvHandler", "bootstrap: setDefaults failed: " + m9899exceptionOrNullimpl.getMessage());
        }
        try {
            Result.Companion companion3 = Result.Companion;
            remoteConfig = FirebaseConfigHelper.INSTANCE.getRemoteConfig();
            m9896constructorimpl2 = Result.m9896constructorimpl((Boolean) Tasks.await(remoteConfig.fetchAndActivate(), 10L, TimeUnit.SECONDS));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            m9896constructorimpl2 = Result.m9896constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable m9899exceptionOrNullimpl2 = Result.m9899exceptionOrNullimpl(m9896constructorimpl2);
        if (m9899exceptionOrNullimpl2 != null) {
            Log.w("FirebaseSrvHandler", "bootstrap: fetchAndActivate failed: " + m9899exceptionOrNullimpl2.getMessage());
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.label = 1;
        Object fetchAll = FirebaseConfigHelper.INSTANCE.fetchAll(this);
        return fetchAll == coroutine_suspended ? coroutine_suspended : fetchAll;
    }
}
