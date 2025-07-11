package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.t8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0600t8 extends MessageNano {
    public static volatile C0600t8[] c;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1056a;
    public C0700x8 b;

    public C0600t8() {
        a();
    }

    public static C0600t8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0600t8[0];
                }
            }
        }
        return c;
    }

    public final C0600t8 a() {
        this.f1056a = WireFormatNano.EMPTY_BYTES;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!Arrays.equals(this.f1056a, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f1056a);
        }
        C0700x8 c0700x8 = this.b;
        return c0700x8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0700x8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f1056a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f1056a);
        }
        C0700x8 c0700x8 = this.b;
        if (c0700x8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0700x8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0600t8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1056a = codedInputByteBufferNano.readBytes();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0700x8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0600t8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0600t8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0600t8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0600t8) MessageNano.mergeFrom(new C0600t8(), bArr);
    }
}
