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
public final class C0433mm extends MessageNano {
    public static volatile C0433mm[] b;

    /* renamed from: a  reason: collision with root package name */
    public String f1015a;

    public C0433mm() {
        a();
    }

    public static C0433mm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0433mm[0];
                }
            }
        }
        return b;
    }

    public final C0433mm a() {
        this.f1015a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f1015a.equals("") ? CodedOutputByteBufferNano.computeStringSize(1, this.f1015a) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1015a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1015a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0433mm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1015a = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static C0433mm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0433mm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0433mm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0433mm) MessageNano.mergeFrom(new C0433mm(), bArr);
    }
}
