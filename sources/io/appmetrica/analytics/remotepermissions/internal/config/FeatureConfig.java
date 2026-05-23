package io.appmetrica.analytics.remotepermissions.internal.config;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Set;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lio/appmetrica/analytics/remotepermissions/internal/config/FeatureConfig;", "", "", "toString", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/util/Set;", "getPermittedPermissions", "()Ljava/util/Set;", "permittedPermissions", "<init>", "(Ljava/util/Set;)V", "remote-permissions_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class FeatureConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Set f1427a;

    public FeatureConfig(Set<String> set) {
        this.f1427a = set;
    }

    public final Set<String> getPermittedPermissions() {
        return this.f1427a;
    }

    public String toString() {
        return "FeatureConfig(permittedPermissions=" + this.f1427a + ')';
    }
}
