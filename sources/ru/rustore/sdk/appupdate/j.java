package ru.rustore.sdk.appupdate;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuationImpl;
import ru.rustore.sdk.activitylauncher.ContextExtensionKt;
import ru.rustore.sdk.appupdate.c;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.appupdate.model.AppUpdateParams;
import ru.rustore.sdk.core.exception.RuStoreNotInstalledException;
import ru.rustore.sdk.core.exception.RuStoreOutdatedException;
import ru.rustore.sdk.core.util.CancellableContinuationExtKt;
import ru.rustore.sdk.core.util.CollectionExtKt;
import ru.rustore.sdk.core.util.RuStoreUtils;
import ru.rustore.sdk.core.util.WithTimeoutOrThrowKt;
/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1352a;
    public final ru.rustore.sdk.appupdate.a b;

    @DebugMetadata(c = "ru.rustore.sdk.appupdate.impl.data.AppUpdateProvider", f = "AppUpdateProvider.kt", i = {0}, l = {80, 81}, m = "completeUpdateFlow", n = {"this"}, s = {"L$0"})
    /* loaded from: classes5.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public j f1353a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return j.this.a(this);
        }
    }

    @DebugMetadata(c = "ru.rustore.sdk.appupdate.impl.data.AppUpdateProvider", f = "AppUpdateProvider.kt", i = {0, 0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF, ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE}, m = "startUpdateFlow", n = {"this", "appUpdateInfo"}, s = {"L$0", "L$1"})
    /* loaded from: classes5.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public j f1354a;
        public AppUpdateInfo b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return j.this.a((AppUpdateInfo) null, this);
        }
    }

    public j(Context context, ru.rustore.sdk.appupdate.a appUpdateInfoMapper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appUpdateInfoMapper, "appUpdateInfoMapper");
        this.f1352a = context;
        this.b = appUpdateInfoMapper;
    }

    public static final void a(j jVar, Context context, c.a aVar, ServiceConnection serviceConnection) {
        List<ResolveInfo> queryIntentServices;
        String str;
        if (!RuStoreUtils.INSTANCE.isRuStoreInstalled(context)) {
            aVar.invoke(new RuStoreNotInstalledException());
            return;
        }
        Intent intent = new Intent("ru.vk.store.provider.appupdate.RemoteAppUpdateFlowProvider");
        if (Build.VERSION.SDK_INT >= 33) {
            queryIntentServices = context.getPackageManager().queryIntentServices(intent, PackageManager.ResolveInfoFlags.of(0L));
            str = "packageManager\n         ….ResolveInfoFlags.of(0L))";
        } else {
            queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            str = "packageManager\n         …IntentServices(intent, 0)";
        }
        Intrinsics.checkNotNullExpressionValue(queryIntentServices, str);
        ComponentName findRuStoreServiceComponentName = CollectionExtKt.findRuStoreServiceComponentName(queryIntentServices);
        if (findRuStoreServiceComponentName == null) {
            aVar.invoke(new RuStoreOutdatedException());
            return;
        }
        intent.setComponent(findRuStoreServiceComponentName);
        context.bindService(intent, serviceConnection, 1);
    }

    public static final AppUpdateParams a(j jVar, Context context) {
        jVar.getClass();
        int i = Build.VERSION.SDK_INT;
        PackageInfo packageInfo = i >= 33 ? context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(1L)) : context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
        return new AppUpdateParams(i >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(2:3|(14:5|6|(1:(1:(3:10|11|12)(2:14|15))(1:16))(4:37|(1:39)|(1:41)|33)|17|18|19|(1:21)|22|23|(1:25)|26|(1:28)|29|(1:31)))|42|6|(0)(0)|17|18|19|(0)|22|23|(0)|26|(0)|29|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ba, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bb, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.m8471constructorimpl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e4, code lost:
        if (r11 != r1) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a A[Catch: all -> 0x00ba, TryCatch #0 {all -> 0x00ba, blocks: (B:24:0x007e, B:26:0x008a, B:27:0x0092), top: B:45:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Continuation<? super Unit> continuation) {
        a aVar;
        int i;
        j jVar;
        Throwable m8474exceptionOrNullimpl;
        Object result;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.d = i2 - Integer.MIN_VALUE;
                Object obj = aVar.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = aVar.d;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    aVar.f1353a = this;
                    aVar.d = 1;
                    f fVar = new f(this);
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    Object withTimeoutOrThrow = WithTimeoutOrThrowKt.withTimeoutOrThrow(20000L, new ru.rustore.sdk.appupdate.b(this, objectRef), new c(fVar, objectRef, this, null), aVar);
                    if (withTimeoutOrThrow != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        withTimeoutOrThrow = Unit.INSTANCE;
                    }
                    if (withTimeoutOrThrow != coroutine_suspended) {
                        jVar = this;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    jVar = aVar.f1353a;
                    ResultKt.throwOnFailure(obj);
                }
                aVar.f1353a = null;
                aVar.d = 2;
                jVar.getClass();
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(aVar), 1);
                cancellableContinuationImpl.initCancellability();
                Result.Companion companion = Result.Companion;
                if (!RuStoreUtils.INSTANCE.isRuStoreInstalled(jVar.f1352a)) {
                    CancellableContinuationExtKt.resumeWithExceptionIfActive(cancellableContinuationImpl, new RuStoreNotInstalledException());
                }
                Context context = jVar.f1352a;
                Intent intent = new Intent("ru.vk.store.FlexibleAppUpdate");
                intent.putExtra("RUN_INSTALL", true);
                intent.putExtra("PACKAGE_NAME", jVar.f1352a.getPackageName());
                ContextExtensionKt.openActivityForResult(context, intent, new o(cancellableContinuationImpl));
                Object m8471constructorimpl = Result.m8471constructorimpl(Unit.INSTANCE);
                m8474exceptionOrNullimpl = Result.m8474exceptionOrNullimpl(m8471constructorimpl);
                if (m8474exceptionOrNullimpl != null) {
                    CancellableContinuationExtKt.resumeWithExceptionIfActive(cancellableContinuationImpl, m8474exceptionOrNullimpl);
                }
                result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(aVar);
                }
                if (result != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    result = Unit.INSTANCE;
                }
            }
        }
        aVar = new a(continuation);
        Object obj2 = aVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar.d;
        if (i != 0) {
        }
        aVar.f1353a = null;
        aVar.d = 2;
        jVar.getClass();
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(aVar), 1);
        cancellableContinuationImpl2.initCancellability();
        Result.Companion companion2 = Result.Companion;
        if (!RuStoreUtils.INSTANCE.isRuStoreInstalled(jVar.f1352a)) {
        }
        Context context2 = jVar.f1352a;
        Intent intent2 = new Intent("ru.vk.store.FlexibleAppUpdate");
        intent2.putExtra("RUN_INSTALL", true);
        intent2.putExtra("PACKAGE_NAME", jVar.f1352a.getPackageName());
        ContextExtensionKt.openActivityForResult(context2, intent2, new o(cancellableContinuationImpl2));
        Object m8471constructorimpl2 = Result.m8471constructorimpl(Unit.INSTANCE);
        m8474exceptionOrNullimpl = Result.m8474exceptionOrNullimpl(m8471constructorimpl2);
        if (m8474exceptionOrNullimpl != null) {
        }
        result = cancellableContinuationImpl2.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        }
        if (result != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|(1:(1:(2:10|11)(2:13|14))(1:15))(4:31|(1:33)|(1:35)|26)|16|17|18|19|(1:21)|22|(1:24)|(1:26)(1:27)))|36|6|(0)(0)|16|17|18|19|(0)|22|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ab, code lost:
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ac, code lost:
        r2 = kotlin.Result.Companion;
        r11 = kotlin.Result.m8471constructorimpl(kotlin.ResultKt.createFailure(r11));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(AppUpdateInfo appUpdateInfo, Continuation<? super Integer> continuation) {
        b bVar;
        int i;
        j jVar;
        Throwable m8474exceptionOrNullimpl;
        Object result;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i2 = bVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.e = i2 - Integer.MIN_VALUE;
                Object obj = bVar.c;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bVar.e;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    bVar.f1354a = this;
                    bVar.b = appUpdateInfo;
                    bVar.e = 1;
                    i iVar = new i(this);
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    Object withTimeoutOrThrow = WithTimeoutOrThrowKt.withTimeoutOrThrow(20000L, new ru.rustore.sdk.appupdate.b(this, objectRef), new c(iVar, objectRef, this, null), bVar);
                    if (withTimeoutOrThrow != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        withTimeoutOrThrow = Unit.INSTANCE;
                    }
                    if (withTimeoutOrThrow != coroutine_suspended) {
                        jVar = this;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    appUpdateInfo = bVar.b;
                    jVar = bVar.f1354a;
                    ResultKt.throwOnFailure(obj);
                }
                bVar.f1354a = null;
                bVar.b = null;
                bVar.e = 2;
                jVar.getClass();
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(bVar), 1);
                cancellableContinuationImpl.initCancellability();
                Result.Companion companion = Result.Companion;
                Context context = jVar.f1352a;
                Intent intent = new Intent("ru.vk.store.FlexibleAppUpdate");
                jVar.b.getClass();
                intent.putExtras(ru.rustore.sdk.appupdate.a.a(appUpdateInfo));
                ContextExtensionKt.openActivityForResult(context, intent, new n(cancellableContinuationImpl));
                appUpdateInfo.markIsUsed$sdk_public_appupdate_release();
                Object m8471constructorimpl = Result.m8471constructorimpl(Unit.INSTANCE);
                m8474exceptionOrNullimpl = Result.m8474exceptionOrNullimpl(m8471constructorimpl);
                if (m8474exceptionOrNullimpl != null) {
                    CancellableContinuationExtKt.resumeWithExceptionIfActive(cancellableContinuationImpl, m8474exceptionOrNullimpl);
                }
                result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(bVar);
                }
                return result != coroutine_suspended ? coroutine_suspended : result;
            }
        }
        bVar = new b(continuation);
        Object obj2 = bVar.c;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bVar.e;
        if (i != 0) {
        }
        bVar.f1354a = null;
        bVar.b = null;
        bVar.e = 2;
        jVar.getClass();
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(bVar), 1);
        cancellableContinuationImpl2.initCancellability();
        Result.Companion companion2 = Result.Companion;
        Context context2 = jVar.f1352a;
        Intent intent2 = new Intent("ru.vk.store.FlexibleAppUpdate");
        jVar.b.getClass();
        intent2.putExtras(ru.rustore.sdk.appupdate.a.a(appUpdateInfo));
        ContextExtensionKt.openActivityForResult(context2, intent2, new n(cancellableContinuationImpl2));
        appUpdateInfo.markIsUsed$sdk_public_appupdate_release();
        Object m8471constructorimpl2 = Result.m8471constructorimpl(Unit.INSTANCE);
        m8474exceptionOrNullimpl = Result.m8474exceptionOrNullimpl(m8471constructorimpl2);
        if (m8474exceptionOrNullimpl != null) {
        }
        result = cancellableContinuationImpl2.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        }
        if (result != coroutine_suspended2) {
        }
    }
}
