package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.mm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0436mm extends MessageNano {
    public static volatile C0436mm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f1124a;
    public C0411lm b;

    public C0436mm() {
        a();
    }

    public static C0436mm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0436mm[0];
                }
            }
        }
        return c;
    }

    public final C0436mm a() {
        this.f1124a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1124a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1124a);
        }
        C0411lm c0411lm = this.b;
        return c0411lm != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0411lm) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1124a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1124a);
        }
        C0411lm c0411lm = this.b;
        if (c0411lm != null) {
            codedOutputByteBufferNano.writeMessage(2, c0411lm);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0436mm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1124a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0411lm();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0436mm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0436mm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0436mm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0436mm) MessageNano.mergeFrom(new C0436mm(), bArr);
    }
}
