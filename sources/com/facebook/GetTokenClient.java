package com.facebook;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
/* loaded from: classes3.dex */
final class GetTokenClient extends PlatformServiceClient {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GetTokenClient(Context context, String str) {
        super(context, 65536, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY, NativeProtocol.PROTOCOL_VERSION_20121101, str);
    }

    @Override // com.facebook.internal.PlatformServiceClient
    protected void populateRequestBundle(Bundle bundle) {
    }
}
