package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.ServiceConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
/* loaded from: classes5.dex */
public final class i extends Lambda implements Function1<CancellableContinuation<? super Unit>, ServiceConnection> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f1351a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar) {
        super(1);
        this.f1351a = jVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ServiceConnection invoke(CancellableContinuation<? super Unit> cancellableContinuation) {
        CancellableContinuation<? super Unit> continuation = cancellableContinuation;
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Context context = this.f1351a.f1352a;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return new e0(context, packageName, new g(continuation), new h(continuation));
    }
}
