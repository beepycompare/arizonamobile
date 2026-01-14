package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
/* renamed from: ru.rustore.sdk.appupdate.f  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0793f extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0792e f1544a;
    public final /* synthetic */ C0796i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0793f(C0792e c0792e, C0796i c0796i) {
        super(0);
        this.f1544a = c0792e;
        this.b = c0796i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0792e c0792e = this.f1544a;
        AnalyticsEventProvider analyticsEventProvider = c0792e.d;
        Context context = c0792e.e;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
        return Unit.INSTANCE;
    }
}
