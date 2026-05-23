package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateSerializer;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.pn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0518pn extends AbstractC0621tn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1151a;
    public final /* synthetic */ ProtobufStateSerializer b;
    public final /* synthetic */ ProtobufConverter c;

    public C0518pn(String str, ProtobufStateSerializer protobufStateSerializer, ProtobufConverter protobufConverter) {
        this.f1151a = str;
        this.b = protobufStateSerializer;
        this.c = protobufConverter;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0621tn
    public final IBinaryDataHelper a(Context context) {
        return Na.I.B().b(context);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0621tn
    public final IBinaryDataHelper b(Context context) {
        IBinaryDataHelper a2;
        C0128al B = Na.I.B();
        synchronized (B) {
            a2 = B.a(context);
        }
        return a2;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0621tn
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArr;
        byte[] bArr2;
        String str = this.f1151a;
        ProtobufStateSerializer protobufStateSerializer = this.b;
        try {
            bArr = AbstractC0402lb.a(context.getPackageName());
        } catch (Throwable unused) {
            bArr = new byte[16];
        }
        try {
            bArr2 = AbstractC0402lb.a(new StringBuilder(context.getPackageName()).reverse().toString());
        } catch (Throwable unused2) {
            bArr2 = new byte[16];
        }
        return new C0459ng(str, iBinaryDataHelper, new T8(protobufStateSerializer, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArr, bArr2)), this.c);
    }
}
