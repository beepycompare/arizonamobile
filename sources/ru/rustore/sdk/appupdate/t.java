package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.ServiceConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
/* loaded from: classes5.dex */
public final class t extends Lambda implements Function1<CancellableContinuation<? super Unit>, ServiceConnection> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppUpdateInfo f1363a;
    public final /* synthetic */ j b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(AppUpdateInfo appUpdateInfo, j jVar) {
        super(1);
        this.f1363a = appUpdateInfo;
        this.b = jVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(CancellableContinuation<? super Unit> cancellableContinuation) {
        CancellableContinuation<? super Unit> continuation = cancellableContinuation;
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        this.f1363a.markIsUsed$sdk_public_appupdate_release();
        Context context = this.b.f1352a;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new c0(context, packageName, new q(continuation), new s(continuation));
    }
}
