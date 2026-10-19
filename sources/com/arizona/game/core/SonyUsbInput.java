package com.arizona.game.core;

import com.google.common.base.Ascii;
/* loaded from: classes3.dex */
abstract class SonyUsbInput {
    int buttons;
    float l2;
    float lx;
    float ly;
    float pitch;
    float r2;
    float rx;
    float ry;
    final Touch[] touch = {new Touch(), new Touch()};
    boolean touchDataFresh;
    boolean touchpadClicked;
    float yaw;

    private static long mix(long j, int i) {
        return (j ^ (i & 4294967295L)) * 1099511628211L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void calibrate(byte[] bArr, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean decode(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float touchMaxX();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float touchMaxY();

    /* loaded from: classes3.dex */
    static final class Touch {
        boolean active;
        int id;
        int x;
        int y;

        Touch() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long controlsSignature() {
        return mix(mix(mix(mix(mix(mix(this.buttons, Float.floatToIntBits(this.lx)), Float.floatToIntBits(this.ly)), Float.floatToIntBits(this.rx)), Float.floatToIntBits(this.ry)), Float.floatToIntBits(this.l2)), Float.floatToIntBits(this.r2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float stick(int i) {
        float f = (i - 128) / (i < 128 ? 128.0f : 127.0f);
        if (Math.abs(f) <= 0.2f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int signed16(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) | (bArr[i] & 255));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void decodeTouch(byte[] bArr, int i, Touch touch) {
        touch.active = (bArr[i] & 128) == 0;
        touch.id = bArr[i] & Byte.MAX_VALUE;
        int i2 = i + 2;
        touch.x = (bArr[i + 1] & 255) | ((bArr[i2] & Ascii.SI) << 8);
        touch.y = ((bArr[i + 3] & 255) << 4) | ((bArr[i2] & 240) >> 4);
    }
}
