package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
/* renamed from: ru.rustore.sdk.appupdate.f  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0790f extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0789e f1435a;
    public final /* synthetic */ C0793i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0790f(C0789e c0789e, C0793i c0793i) {
        super(0);
        this.f1435a = c0789e;
        this.b = c0793i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0789e c0789e = this.f1435a;
        AnalyticsEventProvider analyticsEventProvider = c0789e.d;
        Context context = c0789e.e;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
        return Unit.INSTANCE;
    }
}
