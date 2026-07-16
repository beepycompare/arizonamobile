package io.appmetrica.analytics.screenshot.impl;

import android.os.Bundle;
import io.appmetrica.analytics.modulesapi.internal.client.BundleToServiceConfigConverter;
import io.appmetrica.analytics.screenshot.internal.ClientSideScreenshotConfigWrapper;
import java.util.List;
/* renamed from: io.appmetrica.analytics.screenshot.impl.g  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0785g implements BundleToServiceConfigConverter {
    @Override // io.appmetrica.analytics.modulesapi.internal.client.BundleToServiceConfigConverter
    /* renamed from: a */
    public final ClientSideScreenshotConfigWrapper fromBundle(Bundle bundle) {
        boolean z = AbstractC0791m.f1455a;
        boolean z2 = bundle.getBoolean("enabled", AbstractC0791m.f1455a);
        C0787i c0787i = new C0787i(bundle.getBoolean("api_captor_enabled", AbstractC0791m.c));
        C0790l c0790l = new C0790l(bundle.getBoolean("service_captor_enabled", AbstractC0791m.d), bundle.getLong("service_captor_delay_seconds", AbstractC0791m.e));
        boolean z3 = bundle.getBoolean("content_observer_enabled", AbstractC0791m.f);
        List stringArrayList = bundle.getStringArrayList("content_observer_media_store_column_names");
        if (stringArrayList == null) {
            stringArrayList = AbstractC0791m.b;
        }
        return ClientSideScreenshotConfigWrapper.Companion.toWrapper$screenshot_release(new C0789k(z2, c0787i, c0790l, new C0788j(z3, stringArrayList, bundle.getLong("content_observer_detect_window_seconds", AbstractC0791m.g))));
    }
}
