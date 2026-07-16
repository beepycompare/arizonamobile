package io.appmetrica.analytics.idsync.internal.model;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\r\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lio/appmetrica/analytics/idsync/internal/model/IdSyncConfig;", "", "other", "", "equals", "", "hashCode", "", "toString", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Z", "getEnabled", "()Z", "enabled", "", "b", "J", "getLaunchDelay", "()J", "launchDelay", "", "Lio/appmetrica/analytics/idsync/internal/model/RequestConfig;", "c", "Ljava/util/List;", "getRequests", "()Ljava/util/List;", "requests", "<init>", "(ZJLjava/util/List;)V", "id-sync_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class IdSyncConfig {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f444a;
    private final long b;
    private final List c;

    public IdSyncConfig(boolean z, long j, List<RequestConfig> list) {
        this.f444a = z;
        this.b = j;
        this.c = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(IdSyncConfig.class, obj != null ? obj.getClass() : null)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.appmetrica.analytics.idsync.internal.model.IdSyncConfig");
            IdSyncConfig idSyncConfig = (IdSyncConfig) obj;
            return this.f444a == idSyncConfig.f444a && this.b == idSyncConfig.b && Intrinsics.areEqual(this.c, idSyncConfig.c);
        }
        return false;
    }

    public final boolean getEnabled() {
        return this.f444a;
    }

    public final long getLaunchDelay() {
        return this.b;
    }

    public final List<RequestConfig> getRequests() {
        return this.c;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.b);
        return this.c.hashCode() + ((hashCode + (Boolean.hashCode(this.f444a) * 31)) * 31);
    }

    public String toString() {
        return "IdSyncConfig(enabled=" + this.f444a + ", launchDelay=" + this.b + ", requests=" + this.c + ')';
    }
}
