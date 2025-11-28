package ru.mrlargha.arizona.rating;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.arizona.item.rating.R;
import ru.mrlargha.feature.arizona.item.rating.databinding.RatingItemBinding;
import ru.mrlargha.ui.kit.FlagsKt;
/* compiled from: ItemsAdapter.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\bH\u0016J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\bH\u0016J\u0014\u0010(\u001a\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u0014\u0010+\u001a\u00020\u00062\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0014\u0010-\u001a\u00020\u00062\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014J\u0006\u0010.\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lru/mrlargha/arizona/rating/ItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizona/rating/MembersViewHolder;", "onClick", "Lkotlin/Function1;", "Lru/mrlargha/arizona/rating/RatingItem;", "", "onScrollFinish", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "value", "", "isCars", "()Z", "itemsList", "", "getItemsList", "()Ljava/util/List;", "bonusType", "", "Lru/mrlargha/arizona/rating/BonusType;", "getBonusType", "setBonusType", "(Ljava/util/List;)V", "apiData", "getApiData", "setApiData", "qualityTypeList", "Lru/mrlargha/arizona/rating/QualityType;", "isRequestSend", "page", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addAllItems", "items", "setType", "addBonus", "data", "addQuality", "clearList", "item-rating_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ItemsAdapter extends RecyclerView.Adapter<MembersViewHolder> {
    private List<RatingItem> apiData;
    private List<BonusType> bonusType;
    private boolean isCars;
    private boolean isRequestSend;
    private final List<RatingItem> itemsList;
    private final Function1<RatingItem, Unit> onClick;
    private final Function1<Integer, Unit> onScrollFinish;
    private int page;
    private List<QualityType> qualityTypeList;

    /* JADX WARN: Multi-variable type inference failed */
    public ItemsAdapter(Function1<? super RatingItem, Unit> onClick, Function1<? super Integer, Unit> onScrollFinish) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onScrollFinish, "onScrollFinish");
        this.onClick = onClick;
        this.onScrollFinish = onScrollFinish;
        this.itemsList = new ArrayList();
        this.bonusType = CollectionsKt.emptyList();
        this.apiData = CollectionsKt.emptyList();
        this.qualityTypeList = CollectionsKt.emptyList();
        this.page = 1;
    }

    public final boolean isCars() {
        return this.isCars;
    }

    public final List<RatingItem> getItemsList() {
        return this.itemsList;
    }

    public final List<BonusType> getBonusType() {
        return this.bonusType;
    }

    public final void setBonusType(List<BonusType> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.bonusType = list;
    }

    public final List<RatingItem> getApiData() {
        return this.apiData;
    }

    public final void setApiData(List<RatingItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.apiData = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MembersViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.rating_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MembersViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MembersViewHolder holder, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final RatingItem ratingItem = (RatingItem) CollectionsKt.getOrNull(this.itemsList, i);
        if (ratingItem == null) {
            ratingItem = (RatingItem) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        Iterator<T> it = this.qualityTypeList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((QualityType) obj).getId() == ratingItem.getQualityType()) {
                break;
            }
        }
        QualityType qualityType = (QualityType) obj;
        final RatingItemBinding binding = holder.getBinding();
        binding.number.setText(String.valueOf(ratingItem.getId()));
        binding.nick.setText(ratingItem.getSubName());
        binding.title.setText(ratingItem.getName());
        if (qualityType != null) {
            CustomCardView labelBg = binding.labelBg;
            Intrinsics.checkNotNullExpressionValue(labelBg, "labelBg");
            String str = (String) CollectionsKt.getOrNull(qualityType.getColors(), 0);
            if (str != null) {
                int parseColor = Color.parseColor(str);
                String str2 = (String) CollectionsKt.getOrNull(qualityType.getColors(), 1);
                if (str2 != null) {
                    CustomCardView.setBackground$default(labelBg, parseColor, Color.parseColor(str2), null, null, 12, null);
                    binding.labelText.setText(qualityType.getName() + " (" + ratingItem.getQualityValue() + ")");
                    CustomCardView bottomBg = binding.bottomBg;
                    Intrinsics.checkNotNullExpressionValue(bottomBg, "bottomBg");
                    String str3 = (String) CollectionsKt.getOrNull(qualityType.getColors(), 1);
                    if (str3 != null) {
                        CustomCardView.setBackground$default(bottomBg, Color.parseColor(str3), 0, null, null, 12, null);
                    }
                }
            }
        }
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemsAdapter.onBindViewHolder$lambda$1$1(ItemsAdapter.this, ratingItem, view);
            }
        });
        if (this.isCars) {
            if (UtilsKt.isArizonaType()) {
                ImageView image = binding.image;
                Intrinsics.checkNotNullExpressionValue(image, "image");
                Context context = binding.image.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                UtilsKt.setNotLoadedImage(image, context);
                binding.cardBg.setBackground(0);
                Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default("items", ratingItem.getImageIndex(), (String) null, 4, (Object) null);
                if (iconFromArchive$default != null) {
                    ImageView image2 = binding.image;
                    Intrinsics.checkNotNullExpressionValue(image2, "image");
                    UtilsKt.setImage(image2, iconFromArchive$default);
                }
            } else {
                Picasso.get().load(FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "/projects/rodina-rp/assets/images/inventory/vehicles/512/" + ratingItem.getImageIndex() + ".webp").into(binding.image);
            }
        } else {
            ImageView image3 = binding.image;
            Intrinsics.checkNotNullExpressionValue(image3, "image");
            Context context2 = binding.image.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            UtilsKt.setNotLoadedImage(image3, context2);
            binding.cardBg.setBackground(0);
            Bitmap iconFromArchive$default2 = UtilsKt.getIconFromArchive$default("items", ratingItem.getImageIndex(), (String) null, 4, (Object) null);
            if (iconFromArchive$default2 != null) {
                ImageView image4 = binding.image;
                Intrinsics.checkNotNullExpressionValue(image4, "image");
                UtilsKt.setImage(image4, iconFromArchive$default2);
                Palette.from(iconFromArchive$default2).generate(new Palette.PaletteAsyncListener() { // from class: ru.mrlargha.arizona.rating.ItemsAdapter$$ExternalSyntheticLambda1
                    @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
                    public final void onGenerated(Palette palette) {
                        ItemsAdapter.onBindViewHolder$lambda$1$3$0(RatingItemBinding.this, palette);
                    }
                });
            }
        }
        if (ratingItem.getImageType() == 2) {
            binding.image.setImageResource(FlagsKt.familyFlag(ratingItem.getImageIndex()));
        }
        if (i + 1 != this.itemsList.size() || this.isRequestSend || i <= 18) {
            return;
        }
        this.isRequestSend = true;
        int i2 = this.page + 1;
        this.page = i2;
        this.onScrollFinish.invoke(Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$1(ItemsAdapter itemsAdapter, RatingItem ratingItem, View view) {
        itemsAdapter.onClick.invoke(ratingItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$3$0(RatingItemBinding ratingItemBinding, Palette palette) {
        int dominantColor = palette != null ? palette.getDominantColor(0) : 0;
        CustomCardView cardBg = ratingItemBinding.cardBg;
        Intrinsics.checkNotNullExpressionValue(cardBg, "cardBg");
        CustomCardView.setBackground$default(cardBg, dominantColor, 0, null, null, 12, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<RatingItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.isRequestSend = false;
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ItemsAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final void setType(boolean z) {
        this.isCars = z;
    }

    public final void addBonus(List<BonusType> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.bonusType = data;
        notifyDataSetChanged();
    }

    public final void addQuality(List<QualityType> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.qualityTypeList = data;
        notifyDataSetChanged();
    }

    public final void clearList() {
        this.page = 1;
        this.isRequestSend = false;
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}
