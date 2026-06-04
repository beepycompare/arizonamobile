package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryCategoryItemBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.MobileRentAccessoryCategoryIcon;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryCategoryAdapter;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryCategoryModel;
/* compiled from: MobileRentAccessoryAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0017\u0018B*\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\t2\n\u0010\u0015\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000fH\u0016R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryCategoryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCategoryModel;", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryCategoryAdapter$CategoryViewHolder;", "selectCategory", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "category", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getSelectCategory", "()Lkotlin/jvm/functions/Function1;", "selectedCategory", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "CategoryViewHolder", "Companion", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryCategoryAdapter extends ListAdapter<MobileRentAccessoryCategoryModel, CategoryViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final MobileRentAccessoryCategoryAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<MobileRentAccessoryCategoryModel>() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryCategoryAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(MobileRentAccessoryCategoryModel oldItem, MobileRentAccessoryCategoryModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(MobileRentAccessoryCategoryModel oldItem, MobileRentAccessoryCategoryModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }
    };
    private final Function1<MobileRentAccessoryCategoryModel, Unit> selectCategory;
    private int selectedCategory;

    public final Function1<MobileRentAccessoryCategoryModel, Unit> getSelectCategory() {
        return this.selectCategory;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MobileRentAccessoryCategoryAdapter(Function1<? super MobileRentAccessoryCategoryModel, Unit> selectCategory) {
        super(diffUtilCallback);
        Intrinsics.checkNotNullParameter(selectCategory, "selectCategory");
        this.selectCategory = selectCategory;
        this.selectedCategory = -1;
    }

    /* compiled from: MobileRentAccessoryAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryCategoryAdapter$CategoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryCategoryItemBinding;", "<init>", "(Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryCategoryAdapter;Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryCategoryItemBinding;)V", "getBinding", "()Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryCategoryItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCategoryModel;", "position", "", "initCategory", "setupListeners", "category", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final MobileRentAccessoryCategoryItemBinding binding;
        final /* synthetic */ MobileRentAccessoryCategoryAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CategoryViewHolder(MobileRentAccessoryCategoryAdapter mobileRentAccessoryCategoryAdapter, MobileRentAccessoryCategoryItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = mobileRentAccessoryCategoryAdapter;
            this.binding = binding;
        }

        public final MobileRentAccessoryCategoryItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(MobileRentAccessoryCategoryModel model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            initCategory(model, i);
            setupListeners(model, i);
        }

        private final void initCategory(MobileRentAccessoryCategoryModel mobileRentAccessoryCategoryModel, int i) {
            Object obj;
            MobileRentAccessoryCategoryItemBinding mobileRentAccessoryCategoryItemBinding = this.binding;
            MobileRentAccessoryCategoryAdapter mobileRentAccessoryCategoryAdapter = this.this$0;
            mobileRentAccessoryCategoryItemBinding.tvName.setText(mobileRentAccessoryCategoryModel.getName());
            Iterator<E> it = MobileRentAccessoryCategoryIcon.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((MobileRentAccessoryCategoryIcon) obj).getId() == mobileRentAccessoryCategoryModel.getId()) {
                    break;
                }
            }
            MobileRentAccessoryCategoryIcon mobileRentAccessoryCategoryIcon = (MobileRentAccessoryCategoryIcon) obj;
            if (mobileRentAccessoryCategoryIcon != null) {
                mobileRentAccessoryCategoryItemBinding.ivIcon.setImageResource(mobileRentAccessoryCategoryIcon.getResId());
            }
            mobileRentAccessoryCategoryItemBinding.tvName.setTextColor(Color.parseColor(mobileRentAccessoryCategoryModel.getColor()));
            mobileRentAccessoryCategoryItemBinding.ivIcon.setImageTintList(ColorStateList.valueOf(Color.parseColor(mobileRentAccessoryCategoryModel.getColor())));
            CustomCardView container = mobileRentAccessoryCategoryItemBinding.container;
            Intrinsics.checkNotNullExpressionValue(container, "container");
            CustomCardView.setBackground$default(container, ColorUtils.setAlphaComponent(Color.parseColor(mobileRentAccessoryCategoryModel.getColorBG()), 50), 0, null, null, 12, null);
            CustomCardView container2 = mobileRentAccessoryCategoryItemBinding.container;
            Intrinsics.checkNotNullExpressionValue(container2, "container");
            CustomCardView.setBorder$default(container2, Color.parseColor(mobileRentAccessoryCategoryModel.getColorBG()), 0, null, 4, null);
            ImageView ivSelect = mobileRentAccessoryCategoryItemBinding.ivSelect;
            Intrinsics.checkNotNullExpressionValue(ivSelect, "ivSelect");
            ivSelect.setVisibility(mobileRentAccessoryCategoryAdapter.selectedCategory == i ? 0 : 8);
        }

        private final void setupListeners(final MobileRentAccessoryCategoryModel mobileRentAccessoryCategoryModel, final int i) {
            MobileRentAccessoryCategoryItemBinding mobileRentAccessoryCategoryItemBinding = this.binding;
            final MobileRentAccessoryCategoryAdapter mobileRentAccessoryCategoryAdapter = this.this$0;
            mobileRentAccessoryCategoryItemBinding.container.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryCategoryAdapter$CategoryViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileRentAccessoryCategoryAdapter.CategoryViewHolder.setupListeners$lambda$0$0(MobileRentAccessoryCategoryAdapter.this, i, mobileRentAccessoryCategoryModel, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$0$0(MobileRentAccessoryCategoryAdapter mobileRentAccessoryCategoryAdapter, int i, MobileRentAccessoryCategoryModel mobileRentAccessoryCategoryModel, View view) {
            if (mobileRentAccessoryCategoryAdapter.selectedCategory != i) {
                mobileRentAccessoryCategoryAdapter.notifyItemChanged(mobileRentAccessoryCategoryAdapter.selectedCategory);
                mobileRentAccessoryCategoryAdapter.notifyItemChanged(i);
                mobileRentAccessoryCategoryAdapter.selectedCategory = i;
                return;
            }
            mobileRentAccessoryCategoryAdapter.getSelectCategory().invoke(mobileRentAccessoryCategoryModel);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        MobileRentAccessoryCategoryItemBinding inflate = MobileRentAccessoryCategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new CategoryViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CategoryViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MobileRentAccessoryCategoryModel mobileRentAccessoryCategoryModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(mobileRentAccessoryCategoryModel, "get(...)");
        holder.onBind(mobileRentAccessoryCategoryModel, i);
    }

    /* compiled from: MobileRentAccessoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryCategoryAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryCategoryAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryCategoryAdapter$Companion$diffUtilCallback$1;", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
