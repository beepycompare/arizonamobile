package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.yf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0732yf extends MessageNano {
    public static volatile C0732yf[] d;

    /* renamed from: a  reason: collision with root package name */
    public String f1146a;
    public String b;
    public int c;

    public C0732yf() {
        a();
    }

    public static C0732yf[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C0732yf[0];
                }
            }
        }
        return d;
    }

    public final C0732yf a() {
        this.f1146a = "";
        this.b = "";
        this.c = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1146a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1146a);
        }
        if (!this.b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        return CodedOutputByteBufferNano.computeInt32Size(3, this.c) + computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1146a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1146a);
        }
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        codedOutputByteBufferNano.writeInt32(3, this.c);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0732yf mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1146a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.c = readInt32;
                }
            }
        }
        return this;
    }

    public static C0732yf b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0732yf().mergeFrom(codedInputByteBufferNano);
    }

    public static C0732yf a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0732yf) MessageNano.mergeFrom(new C0732yf(), bArr);
    }
}
