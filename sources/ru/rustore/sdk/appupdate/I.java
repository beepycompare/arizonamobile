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
    public final /* synthetic */ C0805r f1509a;
    public final /* synthetic */ AppUpdateInfo b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(C0805r c0805r, AppUpdateInfo appUpdateInfo) {
        super(1);
        this.f1509a = c0805r;
        this.b = appUpdateInfo;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Single<Integer> invoke(Unit unit) {
        Unit it = unit;
        Intrinsics.checkNotNullParameter(it, "it");
        C0805r c0805r = this.f1509a;
        AppUpdateInfo appUpdateInfo = this.b;
        c0805r.getClass();
        return Single.Companion.create(new C(c0805r, appUpdateInfo));
    }
}
