package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.ServiceConnection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.appupdate.model.AppUpdateParams;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* loaded from: classes5.dex */
public final class B extends Lambda implements Function1<SingleEmitter<AppUpdateInfo>, ServiceConnection> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0812r f1331a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0812r c0812r) {
        super(1);
        this.f1331a = c0812r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<AppUpdateInfo> singleEmitter) {
        SingleEmitter<AppUpdateInfo> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0812r c0812r = this.f1331a;
        AppUpdateParams a2 = C0812r.a(c0812r, c0812r.f1390a);
        C0812r c0812r2 = this.f1331a;
        Context context = c0812r2.f1390a;
        C0809o c0809o = c0812r2.b;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new P(context, c0809o, packageName, a2, new C0820z(emitter), new A(emitter));
    }
}
