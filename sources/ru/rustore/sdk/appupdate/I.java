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
    public final /* synthetic */ C0795r f1444a;
    public final /* synthetic */ AppUpdateInfo b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(C0795r c0795r, AppUpdateInfo appUpdateInfo) {
        super(1);
        this.f1444a = c0795r;
        this.b = appUpdateInfo;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Single<Integer> invoke(Unit unit) {
        Unit it = unit;
        Intrinsics.checkNotNullParameter(it, "it");
        C0795r c0795r = this.f1444a;
        AppUpdateInfo appUpdateInfo = this.b;
        c0795r.getClass();
        return Single.Companion.create(new C(c0795r, appUpdateInfo));
    }
}
