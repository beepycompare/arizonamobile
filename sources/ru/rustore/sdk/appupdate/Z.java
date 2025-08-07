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
/* loaded from: classes5.dex */
public final class Z implements RuStoreAppUpdateManager {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f1354a;
    public final LinkedHashSet b;
    public final C0799e c;
    public AppUpdateOptions d;

    public Z(Context applicationContext) {
        e0 e0Var;
        Intrinsics.checkNotNullParameter(applicationContext, "context");
        this.f1354a = LazyKt.lazy(new U(applicationContext));
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
        C0799e c0799e = (C0799e) e0Var.c.getValue();
        this.c = c0799e;
        c0799e.getClass();
        C0803i event = new C0803i("sdkInfo", (Map) c0799e.f.getValue());
        C0808n c0808n = c0799e.f1361a;
        c0808n.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        Single flatMap = SingleFlatMapKt.flatMap(Single.Companion.from(new C0805k(c0808n, event)), new C0806l(c0808n));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleOnErrorReturnKt.onErrorReturn(SingleSubscribeOnKt.subscribeOn(flatMap, dispatchers.getIo()), C0807m.f1383a), null, C0802h.f1376a, 1, null);
        ObservableSubscribeKt.subscribe$default(ObservableObserveOnKt.observeOn$default(Subject.DefaultImpls.observe$default(q.b, null, 1, null), dispatchers.getMain(), null, 2, null), null, null, new V(this), 3, null);
        ContextCompat.registerReceiver(applicationContext, new S(q), new IntentFilter("rustore_app_downloading_state_" + applicationContext.getPackageName()), 2);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<Unit> completeUpdate(AppUpdateOptions appUpdateOptions) {
        Intrinsics.checkNotNullParameter(appUpdateOptions, "appUpdateOptions");
        int appUpdateType = appUpdateOptions.getAppUpdateType();
        C0799e c0799e = this.c;
        c0799e.getClass();
        Single from = Single.Companion.from(new C0795a(c0799e, new C0803i("updateStart.update", c0799e.a(appUpdateType))));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0796b.f1357a, 1, null);
        C0812r c0812r = (C0812r) this.f1354a.getValue();
        c0812r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0812r.a(new C0815u(c0812r)), new C0819y(c0812r, appUpdateType)), dispatchers.getIo()));
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        C0812r c0812r = (C0812r) this.f1354a.getValue();
        c0812r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(c0812r.a(new B(c0812r)), Dispatchers.INSTANCE.getIo()));
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
            C0799e c0799e = this.c;
            int appUpdateType = appUpdateOptions.getAppUpdateType();
            c0799e.getClass();
            C0803i c0803i = new C0803i("updateStart.request", c0799e.a(appUpdateType));
            Single.Companion companion = Single.Companion;
            Single from = companion.from(new C0800f(c0799e, c0803i));
            Dispatchers dispatchers = Dispatchers.INSTANCE;
            SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0801g.f1375a, 1, null);
            int appUpdateType2 = appUpdateOptions.getAppUpdateType();
            if (appUpdateType2 == 1) {
                C0812r c0812r = (C0812r) this.f1354a.getValue();
                c0812r.getClass();
                Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                subscribeOn = SingleSubscribeOnKt.subscribeOn(companion.create(new E(c0812r, appUpdateInfo)), dispatchers.getIo());
            } else if (appUpdateType2 != 2) {
                C0812r c0812r2 = (C0812r) this.f1354a.getValue();
                c0812r2.getClass();
                Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                subscribeOn = SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0812r2.a(new C0818x(c0812r2)), new I(c0812r2, appUpdateInfo)), dispatchers.getIo());
            } else {
                C0812r c0812r3 = (C0812r) this.f1354a.getValue();
                c0812r3.getClass();
                Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                subscribeOn = SingleMapKt.map(SingleSubscribeOnKt.subscribeOn(c0812r3.a(new H(c0812r3, appUpdateInfo)), dispatchers.getIo()), Y.f1353a);
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
