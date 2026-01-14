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
    public final Lazy f1526a;
    public final LinkedHashSet b;
    public final C0792e c;
    public AppUpdateOptions d;

    public Z(Context applicationContext) {
        e0 e0Var;
        Intrinsics.checkNotNullParameter(applicationContext, "context");
        this.f1526a = LazyKt.lazy(new U(applicationContext));
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
        C0792e c0792e = (C0792e) e0Var.c.getValue();
        this.c = c0792e;
        c0792e.getClass();
        C0796i event = new C0796i("sdkInfo", (Map) c0792e.f.getValue());
        C0801n c0801n = c0792e.f1533a;
        c0801n.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        Single flatMap = SingleFlatMapKt.flatMap(Single.Companion.from(new C0798k(c0801n, event)), new C0799l(c0801n));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleOnErrorReturnKt.onErrorReturn(SingleSubscribeOnKt.subscribeOn(flatMap, dispatchers.getIo()), C0800m.f1555a), null, C0795h.f1548a, 1, null);
        ObservableSubscribeKt.subscribe$default(ObservableObserveOnKt.observeOn$default(Subject.DefaultImpls.observe$default(q.b, null, 1, null), dispatchers.getMain(), null, 2, null), null, null, new V(this), 3, null);
        ContextCompat.registerReceiver(applicationContext, new S(q), new IntentFilter("rustore_app_downloading_state_" + applicationContext.getPackageName()), 2);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<Unit> completeUpdate(AppUpdateOptions appUpdateOptions) {
        Intrinsics.checkNotNullParameter(appUpdateOptions, "appUpdateOptions");
        int appUpdateType = appUpdateOptions.getAppUpdateType();
        C0792e c0792e = this.c;
        c0792e.getClass();
        Single from = Single.Companion.from(new C0788a(c0792e, new C0796i("updateStart.update", c0792e.a(appUpdateType))));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0789b.f1529a, 1, null);
        C0805r c0805r = (C0805r) this.f1526a.getValue();
        c0805r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0805r.a(new C0808u(c0805r)), new C0812y(c0805r, appUpdateType)), dispatchers.getIo()));
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        C0805r c0805r = (C0805r) this.f1526a.getValue();
        c0805r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(c0805r.a(new B(c0805r)), Dispatchers.INSTANCE.getIo()));
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
            C0792e c0792e = this.c;
            int appUpdateType = appUpdateOptions.getAppUpdateType();
            c0792e.getClass();
            C0796i c0796i = new C0796i("updateStart.request", c0792e.a(appUpdateType));
            Single.Companion companion = Single.Companion;
            Single from = companion.from(new C0793f(c0792e, c0796i));
            Dispatchers dispatchers = Dispatchers.INSTANCE;
            SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0794g.f1547a, 1, null);
            int appUpdateType2 = appUpdateOptions.getAppUpdateType();
            if (appUpdateType2 == 1) {
                C0805r c0805r = (C0805r) this.f1526a.getValue();
                c0805r.getClass();
                Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                subscribeOn = SingleSubscribeOnKt.subscribeOn(companion.create(new E(c0805r, appUpdateInfo)), dispatchers.getIo());
            } else if (appUpdateType2 != 2) {
                C0805r c0805r2 = (C0805r) this.f1526a.getValue();
                c0805r2.getClass();
                Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                subscribeOn = SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0805r2.a(new C0811x(c0805r2)), new I(c0805r2, appUpdateInfo)), dispatchers.getIo());
            } else {
                C0805r c0805r3 = (C0805r) this.f1526a.getValue();
                c0805r3.getClass();
                Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                subscribeOn = SingleMapKt.map(SingleSubscribeOnKt.subscribeOn(c0805r3.a(new H(c0805r3, appUpdateInfo)), dispatchers.getIo()), Y.f1525a);
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
