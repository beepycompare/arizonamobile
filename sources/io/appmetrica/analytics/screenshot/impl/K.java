package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class K extends MessageNano {
    public static volatile K[] b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1277a;

    public K() {
        a();
    }

    public static K[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new K[0];
                }
            }
        }
        return b;
    }

    public final K a() {
        this.f1277a = true;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f1277a;
        return !z ? CodedOutputByteBufferNano.computeBoolSize(1, z) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f1277a;
        if (!z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final K mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1277a = codedInputByteBufferNano.readBool();
            }
        }
        return this;
    }

    public static K b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new K().mergeFrom(codedInputByteBufferNano);
    }

    public static K a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (K) MessageNano.mergeFrom(new K(), bArr);
    }
}
