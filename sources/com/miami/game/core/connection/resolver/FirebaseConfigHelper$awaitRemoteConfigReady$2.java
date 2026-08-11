package com.miami.game.core.connection.resolver;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FirebaseServerHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.connection.resolver.FirebaseConfigHelper$awaitRemoteConfigReady$2", f = "FirebaseServerHandler.kt", i = {0, 1, 1}, l = {419, 224}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "settings"}, nl = {TypedValues.CycleType.TYPE_EASING, 225}, s = {"L$0", "L$0", "L$1"}, v = 2)
/* loaded from: classes5.dex */
public final class FirebaseConfigHelper$awaitRemoteConfigReady$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseConfigHelper$awaitRemoteConfigReady$2(Continuation<? super FirebaseConfigHelper$awaitRemoteConfigReady$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FirebaseConfigHelper$awaitRemoteConfigReady$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((FirebaseConfigHelper$awaitRemoteConfigReady$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        if (r14.lock(null, r13) == r3) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ed  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        boolean z;
        FirebaseRemoteConfig remoteConfig;
        FirebaseRemoteConfig remoteConfig2;
        Object fetchAndActivateWithRetry;
        FirebaseRemoteConfig remoteConfig3;
        boolean booleanValue;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z2 = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = FirebaseConfigHelper.remoteConfigReadyMutex;
                this.L$0 = mutex;
                this.label = 1;
            } else if (i != 1) {
                if (i == 2) {
                    FirebaseRemoteConfigSettings firebaseRemoteConfigSettings = (FirebaseRemoteConfigSettings) this.L$1;
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        booleanValue = ((Boolean) obj).booleanValue();
                        FirebaseConfigHelper.INSTANCE.registerRemoteConfigUpdates();
                        FirebaseConfigHelper firebaseConfigHelper = FirebaseConfigHelper.INSTANCE;
                        FirebaseConfigHelper.remoteConfigReady = booleanValue;
                        if (booleanValue) {
                            z2 = false;
                        }
                        Boolean boxBoolean = Boxing.boxBoolean(z2);
                        mutex2.unlock(null);
                        return boxBoolean;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                mutex = (Mutex) this.L$0;
            }
            z = FirebaseConfigHelper.remoteConfigReady;
            if (!z) {
                remoteConfig = FirebaseConfigHelper.INSTANCE.getRemoteConfig();
                FirebaseRemoteConfigSettings build = remoteConfig.getInfo().getConfigSettings().toBuilder().setFetchTimeoutInSeconds(15L).build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                try {
                    remoteConfig3 = FirebaseConfigHelper.INSTANCE.getRemoteConfig();
                    Tasks.await(remoteConfig3.setConfigSettingsAsync(build), 5L, TimeUnit.SECONDS);
                } catch (CancellationException e) {
                    throw e;
                } catch (Throwable th3) {
                    Log.w("FirebaseSrvHandler", "awaitRemoteConfigReady: settings failed: " + th3.getMessage());
                }
                try {
                    remoteConfig2 = FirebaseConfigHelper.INSTANCE.getRemoteConfig();
                    Tasks.await(remoteConfig2.setDefaultsAsync(R.xml.remote_config_defaults), 5L, TimeUnit.SECONDS);
                    FirebaseConfigHelper firebaseConfigHelper2 = FirebaseConfigHelper.INSTANCE;
                    this.L$0 = mutex;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(build);
                    this.label = 2;
                    fetchAndActivateWithRetry = firebaseConfigHelper2.fetchAndActivateWithRetry(this);
                    if (fetchAndActivateWithRetry != coroutine_suspended) {
                        Mutex mutex3 = mutex;
                        obj = fetchAndActivateWithRetry;
                        mutex2 = mutex3;
                        booleanValue = ((Boolean) obj).booleanValue();
                        FirebaseConfigHelper.INSTANCE.registerRemoteConfigUpdates();
                        FirebaseConfigHelper firebaseConfigHelper3 = FirebaseConfigHelper.INSTANCE;
                        FirebaseConfigHelper.remoteConfigReady = booleanValue;
                        if (booleanValue) {
                        }
                        Boolean boxBoolean2 = Boxing.boxBoolean(z2);
                        mutex2.unlock(null);
                        return boxBoolean2;
                    }
                    return coroutine_suspended;
                } catch (CancellationException e2) {
                    throw e2;
                }
            }
            mutex2 = mutex;
            Boolean boxBoolean22 = Boxing.boxBoolean(z2);
            mutex2.unlock(null);
            return boxBoolean22;
        } catch (Throwable th4) {
            Mutex mutex4 = mutex;
            th = th4;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }
}
