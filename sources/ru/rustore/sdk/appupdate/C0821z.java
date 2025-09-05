package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* renamed from: ru.rustore.sdk.appupdate.z  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0821z extends Lambda implements Function1<AppUpdateInfo, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter<AppUpdateInfo> f1415a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0821z(SingleEmitter<AppUpdateInfo> singleEmitter) {
        super(1);
        this.f1415a = singleEmitter;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(AppUpdateInfo appUpdateInfo) {
        AppUpdateInfo appUpdateInfo2 = appUpdateInfo;
        Intrinsics.checkNotNullParameter(appUpdateInfo2, "appUpdateInfo");
        this.f1415a.success(appUpdateInfo2);
        return Unit.INSTANCE;
    }
}
