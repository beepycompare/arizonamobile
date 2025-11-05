package com.arizonagames.feature.arizona.certificate;

import kotlin.Metadata;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/arizonagames/feature/arizona/certificate/ObjectComponent;", "", "id", "", "simple_model", "", "<init>", "(IZ)V", "getId", "()I", "getSimple_model", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "certificate_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ObjectComponent {
    private final int id;
    private final boolean simple_model;

    public static /* synthetic */ ObjectComponent copy$default(ObjectComponent objectComponent, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = objectComponent.id;
        }
        if ((i2 & 2) != 0) {
            z = objectComponent.simple_model;
        }
        return objectComponent.copy(i, z);
    }

    public final int component1() {
        return this.id;
    }

    public final boolean component2() {
        return this.simple_model;
    }

    public final ObjectComponent copy(int i, boolean z) {
        return new ObjectComponent(i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ObjectComponent) {
            ObjectComponent objectComponent = (ObjectComponent) obj;
            return this.id == objectComponent.id && this.simple_model == objectComponent.simple_model;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.id) * 31) + Boolean.hashCode(this.simple_model);
    }

    public String toString() {
        int i = this.id;
        return "ObjectComponent(id=" + i + ", simple_model=" + this.simple_model + ")";
    }

    public ObjectComponent(int i, boolean z) {
        this.id = i;
        this.simple_model = z;
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getSimple_model() {
        return this.simple_model;
    }
}
