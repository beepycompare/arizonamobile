package com.arizona.game.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
/* loaded from: classes3.dex */
final class DualSenseUsbInput extends SonyUsbInput {
    static final float TOUCH_MAX_X = 1919.0f;
    static final float TOUCH_MAX_Y = 1079.0f;
    private final float[] degreesPerCount = {0.0625f, 0.0625f, 0.0625f};
    private long previousTimestamp = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.arizona.game.core.SonyUsbInput
    public float touchMaxX() {
        return TOUCH_MAX_X;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.arizona.game.core.SonyUsbInput
    public float touchMaxY() {
        return TOUCH_MAX_Y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.arizona.game.core.SonyUsbInput
    public void calibrate(byte[] bArr, int i) {
        if (i == 41 && bArr.length >= i && bArr[0] == 5) {
            int signed16 = signed16(bArr, 19) + signed16(bArr, 21);
            float[] fArr = new float[3];
            for (int i2 = 0; i2 < 3; i2++) {
                int signed162 = signed16(bArr, (i2 * 2) + 1);
                int i3 = i2 * 4;
                int abs = Math.abs(signed16(bArr, i3 + 7) - signed162) + Math.abs(signed16(bArr, i3 + 9) - signed162);
                if (abs <= 0 || signed16 <= 0 || Math.abs(signed162) > 1024) {
                    return;
                }
                float f = signed16 / abs;
                fArr[i2] = f;
                if (Math.abs((f * 16.0f) - 1.0f) > 0.5f) {
                    return;
                }
            }
            System.arraycopy(fArr, 0, this.degreesPerCount, 0, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.arizona.game.core.SonyUsbInput
    public boolean decode(byte[] bArr) {
        if (bArr.length == 64 && bArr[0] == 1) {
            this.lx = stick(bArr[1] & 255);
            this.ly = stick(bArr[2] & 255);
            this.rx = stick(bArr[3] & 255);
            this.ry = stick(bArr[4] & 255);
            this.l2 = (bArr[5] & 255) / 255.0f;
            this.r2 = (bArr[6] & 255) / 255.0f;
            byte b = bArr[8];
            byte b2 = bArr[9];
            this.buttons = 0;
            if ((b & 32) != 0) {
                this.buttons |= 1;
            }
            if ((b & SignedBytes.MAX_POWER_OF_TWO) != 0) {
                this.buttons |= 2;
            }
            if ((b & Ascii.DLE) != 0) {
                this.buttons |= 4;
            }
            if ((b & 128) != 0) {
                this.buttons = 8 | this.buttons;
            }
            if ((b2 & 1) != 0) {
                this.buttons |= 16;
            }
            if ((b2 & 2) != 0) {
                this.buttons |= 32;
            }
            if ((b2 & SignedBytes.MAX_POWER_OF_TWO) != 0) {
                this.buttons |= 256;
            }
            if ((b2 & 128) != 0) {
                this.buttons |= 512;
            }
            int i = b & Ascii.SI;
            if (i == 0 || i == 1 || i == 7) {
                this.buttons |= 1024;
            }
            if (i == 3 || i == 4 || i == 5) {
                this.buttons |= 2048;
            }
            if (i == 5 || i == 6 || i == 7) {
                this.buttons |= 4096;
            }
            if (i == 1 || i == 2 || i == 3) {
                this.buttons |= 8192;
            }
            if ((b2 & Ascii.DLE) != 0) {
                this.buttons |= 16384;
            }
            if ((b2 & 32) != 0) {
                this.buttons |= 32768;
            }
            this.touchpadClicked = (bArr[10] & 2) != 0;
            decodeTouch(bArr, 33, this.touch[0]);
            decodeTouch(bArr, 37, this.touch[1]);
            this.touchDataFresh = true;
            long j = 0;
            for (int i2 = 0; i2 < 4; i2++) {
                j |= (bArr[i2 + 28] & 255) << (i2 * 8);
            }
            long j2 = (j - this.previousTimestamp) & 4294967295L;
            this.pitch = 0.0f;
            this.yaw = 0.0f;
            if (this.previousTimestamp >= 0 && j2 > 0 && j2 <= 1500000) {
                float f = ((float) j2) / 3000000.0f;
                this.yaw = (-signed16(bArr, 20)) * this.degreesPerCount[2] * 0.017453292f * f;
                this.pitch = signed16(bArr, 16) * this.degreesPerCount[0] * 0.017453292f * f;
            }
            this.previousTimestamp = j;
            return true;
        }
        return false;
    }
}
