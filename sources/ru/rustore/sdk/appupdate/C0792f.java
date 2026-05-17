package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
/* renamed from: ru.rustore.sdk.appupdate.f  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0792f extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0791e f1548a;
    public final /* synthetic */ C0795i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0792f(C0791e c0791e, C0795i c0795i) {
        super(0);
        this.f1548a = c0791e;
        this.b = c0795i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0791e c0791e = this.f1548a;
        AnalyticsEventProvider analyticsEventProvider = c0791e.d;
        Context context = c0791e.e;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
        return Unit.INSTANCE;
    }
}
