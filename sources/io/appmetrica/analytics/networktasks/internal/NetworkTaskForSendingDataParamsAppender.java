package io.appmetrica.analytics.networktasks.internal;

import android.net.Uri;
/* loaded from: classes5.dex */
public class NetworkTaskForSendingDataParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    private final RequestBodyEncrypter f1307a;

    public NetworkTaskForSendingDataParamsAppender(RequestBodyEncrypter requestBodyEncrypter) {
        this.f1307a = requestBodyEncrypter;
    }

    public void appendEncryptedData(Uri.Builder builder) {
        if (this.f1307a.getEncryptionMode() == RequestBodyEncryptionMode.AES_RSA) {
            builder.appendQueryParameter(CommonUrlParts.ENCRYPTED_REQUEST, "1");
        }
    }
}
