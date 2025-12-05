package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.a  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0758a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0761d f1438a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0758a(C0761d c0761d) {
        super(0);
        this.f1438a = c0761d;
    }

    public static final void a(C0761d c0761d) {
        ((C0780x) c0761d.b).a("AndroidApiScreenshotCaptor");
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Activity.ScreenCaptureCallback invoke() {
        final C0761d c0761d = this.f1438a;
        return new Activity.ScreenCaptureCallback() { // from class: io.appmetrica.analytics.screenshot.impl.a$$ExternalSyntheticLambda0
            public final void onScreenCaptured() {
                C0758a.a(C0761d.this);
            }
        };
    }
}
