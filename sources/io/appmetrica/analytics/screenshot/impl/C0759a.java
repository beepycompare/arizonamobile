package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.a  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0759a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0762d f1353a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0759a(C0762d c0762d) {
        super(0);
        this.f1353a = c0762d;
    }

    public static final void a(C0762d c0762d) {
        ((C0781x) c0762d.b).a("AndroidApiScreenshotCaptor");
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Activity.ScreenCaptureCallback invoke() {
        final C0762d c0762d = this.f1353a;
        return new Activity.ScreenCaptureCallback() { // from class: io.appmetrica.analytics.screenshot.impl.a$$ExternalSyntheticLambda0
            public final void onScreenCaptured() {
                C0759a.a(C0762d.this);
            }
        };
    }
}
