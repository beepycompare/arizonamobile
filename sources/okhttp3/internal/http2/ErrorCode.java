package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ErrorCode.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/http2/ErrorCode;", "", "httpCode", "", "<init>", "(Ljava/lang/String;II)V", "getHttpCode", "()I", "NO_ERROR", "PROTOCOL_ERROR", "INTERNAL_ERROR", "FLOW_CONTROL_ERROR", "SETTINGS_TIMEOUT", "STREAM_CLOSED", "FRAME_SIZE_ERROR", "REFUSED_STREAM", "CANCEL", "COMPRESSION_ERROR", "CONNECT_ERROR", "ENHANCE_YOUR_CALM", "INADEQUATE_SECURITY", "HTTP_1_1_REQUIRED", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ErrorCode[] $VALUES;
    public static final Companion Companion;
    private final int httpCode;
    public static final ErrorCode NO_ERROR = new ErrorCode("NO_ERROR", 0, 0);
    public static final ErrorCode PROTOCOL_ERROR = new ErrorCode("PROTOCOL_ERROR", 1, 1);
    public static final ErrorCode INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 2, 2);
    public static final ErrorCode FLOW_CONTROL_ERROR = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
    public static final ErrorCode SETTINGS_TIMEOUT = new ErrorCode("SETTINGS_TIMEOUT", 4, 4);
    public static final ErrorCode STREAM_CLOSED = new ErrorCode("STREAM_CLOSED", 5, 5);
    public static final ErrorCode FRAME_SIZE_ERROR = new ErrorCode("FRAME_SIZE_ERROR", 6, 6);
    public static final ErrorCode REFUSED_STREAM = new ErrorCode("REFUSED_STREAM", 7, 7);
    public static final ErrorCode CANCEL = new ErrorCode("CANCEL", 8, 8);
    public static final ErrorCode COMPRESSION_ERROR = new ErrorCode("COMPRESSION_ERROR", 9, 9);
    public static final ErrorCode CONNECT_ERROR = new ErrorCode("CONNECT_ERROR", 10, 10);
    public static final ErrorCode ENHANCE_YOUR_CALM = new ErrorCode("ENHANCE_YOUR_CALM", 11, 11);
    public static final ErrorCode INADEQUATE_SECURITY = new ErrorCode("INADEQUATE_SECURITY", 12, 12);
    public static final ErrorCode HTTP_1_1_REQUIRED = new ErrorCode("HTTP_1_1_REQUIRED", 13, 13);

    private static final /* synthetic */ ErrorCode[] $values() {
        return new ErrorCode[]{NO_ERROR, PROTOCOL_ERROR, INTERNAL_ERROR, FLOW_CONTROL_ERROR, SETTINGS_TIMEOUT, STREAM_CLOSED, FRAME_SIZE_ERROR, REFUSED_STREAM, CANCEL, COMPRESSION_ERROR, CONNECT_ERROR, ENHANCE_YOUR_CALM, INADEQUATE_SECURITY, HTTP_1_1_REQUIRED};
    }

    public static EnumEntries<ErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static ErrorCode valueOf(String str) {
        return (ErrorCode) Enum.valueOf(ErrorCode.class, str);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) $VALUES.clone();
    }

    private ErrorCode(String str, int i, int i2) {
        this.httpCode = i2;
    }

    public final int getHttpCode() {
        return this.httpCode;
    }

    static {
        ErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lokhttp3/internal/http2/ErrorCode$Companion;", "", "<init>", "()V", "fromHttp2", "Lokhttp3/internal/http2/ErrorCode;", "code", "", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ErrorCode fromHttp2(int i) {
            ErrorCode[] values;
            for (ErrorCode errorCode : ErrorCode.values()) {
                if (errorCode.getHttpCode() == i) {
                    return errorCode;
                }
            }
            return null;
        }
    }
}
