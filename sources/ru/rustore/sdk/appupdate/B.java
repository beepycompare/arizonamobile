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
    public final /* synthetic */ C0802r f1396a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0802r c0802r) {
        super(1);
        this.f1396a = c0802r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<AppUpdateInfo> singleEmitter) {
        SingleEmitter<AppUpdateInfo> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0802r c0802r = this.f1396a;
        AppUpdateParams a2 = C0802r.a(c0802r, c0802r.f1455a);
        C0802r c0802r2 = this.f1396a;
        Context context = c0802r2.f1455a;
        C0799o c0799o = c0802r2.b;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new P(context, c0799o, packageName, a2, new C0810z(emitter), new A(emitter));
    }
}
