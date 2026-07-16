package io.appmetrica.analytics.adrevenue.other.internal;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.adrevenue.other.impl.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0000\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lio/appmetrica/analytics/adrevenue/other/internal/ClientSideAdRevenueOtherConfigWrapper;", "", "", "toString", "Lio/appmetrica/analytics/adrevenue/other/impl/e;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lio/appmetrica/analytics/adrevenue/other/impl/e;", "getConfig$ad_revenue_other_release", "()Lio/appmetrica/analytics/adrevenue/other/impl/e;", "config", "<init>", "(Lio/appmetrica/analytics/adrevenue/other/impl/e;)V", "Companion", "ad-revenue-other_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class ClientSideAdRevenueOtherConfigWrapper {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final e f255a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lio/appmetrica/analytics/adrevenue/other/internal/ClientSideAdRevenueOtherConfigWrapper$Companion;", "", "Lio/appmetrica/analytics/adrevenue/other/impl/e;", "Lio/appmetrica/analytics/adrevenue/other/internal/ClientSideAdRevenueOtherConfigWrapper;", "toWrapper$ad_revenue_other_release", "(Lio/appmetrica/analytics/adrevenue/other/impl/e;)Lio/appmetrica/analytics/adrevenue/other/internal/ClientSideAdRevenueOtherConfigWrapper;", "toWrapper", "ad-revenue-other_release"}, k = 1, mv = {1, 9, 0})
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClientSideAdRevenueOtherConfigWrapper toWrapper$ad_revenue_other_release(e eVar) {
            return new ClientSideAdRevenueOtherConfigWrapper(eVar);
        }

        private Companion() {
        }
    }

    public ClientSideAdRevenueOtherConfigWrapper(e eVar) {
        this.f255a = eVar;
    }

    public final e getConfig$ad_revenue_other_release() {
        return this.f255a;
    }

    public String toString() {
        return "ClientSideAdRevenueOtherConfigWrapper(config=" + this.f255a + ')';
    }
}
