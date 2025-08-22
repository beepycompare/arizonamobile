package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
/* renamed from: ru.rustore.sdk.appupdate.c  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0794c extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0796e f1368a;
    public final /* synthetic */ C0800i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0794c(C0796e c0796e, C0800i c0800i) {
        super(0);
        this.f1368a = c0796e;
        this.b = c0800i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0796e c0796e = this.f1368a;
        AnalyticsEventProvider analyticsEventProvider = c0796e.d;
        Context context = c0796e.e;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
        return Unit.INSTANCE;
    }
}
