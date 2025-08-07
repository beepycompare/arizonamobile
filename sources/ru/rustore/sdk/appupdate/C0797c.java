package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
/* renamed from: ru.rustore.sdk.appupdate.c  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0797c extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0799e f1358a;
    public final /* synthetic */ C0803i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0797c(C0799e c0799e, C0803i c0803i) {
        super(0);
        this.f1358a = c0799e;
        this.b = c0803i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0799e c0799e = this.f1358a;
        AnalyticsEventProvider analyticsEventProvider = c0799e.d;
        Context context = c0799e.e;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
        return Unit.INSTANCE;
    }
}
