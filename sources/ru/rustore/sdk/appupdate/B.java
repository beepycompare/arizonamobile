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
    public final /* synthetic */ C0796r f1437a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0796r c0796r) {
        super(1);
        this.f1437a = c0796r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<AppUpdateInfo> singleEmitter) {
        SingleEmitter<AppUpdateInfo> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0796r c0796r = this.f1437a;
        AppUpdateParams a2 = C0796r.a(c0796r, c0796r.f1496a);
        C0796r c0796r2 = this.f1437a;
        Context context = c0796r2.f1496a;
        C0793o c0793o = c0796r2.b;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new P(context, c0793o, packageName, a2, new C0804z(emitter), new A(emitter));
    }
}
