package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.target_plate;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudTargetPlateBinding;
import ru.mrlargha.commonui.databinding.HudTargetPlatePageBinding;
import ru.mrlargha.commonui.databinding.HudTargetPlateTransportBinding;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.target_plate.HudTargetPlateTransportModel;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: HudTargetPlate.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/target_plate/HudTargetPlate;", "", "binding", "Lru/mrlargha/commonui/databinding/HudTargetPlatePageBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/HudTargetPlatePageBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudTargetPlatePageBinding;", "bindingAccess", "Lru/mrlargha/commonui/databinding/HudTargetPlateBinding;", "bindingTransport", "Lru/mrlargha/commonui/databinding/HudTargetPlateTransportBinding;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "type", "", "firstOpen", "", "tagList", "", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "Lkotlin/jvm/internal/EnhancedNullability;", "setType", "", "data", "", "initialize", "initDefault", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/target_plate/HudTargetPlateModel;", "(Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/target_plate/HudTargetPlateModel;)Lkotlin/Unit;", "initTags", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/target_plate/HudTargetPlateTransportModel;", "show", "hide", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudTargetPlate {
    private final HudTargetPlatePageBinding binding;
    private final HudTargetPlateBinding bindingAccess;
    private final HudTargetPlateTransportBinding bindingTransport;
    private final Context context;
    private boolean firstOpen;
    private final List<CustomCardView> tagList;
    private int type;

    public HudTargetPlate(HudTargetPlatePageBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        HudTargetPlateBinding accessory = binding.accessory;
        Intrinsics.checkNotNullExpressionValue(accessory, "accessory");
        this.bindingAccess = accessory;
        HudTargetPlateTransportBinding transport = binding.transport;
        Intrinsics.checkNotNullExpressionValue(transport, "transport");
        this.bindingTransport = transport;
        this.context = binding.getRoot().getContext();
        this.firstOpen = true;
        this.tagList = CollectionsKt.listOf((Object[]) new CustomCardView[]{transport.trashTag, transport.rareTag, transport.legendTag});
    }

    public final HudTargetPlatePageBinding getBinding() {
        return this.binding;
    }

    public final void setType(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Integer intOrNull = StringsKt.toIntOrNull(data);
        if (intOrNull != null) {
            this.type = intOrNull.intValue();
        }
    }

    public final void initialize(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            JsonObject asJsonObject = JsonParser.parseString(data).getAsJsonObject();
            if (asJsonObject.has(FirebaseAnalytics.Param.LEVEL) && asJsonObject.has("shield")) {
                if (MapperKt.isJsonValid(data)) {
                    show();
                    initDefault((HudTargetPlateModel) MapperKt.getGson().fromJson(data, (Class<Object>) HudTargetPlateModel.class));
                    return;
                }
                throw new JsonParseException("Json is not valid");
            } else if (MapperKt.isJsonValid(data)) {
                show();
                initTags((HudTargetPlateTransportModel) MapperKt.getGson().fromJson(data, (Class<Object>) HudTargetPlateTransportModel.class));
            } else {
                throw new JsonParseException("Json is not valid");
            }
        } catch (Exception e) {
            Log.d("TAG", "initialize error: " + e);
            hide();
        }
    }

    private final Unit initDefault(HudTargetPlateModel hudTargetPlateModel) {
        HudTargetPlateBinding hudTargetPlateBinding = this.bindingAccess;
        CustomCardView root = hudTargetPlateBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        CustomCardView root2 = this.bindingTransport.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(8);
        if (this.firstOpen) {
            hudTargetPlateBinding.getRoot().startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.show_slide_down));
            this.firstOpen = false;
        }
        hudTargetPlateBinding.tvUserName.setText(hudTargetPlateModel.getUserName());
        hudTargetPlateBinding.tvUserNumber.setText(String.valueOf(hudTargetPlateModel.getUserNumber()));
        hudTargetPlateBinding.tvLevel.setText(hudTargetPlateModel.getLevel());
        LinearLayout shieldContainer = hudTargetPlateBinding.shieldContainer;
        Intrinsics.checkNotNullExpressionValue(shieldContainer, "shieldContainer");
        shieldContainer.setVisibility(hudTargetPlateModel.getShield() > 0 ? 0 : 8);
        hudTargetPlateBinding.tvShield.setText(this.context.getString(R.string.i_percent, Integer.valueOf(hudTargetPlateModel.getShield())));
        LinearLayout luckContainer = hudTargetPlateBinding.luckContainer;
        Intrinsics.checkNotNullExpressionValue(luckContainer, "luckContainer");
        luckContainer.setVisibility(hudTargetPlateModel.getLuck() > 0 ? 0 : 8);
        hudTargetPlateBinding.tvLuck.setText(this.context.getString(R.string.i_percent, Integer.valueOf(hudTargetPlateModel.getLuck())));
        LinearLayout bulletContainer = hudTargetPlateBinding.bulletContainer;
        Intrinsics.checkNotNullExpressionValue(bulletContainer, "bulletContainer");
        bulletContainer.setVisibility(hudTargetPlateModel.getBullet() > 0 ? 0 : 8);
        hudTargetPlateBinding.tvBullet.setText(this.context.getString(R.string.plus_i, Integer.valueOf(hudTargetPlateModel.getBullet())));
        LinearLayout energyContainer = hudTargetPlateBinding.energyContainer;
        Intrinsics.checkNotNullExpressionValue(energyContainer, "energyContainer");
        energyContainer.setVisibility(hudTargetPlateModel.getEnergy() > 0 ? 0 : 8);
        hudTargetPlateBinding.tvEnergy.setText(this.context.getString(R.string.i_percent, Integer.valueOf(hudTargetPlateModel.getEnergy())));
        hudTargetPlateBinding.tvHealth.setText(String.valueOf(hudTargetPlateModel.getHealth()));
        hudTargetPlateBinding.tvArmor.setText(String.valueOf(hudTargetPlateModel.getArmor()));
        hudTargetPlateBinding.progressHealth.setPercentWidth(hudTargetPlateModel.getMaxHealth() > 0 ? RangesKt.coerceIn(hudTargetPlateModel.getHealth() / hudTargetPlateModel.getMaxHealth(), 0.0f, 1.0f) : 0.0f);
        hudTargetPlateModel.getArmor();
        CustomCardView armorContainer = hudTargetPlateBinding.armorContainer;
        Intrinsics.checkNotNullExpressionValue(armorContainer, "armorContainer");
        armorContainer.setVisibility(hudTargetPlateModel.getArmor() > 0 ? 0 : 8);
        hudTargetPlateBinding.progressArmor.setPercentWidth(hudTargetPlateModel.getMaxArmor() > 0 ? RangesKt.coerceIn(hudTargetPlateModel.getArmor() / hudTargetPlateModel.getMaxArmor(), 0.0f, 1.0f) : 0.0f);
        return Unit.INSTANCE;
    }

    private final void initTags(HudTargetPlateTransportModel hudTargetPlateTransportModel) {
        HudTargetPlateTransportModel.Tag tag;
        HudTargetPlateTransportModel.Detail detail;
        HudTargetPlateTransportBinding hudTargetPlateTransportBinding = this.bindingTransport;
        CustomCardView root = hudTargetPlateTransportBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        CustomCardView root2 = this.bindingAccess.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(8);
        if (this.firstOpen) {
            hudTargetPlateTransportBinding.getRoot().startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.show_slide_down));
            this.firstOpen = false;
        }
        hudTargetPlateTransportBinding.tvUserNumber.setText(String.valueOf(hudTargetPlateTransportModel.getUserNumber()));
        List<HudTargetPlateTransportModel.Detail> details = hudTargetPlateTransportModel.getDetails();
        if (details != null && (detail = (HudTargetPlateTransportModel.Detail) CollectionsKt.getOrNull(details, 0)) != null) {
            hudTargetPlateTransportBinding.tvTitleUserName.setText(detail.getTitle());
            hudTargetPlateTransportBinding.tvUserName.setText(detail.getValue());
            TextView tvTitleUserName = hudTargetPlateTransportBinding.tvTitleUserName;
            Intrinsics.checkNotNullExpressionValue(tvTitleUserName, "tvTitleUserName");
            tvTitleUserName.setVisibility(detail.getTitle().length() > 0 ? 0 : 8);
            TextView tvUserName = hudTargetPlateTransportBinding.tvUserName;
            Intrinsics.checkNotNullExpressionValue(tvUserName, "tvUserName");
            tvUserName.setVisibility(detail.getValue().length() > 0 ? 0 : 8);
        } else {
            TextView tvTitleUserName2 = hudTargetPlateTransportBinding.tvTitleUserName;
            Intrinsics.checkNotNullExpressionValue(tvTitleUserName2, "tvTitleUserName");
            tvTitleUserName2.setVisibility(8);
            TextView tvUserName2 = hudTargetPlateTransportBinding.tvUserName;
            Intrinsics.checkNotNullExpressionValue(tvUserName2, "tvUserName");
            tvUserName2.setVisibility(8);
        }
        hudTargetPlateTransportBinding.tvName.setText(hudTargetPlateTransportModel.getName());
        List listOf = CollectionsKt.listOf((Object[]) new TextView[]{hudTargetPlateTransportBinding.tvTrash, hudTargetPlateTransportBinding.tvRare, hudTargetPlateTransportBinding.tvLegend});
        HudTargetPlateTransportModel.Tag mainTag = hudTargetPlateTransportModel.getMainTag();
        if (mainTag != null) {
            List<String> colors = mainTag.getColors();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(colors, 10));
            for (String str : colors) {
                arrayList.add(Integer.valueOf(Color.parseColor(str)));
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2.size() >= 2) {
                CustomCardView limitedTag = hudTargetPlateTransportBinding.limitedTag;
                Intrinsics.checkNotNullExpressionValue(limitedTag, "limitedTag");
                CustomCardView.setBackground$default(limitedTag, CollectionsKt.toIntArray(arrayList2), null, null, 6, null);
            } else if (arrayList2.size() == 1) {
                hudTargetPlateTransportBinding.limitedTag.setBackground(((Number) arrayList2.get(0)).intValue());
            }
            hudTargetPlateTransportBinding.tvLimited.setText(mainTag.getValue());
            CustomCardView limitedTag2 = hudTargetPlateTransportBinding.limitedTag;
            Intrinsics.checkNotNullExpressionValue(limitedTag2, "limitedTag");
            limitedTag2.setVisibility(0);
        } else {
            CustomCardView limitedTag3 = hudTargetPlateTransportBinding.limitedTag;
            Intrinsics.checkNotNullExpressionValue(limitedTag3, "limitedTag");
            limitedTag3.setVisibility(8);
        }
        try {
            List<HudTargetPlateTransportModel.Tag> additionalTags = hudTargetPlateTransportModel.getAdditionalTags();
            if (additionalTags != null && (tag = (HudTargetPlateTransportModel.Tag) CollectionsKt.getOrNull(additionalTags, 0)) != null) {
                List<String> colors2 = tag.getColors();
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(colors2, 10));
                for (String str2 : colors2) {
                    arrayList3.add(Integer.valueOf(Color.parseColor(str2)));
                }
                ArrayList arrayList4 = arrayList3;
                if (arrayList4.size() >= 2) {
                    CustomCardView countContainer = hudTargetPlateTransportBinding.countContainer;
                    Intrinsics.checkNotNullExpressionValue(countContainer, "countContainer");
                    CustomCardView.setBackground$default(countContainer, CollectionsKt.toIntArray(arrayList4), null, null, 6, null);
                } else if (arrayList4.size() == 1) {
                    hudTargetPlateTransportBinding.countContainer.setBackground(((Number) arrayList4.get(0)).intValue());
                }
                hudTargetPlateTransportBinding.tvCount.setText(tag.getValue());
                CustomCardView countContainer2 = hudTargetPlateTransportBinding.countContainer;
                Intrinsics.checkNotNullExpressionValue(countContainer2, "countContainer");
                countContainer2.setVisibility(0);
            } else {
                CustomCardView countContainer3 = hudTargetPlateTransportBinding.countContainer;
                Intrinsics.checkNotNullExpressionValue(countContainer3, "countContainer");
                countContainer3.setVisibility(8);
            }
        } catch (Exception unused) {
            CustomCardView countContainer4 = hudTargetPlateTransportBinding.countContainer;
            Intrinsics.checkNotNullExpressionValue(countContainer4, "countContainer");
            countContainer4.setVisibility(8);
        }
        int i = 0;
        for (Object obj : this.tagList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CustomCardView customCardView = (CustomCardView) obj;
            List<HudTargetPlateTransportModel.Tag> tags = hudTargetPlateTransportModel.getTags();
            HudTargetPlateTransportModel.Tag tag2 = tags != null ? (HudTargetPlateTransportModel.Tag) CollectionsKt.getOrNull(tags, i) : null;
            if (tag2 != null) {
                List<String> colors3 = tag2.getColors();
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(colors3, 10));
                for (String str3 : colors3) {
                    arrayList5.add(Integer.valueOf(Color.parseColor(str3)));
                }
                ArrayList arrayList6 = arrayList5;
                if (arrayList6.size() >= 2) {
                    Intrinsics.checkNotNull(customCardView);
                    CustomCardView.setBackground$default(customCardView, CollectionsKt.toIntArray(arrayList6), null, null, 6, null);
                } else if (arrayList6.size() == 1) {
                    customCardView.setBackground(((Number) arrayList6.get(0)).intValue());
                }
                TextView textView = (TextView) CollectionsKt.getOrNull(listOf, i);
                if (textView != null) {
                    textView.setText(tag2.getValue());
                }
                Intrinsics.checkNotNull(customCardView);
                customCardView.setVisibility(0);
            } else {
                Intrinsics.checkNotNull(customCardView);
                customCardView.setVisibility(8);
            }
            i = i2;
        }
        hudTargetPlateTransportBinding.tvHealth.setText(String.valueOf(hudTargetPlateTransportModel.getHp()));
        hudTargetPlateTransportBinding.progressHealth.setPercentWidth(hudTargetPlateTransportModel.getMaxHp() > 0 ? RangesKt.coerceIn(hudTargetPlateTransportModel.getHp() / hudTargetPlateTransportModel.getMaxHp(), 0.0f, 1.0f) : 0.0f);
    }

    public final void show() {
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
    }

    public final void hide() {
        HudTargetPlatePageBinding hudTargetPlatePageBinding = this.binding;
        this.firstOpen = true;
        hudTargetPlatePageBinding.getRoot().startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.hide_slide_up));
        FrameLayout root = hudTargetPlatePageBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
    }
}
