package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import java.util.LinkedHashSet;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.rustore.sdk.activitylauncher.ContextExtensionKt;
import ru.rustore.sdk.appupdate.listener.InstallStateUpdateListener;
import ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.appupdate.model.AppUpdateOptions;
import ru.rustore.sdk.appupdate.model.InstallState;
import ru.rustore.sdk.core.exception.RuStoreException;
import ru.rustore.sdk.core.tasks.Task;
import ru.rustore.sdk.core.tasks.TaskHelper;
import ru.rustore.sdk.core.util.CancellableContinuationExtKt;
import ru.rustore.sdk.core.util.WithTimeoutOrThrowKt;
/* loaded from: classes5.dex */
public final class b0 implements RuStoreAppUpdateManager {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f1330a;
    public final LinkedHashSet b;
    public final CoroutineScope c;
    public final z d;

    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function0<j> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f1331a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.f1331a = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public final j invoke() {
            f0 f0Var = new f0();
            return new j(this.f1331a, new ru.rustore.sdk.appupdate.a(new AppUpdateInfo.Factory(f0Var), f0Var));
        }
    }

    @DebugMetadata(c = "ru.rustore.sdk.appupdate.impl.manager.RuStoreAppUpdateManagerImpl$completeUpdate$1", f = "RuStoreAppUpdateManagerImpl.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: classes5.dex */
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f1332a;

        public b(Continuation<? super b> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((b) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f1332a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.f1332a = 1;
                if (((j) b0.this.f1330a.getValue()).a(this) == coroutine_suspended) {
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

    @DebugMetadata(c = "ru.rustore.sdk.appupdate.impl.manager.RuStoreAppUpdateManagerImpl$getAppUpdateInfo$1", f = "RuStoreAppUpdateManagerImpl.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: classes5.dex */
    public static final class c extends SuspendLambda implements Function1<Continuation<? super AppUpdateInfo>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f1333a;

        public c(Continuation<? super c> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super AppUpdateInfo> continuation) {
            return ((c) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f1333a;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            j jVar = (j) b0.this.f1330a.getValue();
            this.f1333a = 1;
            jVar.getClass();
            m mVar = new m(jVar);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Object withTimeoutOrThrow = WithTimeoutOrThrowKt.withTimeoutOrThrow(20000L, new ru.rustore.sdk.appupdate.b(jVar, objectRef), new ru.rustore.sdk.appupdate.c(mVar, objectRef, jVar, null), this);
            return withTimeoutOrThrow == coroutine_suspended ? coroutine_suspended : withTimeoutOrThrow;
        }
    }

    @DebugMetadata(c = "ru.rustore.sdk.appupdate.impl.manager.RuStoreAppUpdateManagerImpl$observeInstallState$1", f = "RuStoreAppUpdateManagerImpl.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: classes5.dex */
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f1334a;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b0 f1335a;

            public a(b0 b0Var) {
                this.f1335a = b0Var;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                InstallState installState = (InstallState) obj;
                for (InstallStateUpdateListener installStateUpdateListener : this.f1335a.b) {
                    installStateUpdateListener.onStateUpdated(installState);
                }
                return Unit.INSTANCE;
            }
        }

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f1334a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b0 b0Var = b0.this;
                MutableStateFlow mutableStateFlow = b0Var.d.b;
                a aVar = new a(b0Var);
                this.f1334a = 1;
                if (mutableStateFlow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @DebugMetadata(c = "ru.rustore.sdk.appupdate.impl.manager.RuStoreAppUpdateManagerImpl$startUpdateFlow$1", f = "RuStoreAppUpdateManagerImpl.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: classes5.dex */
    public static final class e extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f1336a;
        public final /* synthetic */ AppUpdateInfo c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AppUpdateInfo appUpdateInfo, Continuation<? super e> continuation) {
            super(1, continuation);
            this.c = appUpdateInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new e(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Integer> continuation) {
            return ((e) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object m8471constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f1336a;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            j jVar = (j) b0.this.f1330a.getValue();
            AppUpdateInfo appUpdateInfo = this.c;
            this.f1336a = 1;
            jVar.getClass();
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            try {
                Result.Companion companion = Result.Companion;
                ContextExtensionKt.openActivityForResult(jVar.f1352a, new Intent("ru.vk.store.AnyAppForceUpdateActivity"), new p(cancellableContinuationImpl));
                appUpdateInfo.markIsUsed$sdk_public_appupdate_release();
                m8471constructorimpl = Result.m8471constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m8471constructorimpl = Result.m8471constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m8474exceptionOrNullimpl = Result.m8474exceptionOrNullimpl(m8471constructorimpl);
            if (m8474exceptionOrNullimpl != null) {
                CancellableContinuationExtKt.resumeWithExceptionIfActive(cancellableContinuationImpl, m8474exceptionOrNullimpl);
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            return result == coroutine_suspended ? coroutine_suspended : result;
        }
    }

    @DebugMetadata(c = "ru.rustore.sdk.appupdate.impl.manager.RuStoreAppUpdateManagerImpl$startUpdateFlow$2", f = "RuStoreAppUpdateManagerImpl.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: classes5.dex */
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f1337a;
        public final /* synthetic */ AppUpdateInfo c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AppUpdateInfo appUpdateInfo, Continuation<? super f> continuation) {
            super(1, continuation);
            this.c = appUpdateInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new f(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Integer> continuation) {
            return ((f) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f1337a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                j jVar = (j) b0.this.f1330a.getValue();
                AppUpdateInfo appUpdateInfo = this.c;
                this.f1337a = 1;
                jVar.getClass();
                t tVar = new t(appUpdateInfo, jVar);
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Object withTimeoutOrThrow = WithTimeoutOrThrowKt.withTimeoutOrThrow(20000L, new ru.rustore.sdk.appupdate.b(jVar, objectRef), new ru.rustore.sdk.appupdate.c(tVar, objectRef, jVar, null), this);
                if (withTimeoutOrThrow != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    withTimeoutOrThrow = Unit.INSTANCE;
                }
                if (withTimeoutOrThrow == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Boxing.boxInt(-1);
        }
    }

    @DebugMetadata(c = "ru.rustore.sdk.appupdate.impl.manager.RuStoreAppUpdateManagerImpl$startUpdateFlow$3", f = "RuStoreAppUpdateManagerImpl.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: classes5.dex */
    public static final class g extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f1338a;
        public final /* synthetic */ AppUpdateInfo c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(AppUpdateInfo appUpdateInfo, Continuation<? super g> continuation) {
            super(1, continuation);
            this.c = appUpdateInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new g(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Integer> continuation) {
            return ((g) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f1338a;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AppUpdateInfo appUpdateInfo = this.c;
            this.f1338a = 1;
            Object a2 = ((j) b0.this.f1330a.getValue()).a(appUpdateInfo, this);
            return a2 == coroutine_suspended ? coroutine_suspended : a2;
        }
    }

    public b0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1330a = LazyKt.lazy(new a(context));
        this.b = new LinkedHashSet();
        this.c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.d = new z();
        a();
        a(context);
    }

    public final void a() {
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new d(null), 3, null);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<Unit> completeUpdate() {
        return TaskHelper.wrap$default(TaskHelper.INSTANCE, null, new b(null), 1, null);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        return TaskHelper.wrap$default(TaskHelper.INSTANCE, null, new c(null), 1, null);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final void registerListener(InstallStateUpdateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b.add(listener);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions) {
        Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
        Intrinsics.checkNotNullParameter(appUpdateOptions, "appUpdateOptions");
        return appUpdateInfo.getUpdateAvailability() != 2 ? TaskHelper.INSTANCE.forException(new RuStoreException("update not available")) : appUpdateInfo.isUsed$sdk_public_appupdate_release() ? TaskHelper.INSTANCE.forException(new IllegalStateException("AppUpdateInfo object is already used. Call the method getAppUpdateInfo() again")) : appUpdateOptions.getAppUpdateType() == 1 ? TaskHelper.wrap$default(TaskHelper.INSTANCE, null, new e(appUpdateInfo, null), 1, null) : appUpdateOptions.getAppUpdateType() == 2 ? TaskHelper.wrap$default(TaskHelper.INSTANCE, null, new f(appUpdateInfo, null), 1, null) : TaskHelper.wrap$default(TaskHelper.INSTANCE, null, new g(appUpdateInfo, null), 1, null);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final void unregisterListener(InstallStateUpdateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b.remove(listener);
    }

    public final void a(Context context) {
        ContextCompat.registerReceiver(context, new a0(this.d), new IntentFilter("rustore_app_downloading_state_" + context.getPackageName()), 2);
    }
}
