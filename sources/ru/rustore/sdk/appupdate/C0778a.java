package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
/* renamed from: ru.rustore.sdk.appupdate.a  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0778a extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0782e f1461a;
    public final /* synthetic */ C0786i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0778a(C0782e c0782e, C0786i c0786i) {
        super(0);
        this.f1461a = c0782e;
        this.b = c0786i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0782e c0782e = this.f1461a;
        AnalyticsEventProvider analyticsEventProvider = c0782e.d;
        Context context = c0782e.e;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
        return Unit.INSTANCE;
    }
}
