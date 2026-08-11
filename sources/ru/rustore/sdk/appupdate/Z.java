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
    public final Lazy f1460a;
    public final LinkedHashSet b;
    public final C0784e c;
    public AppUpdateOptions d;

    public Z(Context applicationContext) {
        e0 e0Var;
        Intrinsics.checkNotNullParameter(applicationContext, "context");
        this.f1460a = LazyKt.lazy(new U(applicationContext));
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
        C0784e c0784e = (C0784e) e0Var.c.getValue();
        this.c = c0784e;
        c0784e.getClass();
        C0788i event = new C0788i("sdkInfo", (Map) c0784e.f.getValue());
        C0793n c0793n = c0784e.f1467a;
        c0793n.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        Single flatMap = SingleFlatMapKt.flatMap(Single.Companion.from(new C0790k(c0793n, event)), new C0791l(c0793n));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleOnErrorReturnKt.onErrorReturn(SingleSubscribeOnKt.subscribeOn(flatMap, dispatchers.getIo()), C0792m.f1489a), null, C0787h.f1482a, 1, null);
        ObservableSubscribeKt.subscribe$default(ObservableObserveOnKt.observeOn$default(Subject.DefaultImpls.observe$default(q.b, null, 1, null), dispatchers.getMain(), null, 2, null), null, null, new V(this), 3, null);
        ContextCompat.registerReceiver(applicationContext, new S(q), new IntentFilter("rustore_app_downloading_state_" + applicationContext.getPackageName()), 2);
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<Unit> completeUpdate(AppUpdateOptions appUpdateOptions) {
        Intrinsics.checkNotNullParameter(appUpdateOptions, "appUpdateOptions");
        int appUpdateType = appUpdateOptions.getAppUpdateType();
        C0784e c0784e = this.c;
        c0784e.getClass();
        Single from = Single.Companion.from(new C0780a(c0784e, new C0788i("updateStart.update", c0784e.a(appUpdateType))));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0781b.f1463a, 1, null);
        C0797r c0797r = (C0797r) this.f1460a.getValue();
        c0797r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0797r.a(new C0800u(c0797r)), new C0804y(c0797r, appUpdateType)), dispatchers.getIo()));
    }

    @Override // ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        C0797r c0797r = (C0797r) this.f1460a.getValue();
        c0797r.getClass();
        return T.a(SingleSubscribeOnKt.subscribeOn(c0797r.a(new B(c0797r)), Dispatchers.INSTANCE.getIo()));
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
            C0784e c0784e = this.c;
            if (isUsed$sdk_public_appupdate_release) {
                c0784e.a(appUpdateOptions.getAppUpdateType(), "AppUpdateInfo object is already used. Call the method getAppUpdateInfo() again");
                subscribeOn = Single.Companion.create(new X());
            } else {
                int appUpdateType = appUpdateOptions.getAppUpdateType();
                c0784e.getClass();
                C0788i c0788i = new C0788i("updateStart.request", c0784e.a(appUpdateType));
                Single.Companion companion = Single.Companion;
                Single from = companion.from(new C0785f(c0784e, c0788i));
                Dispatchers dispatchers = Dispatchers.INSTANCE;
                SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(from, dispatchers.getIo()), null, C0786g.f1481a, 1, null);
                int appUpdateType2 = appUpdateOptions.getAppUpdateType();
                if (appUpdateType2 != 1) {
                    Lazy lazy = this.f1460a;
                    if (appUpdateType2 != 2) {
                        C0797r c0797r = (C0797r) lazy.getValue();
                        c0797r.getClass();
                        Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                        subscribeOn = SingleSubscribeOnKt.subscribeOn(SingleFlatMapKt.flatMap(c0797r.a(new C0803x(c0797r)), new I(c0797r, appUpdateInfo)), dispatchers.getIo());
                    } else {
                        C0797r c0797r2 = (C0797r) lazy.getValue();
                        c0797r2.getClass();
                        Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                        subscribeOn = SingleMapKt.map(SingleSubscribeOnKt.subscribeOn(c0797r2.a(new H(c0797r2, appUpdateInfo)), dispatchers.getIo()), Y.f1459a);
                    }
                } else {
                    C0797r c0797r3 = (C0797r) this.f1460a.getValue();
                    c0797r3.getClass();
                    Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
                    subscribeOn = SingleSubscribeOnKt.subscribeOn(companion.create(new E(c0797r3, appUpdateInfo)), dispatchers.getIo());
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
