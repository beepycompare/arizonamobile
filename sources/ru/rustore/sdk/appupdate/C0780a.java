package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
/* renamed from: ru.rustore.sdk.appupdate.a  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0780a extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0784e f1461a;
    public final /* synthetic */ C0788i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0780a(C0784e c0784e, C0788i c0788i) {
        super(0);
        this.f1461a = c0784e;
        this.b = c0788i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0784e c0784e = this.f1461a;
        AnalyticsEventProvider analyticsEventProvider = c0784e.d;
        Context context = c0784e.e;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
        return Unit.INSTANCE;
    }
}
