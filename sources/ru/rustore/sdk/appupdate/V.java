package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.appupdate.listener.InstallStateUpdateListener;
import ru.rustore.sdk.appupdate.model.AppUpdateOptions;
import ru.rustore.sdk.appupdate.model.InstallState;
import ru.rustore.sdk.reactive.core.Dispatchers;
import ru.rustore.sdk.reactive.single.Single;
import ru.rustore.sdk.reactive.single.SingleSubscribeKt;
import ru.rustore.sdk.reactive.single.SingleSubscribeOnKt;
/* loaded from: classes6.dex */
public final class V extends Lambda implements Function1<InstallState, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Z f1362a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(Z z) {
        super(1);
        this.f1362a = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(InstallState installState) {
        InstallState installState2 = installState;
        Intrinsics.checkNotNullParameter(installState2, "installState");
        Z z = this.f1362a;
        AppUpdateOptions appUpdateOptions = z.d;
        if (appUpdateOptions != null) {
            int appUpdateType = appUpdateOptions.getAppUpdateType();
            int installStatus = installState2.getInstallStatus();
            if (installStatus == 1) {
                C0796e c0796e = z.c;
                c0796e.getClass();
                SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(Single.Companion.from(new C0794c(c0796e, new C0800i("updateStart.downloaded", c0796e.a(appUpdateType)))), Dispatchers.INSTANCE.getIo()), null, C0795d.f1370a, 1, null);
            } else if (installStatus == 3) {
                z.c.a(appUpdateType, String.valueOf(installState2.getInstallErrorCode()));
            }
        }
        if (installState2.getInstallStatus() == 3) {
            this.f1362a.d = null;
        }
        for (InstallStateUpdateListener installStateUpdateListener : this.f1362a.b) {
            installStateUpdateListener.onStateUpdated(installState2);
        }
        return Unit.INSTANCE;
    }
}
