package com.arizona.launcher.updater.http;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateMetadataHttpClient.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "", "Success", "HttpError", "BodyTooLarge", "Timeout", NativeProtocol.ERROR_NETWORK_ERROR, "InvalidRequest", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$BodyTooLarge;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$HttpError;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$InvalidRequest;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$NetworkError;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$Success;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$Timeout;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UpdateMetadataHttpResult {

    /* compiled from: UpdateMetadataHttpClient.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$Success;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", TtmlNode.TAG_BODY, "", "<init>", "(Ljava/lang/String;)V", "getBody", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements UpdateMetadataHttpResult {
        public static final int $stable = 0;
        private final String body;

        public static /* synthetic */ Success copy$default(Success success, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.body;
            }
            return success.copy(str);
        }

        public final String component1() {
            return this.body;
        }

        public final Success copy(String body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return new Success(body);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.body, ((Success) obj).body);
        }

        public int hashCode() {
            return this.body.hashCode();
        }

        public String toString() {
            return "Success(body=" + this.body + ")";
        }

        public Success(String body) {
            Intrinsics.checkNotNullParameter(body, "body");
            this.body = body;
        }

        public final String getBody() {
            return this.body;
        }
    }

    /* compiled from: UpdateMetadataHttpClient.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$HttpError;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "statusCode", "", "<init>", "(I)V", "getStatusCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class HttpError implements UpdateMetadataHttpResult {
        public static final int $stable = 0;
        private final int statusCode;

        public static /* synthetic */ HttpError copy$default(HttpError httpError, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = httpError.statusCode;
            }
            return httpError.copy(i);
        }

        public final int component1() {
            return this.statusCode;
        }

        public final HttpError copy(int i) {
            return new HttpError(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HttpError) && this.statusCode == ((HttpError) obj).statusCode;
        }

        public int hashCode() {
            return Integer.hashCode(this.statusCode);
        }

        public String toString() {
            return "HttpError(statusCode=" + this.statusCode + ")";
        }

        public HttpError(int i) {
            this.statusCode = i;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }
    }

    /* compiled from: UpdateMetadataHttpClient.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nÊ\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$BodyTooLarge;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "limitBytes", "", "receivedBytes", "<init>", "(JLjava/lang/Long;)V", "getLimitBytes", "()J", "getReceivedBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(JLjava/lang/Long;)Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$BodyTooLarge;", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class BodyTooLarge implements UpdateMetadataHttpResult {
        public static final int $stable = 0;
        private final long limitBytes;
        private final Long receivedBytes;

        public static /* synthetic */ BodyTooLarge copy$default(BodyTooLarge bodyTooLarge, long j, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = bodyTooLarge.limitBytes;
            }
            if ((i & 2) != 0) {
                l = bodyTooLarge.receivedBytes;
            }
            return bodyTooLarge.copy(j, l);
        }

        public final long component1() {
            return this.limitBytes;
        }

        public final Long component2() {
            return this.receivedBytes;
        }

        public final BodyTooLarge copy(long j, Long l) {
            return new BodyTooLarge(j, l);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BodyTooLarge) {
                BodyTooLarge bodyTooLarge = (BodyTooLarge) obj;
                return this.limitBytes == bodyTooLarge.limitBytes && Intrinsics.areEqual(this.receivedBytes, bodyTooLarge.receivedBytes);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = Long.hashCode(this.limitBytes) * 31;
            Long l = this.receivedBytes;
            return hashCode + (l == null ? 0 : l.hashCode());
        }

        public String toString() {
            long j = this.limitBytes;
            return "BodyTooLarge(limitBytes=" + j + ", receivedBytes=" + this.receivedBytes + ")";
        }

        public BodyTooLarge(long j, Long l) {
            this.limitBytes = j;
            this.receivedBytes = l;
        }

        public final long getLimitBytes() {
            return this.limitBytes;
        }

        public final Long getReceivedBytes() {
            return this.receivedBytes;
        }
    }

    /* compiled from: UpdateMetadataHttpClient.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$Timeout;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "cause", "Ljava/io/IOException;", "<init>", "(Ljava/io/IOException;)V", "getCause", "()Ljava/io/IOException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Timeout implements UpdateMetadataHttpResult {
        public static final int $stable = 8;
        private final IOException cause;

        public static /* synthetic */ Timeout copy$default(Timeout timeout, IOException iOException, int i, Object obj) {
            if ((i & 1) != 0) {
                iOException = timeout.cause;
            }
            return timeout.copy(iOException);
        }

        public final IOException component1() {
            return this.cause;
        }

        public final Timeout copy(IOException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            return new Timeout(cause);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Timeout) && Intrinsics.areEqual(this.cause, ((Timeout) obj).cause);
        }

        public int hashCode() {
            return this.cause.hashCode();
        }

        public String toString() {
            return "Timeout(cause=" + this.cause + ")";
        }

        public Timeout(IOException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.cause = cause;
        }

        public final IOException getCause() {
            return this.cause;
        }
    }

    /* compiled from: UpdateMetadataHttpClient.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$NetworkError;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "cause", "Ljava/io/IOException;", "responseStarted", "", "<init>", "(Ljava/io/IOException;Z)V", "getCause", "()Ljava/io/IOException;", "getResponseStarted", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class NetworkError implements UpdateMetadataHttpResult {
        public static final int $stable = 8;
        private final IOException cause;
        private final boolean responseStarted;

        public static /* synthetic */ NetworkError copy$default(NetworkError networkError, IOException iOException, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                iOException = networkError.cause;
            }
            if ((i & 2) != 0) {
                z = networkError.responseStarted;
            }
            return networkError.copy(iOException, z);
        }

        public final IOException component1() {
            return this.cause;
        }

        public final boolean component2() {
            return this.responseStarted;
        }

        public final NetworkError copy(IOException cause, boolean z) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            return new NetworkError(cause, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NetworkError) {
                NetworkError networkError = (NetworkError) obj;
                return Intrinsics.areEqual(this.cause, networkError.cause) && this.responseStarted == networkError.responseStarted;
            }
            return false;
        }

        public int hashCode() {
            return (this.cause.hashCode() * 31) + Boolean.hashCode(this.responseStarted);
        }

        public String toString() {
            IOException iOException = this.cause;
            return "NetworkError(cause=" + iOException + ", responseStarted=" + this.responseStarted + ")";
        }

        public NetworkError(IOException cause, boolean z) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.cause = cause;
            this.responseStarted = z;
        }

        public /* synthetic */ NetworkError(IOException iOException, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(iOException, (i & 2) != 0 ? false : z);
        }

        public final IOException getCause() {
            return this.cause;
        }

        public final boolean getResponseStarted() {
            return this.responseStarted;
        }
    }

    /* compiled from: UpdateMetadataHttpClient.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\t\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bÊ\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult$InvalidRequest;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "cause", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "<init>", "(Ljava/lang/IllegalArgumentException;)V", "getCause", "()Ljava/lang/IllegalArgumentException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class InvalidRequest implements UpdateMetadataHttpResult {
        public static final int $stable = 8;
        private final IllegalArgumentException cause;

        public static /* synthetic */ InvalidRequest copy$default(InvalidRequest invalidRequest, IllegalArgumentException illegalArgumentException, int i, Object obj) {
            if ((i & 1) != 0) {
                illegalArgumentException = invalidRequest.cause;
            }
            return invalidRequest.copy(illegalArgumentException);
        }

        public final IllegalArgumentException component1() {
            return this.cause;
        }

        public final InvalidRequest copy(IllegalArgumentException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            return new InvalidRequest(cause);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InvalidRequest) && Intrinsics.areEqual(this.cause, ((InvalidRequest) obj).cause);
        }

        public int hashCode() {
            return this.cause.hashCode();
        }

        public String toString() {
            return "InvalidRequest(cause=" + this.cause + ")";
        }

        public InvalidRequest(IllegalArgumentException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.cause = cause;
        }

        public final IllegalArgumentException getCause() {
            return this.cause;
        }
    }
}
