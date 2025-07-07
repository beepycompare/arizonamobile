package com.skydoves.cloudy.internals.render;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RenderScriptToolkit.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0086\u0002J)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0003H\u0086\u0002J \u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/skydoves/cloudy/internals/render/Rgba3dArray;", "", "values", "", "sizeX", "", "sizeY", "sizeZ", "<init>", "([BIII)V", "getValues", "()[B", "getSizeX", "()I", "getSizeY", "getSizeZ", "get", "x", "y", "z", "set", "", "value", "indexOfVector", "cloudy_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Rgba3dArray {
    public static final int $stable = 8;
    private final int sizeX;
    private final int sizeY;
    private final int sizeZ;
    private final byte[] values;

    public Rgba3dArray(byte[] values, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(values, "values");
        this.values = values;
        this.sizeX = i;
        this.sizeY = i2;
        this.sizeZ = i3;
        if (values.length < i * i2 * i3 * 4) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final int getSizeX() {
        return this.sizeX;
    }

    public final int getSizeY() {
        return this.sizeY;
    }

    public final int getSizeZ() {
        return this.sizeZ;
    }

    public final byte[] getValues() {
        return this.values;
    }

    public final byte[] get(int i, int i2, int i3) {
        int indexOfVector = indexOfVector(i, i2, i3);
        byte[] bArr = new byte[4];
        for (int i4 = 0; i4 < 4; i4++) {
            bArr[i4] = this.values[indexOfVector + i4];
        }
        return bArr;
    }

    public final void set(int i, int i2, int i3, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.length != 4) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int indexOfVector = indexOfVector(i, i2, i3);
        for (int i4 = 0; i4 < 4; i4++) {
            this.values[indexOfVector + i4] = value[i4];
        }
    }

    private final int indexOfVector(int i, int i2, int i3) {
        int i4;
        int i5;
        if (i < 0 || i >= (i4 = this.sizeX)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i2 < 0 || i2 >= (i5 = this.sizeY)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i3 < 0 || i3 >= this.sizeZ) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return ((((i3 * i5) + i2) * i4) + i) * 4;
    }
}
