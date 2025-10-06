package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
/* renamed from: ru.rustore.sdk.appupdate.a  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0797a extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0801e f1375a;
    public final /* synthetic */ C0805i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0797a(C0801e c0801e, C0805i c0805i) {
        super(0);
        this.f1375a = c0801e;
        this.b = c0805i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0801e c0801e = this.f1375a;
        AnalyticsEventProvider analyticsEventProvider = c0801e.d;
        Context context = c0801e.e;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
        return Unit.INSTANCE;
    }
}
