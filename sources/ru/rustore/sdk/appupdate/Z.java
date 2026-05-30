package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.appupdate.e0;
import ru.rustore.sdk.appupdate.listener.InstallStateUpdateListener;
import ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.appupdate.model.AppUpdateOptions;
import ru.rustore.sdk.core.tasks.Task;
import ru.rustore.sdk.reactive.core.Dispatchers;
import ru.rustore.sdk.reactive.observable.ObservableObserveOnKt;
import ru.rustore.sdk.reactive.observable.ObservableSubscribeKt;
import ru.rustore.sdk.reactive.single.Single;
import ru.rustore.sdk.reactive.single.SingleFlatMapKt;
import ru.rustore.sdk.reactive.single.SingleMapKt;
import ru.rustore.sdk.reactive.single.SingleOnErrorReturnKt;
import ru.rustore.sdk.reactive.single.SingleSubscribeKt;
import ru.rustore.sdk.reactive.single.SingleSubscribeOnKt;
import ru.rustore.sdk.reactive.subject.Subject;
/* loaded from: classes6.dex */
public final class Z implements RuStoreAppUpdateManager {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f1503a;
    public final LinkedHashSet b;
    public final C0804e c;
    public AppUpdateOptions d;

    public Z(Context applicationContext) {
        e0 e0Var;
        Intrinsics.checkNotNullParameter(applicationContext, "context");
        this.f1503a = LazyKt.lazy(new U(applicationContext));
        this.b = new LinkedHashSet();
        Q q = new Q();
        new e0.a();
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        synchronized (e0.a.class) {
            e0Var = e0.i;
            if (e0Var == null) {
                e0Var = new e0(applicationContext, null);
                e0.i = e0Var;
            }
        }
        C0804e c0804e = (C0804e) e0Var.c.getValue();
        this.c = c0804e;
        c0804e.getClass();
        C0808i event = new C0808i("sdkInfo", (Map) c0804e.f.getValue());
        C0813n c0813n = c0804e.f1510a;
        c0813n.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        Single flatMap = SingleFlatMapKt.flatMap(Single.Companion.from(new C0810k(c0813n, event)), new C0811l(c0813n));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleOnErrorReturnKt.onErrorReturn(SingleSubscribeOnKt.subscribeOn(flatMap, dispatchers.getIo()), C0812m.f1532a), null, C0807h.f1525a, 1, null);
        ObservableSubscribeKt.subscribe$default(ObservableObserveOnKt.observeOn$default(Subject.DefaultImpls.observe$default(q.b, null, 1, null), dispatchers.getMain(), null, 2, null), null, null, new V(this), 3, null);
        ContextCompat.registerReceiver(applicationContext, new S(q), new IntentFilter("rustore_app_downloading_state_" + applicationContext.getPackageName()), 2);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<Unit> completeUpdate(AppUpdateOptions appUpdateOptions) {
        Intrinsics.checkNotNullParameter(appUpdateOptions, "appUpdateOptions");
        int appUpdateType = appUpdateOptions.getAppUpdateType();
        C0804e c0804e = this.c;
        c0804e.getClass();
        Single from = Single.Companion.from(new C0800a(c0804e, new C0808i("updateStart.update", c0804e.a(appUpdateType))));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0801b.f1506a, 1, null);
        C0817r c0817r = (C0817r) this.f1503a.getValue();
        c0817r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0817r.a(new C0820u(c0817r)), new C0824y(c0817r, appUpdateType)), dispatchers.getIo()));
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        C0817r c0817r = (C0817r) this.f1503a.getValue();
        c0817r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(c0817r.a(new B(c0817r)), Dispatchers.INSTANCE.getIo()));
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final void registerListener(InstallStateUpdateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b.add(listener);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions) {
        Single subscribeOn;
        Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
        Intrinsics.checkNotNullParameter(appUpdateOptions, "appUpdateOptions");
        this.d = appUpdateOptions;
        if (appUpdateInfo.getUpdateAvailability() != 2) {
            this.c.a(appUpdateOptions.getAppUpdateType(), "update not available");
            subscribeOn = Single.Companion.create(new W());
        } else {
            boolean isUsed$sdk_public_appupdate_release = appUpdateInfo.isUsed$sdk_public_appupdate_release();
            C0804e c0804e = this.c;
            if (isUsed$sdk_public_appupdate_release) {
                c0804e.a(appUpdateOptions.getAppUpdateType(), "AppUpdateInfo object is already used. Call the method getAppUpdateInfo() again");
                subscribeOn = Single.Companion.create(new X());
            } else {
                int appUpdateType = appUpdateOptions.getAppUpdateType();
                c0804e.getClass();
                C0808i c0808i = new C0808i("updateStart.request", c0804e.a(appUpdateType));
                Single.Companion companion = Single.Companion;
                Single from = companion.from(new C0805f(c0804e, c0808i));
                Dispatchers dispatchers = Dispatchers.INSTANCE;
                SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0806g.f1524a, 1, null);
                int appUpdateType2 = appUpdateOptions.getAppUpdateType();
                if (appUpdateType2 != 1) {
                    Lazy lazy = this.f1503a;
                    if (appUpdateType2 != 2) {
                        C0817r c0817r = (C0817r) lazy.getValue();
                        c0817r.getClass();
                        Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                        subscribeOn = SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0817r.a(new C0823x(c0817r)), new I(c0817r, appUpdateInfo)), dispatchers.getIo());
                    } else {
                        C0817r c0817r2 = (C0817r) lazy.getValue();
                        c0817r2.getClass();
                        Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                        subscribeOn = SingleMapKt.map(SingleSubscribeOnKt.subscribeOn(c0817r2.a(new H(c0817r2, appUpdateInfo)), dispatchers.getIo()), Y.f1502a);
                    }
                } else {
                    C0817r c0817r3 = (C0817r) this.f1503a.getValue();
                    c0817r3.getClass();
                    Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                    subscribeOn = SingleSubscribeOnKt.subscribeOn(companion.create(new E(c0817r3, appUpdateInfo)), dispatchers.getIo());
                }
            }
        }
        return T.a(subscribeOn);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final void unregisterListener(InstallStateUpdateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b.remove(listener);
    }
}
