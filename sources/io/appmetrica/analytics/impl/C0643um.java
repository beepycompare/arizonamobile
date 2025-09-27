package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.um  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0643um extends MessageNano {
    public static volatile C0643um[] b;

    /* renamed from: a  reason: collision with root package name */
    public String f1116a;

    public C0643um() {
        a();
    }

    public static C0643um[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0643um[0];
                }
            }
        }
        return b;
    }

    public final C0643um a() {
        this.f1116a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f1116a.equals("") ? CodedOutputByteBufferNano.computeStringSize(1, this.f1116a) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1116a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1116a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0643um mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1116a = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static C0643um b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0643um().mergeFrom(codedInputByteBufferNano);
    }

    public static C0643um a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0643um) MessageNano.mergeFrom(new C0643um(), bArr);
    }
}
