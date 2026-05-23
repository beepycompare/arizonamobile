package io.appmetrica.analytics.screenshot.internal;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.screenshot.impl.C0789k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lio/appmetrica/analytics/screenshot/internal/ClientSideScreenshotConfigWrapper;", "", "Lio/appmetrica/analytics/screenshot/impl/k;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lio/appmetrica/analytics/screenshot/impl/k;", "getConfig$screenshot_release", "()Lio/appmetrica/analytics/screenshot/impl/k;", "config", "<init>", "(Lio/appmetrica/analytics/screenshot/impl/k;)V", "Companion", "screenshot_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class ClientSideScreenshotConfigWrapper {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final C0789k f1464a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lio/appmetrica/analytics/screenshot/internal/ClientSideScreenshotConfigWrapper$Companion;", "", "Lio/appmetrica/analytics/screenshot/impl/k;", "Lio/appmetrica/analytics/screenshot/internal/ClientSideScreenshotConfigWrapper;", "toWrapper$screenshot_release", "(Lio/appmetrica/analytics/screenshot/impl/k;)Lio/appmetrica/analytics/screenshot/internal/ClientSideScreenshotConfigWrapper;", "toWrapper", "screenshot_release"}, k = 1, mv = {1, 9, 0})
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClientSideScreenshotConfigWrapper toWrapper$screenshot_release(C0789k c0789k) {
            return new ClientSideScreenshotConfigWrapper(c0789k);
        }

        private Companion() {
        }
    }

    public ClientSideScreenshotConfigWrapper(C0789k c0789k) {
        this.f1464a = c0789k;
    }

    public final C0789k getConfig$screenshot_release() {
        return this.f1464a;
    }
}
