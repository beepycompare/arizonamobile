package ru.mrlargha.commonui.elements.donate.presentation.models;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBadgesModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
/* compiled from: DonateItemModelUi.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toUi", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateItemModelUiKt {
    public static final DonateItemModelUi toUi(DonateItemModel donateItemModel) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(donateItemModel, "<this>");
        int key = donateItemModel.getKey();
        String name = donateItemModel.getName();
        String str = name == null ? "" : name;
        String description = donateItemModel.getDescription();
        String str2 = description == null ? "" : description;
        int price = donateItemModel.getPrice();
        int priceCurrency = donateItemModel.getPriceCurrency();
        int typeTemplate = donateItemModel.getTypeTemplate();
        int iconButton = donateItemModel.getIconButton();
        boolean z = false;
        if (donateItemModel.isEnable() == 1) {
            z = true;
        }
        List<String> colorListButton = donateItemModel.getColorListButton();
        if (colorListButton == null) {
            colorListButton = CollectionsKt.emptyList();
        }
        String titleButton = donateItemModel.getTitleButton();
        if (titleButton == null) {
            titleButton = "";
        }
        int image = donateItemModel.getImage();
        String imageEffect = donateItemModel.getImageEffect();
        if (imageEffect == null) {
            imageEffect = "";
        }
        int backgroundId = donateItemModel.getBackgroundId();
        List<String> list = colorListButton;
        String str3 = titleButton;
        String str4 = imageEffect;
        int discount = donateItemModel.getDiscount();
        int discountPrice = donateItemModel.getDiscountPrice();
        int blockedType = donateItemModel.getBlockedType();
        String blockedReason = donateItemModel.getBlockedReason();
        String str5 = blockedReason != null ? blockedReason : "";
        int leftUnixTime = donateItemModel.getLeftUnixTime();
        List<DonateBadgesModel> badges = donateItemModel.getBadges();
        if (badges != null) {
            List<DonateBadgesModel> list2 = badges;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (DonateBadgesModel donateBadgesModel : list2) {
                arrayList2.add(DonateBadgesModelUiKt.toUi(donateBadgesModel));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        boolean z2 = donateItemModel.getVisible() == 1;
        boolean z3 = donateItemModel.getAnimation() == 1;
        List<String> textGradientColor = donateItemModel.getTextGradientColor();
        if (textGradientColor == null) {
            textGradientColor = CollectionsKt.emptyList();
        }
        return new DonateItemModelUi(key, donateItemModel.getCategory(), str, str2, price, priceCurrency, typeTemplate, iconButton, z, list, str3, image, str4, backgroundId, discount, discountPrice, blockedType, str5, leftUnixTime, arrayList, z2, z3, textGradientColor, donateItemModel.getTotalEarnings(), donateItemModel.getGifId() != -1, donateItemModel.getLimited() > 0);
    }
}
