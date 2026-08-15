package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
/* renamed from: ru.rustore.sdk.appupdate.f  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0784f extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0783e f1478a;
    public final /* synthetic */ C0787i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0784f(C0783e c0783e, C0787i c0787i) {
        super(0);
        this.f1478a = c0783e;
        this.b = c0787i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0783e c0783e = this.f1478a;
        AnalyticsEventProvider analyticsEventProvider = c0783e.d;
        Context context = c0783e.e;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
        return Unit.INSTANCE;
    }
}
