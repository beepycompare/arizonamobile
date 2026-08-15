package com.arizona.launcher;

import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DownloadFailureClassifier.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/DownloadFailureClassifier;", "", "<init>", "()V", "MAX_CAUSE_DEPTH", "", "classify", "Lcom/arizona/launcher/DownloadFailureDetails;", "cause", "", "causeChain", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DownloadFailureClassifier {
    public static final int $stable = 0;
    public static final DownloadFailureClassifier INSTANCE = new DownloadFailureClassifier();
    private static final int MAX_CAUSE_DEPTH = 8;

    private DownloadFailureClassifier() {
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DownloadFailureDetails classify(Throwable th) {
        List<Throwable> causeChain = causeChain(th);
        boolean z = causeChain instanceof Collection;
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th2 : causeChain) {
                if (th2 instanceof SocketTimeoutException) {
                    return new DownloadFailureDetails("TIMEOUT", null, DownloadFailureKind.TIMEOUT, 2, null);
                }
            }
        }
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th3 : causeChain) {
                if (th3 instanceof UnknownHostException) {
                    return new DownloadFailureDetails("DNS", null, DownloadFailureKind.DNS, 2, null);
                }
            }
        }
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th4 : causeChain) {
                if ((th4 instanceof SSLException) || (th4 instanceof CertificateException)) {
                    return new DownloadFailureDetails("TLS", null, null, 6, null);
                }
                while (r0.hasNext()) {
                }
            }
        }
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th5 : causeChain) {
                if ((th5 instanceof EOFException) || (th5 instanceof ProtocolException)) {
                    return new DownloadFailureDetails("TRUNCATED_RESPONSE", null, DownloadFailureKind.CONNECTION, 2, null);
                }
                while (r0.hasNext()) {
                }
            }
        }
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th6 : causeChain) {
                if (Intrinsics.areEqual(th6.getClass().getName(), "okhttp3.internal.http2.StreamResetException") || Intrinsics.areEqual(th6.getClass().getName(), "okhttp3.internal.http2.ConnectionShutdownException")) {
                    return new DownloadFailureDetails("HTTP2_RESET", null, DownloadFailureKind.CONNECTION, 2, null);
                }
                while (r0.hasNext()) {
                }
            }
        }
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th7 : causeChain) {
                if ((th7 instanceof ConnectException) || (th7 instanceof NoRouteToHostException) || (th7 instanceof PortUnreachableException) || (th7 instanceof SocketException)) {
                    return new DownloadFailureDetails("CONNECTION", null, DownloadFailureKind.CONNECTION, 2, null);
                }
                while (r0.hasNext()) {
                }
            }
        }
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th8 : causeChain) {
                if (th8 instanceof IOException) {
                    return new DownloadFailureDetails("IO", null, DownloadFailureKind.IO, 2, null);
                }
            }
        }
        return new DownloadFailureDetails("UNKNOWN", null, null, 6, null);
    }

    private final List<Throwable> causeChain(Throwable th) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8 && th != null; i++) {
            ArrayList<Throwable> arrayList2 = arrayList;
            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                for (Throwable th2 : arrayList2) {
                    if (th2 == th) {
                        return arrayList;
                    }
                }
                continue;
            }
            arrayList.add(th);
            th = th.getCause();
        }
        return arrayList;
    }
}
