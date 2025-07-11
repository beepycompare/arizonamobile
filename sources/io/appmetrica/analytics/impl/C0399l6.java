package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.l6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0399l6 extends MessageNano {
    public static volatile C0399l6[] d;

    /* renamed from: a  reason: collision with root package name */
    public C0374k6 f919a;
    public String b;
    public int c;

    public C0399l6() {
        a();
    }

    public static C0399l6[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C0399l6[0];
                }
            }
        }
        return d;
    }

    public final C0399l6 a() {
        this.f919a = null;
        this.b = "";
        this.c = -1;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0374k6 c0374k6 = this.f919a;
        if (c0374k6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0374k6);
        }
        if (!this.b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        int i = this.c;
        return i != -1 ? CodedOutputByteBufferNano.computeInt32Size(3, i) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0374k6 c0374k6 = this.f919a;
        if (c0374k6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0374k6);
        }
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        int i = this.c;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0399l6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f919a == null) {
                    this.f919a = new C0374k6();
                }
                codedInputByteBufferNano.readMessage(this.f919a);
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == -1 || readInt32 == 0 || readInt32 == 1) {
                    this.c = readInt32;
                }
            }
        }
        return this;
    }

    public static C0399l6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0399l6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0399l6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0399l6) MessageNano.mergeFrom(new C0399l6(), bArr);
    }
}
