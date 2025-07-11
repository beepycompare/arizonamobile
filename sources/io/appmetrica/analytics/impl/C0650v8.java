package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.v8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0650v8 extends MessageNano {
    public static volatile C0650v8[] e;

    /* renamed from: a  reason: collision with root package name */
    public E8 f1088a;
    public G8 b;
    public C0700x8 c;
    public D8 d;

    public C0650v8() {
        a();
    }

    public static C0650v8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C0650v8[0];
                }
            }
        }
        return e;
    }

    public final C0650v8 a() {
        this.f1088a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        E8 e8 = this.f1088a;
        if (e8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, e8);
        }
        G8 g8 = this.b;
        if (g8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, g8);
        }
        C0700x8 c0700x8 = this.c;
        if (c0700x8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0700x8);
        }
        D8 d8 = this.d;
        return d8 != null ? CodedOutputByteBufferNano.computeMessageSize(4, d8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        E8 e8 = this.f1088a;
        if (e8 != null) {
            codedOutputByteBufferNano.writeMessage(1, e8);
        }
        G8 g8 = this.b;
        if (g8 != null) {
            codedOutputByteBufferNano.writeMessage(2, g8);
        }
        C0700x8 c0700x8 = this.c;
        if (c0700x8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0700x8);
        }
        D8 d8 = this.d;
        if (d8 != null) {
            codedOutputByteBufferNano.writeMessage(4, d8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0650v8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1088a == null) {
                    this.f1088a = new E8();
                }
                codedInputByteBufferNano.readMessage(this.f1088a);
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new G8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0700x8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new D8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0650v8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0650v8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0650v8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0650v8) MessageNano.mergeFrom(new C0650v8(), bArr);
    }
}
