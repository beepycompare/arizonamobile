package ru.mrlargha.arizona.rating;

import androidx.constraintlayout.motion.widget.Key;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003JG\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006%"}, d2 = {"Lru/mrlargha/arizona/rating/ObjectModel;", "", "id", "", "simple_model", "", "type", "", Key.ROTATION, "Lru/mrlargha/arizona/rating/Rotation;", "zoom", "", "rotationAxis", "<init>", "(IZLjava/lang/String;Lru/mrlargha/arizona/rating/Rotation;FLjava/lang/String;)V", "getId", "()I", "getSimple_model", "()Z", "getType", "()Ljava/lang/String;", "getRotation", "()Lru/mrlargha/arizona/rating/Rotation;", "getZoom", "()F", "getRotationAxis", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "item-rating"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ObjectModel {
    private final int id;
    private final Rotation rotation;
    private final String rotationAxis;
    private final boolean simple_model;
    private final String type;
    private final float zoom;

    public static /* synthetic */ ObjectModel copy$default(ObjectModel objectModel, int i, boolean z, String str, Rotation rotation, float f, String str2, int i2, Object obj) {
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
            f = objectModel.zoom;
        }
        if ((i2 & 32) != 0) {
            str2 = objectModel.rotationAxis;
        }
        float f2 = f;
        String str3 = str2;
        return objectModel.copy(i, z, str, rotation, f2, str3);
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

    public final float component5() {
        return this.zoom;
    }

    public final String component6() {
        return this.rotationAxis;
    }

    public final ObjectModel copy(int i, boolean z, String type, Rotation rotation, float f, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        return new ObjectModel(i, z, type, rotation, f, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ObjectModel) {
            ObjectModel objectModel = (ObjectModel) obj;
            return this.id == objectModel.id && this.simple_model == objectModel.simple_model && Intrinsics.areEqual(this.type, objectModel.type) && Intrinsics.areEqual(this.rotation, objectModel.rotation) && Float.compare(this.zoom, objectModel.zoom) == 0 && Intrinsics.areEqual(this.rotationAxis, objectModel.rotationAxis);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((Integer.hashCode(this.id) * 31) + Boolean.hashCode(this.simple_model)) * 31) + this.type.hashCode()) * 31) + this.rotation.hashCode()) * 31) + Float.hashCode(this.zoom)) * 31;
        String str = this.rotationAxis;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        int i = this.id;
        boolean z = this.simple_model;
        String str = this.type;
        Rotation rotation = this.rotation;
        float f = this.zoom;
        return "ObjectModel(id=" + i + ", simple_model=" + z + ", type=" + str + ", rotation=" + rotation + ", zoom=" + f + ", rotationAxis=" + this.rotationAxis + ")";
    }

    public ObjectModel(int i, boolean z, String type, Rotation rotation, float f, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        this.id = i;
        this.simple_model = z;
        this.type = type;
        this.rotation = rotation;
        this.zoom = f;
        this.rotationAxis = str;
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

    public final float getZoom() {
        return this.zoom;
    }

    public final String getRotationAxis() {
        return this.rotationAxis;
    }
}
