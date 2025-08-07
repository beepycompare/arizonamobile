package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.a  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0769a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0772d f1291a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0769a(C0772d c0772d) {
        super(0);
        this.f1291a = c0772d;
    }

    public static final void a(C0772d c0772d) {
        ((C0789v) c0772d.b).a("AndroidApiScreenshotCaptor");
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Activity.ScreenCaptureCallback invoke() {
        final C0772d c0772d = this.f1291a;
        return new Activity.ScreenCaptureCallback() { // from class: io.appmetrica.analytics.screenshot.impl.a$$ExternalSyntheticLambda0
            public final void onScreenCaptured() {
                C0769a.a(C0772d.this);
            }
        };
    }
}
