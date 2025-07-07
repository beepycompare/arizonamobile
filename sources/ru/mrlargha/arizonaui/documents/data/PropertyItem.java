package ru.mrlargha.arizonaui.documents.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DocumentsData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/documents/data/PropertyItem;", "", "column", "", "property_type", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColumn", "()Ljava/lang/String;", "getProperty_type", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PropertyItem {
    private final String column;
    private final String property_type;
    private final String text;

    public static /* synthetic */ PropertyItem copy$default(PropertyItem propertyItem, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = propertyItem.column;
        }
        if ((i & 2) != 0) {
            str2 = propertyItem.property_type;
        }
        if ((i & 4) != 0) {
            str3 = propertyItem.text;
        }
        return propertyItem.copy(str, str2, str3);
    }

    public final String component1() {
        return this.column;
    }

    public final String component2() {
        return this.property_type;
    }

    public final String component3() {
        return this.text;
    }

    public final PropertyItem copy(String column, String property_type, String text) {
        Intrinsics.checkNotNullParameter(column, "column");
        Intrinsics.checkNotNullParameter(property_type, "property_type");
        Intrinsics.checkNotNullParameter(text, "text");
        return new PropertyItem(column, property_type, text);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PropertyItem) {
            PropertyItem propertyItem = (PropertyItem) obj;
            return Intrinsics.areEqual(this.column, propertyItem.column) && Intrinsics.areEqual(this.property_type, propertyItem.property_type) && Intrinsics.areEqual(this.text, propertyItem.text);
        }
        return false;
    }

    public int hashCode() {
        return (((this.column.hashCode() * 31) + this.property_type.hashCode()) * 31) + this.text.hashCode();
    }

    public String toString() {
        String str = this.column;
        String str2 = this.property_type;
        return "PropertyItem(column=" + str + ", property_type=" + str2 + ", text=" + this.text + ")";
    }

    public PropertyItem(String column, String property_type, String text) {
        Intrinsics.checkNotNullParameter(column, "column");
        Intrinsics.checkNotNullParameter(property_type, "property_type");
        Intrinsics.checkNotNullParameter(text, "text");
        this.column = column;
        this.property_type = property_type;
        this.text = text;
    }

    public final String getColumn() {
        return this.column;
    }

    public final String getProperty_type() {
        return this.property_type;
    }

    public final String getText() {
        return this.text;
    }
}
