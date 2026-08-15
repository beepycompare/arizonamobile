package com.arizona.launcher.updater.apk;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherApkModels.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\t\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u0082\u0001\t\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "", "InvalidRequest", "UnsafeUrl", "RedirectRejected", "HttpStatus", "Timeout", "Network", "Storage", "Integrity", "DestinationBusy", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$DestinationBusy;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$HttpStatus;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$Integrity;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$InvalidRequest;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$Network;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$RedirectRejected;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$Storage;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$Timeout;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$UnsafeUrl;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LauncherApkDownloadError {

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$InvalidRequest;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class InvalidRequest implements LauncherApkDownloadError {
        public static final int $stable = 0;
        private final String reason;

        public static /* synthetic */ InvalidRequest copy$default(InvalidRequest invalidRequest, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidRequest.reason;
            }
            return invalidRequest.copy(str);
        }

        public final String component1() {
            return this.reason;
        }

        public final InvalidRequest copy(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new InvalidRequest(reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InvalidRequest) && Intrinsics.areEqual(this.reason, ((InvalidRequest) obj).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "InvalidRequest(reason=" + this.reason + ")";
        }

        public InvalidRequest(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final String getReason() {
            return this.reason;
        }
    }

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$UnsafeUrl;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class UnsafeUrl implements LauncherApkDownloadError {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ UnsafeUrl copy$default(UnsafeUrl unsafeUrl, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unsafeUrl.url;
            }
            return unsafeUrl.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final UnsafeUrl copy(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new UnsafeUrl(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UnsafeUrl) && Intrinsics.areEqual(this.url, ((UnsafeUrl) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "UnsafeUrl(url=" + this.url + ")";
        }

        public UnsafeUrl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$RedirectRejected;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class RedirectRejected implements LauncherApkDownloadError {
        public static final int $stable = 0;
        private final String reason;

        public static /* synthetic */ RedirectRejected copy$default(RedirectRejected redirectRejected, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = redirectRejected.reason;
            }
            return redirectRejected.copy(str);
        }

        public final String component1() {
            return this.reason;
        }

        public final RedirectRejected copy(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new RedirectRejected(reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RedirectRejected) && Intrinsics.areEqual(this.reason, ((RedirectRejected) obj).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "RedirectRejected(reason=" + this.reason + ")";
        }

        public RedirectRejected(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final String getReason() {
            return this.reason;
        }
    }

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$HttpStatus;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "statusCode", "", "<init>", "(I)V", "getStatusCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class HttpStatus implements LauncherApkDownloadError {
        public static final int $stable = 0;
        private final int statusCode;

        public static /* synthetic */ HttpStatus copy$default(HttpStatus httpStatus, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = httpStatus.statusCode;
            }
            return httpStatus.copy(i);
        }

        public final int component1() {
            return this.statusCode;
        }

        public final HttpStatus copy(int i) {
            return new HttpStatus(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HttpStatus) && this.statusCode == ((HttpStatus) obj).statusCode;
        }

        public int hashCode() {
            return Integer.hashCode(this.statusCode);
        }

        public String toString() {
            return "HttpStatus(statusCode=" + this.statusCode + ")";
        }

        public HttpStatus(int i) {
            this.statusCode = i;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }
    }

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$Timeout;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "cause", "Ljava/io/IOException;", "<init>", "(Ljava/io/IOException;)V", "getCause", "()Ljava/io/IOException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Timeout implements LauncherApkDownloadError {
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

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$Network;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "cause", "Ljava/io/IOException;", "<init>", "(Ljava/io/IOException;)V", "getCause", "()Ljava/io/IOException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Network implements LauncherApkDownloadError {
        public static final int $stable = 8;
        private final IOException cause;

        public static /* synthetic */ Network copy$default(Network network, IOException iOException, int i, Object obj) {
            if ((i & 1) != 0) {
                iOException = network.cause;
            }
            return network.copy(iOException);
        }

        public final IOException component1() {
            return this.cause;
        }

        public final Network copy(IOException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            return new Network(cause);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Network) && Intrinsics.areEqual(this.cause, ((Network) obj).cause);
        }

        public int hashCode() {
            return this.cause.hashCode();
        }

        public String toString() {
            return "Network(cause=" + this.cause + ")";
        }

        public Network(IOException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.cause = cause;
        }

        public final IOException getCause() {
            return this.cause;
        }
    }

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$Storage;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "cause", "Ljava/io/IOException;", "<init>", "(Ljava/io/IOException;)V", "getCause", "()Ljava/io/IOException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Storage implements LauncherApkDownloadError {
        public static final int $stable = 8;
        private final IOException cause;

        public static /* synthetic */ Storage copy$default(Storage storage, IOException iOException, int i, Object obj) {
            if ((i & 1) != 0) {
                iOException = storage.cause;
            }
            return storage.copy(iOException);
        }

        public final IOException component1() {
            return this.cause;
        }

        public final Storage copy(IOException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            return new Storage(cause);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Storage) && Intrinsics.areEqual(this.cause, ((Storage) obj).cause);
        }

        public int hashCode() {
            return this.cause.hashCode();
        }

        public String toString() {
            return "Storage(cause=" + this.cause + ")";
        }

        public Storage(IOException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.cause = cause;
        }

        public final IOException getCause() {
            return this.cause;
        }
    }

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$Integrity;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Integrity implements LauncherApkDownloadError {
        public static final int $stable = 0;
        private final String reason;

        public static /* synthetic */ Integrity copy$default(Integrity integrity, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = integrity.reason;
            }
            return integrity.copy(str);
        }

        public final String component1() {
            return this.reason;
        }

        public final Integrity copy(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Integrity(reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Integrity) && Intrinsics.areEqual(this.reason, ((Integrity) obj).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Integrity(reason=" + this.reason + ")";
        }

        public Integrity(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final String getReason() {
            return this.reason;
        }
    }

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ê\u0001\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError$DestinationBusy;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "<init>", "()V", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DestinationBusy implements LauncherApkDownloadError {
        public static final int $stable = 0;
        public static final DestinationBusy INSTANCE = new DestinationBusy();

        private DestinationBusy() {
        }
    }
}
