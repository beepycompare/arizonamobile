package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.ej  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0232ej extends MessageNano {
    public static volatile C0232ej[] e;

    /* renamed from: a  reason: collision with root package name */
    public long f866a;
    public C0258fj b;
    public int c;
    public byte[] d;

    public C0232ej() {
        a();
    }

    public static C0232ej[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C0232ej[0];
                }
            }
        }
        return e;
    }

    public final C0232ej a() {
        this.f866a = 0L;
        this.b = null;
        this.c = 0;
        this.d = WireFormatNano.EMPTY_BYTES;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f866a;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        C0258fj c0258fj = this.b;
        if (c0258fj != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0258fj);
        }
        int i = this.c;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        return !Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES) ? CodedOutputByteBufferNano.computeBytesSize(4, this.d) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f866a;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        C0258fj c0258fj = this.b;
        if (c0258fj != null) {
            codedOutputByteBufferNano.writeMessage(2, c0258fj);
        }
        int i = this.c;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0232ej mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f866a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0258fj();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 24) {
                this.c = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.d = codedInputByteBufferNano.readBytes();
            }
        }
        return this;
    }

    public static C0232ej b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0232ej().mergeFrom(codedInputByteBufferNano);
    }

    public static C0232ej a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0232ej) MessageNano.mergeFrom(new C0232ej(), bArr);
    }
}
