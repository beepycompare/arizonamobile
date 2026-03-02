package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.a  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0761a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0764d f1461a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0761a(C0764d c0764d) {
        super(0);
        this.f1461a = c0764d;
    }

    public static final void a(C0764d c0764d) {
        ((C0783x) c0764d.b).a("AndroidApiScreenshotCaptor");
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Activity.ScreenCaptureCallback invoke() {
        final C0764d c0764d = this.f1461a;
        return new Activity.ScreenCaptureCallback() { // from class: io.appmetrica.analytics.screenshot.impl.a$$ExternalSyntheticLambda0
            public final void onScreenCaptured() {
                C0761a.a(C0764d.this);
            }
        };
    }
}
