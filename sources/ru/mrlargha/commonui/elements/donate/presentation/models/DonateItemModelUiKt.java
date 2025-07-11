package ru.mrlargha.commonui.elements.donate.presentation.models;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBadgesModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
/* compiled from: DonateItemModelUi.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toUi", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateItemModelUiKt {
    public static final DonateItemModelUi toUi(DonateItemModel donateItemModel) {
        boolean z;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(donateItemModel, "<this>");
        int key = donateItemModel.getKey();
        String name = donateItemModel.getName();
        String description = donateItemModel.getDescription();
        int price = donateItemModel.getPrice();
        int priceCurrency = donateItemModel.getPriceCurrency();
        int typeTemplate = donateItemModel.getTypeTemplate();
        int iconButton = donateItemModel.getIconButton();
        boolean z2 = donateItemModel.isEnable() == 1;
        List<String> colorListButton = donateItemModel.getColorListButton();
        String titleButton = donateItemModel.getTitleButton();
        int image = donateItemModel.getImage();
        String imageEffect = donateItemModel.getImageEffect();
        int backgroundId = donateItemModel.getBackgroundId();
        int discount = donateItemModel.getDiscount();
        int discountPrice = donateItemModel.getDiscountPrice();
        int blockedType = donateItemModel.getBlockedType();
        String blockedReason = donateItemModel.getBlockedReason();
        int leftUnixTime = donateItemModel.getLeftUnixTime();
        List<DonateBadgesModel> badges = donateItemModel.getBadges();
        if (badges != null) {
            List<DonateBadgesModel> list = badges;
            z = z2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (DonateBadgesModel donateBadgesModel : list) {
                arrayList2.add(DonateBadgesModelUiKt.toUi(donateBadgesModel));
            }
            arrayList = arrayList2;
        } else {
            z = z2;
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        return new DonateItemModelUi(key, donateItemModel.getCategory(), name, description, price, priceCurrency, typeTemplate, iconButton, z, colorListButton, titleButton, image, imageEffect, backgroundId, discount, discountPrice, blockedType, blockedReason, leftUnixTime, arrayList, donateItemModel.getVisible() == 1, donateItemModel.getAnimation() == 1, donateItemModel.getTextGradientColor(), donateItemModel.getTotalEarnings(), donateItemModel.getGifId() != -1);
    }
}
