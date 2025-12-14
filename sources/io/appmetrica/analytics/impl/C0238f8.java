package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.f8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0238f8 extends MessageNano {
    public static volatile C0238f8[] e;

    /* renamed from: a  reason: collision with root package name */
    public C0468o8 f984a;
    public C0518q8 b;
    public C0290h8 c;
    public C0443n8 d;

    public C0238f8() {
        a();
    }

    public static C0238f8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C0238f8[0];
                }
            }
        }
        return e;
    }

    public final C0238f8 a() {
        this.f984a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0468o8 c0468o8 = this.f984a;
        if (c0468o8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0468o8);
        }
        C0518q8 c0518q8 = this.b;
        if (c0518q8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0518q8);
        }
        C0290h8 c0290h8 = this.c;
        if (c0290h8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0290h8);
        }
        C0443n8 c0443n8 = this.d;
        return c0443n8 != null ? CodedOutputByteBufferNano.computeMessageSize(4, c0443n8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0468o8 c0468o8 = this.f984a;
        if (c0468o8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0468o8);
        }
        C0518q8 c0518q8 = this.b;
        if (c0518q8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0518q8);
        }
        C0290h8 c0290h8 = this.c;
        if (c0290h8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0290h8);
        }
        C0443n8 c0443n8 = this.d;
        if (c0443n8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0443n8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0238f8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f984a == null) {
                    this.f984a = new C0468o8();
                }
                codedInputByteBufferNano.readMessage(this.f984a);
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0518q8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0290h8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new C0443n8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0238f8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0238f8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0238f8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0238f8) MessageNano.mergeFrom(new C0238f8(), bArr);
    }
}
