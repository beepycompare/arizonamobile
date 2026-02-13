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
    public final /* synthetic */ Z f1523a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(Z z) {
        super(1);
        this.f1523a = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(InstallState installState) {
        InstallState installState2 = installState;
        Intrinsics.checkNotNullParameter(installState2, "installState");
        Z z = this.f1523a;
        AppUpdateOptions appUpdateOptions = z.d;
        if (appUpdateOptions != null) {
            int appUpdateType = appUpdateOptions.getAppUpdateType();
            int installStatus = installState2.getInstallStatus();
            if (installStatus == 1) {
                C0792e c0792e = z.c;
                c0792e.getClass();
                SingleSubscribeKt.subscribe$default(SingleSubscribeOnKt.subscribeOn(Single.Companion.from(new C0790c(c0792e, new C0796i("updateStart.downloaded", c0792e.a(appUpdateType)))), Dispatchers.INSTANCE.getIo()), null, C0791d.f1531a, 1, null);
            } else if (installStatus == 3) {
                z.c.a(appUpdateType, String.valueOf(installState2.getInstallErrorCode()));
            }
        }
        if (installState2.getInstallStatus() == 3) {
            this.f1523a.d = null;
        }
        for (InstallStateUpdateListener installStateUpdateListener : this.f1523a.b) {
            installStateUpdateListener.onStateUpdated(installState2);
        }
        return Unit.INSTANCE;
    }
}
