package ru.mrlargha.commonui.elements.tuningAuto.presentation.viewHolder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemTuningCharacteristicBinding;
import ru.mrlargha.commonui.elements.tuningAuto.domain.CategoryComponents;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: CategoryComponentsViewHolder.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/presentation/viewHolder/CategoryComponentsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemTuningCharacteristicBinding;", "onItemClicked", "Lkotlin/Function2;", "Lru/mrlargha/commonui/elements/tuningAuto/domain/CategoryComponents;", "", "", "onCartClicked", "Lkotlin/Function1;", "context", "Landroid/content/Context;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemTuningCharacteristicBinding;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroid/content/Context;)V", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "item", "position", "selectedItemPosition", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategoryComponentsViewHolder extends RecyclerView.ViewHolder {
    private final ItemTuningCharacteristicBinding binding;
    private final Context context;
    private Job loadImageJob;
    private final Function1<CategoryComponents, Unit> onCartClicked;
    private final Function2<CategoryComponents, Integer, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CategoryComponentsViewHolder(ItemTuningCharacteristicBinding binding, Function2<? super CategoryComponents, ? super Integer, Unit> onItemClicked, Function1<? super CategoryComponents, Unit> onCartClicked, Context context) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(onCartClicked, "onCartClicked");
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
        this.onCartClicked = onCartClicked;
        this.context = context;
    }

    public final void bind(final CategoryComponents item, int i, int i2) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(item, "item");
        ItemTuningCharacteristicBinding itemTuningCharacteristicBinding = this.binding;
        Button btnCartTypes = itemTuningCharacteristicBinding.btnCartTypes;
        Intrinsics.checkNotNullExpressionValue(btnCartTypes, "btnCartTypes");
        btnCartTypes.setVisibility(i == i2 ? 0 : 8);
        if (item.getAvailable()) {
            if (item.getInstalled()) {
                Button btnCartTypes2 = itemTuningCharacteristicBinding.btnCartTypes;
                Intrinsics.checkNotNullExpressionValue(btnCartTypes2, "btnCartTypes");
                btnCartTypes2.setVisibility(8);
                itemTuningCharacteristicBinding.tvItemPrice.setTextColor(Color.parseColor("#237BFF"));
            } else if (!item.getInCart()) {
                itemTuningCharacteristicBinding.btnCartTypes.setText("Добавить в корзину");
                itemTuningCharacteristicBinding.btnCartTypes.setBackgroundTintList(ColorStateList.valueOf(this.context.getColor(R.color.green_type3)));
                itemTuningCharacteristicBinding.clickedBg.setBackgroundTintList(ColorStateList.valueOf(this.context.getColor(R.color.rodina_gray)));
                itemTuningCharacteristicBinding.btnCartTypes.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                itemTuningCharacteristicBinding.btnCartTypes.setText("Удалить из корзины");
                itemTuningCharacteristicBinding.btnCartTypes.setBackgroundTintList(ColorStateList.valueOf(this.context.getColor(R.color.grey_type6)));
                itemTuningCharacteristicBinding.btnCartTypes.setTextColor(-1);
                itemTuningCharacteristicBinding.clickedBg.setBackgroundTintList(ColorStateList.valueOf(this.context.getColor(R.color.green_type_transparent_90)));
            }
        } else {
            Button btnCartTypes3 = itemTuningCharacteristicBinding.btnCartTypes;
            Intrinsics.checkNotNullExpressionValue(btnCartTypes3, "btnCartTypes");
            btnCartTypes3.setVisibility(0);
            itemTuningCharacteristicBinding.btnCartTypes.setText("Добавить в корзину");
            itemTuningCharacteristicBinding.btnCartTypes.setClickable(false);
            itemTuningCharacteristicBinding.btnCartTypes.setBackgroundTintList(ColorStateList.valueOf(this.context.getColor(R.color.gray)));
            itemTuningCharacteristicBinding.tvItemPrice.setTextColor(Color.parseColor("#818181"));
        }
        Job job = this.loadImageJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CategoryComponentsViewHolder$bind$1$1(itemTuningCharacteristicBinding, this, item, null), 3, null);
        this.loadImageJob = launch$default;
        View clickedBg = itemTuningCharacteristicBinding.clickedBg;
        Intrinsics.checkNotNullExpressionValue(clickedBg, "clickedBg");
        clickedBg.setVisibility(i == i2 ? 0 : 8);
        itemTuningCharacteristicBinding.tvItemName.setText(item.getName());
        itemTuningCharacteristicBinding.tvItemPrice.setText(item.getStatusText());
        AppCompatTextView appCompatTextView = itemTuningCharacteristicBinding.tvItemPrice;
        Integer statusColor = item.getStatusColor();
        appCompatTextView.setTextColor(statusColor != null ? statusColor.intValue() : 0);
        AppCompatTextView tvItemType = itemTuningCharacteristicBinding.tvItemType;
        Intrinsics.checkNotNullExpressionValue(tvItemType, "tvItemType");
        tvItemType.setVisibility(StringsKt.isBlank(item.getHeader()) ? 8 : 0);
        itemTuningCharacteristicBinding.tvItemType.setText(item.getHeader());
        AppCompatTextView appCompatTextView2 = itemTuningCharacteristicBinding.tvItemType;
        Integer color = item.getColor();
        appCompatTextView2.setBackgroundTintList(ColorStateList.valueOf(UtilsKt.getColorTint(color != null ? color.intValue() : 0)));
        Integer color2 = item.getColor();
        if (color2 != null && color2.intValue() == -1) {
            itemTuningCharacteristicBinding.tvItemType.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        itemTuningCharacteristicBinding.mainView.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.viewHolder.CategoryComponentsViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryComponentsViewHolder.bind$lambda$2$lambda$0(CategoryComponentsViewHolder.this, item, view);
            }
        });
        itemTuningCharacteristicBinding.btnCartTypes.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.viewHolder.CategoryComponentsViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryComponentsViewHolder.bind$lambda$2$lambda$1(CategoryComponentsViewHolder.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2$lambda$0(CategoryComponentsViewHolder categoryComponentsViewHolder, CategoryComponents categoryComponents, View view) {
        categoryComponentsViewHolder.onItemClicked.invoke(categoryComponents, Integer.valueOf(categoryComponentsViewHolder.getAdapterPosition()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2$lambda$1(CategoryComponentsViewHolder categoryComponentsViewHolder, CategoryComponents categoryComponents, View view) {
        categoryComponentsViewHolder.onCartClicked.invoke(categoryComponents);
    }
}
