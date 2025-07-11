package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.sm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0589sm extends MessageNano {
    public static volatile C0589sm[] b;

    /* renamed from: a  reason: collision with root package name */
    public int f1049a;

    public C0589sm() {
        a();
    }

    public static C0589sm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0589sm[0];
                }
            }
        }
        return b;
    }

    public final C0589sm a() {
        this.f1049a = 86400;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f1049a;
        return i != 86400 ? CodedOutputByteBufferNano.computeUInt32Size(1, i) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f1049a;
        if (i != 86400) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0589sm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1049a = codedInputByteBufferNano.readUInt32();
            }
        }
        return this;
    }

    public static C0589sm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0589sm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0589sm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0589sm) MessageNano.mergeFrom(new C0589sm(), bArr);
    }
}
