package com.arizonagames.feature.arizona.certificate;

import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0014\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/arizonagames/feature/arizona/certificate/ObjectModel;", "", TtmlNode.ATTR_ID, "", "simple_model", "", "type", "", Key.ROTATION, "Lcom/arizonagames/feature/arizona/certificate/Rotation;", "rotationAxis", "zoom", "", "<init>", "(IZLjava/lang/String;Lcom/arizonagames/feature/arizona/certificate/Rotation;Ljava/lang/String;F)V", "getId", "()I", "getSimple_model", "()Z", "getType", "()Ljava/lang/String;", "getRotation", "()Lcom/arizonagames/feature/arizona/certificate/Rotation;", "getRotationAxis", "getZoom", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "certificate"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ObjectModel {
    private final int id;
    private final Rotation rotation;
    private final String rotationAxis;
    private final boolean simple_model;
    private final String type;
    private final float zoom;

    public static /* synthetic */ ObjectModel copy$default(ObjectModel objectModel, int i, boolean z, String str, Rotation rotation, String str2, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = objectModel.id;
        }
        if ((i2 & 2) != 0) {
            z = objectModel.simple_model;
        }
        if ((i2 & 4) != 0) {
            str = objectModel.type;
        }
        if ((i2 & 8) != 0) {
            rotation = objectModel.rotation;
        }
        if ((i2 & 16) != 0) {
            str2 = objectModel.rotationAxis;
        }
        if ((i2 & 32) != 0) {
            f = objectModel.zoom;
        }
        String str3 = str2;
        float f2 = f;
        return objectModel.copy(i, z, str, rotation, str3, f2);
    }

    public final int component1() {
        return this.id;
    }

    public final boolean component2() {
        return this.simple_model;
    }

    public final String component3() {
        return this.type;
    }

    public final Rotation component4() {
        return this.rotation;
    }

    public final String component5() {
        return this.rotationAxis;
    }

    public final float component6() {
        return this.zoom;
    }

    public final ObjectModel copy(int i, boolean z, String type, Rotation rotation, String rotationAxis, float f) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        Intrinsics.checkNotNullParameter(rotationAxis, "rotationAxis");
        return new ObjectModel(i, z, type, rotation, rotationAxis, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ObjectModel) {
            ObjectModel objectModel = (ObjectModel) obj;
            return this.id == objectModel.id && this.simple_model == objectModel.simple_model && Intrinsics.areEqual(this.type, objectModel.type) && Intrinsics.areEqual(this.rotation, objectModel.rotation) && Intrinsics.areEqual(this.rotationAxis, objectModel.rotationAxis) && Float.compare(this.zoom, objectModel.zoom) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + Boolean.hashCode(this.simple_model)) * 31) + this.type.hashCode()) * 31) + this.rotation.hashCode()) * 31) + this.rotationAxis.hashCode()) * 31) + Float.hashCode(this.zoom);
    }

    public String toString() {
        int i = this.id;
        boolean z = this.simple_model;
        String str = this.type;
        Rotation rotation = this.rotation;
        String str2 = this.rotationAxis;
        return "ObjectModel(id=" + i + ", simple_model=" + z + ", type=" + str + ", rotation=" + rotation + ", rotationAxis=" + str2 + ", zoom=" + this.zoom + ")";
    }

    public ObjectModel(int i, boolean z, String type, Rotation rotation, String rotationAxis, float f) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        Intrinsics.checkNotNullParameter(rotationAxis, "rotationAxis");
        this.id = i;
        this.simple_model = z;
        this.type = type;
        this.rotation = rotation;
        this.rotationAxis = rotationAxis;
        this.zoom = f;
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getSimple_model() {
        return this.simple_model;
    }

    public final String getType() {
        return this.type;
    }

    public final Rotation getRotation() {
        return this.rotation;
    }

    public final String getRotationAxis() {
        return this.rotationAxis;
    }

    public final float getZoom() {
        return this.zoom;
    }
}
