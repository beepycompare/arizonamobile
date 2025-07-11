package ru.mrlargha.arizonaui.documents.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DocumentsData.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/documents/data/PropertyInfo;", "", "type", "", "not", "properties", "", "Lru/mrlargha/arizonaui/documents/data/PropertyItem;", "<init>", "(IILjava/util/List;)V", "getType", "()I", "getNot", "getProperties", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PropertyInfo {
    private final int not;
    private final List<PropertyItem> properties;
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PropertyInfo copy$default(PropertyInfo propertyInfo, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = propertyInfo.type;
        }
        if ((i3 & 2) != 0) {
            i2 = propertyInfo.not;
        }
        if ((i3 & 4) != 0) {
            list = propertyInfo.properties;
        }
        return propertyInfo.copy(i, i2, list);
    }

    public final int component1() {
        return this.type;
    }

    public final int component2() {
        return this.not;
    }

    public final List<PropertyItem> component3() {
        return this.properties;
    }

    public final PropertyInfo copy(int i, int i2, List<PropertyItem> properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        return new PropertyInfo(i, i2, properties);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PropertyInfo) {
            PropertyInfo propertyInfo = (PropertyInfo) obj;
            return this.type == propertyInfo.type && this.not == propertyInfo.not && Intrinsics.areEqual(this.properties, propertyInfo.properties);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.not)) * 31) + this.properties.hashCode();
    }

    public String toString() {
        int i = this.type;
        int i2 = this.not;
        return "PropertyInfo(type=" + i + ", not=" + i2 + ", properties=" + this.properties + ")";
    }

    public PropertyInfo(int i, int i2, List<PropertyItem> properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.type = i;
        this.not = i2;
        this.properties = properties;
    }

    public final int getType() {
        return this.type;
    }

    public final int getNot() {
        return this.not;
    }

    public final List<PropertyItem> getProperties() {
        return this.properties;
    }
}
