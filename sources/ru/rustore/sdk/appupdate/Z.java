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
    public final Lazy f1374a;
    public final LinkedHashSet b;
    public final C0801e c;
    public AppUpdateOptions d;

    public Z(Context applicationContext) {
        e0 e0Var;
        Intrinsics.checkNotNullParameter(applicationContext, "context");
        this.f1374a = LazyKt.lazy(new U(applicationContext));
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
        C0801e c0801e = (C0801e) e0Var.c.getValue();
        this.c = c0801e;
        c0801e.getClass();
        C0805i event = new C0805i("sdkInfo", (Map) c0801e.f.getValue());
        C0810n c0810n = c0801e.f1381a;
        c0810n.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        Single flatMap = SingleFlatMapKt.flatMap(Single.Companion.from(new C0807k(c0810n, event)), new C0808l(c0810n));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleOnErrorReturnKt.onErrorReturn(SingleSubscribeOnKt.subscribeOn(flatMap, dispatchers.getIo()), C0809m.f1403a), null, C0804h.f1396a, 1, null);
        ObservableSubscribeKt.subscribe$default(ObservableObserveOnKt.observeOn$default(Subject.DefaultImpls.observe$default(q.b, null, 1, null), dispatchers.getMain(), null, 2, null), null, null, new V(this), 3, null);
        ContextCompat.registerReceiver(applicationContext, new S(q), new IntentFilter("rustore_app_downloading_state_" + applicationContext.getPackageName()), 2);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<Unit> completeUpdate(AppUpdateOptions appUpdateOptions) {
        Intrinsics.checkNotNullParameter(appUpdateOptions, "appUpdateOptions");
        int appUpdateType = appUpdateOptions.getAppUpdateType();
        C0801e c0801e = this.c;
        c0801e.getClass();
        Single from = Single.Companion.from(new C0797a(c0801e, new C0805i("updateStart.update", c0801e.a(appUpdateType))));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0798b.f1377a, 1, null);
        C0814r c0814r = (C0814r) this.f1374a.getValue();
        c0814r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0814r.a(new C0817u(c0814r)), new C0821y(c0814r, appUpdateType)), dispatchers.getIo()));
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        C0814r c0814r = (C0814r) this.f1374a.getValue();
        c0814r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(c0814r.a(new B(c0814r)), Dispatchers.INSTANCE.getIo()));
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
        } else if (appUpdateInfo.isUsed$sdk_public_appupdate_release()) {
            this.c.a(appUpdateOptions.getAppUpdateType(), "AppUpdateInfo object is already used. Call the method getAppUpdateInfo() again");
            subscribeOn = Single.Companion.create(new X());
        } else {
            C0801e c0801e = this.c;
            int appUpdateType = appUpdateOptions.getAppUpdateType();
            c0801e.getClass();
            C0805i c0805i = new C0805i("updateStart.request", c0801e.a(appUpdateType));
            Single.Companion companion = Single.Companion;
            Single from = companion.from(new C0802f(c0801e, c0805i));
            Dispatchers dispatchers = Dispatchers.INSTANCE;
            SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0803g.f1395a, 1, null);
            int appUpdateType2 = appUpdateOptions.getAppUpdateType();
            if (appUpdateType2 == 1) {
                C0814r c0814r = (C0814r) this.f1374a.getValue();
                c0814r.getClass();
                Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                subscribeOn = SingleSubscribeOnKt.subscribeOn(companion.create(new E(c0814r, appUpdateInfo)), dispatchers.getIo());
            } else if (appUpdateType2 != 2) {
                C0814r c0814r2 = (C0814r) this.f1374a.getValue();
                c0814r2.getClass();
                Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                subscribeOn = SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0814r2.a(new C0820x(c0814r2)), new I(c0814r2, appUpdateInfo)), dispatchers.getIo());
            } else {
                C0814r c0814r3 = (C0814r) this.f1374a.getValue();
                c0814r3.getClass();
                Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                subscribeOn = SingleMapKt.map(SingleSubscribeOnKt.subscribeOn(c0814r3.a(new H(c0814r3, appUpdateInfo)), dispatchers.getIo()), Y.f1373a);
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
