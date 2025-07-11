package io.appmetrica.analytics.coreapi.internal.identifiers;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/identifiers/IdentifierStatus;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "Companion", "OK", "IDENTIFIER_PROVIDER_UNAVAILABLE", "INVALID_ADV_ID", "NO_STARTUP", "FORBIDDEN_BY_CLIENT_CONFIG", "FEATURE_DISABLED", "UNKNOWN", "core-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public enum IdentifierStatus {
    OK("OK"),
    IDENTIFIER_PROVIDER_UNAVAILABLE("IDENTIFIER_PROVIDER_UNAVAILABLE"),
    INVALID_ADV_ID("INVALID_ADV_ID"),
    NO_STARTUP("NO_STARTUP"),
    FORBIDDEN_BY_CLIENT_CONFIG("FORBIDDEN_BY_CLIENT_CONFIG"),
    FEATURE_DISABLED("FEATURE_DISABLED"),
    UNKNOWN("UNKNOWN");
    
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f243a;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/identifiers/IdentifierStatus$Companion;", "", "", "stringValue", "Lio/appmetrica/analytics/coreapi/internal/identifiers/IdentifierStatus;", "from", "core-api_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final IdentifierStatus from(String str) {
            IdentifierStatus identifierStatus;
            IdentifierStatus[] values = IdentifierStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    identifierStatus = null;
                    break;
                }
                identifierStatus = values[i];
                if (Intrinsics.areEqual(identifierStatus.getValue(), str)) {
                    break;
                }
                i++;
            }
            return identifierStatus == null ? IdentifierStatus.UNKNOWN : identifierStatus;
        }

        private Companion() {
        }
    }

    IdentifierStatus(String str) {
        this.f243a = str;
    }

    @JvmStatic
    public static final IdentifierStatus from(String str) {
        return Companion.from(str);
    }

    public final String getValue() {
        return this.f243a;
    }
}
