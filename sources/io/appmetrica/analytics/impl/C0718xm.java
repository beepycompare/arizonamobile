package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.xm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0718xm extends MessageNano {
    public static volatile C0718xm[] c;

    /* renamed from: a  reason: collision with root package name */
    public int f1156a;
    public int b;

    public C0718xm() {
        a();
    }

    public static C0718xm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0718xm[0];
                }
            }
        }
        return c;
    }

    public final C0718xm a() {
        this.f1156a = 86400;
        this.b = 86400;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f1156a;
        if (i != 86400) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        int i2 = this.b;
        return i2 != 86400 ? CodedOutputByteBufferNano.computeInt32Size(2, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f1156a;
        if (i != 86400) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        int i2 = this.b;
        if (i2 != 86400) {
            codedOutputByteBufferNano.writeInt32(2, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0718xm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1156a = codedInputByteBufferNano.readInt32();
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readInt32();
            }
        }
        return this;
    }

    public static C0718xm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0718xm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0718xm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0718xm) MessageNano.mergeFrom(new C0718xm(), bArr);
    }
}
