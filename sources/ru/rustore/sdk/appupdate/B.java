package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.ServiceConnection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.appupdate.model.AppUpdateParams;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* loaded from: classes4.dex */
public final class B extends Lambda implements Function1<SingleEmitter<AppUpdateInfo>, ServiceConnection> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0813r f1346a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0813r c0813r) {
        super(1);
        this.f1346a = c0813r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<AppUpdateInfo> singleEmitter) {
        SingleEmitter<AppUpdateInfo> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0813r c0813r = this.f1346a;
        AppUpdateParams a2 = C0813r.a(c0813r, c0813r.f1405a);
        C0813r c0813r2 = this.f1346a;
        Context context = c0813r2.f1405a;
        C0810o c0810o = c0813r2.b;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new P(context, c0810o, packageName, a2, new C0821z(emitter), new A(emitter));
    }
}
