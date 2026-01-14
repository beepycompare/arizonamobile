package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.a  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0762a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0765d f1462a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0762a(C0765d c0765d) {
        super(0);
        this.f1462a = c0765d;
    }

    public static final void a(C0765d c0765d) {
        ((C0784x) c0765d.b).a("AndroidApiScreenshotCaptor");
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Activity.ScreenCaptureCallback invoke() {
        final C0765d c0765d = this.f1462a;
        return new Activity.ScreenCaptureCallback() { // from class: io.appmetrica.analytics.screenshot.impl.a$$ExternalSyntheticLambda0
            public final void onScreenCaptured() {
                C0762a.a(C0765d.this);
            }
        };
    }
}
