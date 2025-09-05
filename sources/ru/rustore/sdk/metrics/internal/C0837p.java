package ru.rustore.sdk.metrics.internal;

import java.net.URI;
import java.net.URL;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.metrics.BuildConfig;
/* renamed from: ru.rustore.sdk.metrics.internal.p  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0837p extends Lambda implements Function0<URL> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0839s f1460a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0837p(C0839s c0839s) {
        super(0);
        this.f1460a = c0839s;
    }

    @Override // kotlin.jvm.functions.Function0
    public final URL invoke() {
        this.f1460a.f1469a.getClass();
        return new URI(BuildConfig.BACKEND_URL).resolve("/v1/send_custom_event_batch").toURL();
    }
}
