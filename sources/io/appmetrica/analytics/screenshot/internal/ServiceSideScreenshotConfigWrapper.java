package io.appmetrica.analytics.screenshot.internal;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.screenshot.impl.P;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lio/appmetrica/analytics/screenshot/internal/ServiceSideScreenshotConfigWrapper;", "", "Lio/appmetrica/analytics/screenshot/impl/P;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lio/appmetrica/analytics/screenshot/impl/P;", "getConfig$screenshot_release", "()Lio/appmetrica/analytics/screenshot/impl/P;", "config", "<init>", "(Lio/appmetrica/analytics/screenshot/impl/P;)V", "Companion", "screenshot_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class ServiceSideScreenshotConfigWrapper {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final P f1476a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lio/appmetrica/analytics/screenshot/internal/ServiceSideScreenshotConfigWrapper$Companion;", "", "Lio/appmetrica/analytics/screenshot/impl/P;", "Lio/appmetrica/analytics/screenshot/internal/ServiceSideScreenshotConfigWrapper;", "toWrapper$screenshot_release", "(Lio/appmetrica/analytics/screenshot/impl/P;)Lio/appmetrica/analytics/screenshot/internal/ServiceSideScreenshotConfigWrapper;", "toWrapper", "screenshot_release"}, k = 1, mv = {1, 9, 0})
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ServiceSideScreenshotConfigWrapper toWrapper$screenshot_release(P p) {
            return new ServiceSideScreenshotConfigWrapper(p);
        }

        private Companion() {
        }
    }

    public ServiceSideScreenshotConfigWrapper(P p) {
        this.f1476a = p;
    }

    public final P getConfig$screenshot_release() {
        return this.f1476a;
    }
}
