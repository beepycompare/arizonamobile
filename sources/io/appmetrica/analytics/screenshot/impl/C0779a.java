package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.a  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0779a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0782d f1445a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0779a(C0782d c0782d) {
        super(0);
        this.f1445a = c0782d;
    }

    public static final void a(C0782d c0782d) {
        ((C0798u) c0782d.b).a("AndroidApiScreenshotCaptor");
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Activity.ScreenCaptureCallback invoke() {
        final C0782d c0782d = this.f1445a;
        return new Activity.ScreenCaptureCallback() { // from class: io.appmetrica.analytics.screenshot.impl.a$$ExternalSyntheticLambda0
            public final void onScreenCaptured() {
                C0779a.a(C0782d.this);
            }
        };
    }
}
