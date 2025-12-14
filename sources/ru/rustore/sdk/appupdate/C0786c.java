package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
/* renamed from: ru.rustore.sdk.appupdate.c  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0786c extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0788e f1520a;
    public final /* synthetic */ C0792i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0786c(C0788e c0788e, C0792i c0792i) {
        super(0);
        this.f1520a = c0788e;
        this.b = c0792i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0788e c0788e = this.f1520a;
        AnalyticsEventProvider analyticsEventProvider = c0788e.d;
        Context context = c0788e.e;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
        return Unit.INSTANCE;
    }
}
