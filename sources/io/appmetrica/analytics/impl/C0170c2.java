package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.c2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0170c2 extends MessageNano {
    public static volatile C0170c2[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f778a;
    public boolean b;

    public C0170c2() {
        a();
    }

    public static C0170c2[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0170c2[0];
                }
            }
        }
        return c;
    }

    public final C0170c2 a() {
        this.f778a = "";
        this.b = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeBoolSize(2, this.b) + CodedOutputByteBufferNano.computeStringSize(1, this.f778a) + super.computeSerializedSize();
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f778a);
        codedOutputByteBufferNano.writeBool(2, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0170c2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f778a = codedInputByteBufferNano.readString();
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readBool();
            }
        }
        return this;
    }

    public static C0170c2 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0170c2().mergeFrom(codedInputByteBufferNano);
    }

    public static C0170c2 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0170c2) MessageNano.mergeFrom(new C0170c2(), bArr);
    }
}
