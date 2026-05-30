package ru.rustore.sdk.appupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
/* renamed from: ru.rustore.sdk.appupdate.a  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0800a extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0804e f1504a;
    public final /* synthetic */ C0808i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0800a(C0804e c0804e, C0808i c0808i) {
        super(0);
        this.f1504a = c0804e;
        this.b = c0808i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        C0804e c0804e = this.f1504a;
        AnalyticsEventProvider analyticsEventProvider = c0804e.d;
        Context context = c0804e.e;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        analyticsEventProvider.postAnalyticsEvent(context, packageName, this.b);
        return Unit.INSTANCE;
    }
}
