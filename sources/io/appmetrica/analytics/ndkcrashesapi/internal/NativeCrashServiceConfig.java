package io.appmetrica.analytics.ndkcrashesapi.internal;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashServiceConfig;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getNativeCrashFolder", "()Ljava/lang/String;", "nativeCrashFolder", "<init>", "(Ljava/lang/String;)V", "ndkcrashes-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class NativeCrashServiceConfig {

    /* renamed from: a  reason: collision with root package name */
    private final String f1216a;

    public NativeCrashServiceConfig(String str) {
        this.f1216a = str;
    }

    public final String getNativeCrashFolder() {
        return this.f1216a;
    }
}
