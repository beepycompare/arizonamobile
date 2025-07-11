package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Headers;
import okhttp3.internal._UtilCommonKt;
/* compiled from: WebSocketExtensions.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dBG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003JN\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "<init>", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "noContextTakeover", "clientOriginated", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", "hashCode", "toString", "", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webSocketExtensions.perMessageDeflate;
        }
        if ((i & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        if ((i & 4) != 0) {
            z2 = webSocketExtensions.clientNoContextTakeover;
        }
        if ((i & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        if ((i & 16) != 0) {
            z3 = webSocketExtensions.serverNoContextTakeover;
        }
        if ((i & 32) != 0) {
            z4 = webSocketExtensions.unknownValues;
        }
        boolean z5 = z3;
        boolean z6 = z4;
        return webSocketExtensions.copy(z, num, z2, num2, z5, z6);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        return new WebSocketExtensions(z, num, z2, num2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WebSocketExtensions) {
            WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
            return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && Intrinsics.areEqual(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && Intrinsics.areEqual(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.perMessageDeflate) * 31;
        Integer num = this.clientMaxWindowBits;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.clientNoContextTakeover)) * 31;
        Integer num2 = this.serverMaxWindowBits;
        return ((((hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31) + Boolean.hashCode(this.serverNoContextTakeover)) * 31) + Boolean.hashCode(this.unknownValues);
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.perMessageDeflate = z;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z2;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z3;
        this.unknownValues = z4;
    }

    public /* synthetic */ WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4);
    }

    public final boolean noContextTakeover(boolean z) {
        if (z) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    /* compiled from: WebSocketExtensions.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "<init>", "()V", "HEADER_WEB_SOCKET_EXTENSION", "", "parse", "Lokhttp3/internal/ws/WebSocketExtensions;", "responseHeaders", "Lokhttp3/Headers;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
            if (r6 != false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
            if (r2 >= r5) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
            r3 = okhttp3.internal._UtilCommonKt.delimiterOffset(r14, ';', r2, r5);
            r6 = okhttp3.internal._UtilCommonKt.delimiterOffset(r14, '=', r2, r3);
            r2 = okhttp3.internal._UtilCommonKt.trimSubstring(r14, r2, r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0065, code lost:
            if (r6 >= r3) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
            r6 = kotlin.text.StringsKt.removeSurrounding(okhttp3.internal._UtilCommonKt.trimSubstring(r14, r6 + 1, r3), (java.lang.CharSequence) "\"");
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0076, code lost:
            r6 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
            r3 = r3 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
            if (kotlin.text.StringsKt.equals(r2, "client_max_window_bits", true) == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0081, code lost:
            if (r7 == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0083, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
            if (r6 == null) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0086, code lost:
            r7 = kotlin.text.StringsKt.toIntOrNull(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
            r7 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
            if (r7 != null) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
            r2 = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0098, code lost:
            if (kotlin.text.StringsKt.equals(r2, "client_no_context_takeover", true) == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x009a, code lost:
            if (r8 == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x009c, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x009d, code lost:
            if (r6 == null) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x009f, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00a0, code lost:
            r2 = r3;
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a9, code lost:
            if (kotlin.text.StringsKt.equals(r2, "server_max_window_bits", true) == false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ab, code lost:
            if (r9 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00ad, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00ae, code lost:
            if (r6 == null) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00b0, code lost:
            r9 = kotlin.text.StringsKt.toIntOrNull(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00b6, code lost:
            r9 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00b7, code lost:
            if (r9 != null) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00c0, code lost:
            if (kotlin.text.StringsKt.equals(r2, "server_no_context_takeover", true) == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00c2, code lost:
            if (r10 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00c4, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00c5, code lost:
            if (r6 == null) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00c7, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00c8, code lost:
            r2 = r3;
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00cb, code lost:
            r2 = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00cc, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00ce, code lost:
            r5 = r2;
            r6 = true;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00cc -> B:14:0x0055). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final WebSocketExtensions parse(Headers responseHeaders) throws IOException {
            Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            boolean z = false;
            Integer num = null;
            boolean z2 = false;
            Integer num2 = null;
            boolean z3 = false;
            boolean z4 = false;
            for (int i = 0; i < size; i++) {
                if (StringsKt.equals(responseHeaders.name(i), "Sec-WebSocket-Extensions", true)) {
                    String value = responseHeaders.value(i);
                    int i2 = 0;
                    while (i2 < value.length()) {
                        int i3 = i2;
                        int delimiterOffset$default = _UtilCommonKt.delimiterOffset$default(value, (char) AbstractJsonLexerKt.COMMA, i3, 0, 4, (Object) null);
                        int delimiterOffset = _UtilCommonKt.delimiterOffset(value, ';', i3, delimiterOffset$default);
                        String trimSubstring = _UtilCommonKt.trimSubstring(value, i3, delimiterOffset);
                        int i4 = delimiterOffset + 1;
                        if (!StringsKt.equals(trimSubstring, "permessage-deflate", true)) {
                            i2 = i4;
                            z4 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z, num, z2, num2, z3, z4);
        }
    }
}
