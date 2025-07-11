package ru.mrlargha.commonui.elements.battlepassWinter2025.roulette;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.WinterBattlepassRouletteOldPriseItemBinding;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.OldPriseAdapter;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.data.OldPrise;
import ru.mrlargha.commonui.elements.battlepassWinter2025.utils.TimeConverterKt;
/* compiled from: OldPriseAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/OldPriseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/OldPriseAdapter$OldPriseViewHolder;", "<init>", "()V", "priseList", "", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/data/OldPrise;", "setPriseList", "", "list", "", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "OldPriseViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OldPriseAdapter extends RecyclerView.Adapter<OldPriseViewHolder> {
    private List<OldPrise> priseList = new ArrayList();

    public final void setPriseList(List<OldPrise> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.priseList = CollectionsKt.toMutableList((Collection) list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.priseList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OldPriseViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.winter_battlepass_roulette_old_prise_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new OldPriseViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(OldPriseViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.priseList.get(i));
    }

    /* compiled from: OldPriseAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/OldPriseAdapter$OldPriseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/WinterBattlepassRouletteOldPriseItemBinding;", "isClicked", "", "bind", "", "prise", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/data/OldPrise;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OldPriseViewHolder extends RecyclerView.ViewHolder {
        private final WinterBattlepassRouletteOldPriseItemBinding binding;
        private boolean isClicked;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OldPriseViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            WinterBattlepassRouletteOldPriseItemBinding bind = WinterBattlepassRouletteOldPriseItemBinding.bind(itemView);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final void bind(final OldPrise prise) {
            int i;
            String str;
            Intrinsics.checkNotNullParameter(prise, "prise");
            String style = prise.getStyle();
            switch (style.hashCode()) {
                case -976943172:
                    if (style.equals("purple")) {
                        i = R.drawable.rarity_purple;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                case 112785:
                    if (style.equals("red")) {
                        i = R.drawable.rarity_red;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                case 3002044:
                    if (style.equals("aqua")) {
                        i = R.drawable.rarity_aqua;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                case 3178592:
                    if (style.equals("gold")) {
                        i = R.drawable.rarity_gold;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                case 3441014:
                    if (style.equals("pink")) {
                        i = R.drawable.rarity_pink;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                default:
                    i = R.drawable.rarity_default;
                    break;
            }
            String style2 = prise.getStyle();
            switch (style2.hashCode()) {
                case -976943172:
                    if (style2.equals("purple")) {
                        str = "#6881FF";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                case 112785:
                    if (style2.equals("red")) {
                        str = "#FF3600";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                case 3002044:
                    if (style2.equals("aqua")) {
                        str = "#6FF5FF";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                case 3178592:
                    if (style2.equals("gold")) {
                        str = "#FFBA00";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                case 3441014:
                    if (style2.equals("pink")) {
                        str = "#E500FF";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                default:
                    str = "#FFFFFF";
                    break;
            }
            this.binding.priseTimeStamp.setText(TimeConverterKt.oldPriseTimeConvert(prise.getTime()));
            this.binding.oldPriseTitle.setText(prise.getTitle());
            this.binding.bg.setBackgroundResource(i);
            this.binding.rarity.setBackgroundColor(Color.parseColor(str));
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new OldPriseAdapter$OldPriseViewHolder$bind$1(this, prise, null), 3, null);
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.OldPriseAdapter$OldPriseViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OldPriseAdapter.OldPriseViewHolder.bind$lambda$0(OldPriseAdapter.OldPriseViewHolder.this, prise, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(OldPriseViewHolder oldPriseViewHolder, OldPrise oldPrise, View view) {
            if (oldPriseViewHolder.isClicked) {
                oldPriseViewHolder.binding.imagePrise.setImageBitmap(RoulettePrisesPicasso.INSTANCE.getBitmap(oldPrise.getImage()));
            } else {
                oldPriseViewHolder.binding.imagePrise.setImageResource(oldPrise.getId() == 1 ? R.drawable.winter_battlepass_old_item_prem : R.drawable.winter_battlepass_old_item_usual);
            }
            oldPriseViewHolder.isClicked = !oldPriseViewHolder.isClicked;
        }
    }
}
