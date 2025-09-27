package io.appmetrica.analytics.screenshot.impl;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.screenshot.impl.a  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0770a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0773d f1311a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0770a(C0773d c0773d) {
        super(0);
        this.f1311a = c0773d;
    }

    public static final void a(C0773d c0773d) {
        ((C0790v) c0773d.b).a("AndroidApiScreenshotCaptor");
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Activity.ScreenCaptureCallback invoke() {
        final C0773d c0773d = this.f1311a;
        return new Activity.ScreenCaptureCallback() { // from class: io.appmetrica.analytics.screenshot.impl.a$$ExternalSyntheticLambda0
            public final void onScreenCaptured() {
                C0770a.a(C0773d.this);
            }
        };
    }
}
