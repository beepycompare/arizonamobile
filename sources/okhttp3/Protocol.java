package okhttp3;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Protocol.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Lokhttp3/Protocol;", "", "protocol", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "HTTP_3", "toString", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Protocol {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Protocol[] $VALUES;
    public static final Companion Companion;
    private final String protocol;
    public static final Protocol HTTP_1_0 = new Protocol("HTTP_1_0", 0, "http/1.0");
    public static final Protocol HTTP_1_1 = new Protocol("HTTP_1_1", 1, "http/1.1");
    @Deprecated(message = "OkHttp has dropped support for SPDY. Prefer {@link #HTTP_2}.")
    public static final Protocol SPDY_3 = new Protocol("SPDY_3", 2, "spdy/3.1");
    public static final Protocol HTTP_2 = new Protocol("HTTP_2", 3, "h2");
    public static final Protocol H2_PRIOR_KNOWLEDGE = new Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
    public static final Protocol QUIC = new Protocol("QUIC", 5, "quic");
    public static final Protocol HTTP_3 = new Protocol("HTTP_3", 6, "h3");

    private static final /* synthetic */ Protocol[] $values() {
        return new Protocol[]{HTTP_1_0, HTTP_1_1, SPDY_3, HTTP_2, H2_PRIOR_KNOWLEDGE, QUIC, HTTP_3};
    }

    @JvmStatic
    public static final Protocol get(String str) throws IOException {
        return Companion.get(str);
    }

    public static EnumEntries<Protocol> getEntries() {
        return $ENTRIES;
    }

    public static Protocol valueOf(String str) {
        return (Protocol) Enum.valueOf(Protocol.class, str);
    }

    public static Protocol[] values() {
        return (Protocol[]) $VALUES.clone();
    }

    private Protocol(String str, int i, String str2) {
        this.protocol = str2;
    }

    static {
        Protocol[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }

    /* compiled from: Protocol.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lokhttp3/Protocol$Companion;", "", "<init>", "()V", "get", "Lokhttp3/Protocol;", "protocol", "", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Protocol get(String protocol) throws IOException {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            if (Intrinsics.areEqual(protocol, Protocol.HTTP_1_0.protocol)) {
                return Protocol.HTTP_1_0;
            }
            if (Intrinsics.areEqual(protocol, Protocol.HTTP_1_1.protocol)) {
                return Protocol.HTTP_1_1;
            }
            if (Intrinsics.areEqual(protocol, Protocol.H2_PRIOR_KNOWLEDGE.protocol)) {
                return Protocol.H2_PRIOR_KNOWLEDGE;
            }
            if (Intrinsics.areEqual(protocol, Protocol.HTTP_2.protocol)) {
                return Protocol.HTTP_2;
            }
            if (Intrinsics.areEqual(protocol, Protocol.SPDY_3.protocol)) {
                return Protocol.SPDY_3;
            }
            if (Intrinsics.areEqual(protocol, Protocol.QUIC.protocol)) {
                return Protocol.QUIC;
            }
            if (StringsKt.startsWith$default(protocol, Protocol.HTTP_3.protocol, false, 2, (Object) null)) {
                return Protocol.HTTP_3;
            }
            throw new IOException("Unexpected protocol: " + protocol);
        }
    }
}
