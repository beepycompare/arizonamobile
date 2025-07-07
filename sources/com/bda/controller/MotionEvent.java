package com.bda.controller;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
/* loaded from: classes3.dex */
public final class MotionEvent extends BaseEvent implements Parcelable {
    public static final int AXIS_LTRIGGER = 17;
    public static final int AXIS_RTRIGGER = 18;
    public static final int AXIS_RZ = 14;
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 11;
    public static final Parcelable.Creator<MotionEvent> CREATOR = new ParcelableCreator();
    final SparseArray<Float> mAxis;
    final SparseArray<Float> mPrecision;

    /* loaded from: classes3.dex */
    static class ParcelableCreator implements Parcelable.Creator<MotionEvent> {
        ParcelableCreator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MotionEvent createFromParcel(Parcel parcel) {
            return new MotionEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MotionEvent[] newArray(int i) {
            return new MotionEvent[i];
        }
    }

    public MotionEvent(long j, int i, float f, float f2, float f3, float f4, float f5, float f6) {
        super(j, i);
        SparseArray<Float> sparseArray = new SparseArray<>(4);
        this.mAxis = sparseArray;
        sparseArray.put(0, Float.valueOf(f));
        sparseArray.put(1, Float.valueOf(f2));
        sparseArray.put(11, Float.valueOf(f3));
        sparseArray.put(14, Float.valueOf(f4));
        SparseArray<Float> sparseArray2 = new SparseArray<>(2);
        this.mPrecision = sparseArray2;
        sparseArray2.put(0, Float.valueOf(f5));
        sparseArray2.put(1, Float.valueOf(f6));
    }

    public MotionEvent(long j, int i, int[] iArr, float[] fArr, int[] iArr2, float[] fArr2) {
        super(j, i);
        int length = iArr.length;
        this.mAxis = new SparseArray<>(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.mAxis.put(iArr[i2], Float.valueOf(fArr[i2]));
        }
        int length2 = iArr2.length;
        this.mPrecision = new SparseArray<>(length2);
        for (int i3 = 0; i3 < length2; i3++) {
            this.mPrecision.put(iArr2[i3], Float.valueOf(fArr2[i3]));
        }
    }

    MotionEvent(Parcel parcel) {
        super(parcel);
        int readInt = parcel.readInt();
        this.mAxis = new SparseArray<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.mAxis.put(parcel.readInt(), Float.valueOf(parcel.readFloat()));
        }
        this.mPrecision = new SparseArray<>(parcel.readInt());
        for (int i2 = 0; i2 < readInt; i2++) {
            this.mPrecision.put(parcel.readInt(), Float.valueOf(parcel.readFloat()));
        }
    }

    @Override // com.bda.controller.BaseEvent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int findPointerIndex(int i) {
        return -1;
    }

    public final float getAxisValue(int i) {
        return getAxisValue(i, 0);
    }

    public final float getAxisValue(int i, int i2) {
        if (i2 == 0) {
            return this.mAxis.get(i, Float.valueOf(0.0f)).floatValue();
        }
        return 0.0f;
    }

    public final int getPointerCount() {
        return 1;
    }

    public final int getPointerId(int i) {
        return 0;
    }

    public final float getRawX() {
        return getX();
    }

    public final float getRawY() {
        return getY();
    }

    public final float getX() {
        return getAxisValue(0, 0);
    }

    public final float getX(int i) {
        return getAxisValue(0, i);
    }

    public final float getXPrecision() {
        return this.mPrecision.get(0, Float.valueOf(0.0f)).floatValue();
    }

    public final float getY() {
        return getAxisValue(1, 0);
    }

    public final float getY(int i) {
        return getAxisValue(1, i);
    }

    public final float getYPrecision() {
        return this.mPrecision.get(1, Float.valueOf(0.0f)).floatValue();
    }

    @Override // com.bda.controller.BaseEvent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.mAxis.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(this.mAxis.keyAt(i2));
            parcel.writeFloat(this.mAxis.valueAt(i2).floatValue());
        }
        int size2 = this.mPrecision.size();
        parcel.writeInt(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            parcel.writeInt(this.mPrecision.keyAt(i3));
            parcel.writeFloat(this.mPrecision.valueAt(i3).floatValue());
        }
    }
}
