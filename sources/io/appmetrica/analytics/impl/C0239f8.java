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
public final class C0239f8 extends MessageNano {
    public static volatile C0239f8[] e;

    /* renamed from: a  reason: collision with root package name */
    public C0469o8 f887a;
    public C0519q8 b;
    public C0291h8 c;
    public C0444n8 d;

    public C0239f8() {
        a();
    }

    public static C0239f8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C0239f8[0];
                }
            }
        }
        return e;
    }

    public final C0239f8 a() {
        this.f887a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0469o8 c0469o8 = this.f887a;
        if (c0469o8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0469o8);
        }
        C0519q8 c0519q8 = this.b;
        if (c0519q8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0519q8);
        }
        C0291h8 c0291h8 = this.c;
        if (c0291h8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0291h8);
        }
        C0444n8 c0444n8 = this.d;
        return c0444n8 != null ? CodedOutputByteBufferNano.computeMessageSize(4, c0444n8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0469o8 c0469o8 = this.f887a;
        if (c0469o8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0469o8);
        }
        C0519q8 c0519q8 = this.b;
        if (c0519q8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0519q8);
        }
        C0291h8 c0291h8 = this.c;
        if (c0291h8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0291h8);
        }
        C0444n8 c0444n8 = this.d;
        if (c0444n8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0444n8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0239f8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f887a == null) {
                    this.f887a = new C0469o8();
                }
                codedInputByteBufferNano.readMessage(this.f887a);
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0519q8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0291h8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new C0444n8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0239f8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0239f8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0239f8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0239f8) MessageNano.mergeFrom(new C0239f8(), bArr);
    }
}
