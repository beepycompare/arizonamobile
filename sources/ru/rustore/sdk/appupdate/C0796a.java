package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
/* renamed from: ru.rustore.sdk.appupdate.a  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0796a extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0800e f1370a;
    public final /* synthetic */ C0804i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0796a(C0800e c0800e, C0804i c0804i) {
        super(0);
        this.f1370a = c0800e;
        this.b = c0804i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0800e c0800e = this.f1370a;
        AnalyticsEventProvider analyticsEventProvider = c0800e.d;
        Context context = c0800e.e;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
        return Unit.INSTANCE;
    }
}
