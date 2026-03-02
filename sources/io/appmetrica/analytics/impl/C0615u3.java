package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.u3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0615u3 extends MessageNano {
    public static volatile C0615u3[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0665w3 f1247a;
    public int b;

    public C0615u3() {
        a();
    }

    public static C0615u3[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0615u3[0];
                }
            }
        }
        return c;
    }

    public final C0615u3 a() {
        this.f1247a = null;
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0665w3 c0665w3 = this.f1247a;
        if (c0665w3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0665w3);
        }
        int i = this.b;
        return i != 0 ? CodedOutputByteBufferNano.computeInt32Size(2, i) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0665w3 c0665w3 = this.f1247a;
        if (c0665w3 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0665w3);
        }
        int i = this.b;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0615u3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1247a == null) {
                    this.f1247a = new C0665w3();
                }
                codedInputByteBufferNano.readMessage(this.f1247a);
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.b = readInt32;
                }
            }
        }
        return this;
    }

    public static C0615u3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0615u3().mergeFrom(codedInputByteBufferNano);
    }

    public static C0615u3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0615u3) MessageNano.mergeFrom(new C0615u3(), bArr);
    }
}
