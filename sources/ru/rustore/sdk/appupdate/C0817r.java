package ru.rustore.sdk.appupdate;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.appupdate.model.AppUpdateParams;
import ru.rustore.sdk.core.exception.RuStoreConnectionTimeout;
import ru.rustore.sdk.core.exception.RuStoreNotInstalledException;
import ru.rustore.sdk.core.exception.RuStoreOutdatedException;
import ru.rustore.sdk.core.util.CollectionExtKt;
import ru.rustore.sdk.core.util.RuStoreUtils;
import ru.rustore.sdk.reactive.single.Single;
import ru.rustore.sdk.reactive.single.SingleEmitter;
import ru.rustore.sdk.reactive.single.SingleMapErrorKt;
import ru.rustore.sdk.reactive.single.SingleTimeoutKt;
/* renamed from: ru.rustore.sdk.appupdate.r  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0817r {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1539a;
    public final C0814o b;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: ru.rustore.sdk.appupdate.r$a */
    /* loaded from: classes6.dex */
    public static final class a<T> extends Lambda implements Function1<SingleEmitter<T>, Unit> {
        public final /* synthetic */ Function1<SingleEmitter<T>, ServiceConnection> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super SingleEmitter<T>, ? extends ServiceConnection> function1) {
            super(1);
            this.b = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Object obj) {
            Object m9843constructorimpl;
            SingleEmitter<T> emitter = (SingleEmitter) obj;
            Intrinsics.checkNotNullParameter(emitter, "emitter");
            C0817r c0817r = C0817r.this;
            Function1<SingleEmitter<T>, ServiceConnection> function1 = this.b;
            try {
                Result.Companion companion = Result.Companion;
                ServiceConnection invoke = function1.invoke(emitter);
                emitter.onFinish(new C0815p(c0817r, invoke));
                C0817r.a(c0817r, c0817r.f1539a, new C0816q(emitter), invoke);
                m9843constructorimpl = Result.m9843constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9843constructorimpl = Result.m9843constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m9846exceptionOrNullimpl = Result.m9846exceptionOrNullimpl(m9843constructorimpl);
            if (m9846exceptionOrNullimpl != null) {
                emitter.error(m9846exceptionOrNullimpl);
            }
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.rustore.sdk.appupdate.r$b */
    /* loaded from: classes6.dex */
    public static final class b extends Lambda implements Function1<Throwable, Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f1541a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Throwable invoke(Throwable th) {
            Throwable error = th;
            Intrinsics.checkNotNullParameter(error, "error");
            return error instanceof TimeoutException ? new RuStoreConnectionTimeout() : error;
        }
    }

    public C0817r(Context context, C0814o appUpdateInfoMapper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appUpdateInfoMapper, "appUpdateInfoMapper");
        this.f1539a = context;
        this.b = appUpdateInfoMapper;
    }

    public static final void a(C0817r c0817r, Context context, C0816q c0816q, ServiceConnection serviceConnection) {
        List<ResolveInfo> queryIntentServices;
        String str;
        if (!RuStoreUtils.INSTANCE.isRuStoreInstalled(context)) {
            c0816q.invoke(new RuStoreNotInstalledException());
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
            c0816q.invoke(new RuStoreOutdatedException());
            return;
        }
        intent.setComponent(findRuStoreServiceComponentName);
        context.bindService(intent, serviceConnection, 1);
    }

    public static final AppUpdateParams a(C0817r c0817r, Context context) {
        c0817r.getClass();
        int i = Build.VERSION.SDK_INT;
        PackageInfo packageInfo = i >= 33 ? context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(1L)) : context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
        return new AppUpdateParams(i >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode);
    }

    public final <T> Single<T> a(Function1<? super SingleEmitter<T>, ? extends ServiceConnection> function1) {
        return SingleMapErrorKt.mapError(SingleTimeoutKt.timeout$default(Single.Companion.create(new a(function1)), 20000L, TimeUnit.MILLISECONDS, null, 4, null), b.f1541a);
    }
}
