package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.a  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0771a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0774d f1311a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0771a(C0774d c0774d) {
        super(0);
        this.f1311a = c0774d;
    }

    public static final void a(C0774d c0774d) {
        ((C0791v) c0774d.b).a("AndroidApiScreenshotCaptor");
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Activity.ScreenCaptureCallback invoke() {
        final C0774d c0774d = this.f1311a;
        return new Activity.ScreenCaptureCallback() { // from class: io.appmetrica.analytics.screenshot.impl.a$$ExternalSyntheticLambda0
            public final void onScreenCaptured() {
                C0771a.a(C0774d.this);
            }
        };
    }
}
