package com.google.firebase.sessions.settings;

import android.util.Log;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.datastore.core.DataStore;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.sessions.FirebaseSessions;
import com.google.firebase.sessions.TimeProvider;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
/* compiled from: SettingsCache.kt */
@Singleton
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001eH\u0081@¢\u0006\u0004\b\u001f\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCacheImpl;", "Lcom/google/firebase/sessions/settings/SettingsCache;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "sessionConfigsDataStore", "Landroidx/datastore/core/DataStore;", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/sessions/TimeProvider;Landroidx/datastore/core/DataStore;)V", "sessionConfigsAtomicReference", "Ljava/util/concurrent/atomic/AtomicReference;", "sessionConfigs", "getSessionConfigs", "()Lcom/google/firebase/sessions/settings/SessionConfigs;", "hasCacheExpired", "", "sessionsEnabled", "()Ljava/lang/Boolean;", "sessionSamplingRate", "", "()Ljava/lang/Double;", "sessionRestartTimeout", "", "()Ljava/lang/Integer;", "updateConfigs", "", "(Lcom/google/firebase/sessions/settings/SessionConfigs;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeConfigs", "", "removeConfigs$com_google_firebase_firebase_sessions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingsCacheImpl implements SettingsCache {
    private final CoroutineContext backgroundDispatcher;
    private final AtomicReference<SessionConfigs> sessionConfigsAtomicReference;
    private final DataStore<SessionConfigs> sessionConfigsDataStore;
    private final TimeProvider timeProvider;

    @Inject
    public SettingsCacheImpl(@Background CoroutineContext backgroundDispatcher, TimeProvider timeProvider, DataStore<SessionConfigs> sessionConfigsDataStore) {
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(sessionConfigsDataStore, "sessionConfigsDataStore");
        this.backgroundDispatcher = backgroundDispatcher;
        this.timeProvider = timeProvider;
        this.sessionConfigsDataStore = sessionConfigsDataStore;
        this.sessionConfigsAtomicReference = new AtomicReference<>();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(backgroundDispatcher), null, null, new AnonymousClass1(null), 3, null);
    }

    private final SessionConfigs getSessionConfigs() {
        Object runBlocking$default;
        if (this.sessionConfigsAtomicReference.get() == null) {
            AtomicReference<SessionConfigs> atomicReference = this.sessionConfigsAtomicReference;
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new SettingsCacheImpl$sessionConfigs$1(this, null), 1, null);
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, runBlocking$default);
        }
        SessionConfigs sessionConfigs = this.sessionConfigsAtomicReference.get();
        Intrinsics.checkNotNullExpressionValue(sessionConfigs, "get(...)");
        return sessionConfigs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsCache.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCacheImpl$1", f = "SettingsCache.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.firebase.sessions.settings.SettingsCacheImpl$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SettingsCache.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* renamed from: com.google.firebase.sessions.settings.SettingsCacheImpl$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public /* synthetic */ class C00691 implements FlowCollector, FunctionAdapter {
            final /* synthetic */ AtomicReference<SessionConfigs> $tmp0;

            C00691(AtomicReference<SessionConfigs> atomicReference) {
                this.$tmp0 = atomicReference;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public final Function<?> getFunctionDelegate() {
                return new AdaptedFunctionReference(2, this.$tmp0, AtomicReference.class, "set", "set(Ljava/lang/Object;)V", 4);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            public final Object emit(SessionConfigs sessionConfigs, Continuation<? super Unit> continuation) {
                Object invokeSuspend$set = AnonymousClass1.invokeSuspend$set(this.$tmp0, sessionConfigs, continuation);
                return invokeSuspend$set == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invokeSuspend$set : Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((SessionConfigs) obj, (Continuation<? super Unit>) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SettingsCacheImpl.this.sessionConfigsDataStore.getData().collect(new C00691(SettingsCacheImpl.this.sessionConfigsAtomicReference), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object invokeSuspend$set(AtomicReference atomicReference, SessionConfigs sessionConfigs, Continuation continuation) {
            atomicReference.set(sessionConfigs);
            return Unit.INSTANCE;
        }
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public boolean hasCacheExpired() {
        Long cacheUpdatedTimeSeconds = getSessionConfigs().getCacheUpdatedTimeSeconds();
        Integer cacheDurationSeconds = getSessionConfigs().getCacheDurationSeconds();
        return cacheUpdatedTimeSeconds == null || cacheDurationSeconds == null || this.timeProvider.currentTime().getSeconds() - cacheUpdatedTimeSeconds.longValue() >= ((long) cacheDurationSeconds.intValue());
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Boolean sessionsEnabled() {
        return getSessionConfigs().getSessionsEnabled();
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Double sessionSamplingRate() {
        return getSessionConfigs().getSessionSamplingRate();
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Integer sessionRestartTimeout() {
        return getSessionConfigs().getSessionTimeoutSeconds();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|24|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        android.util.Log.w(com.google.firebase.sessions.FirebaseSessions.TAG, "Failed to update config values: " + r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    @Override // com.google.firebase.sessions.settings.SettingsCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateConfigs(SessionConfigs sessionConfigs, Continuation<? super Unit> continuation) {
        SettingsCacheImpl$updateConfigs$1 settingsCacheImpl$updateConfigs$1;
        int i;
        if (continuation instanceof SettingsCacheImpl$updateConfigs$1) {
            settingsCacheImpl$updateConfigs$1 = (SettingsCacheImpl$updateConfigs$1) continuation;
            if ((settingsCacheImpl$updateConfigs$1.label & Integer.MIN_VALUE) != 0) {
                settingsCacheImpl$updateConfigs$1.label -= Integer.MIN_VALUE;
                Object obj = settingsCacheImpl$updateConfigs$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = settingsCacheImpl$updateConfigs$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    settingsCacheImpl$updateConfigs$1.label = 1;
                    if (this.sessionConfigsDataStore.updateData(new SettingsCacheImpl$updateConfigs$2(sessionConfigs, null), settingsCacheImpl$updateConfigs$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        settingsCacheImpl$updateConfigs$1 = new SettingsCacheImpl$updateConfigs$1(this, continuation);
        Object obj2 = settingsCacheImpl$updateConfigs$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = settingsCacheImpl$updateConfigs$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object removeConfigs$com_google_firebase_firebase_sessions(Continuation<Object> continuation) {
        SettingsCacheImpl$removeConfigs$1 settingsCacheImpl$removeConfigs$1;
        int i;
        try {
            if (continuation instanceof SettingsCacheImpl$removeConfigs$1) {
                settingsCacheImpl$removeConfigs$1 = (SettingsCacheImpl$removeConfigs$1) continuation;
                if ((settingsCacheImpl$removeConfigs$1.label & Integer.MIN_VALUE) != 0) {
                    settingsCacheImpl$removeConfigs$1.label -= Integer.MIN_VALUE;
                    Object obj = settingsCacheImpl$removeConfigs$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = settingsCacheImpl$removeConfigs$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    settingsCacheImpl$removeConfigs$1.label = 1;
                    Object updateData = this.sessionConfigsDataStore.updateData(new SettingsCacheImpl$removeConfigs$2(null), settingsCacheImpl$removeConfigs$1);
                    return updateData == coroutine_suspended ? coroutine_suspended : updateData;
                }
            }
            if (i == 0) {
            }
        } catch (IOException e) {
            return Boxing.boxInt(Log.w(FirebaseSessions.TAG, "Failed to remove config values: " + e));
        }
        settingsCacheImpl$removeConfigs$1 = new SettingsCacheImpl$removeConfigs$1(this, continuation);
        Object obj2 = settingsCacheImpl$removeConfigs$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = settingsCacheImpl$removeConfigs$1.label;
    }
}
