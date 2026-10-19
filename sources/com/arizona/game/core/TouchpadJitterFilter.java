package com.arizona.game.core;
/* loaded from: classes3.dex */
final class TouchpadJitterFilter {
    static final float MAX_POSITION_CORRECTION_DISTANCE = 16.0f;
    static final float POSITION_CORRECTION = 1.0f;
    static final float RADIUS = 5.0f;
    static final float SETTLE_EPSILON = 0.001f;
    static final int VELOCITY_WINDOW = 7;
    boolean active;
    int id;
    private float rawX;
    private float rawY;
    private float robustX;
    private float robustY;
    private int velocityAt;
    float x;
    float y;
    private final float[] velocityX = new float[7];
    private final float[] velocityY = new float[7];
    private final float[] medianScratch = new float[7];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update(boolean z, int i, float f, float f2) {
        if (!z) {
            this.active = false;
        } else if (!this.active || this.id != i) {
            this.active = true;
            this.id = i;
            this.x = f;
            this.rawX = f;
            this.y = f2;
            this.rawY = f2;
            this.robustX = f;
            this.robustY = f2;
            clearVelocityHistory();
        } else {
            float f3 = f - this.rawX;
            float f4 = f2 - this.rawY;
            this.rawX = f;
            this.rawY = f2;
            float[] fArr = this.velocityX;
            int i2 = this.velocityAt;
            fArr[i2] = f3;
            this.velocityY[i2] = f4;
            this.velocityAt = (i2 + 1) % 7;
            float median = median(fArr);
            float median2 = median(this.velocityY);
            float f5 = this.robustX;
            this.robustX = f5 + toward(median, f - f5);
            float f6 = this.robustY + toward(median2, f2 - this.robustY);
            this.robustY = f6;
            float f7 = f - this.robustX;
            float f8 = f2 - f6;
            float sqrt = (float) Math.sqrt((f7 * f7) + (f8 * f8));
            if (sqrt > 1.0f && sqrt <= MAX_POSITION_CORRECTION_DISTANCE) {
                this.robustX += (f7 * 1.0f) / sqrt;
                this.robustY += (f8 * 1.0f) / sqrt;
            } else if (sqrt <= 1.0f) {
                this.robustX = f;
                this.robustY = f2;
            }
            if (Math.abs(f - this.robustX) <= SETTLE_EPSILON && Math.abs(f2 - this.robustY) <= SETTLE_EPSILON) {
                this.robustX = f;
                this.robustY = f2;
            }
            if (f3 == 0.0f && f4 == 0.0f && this.robustX == f && this.robustY == f2) {
                clearVelocityHistory();
            }
            float f9 = this.robustX - this.x;
            float f10 = this.robustY - this.y;
            float sqrt2 = (float) Math.sqrt((f9 * f9) + (f10 * f10));
            if (sqrt2 > RADIUS) {
                float f11 = (sqrt2 - RADIUS) / sqrt2;
                this.x += f9 * f11;
                this.y += f10 * f11;
            }
        }
    }

    private float median(float[] fArr) {
        System.arraycopy(fArr, 0, this.medianScratch, 0, 7);
        int i = 1;
        while (true) {
            float[] fArr2 = this.medianScratch;
            if (i < 7) {
                float f = fArr2[i];
                int i2 = i;
                while (i2 != 0) {
                    float[] fArr3 = this.medianScratch;
                    float f2 = fArr3[i2 - 1];
                    if (f2 > f) {
                        fArr3[i2] = f2;
                        i2--;
                    }
                }
                this.medianScratch[i2] = f;
                i++;
            } else {
                return fArr2[3];
            }
        }
    }

    private static float toward(float f, float f2) {
        if (f == 0.0f || f2 == 0.0f || Math.signum(f) != Math.signum(f2)) {
            return 0.0f;
        }
        return Math.copySign(Math.min(Math.abs(f), Math.abs(f2)), f);
    }

    private void clearVelocityHistory() {
        this.velocityAt = 0;
        for (int i = 0; i < 7; i++) {
            float[] fArr = this.velocityX;
            this.velocityY[i] = 0.0f;
            fArr[i] = 0.0f;
        }
    }
}
