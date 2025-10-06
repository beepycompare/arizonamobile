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
    public final /* synthetic */ C0814r f1351a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0814r c0814r) {
        super(1);
        this.f1351a = c0814r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<AppUpdateInfo> singleEmitter) {
        SingleEmitter<AppUpdateInfo> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0814r c0814r = this.f1351a;
        AppUpdateParams a2 = C0814r.a(c0814r, c0814r.f1410a);
        C0814r c0814r2 = this.f1351a;
        Context context = c0814r2.f1410a;
        C0811o c0811o = c0814r2.b;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new P(context, c0811o, packageName, a2, new C0822z(emitter), new A(emitter));
    }
}
