package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.a  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0766a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0769d f1288a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0766a(C0769d c0769d) {
        super(0);
        this.f1288a = c0769d;
    }

    public static final void a(C0769d c0769d) {
        ((C0786v) c0769d.b).a("AndroidApiScreenshotCaptor");
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Activity.ScreenCaptureCallback invoke() {
        final C0769d c0769d = this.f1288a;
        return new Activity.ScreenCaptureCallback() { // from class: io.appmetrica.analytics.screenshot.impl.a$$ExternalSyntheticLambda0
            public final void onScreenCaptured() {
                C0766a.a(C0769d.this);
            }
        };
    }
}
