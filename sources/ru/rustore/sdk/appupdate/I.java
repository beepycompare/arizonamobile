package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.reactive.single.Single;
/* loaded from: classes6.dex */
public final class I extends Lambda implements Function1<Unit, Single<Integer>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0809r f1348a;
    public final /* synthetic */ AppUpdateInfo b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(C0809r c0809r, AppUpdateInfo appUpdateInfo) {
        super(1);
        this.f1348a = c0809r;
        this.b = appUpdateInfo;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Single<Integer> invoke(Unit unit) {
        Unit it = unit;
        Intrinsics.checkNotNullParameter(it, "it");
        C0809r c0809r = this.f1348a;
        AppUpdateInfo appUpdateInfo = this.b;
        c0809r.getClass();
        return Single.Companion.create(new C(c0809r, appUpdateInfo));
    }
}
