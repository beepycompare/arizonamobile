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
    public final Lazy f1516a;
    public final LinkedHashSet b;
    public final C0788e c;
    public AppUpdateOptions d;

    public Z(Context applicationContext) {
        e0 e0Var;
        Intrinsics.checkNotNullParameter(applicationContext, "context");
        this.f1516a = LazyKt.lazy(new U(applicationContext));
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
        C0788e c0788e = (C0788e) e0Var.c.getValue();
        this.c = c0788e;
        c0788e.getClass();
        C0792i event = new C0792i("sdkInfo", (Map) c0788e.f.getValue());
        C0797n c0797n = c0788e.f1523a;
        c0797n.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        Single flatMap = SingleFlatMapKt.flatMap(Single.Companion.from(new C0794k(c0797n, event)), new C0795l(c0797n));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleOnErrorReturnKt.onErrorReturn(SingleSubscribeOnKt.subscribeOn(flatMap, dispatchers.getIo()), C0796m.f1545a), null, C0791h.f1538a, 1, null);
        ObservableSubscribeKt.subscribe$default(ObservableObserveOnKt.observeOn$default(Subject.DefaultImpls.observe$default(q.b, null, 1, null), dispatchers.getMain(), null, 2, null), null, null, new V(this), 3, null);
        ContextCompat.registerReceiver(applicationContext, new S(q), new IntentFilter("rustore_app_downloading_state_" + applicationContext.getPackageName()), 2);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<Unit> completeUpdate(AppUpdateOptions appUpdateOptions) {
        Intrinsics.checkNotNullParameter(appUpdateOptions, "appUpdateOptions");
        int appUpdateType = appUpdateOptions.getAppUpdateType();
        C0788e c0788e = this.c;
        c0788e.getClass();
        Single from = Single.Companion.from(new C0784a(c0788e, new C0792i("updateStart.update", c0788e.a(appUpdateType))));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0785b.f1519a, 1, null);
        C0801r c0801r = (C0801r) this.f1516a.getValue();
        c0801r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0801r.a(new C0804u(c0801r)), new C0808y(c0801r, appUpdateType)), dispatchers.getIo()));
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        C0801r c0801r = (C0801r) this.f1516a.getValue();
        c0801r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(c0801r.a(new B(c0801r)), Dispatchers.INSTANCE.getIo()));
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
            C0788e c0788e = this.c;
            int appUpdateType = appUpdateOptions.getAppUpdateType();
            c0788e.getClass();
            C0792i c0792i = new C0792i("updateStart.request", c0788e.a(appUpdateType));
            Single.Companion companion = Single.Companion;
            Single from = companion.from(new C0789f(c0788e, c0792i));
            Dispatchers dispatchers = Dispatchers.INSTANCE;
            SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0790g.f1537a, 1, null);
            int appUpdateType2 = appUpdateOptions.getAppUpdateType();
            if (appUpdateType2 == 1) {
                C0801r c0801r = (C0801r) this.f1516a.getValue();
                c0801r.getClass();
                Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                subscribeOn = SingleSubscribeOnKt.subscribeOn(companion.create(new E(c0801r, appUpdateInfo)), dispatchers.getIo());
            } else if (appUpdateType2 != 2) {
                C0801r c0801r2 = (C0801r) this.f1516a.getValue();
                c0801r2.getClass();
                Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                subscribeOn = SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0801r2.a(new C0807x(c0801r2)), new I(c0801r2, appUpdateInfo)), dispatchers.getIo());
            } else {
                C0801r c0801r3 = (C0801r) this.f1516a.getValue();
                c0801r3.getClass();
                Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                subscribeOn = SingleMapKt.map(SingleSubscribeOnKt.subscribeOn(c0801r3.a(new H(c0801r3, appUpdateInfo)), dispatchers.getIo()), Y.f1515a);
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
