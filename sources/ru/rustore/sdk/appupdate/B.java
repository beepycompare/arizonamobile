package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.ServiceConnection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.appupdate.model.AppUpdateParams;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* loaded from: classes6.dex */
public final class B extends Lambda implements Function1<SingleEmitter<AppUpdateInfo>, ServiceConnection> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0809r f1341a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0809r c0809r) {
        super(1);
        this.f1341a = c0809r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<AppUpdateInfo> singleEmitter) {
        SingleEmitter<AppUpdateInfo> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0809r c0809r = this.f1341a;
        AppUpdateParams a2 = C0809r.a(c0809r, c0809r.f1400a);
        C0809r c0809r2 = this.f1341a;
        Context context = c0809r2.f1400a;
        C0806o c0806o = c0809r2.b;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new P(context, c0806o, packageName, a2, new C0817z(emitter), new A(emitter));
    }
}
