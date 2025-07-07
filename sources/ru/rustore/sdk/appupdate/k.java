package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.core.util.CancellableContinuationExtKt;
/* loaded from: classes5.dex */
public final class k extends Lambda implements Function1<AppUpdateInfo, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<AppUpdateInfo> f1354a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k(CancellableContinuation<? super AppUpdateInfo> cancellableContinuation) {
        super(1);
        this.f1354a = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(AppUpdateInfo appUpdateInfo) {
        AppUpdateInfo appUpdateInfo2 = appUpdateInfo;
        Intrinsics.checkNotNullParameter(appUpdateInfo2, "appUpdateInfo");
        CancellableContinuationExtKt.resumeIfActive(this.f1354a, appUpdateInfo2);
        return Unit.INSTANCE;
    }
}
