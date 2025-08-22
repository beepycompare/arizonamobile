package ru.mrlargha.commonui.elements.donate.presentation.models;

import io.appmetrica.analytics.impl.L2;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateCategoryModelUi.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\u007f\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\fHÆ\u0001J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001cR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001c¨\u00060"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateCategoryModelUi;", "", "id", "", "title", "", "borderColor", "", "hoverColor", "image", L2.g, "isNew", "", "visible", "gridTemplateType", "isActionCategory", "isLimitCategory", "<init>", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;IIZZIZZ)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getBorderColor", "()Ljava/util/List;", "getHoverColor", "getImage", "getBackground", "()Z", "getVisible", "getGridTemplateType", "Lru/mrlargha/commonui/elements/donate/presentation/models/GridTemplateType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateCategoryModelUi {
    private final int background;
    private final List<String> borderColor;
    private final int gridTemplateType;
    private final String hoverColor;
    private final int id;
    private final int image;
    private final boolean isActionCategory;
    private final boolean isLimitCategory;
    private final boolean isNew;
    private final String title;
    private final boolean visible;

    public static /* synthetic */ DonateCategoryModelUi copy$default(DonateCategoryModelUi donateCategoryModelUi, int i, String str, List list, String str2, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = donateCategoryModelUi.id;
        }
        if ((i5 & 2) != 0) {
            str = donateCategoryModelUi.title;
        }
        List<String> list2 = list;
        if ((i5 & 4) != 0) {
            list2 = donateCategoryModelUi.borderColor;
        }
        if ((i5 & 8) != 0) {
            str2 = donateCategoryModelUi.hoverColor;
        }
        if ((i5 & 16) != 0) {
            i2 = donateCategoryModelUi.image;
        }
        if ((i5 & 32) != 0) {
            i3 = donateCategoryModelUi.background;
        }
        if ((i5 & 64) != 0) {
            z = donateCategoryModelUi.isNew;
        }
        if ((i5 & 128) != 0) {
            z2 = donateCategoryModelUi.visible;
        }
        if ((i5 & 256) != 0) {
            i4 = donateCategoryModelUi.gridTemplateType;
        }
        if ((i5 & 512) != 0) {
            z3 = donateCategoryModelUi.isActionCategory;
        }
        if ((i5 & 1024) != 0) {
            z4 = donateCategoryModelUi.isLimitCategory;
        }
        boolean z5 = z3;
        boolean z6 = z4;
        boolean z7 = z2;
        int i6 = i4;
        int i7 = i3;
        boolean z8 = z;
        int i8 = i2;
        List list3 = list2;
        return donateCategoryModelUi.copy(i, str, list3, str2, i8, i7, z8, z7, i6, z5, z6);
    }

    public final int component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.isActionCategory;
    }

    public final boolean component11() {
        return this.isLimitCategory;
    }

    public final String component2() {
        return this.title;
    }

    public final List<String> component3() {
        return this.borderColor;
    }

    public final String component4() {
        return this.hoverColor;
    }

    public final int component5() {
        return this.image;
    }

    public final int component6() {
        return this.background;
    }

    public final boolean component7() {
        return this.isNew;
    }

    public final boolean component8() {
        return this.visible;
    }

    public final int component9() {
        return this.gridTemplateType;
    }

    public final DonateCategoryModelUi copy(int i, String title, List<String> list, String hoverColor, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(hoverColor, "hoverColor");
        return new DonateCategoryModelUi(i, title, list, hoverColor, i2, i3, z, z2, i4, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateCategoryModelUi) {
            DonateCategoryModelUi donateCategoryModelUi = (DonateCategoryModelUi) obj;
            return this.id == donateCategoryModelUi.id && Intrinsics.areEqual(this.title, donateCategoryModelUi.title) && Intrinsics.areEqual(this.borderColor, donateCategoryModelUi.borderColor) && Intrinsics.areEqual(this.hoverColor, donateCategoryModelUi.hoverColor) && this.image == donateCategoryModelUi.image && this.background == donateCategoryModelUi.background && this.isNew == donateCategoryModelUi.isNew && this.visible == donateCategoryModelUi.visible && this.gridTemplateType == donateCategoryModelUi.gridTemplateType && this.isActionCategory == donateCategoryModelUi.isActionCategory && this.isLimitCategory == donateCategoryModelUi.isLimitCategory;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31;
        List<String> list = this.borderColor;
        return ((((((((((((((((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.hoverColor.hashCode()) * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.background)) * 31) + Boolean.hashCode(this.isNew)) * 31) + Boolean.hashCode(this.visible)) * 31) + Integer.hashCode(this.gridTemplateType)) * 31) + Boolean.hashCode(this.isActionCategory)) * 31) + Boolean.hashCode(this.isLimitCategory);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        List<String> list = this.borderColor;
        String str2 = this.hoverColor;
        int i2 = this.image;
        int i3 = this.background;
        boolean z = this.isNew;
        boolean z2 = this.visible;
        int i4 = this.gridTemplateType;
        boolean z3 = this.isActionCategory;
        return "DonateCategoryModelUi(id=" + i + ", title=" + str + ", borderColor=" + list + ", hoverColor=" + str2 + ", image=" + i2 + ", background=" + i3 + ", isNew=" + z + ", visible=" + z2 + ", gridTemplateType=" + i4 + ", isActionCategory=" + z3 + ", isLimitCategory=" + this.isLimitCategory + ")";
    }

    public DonateCategoryModelUi(int i, String title, List<String> list, String hoverColor, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(hoverColor, "hoverColor");
        this.id = i;
        this.title = title;
        this.borderColor = list;
        this.hoverColor = hoverColor;
        this.image = i2;
        this.background = i3;
        this.isNew = z;
        this.visible = z2;
        this.gridTemplateType = i4;
        this.isActionCategory = z3;
        this.isLimitCategory = z4;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<String> getBorderColor() {
        return this.borderColor;
    }

    public final String getHoverColor() {
        return this.hoverColor;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getBackground() {
        return this.background;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final int getGridTemplateType() {
        return this.gridTemplateType;
    }

    public final boolean isActionCategory() {
        return this.isActionCategory;
    }

    public final boolean isLimitCategory() {
        return this.isLimitCategory;
    }

    /* renamed from: getGridTemplateType  reason: collision with other method in class */
    public final GridTemplateType m11195getGridTemplateType() {
        Object obj;
        if (this.id == 0) {
            return GridTemplateType.MAIN;
        }
        Iterator<E> it = GridTemplateType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((GridTemplateType) obj).getType() == this.gridTemplateType) {
                break;
            }
        }
        GridTemplateType gridTemplateType = (GridTemplateType) obj;
        return gridTemplateType == null ? GridTemplateType.GRID : gridTemplateType;
    }
}
