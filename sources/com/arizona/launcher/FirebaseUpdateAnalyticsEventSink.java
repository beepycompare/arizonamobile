package com.arizona.launcher;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateAnalyticsReporter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/FirebaseUpdateAnalyticsEventSink;", "Lcom/arizona/launcher/UpdateAnalyticsEventSink;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "analytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "logEvent", "", "name", "", "payload", "", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FirebaseUpdateAnalyticsEventSink implements UpdateAnalyticsEventSink {
    public static final int $stable = 8;
    private final FirebaseAnalytics analytics;

    public FirebaseUpdateAnalyticsEventSink(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        this.analytics = firebaseAnalytics;
    }

    @Override // com.arizona.launcher.UpdateAnalyticsEventSink
    public void logEvent(String name, Map<String, ? extends Object> payload) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(payload, "payload");
        FirebaseAnalytics firebaseAnalytics = this.analytics;
        bundle = UpdateAnalyticsReporterKt.toBundle(payload);
        firebaseAnalytics.logEvent(name, bundle);
    }
}
