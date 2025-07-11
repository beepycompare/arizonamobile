package ru.mrlargha.commonui.elements.donate.presentation.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateCategoryModel;
/* compiled from: DonateCategoryModelUi.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toUi", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateCategoryModelUi;", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateCategoryModel;", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateCategoryModelUiKt {
    public static final DonateCategoryModelUi toUi(DonateCategoryModel donateCategoryModel) {
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        Intrinsics.checkNotNullParameter(donateCategoryModel, "<this>");
        int key = donateCategoryModel.getKey();
        String name = donateCategoryModel.getName();
        List<String> borderColor = donateCategoryModel.getBorderColor();
        String hoverColor = donateCategoryModel.getHoverColor();
        int image = donateCategoryModel.getImage();
        int backgroundImage = donateCategoryModel.getBackgroundImage();
        boolean z4 = false;
        boolean z5 = true;
        if (donateCategoryModel.isNew() == 1) {
            z = false;
            z4 = true;
        } else {
            z = false;
        }
        if (donateCategoryModel.getVisible() == 1) {
            z2 = 1;
        } else {
            z2 = 1;
            z5 = z;
        }
        int gridTemplateType = donateCategoryModel.getGridTemplateType();
        if (donateCategoryModel.isActionCategory() == z2) {
            z3 = z2;
            i = gridTemplateType;
        } else {
            i = gridTemplateType;
            z3 = z;
        }
        return new DonateCategoryModelUi(key, name, borderColor, hoverColor, image, backgroundImage, z4, z5, i, z3);
    }
}
