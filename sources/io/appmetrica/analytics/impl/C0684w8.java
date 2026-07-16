package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.w8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0684w8 extends MessageNano {
    public static volatile C0684w8[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0710x8 f1263a;

    public C0684w8() {
        a();
    }

    public static C0684w8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0684w8[0];
                }
            }
        }
        return b;
    }

    public final C0684w8 a() {
        this.f1263a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0710x8 c0710x8 = this.f1263a;
        return c0710x8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, c0710x8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0710x8 c0710x8 = this.f1263a;
        if (c0710x8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0710x8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0684w8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f1263a == null) {
                    this.f1263a = new C0710x8();
                }
                codedInputByteBufferNano.readMessage(this.f1263a);
            }
        }
        return this;
    }

    public static C0684w8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0684w8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0684w8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0684w8) MessageNano.mergeFrom(new C0684w8(), bArr);
    }
}
