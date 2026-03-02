package androidx.core.view;

import android.view.MotionEvent;
/* loaded from: classes2.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addMovement(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i;
        int i2 = this.mDataPointsBufferSize;
        if (i2 != 20) {
            this.mDataPointsBufferSize = i2 + 1;
        }
        this.mMovements[i] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    void computeCurrentVelocity(int i) {
        computeCurrentVelocity(i, Float.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void computeCurrentVelocity(int i, float f) {
        float currentVelocity = getCurrentVelocity() * i;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f))) {
            this.mLastComputedVelocity = -Math.abs(f);
        } else if (this.mLastComputedVelocity > Math.abs(f)) {
            this.mLastComputedVelocity = Math.abs(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getAxisVelocity(int i) {
        if (i != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j;
        int i;
        int i2 = this.mDataPointsBufferSize;
        if (i2 < 2) {
            return 0.0f;
        }
        int i3 = this.mDataPointsBufferLastUsedIndex;
        int i4 = ((i3 + 20) - (i2 - 1)) % 20;
        long j2 = this.mEventTimes[i3];
        while (true) {
            jArr = this.mEventTimes;
            j = jArr[i4];
            int i5 = ((j2 - j) > RANGE_MS ? 1 : ((j2 - j) == RANGE_MS ? 0 : -1));
            i = this.mDataPointsBufferSize;
            if (i5 <= 0) {
                break;
            }
            this.mDataPointsBufferSize = i - 1;
            i4 = (i4 + 1) % 20;
        }
        if (i < 2) {
            return 0.0f;
        }
        if (i == 2) {
            int i6 = (i4 + 1) % 20;
            long j3 = jArr[i6];
            if (j == j3) {
                return 0.0f;
            }
            return this.mMovements[i6] / ((float) (j3 - j));
        }
        float f = 0.0f;
        int i7 = 0;
        for (int i8 = 0; i8 < this.mDataPointsBufferSize - 1; i8++) {
            int i9 = i8 + i4;
            long[] jArr2 = this.mEventTimes;
            long j4 = jArr2[i9 % 20];
            int i10 = (i9 + 1) % 20;
            if (jArr2[i10] != j4) {
                i7++;
                float kineticEnergyToVelocity = kineticEnergyToVelocity(f);
                float f2 = this.mMovements[i10] / ((float) (this.mEventTimes[i10] - j4));
                f += (f2 - kineticEnergyToVelocity) * Math.abs(f2);
                if (i7 == 1) {
                    f *= 0.5f;
                }
            }
        }
        return kineticEnergyToVelocity(f);
    }

    private static float kineticEnergyToVelocity(float f) {
        return (f < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f) * 2.0f));
    }
}
