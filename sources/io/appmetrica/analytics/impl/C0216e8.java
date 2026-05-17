package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.e8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0216e8 extends MessageNano {
    public static volatile C0216e8[] e;

    /* renamed from: a  reason: collision with root package name */
    public C0446n8 f979a;
    public C0496p8 b;
    public C0268g8 c;
    public C0421m8 d;

    public C0216e8() {
        a();
    }

    public static C0216e8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C0216e8[0];
                }
            }
        }
        return e;
    }

    public final C0216e8 a() {
        this.f979a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0446n8 c0446n8 = this.f979a;
        if (c0446n8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0446n8);
        }
        C0496p8 c0496p8 = this.b;
        if (c0496p8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0496p8);
        }
        C0268g8 c0268g8 = this.c;
        if (c0268g8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0268g8);
        }
        C0421m8 c0421m8 = this.d;
        return c0421m8 != null ? CodedOutputByteBufferNano.computeMessageSize(4, c0421m8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0446n8 c0446n8 = this.f979a;
        if (c0446n8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0446n8);
        }
        C0496p8 c0496p8 = this.b;
        if (c0496p8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0496p8);
        }
        C0268g8 c0268g8 = this.c;
        if (c0268g8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0268g8);
        }
        C0421m8 c0421m8 = this.d;
        if (c0421m8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0421m8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0216e8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f979a == null) {
                    this.f979a = new C0446n8();
                }
                codedInputByteBufferNano.readMessage(this.f979a);
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0496p8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0268g8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new C0421m8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0216e8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0216e8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0216e8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0216e8) MessageNano.mergeFrom(new C0216e8(), bArr);
    }
}
