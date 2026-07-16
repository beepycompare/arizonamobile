package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.x8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0710x8 extends MessageNano {
    public static volatile C0710x8[] e;

    /* renamed from: a  reason: collision with root package name */
    public G8 f1279a;
    public I8 b;
    public C0762z8 c;
    public F8 d;

    public C0710x8() {
        a();
    }

    public static C0710x8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C0710x8[0];
                }
            }
        }
        return e;
    }

    public final C0710x8 a() {
        this.f1279a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        G8 g8 = this.f1279a;
        if (g8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, g8);
        }
        I8 i8 = this.b;
        if (i8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, i8);
        }
        C0762z8 c0762z8 = this.c;
        if (c0762z8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0762z8);
        }
        F8 f8 = this.d;
        return f8 != null ? CodedOutputByteBufferNano.computeMessageSize(4, f8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        G8 g8 = this.f1279a;
        if (g8 != null) {
            codedOutputByteBufferNano.writeMessage(1, g8);
        }
        I8 i8 = this.b;
        if (i8 != null) {
            codedOutputByteBufferNano.writeMessage(2, i8);
        }
        C0762z8 c0762z8 = this.c;
        if (c0762z8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0762z8);
        }
        F8 f8 = this.d;
        if (f8 != null) {
            codedOutputByteBufferNano.writeMessage(4, f8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0710x8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1279a == null) {
                    this.f1279a = new G8();
                }
                codedInputByteBufferNano.readMessage(this.f1279a);
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new I8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0762z8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new F8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0710x8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0710x8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0710x8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0710x8) MessageNano.mergeFrom(new C0710x8(), bArr);
    }
}
