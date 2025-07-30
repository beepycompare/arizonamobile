package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.y8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0727y8 extends MessageNano {
    public static volatile C0727y8[] e;

    /* renamed from: a  reason: collision with root package name */
    public H8 f1151a;
    public J8 b;
    public A8 c;
    public G8 d;

    public C0727y8() {
        a();
    }

    public static C0727y8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C0727y8[0];
                }
            }
        }
        return e;
    }

    public final C0727y8 a() {
        this.f1151a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        H8 h8 = this.f1151a;
        if (h8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, h8);
        }
        J8 j8 = this.b;
        if (j8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, j8);
        }
        A8 a8 = this.c;
        if (a8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, a8);
        }
        G8 g8 = this.d;
        return g8 != null ? CodedOutputByteBufferNano.computeMessageSize(4, g8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        H8 h8 = this.f1151a;
        if (h8 != null) {
            codedOutputByteBufferNano.writeMessage(1, h8);
        }
        J8 j8 = this.b;
        if (j8 != null) {
            codedOutputByteBufferNano.writeMessage(2, j8);
        }
        A8 a8 = this.c;
        if (a8 != null) {
            codedOutputByteBufferNano.writeMessage(3, a8);
        }
        G8 g8 = this.d;
        if (g8 != null) {
            codedOutputByteBufferNano.writeMessage(4, g8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0727y8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1151a == null) {
                    this.f1151a = new H8();
                }
                codedInputByteBufferNano.readMessage(this.f1151a);
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new J8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new A8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new G8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0727y8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0727y8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0727y8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0727y8) MessageNano.mergeFrom(new C0727y8(), bArr);
    }
}
