package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class Ko extends MessageNano {
    public static volatile Ko[] e;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f633a;
    public double b;
    public double c;
    public boolean d;

    public Ko() {
        a();
    }

    public static Ko[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new Ko[0];
                }
            }
        }
        return e;
    }

    public final Ko a() {
        this.f633a = WireFormatNano.EMPTY_BYTES;
        this.b = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.c = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.d = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!Arrays.equals(this.f633a, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f633a);
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.b);
        }
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, this.c);
        }
        boolean z = this.d;
        return z ? CodedOutputByteBufferNano.computeBoolSize(4, z) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f633a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f633a);
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
            codedOutputByteBufferNano.writeDouble(2, this.b);
        }
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
            codedOutputByteBufferNano.writeDouble(3, this.c);
        }
        boolean z = this.d;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Ko mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f633a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 17) {
                this.b = codedInputByteBufferNano.readDouble();
            } else if (readTag == 25) {
                this.c = codedInputByteBufferNano.readDouble();
            } else if (readTag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.d = codedInputByteBufferNano.readBool();
            }
        }
        return this;
    }

    public static Ko b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Ko().mergeFrom(codedInputByteBufferNano);
    }

    public static Ko a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Ko) MessageNano.mergeFrom(new Ko(), bArr);
    }
}
