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
    public final /* synthetic */ C0804r f1502a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0804r c0804r) {
        super(1);
        this.f1502a = c0804r;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(SingleEmitter<AppUpdateInfo> singleEmitter) {
        SingleEmitter<AppUpdateInfo> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0804r c0804r = this.f1502a;
        AppUpdateParams a2 = C0804r.a(c0804r, c0804r.f1561a);
        C0804r c0804r2 = this.f1502a;
        Context context = c0804r2.f1561a;
        C0801o c0801o = c0804r2.b;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new P(context, c0801o, packageName, a2, new C0812z(emitter), new A(emitter));
    }
}
