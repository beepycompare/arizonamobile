package io.appmetrica.analytics.coreapi.internal.identifiers;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetId;", "", "", "component1", "Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdScope;", "component2", "id", "scope", "copy", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "b", "Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdScope;", "getScope", "()Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdScope;", "<init>", "(Ljava/lang/String;Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdScope;)V", "core-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class AppSetId {

    /* renamed from: a  reason: collision with root package name */
    private final String f240a;
    private final AppSetIdScope b;

    public AppSetId(String str, AppSetIdScope appSetIdScope) {
        this.f240a = str;
        this.b = appSetIdScope;
    }

    public static /* synthetic */ AppSetId copy$default(AppSetId appSetId, String str, AppSetIdScope appSetIdScope, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appSetId.f240a;
        }
        if ((i & 2) != 0) {
            appSetIdScope = appSetId.b;
        }
        return appSetId.copy(str, appSetIdScope);
    }

    public final String component1() {
        return this.f240a;
    }

    public final AppSetIdScope component2() {
        return this.b;
    }

    public final AppSetId copy(String str, AppSetIdScope appSetIdScope) {
        return new AppSetId(str, appSetIdScope);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppSetId) {
            AppSetId appSetId = (AppSetId) obj;
            return Intrinsics.areEqual(this.f240a, appSetId.f240a) && this.b == appSetId.b;
        }
        return false;
    }

    public final String getId() {
        return this.f240a;
    }

    public final AppSetIdScope getScope() {
        return this.b;
    }

    public int hashCode() {
        String str = this.f240a;
        return this.b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public String toString() {
        return "AppSetId(id=" + this.f240a + ", scope=" + this.b + ')';
    }
}
