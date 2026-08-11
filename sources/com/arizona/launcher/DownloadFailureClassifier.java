package com.arizona.launcher;

import com.google.android.gms.stats.CodePackage;
import com.liulishuo.okdownload.core.exception.DownloadSecurityException;
import com.liulishuo.okdownload.core.exception.PreAllocateException;
import com.liulishuo.okdownload.core.exception.ServerCanceledException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
/* compiled from: DownloadFailureClassifier.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/DownloadFailureClassifier;", "", "<init>", "()V", "MAX_CAUSE_DEPTH", "", "classify", "Lcom/arizona/launcher/DownloadFailureDetails;", "cause", "", "causeChain", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DownloadFailureClassifier {
    public static final int $stable = 0;
    public static final DownloadFailureClassifier INSTANCE = new DownloadFailureClassifier();
    private static final int MAX_CAUSE_DEPTH = 8;

    private DownloadFailureClassifier() {
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DownloadFailureDetails classify(Throwable th) {
        List<Throwable> causeChain = causeChain(th);
        ArrayList arrayList = new ArrayList();
        for (Object obj : causeChain) {
            if (obj instanceof ServerCanceledException) {
                arrayList.add(obj);
            }
        }
        ServerCanceledException serverCanceledException = (ServerCanceledException) CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        if (serverCanceledException != null) {
            int responseCode = serverCanceledException.getResponseCode();
            if (100 <= responseCode && responseCode < 600) {
                return new DownloadFailureDetails("HTTP_" + responseCode, Integer.valueOf(responseCode));
            }
            return new DownloadFailureDetails("HTTP_OTHER", null, 2, null);
        }
        boolean z = causeChain instanceof Collection;
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th2 : causeChain) {
                if (th2 instanceof SocketTimeoutException) {
                    return new DownloadFailureDetails("TIMEOUT", null, 2, null);
                }
            }
        }
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th3 : causeChain) {
                if (th3 instanceof UnknownHostException) {
                    return new DownloadFailureDetails("DNS", null, 2, null);
                }
            }
        }
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th4 : causeChain) {
                if ((th4 instanceof SSLException) || (th4 instanceof CertificateException)) {
                    return new DownloadFailureDetails("TLS", null, 2, null);
                }
                while (r2.hasNext()) {
                }
            }
        }
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th5 : causeChain) {
                if ((th5 instanceof ConnectException) || (th5 instanceof NoRouteToHostException) || (th5 instanceof PortUnreachableException) || (th5 instanceof SocketException)) {
                    return new DownloadFailureDetails("CONNECTION", null, 2, null);
                }
                while (r2.hasNext()) {
                }
            }
        }
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th6 : causeChain) {
                if (th6 instanceof PreAllocateException) {
                    return new DownloadFailureDetails("STORAGE", null, 2, null);
                }
            }
        }
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th7 : causeChain) {
                if (th7 instanceof DownloadSecurityException) {
                    return new DownloadFailureDetails(CodePackage.SECURITY, null, 2, null);
                }
            }
        }
        if (!z || !causeChain.isEmpty()) {
            for (Throwable th8 : causeChain) {
                if (th8 instanceof IOException) {
                    return new DownloadFailureDetails("IO", null, 2, null);
                }
            }
        }
        return new DownloadFailureDetails("UNKNOWN", null, 2, null);
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
