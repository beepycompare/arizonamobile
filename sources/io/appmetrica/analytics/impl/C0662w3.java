package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.w3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0662w3 extends MessageNano {
    public static volatile C0662w3[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f1276a;
    public String b;

    public C0662w3() {
        a();
    }

    public static C0662w3[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0662w3[0];
                }
            }
        }
        return c;
    }

    public final C0662w3 a() {
        this.f1276a = "";
        this.b = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1276a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1276a);
        }
        return !this.b.equals("") ? CodedOutputByteBufferNano.computeStringSize(2, this.b) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1276a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1276a);
        }
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0662w3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1276a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static C0662w3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0662w3().mergeFrom(codedInputByteBufferNano);
    }

    public static C0662w3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0662w3) MessageNano.mergeFrom(new C0662w3(), bArr);
    }
}
