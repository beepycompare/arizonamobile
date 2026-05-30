package io.appmetrica.analytics.adrevenue.other.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class c extends MessageNano {
    public static volatile c[] c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f236a;
    public boolean b;

    public c() {
        a();
    }

    public static c[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new c[0];
                }
            }
        }
        return c;
    }

    public final c a() {
        this.f236a = false;
        this.b = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f236a;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        boolean z2 = this.b;
        return z2 ? CodedOutputByteBufferNano.computeBoolSize(2, z2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f236a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        boolean z2 = this.b;
        if (z2) {
            codedOutputByteBufferNano.writeBool(2, z2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f236a = codedInputByteBufferNano.readBool();
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readBool();
            }
        }
        return this;
    }

    public static c b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new c().mergeFrom(codedInputByteBufferNano);
    }

    public static c a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }
}
