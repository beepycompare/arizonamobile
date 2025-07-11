package io.appmetrica.analytics.networktasks.internal;

import android.net.Uri;
/* loaded from: classes4.dex */
public class NetworkTaskForSendingDataParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    private final RequestBodyEncrypter f1243a;

    public NetworkTaskForSendingDataParamsAppender(RequestBodyEncrypter requestBodyEncrypter) {
        this.f1243a = requestBodyEncrypter;
    }

    public void appendEncryptedData(Uri.Builder builder) {
        if (this.f1243a.getEncryptionMode() == RequestBodyEncryptionMode.AES_RSA) {
            builder.appendQueryParameter(CommonUrlParts.ENCRYPTED_REQUEST, "1");
        }
    }
}
