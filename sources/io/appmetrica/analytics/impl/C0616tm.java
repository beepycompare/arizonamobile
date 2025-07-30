package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.tm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0616tm extends MessageNano {
    public static volatile C0616tm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f1072a;
    public byte[] b;

    public C0616tm() {
        a();
    }

    public static C0616tm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0616tm[0];
                }
            }
        }
        return c;
    }

    public final C0616tm a() {
        this.f1072a = "";
        this.b = WireFormatNano.EMPTY_BYTES;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1072a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1072a);
        }
        return !Arrays.equals(this.b, WireFormatNano.EMPTY_BYTES) ? CodedOutputByteBufferNano.computeBytesSize(2, this.b) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1072a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1072a);
        }
        if (!Arrays.equals(this.b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0616tm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1072a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readBytes();
            }
        }
        return this;
    }

    public static C0616tm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0616tm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0616tm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0616tm) MessageNano.mergeFrom(new C0616tm(), bArr);
    }
}
