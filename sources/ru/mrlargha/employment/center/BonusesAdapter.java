package ru.mrlargha.employment.center;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.employment.center.data.BonusItem;
import ru.mrlargha.feature.employment.center.R;
import ru.mrlargha.feature.employment.center.databinding.EmploymentCenterBonusItemBinding;
import ru.mrlargha.ui.kit.FlagsKt;
/* compiled from: BonusesAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\u0006\u0010\u0019\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lru/mrlargha/employment/center/BonusesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/employment/center/EmploymentBonusViewHolder;", "onSelect", "Lkotlin/Function1;", "Lru/mrlargha/employment/center/data/BonusItem;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "itemsList", "", "getItemsList", "()Ljava/util/List;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addAllItems", "items", "", "clearList", "employment-center_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BonusesAdapter extends RecyclerView.Adapter<EmploymentBonusViewHolder> {
    private final List<BonusItem> itemsList;
    private final Function1<BonusItem, Unit> onSelect;

    /* JADX WARN: Multi-variable type inference failed */
    public BonusesAdapter(Function1<? super BonusItem, Unit> onSelect) {
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        this.onSelect = onSelect;
        this.itemsList = new ArrayList();
    }

    public final List<BonusItem> getItemsList() {
        return this.itemsList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EmploymentBonusViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.employment_center_bonus_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new EmploymentBonusViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EmploymentBonusViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final BonusItem bonusItem = (BonusItem) CollectionsKt.getOrNull(this.itemsList, i);
        if (bonusItem == null) {
            bonusItem = (BonusItem) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        final EmploymentCenterBonusItemBinding binding = holder.getBinding();
        if (bonusItem.getDesc().length() == 0) {
            binding.buttonInfo.setVisibility(8);
        } else {
            binding.buttonInfo.setVisibility(0);
        }
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.BonusesAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BonusesAdapter.onBindViewHolder$lambda$0$0(BonusesAdapter.this, bonusItem, view);
            }
        });
        int imageType = bonusItem.getImageType();
        if (imageType == 0) {
            Picasso picasso = Picasso.get();
            String resourceUrl$default = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            RequestCreator load = picasso.load(resourceUrl$default + "projects/arizona-rp/assets/images/donate/" + bonusItem.getImage() + ".webp");
            Target picassoTarget = holder.getPicassoTarget();
            if (picassoTarget == null) {
                return;
            }
            load.into(picassoTarget);
        } else if (imageType == 1) {
            Picasso picasso2 = Picasso.get();
            String resourceUrl$default2 = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            RequestCreator load2 = picasso2.load(resourceUrl$default2 + "projects/arizona-rp/systems/employment_center/bonuses/" + bonusItem.getImage() + ".webp");
            Target picassoTarget2 = holder.getPicassoTarget();
            if (picassoTarget2 == null) {
                return;
            }
            load2.into(picassoTarget2);
        } else if (imageType == 2) {
            int familyFlag = FlagsKt.familyFlag(bonusItem.getImage());
            Bitmap decodeResource = BitmapFactory.decodeResource(binding.getRoot().getContext().getResources(), familyFlag);
            if (decodeResource != null && !decodeResource.isRecycled()) {
                binding.image.setImageBitmap(decodeResource);
                Intrinsics.checkNotNull(Palette.from(decodeResource).generate(new Palette.PaletteAsyncListener() { // from class: ru.mrlargha.employment.center.BonusesAdapter$$ExternalSyntheticLambda1
                    @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
                    public final void onGenerated(Palette palette) {
                        BonusesAdapter.onBindViewHolder$lambda$0$1(EmploymentCenterBonusItemBinding.this, palette);
                    }
                }));
            } else {
                Log.e("BitmapError", "Bitmap invalid or null for resId=" + familyFlag);
                CustomCardView cardBg = binding.cardBg;
                Intrinsics.checkNotNullExpressionValue(cardBg, "cardBg");
                CustomCardView.setBackground$default(cardBg, -7829368, 0, null, null, 12, null);
            }
        } else if (imageType == 3) {
            Picasso picasso3 = Picasso.get();
            String resourceUrl$default3 = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            RequestCreator load3 = picasso3.load(resourceUrl$default3 + "projects/arizona-rp/assets/images/inventory/vehicles/256/" + bonusItem.getImage() + ".webp");
            Target picassoTarget3 = holder.getPicassoTarget();
            if (picassoTarget3 == null) {
                return;
            }
            load3.into(picassoTarget3);
        }
        binding.text.setText(bonusItem.getName());
        String valueString = bonusItem.getValueString();
        if (valueString != null && valueString.length() != 0) {
            binding.label1.text.setText(bonusItem.getValueString());
        } else if (bonusItem.getValue() <= 0) {
            binding.label1.getRoot().setVisibility(8);
        } else if (bonusItem.getValueMax() > bonusItem.getValue()) {
            TextView textView = binding.label1.text;
            int value = bonusItem.getValue();
            textView.setText(value + "%-" + bonusItem.getValueMax() + "%");
        } else {
            binding.label1.text.setText(bonusItem.getValue() + "%");
        }
        if (bonusItem.isShow() == 1) {
            binding.label1.getRoot().setBackground(Color.parseColor("#8DFF8D"));
            binding.label1.text.setTextColor(Color.parseColor("#3A693A"));
            binding.getRoot().setAlpha(1.0f);
            return;
        }
        binding.label1.getRoot().setBackground(Color.parseColor("#494949"));
        binding.label1.text.setTextColor(Color.parseColor("#7E7F7E"));
        binding.getRoot().setAlpha(0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(BonusesAdapter bonusesAdapter, BonusItem bonusItem, View view) {
        bonusesAdapter.onSelect.invoke(bonusItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$1(EmploymentCenterBonusItemBinding employmentCenterBonusItemBinding, Palette palette) {
        int dominantColor = palette != null ? palette.getDominantColor(-16777216) : -16777216;
        CustomCardView cardBg = employmentCenterBonusItemBinding.cardBg;
        Intrinsics.checkNotNullExpressionValue(cardBg, "cardBg");
        CustomCardView.setBackground$default(cardBg, dominantColor, 0, null, null, 12, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<BonusItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new BonusesAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}
