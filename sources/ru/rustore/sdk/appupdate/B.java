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
    public final /* synthetic */ C0817r f1479a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0817r c0817r) {
        super(1);
        this.f1479a = c0817r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<AppUpdateInfo> singleEmitter) {
        SingleEmitter<AppUpdateInfo> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0817r c0817r = this.f1479a;
        AppUpdateParams a2 = C0817r.a(c0817r, c0817r.f1538a);
        C0817r c0817r2 = this.f1479a;
        Context context = c0817r2.f1538a;
        C0814o c0814o = c0817r2.b;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new P(context, c0814o, packageName, a2, new C0825z(emitter), new A(emitter));
    }
}
