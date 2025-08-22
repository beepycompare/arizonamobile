package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.qm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0540qm extends MessageNano {
    public static volatile C0540qm[] b;

    /* renamed from: a  reason: collision with root package name */
    public String f1031a;

    public C0540qm() {
        a();
    }

    public static C0540qm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0540qm[0];
                }
            }
        }
        return b;
    }

    public final C0540qm a() {
        this.f1031a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f1031a.equals("") ? CodedOutputByteBufferNano.computeStringSize(1, this.f1031a) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1031a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1031a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0540qm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1031a = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static C0540qm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0540qm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0540qm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0540qm) MessageNano.mergeFrom(new C0540qm(), bArr);
    }
}
