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
    public final /* synthetic */ C0801r f1479a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0801r c0801r) {
        super(1);
        this.f1479a = c0801r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<AppUpdateInfo> singleEmitter) {
        SingleEmitter<AppUpdateInfo> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0801r c0801r = this.f1479a;
        AppUpdateParams a2 = C0801r.a(c0801r, c0801r.f1538a);
        C0801r c0801r2 = this.f1479a;
        Context context = c0801r2.f1538a;
        C0798o c0798o = c0801r2.b;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new P(context, c0798o, packageName, a2, new C0809z(emitter), new A(emitter));
    }
}
