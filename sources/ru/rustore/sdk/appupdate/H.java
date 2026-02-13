package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.ServiceConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* loaded from: classes6.dex */
public final class H extends Lambda implements Function1<SingleEmitter<Unit>, ServiceConnection> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppUpdateInfo f1508a;
    public final /* synthetic */ C0805r b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(C0805r c0805r, AppUpdateInfo appUpdateInfo) {
        super(1);
        this.f1508a = appUpdateInfo;
        this.b = c0805r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<Unit> singleEmitter) {
        SingleEmitter<Unit> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        this.f1508a.markIsUsed$sdk_public_appupdate_release();
        Context context = this.b.f1561a;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new f0(context, packageName, new F(emitter), new G(emitter));
    }
}
