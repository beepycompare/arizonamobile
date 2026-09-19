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
    public final /* synthetic */ C0795r f1437a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0795r c0795r) {
        super(1);
        this.f1437a = c0795r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<AppUpdateInfo> singleEmitter) {
        SingleEmitter<AppUpdateInfo> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0795r c0795r = this.f1437a;
        AppUpdateParams a2 = C0795r.a(c0795r, c0795r.f1496a);
        C0795r c0795r2 = this.f1437a;
        Context context = c0795r2.f1496a;
        C0792o c0792o = c0795r2.b;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new P(context, c0792o, packageName, a2, new C0803z(emitter), new A(emitter));
    }
}
