package io.appmetrica.analytics.coreapi.internal.identifiers;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/identifiers/PlatformIdentifiers;", "", "Lio/appmetrica/analytics/coreapi/internal/identifiers/SimpleAdvertisingIdGetter;", "component1", "Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdProvider;", "component2", "advIdentifiersProvider", "appSetIdProvider", "copy", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lio/appmetrica/analytics/coreapi/internal/identifiers/SimpleAdvertisingIdGetter;", "getAdvIdentifiersProvider", "()Lio/appmetrica/analytics/coreapi/internal/identifiers/SimpleAdvertisingIdGetter;", "b", "Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdProvider;", "getAppSetIdProvider", "()Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdProvider;", "<init>", "(Lio/appmetrica/analytics/coreapi/internal/identifiers/SimpleAdvertisingIdGetter;Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdProvider;)V", "core-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class PlatformIdentifiers {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleAdvertisingIdGetter f244a;
    private final AppSetIdProvider b;

    public PlatformIdentifiers(SimpleAdvertisingIdGetter simpleAdvertisingIdGetter, AppSetIdProvider appSetIdProvider) {
        this.f244a = simpleAdvertisingIdGetter;
        this.b = appSetIdProvider;
    }

    public static /* synthetic */ PlatformIdentifiers copy$default(PlatformIdentifiers platformIdentifiers, SimpleAdvertisingIdGetter simpleAdvertisingIdGetter, AppSetIdProvider appSetIdProvider, int i, Object obj) {
        if ((i & 1) != 0) {
            simpleAdvertisingIdGetter = platformIdentifiers.f244a;
        }
        if ((i & 2) != 0) {
            appSetIdProvider = platformIdentifiers.b;
        }
        return platformIdentifiers.copy(simpleAdvertisingIdGetter, appSetIdProvider);
    }

    public final SimpleAdvertisingIdGetter component1() {
        return this.f244a;
    }

    public final AppSetIdProvider component2() {
        return this.b;
    }

    public final PlatformIdentifiers copy(SimpleAdvertisingIdGetter simpleAdvertisingIdGetter, AppSetIdProvider appSetIdProvider) {
        return new PlatformIdentifiers(simpleAdvertisingIdGetter, appSetIdProvider);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlatformIdentifiers) {
            PlatformIdentifiers platformIdentifiers = (PlatformIdentifiers) obj;
            return Intrinsics.areEqual(this.f244a, platformIdentifiers.f244a) && Intrinsics.areEqual(this.b, platformIdentifiers.b);
        }
        return false;
    }

    public final SimpleAdvertisingIdGetter getAdvIdentifiersProvider() {
        return this.f244a;
    }

    public final AppSetIdProvider getAppSetIdProvider() {
        return this.b;
    }

    public int hashCode() {
        return this.b.hashCode() + (this.f244a.hashCode() * 31);
    }

    public String toString() {
        return "PlatformIdentifiers(advIdentifiersProvider=" + this.f244a + ", appSetIdProvider=" + this.b + ')';
    }
}
