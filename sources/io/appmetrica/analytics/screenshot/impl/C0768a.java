package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.a  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0768a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0771d f1292a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0768a(C0771d c0771d) {
        super(0);
        this.f1292a = c0771d;
    }

    public static final void a(C0771d c0771d) {
        ((C0788v) c0771d.b).a("AndroidApiScreenshotCaptor");
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Activity.ScreenCaptureCallback invoke() {
        final C0771d c0771d = this.f1292a;
        return new Activity.ScreenCaptureCallback() { // from class: io.appmetrica.analytics.screenshot.impl.a$$ExternalSyntheticLambda0
            public final void onScreenCaptured() {
                C0768a.a(C0771d.this);
            }
        };
    }
}
