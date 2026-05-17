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
    public final Lazy f1530a;
    public final LinkedHashSet b;
    public final C0791e c;
    public AppUpdateOptions d;

    public Z(Context applicationContext) {
        e0 e0Var;
        Intrinsics.checkNotNullParameter(applicationContext, "context");
        this.f1530a = LazyKt.lazy(new U(applicationContext));
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
        C0791e c0791e = (C0791e) e0Var.c.getValue();
        this.c = c0791e;
        c0791e.getClass();
        C0795i event = new C0795i("sdkInfo", (Map) c0791e.f.getValue());
        C0800n c0800n = c0791e.f1537a;
        c0800n.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        Single flatMap = SingleFlatMapKt.flatMap(Single.Companion.from(new C0797k(c0800n, event)), new C0798l(c0800n));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleOnErrorReturnKt.onErrorReturn(SingleSubscribeOnKt.subscribeOn(flatMap, dispatchers.getIo()), C0799m.f1559a), null, C0794h.f1552a, 1, null);
        ObservableSubscribeKt.subscribe$default(ObservableObserveOnKt.observeOn$default(Subject.DefaultImpls.observe$default(q.b, null, 1, null), dispatchers.getMain(), null, 2, null), null, null, new V(this), 3, null);
        ContextCompat.registerReceiver(applicationContext, new S(q), new IntentFilter("rustore_app_downloading_state_" + applicationContext.getPackageName()), 2);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<Unit> completeUpdate(AppUpdateOptions appUpdateOptions) {
        Intrinsics.checkNotNullParameter(appUpdateOptions, "appUpdateOptions");
        int appUpdateType = appUpdateOptions.getAppUpdateType();
        C0791e c0791e = this.c;
        c0791e.getClass();
        Single from = Single.Companion.from(new C0787a(c0791e, new C0795i("updateStart.update", c0791e.a(appUpdateType))));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0788b.f1533a, 1, null);
        C0804r c0804r = (C0804r) this.f1530a.getValue();
        c0804r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0804r.a(new C0807u(c0804r)), new C0811y(c0804r, appUpdateType)), dispatchers.getIo()));
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        C0804r c0804r = (C0804r) this.f1530a.getValue();
        c0804r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(c0804r.a(new B(c0804r)), Dispatchers.INSTANCE.getIo()));
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
            C0791e c0791e = this.c;
            if (isUsed$sdk_public_appupdate_release) {
                c0791e.a(appUpdateOptions.getAppUpdateType(), "AppUpdateInfo object is already used. Call the method getAppUpdateInfo() again");
                subscribeOn = Single.Companion.create(new X());
            } else {
                int appUpdateType = appUpdateOptions.getAppUpdateType();
                c0791e.getClass();
                C0795i c0795i = new C0795i("updateStart.request", c0791e.a(appUpdateType));
                Single.Companion companion = Single.Companion;
                Single from = companion.from(new C0792f(c0791e, c0795i));
                Dispatchers dispatchers = Dispatchers.INSTANCE;
                SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0793g.f1551a, 1, null);
                int appUpdateType2 = appUpdateOptions.getAppUpdateType();
                if (appUpdateType2 != 1) {
                    Lazy lazy = this.f1530a;
                    if (appUpdateType2 != 2) {
                        C0804r c0804r = (C0804r) lazy.getValue();
                        c0804r.getClass();
                        Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                        subscribeOn = SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0804r.a(new C0810x(c0804r)), new I(c0804r, appUpdateInfo)), dispatchers.getIo());
                    } else {
                        C0804r c0804r2 = (C0804r) lazy.getValue();
                        c0804r2.getClass();
                        Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                        subscribeOn = SingleMapKt.map(SingleSubscribeOnKt.subscribeOn(c0804r2.a(new H(c0804r2, appUpdateInfo)), dispatchers.getIo()), Y.f1529a);
                    }
                } else {
                    C0804r c0804r3 = (C0804r) this.f1530a.getValue();
                    c0804r3.getClass();
                    Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                    subscribeOn = SingleSubscribeOnKt.subscribeOn(companion.create(new E(c0804r3, appUpdateInfo)), dispatchers.getIo());
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
