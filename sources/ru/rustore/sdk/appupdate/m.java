package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.ServiceConnection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.appupdate.model.AppUpdateParams;
/* loaded from: classes5.dex */
public final class m extends Lambda implements Function1<CancellableContinuation<? super AppUpdateInfo>, ServiceConnection> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f1356a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar) {
        super(1);
        this.f1356a = jVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(CancellableContinuation<? super AppUpdateInfo> cancellableContinuation) {
        CancellableContinuation<? super AppUpdateInfo> continuation = cancellableContinuation;
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        j jVar = this.f1356a;
        AppUpdateParams a2 = j.a(jVar, jVar.f1351a);
        j jVar2 = this.f1356a;
        Context context = jVar2.f1351a;
        a aVar = jVar2.b;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new y(context, aVar, packageName, a2, new k(continuation), new l(continuation));
    }
}
