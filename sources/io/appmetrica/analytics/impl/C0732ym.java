package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.ym  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0732ym extends MessageNano {
    public static volatile C0732ym[] b;

    /* renamed from: a  reason: collision with root package name */
    public int f1218a;

    public C0732ym() {
        a();
    }

    public static C0732ym[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0732ym[0];
                }
            }
        }
        return b;
    }

    public final C0732ym a() {
        this.f1218a = 86400;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f1218a;
        return i != 86400 ? CodedOutputByteBufferNano.computeUInt32Size(1, i) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f1218a;
        if (i != 86400) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0732ym mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1218a = codedInputByteBufferNano.readUInt32();
            }
        }
        return this;
    }

    public static C0732ym b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0732ym().mergeFrom(codedInputByteBufferNano);
    }

    public static C0732ym a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0732ym) MessageNano.mergeFrom(new C0732ym(), bArr);
    }
}
