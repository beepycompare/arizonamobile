package com.arizonagames.feature.arizona.certificate;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/arizonagames/feature/arizona/certificate/ObjectViewer;", "", "objectModel", "Lcom/arizonagames/feature/arizona/certificate/ObjectModel;", "objectProperties", "Lcom/arizonagames/feature/arizona/certificate/ObjectProperties;", "objectComponents", "", "Lcom/arizonagames/feature/arizona/certificate/ObjectComponent;", "<init>", "(Lcom/arizonagames/feature/arizona/certificate/ObjectModel;Lcom/arizonagames/feature/arizona/certificate/ObjectProperties;Ljava/util/List;)V", "getObjectModel", "()Lcom/arizonagames/feature/arizona/certificate/ObjectModel;", "getObjectProperties", "()Lcom/arizonagames/feature/arizona/certificate/ObjectProperties;", "getObjectComponents", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "certificate"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ObjectViewer {
    private final List<ObjectComponent> objectComponents;
    private final ObjectModel objectModel;
    private final ObjectProperties objectProperties;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObjectViewer copy$default(ObjectViewer objectViewer, ObjectModel objectModel, ObjectProperties objectProperties, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            objectModel = objectViewer.objectModel;
        }
        if ((i & 2) != 0) {
            objectProperties = objectViewer.objectProperties;
        }
        if ((i & 4) != 0) {
            list = objectViewer.objectComponents;
        }
        return objectViewer.copy(objectModel, objectProperties, list);
    }

    public final ObjectModel component1() {
        return this.objectModel;
    }

    public final ObjectProperties component2() {
        return this.objectProperties;
    }

    public final List<ObjectComponent> component3() {
        return this.objectComponents;
    }

    public final ObjectViewer copy(ObjectModel objectModel, ObjectProperties objectProperties, List<ObjectComponent> objectComponents) {
        Intrinsics.checkNotNullParameter(objectModel, "objectModel");
        Intrinsics.checkNotNullParameter(objectProperties, "objectProperties");
        Intrinsics.checkNotNullParameter(objectComponents, "objectComponents");
        return new ObjectViewer(objectModel, objectProperties, objectComponents);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ObjectViewer) {
            ObjectViewer objectViewer = (ObjectViewer) obj;
            return Intrinsics.areEqual(this.objectModel, objectViewer.objectModel) && Intrinsics.areEqual(this.objectProperties, objectViewer.objectProperties) && Intrinsics.areEqual(this.objectComponents, objectViewer.objectComponents);
        }
        return false;
    }

    public int hashCode() {
        return (((this.objectModel.hashCode() * 31) + this.objectProperties.hashCode()) * 31) + this.objectComponents.hashCode();
    }

    public String toString() {
        ObjectModel objectModel = this.objectModel;
        ObjectProperties objectProperties = this.objectProperties;
        return "ObjectViewer(objectModel=" + objectModel + ", objectProperties=" + objectProperties + ", objectComponents=" + this.objectComponents + ")";
    }

    public ObjectViewer(ObjectModel objectModel, ObjectProperties objectProperties, List<ObjectComponent> objectComponents) {
        Intrinsics.checkNotNullParameter(objectModel, "objectModel");
        Intrinsics.checkNotNullParameter(objectProperties, "objectProperties");
        Intrinsics.checkNotNullParameter(objectComponents, "objectComponents");
        this.objectModel = objectModel;
        this.objectProperties = objectProperties;
        this.objectComponents = objectComponents;
    }

    public final ObjectModel getObjectModel() {
        return this.objectModel;
    }

    public final ObjectProperties getObjectProperties() {
        return this.objectProperties;
    }

    public final List<ObjectComponent> getObjectComponents() {
        return this.objectComponents;
    }
}
